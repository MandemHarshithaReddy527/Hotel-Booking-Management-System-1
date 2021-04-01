package com.cg.hbm.service;
import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.hbm.dao.IBookingDetailsRepository;
import com.cg.hbm.entites.BookingDetails;
import com.cg.hbm.exceptions.BookingDetailsNotFoundException;

/**
 * 
 * @author Harshitha
 *
 */
@Service
public class IBookingDetailsServiceImpl implements IBookingDetailsService {

	
	@Autowired
	IBookingDetailsRepository bDao;
	
	@Override
	public BookingDetails addBookingDetails(BookingDetails bookingdetails) throws BookingDetailsNotFoundException {
		/*
		 * if(bDao.existsById(bookingdetails.getBooking_id())){ throw new
		 * BookingDetailsNotFoundException("BookingDetails with given Id already exists."
		 * ); } else bDao.saveAndFlush(bookingdetails); return bookingdetails;
		 */
		Optional<BookingDetails> b = bDao.findById(bookingdetails.getBooking_id());
		if (b.isEmpty()) {
			return bDao.saveAndFlush(bookingdetails);
		} else {
			throw new BookingDetailsNotFoundException("Hotel already exists");
		}
	}

	@Override
	public BookingDetails updateBookingDetails(BookingDetails bookingdetails)throws BookingDetailsNotFoundException {
		
		Optional<BookingDetails> op=this.bDao.findById(bookingdetails.getBooking_id());
		if(op.isPresent()) {
			BookingDetails bookingdetailsUpdate=op.get();
			bookingdetailsUpdate.setBooking_id(bookingdetails.getBooking_id());
			bookingdetailsUpdate.setBooked_from(bookingdetails.getBooked_from());
			bookingdetailsUpdate.setBooked_to(bookingdetails.getBooked_to());
			bookingdetailsUpdate.setAmount(bookingdetails.getAmount());
			bookingdetailsUpdate.setNo_of_adults(bookingdetails.getNo_of_adults());
			bookingdetailsUpdate.setNo_of_children(bookingdetails.getNo_of_children());
			bookingdetailsUpdate.setHotel(bookingdetails.getHotel());
			bookingdetailsUpdate.setRoomdetails(bookingdetails.getRoomdetails());
			bookingdetailsUpdate.setUser(bookingdetails.getUser());
			return bookingdetailsUpdate;
			
			
		}
		else {
			throw new BookingDetailsNotFoundException("BookingDetails not found with id :"+bookingdetails.getBooking_id());
		}
	}

	@Override
	public List<BookingDetails> showAllBookingDetails() throws BookingDetailsNotFoundException {
		List<BookingDetails> boo = bDao.findAll();
		if (boo.isEmpty()) {
			throw new BookingDetailsNotFoundException("BookingDetails not found");
		}
		return boo;
	}

	@Override
	public BookingDetails showBookingDetails(int id) throws BookingDetailsNotFoundException {
		if(bDao.findById(id).isPresent()) {
			return bDao.findById(id).get();
		}
		else {
			throw new BookingDetailsNotFoundException("Booking Id not found!");
		}
	}

	@Override
	public BookingDetails removeBookingDetails(int id) throws BookingDetailsNotFoundException {
		
		Optional<BookingDetails> op=bDao.findById(id);
		if(op.isPresent()) {
			bDao.deleteById(id);
			return op.get();
		}
		else throw new BookingDetailsNotFoundException("BookingDetails with given Id doesn't exist.");
	}
}
