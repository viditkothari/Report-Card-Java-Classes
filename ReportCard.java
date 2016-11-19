/* @Copyright: Vidit Kothari, http://www.viditkothari.co.in | The code cannot be used, distributed, sold without permission */

class ReportCard {

    private static final int[] GRADES = {40,60,80};
    private static final String mSubjects[] = {"Mathematics","Science","Arts","History","Language"};

    /*
    *  Logically 'subjectCode' for each 'mSubject' is:
    *  Mathematics: 1
    *  Science:  2
    *  Arts:  3
    *  History:  4
    *  Language:  5
    *
    *  I guess using 'static' will help interpreter because GRADES[] or mSubjects[] array will already be defined for other new instances of 'ReportCard' class
    */

    private int mStuID;
    private String mStuName;
    private char mStuGender;
    private int mStuAge;
    private int mscores[][]=new int[2][5]; // Student's score will be saved to its corresponding int[semester][subjectCode]  array slot.

    public ReportCard(Student student){
         mStuID = student.getID();
         mStuName = student.getName();
         mStuGender = student.getGender();
         mStuAge = student.getAge();
    }

    // To set score for each subject per semester
    public void setScore(int semester, int subjectCode, int score) {
        // Implementing a check to prevent an Exception
        switch (semester) {
            case 1: switch(subjectCode){
                        case 1: mscores[0][subjectCode-1]=score;break;
                        case 2: mscores[0][subjectCode-1]=score;break;
                        case 3: mscores[0][subjectCode-1]=score;break;
                        case 4: mscores[0][subjectCode-1]=score;break;
                        case 5: mscores[0][subjectCode-1]=score;break;
                    }
                    break;
            case 2: switch(subjectCode){
                        case 1: mscores[1][subjectCode-1]=score;break;
                        case 2: mscores[1][subjectCode-1]=score;break;
                        case 3: mscores[1][subjectCode-1]=score;break;
                        case 4: mscores[1][subjectCode-1]=score;break;
                        case 5: mscores[1][subjectCode-1]=score;break;
                    }
            break; // or cause an error / interruption to occur;
        }
    }

    /*
     * Implementing function overloading so that when the two parameters are passed to getScore(), ~~ semester's subject score ~~ is returned
     * If not, then ~~ total score ~~ (float datatype) is returned
     */

    // To get score for an individual subject in a particular semester
    public int getScore(int semester, int subjectCode) {
        // Implementing a check to prevent an Exception
        switch (semester) {
            case 1: switch(subjectCode){
                        case 1: return mscores[0][subjectCode-1];
                        case 2: return mscores[0][subjectCode-1];
                        case 3: return mscores[0][subjectCode-1];
                        case 4: return mscores[0][subjectCode-1];
                        case 5: return mscores[0][subjectCode-1];
                    }
            case 2: switch(subjectCode){
                        case 1: return mscores[1][subjectCode-1];
                        case 2: return mscores[1][subjectCode-1];
                        case 3: return mscores[1][subjectCode-1];
                        case 4: return mscores[1][subjectCode-1];
                        case 5: return mscores[1][subjectCode-1];
                    }
            break;
        }
        return 0;
    }

    // To get score for all subjects in a particular semester
    public int[] getScore(int semester) {
        int[] scoresForASemester = new int[5];

        // Implementing a check to prevent an Exception
        if (semester==1 || semester==2) {
            for(int i=0;i<scoresForASemester.length;i++)
                scoresForASemester[i]=mscores[semester][i];
            return scoresForASemester;
        }
        return scoresForASemester;
    }

    // To get overall avg. of all subjects' total score.
    public float getScore(){
        int[] sum=new int[mSubjects.length]; // temporary array to store sum of each subject in both semesters
        float avg=0.0f;
        for(int i=0;i<mSubjects.length;i++){
            sum[i]=mscores[0][i]+mscores[1][i];
            avg+=sum[i];
        }
        if(avg!=0) //Check for division by zero
        	return (float)(avg/mSubjects.length); // Testing if floating from outside the parenthesis results in precise fractional value.
        else
        	return 0.0f;
    }

    public String getResult(){
    	float tempScore=getScore();
    	if(tempScore>=GRADES[2])
    		return "Grade Scored: A";
    	else if(tempScore>=GRADES[1])
    		return "Grade Scored: B";
    	else if(tempScore>=GRADES[0])
    		return "Grade Scored: C";
    	else
    		return "FAILED!";
    }

    //To print with some descriptive text
    public void printScore(int semester, int subjectCode){
    	if(getScore(semester,subjectCode)>0)
    		System.out.println("Student scored " + mscores[semester-1][subjectCode-1] + " in " + mSubjects[subjectCode-1] + "\n");
    	else
    		System.out.println("Either marks hasn't been set or unfortunately you FAILED! ;)");
    }

    @Override
    public String toString(){
    	return("STUDENT'S Details:\n-----------------------\nStudent ID: " + mStuID + "\n" +
    			"Student Name: " + mStuName + "\n" +
    			"Gender: " + mStuGender + "\n" +
    			"Age: " + mStuAge + "\n" + 
    			"-----------------------\n" + 
    			"SCORECARD:" + "\n" +
    			"-----------------------\n" + 
    			String.format("%-13s : %5.2f\n",mSubjects[0],((float)(mscores[0][0]+mscores[1][0])/2.0f)) + 
    			String.format("%-13s : %5.2f\n",mSubjects[1],((float)(mscores[0][1]+mscores[1][1])/2.0f)) + 
    			String.format("%-13s : %5.2f\n",mSubjects[2],((float)(mscores[0][2]+mscores[1][2])/2.0f)) + 
    			String.format("%-13s : %5.2f\n",mSubjects[3],((float)(mscores[0][3]+mscores[1][3])/2.0f)) + 
    			String.format("%-13s : %5.2f\n",mSubjects[4],((float)(mscores[0][4]+mscores[1][4])/2.0f)));
    }
}
