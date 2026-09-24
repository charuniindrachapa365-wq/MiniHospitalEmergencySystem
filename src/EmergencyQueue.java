class QueueNode {

    Patient patient;
    QueueNode next;

    public QueueNode(Patient patient) {
        this.patient = patient;
        this.next = null;
    }
}

public class EmergencyQueue {

    private QueueNode front;
    private QueueNode rear;

    public EmergencyQueue() {
        front = null;
        rear = null;
    }

    // Check whether queue is empty
    public boolean isEmpty() {
        return front == null;
    }

    // Add patient to emergency queue
    public void enqueue(Patient patient) {

        QueueNode newNode = new QueueNode(patient);

        if (rear == null) {
            front = newNode;
            rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }

        System.out.println(
                patient.name + " added to the emergency queue successfully.");
    }

    // Remove next patient for treatment
    public Patient dequeue() {

        if (isEmpty()) {
            System.out.println("Emergency queue is empty.");
            return null;
        }

        Patient patient = front.patient;

        front = front.next;

        // If queue becomes empty
        if (front == null) {
            rear = null;
        }

        System.out.println(
                patient.name + " is now sent for treatment.");

        return patient;
    }

    // Display all waiting patients
    public void displayQueue() {

        if (isEmpty()) {
            System.out.println("Emergency queue is empty.");
            return;
        }

        System.out.println("\n===== EMERGENCY WAITING QUEUE =====");

        QueueNode current = front;
        int position = 1;

        while (current != null) {

            System.out.println(
                    position +
                            ". Patient ID: " + current.patient.patientId +
                            " | Name: " + current.patient.name +
                            " | Condition: " + current.patient.medicalCondition);

            current = current.next;
            position++;
        }
    }
}