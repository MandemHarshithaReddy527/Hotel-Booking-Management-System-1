package com.cg.hbm.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.hbm.entites.RoomDetails;
import com.cg.hbm.exceptions.UserNotFoundException;
import com.cg.hbm.service.IRoomDetailsService;

@RestController
@RequestMapping("/roomdetails")
public class RoomDetailsController {
	
	@Autowired
	IRoomDetailsService rdService;
	
	@PostMapping
	public List<RoomDetails> addRoomDetails(@RequestBody RoomDetails roomDetails) {
		return rdService.addRoomDetails(roomDetails);
		
	}

	@PutMapping
	public RoomDetails updateRoomDetails(@RequestBody RoomDetails roomDetails) {
		
		return rdService.updateRoomDetails(roomDetails);
	}

	@DeleteMapping("/{room_id}")
	public List<RoomDetails> removeRoomDetails(@PathVariable int room_id) {
		return rdService.removeRoomDetails(room_id);
	}

	@GetMapping
	public List<RoomDetails> showAllRoomDetails() {
		
		return rdService.showAllRoomDetails();
	}

	@GetMapping("/{room_id}")
	public ResponseEntity<RoomDetails> viewUser(@PathVariable("room_id")int userid) throws UserNotFoundException {
		RoomDetails rd =  rdService.showRoomDetails(userid);
		if(rd!=null) {
			return new ResponseEntity<RoomDetails>(rd,HttpStatus.OK);
		}
		else {
			return  new ResponseEntity<RoomDetails>(HttpStatus.NOT_FOUND);
		}
	}

}
