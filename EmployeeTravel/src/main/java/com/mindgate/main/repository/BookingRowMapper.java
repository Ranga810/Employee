package com.mindgate.main.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.mindgate.main.domain.BookingDetails;
import com.mindgate.main.domain.TravelRequest;

public class BookingRowMapper implements RowMapper<BookingDetails> {

	@Override
	public BookingDetails mapRow(ResultSet rs, int rowNum) throws SQLException {

		RequestRowMapper requestRowMapper = new RequestRowMapper();
		TravelRequest travelRequest = requestRowMapper.mapRow(rs, rowNum);

		int bookingId = rs.getInt("booking_id");
		int requestTravelId = rs.getInt("travel_request_id");
		String onboardingDate = rs.getString("onboarding_date");
		String onboardingPlace = rs.getString("onboarding_place");
		String destination = rs.getString("destination");
		String destinationDate = rs.getString("destination_date");
		String hotelName = rs.getString("hotel_name");
		String hotelAddress = rs.getString("hotel_address");
		String checkInTime = rs.getString("check_in_time");
		String checkOutTime = rs.getString("check_out_time");
		long contactNumber = rs.getLong("contact_number");

		BookingDetails bookingDetails = new BookingDetails(bookingId, requestTravelId, onboardingDate, onboardingPlace,
				destination, destinationDate, hotelName, hotelAddress, checkInTime, checkOutTime, contactNumber,
				travelRequest);

		return bookingDetails;

	}
}