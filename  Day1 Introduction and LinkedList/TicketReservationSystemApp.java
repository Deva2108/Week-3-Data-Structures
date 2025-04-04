import java.time.LocalDateTime;
import java.util.Scanner;

class Ticket {
    int ticketID;
    String customerName;
    String movieName;
    String seatNumber;
    LocalDateTime bookingTime;
    Ticket next; // Pointer to the next node in the circular linked list

    // Constructor to initialize a ticket
    public Ticket(int ticketID, String customerName, String movieName, String seatNumber, LocalDateTime bookingTime) {
        this.ticketID = ticketID;
        this.customerName = customerName;
        this.movieName = movieName;
        this.seatNumber = seatNumber;
        this.bookingTime = bookingTime;
        this.next = null; // Will be linked later
    }
}

class TicketReservationSystem {
    private Ticket head = null;  // Head of the circular linked list
    private Ticket tail = null;  // Tail of the circular linked list
    private int totalTickets = 0;  // To track the number of tickets

    // Add a new ticket reservation at the end of the list
    public void addTicket(int ticketID, String customerName, String movieName, String seatNumber) {
        Ticket newTicket = new Ticket(ticketID, customerName, movieName, seatNumber, LocalDateTime.now());

        if (head == null) {
            // If the list is empty, the new ticket is both the head and the tail
            head = newTicket;
            tail = newTicket;
            tail.next = head;  // Circular link
        } else {
            // Add the new ticket to the end of the list and update the tail
            tail.next = newTicket;
            tail = newTicket;
            tail.next = head;  // Maintain the circular link
        }
        totalTickets++;
        System.out.println("Ticket reserved successfully.");
    }

    // Remove a ticket by Ticket ID
    public void removeTicket(int ticketID) {
        if (head == null) {
            System.out.println("No tickets to remove.");
            return;
        }

        Ticket current = head;
        Ticket previous = null;

        // Search for the ticket to remove
        do {
            if (current.ticketID == ticketID) {
                if (previous == null) {
                    // If the ticket to remove is the head
                    if (head == head.next) {
                        head = null;  // Only one ticket in the list
                        tail = null;
                    } else {
                        head = head.next;
                        tail.next = head;
                    }
                } else {
                    // Remove the ticket in between or at the end
                    previous.next = current.next;
                    if (current == tail) {
                        tail = previous;  // If it's the last ticket
                    }
                }
                totalTickets--;
                System.out.println("Ticket removed successfully.");
                return;
            }
            previous = current;
            current = current.next;
        } while (current != head);

        // If the ticket is not found
        System.out.println("Ticket with ID " + ticketID + " not found.");
    }

    // Display the current tickets in the list
    public void displayTickets() {
        if (head == null) {
            System.out.println("No tickets reserved.");
            return;
        }

        Ticket current = head;
        System.out.println("Current Tickets:");
        do {
            System.out.println("Ticket ID: " + current.ticketID + ", Customer Name: " + current.customerName +
                    ", Movie Name: " + current.movieName + ", Seat Number: " + current.seatNumber +
                    ", Booking Time: " + current.bookingTime);
            current = current.next;
        } while (current != head);
    }

    // Search for a ticket by Customer Name or Movie Name
    public void searchTicket(String searchTerm) {
        if (head == null) {
            System.out.println("No tickets reserved.");
            return;
        }

        Ticket current = head;
        boolean found = false;
        do {
            if (current.customerName.equalsIgnoreCase(searchTerm) || current.movieName.equalsIgnoreCase(searchTerm)) {
                System.out.println("Ticket found: Ticket ID: " + current.ticketID + ", Customer Name: " + current.customerName +
                        ", Movie Name: " + current.movieName + ", Seat Number: " + current.seatNumber +
                        ", Booking Time: " + current.bookingTime);
                found = true;
            }
            current = current.next;
        } while (current != head);

        if (!found) {
            System.out.println("No tickets found for the search term: " + searchTerm);
        }
    }

    // Calculate the total number of booked tickets
    public void countTotalTickets() {
        System.out.println("Total booked tickets: " + totalTickets);
    }
}

public class TicketReservationSystemApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TicketReservationSystem system = new TicketReservationSystem();

        // Menu options for the system
        while (true) {
            System.out.println("\nTicket Reservation System:");
            System.out.println("1. Add a Ticket Reservation");
            System.out.println("2. Remove a Ticket by Ticket ID");
            System.out.println("3. Display All Tickets");
            System.out.println("4. Search for a Ticket by Customer Name or Movie Name");
            System.out.println("5. Count Total Booked Tickets");
            System.out.println("6. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    // Add a new ticket reservation
                    System.out.print("Enter Ticket ID: ");
                    int ticketID = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter Customer Name: ");
                    String customerName = scanner.nextLine();
                    System.out.print("Enter Movie Name: ");
                    String movieName = scanner.nextLine();
                    System.out.print("Enter Seat Number: ");
                    String seatNumber = scanner.nextLine();
                    system.addTicket(ticketID, customerName, movieName, seatNumber);
                    break;

                case 2:
                    // Remove a ticket by Ticket ID
                    System.out.print("Enter Ticket ID to remove: ");
                    int removeTicketID = scanner.nextInt();
                    system.removeTicket(removeTicketID);
                    break;

                case 3:
                    // Display all tickets
                    system.displayTickets();
                    break;

                case 4:
                    // Search for a ticket by Customer Name or Movie Name
                    System.out.print("Enter Customer Name or Movie Name to search: ");
                    String searchTerm = scanner.nextLine();
                    system.searchTicket(searchTerm);
                    break;

                case 5:
                    // Count the total number of booked tickets
                    system.countTotalTickets();
                    break;

                case 6:
                    // Exit the system
                    System.out.println("Exiting the system...");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
