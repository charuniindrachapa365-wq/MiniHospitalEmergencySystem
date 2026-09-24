class StackNode {

    TreatmentRecord record;
    StackNode next;

    public StackNode(TreatmentRecord record) {
        this.record = record;
        this.next = null;
    }
}

public class TreatmentStack {

    private StackNode top;

    public TreatmentStack() {
        top = null;
    }

    // Check whether stack is empty
    public boolean isEmpty() {
        return top == null;
    }

    // Add completed treatment record
    public void push(TreatmentRecord record) {

        StackNode newNode = new StackNode(record);

        newNode.next = top;
        top = newNode;

        System.out.println(
                "Treatment record added successfully.");
    }

    // Remove most recently completed treatment
    public TreatmentRecord pop() {

        if (isEmpty()) {
            System.out.println("Treatment history is empty.");
            return null;
        }

        TreatmentRecord record = top.record;

        top = top.next;

        System.out.println(
                "Most recent treatment record removed.");

        return record;
    }

    // Display all treatment records
    public void displayTreatments() {

        if (isEmpty()) {
            System.out.println("Treatment history is empty.");
            return;
        }

        System.out.println("\n===== TREATMENT HISTORY =====");

        StackNode current = top;

        while (current != null) {

            current.record.displayTreatment();

            current = current.next;
        }
    }
}