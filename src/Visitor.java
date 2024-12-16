/**
 * The {@code Visitor} class represents a visitor in the theme park.
 * It extends the {@link Person} class and adds additional attributes such as ticket ID and favorite attraction.
 */
public class Visitor extends Person {
    private String ticketId;
    private String favoriteAttraction;

    /**
     * Default constructor that initializes the visitor's attributes to default values.
     */
    public Visitor() {
        super();
        this.ticketId = "";
        this.favoriteAttraction = "";
    }

    /**
     * Constructor that initializes the visitor's attributes with the specified values.
     *
     * @param name the name of the visitor
     * @param age the age of the visitor
     * @param phoneNumber the phone number of the visitor
     * @param ticketId the ticket ID of the visitor
     * @param favoriteAttraction the favorite attraction of the visitor
     */
    public Visitor(String name, int age, String phoneNumber,
                   String ticketId, String favoriteAttraction) {
        super(name, age, phoneNumber);
        this.ticketId = ticketId;
        this.favoriteAttraction = favoriteAttraction;
    }

    /**
     * Gets the ticket ID of the visitor.
     *
     * @return the ticket ID of the visitor
     */
    public String getTicketId() {
        return ticketId;
    }

    /**
     * Sets the ticket ID of the visitor.
     *
     * @param ticketId the new ticket ID of the visitor
     */
    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    /**
     * Gets the favorite attraction of the visitor.
     *
     * @return the favorite attraction of the visitor
     */
    public String getFavoriteAttraction() {
        return favoriteAttraction;
    }

    /**
     * Sets the favorite attraction of the visitor.
     *
     * @param favoriteAttraction the new favorite attraction of the visitor
     */
    public void setFavoriteAttraction(String favoriteAttraction) {
        this.favoriteAttraction = favoriteAttraction;
    }

    /**
     * Returns a string representation of the visitor, including the details from the {@link Person}
     * class (name, age, and phone number), as well as the ticket ID and favorite attraction.
     *
     * @return a string representation of the visitor
     */
    @Override
    public String toString() {
        return String.format("Name=%s, Age=%d, Phone=%s, TicketID=%s, FavoriteAttraction=%s",
                getName(), getAge(), getPhoneNumber(),
                getTicketId(), getFavoriteAttraction());
    }
}
