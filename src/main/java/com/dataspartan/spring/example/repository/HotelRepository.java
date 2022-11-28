package com.dataspartan.spring.example.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.dataspartan.spring.example.model.Hotel;

@Component
public class HotelRepository {
	Map<Long,Hotel> hotels = new HashMap<Long,Hotel>();
	
	public List<Hotel> findAll(){
		return new ArrayList(hotels.values());
	}
	
	public List<Hotel> findByStars(int stars){
		List<Hotel> tempList = new ArrayList<Hotel>();
		for(Hotel hotel : this.hotels.values()) {
			if(hotel.getStars()==stars) {
				tempList.add(hotel);
			}
		}
		return tempList;
	}
	
	public List<Hotel> findByNameContaining(String name){
		List<Hotel> tempList = new ArrayList<Hotel>();
		for(Hotel hotel : this.hotels.values()) {
			if(hotel.getName().contains(name)) {
				tempList.add(hotel);
			}
		}
		return tempList;
	}
	
	public Optional<Hotel> findById(Long id) {
		return Optional.of(this.hotels.get(id));
	}
	
	public void deleteById(Long id) {
		this.hotels.remove(id);
	}
	
	public void deleteAll() {
		this.hotels.clear();
	}
	
	public Hotel save(Hotel hotel) {
		Long id =Long.valueOf(this.hotels.keySet().size()) +1;
		hotel.setId(id);
		this.hotels.put(id, hotel);
		return hotel;
	}
}
