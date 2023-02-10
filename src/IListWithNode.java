package src;

import sol.Node;

/**
 * An interface for a List that explicitly interacts with node.
 *
 * @param <T> - the type of items in the list
 */
public interface IListWithNode<T> {

    /**
     * Returns the node that contains the specified item.
     *
     * @param item -- an item in the list
     * @throws RuntimeException "Item not found" when the item is not in the list
     * @return the first Node that contains the given item
     */
    public Node<T> getNode(T item);

    /**
     * Removes a node from the list given a reference to
     * the actual node object.
     *
     * @param node - the node to remove
     * @throws IllegalArgumentException "removeNode given null input" when the input node is null
     */
    public void removeNode(Node<T> node);

    /**
     * Removes a node from the list given an item to be removed.
     * Implementation is expected to use getNode and removeNode methods from IListWithNode
     * If the item is not in the list, the list is
     * unchanged. If the item occurs more than once in the list, removes only the
     * first instance.
     *
     * @param item -- an item in the list to be removed
     * @return whether or not the item was successfully removed from the list
     */
    public boolean removeWithNode(T item);
}
