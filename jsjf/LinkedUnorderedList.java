package jsjf;

import jsjf.exceptions.*;

/**
 * LinkedUnorderedList represents a singly linked implementation of an 
 * unordered list.
 *
 * @author Java Foundations
 * @version 4.0
 */
public class LinkedUnorderedList<T> extends LinkedList<T> 
         implements UnorderedListADT<T>
{
    /**
     * Creates an empty list.
     */
    public LinkedUnorderedList()
    {
        super();
    }

    /**
     * Adds the specified element to the front of this list.
     *
     * @param element the element to be added to the list
	 */
    public void addToFront(T element)
    {
        if (isEmpty()) 
        {
           // If the list is empty, the new element becomes both the head and the tail
           head = tail = newNode;
        } 
        else 
        {
            newNode.setNext(head);
            head = newNode;
        }
   
       count++;
       modCount++;// To be completed as a Programming Project
    }
	
	/**
     * Adds the specified element to the rear of this list.
     *
     * @param element the element to be added to the list
	 */
    public void addToRear(T element)
    {
        LinearNode<T> newNode = new LinearNode<>(element);

       if (isEmpty()) 
       {
           // If the list is empty, the new element becomes both the head and the tail
           head = tail = newNode;
       } 
       else 
       {
           tail.setNext(newNode);
           tail = newNode;
       }
   
       count++;
       modCount++;// To be completed as a Programming Project
    }
	
	
    /**
     * Adds the specified element to this list after the given target.
     *
     * @param  element the element to be added to this list
	 * @param  target the target element to be added after
	 * @throws ElementNotFoundException if the target is not found
	 */
    public void addAfter(T element, T target) throws ElementNotFoundException 
    {
       LinearNode<T> newNode = new LinearNode<>(element);
       LinearNode<T> current = head;
       boolean found = false;
   
       while (current != null && !found) 
       {
           if (current.getElement().equals(target)) 
           {
               found = true;
           } 
           else 
           {
               current = current.getNext();
           }
       }
   
       if (found) 
       {
           newNode.setNext(current.getNext());
           current.setNext(newNode);
   
           if (current == tail) 
           {
               // If the target is the current tail, update the tail to the new element
               tail = newNode;
           }
   
           count++;
           modCount++;
       } 
       else 
       {
           throw new ElementNotFoundException("LinkedUnorderedList");
       }
    }
}
