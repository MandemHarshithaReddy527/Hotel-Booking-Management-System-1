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

import com.cg.hbm.entites.Hotel;
import com.cg.hbm.exceptions.HotelNotFoundException;
import com.cg.hbm.service.IHotelService;

import io.swagger.annotations.Api;
/**
 * 
 * @author Harshitha
 *
 */
@Api(value="Swagger2DemoRestController")
@RestController
@RequestMapping("/hotel")
public class HotelController {
	@Autowired
	IHotelService hService;
	/**
	 * 
	 * @param hotel
	 * @return 
	 * @throws HotelNotFoundException
	 */
	
	@PostMapping
	public ResponseEntity<Hotel> addHotel(@RequestBody Hotel hotel) throws HotelNotFoundException  {
		Hotel resulthotel=hService.addHotel(hotel);
		return new ResponseEntity<Hotel>(resulthotel,HttpStatus.OK) ;
	}
	@DeleteMapping("/{id}")
	public Hotel removeHotel(@PathVariable int id) throws HotelNotFoundException {
		return hService.removeHotel(id);
	}
	@PutMapping("/{id}")
	public ResponseEntity<Hotel> updateHotel(@PathVariable int id,@RequestBody Hotel hotel) throws HotelNotFoundException {
		hotel.setHotel_id(id);
		return ResponseEntity.ok().body(this.hService.updateHotel(hotel));
	}
	@GetMapping
	public ResponseEntity<List<Hotel>> showAllHotels() throws HotelNotFoundException{
		List<Hotel> resultHotel=hService.showAllHotels();
		return new ResponseEntity<List<Hotel>>(resultHotel, HttpStatus.OK);
	}
	@GetMapping("/{id}")
	public ResponseEntity<Hotel>showHotel(@PathVariable int id) throws HotelNotFoundException {
		Hotel h=hService.showHotel(id);
		if(h!=null) {
			return new ResponseEntity<Hotel>(h,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<Hotel>(HttpStatus.NOT_FOUND);
		}
		
	}

}
	
	
/*
 * import java.util.List;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.http.ResponseEntity; import
 * org.springframework.web.bind.annotation.DeleteMapping; import
 * org.springframework.web.bind.annotation.GetMapping; import
 * org.springframework.web.bind.annotation.PathVariable; import
 * org.springframework.web.bind.annotation.PostMapping; import
 * org.springframework.web.bind.annotation.PutMapping; import
 * org.springframework.web.bind.annotation.RequestBody; import
 * org.springframework.web.bind.annotation.RequestMapping; import
 * org.springframework.web.bind.annotation.RestController;
 * 
 * 
 * @RestController
 * 
 * @RequestMapping("/api/users") public class UserController {
 * 
 * @Autowired private Service userRepository;
 * 
 * // get all users
 * 
 * @GetMapping public List<Hotel> getAllUsers() { return
 * this.userRepositoryc.findAll(); }
 * 
 * // get user by id
 * 
 * @GetMapping("/{id}") public User getUserById(@PathVariable (value = "id")
 * long userId) { return this.userRepository.findById(userId) .orElseThrow(() ->
 * new ResourceNotFoundException("User not found with id :" + userId)); }
 * 
 * // create user
 * 
 * @PostMapping public User createUser(@RequestBody User user) { return
 * this.userRepository.save(user); }
 * 
 * // update user
 * 
 * @PutMapping("/{id}") public User updateUser(@RequestBody User
 * user, @PathVariable ("id") long userId) { User existingUser =
 * this.userRepository.findById(userId) .orElseThrow(() -> new
 * ResourceNotFoundException("User not found with id :" + userId));
 * existingUser.setFirstName(user.getFirstName());
 * existingUser.setLastName(user.getLastName());
 * existingUser.setEmail(user.getEmail()); return
 * this.userRepository.save(existingUser); }
 * 
 * // delete user by id
 * 
 * @DeleteMapping("/{id}") public ResponseEntity<User> deleteUser(@PathVariable
 * ("id") long userId){ User existingUser = this.userRepository.findById(userId)
 * .orElseThrow(() -> new ResourceNotFoundException("User not found with id :" +
 * userId)); this.userRepository.delete(existingUser); return
 * ResponseEntity.ok().build(); } }
 */
