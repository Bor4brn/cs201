import java.util.Random;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

public class Main {

    public static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        try {
            File inputFile = new File("C:\\Users\\user\\IdeaProjects\\cs201\\src\\input");
            Scanner scanner = new Scanner(inputFile);
            int numRandomNumbers = Integer.parseInt(scanner.nextLine()); // Read the number from input file

            File outputFile = new File("C:\\Users\\user\\IdeaProjects\\cs201\\src\\output");
            FileWriter fileWriter = new FileWriter(outputFile);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            Random random = new Random();
            int upperbound = 100000;

            for (int i = 0; i < numRandomNumbers; i++) {
                int int_random = random.nextInt(upperbound); // Generate random number
                bufferedWriter.write(Integer.toString(int_random)); // Write the random number to output file

                if (isPrime(int_random)) {
                    bufferedWriter.write(" Prime"); // Write prime checker
                } else {
                    bufferedWriter.write(" Not Prime"); // Write prime checker
                }

                bufferedWriter.newLine(); // Move to the next line for the next number
            }

            scanner.close();
            bufferedWriter.close();
            System.out.println("Output has been written to output.txt");
        } catch (IOException e) {
            System.err.println("Error while writing to file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Invalid number format in the input file.");
        }
    }
}
