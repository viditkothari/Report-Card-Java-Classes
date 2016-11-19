/* @Copyright: Vidit Kothari, http://www.viditkothari.co.in | The code cannot be used, distributed, sold without permission */

public class Student{
    private int mID;
    private String mName;
    private char mGender;
    private int mAge;

    public Student(int id,String name, char gender, int age){
        mID = id;
        mName = name;
        mGender = gender;
        mAge = age;
    }

    public int getID(){
        return mID;
    }

    public String getName(){
        return mName;
    }

    public char getGender(){
        return mGender;
    }

    public int getAge(){
        return mAge;
    }

}
