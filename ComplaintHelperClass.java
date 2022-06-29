package com.example.onlinegrievance;

public class ComplaintHelperClass {
    String studentID,complaint;

    public ComplaintHelperClass() {

    }

    public ComplaintHelperClass(String studentID, String complaint) {
        this.studentID = studentID;
        this.complaint = complaint;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getComplaint() {
        return complaint;
    }

    public void setComplaint(String complaint) {
        this.complaint = complaint;
    }
}
