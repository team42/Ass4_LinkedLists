
public class main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SingleLinkedList<String> sll = new SingleLinkedList<String>();
		sll.addFirst("Tom");
		sll.addFirst("Dick");
		sll.addFirst("Harry");
		
		sll.traverseList();
		sll.addFirst("Affe");
		sll.traverseList();
		System.out.println();
		
		System.out.println("index 0 = " + sll.get(0));
		System.out.println("index 1 = " + sll.get(1));
		System.out.println("index 2 = " + sll.get(2));
		System.out.println("index 3 = " + sll.get(3));
		System.out.println();
		
		sll.set(2, "Orne");
		
		System.out.println("index 0 = " + sll.get(0));
		System.out.println("index 1 = " + sll.get(1));
		System.out.println("index 2 = " + sll.get(2));
		System.out.println("index 3 = " + sll.get(3));
		System.out.println();
		
		sll.add(1, "Nicolai");
		
		System.out.println("index 0 = " + sll.get(0));
		System.out.println("index 1 = " + sll.get(1));
		System.out.println("index 2 = " + sll.get(2));
		System.out.println("index 3 = " + sll.get(3));
		System.out.println("index 4 = " + sll.get(4));
		System.out.println();
		
	}

}
