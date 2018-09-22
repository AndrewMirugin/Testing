package labaForTesting.main;

import labaForTesting.group.Group;
import labaForTesting.student.Student;

public class Main {
    public static void main(String[] args) {
        Student stud1=new Student("Ivan1","Ivan1",new int[]{7,8,5,9,6});
        Student stud2=new Student("Ivan2","Ivan2",new int[]{9, 6, 8, 7, 4});
        Student stud3=new Student("Ivan3","Ivan3",new int[]{9, 10, 8, 7, 9});
        Group group = new Group();
        group.addStudent(stud1);
        group.addStudent(stud2);
        group.addStudent(stud3);
        System.out.println(stud1.getFam() + " " + stud1.getAver());
        System.out.println(stud2.getFam() + " " + stud2.getAver());
        System.out.println(stud3.getFam() + " " + stud3.getAver());
        System.out.println(group.getAver());
    }
}
