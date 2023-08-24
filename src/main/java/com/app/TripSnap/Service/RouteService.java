package com.app.TripSnap.Service;

import java.util.List;

import com.app.TripSnap.Exception.AdminException;
import com.app.TripSnap.Exception.RouteException;
import com.app.TripSnap.Models.Route;

public interface RouteService {
    public Route addRoute(Route route, String key) throws RouteException, AdminException;
    public List<Route> viewAllRoute() throws RouteException;
    public Route viewRoute(int routeId) throws RouteException;
    public Route updateRoute(Route route,String key) throws RouteException, AdminException;
    public Route deleteRoute(int routeID,String key) throws RouteException, AdminException;


}
