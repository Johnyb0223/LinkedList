package sol;

import org.junit.Before;
import org.junit.Test;

import org.junit.Assert;
import src.IList;

import javax.swing.*;

import static org.junit.Assert.*;

/**
 * Tests for HW2
 */
public class Homework2TestSuite {

    //Test Data Instance Fields
    MutableList<Integer> testList2331;
    MutableList<Integer> testList321;
    MutableList<Integer> testList21;
    MutableList<Integer> testList2;
    MutableList<Integer> testListEmpty;
    MutableList<Integer> testList202;
    MutableList<Integer> testList02;
    MutableList<Integer> testList22;



    /**
     * Test setup:  this method runs before each test method
     * You can use this to reset your data
     */
    @Before
    public void setup() {

        //Sets up testList that will contain one element (int 1)
        this.testList321 = new MutableList<>();
        this.testList321.addFirst(3);
        this.testList321.addLast(2);
        this.testList321.addLast(1);

        this.testList2 = new MutableList<>();
        this.testList2.addFirst(2);

        this.testListEmpty = new MutableList<>();

        this.testList2331 = new MutableList<>();
        this.testList2331.addFirst(3);
        this.testList2331.addFirst(2);
        this.testList2331.addLast(3);
        this.testList2331.addLast(1);

        this.testList21 = new MutableList<>();
        this.testList21.addFirst(1);
        this.testList21.addFirst(2);

        this.testList202 = new MutableList();
        this.testList202.addFirst(2);
        this.testList202.addFirst(0);
        this.testList202.addFirst(2);

        this.testList02 = new MutableList<>();
        this.testList02.addFirst(0);
        this.testList02.addLast(2);

        this.testList22 = new MutableList<>();
        this.testList22.addLast(2);
        this.testList22.addFirst(2);



    }

    /* ******* HELPER METHOD FOR COMPARING LISTS **********
       Note: you may uncomment this method below to use in your testing suite
       after you've completed your get method if you'd like.

       This method depends on your get() method, so
       make sure your get() method is correct or this one will break!

       To uncomment, highlight and press Ctrl+/ or Cmd+/
     */
    /**
     * Checks if the two lists of integers are equal
     *
     * @param l1 - an Integer IList
     * @param l2 - an Integer IList
     * @return true if l1 and l2 have the same items in the same locations.
     */
    public boolean compareTwoLists(IList<Integer> l1, IList<Integer> l2) {
        if (l1.size() != l2.size()) {
            return false;
        } else {
            for (int i = 0; i < l1.size(); i++) {
                if (!(l1.get(i).equals(l2.get(i)))) {
                    return false;
                }
            }
            return true;
        }
    }

    /**
     * test the get() method which returns the item at a specified index
     * */
    @Test
    public void testGetMethod(){
        int get1 = this.testList321.get(2);
        int get2 = this.testList2.get(0);
        Assert.assertEquals(1, get1);
        Assert.assertEquals(2, get2 );
    }

    /**
     * test the get() method to ensure it throws an exception if the index is to large for the list
     * */
    @Test(expected = RuntimeException.class)
    public void testGetMethodIndexToLargeException(){this.testListEmpty.get(1);}

    /**
     * test the get() method to ensure it throws an exception if the index is negative
     * */
    @Test(expected = RuntimeException.class)
    public void testGetMethodNegativeIndexException(){this.testList2.get(-1);}

    /**
     * throw runtime exception if we try and index an empty list
     * */
    @Test(expected = RuntimeException.class)
    public void testIndexEmptyListException(){
        this.testListEmpty.get(0);
    }

    /**
     * test the addLast method which adds an element to the end of the list
     * */
    @Test
    public void testAddLastMethod(){
        this.testList2.addFirst(3);
        this.testList2.addLast(1);
        Assert.assertEquals(this.testList2.toString(), this.testList321.toString());
    }

    /**
     * size() test that ensures the size is properly implemented when both the addLast() and addFirst() method
     * are used to add elements to the list
     * */
    @Test
    public void testSizeMethod(){
        MutableList<Integer> sizeTest = new MutableList<>();
        sizeTest.addLast(3);
        sizeTest.addFirst(2);
        sizeTest.addLast(2);

        Assert.assertEquals(3, sizeTest.size());



    }

