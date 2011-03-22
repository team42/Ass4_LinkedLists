/**
 * Implementation of a Node in a double linked list.
 * 
 * @author Team 42
 *
 * @param <E> Enumerator for this node, eg. String, int, etc.
 */

public class Node<E> {
   
   public E data; // E signifies what type of data to hold
   
   public Node<E> next = null; // Hold reference to next node
   public Node<E> prev = null; // Hold reference to previous node
   
   /**
    * Constructor creates a new node with next and prev references to itself.
    * Used when first creating a list.
    * 
    * @param dataItem Data to store in node
    */
   public Node(E dataItem) {
      data = dataItem;
      next = this;
      prev = this;
   }
   
   /**
    * This constructor creates a new node with proper references to next 
    * and previous nodes.
    * 
    * @param dataItem Data to store in node
    * @param nextNodeRef Next node reference
    * @param prevNodeRef Previous node reference
    */
   public Node(E dataItem, Node<E> nextNodeRef, Node<E> prevNodeRef) {
      data = dataItem;
      next = nextNodeRef;
      prev = prevNodeRef;
   }
}