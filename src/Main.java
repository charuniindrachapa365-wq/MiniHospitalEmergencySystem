import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    static class VisitHistory {
        private final Map<Integer, Visit> visits = new HashMap<>();

        public void addVisit(Visit visit) {
            if (visit == null) {
                return;
            }
            visits.put(visit.visitId, visit);
        }

        public Visit searchVisit(int visitId) {
            return visits.get(visitId);
        }

        public void removeVisit(int visitId) {
            if (visits.containsKey(visitId)) {
                visits.remove(visitId);
                System.out.println("Visit removed successfully.");
            } else {
                System.out.println("Visit not found.");
            }
        }

        public void displayVisits() {
            if (visits.isEmpty()) {
                System.out.println("No visits recorded.");
                return;
            }

            System.out.println("\n----- Visit History -----");
            for (Visit visit : visits.values()) {
                visit.displayVisit();
                System.out.println();
            }
        }
    }

    static Scanner scanner = new Scanner(System.in);

    static PatientBST patientBST = new PatientBST();
    static EmergencyQueue emergencyQueue = new EmergencyQueue();
    static TreatmentStack treatmentStack = new TreatmentStack();
    static Map<Integer, VisitHistory> patientVisitHistory = new HashMap<>();

    private static VisitHistory getVisitHistory(Patient patient) {
        if (patient == null) {
            return null;
        }
        return patientVisitHistory.computeIfAbsent(
                patient.patientId,
                id -> new VisitHistory());
    }

    public static void main(String[] args) {

        int choice;

        do {
            displayMenu();

            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:
                    registerPatient();
                    break;

                case 2:
                    searchPatient();
                    break;

                case 3:
                    deletePatient();
                    break;

                case 4:
                    patientBST.displayAllPatients();
                    break;

                case 5:
                    addEmergencyPatient();
                    break;

                case 6:
                    emergencyQueue.dequeue();
                    break;

                case 7:
                    emergencyQueue.displayQueue();
                    break;

                case 8:
                    addTreatmentRecord();
                    break;

                case 9:
                    treatmentStack.pop();
                    break;

                case 10:
                    treatmentStack.displayTreatments();
                    break;

                case 11:
                    addVisit();
                    break;

                case 12:
                    searchVisit();
                    break;

                case 13:
                    removeVisit();
                    break;

                case 14:
                    displayPatientVisits();
                    break;

                case 0:
                    System.out.println("\n==================================");
                    System.out.println("Thank you for using the system.");
                    System.out.println("==================================");
                    break;

                default:
                    System.out.println(
                            "Invalid choice. Please try again.");
            }

        } while (choice != 0);

        scanner.close();
    }

    // ==============================
    // MAIN MENU
    // ==============================

    public static void displayMenu() {

        System.out.println("\n==========================================");
        System.out.println(" MINI HOSPITAL EMERGENCY MANAGEMENT SYSTEM");
        System.out.println("==========================================");

        System.out.println("\n--- PATIENT RECORDS (BST) ---");
        System.out.println("1. Register New Patient");
        System.out.println("2. Search Patient");
        System.out.println("3. Delete Patient");
        System.out.println("4. Display All Patients");

        System.out.println("\n--- EMERGENCY PATIENT QUEUE ---");
        System.out.println("5. Add Patient to Emergency Queue");
        System.out.println("6. Treat Next Emergency Patient");
        System.out.println("7. Display Emergency Queue");

        System.out.println("\n--- TREATMENT HISTORY (STACK) ---");
        System.out.println("8. Add Completed Treatment");
        System.out.println("9. Remove Latest Treatment");
        System.out.println("10. Display Treatment History");

        System.out.println("\n--- PATIENT VISIT HISTORY ---");
        System.out.println("11. Add Patient Visit");
        System.out.println("12. Search Patient Visit");
        System.out.println("13. Remove Patient Visit");
        System.out.println("14. Display Patient Visit History");

        System.out.println("\n0. Exit");

        System.out.println("==========================================");
    }

    // ==============================
    // BST OPERATIONS
    // ==============================

    public static void registerPatient() {

        System.out.println("\n===== REGISTER NEW PATIENT =====");

        System.out.print("Enter Patient ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter Patient Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Age: ");
        int age = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter Contact Number: ");
        String contact = scanner.nextLine();

        System.out.print("Enter Medical Condition: ");
        String condition = scanner.nextLine();

        Patient patient = new Patient(
                id,
                name,
                age,
                contact,
                condition);

        patientBST.insert(patient);
    }

    public static void searchPatient() {

        System.out.println("\n===== SEARCH PATIENT =====");

        System.out.print("Enter Patient ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Patient patient = patientBST.search(id);

        if (patient == null) {
            System.out.println("Patient not found.");
        } else {
            System.out.println("\nPatient found successfully:");
            patient.displayPatient();
        }
    }

    public static void deletePatient() {

        System.out.println("\n===== DELETE PATIENT =====");

        System.out.print("Enter Patient ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        patientBST.delete(id);
    }

    // ==============================
    // QUEUE OPERATIONS
    // ==============================

    public static void addEmergencyPatient() {

        System.out.println("\n===== ADD EMERGENCY PATIENT =====");

        System.out.print("Enter Patient ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Patient patient = patientBST.search(id);

        if (patient == null) {

            System.out.println(
                    "Patient not found. Please register the patient first.");

        } else {

            emergencyQueue.enqueue(patient);
        }
    }

    // ==============================
    // STACK OPERATIONS
    // ==============================

    public static void addTreatmentRecord() {

        System.out.println("\n===== ADD COMPLETED TREATMENT =====");

        System.out.print("Enter Patient ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Patient patient = patientBST.search(id);

        if (patient == null) {
            System.out.println("Patient not found.");
            return;
        }

        System.out.print("Enter Doctor Name: ");
        String doctor = scanner.nextLine();

        System.out.print("Enter Treatment: ");
        String treatment = scanner.nextLine();

        TreatmentRecord record = new TreatmentRecord(
                patient.patientId,
                patient.name,
                doctor,
                treatment);

        treatmentStack.push(record);
    }

    // ==============================
    // LINKED LIST OPERATIONS
    // ==============================

    public static void addVisit() {

        System.out.println("\n===== ADD PATIENT VISIT =====");

        System.out.print("Enter Patient ID: ");
        int patientId = scanner.nextInt();
        scanner.nextLine();

        Patient patient = patientBST.search(patientId);

        if (patient == null) {
            System.out.println("Patient not found.");
            return;
        }

        System.out.print("Enter Visit ID: ");
        int visitId = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter Visit Date: ");
        String date = scanner.nextLine();

        System.out.print("Enter Doctor Name: ");
        String doctor = scanner.nextLine();

        System.out.print("Enter Diagnosis: ");
        String diagnosis = scanner.nextLine();

        System.out.print("Enter Treatment: ");
        String treatment = scanner.nextLine();

        Visit visit = new Visit(
                visitId,
                date,
                doctor,
                diagnosis,
                treatment);

        VisitHistory visitHistory = getVisitHistory(patient);
        visitHistory.addVisit(visit);
    }

    public static void searchVisit() {

        System.out.println("\n===== SEARCH PATIENT VISIT =====");

        System.out.print("Enter Patient ID: ");
        int patientId = scanner.nextInt();
        scanner.nextLine();

        Patient patient = patientBST.search(patientId);

        if (patient == null) {
            System.out.println("Patient not found.");
            return;
        }

        System.out.print("Enter Visit ID: ");
        int visitId = scanner.nextInt();
        scanner.nextLine();

        VisitHistory visitHistory = getVisitHistory(patient);
        Visit visit = visitHistory.searchVisit(visitId);

        if (visit == null) {

            System.out.println("Visit not found.");

        } else {

            System.out.println("\nVisit found successfully:");
            visit.displayVisit();
        }
    }

    public static void removeVisit() {

        System.out.println("\n===== REMOVE PATIENT VISIT =====");

        System.out.print("Enter Patient ID: ");
        int patientId = scanner.nextInt();
        scanner.nextLine();

        Patient patient = patientBST.search(patientId);

        if (patient == null) {
            System.out.println("Patient not found.");
            return;
        }

        System.out.print("Enter Visit ID: ");
        int visitId = scanner.nextInt();
        scanner.nextLine();

        VisitHistory visitHistory = getVisitHistory(patient);
        visitHistory.removeVisit(visitId);
    }

    public static void displayPatientVisits() {

        System.out.println("\n===== PATIENT VISIT HISTORY =====");

        System.out.print("Enter Patient ID: ");
        int patientId = scanner.nextInt();
        scanner.nextLine();

        Patient patient = patientBST.search(patientId);

        if (patient == null) {

            System.out.println("Patient not found.");

        } else {

            System.out.println(
                    "\nVisit History of " + patient.name);

            VisitHistory visitHistory = getVisitHistory(patient);
            visitHistory.displayVisits();
        }
    }
}