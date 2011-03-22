/**
 * 
 * @author Team 42
 *
 * @param <E>
 */
public class DoubleLinkedList<E> {

   // Reference to list head.
   private Node<E> head = null;
   private Node<E> tail = null;

   // The number of items in the list
   private int size = 0;
   
   public void addFirst(E item) {
      if(size == 0) {
         head = new Node<E>(item);
         tail = head;
      } else if(size == 1) {
         head = new Node<E>(item, tail, tail);
         tail.next = head;
         tail.prev = head;
      } else {
         head = new Node<E>(item, head, tail);
         head.next.prev = head;
         tail.next = head;
      }
      size++;
   }
   
   public void addLast(E item) {
      if(size == 0) {
         head = new Node<E>(item);
         tail = head;
      } else if(size == 1) {
         tail = new Node<E>(item, head, head);
         head.next = tail;
         head.prev = tail;
      } else {
         tail = new Node<E>(item, head, tail);
         tail.prev.next = tail;
         head.prev = tail;
      }
      size++;
   }
   
   private void addAfter(Node<E> node, E item) {
      node.next = new Node<E>(item, node.next, node);
      node.next.next.prev = node.next;
      size++;
   }
   
   private E removeAfter(Node<E> node) {
      Node<E> temp = node.next;
      node.next = temp.next;
      node.next.prev = node;
      size--;
      
      return temp.data;
   }
   
   public E removeFirst() {
      Node<E> temp = head;
      head = head.next;
      head.prev = tail;
      tail.next = head;
      size--;
      
      return temp.data;
   }
   
   private Node<E> getNode(int index) {
      Node<E> node = head;
      for (int i=0; i<index-1; i++) {
         node = node.next;
      }
      return node;
   }
   
   public E get(int index) {
      if (index < 0 || index > size) {
         throw new IndexOutOfBoundsException(Integer.toString(index));
      }
      Node<E> node = getNode(index);
      return node.data;
   }
   
   public E set(int index, E newValue) {
      if (index < 0 || index > size) {
         throw new IndexOutOfBoundsException(Integer.toString(index));
      }
      Node<E> node = getNode(index);
      E result = node.data;
      node.data = newValue;
      return result;
   }
   
   public void add(int index, E item) {
      if (index < 0 || index > size) {
         throw new IndexOutOfBoundsException(Integer.toString(index));
      }
      if(index==0) {
         addFirst(item);
      } else {
         Node<E> node = getNode(index-1);
         addAfter(node, item);
      }
   }
   
   public boolean add(E item) {
      add(size, item);
      return true;
   }
   
   public void remove(int index) {
      if (index < 0 || index > size) {
         throw new IndexOutOfBoundsException(Integer.toString(index));
      }
      if(index==0) {
         removeFirst();
      } else {
         Node<E> node = getNode(index-1);
         removeAfter(node);
      }
   }
   
   public boolean remove() {
      remove(size);
      return true;
   }
   
   public String transverse() {
      Node<String> nodeRef = (Node<String>)head;
      StringBuilder result = new StringBuilder();
      for(int i=0; i<size; i++) {
         result.append(nodeRef.data);
         if (nodeRef.next != null) {
            result.append(" ");
         }
         nodeRef = nodeRef.next; // Advance down the list
      }
      return result.toString();
   }
   
   public void clear() {
      head = null;
      tail = null;
      size = 0;
   }
   
   public int getSize() {
      return size;
   }
}