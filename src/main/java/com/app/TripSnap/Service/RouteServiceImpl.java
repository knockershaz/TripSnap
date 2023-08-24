package com.app.TripSnap.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.app.TripSnap.Exception.AdminException;
import com.app.TripSnap.Exception.RouteException;
import com.app.TripSnap.Models.Bus;
import com.app.TripSnap.Models.CurrentAdminSession;
import com.app.TripSnap.Models.Route;
import com.app.TripSnap.Repository.AdminRepository;
import com.app.TripSnap.Repository.CurrentAdminSessionRepository;
import com.app.TripSnap.Repository.RouteRepository;
import com.app.TripSnap.Service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RouteServiceImpl implements RouteService {

    @Autowired
    private RouteRepository routerepository;

    @Autowired
    private CurrentAdminSessionRepository currentddminsessionrepository;

    @Autowired
    private AdminRepository adminrepository;




    @Override
    public Route addRoute(Route route, String key) throws RouteException, AdminException {

        CurrentAdminSession loggedInAdmin= currentddminsessionrepository.findByaid(key);

        if(loggedInAdmin == null) {
            throw new AdminException("Please provide a valid admin key!");
        }

        Route newRoute = routerepository.findByRouteFromAndRouteTo(route.getRouteFrom(), route.getRouteTo());

        if(newRoute != null) throw new RouteException("Route :"+ newRoute.getRouteFrom() +" to "+ newRoute.getRouteTo()+ " is already present !");

        List<Bus> buses = new ArrayList<>();

        if(route != null) {
            route.setBusList(buses);
            return routerepository.save(route);
        }
        else {
            throw new RouteException("This root is not available");
        }
    }

    @Override
    public List<Route> viewAllRoute() throws RouteException {

        List<Route> routes=routerepository.findAll();

        if(routes.isEmpty())
            throw new RouteException("No route available");
        else
            return routes;

    }
    @Override
    public Route viewRoute(int routeId) throws RouteException {
        Optional<Route> opt=routerepository.findById(routeId);

        return opt.orElseThrow(()->new RouteException("There is no route present of this  routeId :" + routeId));
    }

    @Override
    public Route updateRoute(Route route,String key) throws RouteException, AdminException {
        CurrentAdminSession loggedInAdmin= currentddminsessionrepository.findByaid(key);
        if(loggedInAdmin == null) {
            throw new AdminException("Please provide a valid id to add route !");
        }

        Optional<Route> existedRoute = routerepository.findById(route.getRouteID());
        if(existedRoute.isPresent()) {

            Route presentRoute = existedRoute.get();
            List<Bus> busList = presentRoute.getBusList();

            if(!busList.isEmpty()) throw new RouteException("Cannot update running route! Buses are already scheduled in the route.");

            return routerepository.save(route);
        }
        else
            throw new RouteException("Route doesn't exist of  this routeId : "+ route.getRouteID());

    }


    @Override
    public Route deleteRoute(int routeID,String key) throws RouteException, AdminException {

        CurrentAdminSession loggedInAdmin= currentddminsessionrepository.findByaid(key);

        if(loggedInAdmin == null) {
            throw new AdminException("Please provide a valid id to add route !");
        }

        Optional<Route> route=routerepository.findById(routeID);

        if(route.isPresent()) {
            Route existingRoute=route.get();
            routerepository.delete(existingRoute);
            return existingRoute;
        }
        else
            throw new RouteException("There is no route of this routeId : "+ routeID);

    }
}
