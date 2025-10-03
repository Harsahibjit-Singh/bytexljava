import java.util.ArrayList;
import java.util.List;

public class PartA {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Please provide integer inputs as command-line arguments.");
            return;
        }

        List<Integer> numbers = new ArrayList<>();
        for (String arg : args) {
            try {
                int number = Integer.parseInt(arg);
                numbers.add(number); // Autoboxing: int is converted to Integer
            } catch (NumberFormatException e) {
                System.out.println("Skipping invalid input: " + arg);
            }
        }

        int totalSum = 0;
        for (Integer number : numbers) {
            totalSum += number; // Unboxing: Integer is converted to int
        }

        System.out.println("The list of numbers is: " + numbers);
        System.out.println("The calculated sum is: " + totalSum);
    }
}