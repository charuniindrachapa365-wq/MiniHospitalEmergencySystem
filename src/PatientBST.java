class PatientNode {
    Patient patient;
    PatientNode left;
    PatientNode right;

    public PatientNode(Patient patient) {
        this.patient = patient;
        this.left = null;
        this.right = null;
    }
}

public class PatientBST {

    private PatientNode root;

    // Insert a new patient
    public void insert(Patient patient) {
        root = insertRecursive(root, patient);
    }

    private PatientNode insertRecursive(PatientNode current, Patient patient) {

        if (current == null) {
            System.out.println("Patient registered successfully.");
            return new PatientNode(patient);
        }

        if (patient.patientId < current.patient.patientId) {
            current.left = insertRecursive(current.left, patient);

        } else if (patient.patientId > current.patient.patientId) {
            current.right = insertRecursive(current.right, patient);

        } else {
            System.out.println("Patient ID already exists.");
        }

        return current;
    }

    // Search patient using Patient ID
    public Patient search(int patientId) {

        PatientNode result = searchRecursive(root, patientId);

        if (result == null) {
            return null;
        }

        return result.patient;
    }

    private PatientNode searchRecursive(PatientNode current, int patientId) {

        if (current == null) {
            return null;
        }

        if (patientId == current.patient.patientId) {
            return current;
        }

        if (patientId < current.patient.patientId) {
            return searchRecursive(current.left, patientId);
        }

        return searchRecursive(current.right, patientId);
    }

    // Delete patient
    public void delete(int patientId) {

        if (search(patientId) == null) {
            System.out.println("Patient not found.");
            return;
        }

        root = deleteRecursive(root, patientId);

        System.out.println("Patient deleted successfully.");
    }

    private PatientNode deleteRecursive(PatientNode current, int patientId) {

        if (current == null) {
            return null;
        }

        if (patientId < current.patient.patientId) {

            current.left = deleteRecursive(current.left, patientId);

        } else if (patientId > current.patient.patientId) {

            current.right = deleteRecursive(current.right, patientId);

        } else {

            // No child or only right child
            if (current.left == null) {
                return current.right;
            }

            // Only left child
            if (current.right == null) {
                return current.left;
            }

            // Two children
            PatientNode smallestNode = findSmallest(current.right);

            current.patient = smallestNode.patient;

            current.right = deleteRecursive(
                    current.right,
                    smallestNode.patient.patientId);
        }

        return current;
    }

    private PatientNode findSmallest(PatientNode node) {

        while (node.left != null) {
            node = node.left;
        }

        return node;
    }

    // Display patients in ascending Patient ID order
    public void displayAllPatients() {

        if (root == null) {
            System.out.println("No patient records available.");
            return;
        }

        System.out.println("\n===== PATIENT RECORDS =====");

        inOrderTraversal(root);
    }

    private void inOrderTraversal(PatientNode node) {

        if (node != null) {

            inOrderTraversal(node.left);

            node.patient.displayPatient();

            inOrderTraversal(node.right);
        }
    }
}