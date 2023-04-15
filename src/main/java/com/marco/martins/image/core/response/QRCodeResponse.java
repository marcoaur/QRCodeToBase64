package com.marco.martins.image.core.response;

public class QRCodeResponse {
	
	private String base64;
	private String content;
	
	public QRCodeResponse() {
	}
	
	public QRCodeResponse(String base64, String content) {
		this.base64 = base64;
		this.content = content;
	}
	
	public void setBase64(String base64) {
		this.base64 = base64;
	}
	public void setContent(String content) {
		this.content = content;
	}

	public String getBase64() {
		return base64;
	}
	public String getContent() {
		return content;
	}
	
	
	

}
