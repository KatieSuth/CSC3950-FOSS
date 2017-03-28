//Katie Sutherland
//File contains a Main Menu to provide access to the various functionality

package com.zhokhov.interview.util;

import java.util.Scanner;

import com.zhokhov.interview.data.ArrayList;
import com.zhokhov.interview.data.BinaryTree;
import com.zhokhov.interview.data.HashMap;
import com.zhokhov.interview.data.LinkedList;
import com.zhokhov.interview.data.Queue;
import com.zhokhov.interview.data.Stack;
import com.zhokhov.interview.sorting.BubbleSort;
import com.zhokhov.interview.sorting.InsertionSort;
import com.zhokhov.interview.sorting.MergeSort;
import com.zhokhov.interview.sorting.QuickSort;
import com.zhokhov.interview.sorting.SelectionSort;

public class Menu {

	public static void main(String[] args) {
		Menu mainMenu = new Menu();
		Scanner scan = new Scanner(System.in);
		int intMenu = 0;
		
		System.out.println("Welcome to the Interview Review Helper!");
				
		while(intMenu != -1){ //-1 indicates the user has typed "exit"
			intMenu = mainMenu.printMenu1(scan);		
			switch (intMenu){
				case 1:  intMenu = mainMenu.printDS(scan);
						 break;
				case 2:  intMenu = mainMenu.printSA(scan);
						 break;
				default: break;
			}
		}
		
		scan.close();
	}
	
	public int printMenu1(Scanner scanMenu){
		
		String strInput = "";
		
		//continues to prompt for input until valid input is received
		while(!strInput.trim().toLowerCase().equals("1") && 
		  	  !strInput.trim().toLowerCase().equals("2") &&
			  !strInput.trim().toLowerCase().equals("exit")){
			
			System.out.println("");
			System.out.println("");
			System.out.println("Please select an option or type 'exit' to quit.");
			System.out.println("1. Data Structures");
			System.out.println("2. Sorting Algorithms");
			System.out.println("");
			
			strInput = scanMenu.next();
		}
		
		switch (strInput.trim().toLowerCase()) {
			case "1": return 1;
			case "2": return 2;
			default:  return -1; //"exit"
		}
	}
	
	public int printDS(Scanner scanDS){
		String strInput = "";
		
		while(!strInput.trim().toLowerCase().equals("1") &&
			  !strInput.trim().toLowerCase().equals("2") &&
			  !strInput.trim().toLowerCase().equals("3") &&
			  !strInput.trim().toLowerCase().equals("4") &&
			  !strInput.trim().toLowerCase().equals("5") &&
			  !strInput.trim().toLowerCase().equals("6") &&
			  !strInput.trim().toLowerCase().equals("exit")){

			System.out.println("Please select an option or type 'exit' to quit.");
			System.out.println("1. ArrayList");
			System.out.println("2. Binary Tree");
			System.out.println("3. Hash Map");
			System.out.println("4. Linked List");
			System.out.println("5. Queue");
			System.out.println("6. Stack");
			System.out.println("");
			
			strInput = scanDS.next();
		}
		
		switch (strInput.trim().toLowerCase()) {
			case "1": ArrayList array = new ArrayList();
					  try {
					  	  array.ArrayListStart(scanDS);
					  } catch (Exception e) {
						  System.out.println("An error occurred in ArrayList.");
						  scanDS.nextLine();
					  }
					  break;
			case "2": BinaryTree btree = new BinaryTree();
					  try {
						  btree.BinaryTreeStart(scanDS);
					  } catch (Exception e) {
						  System.out.println("An error occurred in BinaryTree.");
						  scanDS.nextLine();
					  }
					  break;
			case "3": HashMap map = new HashMap();
					  try {
						  map.HashMapStart(scanDS);
					  } catch (Exception e) {
						  System.out.println("An error occurred in HashMap.");
						  scanDS.nextLine();
					  }
				  	  break;
			case "4": LinkedList llist = new LinkedList();
					  try {
						  llist.LinkedListStart(scanDS);
					  } catch (Exception e) {
						  System.out.println("An error occurred in LinkedList.");
						  scanDS.nextLine();
					  }
				  	  break;
			case "5": Queue qu = new Queue();
					  try {
						  qu.QueueStart(scanDS);
					  } catch (Exception e) {
						  System.out.println("An error occurred in Queue.");
						  scanDS.nextLine();
					  }
				  	  break;
			case "6": Stack st = new Stack();
					  try {
						  st.StackStart(scanDS);
					  } catch (Exception e) {
						  System.out.println("An error occurred in Stack.");
						  scanDS.nextLine();
					  }
				  	  break;
			default:  return -1; //"exit"
		}
		
		return 0;
	}
	
	public int printSA(Scanner scanSA){
		String strInput = "";
		
		while(!strInput.trim().toLowerCase().equals("1") &&
			  !strInput.trim().toLowerCase().equals("2") &&
			  !strInput.trim().toLowerCase().equals("3") &&
			  !strInput.trim().toLowerCase().equals("4") &&
			  !strInput.trim().toLowerCase().equals("5") &&
			  !strInput.trim().toLowerCase().equals("exit")){

			System.out.println("Please select an option or type 'exit' to quit.");
			System.out.println("1. Bubble Sort");
			System.out.println("2. Insertion Sort");
			System.out.println("3. Merge Sort");
			System.out.println("4. Quick Sort");
			System.out.println("5. Selection Sort");
			System.out.println("");
			
			strInput = scanSA.next();
		}
		
		switch (strInput.trim().toLowerCase()) {
			case "1": BubbleSort bubble = new BubbleSort();
					  try {
						  bubble.BubbleStart();;
					  } catch (Exception e) {
						  System.out.println("An error occurred in BubbleSort.");
						  scanSA.nextLine();
					  }
					  break;
			case "2": InsertionSort insert = new InsertionSort();
					  try {
						  insert.InsertionStart();
					  } catch (Exception e) {
						  System.out.println("An error occurred in InsertionSort.");
						  scanSA.nextLine();
					  }
					  break;
			case "3": MergeSort merge = new MergeSort();
				      try {
				    	  merge.MergeStart();
				      } catch (Exception e) {
						  System.out.println("An error occurred in MergeSort.");
						  scanSA.nextLine();
				      }
				  	  break;
			case "4": QuickSort quick = new QuickSort();
					  try {
						  quick.QuickStart();
					  } catch (Exception e) {
						  System.out.println("An error occurred in QuickSort.");
						  scanSA.nextLine();
					  }
				  	  break;
			case "5": SelectionSort select = new SelectionSort();
					  try {
						  select.SelectionStart();
					  } catch (Exception e) {
						  System.out.println("An error occured in SelectionSort.");
						  scanSA.nextLine();
					  }
					  break;
			default:  return -1; //"exit"
		}
		
		return 0;
	}
	
    /*
     * Utility for dumping the array
     */
    public static void __dump(int[] array) {
        for (int i : array) System.out.print(i + " ");

        System.out.print("\n");
    }
	
}
