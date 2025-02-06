import java.util.*;

/**
 * Practice for coding interview #1
 */

class Interval {
  int start;
  int end;
  
  public Interval(int start, int end) {
    this.start = start;
    this.end = end;
  }
}
 
 public class SolutionInterval {
   public static void main(String[] args) {
     ArrayList<Interval> intervals = new ArrayList<>();
     intervals.add(new Interval(1, 3));
     intervals.add(new Interval(5, 8));
     intervals.add(new Interval(4, 10));
     intervals.add(new Interval(20, 25));
     
     Collections.sort(intervals, (a, b) -> Integer.compare(a.start, b.end));
 
     ArrayList<Interval> results = new ArrayList<>();
     Interval current = intervals.get(0);
     results.add(current);
     for (Interval interval : intervals) {
       if (current.end >= interval.start) {
         current.end = Math.max(current.end, interval.end);
       } else {
         current = interval;
         results.add(current);
       }
     }
 
     for (Interval result : results) {
       System.out.println(result.start + " " + result.end);
     }
   }
 }
 