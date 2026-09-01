public class VisitLinkedList {

    // Node representing one visit in the list
    private class Node {
        Visit visit;
        Node next;

        Node(Visit visit) {
            this.visit = visit;
            this.next = null;
        }
    }

    private Node head;
    private int size;

    public VisitLinkedList() {
        head = null;
        size = 0;
    }

    // ---------- ADD VISIT ----------
    public void addVisit(Visit visit) {
        Node newNode = new Node(visit);

        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    // ---------- REMOVE VISIT ----------
    public boolean removeVisit(int visitId) {
        if (head == null) {
            System.out.println("No visit history to remove from.");
            return false;
        }

        // If the head itself needs removing
        if (head.visit.getVisitId() == visitId) {
            head = head.next;
            size--;
            return true;
        }

        Node current = head;
        while (current.next != null) {
            if (current.next.visit.getVisitId() == visitId) {
                current.next = current.next.next;
                size--;
                return true;
            }
            current = current.next;
        }

        System.out.println("Visit ID " + visitId + " not found.");
        return false;
    }

    // ---------- SEARCH VISIT ----------
    public Visit searchVisit(int visitId) {
        Node current = head;
        while (current != null) {
            if (current.visit.getVisitId() == visitId) {
                return current.visit;
            }
            current = current.next;
        }
        return null; // not found
    }

    // ---------- DISPLAY ----------
    public void displayVisits() {
        if (head == null) {
            System.out.println("No visit history available.");
            return;
        }

        Node current = head;
        while (current != null) {
            System.out.println(current.visit);
            current = current.next;
        }
    }

    public int getSize() {
        return size;
    }
}