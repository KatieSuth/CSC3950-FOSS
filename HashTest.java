
import java.util.ArrayList;
import java.util.Random;
public class HashTest {

	public static void main(String[] args) {
		HashMap Map = new HashMap();
		Random randGen= new Random();
		
		
		for (int i=0; i<=127;i++)   ///// This forloop was implemented to fill the array
		{					   ////  The array size can be seen in the HashMap.java file
		Map.put(i, i);			///   The array size in the TABLE_SIZE = 128	
		}
		int r=Map.get(0);
		System.out.println("Testing Begining of Table. = "+r);//test for the first element int he table.
		System.out.println(" ");
		r=Map.get(127); 							
		System.out.println("Testing End of Table. = "+r);//test for the last element in the table
		System.out.println(" ");
		
		
		
		System.out.println("Testing when key goes out of bounds of Table '128' ");//<--
		System.out.println(" "); ///test for running the index out of bounds. TABLE_SIZE=128(0-127)
		r=Map.get(128);			////Original array was filled 0-127 with its cooresponding index
		System.out.println(" ");////Every index has its Index number as its element
		System.out.println(r);  ////with linear proping it would have to fill to 127, when 128
								////was attempted it would go into infinite loop.
								///counter measures where added to HashMap.java to return -1 when
								//running over bounds.
		
		System.out.println("now replacing hash 10 with 1500 ");//this test was to prove that it was 
		Map.put(10, 1500);									  ///indeed the linear probing effecting
		r=Map.get(10);										 ////the loop and not the value.
		System.out.println("checking hash 10. = "+r);
		

	}

}
