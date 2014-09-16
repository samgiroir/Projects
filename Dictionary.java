package CSCI_2125_HW3;
/**
 * Container in which elements are uniquely accessed by key.
 */

public class Dictionary<Key, Value> {
  
  private HashTable<Key, Value> table;
  
  public Dictionary(int size){
   //Creates a new HashTable the size of the Dictionary
    this.table = new HashTable<Key, Value>(size);
    
  }
  
  /**
   * This Dictionary contains no entries.
   */
  public boolean isEmpty(){
    
    return table.isEmpty();
    
  }
  
  /**
   * Element of this Dictionary associated with the specified key.
   * Null if there is no entry with the specified key.
   * @require: key != null
   * @ensure: if key in dictionary, will return value. 
   * Else, returns null.
   */
  public Value get (Key key){
    
    return table.get(key);
    
  }
  
  /**
   * Add an entry with specified key and value to this Dictionary.
   * If this already contains an entry with the specified key, value
   * associated with this entry is replaced by specified value.
   * @require: key != null, value != null
   * @ensure: If key in dicitionary, will replace current value 
   * with Value given. Else, will add pair key, value to dicitionary
   */
  public void add (Key key, Value value){
    
    table.add(key, value);
    
  }
  
  /**
   * Check if the given Key is stored in this Dictionary
   * @require key != null && !this.isEmpty()
   * @ensure returns true if the given Key is stored in this 
   * Dictionary, false otherwise 
   */
  public boolean contains(Key key){
    
    return table.contains(key);
    
  }
  
  
  /**
   * Remove the entry this.get(key) from this Dictionary.
   * If this Dictionary does not contain an entry with the 
   * specified key, this method does nothing.
   * @require: key != null
   * @ensure: if key in dicitionary, will remove pair, 
   * else does nothing.
   */
  public void remove (Key key){
    
    table.remove(key);
    
  }
  
  /**
   * Remove all the entries from this Dictionary.
   * @ensure: this.isEmpty()
   */
  public void clear(){
    
    table.clear();
    
  }
}//End of class
  

