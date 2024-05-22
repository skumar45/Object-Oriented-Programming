
public class ForEachLoop {
  /**
   * Accept an applicant if they have at least 3 CSC grades above 85.
   * Do not count non-CS grades in your answer (i.e. skip non-CS grades).
   * 
   * @param grades The applicant's list of CourseGrades
   * @return true if the applicant meets the requirements
   */
  public static boolean atLeastThreeCSCOver85(CourseGrade[] grades) {
    /*
     * Use a FOR-EACH loop. How would you keep count of the number of CSC scores over 85?
     */
  int highScores = 0;
  for (CourseGrade grade : grades) {
    if (grade.getCourse().isCS()  && grade.getScore()>85){
      highScores++;
    }
  }
    return highScores >= 3;
  }

}
