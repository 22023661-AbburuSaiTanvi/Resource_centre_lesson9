import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

// C206 AY2023 SEM1 - Eclipse 21-09 JDK16

public class ResourceCentreTest {
    // prepare test data
    private Camcorder cc1;
    private Camcorder cc2;
    private Camcorder cc3;
    private Chromebook cb1;
    private Chromebook cb2;
    private Chromebook cb3;

    private ArrayList<Camcorder> camcorderList;
    private ArrayList<Chromebook> chromebookList;

    public ResourceCentreTest() {
        super();
    }

    @Before
    public void setUp() throws Exception {
        // prepare test data
        cc1 = new Camcorder("CC0011", "Nikon HDSLR", 40);
        cc2 = new Camcorder("CC0012", "Sony DSC-RX100M7", 20);
        cc3 = new Camcorder("CC0013", "panasoni DSC-RX100M7", 30);
        cb1 = new Chromebook("CB0011", "My Google Chromebook 1st", "Mac OS");
        cb2 = new Chromebook("CB0012", "SAMSUNG Chromebook 4+", "Win 10");
        cb3 = new Chromebook("CB0013", "HUAWEI Magicbook 100+", "Mac 10");

        camcorderList = new ArrayList<Camcorder>();
        chromebookList = new ArrayList<Chromebook>();
    }

    @Test
    public void testAddCamcorder() {
        // Item list is not null and it is empty
        assertNotNull("Test if there is a valid Camcorder arraylist to add to", camcorderList);
        assertEquals("Test that the Camcorder arraylist is empty.", 0, camcorderList.size());

        // Given an empty list, after adding 1 item, the size of the list is 1
        ResourceCentre.addCamcorder(camcorderList, cc1);
        assertEquals("Test that the Camcorder arraylist size is 1.", 1, camcorderList.size());
        assertTrue("Test that the Camcorder is added successfully.", camcorderList.contains(cc1));

        // Add an item
        ResourceCentre.addCamcorder(camcorderList, cc2);
        assertEquals("Test that the Camcorder arraylist size is now 2.", 2, camcorderList.size());
        assertTrue("Test that the Camcorder is added successfully.", camcorderList.contains(cc2));

        // Add an item that already exists in the list
        ResourceCentre.addCamcorder(camcorderList, cc2);
        assertEquals("Test that the Camcorder arraylist size is unchanged.", 2, camcorderList.size());

        // Add an item that has missing details
        Camcorder cc_missing = new Camcorder("CC0014", "", 60);
        ResourceCentre.addCamcorder(camcorderList, cc_missing);
        assertEquals("Test that the Camcorder arraylist size is unchanged.", 2, camcorderList.size());

        // Display success message
        System.out.println("testAddCamcorder: All test cases passed!");

        // write your code here
    }

    @Test
    public void testAddChromebook() {
        // Item list is not null and it is empty
        assertNotNull("Test if there is a valid Chromebook arraylist to add to", chromebookList);
        assertEquals("Test that the Chromebook arraylist is empty.", 0, chromebookList.size());

        // Given an empty list, after adding 1 item, the size of the list is 1
        ResourceCentre.addChromebook(chromebookList, cb1);
        assertEquals("Test that the Chromebook arraylist size is 1.", 1, chromebookList.size());
        assertTrue("Test that the Chromebook is added successfully.", chromebookList.contains(cb1));

        // Add an item
        ResourceCentre.addChromebook(chromebookList, cb2);
        assertEquals("Test that the Chromebook arraylist size is now 2.", 2, chromebookList.size());
        assertTrue("Test that the Chromebook is added successfully.", chromebookList.contains(cb2));

        // Add an item that already exists in the list
        ResourceCentre.addChromebook(chromebookList, cb2);
        assertEquals("Test that the Chromebook arraylist size is unchanged.", 2, chromebookList.size());

        // Add an item that has missing details
        Chromebook cb_missing = new Chromebook("CB0014", "", "Win 11");
        ResourceCentre.addChromebook(chromebookList, cb_missing);
        assertEquals("Test that the Chromebook arraylist size is unchanged.", 2, chromebookList.size());

        // Display success message
        System.out.println("testAddChromebook: All test cases passed!");

        // write your code here
    }

