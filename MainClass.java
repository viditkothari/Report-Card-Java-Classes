/* @Copyright: Vidit Kothari, http://www.viditkothari.co.in | The code cannot be used, distributed, sold without permission */

public class MainClass {
    public static void main (String args[]){
        Student s1=new Student(4521,"Vidit",'M',24);
        ReportCard rc1=new ReportCard(s1);

        // Setting 1st Semester Score
	rc1.setScore(1,1,80);
	rc1.setScore(1,2,72);
	rc1.setScore(1,3,63);
	rc1.setScore(1,4,54);
        rc1.setScore(1,5,45);

	// Setting 2nd Semester Score
        rc1.setScore(2,1,100);
        rc1.setScore(2,2,90);
        rc1.setScore(2,3,85);
        rc1.setScore(2,4,72);
        rc1.setScore(2,5,66);

        System.out.print("\n");
        
	// Printing the Report card for Student 's1' by simply printing the ReportCard object with Overridden .toString() method
        System.out.print(rc1.toString());
    }
}
