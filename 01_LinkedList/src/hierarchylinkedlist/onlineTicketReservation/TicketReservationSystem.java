package hierarchylinkedlist.onlineTicketReservation;

class TicketReservationSystem {
    private Ticket head;

    public TicketReservationSystem() {
        this.head = null;
    }

    // Add a new ticket reservation at the end of the circular linked list
    public void addTicket(int ticketID, String customerName, String movieName, String seatNumber, String bookingTime) {
        Ticket newTicket = new Ticket(ticketID, customerName, movieName, seatNumber, bookingTime);

        if (head == null) {
            head = newTicket;
            newTicket.next = head;  // Circular link
        } else {
            Ticket temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newTicket;
            newTicket.next = head;  // Circular link
        }
    }

    // Remove a ticket by Ticket ID
    public void removeTicket(int ticketID) {
        if (head == null) {
            System.out.println("No tickets to remove.");
            return;
        }

        Ticket temp = head;
        Ticket prev = null;

        // Check if the head node itself needs to be removed
        if (temp.ticketID == ticketID) {
            if (temp.next == head) {
                head = null;  // Only one node in the list
            } else {
                while (temp.next != head) {
                    temp = temp.next;
                }
                head = head.next;
                temp.next = head;  // Update the circular link
            }
            System.out.println("Ticket with ID " + ticketID + " removed.");
            return;
        }

        // Search for the ticket to remove
        do {
            prev = temp;
            temp = temp.next;
        } while (temp != head && temp.ticketID != ticketID);

        if (temp == head) {
            System.out.println("Ticket with ID " + ticketID + " not found.");
        } else {
            prev.next = temp.next;  // Remove the ticket
            System.out.println("Ticket with ID " + ticketID + " removed.");
        }
    }

    // Display the current tickets in the list
    public void displayTickets() {
        if (head == null) {
            System.out.println("No tickets in the reservation system.");
            return;
        }

        Ticket temp = head;
        do {
            System.out.println("Ticket ID: " + temp.ticketID + ", Customer: " + temp.customerName + ", Movie: " + temp.movieName +
                    ", Seat: " + temp.seatNumber + ", Booking Time: " + temp.bookingTime);
            temp = temp.next;
        } while (temp != head);
    }

    // Search for a ticket by Customer Name or Movie Name
    public void searchTicket(String searchTerm) {
        if (head == null) {
            System.out.println("No tickets to search.");
            return;
        }

        Ticket temp = head;
        boolean found = false;
        do {
            if (temp.customerName.contains(searchTerm) || temp.movieName.contains(searchTerm)) {
                System.out.println("Ticket ID: " + temp.ticketID + ", Customer: " + temp.customerName + ", Movie: " + temp.movieName +
                        ", Seat: " + temp.seatNumber + ", Booking Time: " + temp.bookingTime);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);

        if (!found) {
            System.out.println("No tickets found matching: " + searchTerm);
        }
    }

    // Calculate and display the total number of booked tickets
    public void countTickets() {
        if (head == null) {
            System.out.println("No tickets in the reservation system.");
            return;
        }

        Ticket temp = head;
        int count = 0;
        do {
            count++;
            temp = temp.next;
        } while (temp != head);
        System.out.println("Total number of booked tickets: " + count);
    }
}