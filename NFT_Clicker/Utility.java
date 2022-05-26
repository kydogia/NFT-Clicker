/**
 * Utility methods to make things easier.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Utility
{
    public static double round(long num)
    {
      return Math.floor(num * 10 + 0.01) / 10;
    }

  public static double round(double num)
    {
      return Math.floor(num * 10 + 0.01) / 10;
    }
}