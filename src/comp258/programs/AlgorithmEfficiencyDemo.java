package comp258.programs;

import comp258.collections.ArrayManager;
import comp258.collections.LinkedList;

public class AlgorithmEfficiencyDemo {
    public static void main(String[] args) {
        int[] values = {1, 3, 4, 5, 3, 4, 3, 4, 1, 2, 5, 6};
        ArrayManager array = new ArrayManager(values);
        LinkedList list = new LinkedList();

        for (int value : values) {
            list.addAfter(value);
        }
        list.start();

        System.out.println("array before:");
        array.print();
        array.removeAllOccurances(4);
        System.out.println("array after removing 4:");
        array.print();

        System.out.println("\nlinked list before:");
        list.print();
        list.removeAllOccurances(4);
        System.out.println("linked list after removing 4:");
        list.print();
    }
}
