
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ExampleMap {

  /**
   * Return a list of "high scoring" students --- High scoring students are
   * students who have all grades strictly greater than the given threshold.
   *
   * @param scoresByApplicantName A map of applicant names to applicant CourseGrades
   * @param scoreThreshold        The score threshold
   * @return The list of high-scoring applicant names
   */
  public static List<String> highScoringStudents(Map<String, List<CourseGrade>> scoresByApplicantName, int scoreThreshold) {
    List<String> highScoringStudents = new LinkedList<>();

    for (Map.Entry<String, List<CourseGrade>> current : scoresByApplicantName.entrySet()) {
      List<CourseGrade> scores = current.getValue();
      boolean isHighScorer = true;
      for (CourseGrade grade : scores) {
        if (grade.getScore() <= scoreThreshold) {
          isHighScorer = false;
          break;
        }
      }
        if (isHighScorer) {
          highScoringStudents.add(current.getKey());
      }
    }
    return highScoringStudents;
  }
}
