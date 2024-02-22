package main.java.app;

public record Employee(int personalNumber, String phoneNumber, String name, int experience) {
    @Override
    public String toString() {
        return "Employee{" +
                "personalNumber=" + personalNumber +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", name='" + name + '\'' +
                ", experience=" + experience +
                '}';
    }
}
