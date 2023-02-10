package sol;

import src.IList;

/**
 * A class that implements singly-linked mutable lists.
 *
 * @param <T> - the type of items in the list
 */
public class MutableList<T> implements IList<T> { //, IListWithNode<T> {
  private Node<T> start;

  /**
   * A constructor for Mutable List.
   */
  public MutableList() {
    this.start = null;
  }

  /**
   * Returns whether the list is empty.
   *
   * @return true if the list is empty, false otherwise
   */
  @Override
  public boolean isEmpty() {
    return (this.start == null);
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
   * Adds an item to the start of the list.
   *
   * @param item - the item to be added
   */
  @Override
  public void addFirst(T item) {
    Node<T> newNode = new Node<T>(item, this.start);
    this.start = newNode;
  }

   /**
   * Returns the number of elements in the list.
   *
   * @return the number of elements in the list
   */
  @Override
  public int size() {
    // TODO: finish here
    return 0;
  }

  /**
   * Returns the item at the specified index.
   *
   * @param index - an item index
   * @throws RuntimeException "Index out of bounds" if index is too small or big
   * @return the item at the specified index
   */
  @Override
  public T get(int index) {
    // TODO: finish here
    return null;
  }
  /* Task 1-E ->
    TODO: replace this line with the worst-case running time of get()
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
    // TODO: finish here
    return false;
  }

  /**
   * Adds an item to the end of the list.
   *
   * @param item - the item to be added
   */
  @Override
  public void addLast(T item) {
    // TODO: finish here
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
