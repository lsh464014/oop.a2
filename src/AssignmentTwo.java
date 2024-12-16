/**
 * The AssignmentTwo class is a simulation of an amusement park ride system with various functionalities.
 */
public class AssignmentTwo {
    /**
     * Main method that executes the different parts of the simulation.
     * It calls methods representing different scenarios in the amusement park ride system.
     *
     * @param args Command-line arguments.
     */
    public static void main(String[] args) {
        AssignmentTwo test = new AssignmentTwo();
        test.partThree();
        test.partFourA();
        test.partFourB();
        test.partFive();
        test.partSix();
        test.partSeven();
    }

    /**
     * Demonstrates adding visitors to a ride's queue, removing a visitor, and printing the queue.
     */
    public void partThree(){
        Employee employee = new Employee("e1", 20, "11111111", 1000.0, true);
        Ride ride = new Ride("Ferris Wheel", 5, employee);

        ride.addVisitorToQueue(new Visitor("Alice", 25, "555-111-2222",
                "TICKET001", "Ferris Wheel"));
        ride.addVisitorToQueue(new Visitor("Bob", 30, "555-333-4444",
                "TICKET002", "Roller Coaster"));
        ride.addVisitorToQueue(new Visitor("Charlie", 28, "555-555-6666",
                "TICKET003", "Water Ride"));
        ride.addVisitorToQueue(new Visitor("Diana", 22, "555-777-8888",
                "TICKET004", "Haunted House"));
        ride.addVisitorToQueue(new Visitor("Eve", 35, "555-999-0000",
                "TICKET005", "Carousel"));

        ride.removeVisitorFromQueue();

        ride.printQueue();
    }

    /**
     * Demonstrates adding visitors to the ride history, checking if a visitor is in history,
     * counting the visitors, and printing the ride history.
     */
    public void partFourA(){
        Employee employee = new Employee("e1", 20, "11111111", 1000.0, true);
        Ride ride = new Ride("Ferris Wheel", 5, employee);

        ride.addVisitorToHistory(new Visitor("Alice", 25, "555-111-2222",
                "TICKET001", "Ferris Wheel"));
        ride.addVisitorToHistory(new Visitor("Bob", 30, "555-333-4444",
                "TICKET002", "Roller Coaster"));
        ride.addVisitorToHistory(new Visitor("Charlie", 28, "555-555-6666",
                "TICKET003", "Water Ride"));
        ride.addVisitorToHistory(new Visitor("Diana", 22, "555-777-8888",
                "TICKET004", "Haunted House"));
        ride.addVisitorToHistory(new Visitor("Eve", 35, "555-999-0000",
                "TICKET005", "Carousel"));

        boolean isOK = ride.checkVisitorFromHistory(new Visitor("Alice", 25, "555-111-2222",
                "TICKET001", "Ferris Wheel"));

        ride.numberOfVisitors();

        ride.printRideHistory();
    }

    /**
     * Demonstrates adding visitors to the ride history, sorting visitors, and printing the ride history before and after sorting.
     */
    public void partFourB(){
        Employee employee = new Employee("e1", 20, "11111111", 1000.0, true);
        Ride ride = new Ride("Ferris Wheel", 5, employee);

        ride.addVisitorToHistory(new Visitor("Alice", 25, "555-111-2222",
                "TICKET003", "Ferris Wheel"));
        ride.addVisitorToHistory(new Visitor("Bob", 30, "555-333-4444",
                "TICKET002", "Roller Coaster"));
        ride.addVisitorToHistory(new Visitor("Charlie", 28, "555-555-6666",
                "TICKET001", "Water Ride"));
        ride.addVisitorToHistory(new Visitor("Diana", 22, "555-777-8888",
                "TICKET005", "Haunted House"));
        ride.addVisitorToHistory(new Visitor("Eve", 35, "555-999-0000",
                "TICKET004", "Carousel"));

        ride.printRideHistory();

        ride.sortVisitors(ride.getVisitors(), new VisitorComparator());

        ride.printRideHistory();
    }

    /**
     * Demonstrates adding visitors to a ride queue, running a ride cycle, and printing the queue and ride history.
     */
    public void partFive(){
        Employee employee = new Employee("e1", 20, "11111111", 1000.0, true);
        Ride ride = new Ride("Ferris Wheel", 5, employee);
        ride.setMaxRider(4);

        for (int i = 1; i <= 10; i++) {
            Visitor visitor = new Visitor(
                    "Visitor " + i,
                    20 + i,
                    "555-000-000" + i,
                    "TICKET" + i,
                    "Roller Coaster"
            );
            ride.addVisitorToQueue(visitor);
        }

        ride.printQueue();

        ride.runOneCycle();

        ride.printQueue();

        ride.printRideHistory();
    }

    /**
     * Demonstrates adding visitors to the ride history and exporting the ride history to a CSV file.
     */
    public void partSix(){
        Employee employee = new Employee("e1", 20, "11111111", 1000.0, true);
        Ride ride = new Ride("Ferris Wheel", 5, employee);

        ride.addVisitorToHistory(new Visitor("Alice", 25, "555-111-2222",
                "TICKET003", "Ferris Wheel"));
        ride.addVisitorToHistory(new Visitor("Bob", 30, "555-333-4444",
                "TICKET002", "Roller Coaster"));
        ride.addVisitorToHistory(new Visitor("Charlie", 28, "555-555-6666",
                "TICKET001", "Water Ride"));
        ride.addVisitorToHistory(new Visitor("Diana", 22, "555-777-8888",
                "TICKET005", "Haunted House"));
        ride.addVisitorToHistory(new Visitor("Eve", 35, "555-999-0000",
                "TICKET004", "Carousel"));

        ride.exportRideHistory("RideHistory.csv");
    }

    /**
     * Demonstrates importing the ride history from a CSV file and printing the ride history.
     */
    public void partSeven(){
        Employee employee = new Employee("e1", 20, "11111111", 1000.0, true);
        Ride ride = new Ride("Ferris Wheel", 5, employee);

        ride.importRideHistory("RideHistory.csv");

        ride.numberOfVisitors();

        ride.printRideHistory();
    }
}
