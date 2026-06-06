package controller;

import business.AppointmentUseCase;
import repository.AppointmentRepository;
import service.AppointmentService;
import util.JsonUtil;

public class DentalClinicApplication {

    public static void main(String[] args) throws Exception {

        AppointmentRepository repository =
                new AppointmentRepository();

        AppointmentService service =
                new AppointmentService(repository);

        AppointmentUseCase useCase =
                new AppointmentUseCase(service);

        System.out.println(
                "===== ALL APPOINTMENTS =====");

        System.out.println(
                JsonUtil.toJson(
                        useCase.getAllAppointmentsDescending()));

        System.out.println(
                "\n===== QUARTERLY UPCOMING APPOINTMENTS =====");

        System.out.println(
                JsonUtil.toJson(
                        useCase.getQuarterlyUpcomingAppointments()));
    }
}