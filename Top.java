import java.util.Scanner;

public class Top {

    // Static variable to store the input array
    private static int[] numbers;

    // Static method to identify and prioritize top K numbers with maximum occurrences
    public static void findTopKFrequentNumbers(int K) {
        // Validate input
        if (numbers == null || numbers.length == 0 || K <= 0 || K > numbers.length) {
            System.out.println("Invalid input");
            return;
        }

        // Sort the array to simplify frequency analysis
        sortArray();

        int n = numbers.length;

        int uniqueCount = 0;

        // Count unique values
        for (int i = 0; i < n; i++) {
            if (i == 0 || numbers[i] != numbers[i - 1]) {
                uniqueCount++;
            }
        }

        // Create arrays to store unique values and their frequencies
        int[] values = new int[uniqueCount];
        int[] frequencies = new int[uniqueCount];

        uniqueCount = 0;
        frequencies[uniqueCount] = 1;

        // Calculate frequencies and unique values
        for (int i = 1; i < n; i++) {
            if (numbers[i] == numbers[i - 1]) {
                frequencies[uniqueCount]++;
            } else {
                uniqueCount++;
                values[uniqueCount] = numbers[i];
                frequencies[uniqueCount] = 1;
            }
        }

        // Sort the arrays based on frequencies and values
        sortArraysByFrequencyAndValue(values, frequencies, uniqueCount + 1);

        // Print the top K numbers with maximum occurrences
        System.out.print("Output: ");
        for (int i = 0; i < Math.min(K, uniqueCount + 1); i++) {
            System.out.print(values[i] + " ");
        }
        System.out.println();
    }

    // Helper method to sort the array in ascending order
    private static void sortArray() {
        int n = numbers.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (numbers[j] > numbers[j + 1]) {
                    // swap temp and numbers[i]
                    int temp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = temp;
                }
            }
        }
    }

    // Helper method to sort arrays by frequency and value
    private static void sortArraysByFrequencyAndValue(int[] values, int[] frequencies, int size) {
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                if (frequencies[j] < frequencies[j + 1] || (frequencies[j] == frequencies[j + 1] && values[j] < values[j + 1])) {
                    // swap frequencies
                    int tempFreq = frequencies[j];
                    frequencies[j] = frequencies[j + 1];
                    frequencies[j + 1] = tempFreq;

                    // swap values
                    int tempVal = values[j];
                    values[j] = values[j + 1];
                    values[j + 1] = tempVal;
                }
            }
        }
    }

    // Helper method to check if a string contains letters or special characters
    private static boolean containsInvalidCharacters(String input) {
        return !input.matches("[0-9]+");
    }

    public static void main(String[] args) {
        // Take input from the user
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the size of the array: ");
        String sizeInput = scanner.next();

        // Validate array size
        if (containsInvalidCharacters(sizeInput)) {
            System.out.println("Invalid input. Letters or special characters are not allowed for array size.");
            return;
        }

        int size = Integer.parseInt(sizeInput);

        if (size <= 0) {
            System.out.println("Invalid array size");
            return;
        }

        numbers = new int[size];
        System.out.println("Enter the elements of the array:");

        for (int i = 0; i < size; i++) {
            String elementInput = scanner.next();

            // Validate array element
            if (containsInvalidCharacters(elementInput)) {
                System.out.println("Invalid input. Letters or special characters are not allowed for array elements.");
                return;
            }

            numbers[i] = Integer.parseInt(elementInput);
        }

        System.out.print("Enter the value of K: ");
        String KInput = scanner.next();

        // Validate K value
        if (containsInvalidCharacters(KInput)) {
            System.out.println("Invalid input. Letters or special characters are not allowed for K value.");
            return;
        }

        int K = Integer.parseInt(KInput);

        // Call the method to find and print the top K frequent numbers
        findTopKFrequentNumbers(K);
    }
}