package com.cg.hbm.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.hbm.entites.BookingDetails;

@Repository
public interface IBookingDetailsRepository extends JpaRepository<BookingDetails, Integer> {
	
	/*
	public BookingDetails addBookingDetails(BookingDetails bookingDetails);
	public BookingDetails updateBookingDetails(BookingDetails bookingDetails);
	public BookingDetails removeBookingDetails(BookingDetails bookingDetails);
	public List<BookingDetails> showAllBookingDetails();
	public BookingDetails showBookingDetails(BookingDetails bookingDetails);
	*/
	
}
