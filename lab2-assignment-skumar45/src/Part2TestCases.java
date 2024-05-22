import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static junit.framework.TestCase.assertEquals;


public class Part2TestCases
{
    /*
     * This test is just to get you started.  Uncomment it once you have created your Applicant Object.
     * IMPORTANT: do not modify the test...make sure it still can run as-is after creating your own filter.
     */
    @Test
    public void testGetName()
    {
        // This will not compile until you implement the Applicant class
        List<CourseGrade> grades = Arrays.asList(
                new CourseGrade(new Course("Intro to CS", 4, true), 100),
                new CourseGrade(new Course("Data Structures", 4, true), 95),
                new CourseGrade(new Course("Algorithms", 4, true), 91),
                new CourseGrade(new Course("Computer Organization", 4, true), 91),
                new CourseGrade(new Course("Operating Systems", 4, true), 75),
                new CourseGrade(new Course("Non-CS", 10 * 4, false), 83)
        );
        Applicant testApplicant = new Applicant("Aakash", grades);
        assertEquals("Aakash", testApplicant.getName());
    }

    @Test
    public void testGetName2()
    {
        List<CourseGrade> grades = Arrays.asList(
                new CourseGrade(new Course("Intro to CS", 4, true), 100),
                new CourseGrade(new Course("Data Structures", 4, true), 95),
                new CourseGrade(new Course("Algorithms", 4, true), 91),
                new CourseGrade(new Course("Computer Organization", 4, true), 91),
                new CourseGrade(new Course("Operating Systems", 4, true), 75)
        );
        Applicant testApplicant = new Applicant("John", grades, true);
        assertEquals("John", testApplicant.getName());
    }
    @Test
    public void testGeGrades()
    {
        List<CourseGrade> grades = Arrays.asList(
                new CourseGrade(new Course("Intro to CS", 4, true), 100),
                new CourseGrade(new Course("Data Structures", 4, true), 95),
                new CourseGrade(new Course("Algorithms", 4, true), 91),
                new CourseGrade(new Course("Computer Organization", 4, true), 91),
                new CourseGrade(new Course("Operating Systems", 4, true), 75)
        );
        Applicant testApplicant = new Applicant("Aakash", grades, true);
        assertEquals(grades, testApplicant.getGrades());
    }


    @Test
    public void testGeGradeFor()
    {
        // This will not compile until you implement the Applicant class
        List<CourseGrade> grades = Arrays.asList(
                new CourseGrade(new Course("Intro to CS", 4, true), 100),
                new CourseGrade(new Course("Data Structures", 4, true), 95),
                new CourseGrade(new Course("Algorithms", 4, true), 91),
                new CourseGrade(new Course("Computer Organization", 4, true), 91),
                new CourseGrade(new Course("Operating Systems", 4, true), 75)
        );
        Applicant testApplicant = new Applicant("Aakash", grades, true);
        CourseGrade expectedGrade = grades.get(0);
        CourseGrade actualGrade = testApplicant.getGradeFor("Intro to CS");
        assertEquals(expectedGrade, actualGrade);
    }

}