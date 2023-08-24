package com.app.TripSnap.Service;

import com.app.TripSnap.Exception.AdminException;
import com.app.TripSnap.Models.Admin;
import com.app.TripSnap.Models.CurrentAdminSession;
import com.app.TripSnap.Repository.AdminRepository;
import com.app.TripSnap.Repository.CurrentAdminSessionRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService{

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private CurrentAdminSessionRepository adminSessionRepository;

    @Override
    public Admin createAdmin(Admin admin) throws AdminException {
//        Admin a = adminRepository.findByEmail(admin.getEmail());
        List<Admin> admins = adminRepository.findByEmail(admin.getEmail());

        if(!admins.isEmpty()) throw new AdminException("Admin already present with the given email: " + admin.getEmail());

        return adminRepository.save(admin);
    }

    @Override
    public Admin updateAdmin(Admin admin, String key) throws AdminException {
        CurrentAdminSession adminSession = adminSessionRepository.findByaid(key);
        if(adminSession == null) throw new AdminException("Please enter valid key or login first!");
        if(admin.getAdminID() != adminSession.getAdminID()) throw new AdminException("Invalid admin details, please login for updating admin!");
        return adminRepository.save(admin);
    }

}
