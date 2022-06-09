package com.lld.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AttendanceRegister {
    int id;
    int classRoomId;
    private final String HOLIDAY = "HOLIDAY";
    private final String NA = "NOT_APPLICABLE";

    private final String EMPTY = "EMPTY";
    Map<String, Map<Integer, List<String>>> pages;

    AttendanceRegister(int id, int classRoomId) {
        this.id = id;
        this.classRoomId = classRoomId;
        this.pages = new HashMap<>();
    }

    public void init(List<String> students, Integer month) {
        for (String s : students) {

            // if student not present
            if (!this.pages.containsKey(s)) this.pages.put(s, new HashMap<>());

            // if month is not present
            if (!this.pages.get(s).containsKey(month)) {
                this.pages.get(s).put(month, new ArrayList<>());
                List<String> days = this.pages.get(s).get(month);
                for (int i = 1; i <= 31; i++) days.add(EMPTY);
            }
        }
    }


    public void markHoliday(int month, int day) {
        for (String student : this.pages.keySet()) {
            Map<Integer, List<String>> studentAttendence = this.pages.get(student);
            for(int i = 0; i < studentAttendence.get(month).size(); i++)
                if (i == day-1)
                    this.pages.get(student).get(month).set(i, HOLIDAY);
        }
    }

    public void setAttendence(String student, Integer month, int day, String value) {
        List<String> pages = this.pages.get(student).get(month);
        pages.set(day-1, value);
    }

    // 1 day
    public void getAttendence(String student, Integer month, int day){
        System.out.println("Attendence: for day: "+ day + " : " + this.pages.get(student).get(month).get(day-1));
    }

    // 1 month
    public void getAttendence(String student, Integer month){
        System.out.println("Attendence: " + student + " for month: " + month);
        int d = 1;
        for (String s :  this.pages.get(student).get(month)) getAttendence(student, month, d++);
    }

    // 1 year
    public void getAttendence(String student){
       for (Integer month: this.pages.get(student).keySet()) getAttendence(student, month);
    }

    public void addStudent(String student, Integer month, int day) {
        this.pages.put(student, new HashMap<>());
        this.pages.get(student).put(month, new ArrayList<>());
        List<String> page = this.pages.get(student).get(month);

        for (int i = 1; i < day; i++) {
            page.add(NA);
        }
    }

    public void removeStudent(String student, Integer month) {
        Map<Integer, List<String>> pages = this.pages.get(student);

        for (Integer mon: pages.keySet()) {
            if (mon >= month) {
                pages.remove(mon);
            }
        }
    }

}
