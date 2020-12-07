package exceptions;

public class Runner {
    public static void main(String[] args) {
        Student student1 = new Student("Vasia");
        student1.subjectsAndMarks.put(Subject.ENGLISH, 5);
        student1.subjectsAndMarks.put(Subject.MATHS, 3);
        student1.subjectsAndMarks.put(Subject.ECONOMICS, 4);

        Student student2 = new Student("Inna");
        student2.subjectsAndMarks.put(Subject.ENGLISH, 5);
        student2.subjectsAndMarks.put(Subject.MATHS, 5);
        student2.subjectsAndMarks.put(Subject.ECONOMICS, 5);

        Student student3 = new Student("Givi");
        student3.subjectsAndMarks.put(Subject.ENGLISH, 2);
        student3.subjectsAndMarks.put(Subject.MATHS, 2);
        student3.subjectsAndMarks.put(Subject.ECONOMICS, 3);

        Student student4 = new Student("Zina");
        student3.subjectsAndMarks.put(Subject.ENGLISH, 4);
        student3.subjectsAndMarks.put(Subject.MATHS, 1);
        student3.subjectsAndMarks.put(Subject.ECONOMICS, 1);

        Group group1 = new Group("PO2");
        group1.studentList.add(student1);
        group1.studentList.add(student2);
        group1.studentList.add(student3);

        Group group2 = new Group("PO1");
        group1.studentList.add(student4);

        Faculty faculty1 = new Faculty("POIT");
        faculty1.groupList.add(group1);
        faculty1.groupList.add(group2);

        University university = new University("BGU");
        university.facultyList.add(faculty1);



    }
}
