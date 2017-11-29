package com.bean;

import java.util.Date;

public class Room {
	
	int roomId;
	String roomName;	
	Date dateCreated;
	
	public int getRoomId() {
		return roomId;
	}
	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}
	public String getRoomName() {
		return roomName;
	}
	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}
	public Date getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}
	
	@Override
	public String toString() {
		return "Room [roomId=" + roomId + ", roomName=" + roomName + ", dateCreated=" + dateCreated + "]";
	}
	
	

}
