/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package comp258labs;
import java.util.InputMismatchException;
import java.util.Scanner;
/**
 *
 * @author CrgCA
 */
public class ArrayManagerDriver {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int[] startingValues = {
            12, 7, 25, 4, 18, 9, 14, 21, 30
        };

        ArrayManager manager =
            new ArrayManager(startingValues);

        boolean running = true;

        while (running) {
            showMenu();

            int choice = readInt(
                input,
                "choose an option: "
            );

            try {
                switch (choice) {
                    case 1:
                        System.out.println(
                            "number of items: "
                            + manager.size()
                        );
                        break;

                    case 2:
                        manager.print();
                        break;

                    case 3:
                        int value = readInt(
                            input,
                            "enter an item: "
                        );

                        manager.add(value);

                        System.out.println("item added");
                        manager.print();
                        break;

                    case 4:
                        value = readInt(
                            input,
                            "enter an item: "
                        );

                        int addPosition = readInt(
                            input,
                            "enter a position: "
                        );

                        manager.addAt(
                            value,
                            addPosition
                        );

                        System.out.println(
                            "item added at position "
                            + addPosition
                        );

                        manager.print();
                        break;

                    case 5:
                        int removePosition = readInt(
                            input,
                            "enter a position: "
                        );

                        manager.remove(removePosition);

                        System.out.println("item removed");
                        manager.print();
                        break;

                    case 6:
                        running = false;
                        System.out.println(
                            "program ended"
                        );
                        break;

                    default:
                        System.out.println(
                            "please choose a number from 1 to 6"
                        );
                }
            } catch (
                NoItemsException
                | OutOfBoundsException e
            ) {
                System.out.println(
                    "error: " + e.getMessage()
                );
            }

            System.out.println();
        }

        input.close();
    }

    private static void showMenu() {
        System.out.println(
            "1. display number of items"
        );

        System.out.println(
            "2. display all items"
        );

        System.out.println(
            "3. add an item"
        );

        System.out.println(
            "4. add an item at a position"
        );

        System.out.println(
            "5. remove an item"
        );

        System.out.println(
            "6. exit"
        );
    }

    private static int readInt(
            Scanner input,
            String message) {

        while (true) {
            System.out.print(message);

            try {
                return input.nextInt();
            } catch (InputMismatchException e) {
                System.out.println(
                    "please enter a whole number"
                );

                input.nextLine();
            }
        }
    }
}
