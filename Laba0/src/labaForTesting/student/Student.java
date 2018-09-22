package labaForTesting.student;

import java.util.ArrayList;

public class Student {
    public Student(String fam, String name, int[] marks) {
        this.fam = fam;
        this.name = name;
        addMark(marks);
    }

    public Student() {
        this.fam="";
        this.name="";
        this.marks=new ArrayList<>();
    }

    private String fam;
    private String name;
    private ArrayList<Integer> marks;

    public String getFam() {
        return fam;
    }

    public void setFam(String fam) {
        this.fam = fam;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Integer> getMarks() {
        return marks;
    }

    public void addMark(int []marks){
        ArrayList<Integer> newMarks = new ArrayList<>();
        for (int mark : marks) {
            newMarks.add(mark);
        }
        this.marks = newMarks;

    }

    public void deleteMark(int index){
        if(index<this.marks.size()){
            this.marks.remove(index);
        }
    }

    public void addMarks(int index,int value){
        if(index<this.marks.size()){
            this.marks.add(index,value);
        }
    }

    public void changeMark(int index,int value){
        if(index<this.marks.size()){
            this.marks.set(index,value);
        }
    }

    public double getAver(){
        if(this.marks.size()==0){
            return -1;
        }
        else{
            double sum=0;
            for(int i=0;i<this.marks.size();i++){
                sum+=getMarks().get(i);
            }
            return sum/this.marks.size();
        }
    }
}
