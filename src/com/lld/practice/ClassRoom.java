package com.lld.practice;

import java.util.ArrayList;
import java.util.List;

public class ClassRoom {
    int id;
    String name;
    String section;
    List<String> students = new ArrayList<>();
    String classTeacherName;
    AttendanceRegister register;

    void addStudent(String s) {
        students.add(s);
    }

    void removeStudent(String s) {
        for (String st : students) {
            if (st.equals(s)) {
                students.remove(st);
                return;
            }
        }
    }
}