    @Test
    public void testRetrieveAllCamcorder() {
        // Test Case 1
        // Test if the Camcorder arraylist is not null and empty
        assertNotNull("Test if there is a valid Camcorder arraylist to retrieve from", camcorderList);
        assertEquals("Test that the Camcorder arraylist is empty.", 0, camcorderList.size());
        // Attempt to retrieve the Camcorders
        String allCamcorder = ResourceCentre.retrieveAllCamcorder(camcorderList);
        String testOutput = "";
        // Test if the output is empty
        assertEquals("Test that nothing is displayed", testOutput, allCamcorder);

        // Test Case 2
        ResourceCentre.addCamcorder(camcorderList, cc1);
        ResourceCentre.addCamcorder(camcorderList, cc2);
        // Test that the list is not empty
        assertEquals("Test that the Camcorder arraylist size is 2.", 2, camcorderList.size());
        // Attempt to retrieve the Camcorders
        allCamcorder = ResourceCentre.retrieveAllCamcorder(camcorderList);
        testOutput = String.format("%-10s %-30s %-10s %-10s %-20d\n", "CC0011", "Nikon HDSLR", "Yes", "", 40);
        testOutput += String.format("%-10s %-30s %-10s %-10s %-20d\n", "CC0012", "Sony DSC-RX100M7", "Yes", "", 20);
        // Test that the details are displayed correctly
        assertEquals("Test that the display is correct.", testOutput, allCamcorder);

        // Display success message
        System.out.println("testRetrieveAllCamcorder: All test cases passed!");

        // write your code here
    }

    @Test
    public void testRetrieveAllChromebook() {
        // Test Case 1
        // Test if the Chromebook arraylist is not null and empty
        assertNotNull("Test if there is a valid Chromebook arraylist to retrieve from", chromebookList);
        assertEquals("Test that the Chromebook arraylist is empty.", 0, chromebookList.size());
     // Attempt to retrieve the Camcorders
        String allCamcorder = ResourceCentre.retrieveAllCamcorder(camcorderList);
        String testOutput = "";

        // Test if the output is empty
        assertEquals("Test that nothing is displayed", testOutput, allCamcorder);

        // Test Case 2
        ResourceCentre.addCamcorder(camcorderList, cc1);
        ResourceCentre.addCamcorder(camcorderList, cc2);

        // Test that the list is not empty
        assertEquals("Test that the Camcorder arraylist size is 2.", 2, camcorderList.size());

        // Attempt to retrieve the Camcorders
        allCamcorder = ResourceCentre.retrieveAllCamcorder(camcorderList);
        testOutput += String.format("%-10s %-30s %-10s %-10s %-20d\n", "CC0011", "Nikon HDSLR", "Yes", "", 40);
        testOutput += String.format("%-10s %-30s %-10s %-10s %-20d\n", "CC0012", "Sony DSC-RX100M7", "Yes", "", 20);

        // Test that the details are displayed correctly
        assertEquals("Test that the display is correct.", testOutput, allCamcorder);
    }
    
    @Test
    public void testDoLoanCamcorder() {
        // Test Case 1 - Loan an available item
        assertNotNull("Test if there is a valid Camcorder arraylist to loan from", camcorderList);
        ResourceCentre.addCamcorder(camcorderList, cc1);
        boolean isLoaned = ResourceCentre.doLoanCamcorder(camcorderList, "CC0011", "8-8-2020");
        assertTrue("Test if an available item is successfully loaned.", isLoaned);
        assertFalse("Test that the item is not available after loaning.", camcorderList.get(0).getIsAvailable());
        assertEquals("Test that the due date is updated after loaning.", "8-8-2020",
                camcorderList.get(0).getDueDate());

        // Test Case 2 - Loan an unavailable item
        cc2.setIsAvailable(false);
        ResourceCentre.addCamcorder(camcorderList, cc2);
        assertFalse("Test that an unavailable item cannot be loaned.", ResourceCentre.doLoanCamcorder(camcorderList, "CC0012", "8-8-2020"));

        // Test Case 3 - Loan an item that does not exist
        assertFalse("Test that a non-existent item cannot be loaned.", ResourceCentre.doLoanCamcorder(camcorderList, "CC0013", "8-8-2020"));

        // Test Case 4 - Loan an item with missing details
        ResourceCentre.addCamcorder(camcorderList, cc3);
        assertFalse("Test that an item with missing details cannot be loaned.", ResourceCentre.doLoanCamcorder(camcorderList, "CC0013", ""));

        // Display success message
        System.out.println("testDoLoanCamcorder: All test cases passed!");

        // write your code here
    }

