/*
 *  You are free to use this code anywhere, copy, modify and redistribute at your own risk.
 *  Your are solely responsibly for any damage that may occur by using this code.This code is not tested for all boundary conditions. Use it at your own risk.
 *  Original code: http://www.mycstutorials.com/articles/data_structures/stacks
 *  @author <a href='mailto:alexey@zhokhov.com'>Alexey Zhokhov</a>
 */
package com.zhokhov.interview.data;
import java.util.Scanner;

public class Stack {
   private LinkedList list;

   public boolean isEmpty(){// Post: Returns true if the stack is empty. Otherwise, false.
      return (list.size() == 0);
   }

   public Object pop(){// Pre: this.isEmpty() == false
    // Post: The item at the front of the stack is returned and deleted from the stack. Returns null if precondition not met.  
        // Store a reference to the item at the front of the stack so that it does not get garbage collected when we remove it from the list
      Object item = list.get(list.size());
        //My implementation of the linked list is based on the J2SE API reference. In both, elements start at 1,unlike arrays which start at 0.
      list.remove(list.size());
      return item;
   }

   public Object peek(){// Pre: this.isEmpty() == false
    //Post: The item at the front of the stack is returned and deleted from the stack. Returns null if precondition not met. 
    // This method is very similar to pop(). See Stack.pop() for comments.
      return list.get(list.size());
   }

   public void StackStart(Scanner scanS){
      int Sinput=0;
      list = new LinkedList();
      while(Sinput!=-999){
         System.out.println("Enter the values you would like to add to the stack.(-999 to stop)");
         Sinput=scanS.nextInt();
         list.add(Sinput);
      }/*
      while(Sinput!=-999){
         System.out.println("Enter the position value you would like to see.(-999 to stop)");
         Sinput=scanS.nextInt();
         System.out.println("Value: "+list.get(Sinput));
      }*/
   }
}