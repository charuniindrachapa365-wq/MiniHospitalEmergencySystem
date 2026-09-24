class VisitNode {

    Visit visit;
    VisitNode next;

    public VisitNode(Visit visit) {
        this.visit = visit;
        this.next = null;
    }
}

public class VisitLinkedList {

    private VisitNode head;

    public VisitLinkedList() {
        head = null;
    }

    // Add a new visit
    public void addVisit(Visit visit) {

        VisitNode newNode = new VisitNode(visit);

        if (head == null) {
            head = newNode;
        } else {

            VisitNode current = head;

            while (current.next != null) {
                current = current.next;
            }

            current.next = newNode;
        }

        System.out.println("Visit added successfully.");
    }

    // Search visit using Visit ID
    public Visit searchVisit(int visitId) {

        VisitNode current = head;

        while (current != null) {

            if (current.visit.visitId == visitId) {
                return current.visit;
            }

            current = current.next;
        }

        return null;
    }

    // Remove a visit
    public void removeVisit(int visitId) {

        if (head == null) {
            System.out.println("Visit history is empty.");
            return;
        }

        // If first node is the visit
        if (head.visit.visitId == visitId) {

            head = head.next;

            System.out.println("Visit removed successfully.");
            return;
        }

        VisitNode current = head;

        while (current.next != null &&
                current.next.visit.visitId != visitId) {

            current = current.next;
        }

        if (current.next == null) {

            System.out.println("Visit not found.");

        } else {

            current.next = current.next.next;

            System.out.println("Visit removed successfully.");
        }
    }

    // Display all visits
    public void displayVisits() {

        if (head == null) {

            System.out.println("No visit history available.");
            return;
        }

        System.out.println("\n===== PATIENT VISIT HISTORY =====");

        VisitNode current = head;

        while (current != null) {

            current.visit.displayVisit();

            current = current.next;
        }
    }
}