import org.junit.Test;

import java.util.*;

import static junit.framework.TestCase.*;
import static org.junit.Assert.assertArrayEquals;


public class Part1TestCases
{
   private final static double DELTA = 0.0001;

   ////////////////////////////////////////////////////////////
   //                      SimpleIf Tests                    //
   ////////////////////////////////////////////////////////////

   @Test
   public void testAnalyzeApplicant()
   {
      assertTrue(SimpleIf.analyzeApplicant(89, 85));
   }

   @Test
   public void testAnalyzeApplicant2()
   {
      assertFalse(SimpleIf.analyzeApplicant(15, 90));
   }

   @Test
   public void testAnalyzeApplicant3()
   {
      assertTrue(SimpleIf.analyzeApplicant(75, 70));
   }

   @Test
   public void testMaxAverage() {
      assertEquals(SimpleIf.maxAverage(89.5, 91.2), 91.2, DELTA);
   }

   @Test
   public void testMaxAverage2() {
      assertEquals(SimpleIf.maxAverage(60, 89), 89, DELTA);
   }

   @Test
   public void testMaxAverage3() {
      assertEquals(SimpleIf.maxAverage(93, 45), 93, DELTA); }

   ////////////////////////////////////////////////////////////
   //                    SimpleLoop Tests                    //
   ////////////////////////////////////////////////////////////

   @Test
   public void testSimpleLoop1()
   {
      assertEquals(7, SimpleLoop.sum(3, 4));
   }

   @Test
   public void testSimpleLoop2()
   {
      assertEquals(7, SimpleLoop.sum(-2, 4));
   }

   @Test
   public void testSimpleLoop3()
   {assertEquals(14, SimpleLoop.sum(2, 5));}

   ////////////////////////////////////////////////////////////
   //                    SimpleArray Tests                   //
   ////////////////////////////////////////////////////////////

   @Test
   public void testSimpleArray1()
   {
      /* What is that parameter?  They are newly allocated arrays
         with initial values. */
      assertArrayEquals(
         new boolean[] {false, false, true, true, false, false},
         SimpleArray.applicantAcceptable(new int[] {80, 85, 89, 92, 76, 81}, 85)
      );
   }

   @Test
   public void testSimpleArray2()
   {
      assertArrayEquals(
         new boolean[] {false, false},
         SimpleArray.applicantAcceptable(new int[] {80, 83}, 92));
   }

   @Test
   public void testSimpleArray3()
   {
      assertArrayEquals(
         new boolean[] {false, false, true, false},
         SimpleArray.applicantAcceptable(new int[] {80, 83, 93, 76}, 87));
   }

   ////////////////////////////////////////////////////////////
   //                    SimpleList Tests                    //
   ////////////////////////////////////////////////////////////

   @Test
   public void testSimpleList1()
   {
      List<Integer> input =
         new LinkedList<>(Arrays.asList(80, 85, 89, 92, 76, 81));
      List<Boolean> expected =
         new ArrayList<>(Arrays.asList(false, false, true, true, false, false));

      assertEquals(expected, SimpleList.applicantAcceptable(input, 85));
   }

   @Test
   public void testSimpleList2()
   {
      List<Integer> input =
              new LinkedList<>(Arrays.asList(95, 65, 82, 74, 76, 45));
      List<Boolean> expected =
              new ArrayList<>(Arrays.asList(true, false, true, false, true, false));

      assertEquals(expected, SimpleList.applicantAcceptable(input, 75));
   }

   ////////////////////////////////////////////////////////////
   //                    ForEachLoop Tests                    //
   ////////////////////////////////////////////////////////////
   @Test
   public void testAtLeastThreeCSNotOver85()
   {
      CourseGrade[] gradesOnlyTwoOver = {
              new CourseGrade(new Course("CSC 101", 4, true),86),
              new CourseGrade(new Course("MATH 248", 4, false), 87),
              new CourseGrade(new Course("CSC 202", 4, true),90),
              new CourseGrade(new Course("CSC 203", 4, true),80)
      };
      assertFalse(ForEachLoop.atLeastThreeCSCOver85(gradesOnlyTwoOver));

      CourseGrade[] gradesOnThreshold = {
              new CourseGrade(new Course("CSC 101", 4, true),85),
              new CourseGrade(new Course("CSC 202", 4, true),90),
              new CourseGrade(new Course("CSC 225", 4, true), 87)
      };
      assertFalse(ForEachLoop.atLeastThreeCSCOver85(gradesOnThreshold));
   }

