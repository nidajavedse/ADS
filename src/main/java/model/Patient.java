package model;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;

public record Patient(
        String patientId,
        String firstName,
        String lastName,
        String address,
        String phone,
        String email,
        LocalDate dateOfBirth,
        List<Bill> bills) {

    public int getAge() {
        return Period.between(dateOfBirth, LocalDate.now()).getYears();
    }

    public boolean hasOutstandingBill() {
        return bills.stream()
                .anyMatch(Bill::isOutstandingOver12Months);
    }
}