package com.cg.hbm.entites;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
/**
 * 
 * @author Harshitha
 *
 */

@Entity
@Table(name = "bookingdetails")
public class BookingDetails {
	@Id
	//@GeneratedValue(strategy=GenerationType.AUTO)
	private int booking_id;
	private Date booked_from;
	private Date booked_to;
	private int no_of_adults;
	private int no_of_children;
	private double amount;

	@ManyToOne
	@JoinColumn(name = "user_id", referencedColumnName = "user_id", insertable = false, updatable = false)
	//@JoinColumn(name="user_id")
	private User user;

	@ManyToOne
	@JoinColumn(name = "hotel_id", referencedColumnName = "hotel_id", insertable = false, updatable = false)
	//@JoinColumn(name="hotel_id")
	private Hotel hotel;
	
	@OneToOne
	@JoinColumn(name = "room_id", referencedColumnName = "room_id", insertable = false, updatable = false)
	//@JoinColumn(name="room_id")
	private RoomDetails roomdetails;
	/**
	 * Default Constructor
	 */
	public BookingDetails() {
		
	}
	/**
	 * 
	 * @param booked_from
	 * @param booked_to
	 * @param no_of_adults
	 * @param no_of_children
	 * @param amount
	 * @param hotel
	 * @param roomdetails
	 * @param user
	 */
	

	
	public BookingDetails(int booking_id,Date booked_from, Date booked_to, int no_of_adults, int no_of_children,
			double amount, Hotel hotel , RoomDetails roomdetails, User user) {
		super();
		this.booking_id=booking_id;
		this.booked_from = booked_from;
		this.booked_to = booked_to;
		this.no_of_adults = no_of_adults;
		this.no_of_children = no_of_children;
		this.amount = amount;
		this.hotel = hotel;
		this.roomdetails = roomdetails;
		this.user = user;
	}


	
	/**
	 * 
	 * @return int
	 */


	public int getBooking_id() {
		return booking_id;
	}

	public void setBooking_id(int booking_id) {
		this.booking_id = booking_id;
	}

	/**
	 * 
	 * @return Date
	 */
	public Date getBooked_from() {
		return booked_from;
	}

	public void setBooked_from(Date booked_from) {
		this.booked_from = booked_from;
	}
	/**
	 * 
	 * @return Date
	 */

	public Date getBooked_to() {
		return booked_to;
	}

	public void setBooked_to(Date booked_to) {
		this.booked_to = booked_to;
	}
	/**
	 * 
	 * @return int
	 */

	public int getNo_of_adults() {
		return no_of_adults;
	}

	public void setNo_of_adults(int no_of_adults) {
		this.no_of_adults = no_of_adults;
	}
	/**
	 * 
	 * @return int
	 */
	

	public int getNo_of_children() {
		return no_of_children;
	}

	public void setNo_of_children(int no_of_children) {
		this.no_of_children = no_of_children;
	}
	/**
	 * 
	 * @return double
	 */
	
	  
	 public double getAmount() { 
		 return amount;
	 } 
	 public void setAmount(double amount) { 
		 this.amount = amount;
	 }
	 /**
	  * 
	  * @return hotel
	  */
	 
	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}
	/**
	 * 
	 * @return roomDetails
	 */

	public RoomDetails getRoomdetails() {
		return roomdetails;
	}

	public void setRoomdetails(RoomDetails roomdetails) {
		this.roomdetails = roomdetails;
	}
	/**
	 * 
	 * @return user
	 */

	
	 public User getUser() { 
		 return user; 
	 } 
	 public void setUser(User user) {
	 this.user = user;
	 }
	 

}
