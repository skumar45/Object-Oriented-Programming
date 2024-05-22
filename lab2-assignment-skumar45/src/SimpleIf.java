
public class SimpleIf {

  /**
   * Takes an applicant's average score and accepts the applicant if the average
   * is higher than the given threshold.
   * 
   * @param avg The applicant's average score
   * @param threshold The threshold score
   * @return true if the applicant's average is over the threshold, and false otherwise
   */
  public static boolean analyzeApplicant(double avg, double threshold) {
      return avg > threshold;
  }

  /* I made a completed_degree boolean that determine whether the applicant has a degree or not. If an applicant has
  completed their degree, then they should be considered for employment. If they have not completed a degree, they
  should not be considered. This is a good way to determine eligibility because earning a degree teaches a person
  valuable life skills and knowledge needed for employment. */

   public static boolean analyzeApplicant2(Applicant applicant, boolean completed_degree) {
      return completed_degree;
  }

  /**
   * Takes two applicants' average scores and returns the score of the applicant
   * with the higher average.
   * 
   * @param avg1 The first applicant's average score
   * @param avg2 The second applicant's average score
   * @return the higher average score
   */
  public static double maxAverage(double avg1, double avg2) {
    if (avg1 > avg2) {
      return avg1;}
    else {
      return avg2;
    }
  }

}
