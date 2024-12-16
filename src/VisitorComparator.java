import java.util.Comparator;

/**
 * The {@code VisitorComparator} class implements the {@link Comparator} interface
 * to compare two {@link Visitor} objects. The comparison is performed first by the ticket ID
 * and if they are equal, then by the name of the visitor.
 */
public class VisitorComparator implements Comparator<Visitor> {
    @Override
    public int compare(Visitor v1, Visitor v2) {
        int ticketComparison = v1.getTicketId().compareToIgnoreCase(v2.getTicketId());
        if (ticketComparison != 0) {
            return ticketComparison;
        }
        return v1.getName().compareTo(v2.getName());
    }
}
