import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Allocation {
    
//sort students based on ranking
//set the number of seats for each reservatoin categories
//have one function that updates the reservation seats - call this function for each category

/**
 * function(Category, Women seats, total seats, Remaining students) -  output List of Students allocated in the category
 * - we allocate seats for women
 * if there are more women than allocated women seats --> women seats = top ranked women in that category 
 *                                                    --> total seats - women seats = top ranked students(everyone) in that category
 * else if there are less women than allocated women seats --> fill women seats = top ranked women in that category
 *                                                         --> total seats - filled women seats = top ranked students in that category
 * 
 */
private int Openwomen;
private int Open;
private int SCwomen;
private int SC;
private int STwomen;
private int ST;
private int OBCwomen;
private int OBC;

private int EWSwomen;
private int EWS;

private List<Student> selectedList = new ArrayList<>();



    public Allocation(int Openwomen, int Open, int SCwomen, int SC, int STwomen, int ST, int OBCwomen, int OBC, int EWSwomen, int EWS){
        this.Openwomen = Openwomen;
        this.Open = Open;
        this.SCwomen = SCwomen;
        this.SC = SC;
        this.STwomen = STwomen;
        this.ST = ST;
        this.OBCwomen = OBCwomen;
        this.OBC = OBC;
        this. EWSwomen = EWSwomen;
        this.EWS = EWS;

    }

    public void ChoiceFunction(Category category, List<Student> studentList,int categoryWomenSeats,int categorySeats){
        List<Student> femaleList = new ArrayList<>();
        List<Student> restList = new ArrayList<>();
        for(int i = 0; i < studentList.size(); i++){
            if (category != Category.OPEN){
                if(studentList.get(i).getCategory() == category){
                    if(studentList.get(i).getGender() == Gender.FEMALE) {
                        femaleList.add(studentList.get(i));
                    }
                    else{
                        restList.add(studentList.get(i));
                    }
                }
            }
            else{
                if(studentList.get(i).getGender() == Gender.FEMALE) {
                    femaleList.add(studentList.get(i));
                }
                else{
                    restList.add(studentList.get(i));
                }
            }
        }
        Collections.sort(femaleList);
        Collections.sort(restList);

        System.out.println();
        System.out.println("Female list in " + category);
        for(int i = 0; i < femaleList.size(); i++){
            System.out.println(femaleList.get(i).toString());
        }

        System.out.println();
        System.out.println("Rest list in " + category);
        for(int i = 0; i < restList.size(); i++){
            System.out.println(restList.get(i).toString());
        }

        if(femaleList.size()<= categoryWomenSeats){
            for(int i = femaleList.size()-1; i>=0 ; i--){
                selectedList.add(femaleList.get(i));
                femaleList.get(i).setSelectionQuta(category);
                studentList.remove(femaleList.get(i));
                femaleList.remove(i);
                categoryWomenSeats--;
            }
            //add more seats to the category
            categorySeats += categoryWomenSeats;

            Collections.sort(selectedList);
        }
        else{
            for(int i = categoryWomenSeats-1; i>=0 ; i--){
                selectedList.add(femaleList.get(i));
                femaleList.get(i).setSelectionQuta(category);
                studentList.remove(femaleList.get(i));
                System.out.println("Female seats being added"+ femaleList.get(i));
                femaleList.remove(i);

            }
            categorySeats -= categoryWomenSeats;

            System.out.println("Female list size after allocation of women seats "+femaleList.size());

            //add the rest women to the restList
            restList.addAll(femaleList);
            Collections.sort(restList);
            Collections.sort(selectedList);
        }

        System.out.println();
        System.out.println("Female list after allocation in " + category);
        for(int i = 0; i < selectedList.size(); i++){
            System.out.println(selectedList.get(i).toString());
        }

        if (restList.size()<= categorySeats){
            for(int i = 0; i < restList.size(); i++){
                selectedList.add(restList.get(i));
                studentList.remove(restList.get(i));
                restList.get(i).setSelectionQuta(category);
            }
        }else {
            for(int i = 0; i < categorySeats; i++){
                selectedList.add(restList.get(i));
                studentList.remove(restList.get(i));
                restList.get(i).setSelectionQuta(category);
            }
        }

        Collections.sort(selectedList);
        System.out.println();
        System.out.println("Rest list after allocation in " + category);
        for(int i = 0; i < selectedList.size(); i++){
            System.out.println(selectedList.get(i).toString());
        }

    }

    public List<Student> getSelectedList() {
        return selectedList;
    }

    public void setSelectedList(List<Student> selectedList) {
        this.selectedList = selectedList;
    }
}
