package com.mindgate.main.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.mindgate.main.domain.BookingDetails;

@Repository
public class BookingRepository implements BookingRepositoryInterface {
	
	 @Autowired
	    private JdbcTemplate jdbcTemplate;
	    
	    private final  static String INSERT_NEW_BOOKING="insert into booking_details values(booking_id.nextVal,?,?,?,?,?,?,?,?,?,?)";
	    
	    private final static String UPDATE_EXISTING_BOOKING="update booking_details set travel_request_id=?,onboarding_date=?,onboarding_place=?,destination=? ,destination_date=?, hotel_name=?, hotel_address=? ,check_in_time=? ,check_out_time=?, contact_number=? where booking_id=?";
	    
	    
	    
	    private final static String SELECT_ALL_BOOKING=" SELECT * FROM BOOKING_DETAILS B,TRAVEL_REQUEST TR,EMPLOYEE_DETAILS E,DOCUMENT D,SLAB S WHERE B.TRAVEL_REQUEST_ID=TR.TRAVEL_REQUEST_ID AND TR.EMPLOYEE_ID =E.EMPLOYEE_ID AND  TR.DOCUMENT_ID = D.DOCUMENT_ID AND E.SLAB_ID = S.SLAB_ID";
	    		 
	            
	    
	    private final static String SELECT_ONE_BOOKING="SELECT * FROM BOOKING_DETAILS B,TRAVEL_REQUEST TR,EMPLOYEE_DETAILS E,DOCUMENT D,SLAB S WHERE B.TRAVEL_REQUEST_ID=TR.TRAVEL_REQUEST_ID AND TR.EMPLOYEE_ID =E.EMPLOYEE_ID AND  TR.DOCUMENT_ID = D.DOCUMENT_ID AND E.SLAB_ID = S.SLAB_ID AND booking_id=?";

	    private final static String DELETE_EXISTING_BOOKING="delete from booking_details where booking_id =?";
	    

	@Override
	public boolean deletebooking(int bookingId) {
		 jdbcTemplate.update(DELETE_EXISTING_BOOKING,bookingId);
         return true;
	}

	@Override
	public BookingDetails getbookingBybookingId(int bookingId) {
		 BookingRowMapper bookingRowMapper = new BookingRowMapper();
	        BookingDetails bookingDetails =jdbcTemplate.queryForObject(SELECT_ONE_BOOKING, bookingRowMapper,bookingId);
	        return bookingDetails;   
	}

	@Override
	public List<BookingDetails> getallbookings() {
		BookingRowMapper bookingRowMapper = new BookingRowMapper();
        return jdbcTemplate.query(SELECT_ALL_BOOKING,bookingRowMapper);
	}

	@Override
	public boolean addnewbooking(BookingDetails bookingDetails) {
		 Object[] parameters = {
				 bookingDetails.getTravelRequestId(), 
				 bookingDetails.getOnboardingDate(),
				 bookingDetails.getOnboardingPlace(),
				 bookingDetails.getDestination(),
				 bookingDetails.getDestinationDate(),
				 bookingDetails.getHotelName(),
				 bookingDetails.getHotelAddress(),
				 bookingDetails.getCheckInTime(), 
				 bookingDetails.getCheckOutTime(),
				 bookingDetails.getContactNumber(),
				  };
	        

		 int rowcount =jdbcTemplate.update(INSERT_NEW_BOOKING, parameters);
		 if(rowcount >0){
	            return true;
	        }
	        return false;
	        
	}

	@Override
	public BookingDetails updatebooking(BookingDetails bookingDetails) {
		 Object [] parameters = {
				 bookingDetails.getTravelRequestId(), 
				 bookingDetails.getOnboardingDate(),
				 bookingDetails.getOnboardingPlace(),
				 bookingDetails.getDestination(),
				 bookingDetails.getDestinationDate(),
				 bookingDetails.getHotelName(),
				 bookingDetails.getHotelAddress(),
				 bookingDetails.getCheckInTime(), 
				 bookingDetails.getCheckOutTime(),
				 bookingDetails.getContactNumber(),
				 bookingDetails.getBookingId() 
				 };
//		 travel_request_id=?,onboarding_date=?,onboarding_place=?,destination=? ,destination_date=?, hotel_name=?, hotel_address=? ,check_in_time=? ,check_out_time=?, contact_number=? where booking_id=?"
	        int rowcount = jdbcTemplate.update(UPDATE_EXISTING_BOOKING, parameters);
	        if(rowcount >0){
	            return getbookingBybookingId(bookingDetails.getBookingId());
	        }
	        return null;
	    
	    }
}
