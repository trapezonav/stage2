package exceptions;

public class Runner {
    public static void main(String[] args) {
        Student student1 = new Student("Vasia");
        student1.getSubjectsAndMarks().put(Subject.ENGLISH, 5);
        student1.getSubjectsAndMarks().put(Subject.MATHS, 3);
        student1.getSubjectsAndMarks().put(Subject.ECONOMICS, 4);

        Student student2 = new Student("Inna");
        student2.getSubjectsAndMarks().put(Subject.ENGLISH, 5);
        student2.getSubjectsAndMarks().put(Subject.MATHS, 5);
        student2.getSubjectsAndMarks().put(Subject.ECONOMICS, 5);

        Student student3 = new Student("Givi");
        student3.getSubjectsAndMarks().put(Subject.ENGLISH, 2);
        student3.getSubjectsAndMarks().put(Subject.MATHS, 2);
        student3.getSubjectsAndMarks().put(Subject.ECONOMICS, 3);

        Student student4 = new Student("Zina");
        student4.getSubjectsAndMarks().put(Subject.ENGLISH, 4);
        student4.getSubjectsAndMarks().put(Subject.ECONOMICS, 1);

        Student student5 = new Student("Rick");
        student5.getSubjectsAndMarks().put(Subject.ENGLISH, 4);
        student5.getSubjectsAndMarks().put(Subject.ECONOMICS, 2);

        Group group1 = new Group("PO2");
        group1.studentList.add(student1);
        group1.studentList.add(student2);
        group1.studentList.add(student3);
        group1.studentList.add(student5);

        Group group2 = new Group("PO1");
        group2.studentList.add(student4);

        Faculty faculty1 = new Faculty("POIT");
        faculty1.getGroupList().add(group1);
        faculty1.getGroupList().add(group2);

        University university = new University("BGU");
        university.getFacultyList().add(faculty1);

        System.out.println(student1.averageMark());
        System.out.println(university.CalculateAverageMarkOnSubject(Subject.MATHS));
    }
}