/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package comp258.programs;
import comp258.collections.GenericList;
import comp258.framework.ConsoleProgram;

/**
 *
 * @author CrgCA
 */
public class GenericListProgram
        extends ConsoleProgram {

    private GenericList<Widget> widgetList;

    public GenericListProgram() {
        widgetList = new GenericList<>();
    }

    @Override
    public void startProgram() {
        System.out.println(
                "generic list program started"
        );
    }

    @Override
    public void endProgram() {
        System.out.println(
                "generic list program ended"
        );
    }

    @Override
    public int showMenu() {
        System.out.println();
        System.out.println(
                "========== menu =========="
        );
        System.out.println("1. test empty list");
        System.out.println("2. test integer list");
        System.out.println("3. test string list");
        System.out.println("4. create widget list");
        System.out.println("5. print widget list");
        System.out.println("6. get maximum widget");
        System.out.println("7. get current widget");
        System.out.println("8. advance");
        System.out.println("9. delete current");
        System.out.println("0. exit program");

        return readInt("choose an option: ");
    }

    @Override
    public void executeAction(int choice) {
        switch (choice) {
            case 1:
                testEmptyList();
                break;

            case 2:
                testIntegerList();
                break;

            case 3:
                testStringList();
                break;

            case 4:
                createWidgetList();
                break;

            case 5:
                widgetList.print();
                break;

            case 6:
                showMaximumWidget();
                break;

            case 7:
                showCurrentWidget();
                break;

            case 8:
                advanceWidgetList();
                break;

            case 9:
                deleteCurrentWidget();
                break;

            default:
                System.out.println(
                        "invalid menu option"
                );
        }
    }

    private void testEmptyList() {
        GenericList<Integer> list =
                new GenericList<>();

        System.out.println("empty list test:");

        list.print();

        System.out.println(
                "maximum: " + list.getMaximum()
        );

        System.out.println(
                "current: " + list.getCurrent()
        );

        System.out.println(
                "advanced: " + list.advance()
        );

        list.deleteCurrent();

        System.out.println(
                "delete completed"
        );
    }

    private void testIntegerList() {
        GenericList<Integer> list =
                new GenericList<>();

        list.addAfter(12);
        list.addAfter(4);
        list.addAfter(28);
        list.addAfter(16);

        list.start();

        System.out.println("integer list:");
        list.print();

        System.out.println(
                "maximum: " + list.getMaximum()
        );

        System.out.println(
                "current: " + list.getCurrent()
        );
    }

    private void testStringList() {
        GenericList<String> list =
                new GenericList<>();

        list.addAfter("Apple");
        list.addAfter("Orange");
        list.addAfter("Banana");
        list.addAfter("Pear");

        list.start();

        System.out.println("string list:");
        list.print();

        System.out.println(
                "maximum: " + list.getMaximum()
        );

        System.out.println(
                "current: " + list.getCurrent()
        );
    }

    private void createWidgetList() {
        widgetList = new GenericList<>();

        widgetList.addAfter(
                new Widget("Keyboard", 49.99)
        );

        widgetList.addAfter(
                new Widget("Monitor", 249.99)
        );

        widgetList.addAfter(
                new Widget("Mouse", 29.99)
        );

        widgetList.addAfter(
                new Widget("Headset", 89.99)
        );

        widgetList.start();

        System.out.println(
                "widget list created"
        );

        widgetList.print();
    }

    private void showMaximumWidget() {
        Widget maximum =
                widgetList.getMaximum();

        if (maximum == null) {
            System.out.println(
                    "the list is empty"
            );
        } else {
            System.out.println(
                    "maximum widget: " + maximum
            );

            System.out.println(
                    "current widget: "
                    + widgetList.getCurrent()
            );
        }
    }

    private void showCurrentWidget() {
        Widget current =
                widgetList.getCurrent();

        if (current == null) {
            System.out.println(
                    "there is no current widget"
            );
        } else {
            System.out.println(
                    "current widget: " + current
            );
        }
    }

    private void advanceWidgetList() {
        if (widgetList.advance()) {
            System.out.println(
                    "moved to the next widget"
            );

            showCurrentWidget();
        } else {
            System.out.println(
                    "cannot advance"
            );
        }
    }

    private void deleteCurrentWidget() {
        if (widgetList.getCurrent() == null) {
            System.out.println(
                    "there is no current widget"
            );

            return;
        }

        widgetList.deleteCurrent();

        System.out.println(
                "current widget deleted"
        );

        showCurrentWidget();
    }
}

