/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package comp258labs;
import java.util.Scanner;
/**
 *
 * @author CrgCA
 */
public abstract class ConsoleProgram {

    protected Scanner input = new Scanner(System.in);
    protected static final int QUIT_OPTION = 0;

    public final void run() {
        startProgram();

        int choice;

        do {
            choice = showMenu();

            if (choice != QUIT_OPTION) {
                executeAction(choice);
            }

        } while (choice != QUIT_OPTION);

        endProgram();
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