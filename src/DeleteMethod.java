public class DoublyLinkedList {
    Node head;

    public DoublyLinkedList() {
        this.head = null;
    }

    // Method to add a node at the end of the list
    public void append(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
        newNode.prev = temp;
    }

    // Method to search for a value in the list
    public boolean search(int value) {
        Node temp = head;
        while (temp != null) {
            if (temp.data == value) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    // Method to delete a node with a specific value
    public void delete(int value) {
        if (head == null) {
            System.out.println("List is empty, cannot delete.");
            return;
        }

        Node temp = head;

        // Case 1: Deleting the head node
        if (temp.data == value) {
            head = temp.next;
            if (head != null) {
                head.prev = null;
            }
            return;
        }

        // Traverse the list to find the node to delete
        while (temp != null && temp.data != value) {
            temp = temp.next;
        }

        // Case 2: Node with value not found
        if (temp == null) {
            System.out.println("Value not found in the list.");
            return;
        }

        // Case 3: Deleting a node in the middle or end
        if (temp.next != null) {
            temp.next.prev = temp.prev;
        }

        if (temp.prev != null) {
            temp.prev.next = temp.next;
        }
    }

    // Method to display the list (for testing purposes)
    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();
        dll.append(10);
        dll.append(20);
        dll.append(30);
        dll.append(40);
        dll.append(50);

        System.out.println("List contents:");
        dll.display();

        int valueToDelete = 30;
        System.out.println("Deleting value " + valueToDelete + " from the list.");
        dll.delete(valueToDelete);
        System.out.println("List contents after deletion:");
        dll.display();

        valueToDelete = 10;
        System.out.println("Deleting value " + valueToDelete + " from the list.");
        dll.delete(valueToDelete);
        System.out.println("List contents after deletion:");
        dll.display();

        valueToDelete = 50;
        System.out.println("Deleting value " + valueToDelete + " from the list.");
        dll.delete(valueToDelete);
        System.out.println("List contents after deletion:");
        dll.display();
    }
}

