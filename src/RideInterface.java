/**
 * The {@code RideInterface} defines the basic operations for managing a ride at a theme park.
 * It includes operations to handle the queue of visitors waiting for the ride, manage the
 * ride history, and simulate the execution of a ride cycle.
 */
public interface RideInterface {
    /**
     * Adds a visitor to the queue for the ride.
     *
     * @param visitor the visitor to be added to the queue
     */
    void addVisitorToQueue(Visitor visitor);

    /**
     * Removes a visitor from the front of the queue.
     *
     * @return the visitor removed from the queue, or {@code null} if the queue is empty
     */
    Visitor removeVisitorFromQueue();

    /**
     * Prints the details of all visitors currently in the queue.
     */
    void printQueue();

    /**
     * Simulates running one cycle of the ride. The ride may process visitors from the queue
     * and perform necessary actions related to the ride's operation.
     */
    void runOneCycle();

    /**
     * Adds a visitor to the ride history. This method records the visitor's ride experience
     * after they have taken the ride.
     *
     * @param visitor the visitor to be added to the ride history
     */
    void addVisitorToHistory(Visitor visitor);

    /**
     * Checks if a visitor is already in the ride history.
     *
     * @param visitor the visitor to be checked
     * @return {@code true} if the visitor is in the ride history, otherwise {@code false}
     */
    boolean checkVisitorFromHistory(Visitor visitor);

    /**
     * Returns the number of visitors who have taken the ride.
     *
     * @return the number of visitors in the ride history
     */
    int numberOfVisitors();

    /**
     * Prints the details of all visitors in the ride history.
     */
    void printRideHistory();
}
