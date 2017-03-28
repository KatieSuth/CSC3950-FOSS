/*
 *  You are free to use this code anywhere, copy, modify and redistribute at your own risk.
 *  Your are solely responsibly for any damage that may occur by using this code
 *  This code is not tested for all boundary conditions. Use it at your own risk.
 *  Original code: http://www.mycstutorials.com/articles/data_structures/queues
 *  @author <a href='mailto:alexey@zhokhov.com'>Alexey Zhokhov</a>
 */
 //Ring 3/28/17: Removed several functions made unnecesary by QueueStart.
package com.zhokhov.interview.data;
import java.util.Scanner;

public class Queue {
   private LinkedList list;

   public boolean isEmpty(){// Post: Returns true if the queue is empty. Otherwise, false.
      return (list.size() == 0);
   }

   public void QueueStart(Scanner scanQ){
      int Qinput=0;
      list = new LinkedList();// My implementation of the linked list is based on the J2SE API reference. In both, elements start at 1, unlike arrays which start at 0. 
      while(Qinput!=-999){
         System.out.println("Enter the values you would like to add to the queue.(-999 to stop)");
         Qinput=scanQ.nextInt();
         if(Qinput!=-999){
            list.add(Qinput);
         }
      }
      Qinput=0;
      while(Qinput!=-999){
         System.out.println("What position would you like to see the value for?(-999 to stop)");    
         Qinput=scanQ.nextInt();
         System.out.println(list.get(Qinput));
      }
      Qinput=0;
      while(Qinput!=-999){
         System.out.println("What value would you like to remove?(-999 to stop)");    
         Qinput=scanQ.nextInt();
         list.remove(Qinput);
         System.out.println("Removed: "+Qinput);
      }
   }
}