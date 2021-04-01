package com.cg.hbm.service;

import java.util.List;

import java.util.Optional;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.hbm.dao.IHotelRepository;
import com.cg.hbm.entites.Hotel;
import com.cg.hbm.exceptions.HotelNotFoundException;
/**
 * 
 * @author Harshitha
 *
 */
@Service
@Transactional
public class IHotelServiceImpl implements IHotelService {
	@Autowired
	IHotelRepository hDao;
	@Override
	public Hotel addHotel(Hotel hotel) throws HotelNotFoundException{
		Optional<Hotel> h = hDao.findById(hotel.getHotel_id());
		if (h.isEmpty()) {
			return hDao.saveAndFlush(hotel);
		} else {
			throw new HotelNotFoundException("Hotel already exists");
		}
	}

	@Override
	public Hotel updateHotel(Hotel hotel) throws HotelNotFoundException {
		Optional<Hotel> op=this.hDao.findById(hotel.getHotel_id());
		if(op.isPresent()) {
			Hotel hotelUpdate=op.get();
			hotelUpdate.setHotel_id(hotel.getHotel_id());
			hotelUpdate.setHotel_name(hotel.getHotel_name());
			hotelUpdate.setCity(hotel.getCity());
			hotelUpdate.setDescription(hotel.getDescription());
			hotelUpdate.setEmail(hotel.getEmail());
			hotelUpdate.setPhone1(hotel.getPhone1());
			hotelUpdate.setPhone2(hotel.getPhone2());
			hotelUpdate.setAddress(hotel.getAddress());
			hotelUpdate.setAvg_rate_per_day(hotel.getAvg_rate_per_day());
			hotelUpdate.setWebsite(hotel.getWebsite());
			return hotelUpdate;
			
			
		}
		else {
			throw new HotelNotFoundException("Hotel not found with id :"+hotel.getHotel_id());
		}
		
	}

	@Override
	public Hotel removeHotel(int hotel_id) throws HotelNotFoundException{
			Optional<Hotel> op=hDao.findById(hotel_id);
			if(op.isPresent()) {
				hDao.deleteById(hotel_id);
				return op.get();
			}
			else throw new HotelNotFoundException("Hotel with given Id doesn't exist.");
			
	}
	
    @Override
	public List<Hotel> showAllHotels() throws HotelNotFoundException{
    	List<Hotel> h = hDao.findAll();
		if (h.isEmpty()) {
			throw new HotelNotFoundException("Hotel not found");
		}
		return h;
	}


	

	@Override
	public Hotel showHotel(int hotel_id) throws HotelNotFoundException{
		
		  /*if(hDao.findById(hotel_id).isPresent()) {
		  
		  return hDao.findById(hotel_id).get();
		  
		 } 
		  else 
			  return null;
			 // throw new HotelNotFoundException(" Hotel not found with such HotelID..!" );
		  }*/
		
		Optional<Hotel> h=hDao.findById(hotel_id);
		if(h.isEmpty()) {
			throw new HotelNotFoundException("Given HotelId does not exist");
		}
		return h.get();
			
		
		
		 
		}

		 
	
	}
	

	
