package comp258.framework;
import java.util.Scanner;
public abstract class ConsoleProgram {

    // share one scanner between menus
    protected static final Scanner input = new Scanner(System.in);
    protected static final int QUIT_OPTION = 0;

    public final void run() {
        startProgram();

        int choice;

        do {
            choice = showMenu();

            if (choice != getQuitOption()) {
                executeAction(choice);
            }

        } while (choice != getQuitOption());

        endProgram();
    }

    protected int getQuitOption() {
        return QUIT_OPTION;
    }

    public void startProgram() {
        System.out.println("Program starting...");
    }

    public void endProgram() {
        System.out.println("Program ended.");
    }

    protected int readInt(String prompt) {
        System.out.print(prompt);

        while (!input.hasNextInt()) {
            System.out.println("Please enter a whole number.");
            input.nextLine();
            System.out.print(prompt);
        }

        int value = input.nextInt();
        input.nextLine();

        return value;
    }

    protected abstract int showMenu();

    protected abstract void executeAction(int choice);
}