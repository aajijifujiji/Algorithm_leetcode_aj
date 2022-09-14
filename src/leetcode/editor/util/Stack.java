package leetcode.editor.util;

public class Stack<Item> {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack);
        System.out.println(stack.peck());
        stack.pop();
        System.out.println(stack);
    }
    private Node first;
    private int N ;
    private class Node{
        Item item ;
        Node next;
    }
    public boolean isEmpty(){return first == null;}
    public int size (){return N;}
    public void push(Item item){
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        N++;
    }
    public Item pop(){
        Item item = first.item;
        if(first != null){
            first = first.next;
            N--;
        }
        return item;
    }
    public Item peck(){
        return first.item;
    }

    @Override
    public String toString() {
        Node curr = first;
       String ret =  "Stack "+ "(N:"+N+"){";
       while (curr != null){
           ret += "node=" + curr.item;
           if (curr.next != null )ret +=",";
           curr = curr.next;
       }
       ret += '}';
       return ret;
    }
}
