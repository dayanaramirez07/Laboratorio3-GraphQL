
package com.udea.search.service;

import com.udea.search.entity.Flight;
import com.udea.search.repository.FlightRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchService {

    private final FlightRepository flightRepository;

    public SearchService(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    // Buscar vuelos por origen y destino
    public List<Flight> searchFlights(String origin, String destination) {
        return flightRepository.findByOriginAndDestination(origin, destination);
    }

}
