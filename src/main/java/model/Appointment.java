package model;
import java.time.LocalDate;
import java.time.LocalDateTime;

public record Appointment(
        String appointmentId,
        LocalDate bookingDate,
        LocalDateTime appointmentDateTime,
        Patient patient,
        Dentist dentist,
        Surgery surgery) {
}