    /**
     * test remove() method to ensure we remove the first instance of the object and it also get removed from the
     * linked list as this is a mutable list.
     * */
    @Test
    public void testRemoveNode(){

        //Removing item from empty list returns false
        Assert.assertFalse(this.testListEmpty.remove(2));
        System.out.println("Removing item from empty list return false " + this.testListEmpty.remove(2));

        //Remove the first instance of 3
        assertTrue(this.testList2331.remove(3));
        Assert.assertEquals("[2, 3, 1]", this.testList2331.toString());
        System.out .println("Successfully removed the first instance of 3 " + this.testList2331.toString());

        //We don't have to successfully remove the tail.
        assertFalse(this.testList2331.remove(1));
        Assert.assertEquals("[2, 3, 1]", this.testList2331.toString());
        System.out.println("We don't handle removing the tail " + this.testList2331.toString());

        //Remove the middle 3
        Assert.assertEquals(true, this.testList2331.remove(3));
        Assert.assertEquals("[2, 1]", this.testList2331.toString());
        System.out.println("Remove tail 3 " + this.testList2331.toString());

        //Add two to head of list
        this.testList2331.addFirst(2);
        Assert.assertEquals("2", this.testList2331.get(0).toString());
        //Successfully added two to head of list, size should be three
        Assert.assertEquals( 3, this.testList2331.size());
        System.out.println("Size equals 3 " + this.testList2331.size());
        Assert.assertEquals("[2, 2, 1]", this.testList2331.toString());
        System.out.println("Successfully added 2 two head " + this.testList2331.toString());

        //Add 4 to tail of list
        this.testList2331.addLast(4);
        System.out.println("Try to add 4 to end");
        Assert.assertEquals("[2, 2, 1, 4]", this.testList2331.toString());
        System.out.println("We added four to the end of the list" + this.testList2331.toString());

        //Check head really equals 2
        Assert.assertEquals("2", this.testList2331.get(0).toString());
        System.out.println("Yes, head is really 2 " + this.testList2331.get(0).toString());
        //Check if mid really equals 2
        Assert.assertEquals("2", this.testList2331.get(1).toString());
        System.out.println("Yes the 2nd element is really two " + this.testList2331.get(1).toString());
        //Check Size is now 2
        System.out.println("We know have four elements in the list so size should equal 4");
        Assert.assertEquals(4, this.testList2331.size());
        System.out.println("The size now equals 4 " + this.testList2331.size());
        //Remove an element and see if it decrements the size
        //Remove head
        Assert.assertEquals(false, this.testList2331.remove(2));           //Uncomment before turning in
        Assert.assertEquals("[2, 2, 1, 4]", this.testList2331.toString());
        System.out.println("We didn't remove the head " + this.testList2331.toString());
        assertEquals("[2, 2, 1, 4]", this.testList2331.toString());
        //Assert.assertEquals(4, this.testList2331.size());
        System.out.println("The size now equals 3 which is good");
        //Remove 3 but 3 is not found
        Assert.assertFalse(this.testList2331.remove(3));
        //Tried to remove and element not int the list and returned false
        System.out.println("Tried to remove an element not in the list, returned false" + this.testList2331.toString());
        //Noo element was removed
        //Assert.assertEquals(4, this.testList2331.size());
        System.out.println("Size still equals 3 " + this.testList2331.size());

        this.testList202.remove(2);
        assertEquals("2", this.testList202.getFirst().toString());

    }

    /**
     * Test our get node function
     * */
    @Test
    public void testGetNode(){
        //Let's get the first node in a list
        Node returnedNode = this.testList2331.getNode(2);
        assertEquals(2, returnedNode.getItem());
        assertEquals("[2, 3, 3, 1]", this.testList2331.toString());
        System.out.println("We found the correct node and didn't remove it from the list");

        //Let's remove a 3 from out list and search for the node
        this.testList2331.remove(3);

        Node foundNode3 = this.testList2331.getNode(3);
        assertEquals(3, foundNode3.getItem());
        assertEquals("[2, 3, 1]", this.testList2331.toString());
        System.out.println("We found the correct node and didn't remove it from the list");
    }

