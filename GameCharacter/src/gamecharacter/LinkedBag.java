package gamecharacter;

/**
 *
 * @author Joshua Klenk
 * @version 1.0
 */
public class LinkedBag<E extends Comparable<E>> {

    private Node<E> head;
    private Node<E> tail;
    private int numElements;

    public LinkedBag() {
        head = null;
        tail = null;
        numElements = 0;
    }

    /**
     * getSize returns the size of the this.
     *
     * @return numElements The amount of nodes in the list.
     */
    public int getSize() {
        return numElements;
    }

    public void add(E newElement) 
    {
        Node<E> newNode = new Node<>(newElement, null);

        if (head == null) 
        {
            // If the list is empty, make the new element the head.
            head = newNode;
        } 
        else if (newElement.compareTo(head.getData()) <= 0) 
        {
            // If the new element is less than or equal to the head, update the head.
            newNode.setNext(head);
            head = newNode;
        } 
        else 
        {
            Node<E> current = head;

            while (current.getNext() != null && newElement.compareTo(current.getData()) > 0) 
            {
                current = current.getNext();
            }

            newNode.setNext(current.getNext());
            current.setNext(newNode);
        }

        numElements++;
    }

    /**
     * Adds an element to the beginning of the list
     *
     * @param newElement The element to add
     */
    public void appendList(E newElement) {
        Node<E> newNode = new Node<>(newElement, null);

        if (head == null) {
            head = newNode;
        } else {
            Node<E> current = head;

            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newNode);
        }

        numElements++;
    }

    /**
     * Adds an element to the end of the list
     *
     * @param newElement The element to add
     */
    public void prependList(E newElement) {

        if (tail == null) {
            head = new Node(newElement, null);
            tail = head;
        } else {
            tail.setNext(new Node(newElement, null));
            tail = tail.getNext();
        }

        numElements++;

    }

    /**
     * Exists checks to see if a specific element exists in the list
     *
     * @param target the element to search for
     * @return true if the element is found in the list, false otherwise.
     */
    public boolean exists(E target) {
        boolean found = false;
        Node<E> cursor = head;

        while (cursor != null && !found) {
            if (cursor.getData().equals(target)) {
                found = true;
            } else {
                cursor = cursor.getNext();
            }
        }

        return found;
    }

    /**
     * Counts the occurrences of a specific element in the list.
     *
     * @param target the element to count.
     * @return The number of occurrences of the specific element
     */
    public int countOccurences(E target) {
        int count = 0;
        boolean found = false;
        Node<E> cursor = head;

        while (cursor != null && !found) {
            if (cursor.getData().equals(target)) {
                count++;
                cursor = cursor.getNext();
            } else {
                cursor = cursor.getNext();
            }
        }

        return count;
    }

    /**
     * The remove method removes the first occurrence of the specified target
     * from the list.
     *
     * @param target the object to be removed.
     * @return Returns true if the target was found & removed, otherwise false.
     */
    public boolean remove(E target) {

        Node<E> cursor = head, previous = null;
        boolean found = false;

        while (cursor != null && !found) {
            if (cursor.getData().equals(target)) {
                found = true;
            } else {
                previous = cursor;
                cursor = cursor.getNext();
            }
        }

        if (found && cursor != null) {
            if (previous == null) {
                head = head.getNext();
            } else {
                previous.setNext(cursor.getNext());
            }

            if (tail == cursor) {
                tail = previous;
            }

            numElements--;
        }
        return found;

    }

    /**
     * the iteratorPrototype method "copies" the linked list and passes the
     * copied linked list to a new Lister<E>
     *
     * @return a Lister<E> using a copy of the linked list
     */
    public Lister<E> iterator() {
        // declare variables
        Node headOfListToReturn; // beginning of new "copied" list
        Node cursorOfListToCopy; // active node of list to copy
        Node lastNodeOfListToReturn; // end of new "copied" list

        // establish the copied list
        headOfListToReturn = null;

        if (head != null) {
            // create the head of the new list
            headOfListToReturn = new Node(head.getData(), null);
            // use lastNodeOfListToReturn as a pointer to the last node in the copied list
            lastNodeOfListToReturn = headOfListToReturn;
            // use currentCursor as the pointer to the existing list
            cursorOfListToCopy = head.getNext();
            // if we have a node...
            while (cursorOfListToCopy != null) {
                // create a new node from the end of the new list
                lastNodeOfListToReturn.setNext(new Node(cursorOfListToCopy.getData(), null));
                // move lastNodeOfListToReturn to the new last node
                lastNodeOfListToReturn = lastNodeOfListToReturn.getNext();
                // move the cursorOfListToCopy to the next node
                cursorOfListToCopy = cursorOfListToCopy.getNext();
            }
        }
        return new Lister(headOfListToReturn);
    }
}
