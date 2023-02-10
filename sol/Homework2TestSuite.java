package sol;

import org.junit.Before;
import org.junit.Test;

import org.junit.Assert;
import src.IList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

/**
 * Tests for HW2
 */
public class Homework2TestSuite {

    /**
     * Test setup:  this method runs before each test method
     * You can use this to reset your data
     */
    @Before
    public void setup() {
        // TODO: set up any testing data here
        //  (the setup method runs before *each* test method, thus resetting the data)
    }

    /* ******* HELPER METHOD FOR COMPARING LISTS **********
       Note: you may uncomment this method below to use in your testing suite
       after you've completed your get method if you'd like.

       This method depends on your get() method, so
       make sure your get() method is correct or this one will break!

       To uncomment, highlight and press Ctrl+/ or Cmd+/
     */
//    /**
//     * Checks if the two lists of integers are equal
//     *
//     * @param l1 - an Integer IList
//     * @param l2 - an Integer IList
//     * @return true if l1 and l2 have the same items in the same locations.
//     */
//    public boolean compareTwoLists(IList<Integer> l1, IList<Integer> l2) {
//        if (l1.size() != l2.size()) {
//            return false;
//        } else {
//            for (int i = 0; i < l1.size(); i++) {
//                if (!(l1.get(i).equals(l2.get(i)))) {
//                    return false;
//                }
//            }
//            return true;
//        }
//    }
}
