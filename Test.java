import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String[] args){
        Student student1 = new Student(Gender.MALE,Category.OPEN,2);
        Student student2 = new Student(Gender.FEMALE,Category.OBC,1);
        Student student3 = new Student(Gender.MALE,Category.SC,3);
         List<Student> studentList = new ArrayList<>();
         studentList.add(student1);
         studentList.add(student2);
         studentList.add(student3);
    }
}
