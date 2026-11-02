/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package comp258.programs;
import comp258.framework.ConsoleProgram;
import java.util.Random;
/**
 *
 * @author CrgCA
 */
public class RandomNumberProgram extends ConsoleProgram {

    private static final int ARRAY_SIZE = 20;
    private static final int MIN_RANDOM_VALUE = 1;
    private static final int MAX_RANDOM_VALUE = 10;

    private int[] numbers;

    @Override
    public void startProgram() {
        System.out.println("================================");
        System.out.println("       Random Number Program");
        System.out.println("================================");

        numbers = new int[ARRAY_SIZE];
        fillArray();
    }

    private void fillArray() {
        Random random = new Random();

        for (int index = 0; index < numbers.length; index++) {
            numbers[index] =
                    random.nextInt(
                            MAX_RANDOM_VALUE - MIN_RANDOM_VALUE + 1
                    ) + MIN_RANDOM_VALUE;
        }
    }

    @Override
    protected int showMenu() {
        System.out.println();
        System.out.println("1. Print Numbers");
        System.out.println("2. Search");
        System.out.println("3. Find and Replace");
        System.out.println(QUIT_OPTION + ". Quit");

        return readInt("Enter your choice: ");
    }

    @Override
    protected void executeAction(int choice) {
        switch (choice) {
            case 1:
                printNumbers();
                break;

            case 2:
                searchForNumber();
                break;

            case 3:
                findAndReplace();
                break;

            default:
                System.out.println(
                        "Invalid option. Please choose 0, 1, 2, or 3."
                );
        }
    }

    private void printNumbers() {
        System.out.println();
        System.out.println("Numbers in the array:");

        for (int index = 0; index < numbers.length; index++) {
            int displayPosition = index + 1;

            System.out.println(
                    "Position " + displayPosition + ": " + numbers[index]
            );
        }
    }

    private int findFirstIndex(int target) {
        for (int index = 0; index < numbers.length; index++) {
            if (numbers[index] == target) {
                return index;
            }
        }

        return -1;
    }

    private void searchForNumber() {
        int target = readInt("Enter a number to search for: ");
        int index = findFirstIndex(target);

        if (index == -1) {
            System.out.println(target + " was not found.");
        } else {
            int displayPosition = index + 1;

            System.out.println(
                    target + " was first found at position "
                    + displayPosition + "."
            );
        }
    }

    private void findAndReplace() {
        int valueToFind = readInt("Enter the value to find: ");
        int replacementValue =
                readInt("Enter the replacement value: ");

        int index = findFirstIndex(valueToFind);

        if (index == -1) {
            System.out.println(valueToFind + " was not found.");
        } else {
            numbers[index] = replacementValue;

            int displayPosition = index + 1;

            System.out.println(
                    "Replaced the first occurrence of "
                    + valueToFind
                    + " with "
                    + replacementValue
                    + " at position "
                    + displayPosition
                    + "."
            );
        }
    }

    @Override
    public void endProgram() {
        System.out.println();
        System.out.println("Random Number Program ended.");
    }

    public static void main(String[] args) {
        RandomNumberProgram program = new RandomNumberProgram();
        program.run();
    }
}