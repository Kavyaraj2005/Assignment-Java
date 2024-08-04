package Enroll;
public class Course{
   private int courseID;
   private  String courseName;
    private int credits;
    public Course(int courseID,String courseName,int credits)
    {
        this.courseID = courseID;
        this.courseName = courseName;
        this.credits = credits;
    }
    public int getCourseID()
    {
        return courseID;
    }
    public String getCourseName()
    {
        return courseName;
    }
    public int getcredits()
    {
        return credits;
    }
    public String toString()
    {
        return "Course ID: " + courseID+" "+ "Course Name: "+ courseName+" "+" Credits: "+credits;
    }
}