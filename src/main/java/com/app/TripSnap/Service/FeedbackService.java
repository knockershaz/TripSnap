package com.app.TripSnap.Service;

import java.util.List;

import com.app.TripSnap.Exception.BusException;
import com.app.TripSnap.Exception.FeedBackException;
import com.app.TripSnap.Exception.UserException;
import com.app.TripSnap.Models.Feedback;


public interface FeedbackService {


    public Feedback addFeedBack(Feedback feedBack, Integer busId, String key) throws BusException, UserException;

    public Feedback updateFeedBack(Feedback feedback,String key) throws FeedBackException, UserException;

    public Feedback deleteFeedBack(Integer feedbackId, String key)throws FeedBackException,UserException;

    public Feedback viewFeedback(Integer id) throws FeedBackException;

    public List<Feedback> viewFeedbackAll() throws FeedBackException;

}
