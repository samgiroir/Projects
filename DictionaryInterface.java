/**
 * Container in which elements are uniquely accessed by key.
 */

public interface Dictionary<Key, Value> {
  
  private HashTable table;
  
  public Dictionary(int size){
   
    this.table = new HashTable(size);
    
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
   * @ensure: if key in dictionary, will return value. Else, returns null.
   */
  
  public Value get (Key key){
    
    return table.get(key);
    
  }
  
  /**
   * Add an entry with specified key and value to this Dictionary.
   * If this already contains an entry with the specified key, value
   * associated with this entry is replaced by specified value.
   * @require: key != null, value != null
   * @ensure: If key in dicitionary, will replace current value with Value
   * given. Else, will add pair key, value to dicitionary
   */
  public void add (Key key, Value value);
  
  /**
   * Check if the given Key is stored in this Dictionary
   * @require key != null && !this.isEmpty()
   * @ensure returns true if the given Key is stored in this Dictionary, false otherwise 
   */
  public boolean contains(Key key);
  
  
  /**
   * Remove the entry this.get(key) from this Dictionary. If this Dictionary
   * does not contain an entry with the specified key, this method does nothing.
   * @require: key != null
   * @ensure: if key in dicitionary, will remove pair, else does nothing.
   */
  
  public void remove (Key key);
  
  /**
   * Remove all the entries from this Dictionary.
   * @ensure: this.isEmpty()
   */
  
  public void clear();
} 
  

