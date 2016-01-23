package com.bufx.obj;

import java.util.List;
import java.util.Map;

public class DirectoryBook {

	private Map<String, List<DirectoryEntiry>> directoryListIndexByName;
	private Map<String, List<DirectoryEntiry>> directoryListIndexByPhoneNumber;
	
	public DirectoryBook() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DirectoryBook(
			Map<String, List<DirectoryEntiry>> directoryListIndexByName,
			Map<String, List<DirectoryEntiry>> directoryListIndexByPhoneNumber) {
		super();
		this.directoryListIndexByName = directoryListIndexByName;
		this.directoryListIndexByPhoneNumber = directoryListIndexByPhoneNumber;
	}
	public Map<String, List<DirectoryEntiry>> getDirectoryListIndexByName() {
		return directoryListIndexByName;
	}
	public void setDirectoryListIndexByName(
			Map<String, List<DirectoryEntiry>> directoryListIndexByName) {
		this.directoryListIndexByName = directoryListIndexByName;
	}
	public Map<String, List<DirectoryEntiry>> getDirectoryListIndexByPhoneNumber() {
		return directoryListIndexByPhoneNumber;
	}
	public void setDirectoryListIndexByPhoneNumber(
			Map<String, List<DirectoryEntiry>> directoryListIndexByPhoneNumber) {
		this.directoryListIndexByPhoneNumber = directoryListIndexByPhoneNumber;
	}
	
	
}
