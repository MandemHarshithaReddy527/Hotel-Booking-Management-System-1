package com.cg.hbm.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cg.hbm.entites.Hotel;
@Repository
public interface IHotelRepository extends JpaRepository<Hotel,Integer>{


	
	/*
	
	public Hotel addHotel(Hotel hotel);
	public Hotel updateHotel(Hotel hotel);
	public Hotel removeHotel(Hotel hotel);
	public List<Hotel> showAllHotels();
	public Hotel showHotel(Hotel id);
	
	*/
	
}
