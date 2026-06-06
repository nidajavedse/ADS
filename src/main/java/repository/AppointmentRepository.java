package repository;
import model.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class AppointmentRepository {

    public List<Appointment> findAll() {

        Bill bill = new Bill(
                "B1",
                500,
                LocalDate.now().minusMonths(13),
                false);

        Patient patient1 = new Patient(
                "P1",
                "John",
                "Doe",
                "Chicago",
                "111111",
                "john@test.com",
                LocalDate.of(1990,5,12),
                List.of());

        Patient patient2 = new Patient(
                "P2",
                "Jane",
                "Smith",
                "Dallas",
                "222222",
                "jane@test.com",
                LocalDate.of(1985,7,20),
                List.of(bill));

        Dentist dentist =
                new Dentist("D1","Robert","Brown");

        Surgery surgery =
                new Surgery(
                        "S1",
                        "ADS Fairfield",
                        "100 Main St",
                        "6411111111");

        List<Appointment> appointments = new ArrayList<>();

        appointments.add(
                new Appointment(
                        "A1",
                        LocalDate.now(),
                        LocalDateTime.of(2026,8,10,9,0),
                        patient1,
                        dentist,
                        surgery));

        appointments.add(
                new Appointment(
                        "A2",
                        LocalDate.now(),
                        LocalDateTime.of(2026,9,15,14,0),
                        patient2,
                        dentist,
                        surgery));

        appointments.add(
                new Appointment(
                        "A3",
                        LocalDate.now(),
                        LocalDateTime.of(2026,12,1,11,0),
                        patient1,
                        dentist,
                        surgery));

        return appointments;
    }
}