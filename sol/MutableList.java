package sol;

import src.IList;
import src.IListWithNode;

/**
 * A class that implements singly-linked mutable lists.
 *
 * @param <T> - the type of items in the list
 */
public class MutableList<T> implements IList<T> , IListWithNode<T> {
  private Node<T> start;
  private Node<T> last;
  private int length;

  /**
   * A constructor for Mutable List.
   */
  public MutableList() {
    this.start = null;
    this.last = null;
    this.length = 0;
  }

  /**
   * Returns whether the list is empty.
   *
   * @return true if the list is empty, false otherwise
   */
  @Override
  public boolean isEmpty() {return (this.start == null);
  }

  /**
   * Returns the first item in the list.
   *
   * @throws RuntimeException "List is empty" when the list is empty
   * @return the first item in the list
   */
  @Override
  public T getFirst() {
    if (this.isEmpty()) {
      throw new RuntimeException("List is empty");
    }
    return this.start.getItem();
  }

   /**
   * Returns the number of elements in the list.
   *
   * @return the number of elements in the list
   */
  @Override
  public int size() {
    if(this.start == null){
      return 0;
    }else{
      return this.start.size();
    }
  }
  //This is a constant runtime function. It just returns the int value of length

  /**
   * Returns the item at the specified index.
   *
   * @param index - an item index
   * @throws RuntimeException "Index out of bounds" if index is too small or big
   * @return the item at the specified index
   */
  @Override
  public T get(int index) {
    if(this.start ==  null){
      throw new RuntimeException("Index out of bounds");
    }
    return this.start.getIndex(index);
  }
  /* Task 1-E ->
    TODO: Our method get() is a linear time method. At its worst you would have to go to the end of the list to get
    the nth element. Therefore worst case O(n).
   */

  /**
   * Removes an item from the list. If the item is not in the list, the list is
   * unchanged. If the item occurs more than once in the list, removes only the
   * first instance.
   *
   * @param itemToRem - the item to remove
   *
   * @return whether the item was successfully removed from the list
   */
  @Override
  public boolean remove(T itemToRem) {
    if(this.start == null){
      return false;
    }
    if(this.start.remove(itemToRem)){
      --this.length;
      return true;
    }else{
      return false;
    }
  }
  /* TODO: The current implementation of remove does not remove the head of the list or the tail of the list. If the front
      node were to be removed we would need to set this.start to the next node. However, we do not have access to this.start
      while in the node class. I would change the remove return type to a noce so we could set this.start equal to the
      returned node.
      If we removed the last node we would have to set this.last to the prev node but again we don't have access to this.last
      while in the node class. If we changed the return type we could return the next to last node to set this.last equal to

  */

  /**
   * Adds an item to the start of the list.
   *
   * @param item - the item to be added
   */
  @Override
  public void addFirst(T item) {

    if(this.last == null){
      Node<T> node = new Node(item, null, null);
      this.start = node;
      this.last =node;
    }else {
      Node<T> node = new Node(item, this.start, null);
      this.start.setPrev(node);
      this.start = node;
    }
    this.length++;
  }

  /**
   * Adds an item to the end of the list.
   *
   * @param item - the item to be added
   */
  //I decided to add a field "last" to the MutableList class. This is a constant time method compared to an
  //implementation that would have been O(n) if recursion was used.
  @Override
  public void addLast(T item) {
    if(this.last == null){
      Node<T> node = new Node(item);
      this.start = node;
      this.last = node;
    }else{
       this.last = this.last.insertNode(item, this.last);
    }
    this.length++;
  }

  /**
   * Implement getNode()
   *
   * @param item - item to be found
   * @Thorw a runtime exception when the item is not found in the list
   * @Return the node that contains the specified item
   *
   * */
  @Override
  public Node getNode(T item){
    Node<T> foundNode = this.start.getNode(item);
    if(foundNode == null){
      throw new RuntimeException("Item not found");
    }
    return foundNode;

  }

  /**
   * Implementation of removeNode()
   * When given a reference node remove it from our list.
   * We need to handle the head and the tail elements
   *
   * @param node - the node to be removed
   * @throw IllegalArgumentException if the node passed is null
   * */
  @Override
  public void removeNode(Node<T> node){
    if (node == null){
      throw new IllegalArgumentException("removeNode given null input");
    } else if (node.getPrev() == null && node.getNext() == null) {
      this.start = null;
      this.last = null;
      this.length = 0;
    } else if (node.getPrev() == null) {
      Node nextNode = node.getNext();
      nextNode.setPrev(null);
      this.start = nextNode;
    } else if (node.getNext() == null) {
      Node prevNode = node.getPrev();
      prevNode.setNext(null);
      this.last = prevNode;
    }else{
      node.bypass();
    }
  }

  /**
   * Removes a node from the list given an item to be removed.
   * use getNode and removeNode methods
   * If the item is not in the list, the list is
   * unchanged. If the item occurs more than once in the list, removes only the
   * first instance.
   *
   * @param item -- an item in the list to be removed
   * @return boolean whether or not the item was successfully removed from the list
   */
  @Override
  public boolean removeWithNode(T item){
    Node nodeToRemove;
    try{
      nodeToRemove = this.getNode(item);
    }catch(RuntimeException e){
      return false;
    }
    this.removeNode(nodeToRemove);
    --this.length;
    return true;

  }

  /**
   * Returns the first item in the list as a String.
   *
   * @return the first item in the list as a String
   */
  public String toString() {
    if (this.start == null)
      return "[]";
    else
      return "[" + this.start.toString() + "]";
  }
}
