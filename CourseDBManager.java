import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class CourseDBManager implements CourseDBManagerInterface {
    private CourseDBStructure cds;

    public CourseDBManager() {
        cds = new CourseDBStructure(100);
    }

    @Override
    public void add(String id, int crn, int credits, String roomNum, String instructor) {
        CourseDBElement cde = new CourseDBElement(id, crn, credits, roomNum, instructor);
        cds.add(cde);
    }

    @Override
    public CourseDBElement get(int crn) {
        try {
            return cds.get(crn);
        } catch (IOException e) {

        }
        return null;
    }

    @Override
    public void readFile(File input) throws FileNotFoundException {
    // CMSC100 21556 2 Distance-Learning Janet E. Joy
        try {
            Scanner scanner = new Scanner(input);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] values = line.split(" ");
                CourseDBElement cde = new CourseDBElement(

                );
                add(
                        values[0],
                        Integer.parseInt(values[1]),
                        Integer.parseInt(values[2]),
                        values[3],
                        values[4]
                );
            }
            scanner.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<String> showAll() {
        ArrayList<String> all = new ArrayList<>();
        for (LinkedList<CourseDBElement> list : cds.getHashTable()) {
            if (list == null) {
                continue;
            }
            all.add(list.get(0).toString());
        }
        return all;
    }
}
