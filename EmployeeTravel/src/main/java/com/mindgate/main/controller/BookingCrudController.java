package com.mindgate.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mindgate.main.domain.BookingDetails;
import com.mindgate.main.service.BookingServiceInterface;

@RestController
@RequestMapping("bookingapi")
public class BookingCrudController {
	
	@Autowired
    private BookingServiceInterface bookingServiceInterface;
    @RequestMapping(value="booking/{bookingId}",method = RequestMethod.DELETE)
    public boolean deletetebooking(@PathVariable int bookingId) {
        return bookingServiceInterface.deletebooking(bookingId);
    }
    @RequestMapping(value="bookings",method = RequestMethod.GET)
    public List<BookingDetails>getallbookings(){
        return bookingServiceInterface.getallbookings();
    }
    @RequestMapping(value="bookings/{bookingId}",method = RequestMethod.GET)
    public BookingDetails selectonebooking(@PathVariable int bookingId) {
        return bookingServiceInterface.getbookingBybookingId(bookingId);
    }
    @RequestMapping(value="bookings/booking",method = RequestMethod.POST)
        public boolean addnewbooking(@RequestBody BookingDetails bookingDetails) {
            return bookingServiceInterface.addnewbooking(bookingDetails);
        }
    @RequestMapping(value="bookings/update",method = RequestMethod.PUT)
    public BookingDetails updatebooking(@RequestBody BookingDetails bookingDetails) {
        return bookingServiceInterface.updatebooking(bookingDetails);
    }

}
