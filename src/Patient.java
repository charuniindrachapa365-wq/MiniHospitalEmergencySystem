public class Patient {

    int patientId;
    String name;
    int age;
    String contactNumber;
    String medicalCondition;

    public Patient(int patientId, String name, int age,
                   String contactNumber, String medicalCondition) {

        this.patientId = patientId;
        this.name = name;
        this.age = age;
        this.contactNumber = contactNumber;
        this.medicalCondition = medicalCondition;
    }

    public void displayPatient() {
        System.out.println("------------------------------");
        System.out.println("Patient ID        : " + patientId);
        System.out.println("Patient Name      : " + name);
        System.out.println("Age               : " + age);
        System.out.println("Contact Number    : " + contactNumber);
        System.out.println("Medical Condition : " + medicalCondition);
        System.out.println("------------------------------");
    }
}