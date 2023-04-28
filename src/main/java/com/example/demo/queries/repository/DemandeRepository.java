package com.example.demo.queries.repository;

public interface DemandeRepository {
    @Repository
    public interface BookingRepository extends JpaRepository<Booking, String> {

        List<Booking> findByTripId(String tripId);
    }

}
