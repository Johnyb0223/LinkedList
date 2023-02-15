package sol;

/**
 * A class that implements linked list nodes.

 * Remove() is tough because you can recur until you find the element but at that point you have lost all
 * reference to the previous node. Therefore, you have no way to set the previous nodes next to the this.node next.
 * With a "previous node" field we will have access to the information needed to path the hole in the list we create by
 * removing a specific node.
 *
 * @param <S> - some type
 */
public class Node<S> {
    private S item;
    private Node<S> next;
    private Node<S> prev;


    /**
     * A constructor for Node.
     *
     * @param item - the item stored at this node
     */
    public Node(S item) {
        this.item = item;
        this.next = null;
        this.prev = null;
    }

    /**
     * A constructor for Node.
     *
     * @param item - the item stored at this node
     * @param next - the node which comes directly after this node in the list
     * @param prev - the node that prev needs to be set to
     */
    public Node(S item, Node<S> next, Node<S> prev) {
        this.item = item;
        this.next = next;
        this.prev = prev;
    }

    /**
     * A size method that recurs through our list*/
    public int size(){
        if(this.next == null){
            return 1;
        }else{
            return (1 + this.next.size());
        }
    }

    /**
     * Returns a boolean indicating whether the Node has a given item.
     *
     * @param checkItem - the item to check if the Node has
     * @return true if this Node has checkItem, false otherwise
     */
    public boolean hasItem(S checkItem) { return this.item.equals(checkItem); }

    /**
     * Returns the Node's item.
     *
     * @return the Node's item
     */
    public S getItem() { return this.item; }

    /**
     * getPrev() method returns the node in the prev node field
     *
     * @return node in the prev field
     * */
    public Node getPrev(){
        return this.prev;
    }

    /**
     * setPrev is a method used to set a nodes prev field
     * @param prev - the node to be set as the previous node
     * */
    public void setPrev(Node prev){
        this.prev = prev;
    }

    /**
     * setNext is a method used to set a nodes next field
     * @param next - The node to be set as next
     * */
    public void setNext(Node next){
        this.next = next;
    }

    /**
     * getNext() method
     *
     * @return the node in the next field
     * */
    public Node getNext(){
        return this.next;
    }

    /**
     * Returns a boolean indicating if the Node has a Node as its next field.
     *
     * @return true if the Node has a next Node, false otherwise
     */
    private boolean hasNext() {return (this.next != null); }

    /**
     * Returns the item at a given position in the list
     * @param index - the 0-based position of the desired list element
     * @return the element in the index-th position from start
     */
    public S getIndex(int index) {

        //Throws exception if index is less than 0;
        if(index < 0 || !(this.hasNext()) && index > 0 ){
            throw new RuntimeException("Index out of bounds");
        }
        //Base case
        if(index == 0){
            return this.getItem();
        }
        //Recursive call
        return this.next.getIndex(--index);
    }

    /**
     * cleaveNode test the different states of a node needing to be removed and handles each case appropriately
     */
    public void bypass() {
        this.prev.next = this.next;
        this.next.prev = this.prev;
    }

    /**
     * Removes first occurrence of given item from the list
     * @param itemToRem - the item to remove the first occurrence of
     * @return boolean indicating whether an item was removed
     */
    public boolean remove(S itemToRem) {
        // TODO: discuss (in comment just below) how to finish this method
         if (this.hasItem(itemToRem)){
             //We don't handle removing head or tail of list
            if(this.prev == null || this.next == null){
                return false;
            }else{
            this.bypass();
            return  true;
            }
        } else if (this.hasNext()) {
            return this.next.remove(itemToRem);
        }else{
            return  false;
        }
    }

    /*
       TODO:
        I simply recur through the linked list. If i have a match I make sure its not the first or the last node
        and then bypass said node. If it is the first or the last, I don't remove it and return false as no node is removed.
        Runtime: The recursive function is still a linear function. The worst case runtime is if the node to be removed
        is the last element in the list and you have to go through n elements. BigO = O(n)
     */

    /**
     * traverses to the end of the list and inserts a node into the list
     *
     * @param item - the item that needs to be inserted into the list
     * @param prev -
     * @return node that is now the last node in the list
     * */
    public Node insertNode(S item, Node<S> prev){

        Node node = new Node(item, null, prev);
        this.next = node;
        return node;

    }

    /**
     * Implementation of findNode()
     *
     * Finds the first instance of a node with a specified item and return that node
     * @param item - the item to be found
     * @return either the node to be found or null if the node is not found
     *
     * */
    public Node getNode(S item){
        if(this.hasItem(item)){
            return  this;
        }else if(!(this.hasNext())){
            return null;
        }else{
            return this.next.getNode(item);
        }
    }

    /**
     * Returns the Node's representation as a String.
     *
     * @return the Node's representation as a String
     */
    public String toString() {
        if (this.hasNext())
            return this.item.toString() + ", " + this.next.toString();
        else
            return this.item.toString();
    }

}
