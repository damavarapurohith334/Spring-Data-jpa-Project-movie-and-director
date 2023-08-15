package com.rohi.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rohi.dto.DirectorDTO;
import com.rohi.dto.MovieDTO;
import com.rohi.exceptions.RecordNotFoundException;
import com.rohi.service.MovieDirectorService;
import com.rohi.utils.AddMovieAndDirectorRequest;

@RestController
@RequestMapping("/api")
public class MovieDirectorController {

	@Autowired
	private MovieDirectorService movieDirectorService;

	@PostMapping("/addMovieAndDirector")
	public ResponseEntity<String> addMovieAndDirector(@RequestBody AddMovieAndDirectorRequest request) {
		try {
			MovieDTO movieDTO = new MovieDTO(request.getMovieTitle(), request.getDateReleased(),
					request.getMovieRunningTime());
			DirectorDTO directorDTO = new DirectorDTO(request.getFirstName(), request.getLastName(),
					request.getAddress(), request.getContactNumber(), request.getEmail());

			movieDirectorService.addMovieAndDirector(movieDTO, directorDTO);
			return ResponseEntity.ok("Movie and Director added successfully");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error adding Movie and Director");
		}
	}

//    @GetMapping("/searchMoviesByTitle")
//    public ResponseEntity<List<MovieDTO>> searchMoviesByTitle(@RequestParam String movieTitle) {
//        List<MovieDTO> movies = movieDirectorService.searchMoviesByTitle(movieTitle);
//        return ResponseEntity.ok(movies);
//    }

	
	 @GetMapping("/searchDirectorsByName/{firstName}/{lastName}")
	    public ResponseEntity<List<DirectorDTO>> searchDirectorsByName(@PathVariable String firstName,
	                                                                   @PathVariable String lastName) {
	        System.out.println("Invoking searchDirectorsByName with firstName: " + firstName + " and lastName: " + lastName);

	        List<DirectorDTO> directors = movieDirectorService.searchDirectorsByName(firstName, lastName);
	        
	        if (directors.isEmpty()) {
	            return ResponseEntity.notFound().build(); // Return a 404 response if no directors are found
	        }
	        
	        return ResponseEntity.ok(directors);
	    }

	@GetMapping("/viewAllMovies")
	public ResponseEntity<List<MovieDTO>> viewAllMovies() {
		List<MovieDTO> movies = movieDirectorService.viewAllMovies();
		return ResponseEntity.ok(movies);
	}

	@PostMapping("/updateMovieReleaseDate")
	public ResponseEntity<String> updateMovieReleaseDate(@RequestParam String movieTitle,
			@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date newReleaseDate) {
		try {
			movieDirectorService.updateMovieReleaseDate(movieTitle, newReleaseDate);
			return ResponseEntity.ok("Movie release date updated successfully");
		} catch (RecordNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error updating movie release date");
		}
	}

//    @PostMapping("/updateDirectorDetails")
//    public ResponseEntity<String> updateDirectorDetails(@RequestBody DirectorUpdateRequest request) {
//        try {
//            movieDirectorService.updateDirectorDetails(
//                request.getFirstName(),
//                request.getLastName(),
//                request.getNewAddress(),
//                request.getNewContactNumber());
//            return ResponseEntity.ok("Director details updated successfully");
//        } catch (DirectorDetailsNotFoundException e) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error updating director details");
//        }
//    }

	@PostMapping("/removeMovieByTitle")
	public ResponseEntity<String> removeMovieByTitle(@RequestParam String movieTitle) {
		try {
			movieDirectorService.removeMovieByTitle(movieTitle);
			return ResponseEntity.ok("Movie removed successfully");
		} catch (RecordNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error removing movie");
		}
	}
}
