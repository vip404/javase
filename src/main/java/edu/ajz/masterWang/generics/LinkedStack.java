package edu.ajz.masterWang.generics;

/**
 * @ClassName LinkedStack
 * @Description 泛型实现一个堆栈类
 * @Author master wang
 * @Date 2019/7/4 22:31
 * @Version 1.0
 **/
public class LinkedStack<T> {

    private static class Node<U>{
        U item;
        Node<U> next;
        Node(){
            item = null;
            next = null;
        }
        Node(U item,Node<U> next){
            this.item = item;
            this.next = next;
        }
        boolean end(){
            return item == null && next == null;
        }
    }
    private Node<T> top = new Node<>();     //end sentinel  结束哨兵

    /**
     *  进站
     * @param item
     */
    public void push(T item){
        top = new Node<>(item,top);
    }

    public T pop(){
        T result = top.item;
        if(!top.end()){
            top = top.next;
        }
        return result;
    }
    public static void main(String[] args){
        LinkedStack<String>  linkedStack = new LinkedStack<>();
        for(String s : "you are idiot".split(" ")){
            linkedStack.push(s);
        }
        String s;
        while((s = linkedStack.pop()) != null){
            System.out.println(s);
        }

    }
}
