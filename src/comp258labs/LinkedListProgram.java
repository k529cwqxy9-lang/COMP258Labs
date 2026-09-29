/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package comp258labs;

/**
 *
 * @author CrgCA
 */
public class LinkedListProgram
        extends ConsoleProgram {

    private LinkedList list;

    public LinkedListProgram() {
        list = new LinkedList();
    }

    public static void main(String[] args) {
        LinkedListProgram program =
            new LinkedListProgram();

        program.run();
    }

    @Override
    public void startProgram() {
        System.out.println(
            "linked list program started"
        );
    }

    @Override
    public void endProgram() {
        System.out.println(
            "linked list program ended"
        );
    }

    @Override
    public int showMenu() {
        System.out.println();
        System.out.println(
            "================ menu ================"
        );
        System.out.println("1. add before");
        System.out.println("2. add after");
        System.out.println("3. print");
        System.out.println("4. get current");
        System.out.println("5. get item at");
        System.out.println("6. delete current");
        System.out.println("7. advance");
        System.out.println("8. start");
        System.out.println("9. run test");
        System.out.println("0. exit program");

        return readInt("choose an option: ");
    }

    @Override
    public void executeAction(int choice) {
        switch (choice) {
            case 1:
                addBefore();
                break;

            case 2:
                addAfter();
                break;

            case 3:
                list.print();
                break;

            case 4:
                showCurrent();
                break;

            case 5:
                showItemAt();
                break;

            case 6:
                deleteCurrent();
                break;

            case 7:
                advance();
                break;

            case 8:
                startList();
                break;

            case 9:
                runLinkedListTest();
                break;

            default:
                System.out.println(
                    "please choose a number from 0 to 9"
                );
        }
    }

    private void addBefore() {
        int item = readInt(
            "enter an item: "
        );

        list.addBefore(item);

        System.out.println(
            "item added before current"
        );
    }

    private void addAfter() {
        int item = readInt(
            "enter an item: "
        );

        list.addAfter(item);

        System.out.println(
            "item added after current"
        );
    }

    private void showCurrent() {
        Object item = list.getCurrent();

        if (item == null) {
            System.out.println(
                "there is no current item"
            );
        } else {
            System.out.println(
                "current item: " + item
            );
        }
    }

    private void showItemAt() {
        int position = readInt(
            "enter a position: "
        );

        Object item = list.getItemAt(position);

        if (item == null) {
            System.out.println(
                "invalid position"
            );
        } else {
            System.out.println(
                "item at position "
                + position
                + ": "
                + item
            );
        }
    }

    private void deleteCurrent() {
        if (list.getCurrent() == null) {
            System.out.println(
                "there is no current item"
            );
            return;
        }

        list.deleteCurrent();

        System.out.println(
            "current item deleted"
        );
    }

    private void advance() {
        boolean moved = list.advance();

        if (moved) {
            System.out.println(
                "moved to the next item"
            );

            showCurrent();
        } else {
            System.out.println(
                "cannot advance"
            );
        }
    }

    private void startList() {
        list.start();

        if (list.getCurrent() == null) {
            System.out.println(
                "the list is empty"
            );
        } else {
            System.out.println(
                "current moved to the start"
            );

            showCurrent();
        }
    }

    private void runLinkedListTest() {
        list = new LinkedList();

        list.addAfter(5);
        list.addAfter(6);
        list.addAfter(7);
        list.addAfter(8);
        list.addAfter(9);
        list.addAfter(10);
        list.addAfter(11);
        list.addAfter(12);

        list.start();

        System.out.println("test list:");
        list.print();
    }
}

