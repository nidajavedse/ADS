package service;
import model.Appointment;
import repository.AppointmentRepository;

import java.util.List;

public class AppointmentService {

    private final AppointmentRepository repository;

    public AppointmentService(AppointmentRepository repository) {
        this.repository = repository;
    }

    public List<Appointment> getAppointments() {
        return repository.findAll();
    }
}