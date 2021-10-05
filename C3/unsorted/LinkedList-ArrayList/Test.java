

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;


class Test {
    public static void main(String[] args) {
        System.out.println("ARRAYLIST: ");
        // ARRAYLIST:
        /*
        * int TestArray[] = new int[5]; || {1,2,3,4,5}; Cant change size
        */

        //HOW TO INIT
        ArrayList<Integer> arlst = new ArrayList<Integer>(16); // "(16)" is initial size, not final (optional)
        //       <ITEM TYPE> NAME               <ITEM TYPE>
        
        //====================


        //MODIFICATION

        arlst.add(1); //adds any value we specify to the end
        //arlst.addAll(); adds all values we specify
        arlst.remove(0); //removes the element at the index
        //arlst.clear(); will remove all elements, sizes to 0
        arlst.trimToSize(); //if the size of the array is bigger then the amount of elements, trim it.
        
        // fill the array with simple for: 

        for (int i = 0; i <= 50; i++) {

            arlst.add(i); //adds integers [0 -> 50];

        }

        System.out.println("index of 16: " + arlst.indexOf(16)); //returns the index of the value we want to find
        //arlst.clone(); will return the array without elements 
        System.out.println("does arlist contain 69?: " + arlst.contains(69)); //asks if the arraylist contains this value, return bool
        //arlst.equals(); are two lists equal?
        //arlst.ensureCapacity(minCapacity); increases capacity if we expect more elements
        System.out.println("is arrlist empty?: " + arlst.isEmpty()); //returns true if the arrlist is empty
        arlst.set(16, 616); //changes the element on index, to value as such (index, val);
        
        //===================

        //prints out the Size first, then all items as such: [0, 1, 2, 3, ..., 50];
        System.out.println("ArrayList size: " + arlst.size());
        System.out.print("Items: \n[");

        for (Integer item : arlst) {
            
            if(item == 50) { System.out.print(item); break; }

            System.out.print(item + ", ");
        }
        System.out.print("]");
        //======================
        System.out.println("\n\n\n LINKED LIST: ");

        //LINKED LIST:
        LinkedList<Integer> lnkLs = new LinkedList<Integer>();
        lnkLs.add(1);
        lnkLs.add(2);
        lnkLs.add(3);
        lnkLs.remove(0); //removes the element at index
        lnkLs.addFirst(11); //adds to the front  ??not works?? tf
        lnkLs.addLast(16); //adds to the end
        lnkLs.removeFirst(); //removes first element
        lnkLs.add(2, 25); //adds to the particular index (index, val)
        
        lnkLs.set(2, 33);

        System.out.println("size of lnkLS: " + lnkLs.size());
        for (int item : lnkLs) {
            System.out.println(item);
        }

        lnkLs.clear();//clears the linked list

        System.out.println("DIFFERENCES?: ");
        /*differences: 
       *LL+:
       *    Insertion into LL is faster than AL
       *    Deletion is faster than AL
       *LL-:
       *    More memory as every N element knows about N+&-1
       *    Have to iterate through all of it to retrieve
       *    
       * AL+:
       *    Less memory, only holds Object and pos
       *    faster search
       * AL-: 
       *    resizing cuz of indexing
       * In the end:
       *            if we add||del a lot, use LL
       *            if you search,comp a lot, use AL
       */
        arlst.clear();
        lnkLs.clear();
       long n = (long) 1E7; // 10^7 ==  10+7zeroes => 10M ( 10 000 000 )
       long milis = System.currentTimeMillis();
       //ArrayList:
       for (int i = 0; i < n; i++) {
           arlst.add(i);
       }
       System.out.println("AL, 10M insertions time(MS): " + (System.currentTimeMillis() - milis) + " MS" );
       //==========

       milis = System.currentTimeMillis();

       //LinkedList:
       for (int i = 0; i < n; i++) {
            lnkLs.add(i);
        }
        System.out.println("AL, 10M insertions time(MS): " + (System.currentTimeMillis() - milis) + " MS" );


        System.out.println("Deletion from 1E5:");
        milis = System.currentTimeMillis();
        arlst.remove(1E5);
        System.out.println("AL, remove from 1E5 time(MS): " + (System.currentTimeMillis() - milis) + " MS" );
        milis = System.currentTimeMillis();
        lnkLs.remove(1E5);
        System.out.println("LL, remove from 1E5 time(MS): " + (System.currentTimeMillis() - milis) + " MS" );

        System.out.println("get from: ");
        milis = System.currentTimeMillis();
        arlst.get((int)n/2);
        System.out.println("AL, get time(MS): " + (System.currentTimeMillis() - milis) + " MS" );
        milis = System.currentTimeMillis();
        lnkLs.get((int)n/2);
        System.out.println("LL, get time(MS): " + (System.currentTimeMillis() - milis) + " MS" );


        System.out.println("LISTITERATOR: ");
        /*
        *METHODS:
        *   hasNext();
        *   next();
        *   hasPrevious();
        *   previous();
        */
        String[] namear = {"Lukas", "George", "Jirka", "Pavel", "Mikulas"}; //names
        ArrayList<String> names = new ArrayList<String>(); //arraylist
        for (int i = 0; i < namear.length; i++) {  //filling
            names.add(namear[i]);   
        }

        ListIterator<String> itr = names.listIterator(); //linkes the iterator to the list
        System.out.println("forward iter: ");
        while(itr.hasNext()) { //do i have next?? starts from start
            System.out.println(itr.next()); //yes = return it
        }
        System.out.println("\n reverse iter: ");
        while(itr.hasPrevious()) { //do i have a previous value? starts from last
            System.out.println(itr.previous()); // yes = return it
        }


       }
    
      
}
