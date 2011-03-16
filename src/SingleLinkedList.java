
public class SingleLinkedList<E> {
	private Node<E> head = null;
	private int size;
	
	/**
	 * Add node to the front of list.
	 * 
	 * @param data
	 */
	public void addFirst(E data) {
		head = new Node<E>(data, head);
		size++;
	}
	
	/**
	 * We need this method to remove first node (head).
	 * 
	 * @return
	 */
	private E removeFirst() {
		Node<E> temp = head;
		
		if (head != null) {
			head = head.next; // head is now next node
		}
		
		if (temp != null) {
			size--;
			return temp.data;
		} else {
			return null;
		}
	}
	
	/**
	 * Insert new node after given Node.
	 * 
	 * Specialized example:
	 * Node<String> bob = new Node<String>("Bob");
	 * bob.next = harry.next;
	 * harry.next = bob;
	 * 
	 * @param node Node to insert
	 * @param data 
	 */
	private void addAfter(Node<E> node, E data) {
		node.next = new Node<E>(data, node.next);
		size++;
	}
	
	/**
	 * Removes node after give Node.
	 * 
	 * @param node The node before the one to be removed
	 * @return Returns data from removed node
	 */
	private E removeAfter(Node<E> node) {
		Node<E> temp = node.next;
		if (temp != null) {
			node.next = temp.next;
			size--;
			return temp.data;
		} else {
			return null;
		}
	}
	
	/**
	 * Find node at given index (position)
	 * 
	 * @param index Position of node to look for
	 * @return Node at given index
	 */
	private Node<E> getNode(int index) {
		Node<E> node = head;
		for(int i= 0;i<index;i++) {
			node = node.next;
		}
		return node;
	}
	/**
	 * Inner class implementation of a Node in a linked list.
	 * 
	 * @author lasse
	 *
	 * @param <E>
	 */
	private static class Node<E> {
		private E data; // Use to hold data in list (String, int, etc...)
		private Node<E> next; // Use to reference next node
		
		private Node(E dataItem) {
			data = dataItem;
			next = null;
		}
		
		/**
		 * Constructor creates a new node with next reference.
		 * 
		 * @param dataItem Holds data to put into node
		 * @param nodeRef Reference to next node
		 */
		private Node(E dataItem, Node<E> nodeRef) {
			data = dataItem;
			next = nodeRef;
		}		
	}

	/**
	 * Traverse list and print out values.
	 * 
	 * 1. set nodeRef to reference first node
	 * 2. while nodeRef is not null
	 * 3. 	Do something with node referenced by nodeRef
	 * 4.	Set nodeRef to nodeRef.next
	 * 
	 */
	public void traverseList() {
		Node<String> nodeRef = (Node<String>) head;
		while(nodeRef != null) {
			System.out.print(nodeRef.data + "==>");
			nodeRef = nodeRef.next;
		}
		System.out.println();
	}
	
	/**
	 * Getter for finding specific node.
	 * Uses getNode() to traverse list.
	 * 
	 * @param index 
	 * @return
	 */
	public E get(int index) {
		Node<E> node = getNode(index);
		return node.data;
	}
	
	/**
	 * Setter for setting new value for node at given index.
	 * 
	 * @param index
	 * @param newValue
	 * @return
	 */
	public E set(int index, E newValue) {
		Node<E> node = getNode(index);
		node.data = newValue;
		return node.data;
	}
	
	public void add(int index, E data) {
		if(index == 0) {
			addFirst(data);
		} else {
			Node<E> node = getNode(index - 1);
			addAfter(node, data);
		}
	}
	
	/**
	 * Add node to end of list.
	 * 
	 * @param data
	 * @return
	 */
	public boolean add(E data) {
		add(size, data);
		return true;
	}
}
