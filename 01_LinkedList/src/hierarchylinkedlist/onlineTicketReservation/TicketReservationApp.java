package hierarchylinkedlist.onlineTicketReservation;

public class TicketReservationApp {
    public static void main(String[] args) {
        TicketReservationSystem system = new TicketReservationSystem();

        // Add tickets to the reservation system
        system.addTicket(101, "Alice", "Avatar", "A1", "2025-01-28 10:00 AM");
        system.addTicket(102, "Bob", "Avatar", "A2", "2025-01-28 10:00 AM");
        system.addTicket(103, "Charlie", "Titanic", "B1", "2025-01-28 12:00 PM");

        // Display current tickets
        system.displayTickets();

        // Search for tickets by customer name
        system.searchTicket("Alice");

        // Remove a ticket
        system.removeTicket(102);

        // Display updated tickets
        system.displayTickets();

        // Count the total number of booked tickets
        system.countTickets();
    }
}