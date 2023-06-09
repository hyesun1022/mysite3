package com.javaex.vo;

public class GalleryVo {
	
	private int no;
	private String content;
	private String filePath;
	private String orgName;
	private String saveName;
	private long fileSize;
	private int userno;
	private String username;
	
	
	public GalleryVo() {
		
	}
	
	public GalleryVo(String content, String filePath, String orgName, String saveName, long fileSize, int userno) {
		
		this.content = content;
		this.filePath = filePath;
		this.orgName = orgName;
		this.saveName = saveName;
		this.fileSize = fileSize;
		this.userno = userno;
	}


	public GalleryVo(int no, String content, String filePath, String orgName, String saveName, long fileSize, int userno,
			String username) {
		
		this.no = no;
		this.content = content;
		this.filePath = filePath;
		this.orgName = orgName;
		this.saveName = saveName;
		this.fileSize = fileSize;
		this.userno = userno;
		this.username = username;
	}


	public int getNo() {
		return no;
	}


	public void setNo(int no) {
		this.no = no;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public String getFilePath() {
		return filePath;
	}


	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}


	public String getOrgName() {
		return orgName;
	}


	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}


	public String getSaveName() {
		return saveName;
	}


	public void setSaveName(String saveName) {
		this.saveName = saveName;
	}


	public long getFileSize() {
		return fileSize;
	}


	public void setFileSize(int fileSize) {
		this.fileSize = fileSize;
	}


	public int getUserno() {
		return userno;
	}


	public void setUserno(int userno) {
		this.userno = userno;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	@Override
	public String toString() {
		return "GalleryVo [no=" + no + ", content=" + content + ", filePath=" + filePath + ", orgName=" + orgName
				+ ", saveName=" + saveName + ", fileSize=" + fileSize + ", userno=" + userno + ", username=" + username
				+ "]";
	}
	
	
	
	
	

}
