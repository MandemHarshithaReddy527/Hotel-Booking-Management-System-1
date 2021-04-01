package com.cg.hbm.service;

import java.util.List;


import com.cg.hbm.entites.BookingDetails;
import com.cg.hbm.exceptions.BookingDetailsNotFoundException;
/**
 * 
 * @author Harshitha
 *
 */
public interface IBookingDetailsService {
	/**
	 * 
	 * @param bookingdetails
	 * @return int
	 * @throws BookingDetailsNotFoundException
	 */
	public BookingDetails addBookingDetails(BookingDetails bookingdetails) throws BookingDetailsNotFoundException;
	public BookingDetails updateBookingDetails(BookingDetails bookingdetails) throws BookingDetailsNotFoundException;
	public List<BookingDetails> showAllBookingDetails()throws BookingDetailsNotFoundException;
	public BookingDetails removeBookingDetails(int id)throws BookingDetailsNotFoundException;
	public BookingDetails showBookingDetails(int id)throws BookingDetailsNotFoundException;
}
