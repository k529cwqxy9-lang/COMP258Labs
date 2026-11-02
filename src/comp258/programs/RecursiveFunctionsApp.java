package comp258.programs;

import comp258.collections.LinkedList;
import comp258.framework.ConsoleProgram;

public class RecursiveFunctionsApp extends ConsoleProgram {
    private final LinkedList testList = new LinkedList();

    public RecursiveFunctionsApp() {
        testList.addAfter(10);
        testList.addAfter(20);
        testList.addAfter(30);
        testList.addAfter(40);
        testList.start();
    }

    public int factorial(int n) {
        if (n < 0 || n > 12) {
            throw new IllegalArgumentException("Factorial requires 0 through 12 for an int result.");
        }
        // 0! and 1! are both 1
        if (n <= 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    public int calculatePower(int base, int exponent) {
        if (exponent < 0) {
            throw new IllegalArgumentException("Use a non-negative exponent for an int result.");
        }
        // stop when the exponent reaches zero
        if (exponent == 0) {
            return 1;
        }
        return Math.multiplyExact(base, calculatePower(base, exponent - 1));
    }

    public boolean isPalindrome(String word) {
        if (word == null) {
            throw new IllegalArgumentException("Enter a word.");
        }
        return isPalindrome(word, 0, word.length() - 1);
    }

    public boolean isPalindrome(String word, int start, int end) {
        // stop when the indices meet
        if (start >= end) {
            return true;
        }
        if (word.charAt(start) != word.charAt(end)) {
            return false;
        }
        return isPalindrome(word, start + 1, end - 1);
    }

    public int digitSum(int number) {
        // add the last digit to the remaining digits
        if (number > -10 && number < 10) {
            return Math.abs(number);
        }
        return Math.abs(number % 10) + digitSum(number / 10);
    }

    public void indentoTron(int maxNum) {
        if (maxNum < 0 || maxNum > 100) {
            throw new IllegalArgumentException("Choose a maximum from 0 through 100.");
        }
        indentoTron(1, maxNum);
    }

    public void indentoTron(int currentNum, int maxNum) {
        // stop after the last call
        if (currentNum > maxNum) {
            return;
        }
        String indent = "   ".repeat(currentNum - 1);
        System.out.println(indent + "This was written by call number " + currentNum + ".");
        indentoTron(currentNum + 1, maxNum);
        // print again as each call returns
        System.out.println(indent + "This ALSO written by call number " + currentNum + ".");
    }

    @Override
    protected int getQuitOption() {
        return 8;
    }

    @Override
    public void startProgram() {
        System.out.println("Recursive functions (test list: 10, 20, 30, 40)");
    }

    @Override
    public int showMenu() {
        System.out.println("\n1. Calculate factorial");
        System.out.println("2. Calculate powers");
        System.out.println("3. Check if a word is a palindrome");
        System.out.println("4. Print number's digit sum");
        System.out.println("5. Run Indent-o-tron");
        System.out.println("6. Print linked list with recursion");
        System.out.println("7. Print linked list backwards with recursion");
        System.out.println("8. Exit program");
        return readInt("Choose an option: ");
    }

    @Override
    public void executeAction(int choice) {
        try {
            switch (choice) {
                case 1:
                    System.out.println("Factorial: " + factorial(readInt("Enter n (0-12): ")));
                    break;
                case 2:
                    int base = readInt("Enter base: ");
                    int exponent = readInt("Enter exponent (0 or greater): ");
                    System.out.println("Power: " + calculatePower(base, exponent));
                    break;
                case 3:
                    System.out.print("Enter a word (case-sensitive): ");
                    System.out.println("Palindrome: " + isPalindrome(input.nextLine()));
                    break;
                case 4:
                    System.out.println("Digit sum: " + digitSum(readInt("Enter a whole number: ")));
                    break;
                case 5:
                    indentoTron(readInt("Enter maximum call number (0-100): "));
                    break;
                case 6:
                    testList.printRecursive();
                    break;
                case 7:
                    testList.printBackwards();
                    break;
                default:
                    System.out.println("Please choose a number from 1 to 8.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } catch (ArithmeticException e) {
            System.out.println("The result is too large for an int.");
        }
    }

    @Override
    public void endProgram() {
        System.out.println("Returning to the lab launcher.");
    }
}
