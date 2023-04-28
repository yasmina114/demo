package com.example.demo.commands.aggregates;
import com.example.demo.commonapi.enums.DemandeStatus;
import com.example.org.oga.commonapi.commands.CreateReservationCommand;
import com.example.org.oga.commonapi.commands.DeleteReservationCommand;
import com.example.org.oga.commonapi.enums.ReservationStatus;
import com.example.org.oga.commonapi.events.CancelResrvationEvent;
import com.example.org.oga.commonapi.events.ReservationActivatedEvent;
import com.example.org.oga.commonapi.events.ReservationCreatedEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
public class DemandeAggregate {
    @AggregateIdentifier
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    private String tripId;

    private String passenger;

    @Enumerated(EnumType.STRING)
    private BookingStatus status;

    private String reason;




}
