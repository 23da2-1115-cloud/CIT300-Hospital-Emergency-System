public class EmergencyQueue {

    // Inner class representing a single node in the queue
    private class Node {
        Patient patient;
        Node next;

        Node(Patient patient) {
            this.patient = patient;
            this.next = null;
        }
    }

    private Node front;
    private Node rear;
    private int size;

    public EmergencyQueue() {
        front = null;
        rear = null;
        size = 0;
    }

    // ---------- ENQUEUE ----------
    public void enqueue(Patient patient) {
        Node newNode = new Node(patient);

        if (rear == null) {
            front = newNode;
            rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        size++;
        System.out.println("Patient " + patient.getName() + " added to the emergency queue.");
    }

    // ---------- DEQUEUE ----------
    public Patient dequeue() {
        if (isEmpty()) {
            System.out.println("The emergency queue is empty. No patient to treat.");
            return null;
        }

        Patient treated = front.patient;
        front = front.next;

        if (front == null) {
            rear = null;
        }
        size--;
        return treated;
    }

    // ---------- EMPTY CHECK ----------
    public boolean isEmpty() {
        return front == null;
    }

    public int getSize() {
        return size;
    }

    // ---------- DISPLAY ----------
    public void displayQueue() {
        if (isEmpty()) {
            System.out.println("No patients currently waiting.");
            return;
        }

        System.out.println("Patients currently waiting:");
        Node current = front;
        int position = 1;
        while (current != null) {
            System.out.println(position + ". " + current.patient);
            current = current.next;
            position++;
        }
    }
}