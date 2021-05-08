import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class CourseDBManager_STUDENT_Test {

    private CourseDBManagerInterface dataMgr = new CourseDBManager();

    /**
     * Create an instance of CourseDBManager
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
        dataMgr = new CourseDBManager();
    }

    /**
     * Set dataMgr reference to null
     * @throws Exception
     */
    @After
    public void tearDown() throws Exception {
        dataMgr = null;
    }

    /**
     * Test for the createConcordanceArray method
     * Use the String text created in setUp()
     */
    @Test
    public void testAddToDB() {
        try {
            dataMgr.add("CMSC204",12345,4,"SC420","Joe Mama");
        }
        catch(Exception e) {
            fail("This should not have caused an Exception");
        }
    }
    /**
     * Test for the showAll method
     */
    @Test
    public void testShowAll() {
        dataMgr.add("CMSC204",10001,4,"SC420","Joe Mama");
        dataMgr.add("CMSC204",10002,4,"SC6969","Peter Yu");
        dataMgr.add("CMSC204",10003,4,"SC430","Mauri Got");
        ArrayList<String> list = dataMgr.showAll();

        assertEquals(list.get(0),"\nCourse:CMSC204 CRN:10001 Credits:4 Instructor:Joe Mama Room:SC420");
        assertEquals(list.get(1),"\nCourse:CMSC204 CRN:10002 Credits:4 Instructor:Peter Yu Room:SC6969");
        assertEquals(list.get(2),"\nCourse:CMSC204 CRN:10003 Credits:4 Instructor:Mauri Got Room:SC430");
    }
    /**
     * Test for the read method
     */
    @Test
    public void testRead() {
        try {
            File inputFile = new File("Test1.txt");
            PrintWriter inFile = new PrintWriter(inputFile);
            inFile.println("CMSC204 12345 4 SC6969 Joe Mama");
            inFile.print("CMSC204 67891 4 SC420 I.M. Stinky");

            inFile.close();
            dataMgr.readFile(inputFile);
            //System.out.println(dataMgr.showAll());
        } catch (Exception e) {
            fail("Should not have thrown an exception");
        }
    }
}
