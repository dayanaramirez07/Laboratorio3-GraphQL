package com.udea.search.resolver;

import com.udea.search.entity.Flight;
import com.udea.search.repository.FlightRepository;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import java.util.List;

@Controller
public class SearchController {

    private final FlightRepository flightRepository;

    public SearchController(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    @QueryMapping
    public List<Flight> searchFlights(@Argument String origin, @Argument String destination) {
        return flightRepository.findByOriginAndDestination(origin, destination);
    }

}
