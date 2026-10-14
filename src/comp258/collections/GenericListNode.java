/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package comp258.collections;

/**
 *
 * @author CrgCA
 */
public class GenericListNode<T> {

    private T data;
    private GenericListNode<T> nextNode;

    public GenericListNode(T data) {
        this.data = data;
        nextNode = null;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public GenericListNode<T> getNextNode() {
        return nextNode;
    }

    public void setNextNode(GenericListNode<T> nextNode) {
        this.nextNode = nextNode;
    }
}