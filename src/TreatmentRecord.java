public class TreatmentRecord {
    private int patientId;
    private String patientName;
    private String treatmentDetails;
    private String dateCompleted;

    public TreatmentRecord(int patientId, String patientName, String treatmentDetails, String dateCompleted) {
        this.patientId = patientId;
        this.patientName = patientName;
        this.treatmentDetails = treatmentDetails;
        this.dateCompleted = dateCompleted;
    }

    public int getPatientId() {
        return patientId;
    }

    public String getPatientName() {
        return patientName;
    }

    public String getTreatmentDetails() {
        return treatmentDetails;
    }

    public String getDateCompleted() {
        return dateCompleted;
    }

    @Override
    public String toString() {
        return "Patient ID: " + patientId +
                ", Name: " + patientName +
                ", Treatment: " + treatmentDetails +
                ", Date: " + dateCompleted;
    }
}