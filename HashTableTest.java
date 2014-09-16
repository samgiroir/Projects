package CSCI_2125_HW3;
import junit.framework.TestCase;

/**
 * Unit test class for the HashTable class
 */
public class HashTableTest <Key, Value> extends TestCase{
 
  private HashTable<String, String> eTable;
  private HashTable<String, String> fTable;
  String key = "full";
  String value = "table";
  String key2 = "hello";
  String value2 = "WhatsUp";
 /*
  * Set up for the test
  */
  public void setUp(){
   this.eTable = new HashTable<String, String>(10);
   this.fTable = new HashTable<String, String>(1000);
   this.fTable.add(key, value);
   this.fTable.add(key2, value2);
  }
  
  /*
   * Test for isEmpty()
   */
  public void testIsEmpty(){
   setUp();
   //tests for returning true
   assertTrue(eTable.isEmpty());
   //tests for returning false
   assertFalse(fTable.isEmpty());
  }
  /*
   * Tests the method get(key)
   */
  public void testGet(){
    setUp();
//Assures the output value is correct for the key passed in
    assertTrue(fTable.get(key2).equals("WhatsUp"));
    assertTrue(fTable.get(key).equals("table"));
  }
  /*
   * Tests the method contains(key)
   */
  public void testContains(){
   setUp(); 
   assertTrue(fTable.contains(key));
   assertFalse(eTable.contains(key));
  }
  /*
   * Tests the method add(key, value)
   */
  public void testAdd(){
   setUp();
   assertTrue(fTable.contains(key));
  }
  /*
   * Tests the method remove(key)
   */
  public void testRemove(){
   setUp();
   fTable.remove(key);
   assertFalse(fTable.contains(key));
   assertFalse(fTable.contains(value));
  }
  /*
   * Tests the method clear()
   */
  public void testClear(){
   setUp();
   fTable.clear();
   assertFalse(fTable.contains(key));
   assertFalse(fTable.contains(value));
   assertFalse(fTable.contains(key2));
   assertFalse(fTable.contains(value2));
  }
}//End of test class