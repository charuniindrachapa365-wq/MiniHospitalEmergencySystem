public class TreatmentRecord {

    int patientId;
    String patientName;
    String doctorName;
    String treatment;

    public TreatmentRecord(int patientId,
            String patientName,
            String doctorName,
            String treatment) {

        this.patientId = patientId;
        this.patientName = patientName;
        this.doctorName = doctorName;
        this.treatment = treatment;
    }

    public void displayTreatment() {

        System.out.println("------------------------------");
        System.out.println("Patient ID   : " + patientId);
        System.out.println("Patient Name : " + patientName);
        System.out.println("Doctor Name  : " + doctorName);
        System.out.println("Treatment    : " + treatment);
        System.out.println("------------------------------");
    }
}