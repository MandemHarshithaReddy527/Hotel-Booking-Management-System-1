package com.cg.hbm.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.hbm.entites.RoomDetails;

@Repository
public interface IRoomDetailsRepository extends JpaRepository<RoomDetails,Integer >{

	
	
}