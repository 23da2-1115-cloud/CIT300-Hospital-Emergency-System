import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        PatientBST patientBST = new PatientBST();
        EmergencyQueue emergencyQueue = new EmergencyQueue();
        TreatmentStack treatmentStack = new TreatmentStack();

        int choice;

        do {
            System.out.println("\n===== Mini Hospital Emergency Management System =====");
            System.out.println("1. Register new patient");
            System.out.println("2. Search patient by ID");
            System.out.println("3. Delete patient");
            System.out.println("4. Display all patients (in-order)");
            System.out.println("5. Add patient to emergency queue");
            System.out.println("6. Treat next patient (dequeue + push to stack)");
            System.out.println("7. Display waiting queue");
            System.out.println("8. Display treatment history (stack)");
            System.out.println("9. Add visit to patient history");
            System.out.println("10. Display patient visit history");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            choice = readInt(scanner);

            switch (choice) {
                case 1:
                    System.out.print("Enter Patient ID: ");
                    int id = readInt(scanner);
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Age: ");
                    int age = readInt(scanner);
                    System.out.print("Enter Contact Number: ");
                    String contact = scanner.nextLine();
                    System.out.print("Enter Medical Condition: ");
                    String condition = scanner.nextLine();

                    Patient newPatient = new Patient(id, name, age, contact, condition);
                    patientBST.insert(newPatient);
                    System.out.println("Patient registered successfully.");
                    break;

                case 2:
                    System.out.print("Enter Patient ID to search: ");
                    int searchId = readInt(scanner);
                    Patient found = patientBST.search(searchId);
                    if (found != null) {
                        System.out.println("Found: " + found);
                    } else {
                        System.out.println("Patient not found.");
                    }
                    break;

                case 3:
                    System.out.print("Enter Patient ID to delete: ");
                    int deleteId = readInt(scanner);
                    patientBST.delete(deleteId);
                    System.out.println("Delete operation completed.");
                    break;

                case 4:
                    patientBST.displayInOrder();
                    break;

                case 5:
                    System.out.print("Enter Patient ID to add to queue: ");
                    int queueId = readInt(scanner);
                    Patient patientForQueue = patientBST.search(queueId);
                    if (patientForQueue != null) {
                        emergencyQueue.enqueue(patientForQueue);
                    } else {
                        System.out.println("Patient not found in records. Register first.");
                    }
                    break;

                case 6:
                    Patient treated = emergencyQueue.dequeue();
                    if (treated != null) {
                        System.out.println("Now treating: " + treated);
                        System.out.print("Enter treatment details: ");
                        String details = scanner.nextLine();
                        System.out.print("Enter date completed: ");
                        String date = scanner.nextLine();

                        TreatmentRecord record = new TreatmentRecord(
                                treated.getPatientId(), treated.getName(), details, date);
                        treatmentStack.push(record);
                    }
                    break;

                case 7:
                    emergencyQueue.displayQueue();
                    break;

                case 8:
                    treatmentStack.displayStack();
                    break;

                case 9:
                    System.out.print("Enter Patient ID: ");
                    int visitPatientId = readInt(scanner);
                    Patient patientForVisit = patientBST.search(visitPatientId);
                    if (patientForVisit != null) {
                        System.out.print("Enter Visit ID: ");
                        int visitId = readInt(scanner);
                        System.out.print("Enter Visit Date: ");
                        String visitDate = scanner.nextLine();
                        System.out.print("Enter Doctor Name: ");
                        String doctorName = scanner.nextLine();
                        System.out.print("Enter Diagnosis: ");
                        String diagnosis = scanner.nextLine();
                        System.out.print("Enter Treatment: ");
                        String treatment = scanner.nextLine();

                        Visit visit = new Visit(visitId, visitDate, doctorName, diagnosis, treatment);
                        patientForVisit.getVisitHistory().addVisit(visit);
                        System.out.println("Visit added to patient history.");
                    } else {
                        System.out.println("Patient not found.");
                    }
                    break;

                case 10:
                    System.out.print("Enter Patient ID: ");
                    int historyId = readInt(scanner);
                    Patient patientForHistory = patientBST.search(historyId);
                    if (patientForHistory != null) {
                        patientForHistory.getVisitHistory().displayVisits();
                    } else {
                        System.out.println("Patient not found.");
                    }
                    break;

                case 0:
                    System.out.println("Exiting system. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 0);

        scanner.close();
    }

    // Helper method to safely read an integer and consume the leftover newline
    private static int readInt(Scanner scanner) {
        int value = Integer.parseInt(scanner.nextLine().trim());
        return value;
    }
}
