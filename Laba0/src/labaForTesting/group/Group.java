package labaForTesting.group;

import labaForTesting.student.Student;

import java.util.ArrayList;

public class Group {

    private ArrayList<Student> group;

    public Group() {
        group = new ArrayList<>();
    }

    public void setGroup(ArrayList<Student> group) {
        this.group = group;
    }

    public ArrayList<Student> getGroup() {
        return group;
    }

    public void addStudent(Student stud){
        this.group.add(stud);
    }

    public int delStudent(int index){
        this.group.remove(index);
        return 1;
    }

    public int changeStudent(int index,Student stud){
        this.group.set(index,stud);
        return 1;
    }

    public double getAver(){
        if(group.size()==0){
            return -1;
        }
        double sum=0;
        for(Student stud : group){
            sum+=stud.getAver();
        }
        return sum/group.size();
    }
}
