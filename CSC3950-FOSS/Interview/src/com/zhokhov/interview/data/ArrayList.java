/*  You are free to use this code anywhere, copy, modify and redistribute at your own risk.
 *  You are solely responsibly for any damage that may occur by using this code.
 *  This code is not tested for all boundary conditions. Use it at your own risk.
 *  Original code: http://www.journaldev.com/110/how-to-implement-arraylist-with-array-in-java
 *  @author <a href='mailto:alexey@zhokhov.com'>Alexey Zhokhov</a>
    
    ->Ring 3/27/17: Did some general cleanup on the code, attempted to add user input for arraylist.
    Also fixed some problems with the output being clustered together.
 */
package com.zhokhov.interview.data;
import java.util.Scanner;           

public class ArrayList {
   private static final int SIZE_FACTOR = 5;
   private Object data[];
   private int index;
   private int size;
   
   public ArrayList() {
      this.data = new Object[SIZE_FACTOR];
      this.size = SIZE_FACTOR;
   }

   public void add(Object item) {
      System.out.println("index:" + this.index + " size:" + this.size + " data size:" + this.data.length);
      if (this.index == this.size - 1){
         increaseSizeAndReallocate();  //we need to increase the size of data[] 
      }
      data[this.index] = item;
      this.index++;
   }
   
   private void increaseSizeAndReallocate() {
      this.size = this.size + SIZE_FACTOR;
      // TODO: Arrays.copyOf()
      Object newData[] = new Object[this.size];                                             
      // TODO: System.arraycopy(data, 0, newData, 0, data.length);
      for (int i = 0; i < data.length; i++) {
         newData[i] = data[i];
      }
      this.data = newData;
      //System.out.println("***index:" + this.index + " size:" + this.size + " data size:" + this.data.length);
   }

   public Object get(int index, Scanner scanGet){
	  while (index < 0 || index >= this.index) {
		  System.out.println("Please enter a valid index from 0 to " + (this.index - 1));
		  index = scanGet.nextInt();
	  }

	  return this.data[index];
   }

   public void remove(int removeIndex, Scanner scanRemove){
      while (removeIndex < 0 || removeIndex >= this.index) {
    	 System.out.println("Please enter a valid index from 0 to " + (this.index - 1));
		 removeIndex = scanRemove.nextInt();
	  }

      System.out.println("Object getting removed:"+this.data[removeIndex]+" ");
      for (int i = removeIndex; i < this.data.length - 1; i++) {
         data[i] = data[i + 1];
      }
      this.index--;
   }

  //Katie - renamed this function since Menu.java is the new main
   public void ArrayListStart(Scanner scanAL) throws Exception{
      ArrayList mal = new ArrayList();       //Ring:I think zhokhov meant "master array list"
      int ALinput;                           //Ring: For allowing the user to enter int variables.Could flesh it out later for other data types.
      System.out.println("Enter the integer values you'd like to populate the ArrayList with individually.(-999 to stop)");
      System.out.println("Please note that any non-integer input will cause an error.");
      ALinput = scanAL.nextInt();
      while(ALinput!=-999){
         mal.add(ALinput);
         ALinput = scanAL.nextInt();
      }
      System.out.println("Enter the index you'd like to remove.");
      ALinput = scanAL.nextInt();
      mal.remove(ALinput, scanAL);
      System.out.println("Enter the index you'd like to retrieve.");
      ALinput = scanAL.nextInt();
      
      if(mal.get(ALinput, scanAL) != null){
    	  System.out.println("The value stored at index "+ALinput+" is: "+mal.get(ALinput, scanAL));
      } 
   }
}
