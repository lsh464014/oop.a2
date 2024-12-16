import java.io.*;
import java.util.*;

/**
 * The {@code Ride} class implements the {@code RideInterface} and represents a ride at a theme park.
 */
public class Ride implements RideInterface {
    private String rideName;
    private int maxCapacity;
    private Employee employee;
    private Queue<Visitor> waitingQueue;
    private LinkedList<Visitor> visitors;
    private int maxRider;
    private int numOfCycles;

    /**
     * Default constructor for the {@code Ride} class. Initializes fields to default values.
     */
    public Ride() {
        this.rideName = "";
        this.maxCapacity = 0;
        this.employee = null;
        this.waitingQueue = new LinkedList<>();
        this.visitors = new LinkedList<>();
    }

    /**
     * Constructor that initializes the ride with a name, capacity, and assigned employee.
     *
     * @param rideName the name of the ride
     * @param maxCapacity the maximum capacity of the ride
     * @param employee the employee assigned to operate the ride
     */
    public Ride(String rideName, int maxCapacity, Employee employee) {
        this.rideName = rideName;
        this.maxCapacity = maxCapacity;
        this.employee = employee;
        this.waitingQueue = new LinkedList<>();
        this.visitors = new LinkedList<>();
    }

    /**
     * Gets the name of the ride.
     *
     * @return the name of the ride
     */
    public String getRideName() {
        return rideName;
    }

    /**
     * Sets the name of the ride.
     *
     * @param rideName the name of the ride
     */
    public void setRideName(String rideName) {
        this.rideName = rideName;
    }

    /**
     * Gets the maximum capacity of the ride.
     *
     * @return the maximum capacity of the ride
     */
    public int getMaxCapacity() {
        return maxCapacity;
    }

    /**
     * Sets the maximum capacity of the ride.
     *
     * @param maxCapacity the maximum capacity of the ride
     */
    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    /**
     * Gets the employee assigned to the ride.
     *
     * @return the employee assigned to operate the ride
     */
    public Employee getEmployee() {
        return employee;
    }

    /**
     * Sets the employee assigned to the ride.
     *
     * @param employee the employee to assign to the ride
     */
    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    /**
     * Gets the queue of visitors waiting for the ride.
     *
     * @return the queue of waiting visitors
     */
    public Queue<Visitor> getWaitingQueue() {
        return waitingQueue;
    }

    /**
     * Gets the list of visitors who have taken the ride.
     *
     * @return the list of visitors who have ridden the attraction
     */
    public LinkedList<Visitor> getVisitors() {
        return visitors;
    }

    /**
     * Gets the maximum number of riders that can be processed in one cycle.
     *
     * @return the maximum number of riders per cycle
     */
    public int getMaxRider() {
        return maxRider;
    }

    /**
     * Sets the maximum number of riders that can be processed in one cycle.
     *
     * @param maxRider the maximum number of riders per cycle
     */
    public void setMaxRider(int maxRider) {
        this.maxRider = maxRider;
    }

    /**
     * Gets the number of ride cycles completed.
     *
     * @return the number of cycles completed
     */
    public int getNumOfCycles() {
        return numOfCycles;
    }

    /**
     * Sorts the list of visitors based on a given comparator.
     *
     * @param visitors the list of visitors to be sorted
     * @param comparator the comparator to determine the sorting order
     */
    public void sortVisitors(List<Visitor> visitors, Comparator<Visitor> comparator) {
        Collections.sort(visitors, comparator);
    }

    /**
     * Exports the ride history (visitors) to a CSV file.
     *
     * @param filePath the path to the file to export the data
     */
    public void exportRideHistory(String filePath) {
        try {
            FileWriter writer = new FileWriter(filePath);
            Iterator<Visitor> it = this.visitors.iterator();
            while (it.hasNext()) {
                Visitor visitor = it.next();
                String msg = String.format("%s,%d,%s,%s,%s",
                        visitor.getName(), visitor.getAge(), visitor.getPhoneNumber(),
                        visitor.getTicketId(), visitor.getFavoriteAttraction()
                );

                writer.write(msg + System.lineSeparator());
                writer.flush();
            }
            writer.close();
            System.out.println("Export ride history successfully.");
        } catch (IOException e) {
            System.out.println("Export failed: " + e.getMessage());
        }
    }