    /**
     * Now we need to throw a runtime exception if we did not find the node in the list
     */
    @Test(expected = RuntimeException.class)
    public void testGetNodeException(){
        this.testList202.remove(0);
        this.testList202.getNode(0);
    }



    /**
     * test that remove() returns false when unable to find the item in the list. Leaves the list unmodified
     *  */
    @Test
    public void testRemoveNodeReturnFalse(){

        Assert.assertFalse(this.testList2.remove(5));
        Assert.assertFalse(this.testList321.remove(0));
        Assert.assertFalse(this.testListEmpty.remove(3));
    }

    /**
     * Test remove node in the MutableList class
     * This function removes the node that matches a given item
     * This will be a constant runtime function and must handle the beginning and end of the list
     * Throws illegal argument exception if the node passed is null
     * */
    @Test
    public void testRemoveNodeMutableList(){

        //Lets remove the first node in a list

        this.testList321.removeNode(this.testList321.getNode(3));
        assertEquals("[2, 1]", this.testList321.toString());
        System.out.println("Removed the first node in the list");

        //Let's remove the last node in the list
        this.testList321.removeNode(this.testList321.getNode(1));
        assertEquals("[2]", this.testList321.toString());
        System.out.println("Successfully removed the last node in a list");

        //Now lets remove the first instance of a node
        this.testList2331.removeNode(this.testList2331.getNode(3));
        assertEquals("[2, 3, 1]", this.testList2331.toString());
        System.out.println("Successfully removed the first instance of an item in the list");

        //Lets remove a node in the middle of a list
        this.testList202.removeNode(this.testList202.getNode(0));
        assertEquals("[2, 2]", this.testList202.toString());
        System.out.println("We have successfully removed the middle node");

    }

    /**
     * lets make sure we throw an exception when the the node passed to remove is null
     * */
    @Test(expected = IllegalArgumentException.class)
    public void testRemoveNodeIllegalArgumentException(){
        this.testList202.removeNode(null);
    }

    /**
     * test removeWithNode
     *
     * should return false if no node found and true if node is found and removed
     * */
    @Test
    public void testRemoveWithNode(){

        //Lets try to remove a node from an empty list
        Assert.assertFalse(this.testListEmpty.removeWithNode(3));
        System.out.println("Returned false when trying to remove a node from empty list");

        //Now lets see if we return false when the item is not in the list
        assertFalse(this.testList2331.removeWithNode(4));
        System.out.println("Returned false when item was not in the list");

        //Now lets remove the first item in the list
        assertTrue(this.testList2331.removeWithNode(2));
        assertEquals("[3, 3, 1]", this.testList2331.toString());
        System.out.println("Successfully removed the head node");

        //Now lets remove the tail item
        assertTrue(this.testList2331.removeWithNode(1));
        assertEquals("[3, 3]", this.testList2331.toString());
        System.out.println("We have removed the tail of the list");

        //Now lets remove the first instance of a duplicate
        assertTrue(this.testList2331.removeWithNode(3));
        assertEquals("[3]", this.testList2331.toString());
        System.out.println("We removed the first instance of the duplicate");

        //Now lets remove the last item in the list
        assertTrue(this.testList2331.removeWithNode(3));
        assertEquals("[]", this.testList2331.toString());
        System.out.println("Successfully removed the last item in the list");
    }

    /**
     * testDoubleRemove
     * */
    @Test
    public void testDoubleRemove(){
//        Node node = this.testList321.getNode(2);
//        this.testList321.removeNode(node);
//        this.testList321.removeNode(node);
//
//        assertEquals("[3, 1]", this.testList321.toString());
//        assertEquals(2, this.testList321.size());

        /**
         * This is interesting! Its like node gets set to the node reference and get is not called again otherwise it
         * would recognize that the node no longer exists in the list. One way top fix this is to ensure getNode
         * is called again and you don't use the value already referenced node. We could have remove delete the node in
         * in memory when it is removed from the list forcing get node to run again*/

    }

}
