package model;
import java.time.LocalDate;

public record Bill(
        String billId,
        double amount,
        LocalDate billDate,
        boolean paid) {

    public boolean isOutstandingOver12Months() {
        return !paid &&
                billDate.isBefore(LocalDate.now().minusMonths(12));
    }
}