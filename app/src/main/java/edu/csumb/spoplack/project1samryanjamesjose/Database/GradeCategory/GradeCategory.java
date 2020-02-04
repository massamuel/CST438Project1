package edu.csumb.spoplack.project1samryanjamesjose.Database.GradeCategory;


import androidx.room.Entity;

@Entity(tableName = "grade_category_table")
public class GradeCategory {

    private String Title;
    private double Weight;
    private long gradeID;
    private String AssignedDate;
    private long categoryID;

    public GradeCategory(String title, double weight, long gradeID, String assignedDate, long categoryID) {
        this.Title = title;
        this.Weight = weight;
        this.gradeID = gradeID;
        this.AssignedDate = assignedDate;
        this.categoryID = categoryID;
    }

    public String getTitle() {return Title;}
    public double getWeight() {return Weight;}
    public long getGradeID() {return gradeID;}
    public String getAssignedDate() {return AssignedDate;}
    public long getCategoryID() {return categoryID;}



    public void setTitle(String title) {this.Title = title;}
    public void setWeight(double weight) {this.Weight = weight;}
    public void setGradeID(long gradeid) {this.gradeID =  gradeid;}
    public void setAssignedDate(String assignedDate) {this.AssignedDate = assignedDate;}
    public void setCategoryID(long categoryid) {this.categoryID = categoryid;}

    /*
    Title
Weight
GradeID
AssignedDate
categoryID

     */
}
