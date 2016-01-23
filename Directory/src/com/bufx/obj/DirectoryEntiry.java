package com.bufx.obj;

public class DirectoryEntiry {

	private String name;
	private String phoneNumber;
	
	public DirectoryEntiry(String name, String phoneNumber) {
		if(name == null)
			name = "";
		if(phoneNumber == null)
			phoneNumber = "";
		
		this.name = name;
		this.phoneNumber = phoneNumber;
	}
	public DirectoryEntiry() {
		this.name="";
		this.phoneNumber = "";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	/*
	 * 重写equals方法
	 */
	public boolean equals(Object obj)
	{
		if(!(obj instanceof DirectoryEntiry))
			return false;
		DirectoryEntiry de = (DirectoryEntiry) obj;
		if(this.name.equals(de.getName()) && this.phoneNumber.equals(de.getPhoneNumber()))
			return true;
		else
			return false;
	}
	
	public int hashCode()
	{
		return (this.name + this.phoneNumber).hashCode();
	}
}
