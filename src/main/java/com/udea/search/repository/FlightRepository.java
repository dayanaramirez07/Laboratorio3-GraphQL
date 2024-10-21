package com.udea.search.repository;

import com.udea.search.entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface FlightRepository extends JpaRepository<Flight, Long> {

    List<Flight> findByOriginAndDestination(String origin, String destination);

}
