import java.util.ArrayList;


public class Main {

   /**
    * Test the SingleLinkedList
    */
   public void callSLL() {
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

   public static void main(String[] args) {

      DoubleLinkedList<String> list = new DoubleLinkedList();
      ArrayList<String> aList = new ArrayList<String>();

      int amount = 5000000;

      long ts = 0;
      /*
      ts = System.currentTimeMillis();
      for(int i=0; i<amount; i++) {
         list.add(""+(amount-i));
      }
      System.out.println(System.currentTimeMillis()-ts);

      ts = System.currentTimeMillis();
      for(int i=0; i<(10000); i++) {
         list.get(i);
      }
      System.out.println(System.currentTimeMillis()-ts);

      ts = System.currentTimeMillis();
      for(int i=0; i<amount; i++) {
         list.remove();
      }
      System.out.println(System.currentTimeMillis()-ts);

      //System.out.println(list.transverse());

      ts = System.currentTimeMillis();
      for(int i=0; i<amount; i++) {
         list.addFirst(""+(amount-i));
      }
      System.out.println(System.currentTimeMillis()-ts);

      list.clear();

      ts = System.currentTimeMillis();
      for(int i=0; i<amount; i++) {
         list.addLast(""+(amount-i));
      }
      System.out.println(System.currentTimeMillis()-ts);

      for(int i=0; i<amount; i++) {
         list.addLast(""+(amount-i));
      }

      ts = System.currentTimeMillis();
      for(int i=0; i<amount; i++) {
         list.removeFirst();
      }
      System.out.println(System.currentTimeMillis()-ts);

      list.clear();

      for(int i=0; i<amount; i++) {
         list.addLast(""+(amount-i));
      }

      ts = System.currentTimeMillis();
      for(int i=0; i<amount; i++) {
         list.remove();
      }
      System.out.println(System.currentTimeMillis()-ts);
       */

      amount = 1000;

      for(int i=0; i<amount; i++) {
         list.addLast(""+(int)(Math.random()*10000));
      }

      //System.out.println(list.transverse());

      ts = System.currentTimeMillis();

      int size = list.getSize();
      int temp;

      /**
       * Our implementation of a selection sort using our own circular double-linked list.
       */
      for(int i=0; i<=(size); i++) {
         for(int k=i; k<=(size);k++) {
            if(Integer.parseInt(list.get(i)) > Integer.parseInt(list.get(k))) {
               temp = Integer.parseInt(list.get(i));
               list.set(i, list.get(k));
               list.set(k, temp+"");
            }  
         }
      }

      System.out.println(System.currentTimeMillis()-ts);

      //System.out.println(list.transverse());

   }

}
