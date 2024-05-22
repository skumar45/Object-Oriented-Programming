
/*
 * This file should remain unchanged.
 */
public class Course
{
   private final String name;
   private final int numUnits;
   private boolean isCS;

   /**
    * This is a constructor. It creates a new Course object with a given number of units.
    * @param name
    * @param numUnits
    * @param isCS Is the course within the CS department, or an external course.
    */
   public Course(final String name, final int numUnits, final boolean isCS)
   {
      this.name = name;
      this.numUnits = numUnits;
      this.isCS = isCS;
   }

   public String getName()
   {
      return name;
   }

   public int getNumUnits()
   {
      return numUnits;
   }

   public boolean isCS() { return isCS; }
}
