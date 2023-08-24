package com.app.TripSnap.Service;


import com.app.TripSnap.Exception.LoginException;
import com.app.TripSnap.Models.CurrentUserSession;
import com.app.TripSnap.Models.UserLoginDTO;

public interface UserLoginService {
    public CurrentUserSession userLogin(UserLoginDTO userLoginDTO) throws LoginException;
    public String userLogout(String key) throws LoginException;
}
