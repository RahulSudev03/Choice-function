public class Student implements Comparable<Student>{

    private Gender gender;
    private Category category;
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
}
