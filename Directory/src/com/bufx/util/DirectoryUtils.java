package com.bufx.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bufx.obj.DirectoryBook;
import com.bufx.obj.DirectoryEntiry;

public class DirectoryUtils {

	public DirectoryBook initDirectoryBook(String filePath) throws Exception
	{
		Map<String, List<DirectoryEntiry>> mapIndexByName = new HashMap<String, List<DirectoryEntiry>>();
		Map<String, List<DirectoryEntiry>> mapIndexByPhoneNumber = new HashMap<String, List<DirectoryEntiry>>();
		
		if(filePath == null || "".equals(filePath))
			return null;
		
		filePath = filePath.replace("\\", "\\\\");
		File file = new File(filePath);
		if(!file.exists())//判断是否存在
			return null;
		if(!file.isFile())//判断是否是文件夹
			return null;
		
		FileInputStream fis = new FileInputStream(file);
		InputStreamReader isr = new InputStreamReader(fis, "utf-8");
		BufferedReader br = new BufferedReader(isr);
		
		String tempStr = null;
		while((tempStr = br.readLine()) != null)
		{
			String[] entry = tempStr.split(",");
			//舍弃超过三列的行
			if(entry.length > 2)
				continue;
			String name = entry[0];
			String phoneNumber = entry[1];
			
			DirectoryEntiry directoryEntiry = new DirectoryEntiry(name, phoneNumber);
			if(!mapIndexByName.containsKey(name))
			{
				List<DirectoryEntiry> listIndexByName = new ArrayList<DirectoryEntiry>();
				listIndexByName.add(directoryEntiry);
				mapIndexByName.put(name, listIndexByName);
			}
			else
			{
				if(mapIndexByName.get(name).contains(directoryEntiry))
					continue;
				else
					mapIndexByName.get(name).add(directoryEntiry);
			}
			if(!mapIndexByPhoneNumber.containsKey(phoneNumber))
			{
				List<DirectoryEntiry> listIndexByPhoneNumber = new ArrayList<DirectoryEntiry>();
				listIndexByPhoneNumber.add(directoryEntiry);
				mapIndexByPhoneNumber.put(phoneNumber, listIndexByPhoneNumber);
			}
			else
			{
				if(mapIndexByPhoneNumber.get(phoneNumber).contains(directoryEntiry))
					continue;
				else
					mapIndexByPhoneNumber.get(phoneNumber).add(directoryEntiry);
			}
		}
		br.close();
		DirectoryBook directoryBook = new DirectoryBook(mapIndexByName, mapIndexByPhoneNumber);
		return directoryBook;
	}
	
	public List<DirectoryEntiry> search(String param, DirectoryBook directoryBook, String temp)
	{
		List<DirectoryEntiry> directoryEntiryList = new ArrayList<DirectoryEntiry>();
		switch (temp) {
		case "searchPhoneNumberByName":
			if(directoryBook.getDirectoryListIndexByName().containsKey(param))
				directoryEntiryList = directoryBook.getDirectoryListIndexByName().get(param);
			break;
		case "searchNameByPhoneNumber":
			if(directoryBook.getDirectoryListIndexByPhoneNumber().containsKey(param))
				directoryEntiryList = directoryBook.getDirectoryListIndexByPhoneNumber().get(param);
			break;
		default:
			break;
		}
		return directoryEntiryList;
	}
}
