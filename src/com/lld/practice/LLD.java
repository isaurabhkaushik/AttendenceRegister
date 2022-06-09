package com.lld.practice;

public class LLD {
    public static void main(String[] args) {
        ClassRoom classRoom = new ClassRoom();
        classRoom.id = 1;
        classRoom.classTeacherName = "Teacher: T1";
        classRoom.name = "Xth";
        classRoom.section = "A";
        classRoom.addStudent("S1");
        classRoom.addStudent("S2");
        classRoom.addStudent("S3");
        classRoom.addStudent("S4");
        classRoom.register = new AttendanceRegister(1, 1);

        final String PRESENT = "PRESENT";
        final String ABSENT = "ABSENT";

        classRoom.register.init(classRoom.students, 6);
        classRoom.register.init(classRoom.students, 7);
        classRoom.register.setAttendence("S1", 6, 1, PRESENT);
        classRoom.register.setAttendence("S2", 6, 1, PRESENT);
        classRoom.register.setAttendence("S3", 6, 1, PRESENT);
        classRoom.register.setAttendence("S4", 6, 1, PRESENT);
        classRoom.register.setAttendence("S1", 6, 2, ABSENT);
        classRoom.register.setAttendence("S1", 6, 3, ABSENT);
        classRoom.register.setAttendence("S1", 6, 4, PRESENT);

        classRoom.register.setAttendence("S1", 7, 1, PRESENT);
        classRoom.register.setAttendence("S1", 7, 2, ABSENT);
        classRoom.register.setAttendence("S1", 7, 3, ABSENT);
        classRoom.register.setAttendence("S1", 7, 4, PRESENT);

        classRoom.register.markHoliday(6, 10);
        classRoom.register.markHoliday(7, 17);

        // month wise
        //classRoom.register.getAttendence("S1", 6);

        // over all
        classRoom.register.getAttendence("S1");
    }
}
