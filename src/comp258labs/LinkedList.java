/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package comp258labs;

/**
 *
 * @author CrgCA
 */
public class LinkedList {

    private ListNode items;
    private ListNode current;

    public LinkedList() 
    {
        items = null;
        current = null;
    }

    public void start() {
        current = items;
    }

    public void addAfter(Object item) {
        ListNode newNode = new ListNode(item);

        if (items == null) 
        {
            items = newNode;
            current = newNode;
            return;
        }

        // restart if current is missing
        if (current == null) {
            current = items;
        }

        newNode.setNextNode(
            current.getNextNode()
        );

        current.setNextNode(newNode);
        current = newNode;
    }

    public void addBefore(Object item) {
        ListNode newNode = new ListNode(item);

        if (items == null) 
        {
            items = newNode;
            current = newNode;
            return;
        }

        // restart if current is missing
        if (current == null) 
        {
            current = items;
        }

        if (current == items) {
            newNode.setNextNode(items);
            items = newNode;
            current = newNode;
            return;
        }

        ListNode previous = findPrevious();

        if (previous != null) 
        {
            previous.setNextNode(newNode);
            newNode.setNextNode(current);
            current = newNode;
        }
    }

    public Object getCurrent() {
        if (current == null) 
        {
            return null;
        }

        return current.getData();
    }

    public boolean advance() {
        if (current == null) 
        {
            return false;
        }

        if (current.getNextNode() == null) 
        {
            return false;
        }

        current = current.getNextNode();
        return true;
    }

    public void deleteCurrent() {
        if (current == null) 
        {
            return;
        }

        if (current == items) 
        {
            items = items.getNextNode();
            current = items;
            return;
        }

        ListNode previous = findPrevious();

        if (previous != null) 
        {
            previous.setNextNode(
                current.getNextNode()
            );

            current = current.getNextNode();
        }
    }

    public Object getItemAt(int position) {
        if (position < 0) {
            return null;
        }

        ListNode temp = items;
        int index = 0;

        while (temp != null) {
            if (index == position) 
            {
                return temp.getData();
            }

            temp = temp.getNextNode();
            index++;
        }

        return null;
    }

    public void print() {
        if (items == null) {
            System.out.println("the list is empty");
            return;
        }

        ListNode temp = items;
        int position = 0;

        while (temp != null) {
            System.out.println(
                position + ": " + temp.getData()
            );

            temp = temp.getNextNode();
            position++;
        }
    }

    public boolean isEmpty() 
    {
        return items == null;
    }

    private ListNode findPrevious() {
        ListNode temp = items;

        while (temp != null) {
            if (temp.getNextNode() == current) 
            {
                return temp;
            }

            temp = temp.getNextNode();
        }

        return null;
    }
} 
