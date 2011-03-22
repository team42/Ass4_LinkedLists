/**
 * A implementation of a circular double-linked list using classes for nodes.
 * 
 * Ideas and some code taken from the book
 * "Data Structures - Abstraction and Design Using Java" by Koffman & Wolfgang
 * 
 * @author Team 42
 * 
 * @param <E> Enumerator for this lists, eg. String, int, etc.
 */
public class DoubleLinkedList<E> {

   private Node<E> head = null; // Reference to list head
   private Node<E> tail = null; // Reference to list tail

   // The number of items in the list
   private int size = 0;

   /**
    * Add a node to the front of the list. If this is the first node to be added
    * we add it as head. If its the second node we add it as tail. Otherwise we
    * add the node as new head.
    * 
    * @param item Data to store in node
    */
   public void addFirst(E item) {
      if (size == 0) {
         head = new Node<E>(item);
         tail = head;
      } else if (size == 1) {
         head = new Node<E>(item, tail, tail);
         tail.next = head;
         tail.prev = head;
      } else {
         head = new Node<E>(item, head, tail);
         head.next.prev = head;
         tail.next = head;
      }
      size++; // Increment size of list
   }

   /**
    * Add node to end of list. If this is the first node to be added to the
    * list, we add it as head. If its the second, we add it as tail. Otherwise
    * add the node as new tail.
    * 
    * @param item Data to store in node
    */
   public void addLast(E item) {
      if (size == 0) {
         head = new Node<E>(item);
         tail = head;
      } else if (size == 1) {
         tail = new Node<E>(item, head, head);
         head.next = tail;
         head.prev = tail;
      } else {
         tail = new Node<E>(item, head, tail);
         tail.prev.next = tail;
         head.prev = tail;
      }
      size++; // Increment size of list
   }

   /**
    * Insert new node after given Node.
    * 
    * @param node Reference to the node we want to add a new node after
    * @param item Data to store in node
    */
   private void addAfter(Node<E> node, E item) {
      node.next = new Node<E>(item, node.next, node);
      node.next.next.prev = node.next;
      size++;
   }

   /**
    * Removes node after given Node.
    * 
    * @param node The node before the one to remove 
    * @return Returns data from removed node
    */
   private E removeAfter(Node<E> node) {
      Node<E> temp = node.next;
      node.next = temp.next;
      node.next.prev = node;
      size--;

      return temp.data;
   }

   /**
    * We need this method to remove first node (head).
    * 
    * @return Returns data from old head
    */
   public E removeFirst() {
      Node<E> temp = head;
      head = head.next;
      head.prev = tail;
      tail.next = head;
      size--;

      return temp.data;
   }

   /**
    * Returns the node at given index.
    * 
    * @param index Position of node to look for
    * @return Node at given index
    */
   private Node<E> getNode(int index) {
      Node<E> node = head;
      for (int i = 0; i < index - 1; i++) {
         node = node.next;
      }
      return node;
   }

   /**
    * Getter for finding specific node.
    * Uses getNode() for list traversal.
    * 
    * @param index Position of node to look for
    * @return Node at given index
    */
   public E get(int index) {
      if (index < 0 || index > size) {
         throw new IndexOutOfBoundsException(Integer.toString(index));
      }
      Node<E> node = getNode(index);
      return node.data;
   }

   /**
    * Setter for setting new value for node at given index.
    * 
    * @param index Position of node to set
    * @param newValue New data to store in node
    * @return Old value of data
    */
   public E set(int index, E newValue) {
      if (index < 0 || index > size) {
         throw new IndexOutOfBoundsException(Integer.toString(index));
      }
      Node<E> node = getNode(index);
      E result = node.data;
      node.data = newValue;
      return result;
   }

   /**
    * Adds a new node to list. Uses addFirst(), getNode() and addLast()
    * depending on whether this is first, second or third node to be added.
    * 
    * @param index Position to add node
    * @param item Data to store in node
    */
   public void add(int index, E item) {
      if (index < 0 || index > size) {
         throw new IndexOutOfBoundsException(Integer.toString(index));
      }
      if (index == 0) {
         addFirst(item);
      } else {
         Node<E> node = getNode(index - 1);
         addAfter(node, item);
      }
   }

   /**
    * If no index is given to simply add the node to the end of the list.
    * 
    * @param item Data to store in node
    * @return true
    */
   public boolean add(E item) {
      add(size, item);
      return true;
   }

   /**
    * Remover for removing a node at given index.
    * 
    * @param index Position of node to remove
    */
   public void remove(int index) {
      if (index < 0 || index > size) {
         throw new IndexOutOfBoundsException(Integer.toString(index));
      }
      if (index == 0) {
         removeFirst();
      } else {
         Node<E> node = getNode(index - 1);
         removeAfter(node);
      }
   }

   /**
    * Removes last node in list
    * 
    * @return true
    */
   public boolean remove() {
      remove(size);
      return true;
   }

   /**
    * Traverses entire list and returns concatenated values of the nodes data.
    * 
    * @return Concatenated values of all the nodes data
    */
   public String transverse() {
      Node<String> nodeRef = (Node<String>) head;
      StringBuilder result = new StringBuilder();
      for (int i = 0; i < size; i++) {
         result.append(nodeRef.data);
         if (nodeRef.next != null) {
            result.append(" ");
         }
         nodeRef = nodeRef.next; // Advance down the list
      }
      return result.toString();
   }

   /**
    * Reset list
    * 
    */
   public void clear() {
      head = null;
      tail = null;
      size = 0;
   }

   /**
    * Returns current size of list.
    * 
    * @return current size of list
    */
   public int getSize() {
      return size;
   }
}