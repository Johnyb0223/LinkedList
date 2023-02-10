package sol;

/**
 * A class that implements linked list nodes.
 */
public class Node<S> {
    private S item;
    private Node<S> next;

    /**
     * A constructor for Node.
     *
     * @param item - the item stored at this node
     */
    public Node(S item) {
        this.item = item;
        this.next = null;
    }

    /**
     * A constructor for Node.
     *
     * @param item - the item stored at this node
     * @param next - the node which comes directly after this node in the list
     */
    public Node(S item, Node<S> next) {
        this.item = item;
        this.next = next;
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
        // TODO: finish here
        return null;
    }

    /**
     * Removes first occurrence of given item from the list
     * @param itemToRem - the item to remove the first occurrence of
     * @return boolean indicating whether an item was removed
     */
    public boolean remove(S itemToRem) {
        // TODO: discuss (in comment just below) how to finish this method
        if (this.item.equals(itemToRem)) {
            // remove node
            return true;
        } else {
            // recur until this.next is null then return false if not found
        }
        return false;
    }

    /*
       TODO:  your discussion on how to finish this method goes here
     */

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
