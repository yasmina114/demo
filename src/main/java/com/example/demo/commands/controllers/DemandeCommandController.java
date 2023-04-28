package com.example.demo.commands.controllers;

public class DemandeCommandController {
    @RestController
    @RequestMapping("/bookings")
    public class BookingController {

        private final BookingService bookingService;

        public BookingController(BookingService bookingService) {
            this.bookingService = bookingService;
        }

        @GetMapping("/by-trip/{tripId}")
        public ResponseEntity<List<Booking>> getBookingsByTripId(@PathVariable String tripId) {
            List<Booking> bookings = bookingService.getBookingsByTripId(tripId);
            return ResponseEntity.ok(bookings);
        }

        @PutMapping("/{bookingId}/accept")
        public ResponseEntity<Void> acceptBooking(@PathVariable String bookingId) {
            bookingService.acceptBooking(bookingId);
            return ResponseEntity.ok().build();
        }

        @PutMapping("/{bookingId}/reject")
        public ResponseEntity<Void> rejectBooking(@PathVariable String bookingId, @RequestBody String reason) {
            bookingService.rejectBooking(bookingId, reason);
            return ResponseEntity.ok().build();
        }
    }

}

