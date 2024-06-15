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

        List<Student> studentMainList = new ArrayList<>();
        studentMainList.add(student1);
        studentMainList.add(student2);
        studentMainList.add(student3);
        studentMainList.add(student4);
        studentMainList.add(student5);
        studentMainList.add(student6);
        studentMainList.add(student7);
        studentMainList.add(student8);
        studentMainList.add(student9);
        studentMainList.add(student10);
        studentMainList.add(student11);
        studentMainList.add(student12);
        studentMainList.add(student13);
        studentMainList.add(student14);
        studentMainList.add(student15);

        List<Student> secondaryStudentList = new ArrayList<>();

         Collections.sort(studentMainList);
         for(int i = 0; i < studentMainList.size(); i++){
             System.out.println(studentMainList.get(i).toString());
         }

         int open = 10;
         int SC = 10;
         int ST = 10;
         int OBC = 10;
         int EWS = 10;
         int remaining_seats_OPEN = 10;
        int remaining_seats_SC = 10;
        int remaining_seats_ST = 10;
        int remaining_seats_OBC = 10;
        int remaining_seats_EWS = 10;


        Allocation newAllocation = new Allocation(5, open, 5, SC, 5, ST, 5, OBC, 5, EWS);

        //Since OBC is a soft reserve category we need to move all its empty seats to open and run it till there are no more vacancies in OBC.
        while(remaining_seats_OBC != 0){

            //Adding all elements from main list to secondary list
             for(int i = 0; i< studentMainList.size(); i++){
                 secondaryStudentList.add(studentMainList.get(i));
             }

             // Running allocation function for each category

             remaining_seats_OPEN = newAllocation.ChoiceFunction(Category.OPEN, secondaryStudentList, 5, open);
             System.out.println("Remaining seats in open " +remaining_seats_OPEN);
             remaining_seats_SC = newAllocation.ChoiceFunction(Category.SC, secondaryStudentList, 5, SC);
             System.out.println("Remaining seats in SC " +remaining_seats_SC);
             remaining_seats_ST = newAllocation.ChoiceFunction(Category.ST, secondaryStudentList, 5, ST);
             System.out.println("Remaining seats in ST " +remaining_seats_ST);
             remaining_seats_OBC = newAllocation.ChoiceFunction(Category.OBC, secondaryStudentList, 5, OBC);
             System.out.println("Remaining seats in OBC " +remaining_seats_OBC);
             remaining_seats_EWS = newAllocation.ChoiceFunction(Category.EWS, secondaryStudentList, 5, EWS);
             System.out.println("Remaining seats in EWS " +remaining_seats_EWS);

             //Adding remaining OBC seats to open and subtracting remaining OBC seats from OBC
             open += remaining_seats_OBC;
             OBC -= remaining_seats_OBC;

             //clearing studentList for next iteration
             secondaryStudentList.clear();
        }


         System.out.println();
         System.out.println("Selected student list ");
        for(int i = 0; i < newAllocation.getSelectedList().size(); i++){
            System.out.println(newAllocation.getSelectedList().get(i).toString());
        }

    }
}
