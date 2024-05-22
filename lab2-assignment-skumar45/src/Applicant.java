import java.util.List;
import java.util.Objects;


public class Applicant {
    //instance variables
    private Boolean completed_degree;
    private String name;
    private List<CourseGrade> grades;

    public Applicant(String name, List<CourseGrade> grades) {
        this.name = name;
        this.grades = grades;
    }

    public Applicant(String name, List<CourseGrade> grades, Boolean completed_degree) {
        this.name = name;
        this.grades = grades;
        this.completed_degree = completed_degree;
    }

    public String getName() {
        return this.name;
    }

    public List<CourseGrade> getGrades() {
        return this.grades;
    }

    public Boolean getCompleted_degree() {
        return this.completed_degree;
    }

    public CourseGrade getGradeFor(String course) {
        for (CourseGrade grade : grades) {
            if (grade.getCourse().getName().equals(course)) {
                return grade;
            }
        }
        return null;
    }
}
