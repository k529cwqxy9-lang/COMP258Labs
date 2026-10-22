package comp258.programs;

import comp258.drivers.ArrayManagerDriver;
import comp258.framework.ConsoleProgram;

public class LabLauncher extends ConsoleProgram {
    @Override
    protected int getQuitOption() {
        return 5;
    }

    @Override
    public void startProgram() {
        System.out.println("COMP 258 lab launcher");
    }

    @Override
    public int showMenu() {
        System.out.println("\n========== programs ==========");
        System.out.println("1. Manage data with ArrayManager");
        System.out.println("2. Manage data with LinkedList");
        System.out.println("3. Manage data with GenericLinkedList");
        System.out.println("4. Showcase Recursive Functions");
        System.out.println("5. Exit");
        return readInt("Choose a program: ");
    }

    @Override
    public void executeAction(int choice) {
        switch (choice) {
            case 1:
                ArrayManagerDriver.run(input);
                break;
            case 2:
                new LinkedListProgram().run();
                break;
            case 3:
                new GenericListProgram().run();
                break;
            case 4:
                new RecursiveFunctionsApp().run();
                break;
            default:
                System.out.println("Please choose a number from 1 to 5.");
        }
    }

    @Override
    public void endProgram() {
        System.out.println("Lab launcher closed.");
    }
}
