package com.cybertek.controller;

import com.cybertek.entity.Cinema;
import com.cybertek.repository.CinemaRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cinema")
@Tag(name = "Cinema", description = "Cinema Api")
public class CinemaController {

    private final CinemaRepository cinemaRepository;

    public CinemaController(CinemaRepository cinemaRepository) {
        this.cinemaRepository = cinemaRepository;
    }

    @GetMapping("/read-all")
    @Operation(summary = "Read all cinemas")
    public List<Cinema> readAll(){
        return cinemaRepository.findAll();
    }
}
