package com.app.TripSnap.Service;


import com.app.TripSnap.Exception.AdminException;
import com.app.TripSnap.Exception.BusException;
import com.app.TripSnap.Models.Bus;

import java.util.List;

public interface BusService {
    //admin methods
    public Bus addBus(Bus bus, String key) throws BusException, AdminException;
    public Bus updateBus(Bus bus, String key) throws BusException, AdminException;
    public Bus deleteBus(Integer busId, String key) throws BusException, AdminException;

    //admin + user methods
    public Bus viewBus(Integer busId) throws BusException;
    public List<Bus> viewBusByBusType(String busType) throws BusException;
    public List<Bus> viewAllBuses() throws BusException;
}
