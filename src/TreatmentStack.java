public class TreatmentStack {

    // Inner class representing a single node in the stack
    private class Node {
        TreatmentRecord record;
        Node next;

        Node(TreatmentRecord record) {
            this.record = record;
            this.next = null;
        }
    }

    private Node top;
    private int size;

    public TreatmentStack() {
        top = null;
        size = 0;
    }

    // ---------- PUSH ----------
    public void push(TreatmentRecord record) {
        Node newNode = new Node(record);
        newNode.next = top;
        top = newNode;
        size++;
        System.out.println("Treatment record added for patient ID " + record.getPatientId());
    }

    // ---------- POP ----------
    public TreatmentRecord pop() {
        if (isEmpty()) {
            System.out.println("No treatment records available. Stack is empty.");
            return null;
        }

        TreatmentRecord removed = top.record;
        top = top.next;
        size--;
        return removed;
    }

    // ---------- EMPTY CHECK ----------
    public boolean isEmpty() {
        return top == null;
    }

    public int getSize() {
        return size;
    }

    // ---------- DISPLAY ----------
    public void displayStack() {
        if (isEmpty()) {
            System.out.println("No treatment records to display.");
            return;
        }

        System.out.println("Treatment history (most recent first):");
        Node current = top;
        while (current != null) {
            System.out.println(current.record);
            current = current.next;
        }
    }
}
