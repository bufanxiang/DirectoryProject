package com.bufx.main;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import com.bufx.obj.DirectoryBook;
import com.bufx.obj.DirectoryEntiry;
import com.bufx.util.DirectoryUtils;

public class Test {
	
	public static void main(String[] args) throws Exception {
		System.out.println("请输入csv文件的路径：");
		String filePath = getConsole();
		DirectoryUtils directoryUtils = new DirectoryUtils();
		DirectoryBook directoryBook = directoryUtils.initDirectoryBook(filePath);
		
		
		System.out.println("下面有三种操作：");
		System.out.println("1.根据姓名查电话；");
		System.out.println("2.根据电话查姓名；");
		System.out.println("3.根据姓名查电话，并输出电话对应姓名最多的所有姓名。");
		System.out.println("请输入相应输入并回车：");
		String temp = getConsole();
		
		while(!("1".equals(temp.trim()) || "2".equals(temp.trim()) || "3".equals(temp.trim())))
		{
			System.out.println("您输入的不正确，请重新输入！");
			temp = getConsole();
		}
		
		switch (temp) {
		case "1":
			System.out.println("请输入姓名：");
			String name = getConsole();
			List<DirectoryEntiry> directoryEntiryListByName = directoryUtils.search(name.trim(), directoryBook, "searchPhoneNumberByName");
			if(directoryEntiryListByName == null ||directoryEntiryListByName.size() == 0)
				System.out.println("没有对应的电话号码！");
			else
			{
				System.out.println("对应的电话号码为：");
				for (DirectoryEntiry directoryEntiry : directoryEntiryListByName) {
					System.out.println(directoryEntiry.getPhoneNumber());
				}
			}
			break;
			
		case "2":
			System.out.println("请输入电话号码：");
			String phoneNumber = getConsole();
			List<DirectoryEntiry> directoryEntiryListByPhoneNumber = directoryUtils.search(phoneNumber.trim(), directoryBook, "searchNameByPhoneNumber");
			if(directoryEntiryListByPhoneNumber == null || directoryEntiryListByPhoneNumber.size() == 0)
				System.out.println("没有对应的姓名！");
			else
			{
				System.out.println("对应的姓名为：");
				for (DirectoryEntiry directoryEntiry : directoryEntiryListByPhoneNumber) {
					System.out.println(directoryEntiry.getName());
				}
			}
			break;

		default:
			break;
		}
	}
	
	private static String getConsole() throws Exception
	{
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		return br.readLine();
	}
}
