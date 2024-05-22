
/*
 * This file should remain unchanged.
 */
public class CourseGrade {
  private Course course;
  private int score; 

  /**
   * This is a constructor. It creates a new CourseGrade with the specified scores.
   * @param course
   * @param score 
   */
  public CourseGrade(Course course, int score) {
    this.course = course;
    this.score = score;
  }

  public Course getCourse() {
    return this.course;
  }

  public int getScore() {
    return this.score;
  }
}
