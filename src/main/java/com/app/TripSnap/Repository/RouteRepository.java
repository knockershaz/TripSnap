package com.app.TripSnap.Repository;

import com.app.TripSnap.Models.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RouteRepository extends JpaRepository<Route, Integer>{

    public Route findByRouteFromAndRouteTo(String from, String to);

}
