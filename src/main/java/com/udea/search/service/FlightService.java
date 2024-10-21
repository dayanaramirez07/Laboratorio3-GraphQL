package com.udea.search.service;

import com.udea.search.entity.Flight;
import com.udea.search.repository.FlightRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class FlightService {

    private final FlightRepository flightRepository;

    public FlightService(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    // Obtener todos los vuelos
    public List<Flight> getAllFlights() {
        return flightRepository.findAll();
    }

    // Buscar vuelo por ID
    public Flight getFlightById(Long id) {
        return flightRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Flight not found"));
    }

    // Guardar un nuevo vuelo
    public Flight addFlight(String flightNumber, String origin, String destination, LocalDateTime departureTime, LocalDateTime arrivalTime, double price, int passengers) {
        Flight flight = new Flight();
        flight.setFlightNumber(flightNumber);
        flight.setOrigin(origin);
        flight.setDestination(destination);
        flight.setDepartureTime(departureTime);
        flight.setArrivalTime(arrivalTime);
        flight.setPrice(price);
        flight.setPassengers(passengers);
        return flightRepository.save(flight);
    }

}