   @Test
   public void testAtLeastThreeCSOver85()
   {
      CourseGrade[] allOver = {
              new CourseGrade(new Course("CSC 101", 4, true), 86),
              new CourseGrade(new Course("MATH 248", 4, false),87),
              new CourseGrade(new Course("CSC 202", 4, true),90),
              new CourseGrade(new Course("CSC 203", 4, true),90),
      };
      assertTrue(ForEachLoop.atLeastThreeCSCOver85(allOver));
   }

   @Test
   public void testAtLeastThreeCSNotOver85_2()
   {
      CourseGrade[] allOver = {
              new CourseGrade(new Course("CSC 101", 4, true), 76),
              new CourseGrade(new Course("GRC 248", 4, false),87),
              new CourseGrade(new Course("CSC 202", 4, true),73),
              new CourseGrade(new Course("CSC 484", 4, true),86),
      };
      assertFalse(ForEachLoop.atLeastThreeCSCOver85(allOver));
   }

   ////////////////////////////////////////////////////////////
   //                    ExampleMap Tests                    //
   ////////////////////////////////////////////////////////////

   @Test
   public void testExampleMap1()
   {
      Map<String, List<CourseGrade>> courseListsByStudent = new HashMap<>();
      courseListsByStudent.put("Julie",
         Arrays.asList(
            new CourseGrade(new Course("CSC 123", 4, true), 89),
            new CourseGrade(new Course("CSC 101", 4, true), 90),
            new CourseGrade(new Course("CSC 202", 4, true), 99),
            new CourseGrade(new Course("CSC 203", 4, true), 100),
            new CourseGrade(new Course("CSC 225", 4, true), 89)));
      courseListsByStudent.put("Paul",
         Arrays.asList(
            new CourseGrade(new Course("CSC 101", 4, true), 86),
            new CourseGrade(new Course("CSC 202", 4, true),80),
            new CourseGrade(new Course("CSC 203", 4, true),76),
            new CourseGrade(new Course("CSC 225", 4, true),80)));
      courseListsByStudent.put("Zoe",
         Arrays.asList(
            new CourseGrade(new Course("CSC 123",4, true), 99),
            new CourseGrade(new Course("CSC 203", 4, true),91),
            new CourseGrade(new Course("CSC 471", 4, true), 86),
            new CourseGrade(new Course("CSC 473", 4, true),90),
            new CourseGrade(new Course("CSC 476", 4, true), 99),
            new CourseGrade(new Course("CSC 572", 4, true), 100)));

      List<String> expected = Arrays.asList("Julie", "Zoe");

      /*
       * Why compare HashSets here?  Just so that the order of the
       * elements in the list is not important for this test.
       */
      assertEquals(new HashSet<>(expected),
         new HashSet<>(ExampleMap.highScoringStudents(
            courseListsByStudent, 85)));
   }

   @Test
   public void testExampleMap2() {
         Map<String, List<CourseGrade>> courseListsByStudent = new HashMap<>();
         courseListsByStudent.put("Austin",
                 Arrays.asList(
                         new CourseGrade(new Course("CSC 101", 4, true), 87),
                         new CourseGrade(new Course("CSC 202", 4, true), 95),
                         new CourseGrade(new Course("CSC 234", 4, true), 86),
                         new CourseGrade(new Course("CSC 225", 4, true), 89)));
         courseListsByStudent.put("Mark",
                 Arrays.asList(
                         new CourseGrade(new Course("CSC 101", 4, true), 90),
                         new CourseGrade(new Course("CSC 202", 4, true),89),
                         new CourseGrade(new Course("CSC 203", 4, true),83),
                         new CourseGrade(new Course("CSC 365", 4, true),98)));
         courseListsByStudent.put("Sofia",
                 Arrays.asList(
                         new CourseGrade(new Course("CSC 101",4, true), 94),
                         new CourseGrade(new Course("CSC 201", 4, true),88),
                         new CourseGrade(new Course("CSC 471", 4, true), 89)));

         List<String> expected = Arrays.asList("Austin", "Sofia");

         assertEquals(new HashSet<>(expected),
                 new HashSet<>(ExampleMap.highScoringStudents(
                         courseListsByStudent, 85)));
      }


}
