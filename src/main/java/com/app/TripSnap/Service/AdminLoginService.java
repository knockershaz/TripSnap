package com.app.TripSnap.Service;

import com.app.TripSnap.Exception.AdminException;
import com.app.TripSnap.Exception.LoginException;
import com.app.TripSnap.Models.AdminLoginDTO;
import com.app.TripSnap.Models.CurrentAdminSession;

public interface AdminLoginService {
    public CurrentAdminSession adminLogin(AdminLoginDTO loginDTO) throws LoginException, AdminException;
    public String adminLogout(String key) throws LoginException;
}