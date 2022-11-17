package com.dataspartan.spring.example.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dataspartan.spring.example.model.Hotel;
import com.dataspartan.spring.example.repository.HotelRepository;


@RestController
@RequestMapping("/api")
public class HotelController {

	@Autowired
	HotelRepository hotelRepository;

	@GetMapping("/hotels")
	public ResponseEntity<List<Hotel>> getAllHotels(@RequestParam(required = false) String title) {
		try {
			List<Hotel> hotels = new ArrayList<Hotel>();

			if (title == null)
				hotelRepository.findAll().forEach(hotels::add);
			else
				hotelRepository.findByNameContaining(title).forEach(hotels::add);

			if (hotels.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(hotels, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/hotels/{id}")
	public ResponseEntity<Hotel> getTutorialById(@PathVariable("id") long id) {
		Optional<Hotel> tutorialData = hotelRepository.findById(id);

		if (tutorialData.isPresent()) {
			return new ResponseEntity<>(tutorialData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/hotels")
	public ResponseEntity<Hotel> createTutorial(@RequestBody Hotel tutorial) {
		try {
			Hotel _tutorial = hotelRepository
					.save(new Hotel(tutorial.getName(), tutorial.getDescription(), tutorial.getStars()));
			return new ResponseEntity<>(_tutorial, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/hotels/{id}")
	public ResponseEntity<Hotel> updateTutorial(@PathVariable("id") long id, @RequestBody Hotel tutorial) {
		Optional<Hotel> tutorialData = hotelRepository.findById(id);

		if (tutorialData.isPresent()) {
			Hotel _tutorial = tutorialData.get();
			_tutorial.setName(tutorial.getName());
			_tutorial.setDescription(tutorial.getDescription());
			_tutorial.setStars(tutorial.getStars());
			return new ResponseEntity<>(hotelRepository.save(_tutorial), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/hotels/{id}")
	public ResponseEntity<HttpStatus> deleteTutorial(@PathVariable("id") long id) {
		try {
			hotelRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/hotels")
	public ResponseEntity<HttpStatus> deleteAllTutorials() {
		try {
			hotelRepository.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@GetMapping("/hotels/stars")
	public ResponseEntity<List<Hotel>> findByStars(@RequestParam(required = true) int starsFilter) {
		try {
			List<Hotel> tutorials = hotelRepository.findByStars(starsFilter);

			if (tutorials.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tutorials, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