    @Test
    public void testDoLoanChromebook() {
        // Test Case 1 - Loan an available item
        assertNotNull("Test if there is a valid Chromebook arraylist to loan from", chromebookList);
        ResourceCentre.addChromebook(chromebookList, cb1);
        boolean isLoaned = ResourceCentre.doLoanChromebook(chromebookList, "CB0011", "8-8-2020");
        assertTrue("Test if an available item is successfully loaned.", isLoaned);
        assertFalse("Test that the item is not available after loaning.", chromebookList.get(0).getIsAvailable());
        assertEquals("Test that the due date is updated after loaning.", "8-8-2020",
                chromebookList.get(0).getDueDate());

        // Test Case 2 - Loan an unavailable item
        cb2.setIsAvailable(false);
        ResourceCentre.addChromebook(chromebookList, cb2);
        assertFalse("Test that an unavailable item cannot be loaned.", ResourceCentre.doLoanChromebook(chromebookList, "CB0012", "8-8-2020"));

        // Test Case 3 - Loan an item that does not exist
        assertFalse("Test that a non-existent item cannot be loaned.", ResourceCentre.doLoanChromebook(chromebookList, "CB0013", "8-8-2020"));

        // Test Case 4 - Loan an item with missing details
        ResourceCentre.addChromebook(chromebookList, cb3);
        assertFalse("Test that an item with missing details cannot be loaned.", ResourceCentre.doLoanChromebook(chromebookList, "CB0013", ""));

        // Display success message
        System.out.println("testDoLoanChromebook: All test cases passed!");

        // write your code here
    }

    @Test
    public void testDoReturnCamcorder() {
        // Test Case 1 - Return a loaned out item
        assertNotNull("Test if there is a valid Camcorder arraylist to return to", camcorderList);
        ResourceCentre.addCamcorder(camcorderList, cc1);
        boolean isLoaned = ResourceCentre.doLoanCamcorder(camcorderList, "CC0011", "8-8-2020");
        assertTrue("Test if CC0011 is successfully loaned out.", isLoaned);
        boolean isReturned = ResourceCentre.doReturnCamcorder(camcorderList, "CC0011");
        assertTrue("Test if CC0011 is successfully returned.", isReturned);
        assertTrue("Test that the item is available after returning.", camcorderList.get(0).getIsAvailable());

        // Test Case 2 - Return an item that is not loaned out
        assertFalse("Test that an item that is not loaned out cannot be returned.", ResourceCentre.doReturnCamcorder(camcorderList, "CC0011"));

        // Test Case 3 - Return an item that does not exist
        assertFalse("Test that a non-existent item cannot be returned.", ResourceCentre.doReturnCamcorder(camcorderList, "CC0012"));

        // Display success message
        System.out.println("testDoReturnCamcorder: All test cases passed!");

        // write your code here
    }

    @Test
    public void testDoReturnChromebook() {
        // Test Case 1 - Return a loaned out item
        assertNotNull("Test if there is a valid Chromebook arraylist to return to", chromebookList);
        ResourceCentre.addChromebook(chromebookList, cb1);
        boolean isLoaned = ResourceCentre.doLoanChromebook(chromebookList, "CB0011", "8-8-2020");
        assertTrue("Test if CB0011 is successfully loaned out.", isLoaned);
        boolean isReturned = ResourceCentre.doReturnChromebook(chromebookList, "CB0011");
        assertTrue("Test if CB0011 is successfully returned.", isReturned);
        assertTrue("Test that the item is available after returning.", chromebookList.get(0).getIsAvailable());

        // Test Case 2 - Return an item that is not loaned out
        assertFalse("Test that an item that is not loaned out cannot be returned.", ResourceCentre.doReturnChromebook(chromebookList, "CB0011"));

        // Test Case 3 - Return an item that does not exist
        assertFalse("Test that a non-existent item cannot be returned.", ResourceCentre.doReturnChromebook(chromebookList, "CB0012"));

        // Display success message
        System.out.println("testDoReturnChromebook: All test cases passed!");

        // write your code here
    }

    @After
    public void tearDown() throws Exception {
        cc1 = null;
        cc2 = null;
        cc3 = null;
        cb1 = null;
        cb2 = null;
        cb3 = null;
        camcorderList = null;
        chromebookList = null;
    }
}
