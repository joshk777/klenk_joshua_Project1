package gamecharacter;
/**
 *
 * @author Joshua Klenk
 * @version 1.0
 */
public class Node <E>
{
    
    private E data;
    private Node<E> next;

    /**
     * Counstructs a generic node  with initialData and initialLink
     * 
     * @param initialData The initial data to be stored
     * @param initialLink The initial reference to the next node (link)
     */
    public Node(E initialData, Node<E> initialNext) 
    {
        data = initialData;
        next = initialNext;
    }

    /**
     * Get the object data stored in the node.
     * 
     * @return The data stored in this node.
     */
    public E getData() 
    {
        return data;
    }

    /**
     * getNext the reference to the next node 
     * 
     * @return The reference to the node(link)
     */
    public Node<E> getNext() 
    {
        return next;
    }

    /**
     * setData sets the object data in this node
     * 
     * @param data the string data to be stored
     */
    public void setData(E newData) 
    {
        data = newData;
    }

    /**
     * setNext the next node to be linked
     * 
     * @param next The reference to the next link
     */
    public void setNext(Node<E> newNext) 
    {
        next = newNext;
    }

    int compareTo(Object data) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
