package Loops;

import java.util.Arrays;

public class TestStatistics {
    public static void main(String[] args) {
        //Score 10 test scores in an array
        int [] scores = {75,85,90,60,95,70,80,88,92,65};
        // String to store the title
        String title = "Test Statistics";
        System.out.println("===" + title + "===");
        //Display all test scores
        System.out.println("Test Scores:");
        for (int score : scores) {
            System.out.println(score + " ");
        }
        //Call the methods
        System.out.println("\nAverage: " + getAverage(scores));
        System.out.println("High score:" + getHigh(scores));
        System.out.println("Low Score:" + getLow(scores));
        System.out.println("Median:" + getMedian(scores));
    }
    //Method to calculate average
     public static double getAverage(int[] scores) {
        int sum = 0;
        for (int score : scores) {
            sum += score;
        }
        return (double) sum / scores.length;
    }
    //Method to find highest score
    public static double getHigh(int[] scores) {
        int high = scores[0];
        for (int score : scores) {
            if (score > high) {
                high = score;
            }
        }
        return high;
    }
    //Method to find the lowest score
    public static double getLow(int[] scores) {
        int low = scores[0];
        for (int score : scores) {
            if (score < low) {
                low = score;
            }
        }
        return low;
    }
    //Method to calculate median
    public static double getMedian(int[] scores) {
        //Sort the scores from lowest to highest
        int [] sorted = scores.clone();
        Arrays.sort(sorted);
        int middle = sorted.length / 2;
        return (sorted[middle-1] + sorted[middle])/2.0;
    }
}