    /**
     * Imports the ride history (visitors) from a CSV file.
     *
     * @param filePath the path to the file to import the data from
     */
    public void importRideHistory(String filePath) {
        try {
            Scanner sc = new Scanner(new File(filePath));
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                if (line.isBlank()) {
                    continue;
                }

                String[] parts = line.trim().split(",");
                if (parts.length == 5) {
                    String name = parts[0];
                    int age = Integer.parseInt(parts[1]);
                    String phone = parts[2];
                    String ticketId = parts[3];
                    String favoriteAttraction = parts[4];

                    this.visitors.add(new Visitor(name, age, phone, ticketId, favoriteAttraction));
                }
            }
            sc.close();
            System.out.println("Import ride history successfully.");
        } catch (Exception e) {
            System.out.println("Import failed: " + e.getMessage());
        }
    }

    /**
     * Adds a visitor to the ride's waiting queue.
     *
     * @param visitor the visitor to be added to the queue
     */
    @Override
    public void addVisitorToQueue(Visitor visitor) {
        if (visitor != null) {
            this.waitingQueue.offer(visitor);
            System.out.println("Add Visitor To Queue successfully. Visitor: " + visitor.getName());
            return;
        }

        System.out.println("Visitor is null.");
    }

    /**
     * Removes and returns the visitor at the front of the queue.
     *
     * @return the visitor removed from the queue, or {@code null} if the queue is empty
     */
    @Override
    public Visitor removeVisitorFromQueue() {
        if (waitingQueue.isEmpty()) {
            System.out.println("Waiting queue is empty.");
            return null;
        }

        Visitor visitor = waitingQueue.poll();
        System.out.println(visitor.getName() + " has been removed from the queue.");
        return visitor;
    }

    /**
     * Prints the details of all visitors currently in the waiting queue.
     */
    @Override
    public void printQueue() {
        if (waitingQueue.isEmpty()) {
            System.out.println("Waiting queue is empty.");
            return;
        }

        System.out.println("Waiting queue:");
        for (Visitor visitor : waitingQueue) {
            System.out.println(visitor);
        }
    }

    /**
     * Runs one cycle of the ride, processing up to the maximum number of riders.
     */
    @Override
    public void runOneCycle() {
        if (this.employee == null) {
            System.out.println("No operator assigned. Ride cannot be run.");
            return;
        }

        if (this.waitingQueue.isEmpty()) {
            System.out.println("There are no waiting visitors in the queue, the ride cannot be run.");
            return;
        }

        int removed = 0;
        while (!this.waitingQueue.isEmpty() && removed < this.maxRider) {
            Visitor visitor = removeVisitorFromQueue();
            removed++;
            addVisitorToHistory(visitor);
        }

        this.numOfCycles++;
        System.out.println("Ride one cycle completed.");
    }

    /**
     * Adds a visitor to the ride history after they have ridden the attraction.
     *
     * @param visitor the visitor to be added to the ride history
     */
    @Override
    public void addVisitorToHistory(Visitor visitor) {
        if (visitor != null) {
            this.visitors.add(visitor);
            System.out.println(visitor.getName() + " has taken the Ride.");
            return;
        }

        System.out.println("Visitor is null.");
    }

    /**
     * Checks if a visitor has already taken the ride.
     *
     * @param visitor the visitor to be checked
     * @return {@code true} if the visitor has taken the ride, otherwise {@code false}
     */
    @Override
    public boolean checkVisitorFromHistory(Visitor visitor) {
        if (visitor == null) {
            System.out.println("Visitor is null.");
            return false;
        }

        for (Visitor v : this.visitors) {
            if (v.getName().equals(visitor.getName())) {
                System.out.println(visitor.getName() + " has taken the Ride.");
                return true;
            }
        }

        System.out.println(visitor.getName() + " has not taken the Ride.");
        return false;
    }

    /**
     * Returns the number of visitors who have taken the ride.
     *
     * @return the number of visitors who have ridden the attraction
     */
    @Override
    public int numberOfVisitors() {
        int size = this.visitors.size();
        System.out.println(size + " of visitors has taken the Ride.");
        return size;
    }

    /**
     * Prints the ride history by displaying the list of visitors who have taken the ride.
     */
    @Override
    public void printRideHistory() {
        if (this.visitors.isEmpty()) {
            System.out.println("Ride history is empty.");
            return;
        }

        System.out.println("Ride history:");
        Iterator<Visitor> it = this.visitors.iterator();
        while (it.hasNext()) {
            Visitor visitor = it.next();
            System.out.println(visitor);
        }
    }
}
