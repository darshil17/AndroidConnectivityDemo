package com.example.sr.sqlitedemo;

public class Student {
    private int id;

    public Student() {
    }

    public Student(int id, String studentName) {
        this.id = id;
        this.studentName = studentName;
    }

    private String studentName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
}