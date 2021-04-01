package com.cg.hbm.service;

import java.util.List;

import com.cg.hbm.entites.RoomDetails;

public interface IRoomDetailsService {
	public List<RoomDetails> addRoomDetails(RoomDetails roomDetails);
	public RoomDetails updateRoomDetails(RoomDetails roomDetails);
	public List<RoomDetails> removeRoomDetails(int room_id);
	public List<RoomDetails> showAllRoomDetails();
	public RoomDetails showRoomDetails(int id);
}

//List<RoomDetails> updateRoomDetails(RoomDetails roomDetails)
// List<RoomDetails> removeRoomDetails(Integer room_id)
//c User showRoomDetails(Integer room_id)