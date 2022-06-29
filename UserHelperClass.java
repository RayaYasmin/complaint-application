package com.example.onlinegrievance;

public class UserHelperClass {
   String username,email,password,Department,Student_ID;

    public UserHelperClass() {

    }

    public UserHelperClass(String username, String email, String password,String Department, String Student_ID) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.Department = Department;
        this.Student_ID = Student_ID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDepartment() {
        return Department;
    }

    public void setDepartment(String department) {
        Department = department;
    }

    public String getStudent_ID() {
        return Student_ID;
    }

    public void setStudent_ID(String student_ID) {
        Student_ID = student_ID;
    }
}
