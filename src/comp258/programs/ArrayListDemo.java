/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package comp258.programs;
import java.util.ArrayList;

/**
 *
 * @author CrgCA
 */
public class ArrayListDemo {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();

        numbers.add(12);
        numbers.add(7);
        numbers.add(25);
        numbers.add(4);
        numbers.add(18);

        System.out.println("number of items: " + numbers.size());

        System.out.println("starting items:");
        for (int number : numbers) {
            System.out.println(number);
        }

        // add to the end
        numbers.add(30);
        System.out.println("after adding 30: " + numbers);

        // insert at index 2
        numbers.add(2, 15);
        System.out.println("after inserting 15: " + numbers);

        // remove index 4
        numbers.remove(4);
        System.out.println("after removing index 4: " + numbers);

        System.out.println("item at index 3: " + numbers.get(3));

        // update index 0
        numbers.set(0, 100);
        System.out.println("after updating index 0: " + numbers);

        System.out.println("completed list: " + numbers);
    }

}
