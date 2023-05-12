package com.rdxy.entity;

public class StudentU {
    private Student student;

    private String path;
    private String fileName;


    public StudentU() {
    }

    public StudentU(Student student, String path, String fileName) {
        this.student = student;
        this.path = path;
        this.fileName = fileName;
    }

    /**
     * 获取
     * @return student
     */
    public Student getStudent() {
        return student;
    }

    /**
     * 设置
     * @param student
     */
    public void setStudent(Student student) {
        this.student = student;
    }

    /**
     * 获取
     * @return path
     */
    public String getPath() {
        return path;
    }

    /**
     * 设置
     * @param path
     */
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * 获取
     * @return fileName
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * 设置
     * @param fileName
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String toString() {
        return "StudentU{student = " + student + ", path = " + path + ", fileName = " + fileName + "}";
    }
}
