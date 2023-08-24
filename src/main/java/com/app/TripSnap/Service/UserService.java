package com.app.TripSnap.Service;

import com.app.TripSnap.Exception.AdminException;
import com.app.TripSnap.Exception.UserException;
import com.app.TripSnap.Models.User;

import java.util.List;

public interface UserService {
    public User createUser(User user) throws UserException;
    public User updateUser(User user, String key) throws UserException;
    public User deleteUser(Integer userId, String key) throws UserException, AdminException;
    public User viewUserById(Integer userId, String key) throws UserException, AdminException;
    public List<User> viewAllUser(String key) throws UserException, AdminException;
}
