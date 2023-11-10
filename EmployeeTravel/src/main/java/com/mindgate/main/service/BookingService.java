package com.mindgate.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindgate.main.domain.BookingDetails;
import com.mindgate.main.repository.BookingRepositoryInterface;

@Service
public class BookingService implements BookingServiceInterface {
	
	@Autowired
	private BookingRepositoryInterface  bookingRepositoryInterface;

	@Override
	public boolean deletebooking(int bookingId) {

		return bookingRepositoryInterface.deletebooking(bookingId);
	}

	@Override
	public BookingDetails getbookingBybookingId(int bookingId) {
		// TODO Auto-generated method stub
		return bookingRepositoryInterface.getbookingBybookingId(bookingId);
	}

	@Override
	public List<BookingDetails> getallbookings() {
		// TODO Auto-generated method stub
		return bookingRepositoryInterface.getallbookings();
	}

	@Override
	public boolean addnewbooking(BookingDetails bookingDetails) {
		// TODO Auto-generated method stub
		return bookingRepositoryInterface.addnewbooking(bookingDetails);
	}

	@Override
	public BookingDetails updatebooking(BookingDetails bookingDetails) {
		// TODO Auto-generated method stub
		return bookingRepositoryInterface.updatebooking(bookingDetails);
	}

}
