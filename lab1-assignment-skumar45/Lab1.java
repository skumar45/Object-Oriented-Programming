public class Lab1
{
   public static void main(String[] args) {

      // initializing and declaring some variables
      int x = 5;
      String y = "hello";
      double z = 9.8;

      // printing the variables
      System.out.println("x: " + x);
      System.out.println("y: " + y);
      System.out.println("z: " + z);

      //declare and initialize an array
      int[] nums = {3, 6, -1, 2};

      // iterate through array with a for-loop
      for (int num : nums) {
         System.out.println(num);
      }

      // call a function
      int num = charCount(y, 'l');
      System.out.println("Found: " + num);

      // a counting for loop
      for (int i = 1; i < 11; i++) {
         System.out.print(i + "");
      }
      System.out.println();
   }
      public static int charCount(String s, char c) {
         int count = 0;
         for (char ch : s.toCharArray()) {
            if (ch ==c) {
               count++;
            }
         }
         return count;
   }
}
