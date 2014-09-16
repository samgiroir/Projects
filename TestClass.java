package CSCI_2125_HW3;
import java.util.Random;
/**
 * A simple class to test the probability of collisions
 * for a certain load factor. The class uses the Random class
 * to generate Strings to use for the key and value
 * 
 */
public class TestClass{
  /*
   *Method to be used in the main method to create strings
   * using the Random class and passing in ASCII values
   * for lower case letters.
   * It creates a Random String of 8 or 9 characters
   */
  private static String stringGen(){
    String s = "";
    Random ran = new Random();
    for(int i = 0; i < 8+ran.nextInt(2); i++)
      s = s + (char)(97 + ran.nextInt(26));
    return s;
  }
  /*
   * Produces the probability of collisions by creating 
   * 1000 hashTables, creating either 1000 or 2000 Strings
   * per key, value pair, then incrementing a count for
   * the number of empty spaces in the HashTable 
   * The probability is computed by dividing total count
   * (number of empty spaces) by the size*numHash
   */
  public static void main(String[] args){
    double count = 0;
    double size = 1000;
    double numHash = 1000;
    double loadFactor = 2;
    for(int i = 0; i < numHash; i++){
     HashTable<String, String> table = new HashTable<String, String>((int)size);
     for(int j = 0; j < size*loadFactor; j++){
      table.add(stringGen(), stringGen());
     }
     for(int j = 0; j < size; j++){
       if(table.get(j).isEmpty())
         count = count + 1;
       else 
         count = count; 
     }
     
    }
     System.out.println("Probability of Collisions with a load factor of 2: " 
                          + count/(size*numHash)); 
  }
 
}//End of class