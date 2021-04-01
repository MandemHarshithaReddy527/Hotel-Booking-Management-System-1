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

import com.cg.hbm.entites.BookingDetails;

import com.cg.hbm.exceptions.BookingDetailsNotFoundException;
import com.cg.hbm.service.IBookingDetailsService;

import io.swagger.annotations.Api;
@RestController
@RequestMapping("/bookingdetails")
@Api(value="Swagger2DemoRestController")
/**
 * 
 * @author Harshitha
 *
 */
public class BookingDetailsController {
	
	@Autowired
	IBookingDetailsService bService;
	
	
	@PostMapping
	public ResponseEntity<BookingDetails> addBookingDetails(@RequestBody BookingDetails bookingdetails) throws Exception {
		BookingDetails resultBookingDetails=bService.addBookingDetails(bookingdetails);
		return new ResponseEntity<BookingDetails>(resultBookingDetails,HttpStatus.OK) ;
	}
	@DeleteMapping("/{id}")
	public BookingDetails removeBookingDetails(@PathVariable int id)throws BookingDetailsNotFoundException {
		return bService.removeBookingDetails(id);
	}
	@PutMapping
	public ResponseEntity<BookingDetails> updateBookingDetails(@PathVariable int id,@RequestBody BookingDetails bookingdetails) throws BookingDetailsNotFoundException {
		bookingdetails.setBooking_id(id);
		return ResponseEntity.ok().body(this.bService.updateBookingDetails(bookingdetails));
	}
	@GetMapping("/all")
	public ResponseEntity<List<BookingDetails>>showAllBookingDetails() throws BookingDetailsNotFoundException{
		List<BookingDetails> resultBookingDetails=bService.showAllBookingDetails();
		return new ResponseEntity<List<BookingDetails>>(resultBookingDetails, HttpStatus.OK);
	}
	@GetMapping("/{id}")
	public ResponseEntity<BookingDetails>showBookingDetails(@PathVariable int id) throws BookingDetailsNotFoundException {
		BookingDetails b=bService.showBookingDetails(id);
		if(b!=null) {
			return new ResponseEntity<BookingDetails>(b,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<BookingDetails>(HttpStatus.NOT_FOUND);
		}
		
	}
}
