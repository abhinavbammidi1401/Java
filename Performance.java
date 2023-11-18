import java.util.Scanner;

public class Performance {
    private int[] marks;

    // Constructor
    public Performance() {
        marks = new int[10];
    }

    // Method to read marks into the array
    public void readMarks() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the marks of 60 students:");
        for (int i = 0; i < 10; i++) {
            System.out.print("Student " + (i + 1) + ": ");
            marks[i] = scanner.nextInt();

            // Validate marks are within the given range
            if (marks[i] < 0 || marks[i] > 100) {
                System.out.println("Invalid mark. Marks should be between 0 and 100. Please enter again.");
                i--; // Decrement i to re-enter the current student's mark
            }
        }
    }

    // Method to return the highest mark scored in the class
    public int highestmark() {
        int max = marks[0];
        for (int i = 1; i < marks.length; i++) {
            if (marks[i] > max) {
                max = marks[i];
            }
        }
        return max;
    }

    // Method to return the least mark scored in the class
    public int leastmark() {
        int min = marks[0];
        for (int i = 1; i < marks.length; i++) {
            if (marks[i] < min) {
                min = marks[i];
            }
        }
        return min;
    }

    // Method to return the mode
    public int getMode() {
        int mode = marks[0];
        int maxFrequency = 1;

        for (int i = 0; i < marks.length; i++) {
            int currentMark = marks[i];
            int currentFrequency = 1;

            for (int j = i + 1; j < marks.length; j++) {
                if (marks[j] == currentMark) {
                    currentFrequency++;
                }
            }

            if (currentFrequency > maxFrequency || (currentFrequency == maxFrequency && currentMark > mode)) {
                mode = currentMark;
                maxFrequency = currentFrequency;
            }
        }

        return mode;
    }

    // Method to return the frequency at mode
    public int getFreqAtMode() {
        int mode = getMode();
        int frequency = 0;

        for (int i = 0; i < marks.length; i++) {
            if (marks[i] == mode) {
                frequency++;
            }
        }

        return frequency;
    }

    // Method to display the result
    public void display() {
        System.out.println("Highest Mark: " + highestmark());
        System.out.println("Least Mark: " + leastmark());
        System.out.println("Mode: " + getMode());
        System.out.println("Frequency at Mode: " + getFreqAtMode());
    }

    public static void main(String[] args) {
        Performance performance = new Performance();
        performance.readMarks();
        performance.display();
    }
}
