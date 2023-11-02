package jsjf;

import jsjf.exceptions.*;

/**
 * LinkedOrderedList represents a singly linked implementation of an 
 * ordered list.
 *
 * @author Java Foundations
 * @version 4.0
 */
public class LinkedOrderedList<T> extends LinkedList<T> 
         implements OrderedListADT<T>
{
    /**
     * Creates an empty list.
     */
    public LinkedOrderedList()
    {
        super();
    }

    /**
     * Adds the specified element to this list at the location determined by
	 * the element's natural ordering. Throws a NonComparableElementException 
	 * if the element is not comparable.
     *
     * @param element the element to be added to this list
     * @throws NonComparableElementException if the element is not comparable
	 */
    public void add(T element) throws NonComparableElementException 
    {
       if (!(element instanceof Comparable)) 
       {
           throw new NonComparableElementException("LinkedOrderedList");
       }
   
       LinearNode<T> newNode = new LinearNode<>(element);
       LinearNode<T> current = head;
       LinearNode<T> previous = null;
   
       while (current != null && ((Comparable<T>) element).compareTo(current.getElement()) > 0) 
       {
           previous = current;
           current = current.getNext();
       }
   
       if (previous == null) 
       {
           // Element is smaller than the head, so it becomes the new head
           newNode.setNext(head);
           head = newNode;
       } 
       else 
       {
           // Insert the element between previous and current
           previous.setNext(newNode);
           newNode.setNext(current);
   
           if (current == null) 
           {
               // Element is larger than all elements in the list, so it becomes the new tail
               tail = newNode;
           }
       }
   
       count++;
       modCount++;
}
}
