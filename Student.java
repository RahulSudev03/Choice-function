public class Student implements Comparable<Student>{

    private Gender gender;
    private Category category;

    private Category selectionQuta;
    private int ranking;



    public Student(Gender gender, Category category, int ranking){
        this.gender = gender;
        this.category = category;
        this.ranking = ranking;
    }

    public int compareTo(Student student)
    {
        return(ranking - student.ranking);
    }

    @Override
    public String toString() {
        return "Ranking " +  this.ranking + ", Category: " + this.category;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public int getRanking() {
        return ranking;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }

    public Category getSelectionQuta() {
        return selectionQuta;
    }

    public void setSelectionQuta(Category selectionQuta) {
        this.selectionQuta = selectionQuta;
    }
}


