package model;
public record Dentist(
        String dentistId,
        String firstName,
        String lastName) {

    public String getFullName() {
        return firstName + " " + lastName;
    }
}
