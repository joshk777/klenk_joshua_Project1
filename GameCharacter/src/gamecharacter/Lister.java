package gamecharacter;

import java.util.NoSuchElementException;

/**
 * inspired by Michael Main's Lister for Generic Linked Lists
 * this 'Lister' is for a String linked list
 * @author Stephen T. Brower<stephen.brower@raritanval.edu>
 */
public class Lister<E>
{
    private Node<E> cursor;

    /**
     * Constructor establishes cursor as the beginning of the
     * linked list
     * @param head points to a linked list of StringNodes
     */
    public Lister(Node<E> head)
    {
        /* note: this does not copy the underlying data.
           We are assuming that the iteratorPrototype() in StringLinkedBag
           copies the "data" */
        cursor = head;
    }

    /**
     * hasNext method indicates if the cursor is null or not
     * @return boolean that is true is cursor is not null, false otherwise
     */
    public boolean hasNext()
    {
        return cursor != null;
    }

    /**
     * next method gets the String from the current node and advances cursor
     * @return String from the "current" node
     */
    public E next()
    {
        E valueToReturn;

        if (!hasNext())
            throw new NoSuchElementException("The lister is empty");

        // get the string from the node
        valueToReturn = cursor.getData();

        // advance the cursor to the next node
        cursor = cursor.getNext();

        return valueToReturn;
    }

}
