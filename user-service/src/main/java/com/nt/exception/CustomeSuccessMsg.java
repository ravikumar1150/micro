package com.nt.exception;

import java.time.LocalDateTime;

public class CustomeSuccessMsg {
	
	private String  message;
	
	private LocalDateTime  localTimeDate;
	
	private int count;

	public CustomeSuccessMsg(String message, LocalDateTime localTimeDate, int count) {
		super();
		this.message = message;
		this.localTimeDate = localTimeDate;
		this.count = count;
	}
	

	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public LocalDateTime getLocalTimeDate() {
		return localTimeDate;
	}


	public void setLocalTimeDate(LocalDateTime localTimeDate) {
		this.localTimeDate = localTimeDate;
	}


	public int getCount() {
		return count;
	}


	public void setCount(int count) {
		this.count = count;
	}


	@Override
	public String toString() {
		return "CustomeSuccessMsg [count=" + count + ", localTimeDate=" + localTimeDate + ", message=" + message + "]";
	}
	
	

}
