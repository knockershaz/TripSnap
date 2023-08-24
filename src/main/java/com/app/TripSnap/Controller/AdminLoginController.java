package com.app.TripSnap.Controller;

import com.app.TripSnap.Exception.AdminException;
import com.app.TripSnap.Exception.LoginException;
import com.app.TripSnap.Models.AdminLoginDTO;
import com.app.TripSnap.Models.CurrentAdminSession;
import com.app.TripSnap.Service.AdminLoginService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/safar")
public class AdminLoginController {

    @Autowired
    private AdminLoginService loginService;

    @PostMapping("/admin/login")
    public ResponseEntity<CurrentAdminSession> loginAdmin(@RequestBody AdminLoginDTO loginDTO) throws AdminException, LoginException {
//        System.out.println(loginDTO);
        CurrentAdminSession currentAdminSession = loginService.adminLogin(loginDTO);
        return new ResponseEntity<>(currentAdminSession, HttpStatus.ACCEPTED);
    }

    @PostMapping("/admin/logout")
    public String logoutAdmin(@RequestParam(required = false) String key) throws LoginException {
        return loginService.adminLogout(key);
    }
}

