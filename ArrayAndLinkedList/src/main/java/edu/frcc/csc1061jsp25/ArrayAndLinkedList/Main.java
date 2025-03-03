package edu.frcc.csc1061jsp25.ArrayAndLinkedList;

import java.util.List;


public class Main
{
    public static void main( String[] args )
    {
       List<Integer> m1 = new MyArrayList<>();
       
       m1.add(1);
       m1.add(2);
       m1.add(3);
       m1.add(4);
       m1.add(5);
       m1.add(6);
       
       for (int i = 0; i < m1.size(); i++) {
    	   int num = m1.get(i);
    	   System.out.print(num);
       }
       System.out.println();
       
       m1.remove(3); //Removes 4th value of our array (index 3)
       m1.remove(Integer.valueOf(3)); // Removes the object with value 3 in our array
       
    }
    
    
}
