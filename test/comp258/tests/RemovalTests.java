package comp258.tests;

import comp258.collections.ArrayManager;
import comp258.collections.LinkedList;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class RemovalTests {
    private static int checks = 0;

    private static void check(boolean result, String message) {
        checks++;
        if (!result) {
            throw new AssertionError(message);
        }
    }

    private static String arrayOutput(ArrayManager array) {
        PrintStream original = System.out;
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        try {
            System.setOut(new PrintStream(output));
            array.print();
        } finally {
            System.setOut(original);
        }
        return output.toString().trim();
    }

    private static void checkRemoval(int[] values, int target) {
        ArrayManager array = new ArrayManager(values);
        LinkedList list = new LinkedList();
        ArrayList<Integer> expected = new ArrayList<>();

        for (int value : values) {
            list.addAfter(value);
            if (value != target) {
                expected.add(value);
            }
        }
        list.start();
        array.removeAllOccurances(target);
        list.removeAllOccurances(target);

        String text = expected.isEmpty() ? "the array manager is empty"
                : "items: " + expected.toString().replace("[", "").replace("]", "");
        check(arrayOutput(array).equals(text), "array contents: " + Arrays.toString(values));
        check(array.size() == expected.size(), "array count");
        for (int i = 0; i < expected.size(); i++) {
            check(expected.get(i).equals(list.getItemAt(i)), "list order at " + i);
        }
        check(list.getItemAt(expected.size()) == null, "list end");

        // check that later inserts still work
        array.add(99);
        list.addAfter(99);
        check(array.size() == expected.size() + 1, "array add after removal");
        check(list.getCurrent().equals(99), "list add after removal");
    }

    public static void main(String[] args) throws Exception {
        checkRemoval(new int[]{1, 3, 4, 5, 3, 4, 3, 4, 1, 2, 5, 6}, 4);
        checkRemoval(new int[]{}, 4);
        checkRemoval(new int[]{4}, 4);
        checkRemoval(new int[]{4, 4, 4}, 4);
        checkRemoval(new int[]{4, 4, 1, 2, 4, 4}, 4);
        checkRemoval(new int[]{1, 2, 3}, 4);
        checkRemoval(new int[]{0, -1, 0, Integer.MIN_VALUE, 0}, 0);

        Random random = new Random(258);
        for (int test = 0; test < 250; test++) {
            int[] values = new int[random.nextInt(51)];
            for (int i = 0; i < values.length; i++) {
                values[i] = random.nextInt(7) - 3;
            }
            checkRemoval(values, random.nextInt(7) - 3);
        }

        LinkedList list = new LinkedList();
        list.addAfter(1);
        list.addAfter(4);
        list.addAfter(4);
        list.addAfter(2);
        list.start();
        list.advance();
        list.removeAllOccurances(4);
        check(list.getCurrent().equals(2), "removed cursor moves to next survivor");
        list.start();
        list.removeAllOccurances(2);
        check(list.getCurrent().equals(1), "surviving cursor is kept");
        list.removeAllOccurances(1);
        check(list.isEmpty() && list.getCurrent() == null, "empty cursor");

        list.addAfter("apple");
        list.addAfter(null);
        list.addAfter("apple");
        list.addAfter("pear");
        list.removeAllOccurances("apple");
        check(list.getItemAt(0) == null && list.getItemAt(1).equals("pear"), "object removal");
        list.removeAllOccurances(null);
        check(list.getItemAt(0).equals("pear") && list.getItemAt(1) == null, "null removal");

        ArrayManager array = new ArrayManager(new int[]{0, 4, 4});
        array.removeAllOccurances(null);
        array.removeAllOccurances("4");
        check(arrayOutput(array).equals("items: 0, 4, 4"), "non-integer targets leave array unchanged");
        array.removeAllOccurances(4);
        array.addAt(7, 1);
        array.remove(0);
        check(arrayOutput(array).equals("items: 7"), "other array methods still work");

        System.out.println(checks + " removal checks passed.");
    }
}
