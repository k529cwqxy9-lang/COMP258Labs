package comp258labs;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author CrgCA
 */
public class ListNode {

    private Object data;
    private ListNode nextNode;

    public ListNode(Object data) 
    
    {
        this.data = data;
        nextNode = null;
    }

    public Object getData() 
    {
        return data;
    }

    public void setData(Object data) 
    
    {
        this.data = data;
    }

    public ListNode getNextNode() 
    
    {
        return nextNode;
    }

    public void setNextNode(ListNode nextNode) 
    
    {
        this.nextNode = nextNode;
    }
}
    

