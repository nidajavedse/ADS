package business;

import model.Appointment;
import service.AppointmentService;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;

public class AppointmentUseCase {

    private final AppointmentService service;

    public AppointmentUseCase(AppointmentService service) {
        this.service = service;
    }

    public List<Appointment> getAllAppointmentsDescending() {

        return service.getAppointments()
                .stream()
                .sorted(
                        Comparator.comparing(
                                        Appointment::appointmentDateTime)
                                .reversed())
                .toList();
    }

    public List<Appointment> getQuarterlyUpcomingAppointments() {

        LocalDate now = LocalDate.now();

        int nextQuarter =
                (now.getMonthValue() - 1) / 3 + 2;

        int year = now.getYear();

        if (nextQuarter == 5) {
            nextQuarter = 1;
            year++;
        }

        final int q = nextQuarter;
        final int y = year;

        return service.getAppointments()
                .stream()
                .filter(a -> {

                    int aq =
                            (a.appointmentDateTime()
                                    .getMonthValue() - 1) / 3 + 1;

                    int ay =
                            a.appointmentDateTime()
                                    .getYear();

                    return aq == q && ay == y;
                })
                .sorted(
                        Comparator.comparing(
                                Appointment::appointmentDateTime))
                .toList();
    }
}