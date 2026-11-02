/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package comp258.programs;
import comp258.framework.ConsoleProgram;

/**
 *
 * @author CrgCA
 */
public class LabLauncher
        extends ConsoleProgram {

    private ConsoleProgram currentProgram;

    @Override
    public void startProgram() {
        System.out.println(
                "COMP 258 lab launcher"
        );
    }

    @Override
    public void endProgram() {
        System.out.println(
                "lab launcher closed"
        );
    }

    @Override
    public int showMenu() {
        System.out.println();
        System.out.println(
                "========== programs =========="
        );
        System.out.println(
                "1. random number program"
        );
        System.out.println(
                "2. linked list program"
        );
        System.out.println(
                "3. generic list program"
        );
        System.out.println(
                "0. exit launcher"
        );

        return readInt("choose a program: ");
    }

    @Override
    public void executeAction(int choice) {
        switch (choice) {
            case 1:
                currentProgram =
                        new RandomNumberProgram();
                break;

            case 2:
                currentProgram =
                        new LinkedListProgram();
                break;

            case 3:
                currentProgram =
                        new GenericListProgram();
                break;

            default:
                System.out.println(
                        "invalid program option"
                );

                return;
        }

        // Run the selected program
        currentProgram.run();
    }
}
