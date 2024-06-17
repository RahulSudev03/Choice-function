public class Student implements Comparable<Student>{

    private Gender gender;
    private StudentCategory category;
    private PositionCategory selectionQuota;
    private int ranking;



    public Student(Gender gender, StudentCategory category, int ranking){
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
        return "Ranking: " +  this.ranking + ", Gender: " + this.gender + ", StudentCategory: " + this.category + ", SelectionQuota: " + this.selectionQuota;
    }

    public StudentCategory getStudentCategory() {
        return category;
    }

    public void setStudentCategory(StudentCategory category) {
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

    public PositionCategory getSelectionQuota() {
        return selectionQuota;
    }

    public void setSelectionQuota(PositionCategory selectionQuota) {
        this.selectionQuota = selectionQuota;
    }
}


