public class CourseDBElement implements Comparable{
    private String courseID;
    private int crn;
    private int numOfCredits;
    private String roomNum;
    private String instructorName;

    public CourseDBElement() {}
    public CourseDBElement (String courseID, int crn, int numOfCredits, String roomNum, String instructorName){
        this.courseID = courseID;
        this.crn = crn;
        this.numOfCredits = numOfCredits;
        this.roomNum = roomNum;
        this.instructorName = instructorName;
    }

    public void setCRN(int crn) {
        this.crn = crn;
    }

    public int getCRN() {
        return crn;
    }

    @Override
    public int hashCode() {
        return String.valueOf(crn).hashCode();
    }


//"\nCourse:CMSC203 CRN:30503 Credits:4 Instructor:Jill B. Who-Dunit Room:SC450");
    @Override
    public String toString() {
        return "\nCourse:" + courseID + " CRN:" + crn + " Credits:" + numOfCredits + " Instructor:" + instructorName + " Room:" + roomNum;
    }


    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
