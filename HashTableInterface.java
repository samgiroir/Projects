/**
 * Container in which elements are uniquely accessed by key.
 */

public interface HashTableInterface<Key, Value> {
  
  /**
   * This HashTable contains no entries.
   */
  
  public boolean isEmpty();
  
  
  /**
   * Element of this HashTable associated with the specified key.
   * Null if there is no entry with the specified key.
   * @require: key != null
   * @ensure: if key in HashTable, will return value. Else, returns null.
   */
  
  public Value get (Key key);
  
    /**
   * Element of this HashTable associated with the specified index.
   * This is an auxilliary method for the purpose of load balance testing.
   * @require: 0 <= i <= this.size()
   */
  
  public LinkedList<Entry> get (int i);
  
  /**
   * Add an entry with specified key and value to this HashTable.
   * If this already contains an entry with the specified key, value
   * associated with this entry is replaced by specified value.
   * @require: key != null, value != null
   * @ensure: If key in dicitionary, will replace current value with Value
   * given. Else, will add pair key, value to dicitionary
   */
  public void add (Key key, Value value);
  
  /**
   * Check if the given Key is stored in this HashTable
   * @require key != null && !this.isEmpty()
   * @ensure returns true if the given Key is stored in this HashTable, false otherwise 
   */
  public Key contains(Key key);
  
  
  /**
   * Remove the entry this.get(key) from this HashTable. If this HashTable
   * does not contain an entry with the specified key, this method does nothing.
   * @require: key != null
   * @ensure: if key in dicitionary, will remove pair, else does nothing.
   */
  public void remove (Key key);
  
  /**
   * Remove all the entries from this HashTable.
   * @ensure: this.isEmpty()
   */
  public void clear();
  
  /**
   * Compute the hash code for this key
   * Note* change the return value to long if using the Apache buzhash implementation
   * @require key != null
   */
  public int hashCode(Key key);
  
    public interface Entry<Key,Value> {
    
    /**
     * Returns key of pair.
     */
    public Key getKey();
    
    /**
     * Returns value of pair.
     */
    public Value getValue();
    
    /**
     * Replaces the current value of this entry with newValue.
     */
    public void setValue(Value newValue);
    
  }
}//End of class