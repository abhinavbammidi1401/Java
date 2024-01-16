import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Interval{
    int start, end;

    Interval(int start, int end){
        this.start = start;
        this.end = end;
    }
}

public class SynchronizedThreads{
    private static List<Interval> mergedIntervals(List<Interval> intervals){
        if(intervals == null || intervals.size() <=1){
            return intervals;
        }
        intervals.sort((a,b) -> Integer.compare(a.start, b.start));
        List<Interval> mergedIntervals = new ArrayList<>();
        Interval currentInterval = intervals.get(0);

        for (int i =1; i< intervals.size(); i++){
            Interval nextInterval = intervals.get(i);

            if(currentInterval.end >= nextInterval.start){
                currentInterval.end = Math.max(currentInterval.end, nextInterval.end);
            }
            else{
                mergedIntervals.add(currentInterval);
                currentInterval = nextInterval;
            }
        }

        mergedIntervals.add(currentInterval);
        return mergedIntervals;
    }

    public static void main(String[] args) {
        List<Interval> inputIntervals = Arrays.asList(new Interval(1,3),new Interval(2,4), new Interval(6,8), new Interval(9,10));

        //first thread for prining a message.
        Thread t1 = new Thread(() -> {
            synchronized(System.out){
                System.out.println("Welcome to Java Programming Practical Test2.");
            }
        });

        //Second thread for mergin intervals.
        Thread t2 = new Thread(() -> {
            synchronized(System.out) {
                List<Interval> mergedIntervals = mergedIntervals(inputIntervals);
                System.out.println("Input: " + inputIntervals);
                System.out.println("Output: " + mergedIntervals);
            }
        });

        //THird Thread for anagrams.
        Thread t3 = new Thread();

        //Start both threads
        t1.start();
        t2.start();
        t3.start();


        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}