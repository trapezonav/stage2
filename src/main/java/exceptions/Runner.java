package exceptions;

public class Runner {
    public static void main(String[] args) {
        try {
            Student student1 = new Student("Vasya");
            student1.setMarksOnSubjects(Subject.ENGLISH, 5);
            student1.setMarksOnSubjects(Subject.MATHS, 3);
            student1.setMarksOnSubjects(Subject.ECONOMICS, 4);

            Student student2 = new Student("Inna");
            student2.setMarksOnSubjects(Subject.ENGLISH, 5);
            student2.setMarksOnSubjects(Subject.MATHS, 5);
            student2.setMarksOnSubjects(Subject.ECONOMICS, 5);

            Student student3 = new Student("Givi");
            student3.setMarksOnSubjects(Subject.ENGLISH, 2);
            student3.setMarksOnSubjects(Subject.MATHS, 2);
            student3.setMarksOnSubjects(Subject.ECONOMICS, 3);

            Student student4 = new Student("Zina");
            student4.setMarksOnSubjects(Subject.ENGLISH, 4);
            student4.setMarksOnSubjects(Subject.ECONOMICS, 1);

            Student student5 = new Student("Rick");
            student5.setMarksOnSubjects(Subject.ENGLISH, 4);
            student5.setMarksOnSubjects(Subject.ECONOMICS, 2);

            Group group1 = new Group("PO2");
            group1.addStudent(student1);
            group1.addStudent(student2);
            group1.addStudent(student3);
            group1.addStudent(student5);

            Group group2 = new Group("PO1");
            group2.addStudent(student4);

            Group group3 = new Group("PO3");

            Faculty faculty1 = new Faculty("POIT");
            faculty1.addGroup(group1);
            faculty1.addGroup(group2);

            University university = new University("BGU");
            university.addFaculty(faculty1);

            System.out.println(student1.averageMark());

            System.out.println(university.calculateAverageMarkOnSubject(Subject.MATHS));

            System.out.println(faculty1.getAverageMark("PO2", Subject.ECONOMICS));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}