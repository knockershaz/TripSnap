package com.app.TripSnap.Service;

import com.app.TripSnap.Exception.AdminException;
import com.app.TripSnap.Models.Admin;

public interface AdminService {
    public Admin createAdmin(Admin admin) throws AdminException;
    public Admin updateAdmin(Admin admin, String key) throws AdminException;
}
