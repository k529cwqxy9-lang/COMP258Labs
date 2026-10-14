/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package comp258.programs;
import java.util.LinkedList;
/**
 *
 * @author CrgCA
 */
public class BuiltInLinkedListDemo {

    public static void main(String[] args) {
        LinkedList<Integer> numbers = new LinkedList<>();

        numbers.add(12);
        numbers.add(7);
        numbers.add(25);
        numbers.add(4);
        numbers.add(18);

        System.out.println("starting list:");
        printList(numbers);

        System.out.println("number of items: " + numbers.size());

        // add to the end
        numbers.add(30);
        System.out.println("after adding 30:");
        printList(numbers);

        // add at index 2
        numbers.add(2, 15);
        System.out.println("after adding 15 at index 2:");
        printList(numbers);

        // remove index 4
        numbers.remove(4);
        System.out.println("after removing index 4:");
        printList(numbers);

        System.out.println(
            "item at index 3: " + numbers.get(3)
        );

        // replace the first item
        numbers.set(0, 100);
        System.out.println("after replacing the first item:");
        printList(numbers);

        // add to front
        numbers.addFirst(50);
        System.out.println("after adding to front:");
        printList(numbers);

        // add to end
        numbers.addLast(60);
        System.out.println("after adding to end:");
        printList(numbers);

        // remove first
        numbers.removeFirst();
        System.out.println("after removing first:");
        printList(numbers);

        // remove last
        numbers.removeLast();
        System.out.println("after removing last:");
        printList(numbers);

        System.out.println(
            "final size: " + numbers.size()
        );
    }

    private static void printList(
            LinkedList<Integer> numbers) {

        for (int number : numbers) {
            System.out.print(number + " ");
        }

        System.out.println();
    }
}   

