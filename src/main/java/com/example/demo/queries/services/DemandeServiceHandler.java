package com.example.demo.queries.services;

public class DemandeServiceHandler {

    @Service
    public class BookingService {

        private final BookingRepository bookingRepository;

        public BookingService(BookingRepository bookingRepository) {
            this.bookingRepository = bookingRepository;
        }

        public List<Booking> getBookingsByTripId(String tripId) {
            return bookingRepository.findByTripId(tripId);
        }

        public void acceptBooking(String bookingId) {
            Booking booking = bookingRepository.findById(bookingId)
                    .orElseThrow(() -> new EntityNotFoundException("Booking not found"));
            booking.setStatus(BookingStatus.ACCEPTED);
            bookingRepository.save(booking);
        }

        public void rejectBooking(String bookingId, String reason) {
            Booking booking = bookingRepository.findById(bookingId)
                    .orElseThrow(() -> new EntityNotFoundException("Booking not found"));
            booking.setStatus(BookingStatus.REJECTED);
            booking.setReason(reason);
            bookingRepository.save(booking);
        }
    }

}
