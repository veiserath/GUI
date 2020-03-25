package com.company;

public class Subject {
    String subjectName;
    Person Teacher;
    Student students[];
    private int index;

    Subject(String name)
    {
        this.subjectName = name;
        students = new Student[10];
        index = 0;
    }

    public void setTeacher(Person teacher)
    {
        this.Teacher = teacher;
    }

    @Override
    public String toString(){
        String allStudents = "";
        for (int j = 0; j< this.index ;j++){
            allStudents = students[j] + " ";
        }
        return this.subjectName + ", teacher: " + this.Teacher + ", students: " + allStudents;
    }

    void addStudent(Student student) throws TooManyStudentsException {
        if(index>9)
            throw new TooManyStudentsException();
        students[index++] = student;

    }
}
