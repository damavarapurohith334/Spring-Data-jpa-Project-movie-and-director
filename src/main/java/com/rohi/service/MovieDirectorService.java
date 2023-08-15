package com.rohi.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rohi.dto.DirectorDTO;
import com.rohi.dto.MovieDTO;
import com.rohi.entity.Director;
import com.rohi.entity.Movie;
import com.rohi.entity.MovieDirector;
import com.rohi.exceptions.DirectorDetailsNotFoundException;
import com.rohi.exceptions.RecordNotFoundException;
import com.rohi.repo.DirectorRepository;
import com.rohi.repo.MovieDirectorRepository;
import com.rohi.repo.MovieRepository;

@Service
public class MovieDirectorService {

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private DirectorRepository directorRepository;

    @Autowired
    private MovieDirectorRepository movieDirectorRepository;

    public void addMovieAndDirector(MovieDTO movieDTO, DirectorDTO directorDTO) {
        Movie movie = new Movie();
        movie.setMovieTitle(movieDTO.getMovieTitle());
        movie.setDateReleased(movieDTO.getDateReleased());
        movie.setMovieRunningTime(movieDTO.getMovieRunningTime());
        movieRepository.save(movie);

        Director director = new Director();
        director.setFirstName(directorDTO.getFirstName());
        director.setLastName(directorDTO.getLastName());
        director.setAddress(directorDTO.getAddress());
        director.setContactNumber(directorDTO.getContactNumber());
        director.setEmail(directorDTO.getEmail());
        directorRepository.save(director);

        MovieDirector movieDirector = new MovieDirector();
        movieDirector.setMovie(movie);
        movieDirector.setDirector(director);
        movieDirectorRepository.save(movieDirector);
    }

//    public List<MovieDTO> searchMoviesByTitle(String movieTitle) {
//        Movie movies = movieRepository.findByMovieTitleIgnoreCase(movieTitle);
//        return mapMoviesToMovieDTOs(movies);
//    }

  
    

    public List<DirectorDTO> searchDirectorsByName(String firstName, String lastName) {
        System.out.println("Inside searchDirectorsByName service method");

        List<Director> directors = directorRepository.findByFirstNameAndLastNameIgnoreCase(firstName, lastName);

        return mapDirectorsToDirectorDTOs(directors);
    }

    public List<MovieDTO> viewAllMovies() {
        List<Movie> movies = movieRepository.findAll();
        return mapMoviesToMovieDTOs(movies);
    }

    public void updateMovieReleaseDate(String movieTitle, Date newReleaseDate) throws RecordNotFoundException {
        Movie movie = movieRepository.findByMovieTitleIgnoreCase(movieTitle);
        if (movie != null) {
            movie.setDateReleased(newReleaseDate);
            movieRepository.save(movie);
        } else {
            throw new RecordNotFoundException("Movie not found");
        }
    }

//    public void updateDirectorDetails(String firstName, String lastName, String newAddress, int newContactNumber) {
//        Director director = directorRepository.findByFirstNameAndLastName(firstName, lastName);
//        if (director != null) {
//            director.setAddress(newAddress);
//            director.setContactNumber(newContactNumber);
//            directorRepository.save(director);
//        } else {
//            throw new DirectorDetailsNotFoundException("Director details not found");
//        }
//    }

    public void removeMovieByTitle(String movieTitle) throws RecordNotFoundException {
        Movie movie = movieRepository.findByMovieTitleIgnoreCase(movieTitle);
        if (movie != null) {
            movieRepository.delete(movie);
        } else {
            throw new RecordNotFoundException("Movie not found");
        }
    }

    private List<MovieDTO> mapMoviesToMovieDTOs(List<Movie> movies) {
        List<MovieDTO> movieDTOs = new ArrayList<>();
        for (Movie movie : movies) {
            MovieDTO movieDTO = new MovieDTO();
            movieDTO.setMovieTitle(movie.getMovieTitle());
            movieDTO.setDateReleased(movie.getDateReleased());
            movieDTO.setMovieRunningTime(movie.getMovieRunningTime());
            movieDTOs.add(movieDTO);
        }
        return movieDTOs;
    }

    private List<DirectorDTO> mapDirectorsToDirectorDTOs(List<Director> directors) {
        List<DirectorDTO> directorDTOs = new ArrayList<>();
        for (Director director : directors) {
            DirectorDTO directorDTO = new DirectorDTO();
            directorDTO.setFirstName(director.getFirstName());
            directorDTO.setLastName(director.getLastName());
            directorDTO.setAddress(director.getAddress());
            directorDTO.setContactNumber(director.getContactNumber());
            directorDTO.setEmail(director.getEmail());
            directorDTOs.add(directorDTO);
        }
        return directorDTOs;
    }
}
