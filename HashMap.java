/*
 *  You are free to use this code anywhere, copy, modify and redistribute at your
 *  own risk.
 *  Your are solely responsibly for any damage that may occur by using this code.
 *
 *  This code is not tested for all boundary conditions. Use it at your own risk.
 *
 *  Original code: http://www.algolist.net/Data_structures/Hash_table/Simple_example
 */


/**
 * @author <a href='mailto:alexey@zhokhov.com'>Alexey Zhokhov</a>
 */

//Anthony Logan Mitchell, Software Maintenance CSC 3950. 
//Bug was reported that the hash table would go into an infinite loop
//when the table was full, and you request a key that was not in the table.
//The bug happend because of a final static TABLE_SIZE=128, and the get(key);
//function is to find what is contained within a specific index, if the table
//was full and the key wasnt in the 
//
public class HashMap {

    private final static int TABLE_SIZE = 128;

    private class HashEntry {

        private int key;
        private int value;

        HashEntry(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public int getKey() {
            return key;
        }

        public int getValue() {
            return value;
        }

    }

    HashEntry[] table;

    HashMap() {
        table = new HashEntry[TABLE_SIZE];

        for (int i = 0; i < TABLE_SIZE; i++) {
            table[i] = null;
        }
    }

    public int get(int key) {
        int hash = (key % TABLE_SIZE);
        if(hash>=TABLE_SIZE)
        {
        	return -1;
        }

        while (table[hash] != null && table[hash].getKey() != key) {
        	
        	//System.out.println("line 58"); //<<------------This is where the infinite loop was occuring.
        	if(key >=TABLE_SIZE){       ///<----------This statement was added to inform and prevent the loop.
        		break;
        	} else {
            hash = (hash + 1) % TABLE_SIZE;
        	}
        }
        
      

        if (table[hash] == null || key>=TABLE_SIZE)//<<---The || shortcircuit was added to prevent overflow.
            {
        	System.out.println("Ran Over bounds");
        	System.out.println("key must be 0-127, returning -1");
        	return -1;
            }
        	else
        	{
        	 return table[hash].getValue();
        	}
           
    }

    public void put(int key, int value) {
        int hash = (key % TABLE_SIZE);

        while (table[hash] != null && table[hash].getKey() != key) {
            hash = (hash+1) % TABLE_SIZE;
            if(hash>128)
            {
            	
            	break;
            }
                   
        }

        table[hash] = new HashEntry(key, value);
    }
    
 

}

