package com.mindgate.main.repository;

import java.util.List;

import com.mindgate.main.domain.BookingDetails;

public interface BookingRepositoryInterface {
	
	 public boolean deletebooking(int bookingId);
	 public BookingDetails getbookingBybookingId(int bookingId);
	 public List<BookingDetails> getallbookings();
	 public boolean addnewbooking(BookingDetails bookingDetails);
	 public BookingDetails updatebooking(BookingDetails bookingDetails);

	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
}