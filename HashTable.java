package CSCI_2125_HW3;
import nhUtilities.containers2.LinkedList;
import java.util.ArrayList;
/**
 * Samantha Giroir
 * CSCI 2125
 * Container in which elements are uniquely accessed by key.
 */

public class HashTable<Key, Value> {
  
  private ArrayList<LinkedList<Entry<Key, Value>>> table;
  
  public HashTable(int size){
    this.table = new ArrayList<LinkedList<Entry<Key, Value>>>();
    for(int i = 0; i < size; i++)
      this.table.add(new LinkedList<Entry<Key, Value>>());
  }
  
  /**
   * This HashTable contains no entries when true is the 
   * output when isEmpty()==false the hashTable has
   * items 
   */
  public boolean isEmpty(){
    for(int i = 0; i < table.size(); i++){
      if(table.get(i).isEmpty()== false)
        return false;
    }
    return true;
    
  }
  
  /**
   * Element of this HashTable associated with the specified key.
   * Null if there is no entry with the specified key.
   * @require: key != null
   * @ensure: if key in HashTable, will return value. Else, returns null.
   */
  public Value get (Key key){
    
    int index = hashCode(key);
    LinkedList<Entry<Key, Value>> list = table.get(index);
    for(int i = 0; i < list.size(); i++){
      if(key.equals(list.get(i).getKey())){
        return list.get(i).getValue();
      }
    }
    return null;
  }
  
  /**
   * Element of this HashTable associated with the specified index.
   * This is an auxilliary method for the purpose of load balance testing.
   * @require: 0 <= i <= this.size()
   */
  public LinkedList<Entry<Key,Value>> get (int i){
    return table.get(i);
  }
  
  /**
   * Add an entry with specified key and value to this HashTable.
   * If this already contains an entry with the specified key, value
   * associated with this entry is replaced by specified value.
   * @require: key != null, value != null
   * @ensure: If key in dicitionary, will replace current value with Value
   * given. Else, will add pair key, value to dicitionary
   */
  public void add (Key key, Value value){
    int index = hashCode(key);
    if(contains(key)){
      for(int i = 0; i < get(index).size(); i++){
        if(key.equals(get(index).get(i).getKey()))
          get(index).get(i).setValue(value);
      }
    }else
      get(index).add(new Entry<Key, Value>(key, value));
    
  }
  
  /**
   * Check if the given Key is stored in this HashTable
   * @require key != null && !this.isEmpty()
   * @ensure returns true if the given Key is stored 
   * in this HashTable, false otherwise 
   */
  public boolean contains(Key key){
    int index = hashCode(key);
    for(int i = 0; i < get(index).size(); i++){
      if(key.equals(get(index).get(i).getKey()))
        return true;
    }
    return false;
  }
  
  /**
   * Remove the entry this.get(key) from this HashTable. 
   * If this HashTable does not contain an entry with the 
   * specified key, this method does nothing.
   * @require: key != null
   * @ensure: if key in dicitionary, will remove pair, 
   * else does nothing.
   */
  public void remove (Key key){
    int index = hashCode(key);
    if(contains(key))
      for(int i = 0; i < get(index).size(); i++){
      if(get(index).get(i).getKey().equals(key)){
        get(index).remove(get(index).get(i));
      }
    }
  }
  /**
   * Remove all the entries from this HashTable.
   * @ensure: this.isEmpty()
   */
  public void clear(){
    for(int i = 0; i < table.size(); i++)
      table.set(i, new LinkedList<Entry<Key, Value>>());
  }
  
  
  /**
   * Compute the hash code for this key
   * @require key != null
   */
  public int hashCode(Key key){
    long n = Math.abs(HashUtil.hash(key.toString()));
    int index = Math.abs((int)n % table.size());
    return index;
  }
  
  public class Entry<Key,Value>  {
    private Key key;
    private Value value;
    
    public Entry(Key key, Value value){
      this.key = key;
      this.value = value;
    }
    /**
     * Returns key of pair.
     */
    public Key getKey(){
      return key;
    }
    
    /**
     * Returns value of pair.
     */
    public Value getValue(){
      return value;
    }
    
    /**
     * Replaces the current value of this entry with newValue.
     */
    public void setValue(Value newValue){
      this.value = newValue;
    } 
  }
}//End of class