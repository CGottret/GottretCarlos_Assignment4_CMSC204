/**
 * This is the interface to the Course Database Structure Class.  It is the data structure
 * class that is used with the Course Database Manager class.
 * This is a hash table with buckets.  Your hash table with be an array of
 * linked lists of CourseDatabaseElements. Use the hashcode for a
 * CourseDatabaseElement to find the location in the hash table for the linked lists of
 * CourseDatabaseElements.
 *
 * There should be two constructors.  The first one takes in an integer which represents the
 * estimated size of the hash table.
 *
 * Since the requirement is for a closed-addressing hash table (bucket hashing),
 * you will not need to compute a 4k+3 prime.
 *
 * If you were doing open-addressing, you would determine the size of the table by using a loading
 * factor of 1.5 and a 4K+3 prime.  Example: if you estimated 500 words, 500/1.5 = 333.
 * The next 4K+3 prime over 333 is 347.  So the tableSize would be 347.
 *
 * The other constructor will take in a String and an int.  The string will be "Testing"
 * and the int will be the size of the hash table.  This is used only for testing.
 */
import java.io.IOException;
import java.util.LinkedList;

public class CourseDBStructure implements CourseDBStructureInterface{
    public LinkedList<CourseDBElement>[] hashTable;
    public CourseDBStructure (int size){
        hashTable = new LinkedList[size];
    }
    public CourseDBStructure (String testing, int size){
        hashTable = new LinkedList[size];
    }

    public LinkedList<CourseDBElement>[] getHashTable() {
        return hashTable;
    }

    /**
     * Use the hashcode of the CourseDatabaseElement to see if it is
     * in the hashtable.
     * <p>
     * If the CourseDatabaseElement does not exist in the hashtable,
     * add it to the hashtable.
     *
     * @param element the CDE to be added
     */
    @Override
    public void add(CourseDBElement element) {
        int bucketIdx = element.hashCode() % getTableSize();
        LinkedList<CourseDBElement> list = hashTable[bucketIdx];
        if (list == null) {
            list = new LinkedList<>();
        }
        list.add(element);
        hashTable[bucketIdx] = list;

    }

    /**
     * Use the hashcode of the CourseDatabaseElement to see if it is
     * in the hashtable.
     * <p>
     * If the CourseDatabaseElement is in the hashtable, return it
     * If not, throw an IOException
     *
     * @param crn@throws IOException
     */
    @Override
    public CourseDBElement get(int crn) throws IOException {
        int hashCodeFromCrn = String.valueOf(crn).hashCode();
        LinkedList<CourseDBElement> list = hashTable[hashCodeFromCrn];
        if (list == null) {
            throw new IOException("cannot find element with given crn.");
        }
        return hashTable[hashCodeFromCrn].get(0);
    }

    /**
     * Returns the size of the ConcordanceDataStructure (number of indexes in the array)
     */
    @Override
    public int getTableSize() {
        return hashTable.length;
    }
}
