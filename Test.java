import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test {

    public static void main(String[] args){
        Student student1 = new Student(Gender.MALE,Category.OPEN,2);
        Student student2 = new Student(Gender.FEMALE,Category.OBC,1);


        Student student3 = new Student(Gender.MALE,Category.SC,3);

        Student student4 = new Student(Gender.FEMALE, Category.SC, 4);
        Student student5 = new Student(Gender.FEMALE, Category.SC, 5);
        Student student6 = new Student(Gender.FEMALE, Category.SC, 6);

        Student student7 = new Student(Gender.MALE, Category.SC, 7);
        Student student8 = new Student(Gender.MALE, Category.SC, 8);

        Student student9 = new Student(Gender.FEMALE, Category.SC, 9);
        Student student10 = new Student(Gender.FEMALE, Category.SC, 10);
        Student student11 = new Student(Gender.FEMALE, Category.SC, 11);
        Student student12 = new Student(Gender.FEMALE, Category.SC, 12);
        Student student13 = new Student(Gender.FEMALE, Category.SC, 13);
        Student student14 = new Student(Gender.FEMALE, Category.SC, 14);
        Student student15 = new Student(Gender.FEMALE, Category.SC, 15);

         List<Student> studentList = new ArrayList<>();
         studentList.add(student1);
         studentList.add(student2);
         studentList.add(student3);
         studentList.add(student4);
        studentList.add(student5);
        studentList.add(student6);
        studentList.add(student7);
        studentList.add(student8);
        studentList.add(student9);
        studentList.add(student10);
        studentList.add(student11);
        studentList.add(student12);
        studentList.add(student13);
        studentList.add(student14);
        studentList.add(student15);


         Collections.sort(studentList);
         for(int i = 0; i < studentList.size(); i++){
             System.out.println(studentList.get(i).toString());
         }

         Allocation newAllocation = new Allocation(5, 10, 5, 10, 5, 10, 5, 10, 5, 10);
         newAllocation.ChoiceFunction(Category.SC, studentList, 5, 10);

         System.out.println();
         System.out.println("Selected student list ");
        for(int i = 0; i < newAllocation.getSelectedList().size(); i++){
            System.out.println(newAllocation.getSelectedList().get(i).toString());
        }

    }
}
