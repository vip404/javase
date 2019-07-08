package edu.ajz.masterWang.collections;

import java.util.Iterator;
import java.util.Map;

/**
 * @ClassName IterableClass
 * @Description 迭代器
 * @Author master wang
 * @Date 2019/5/3 20:30
 * @Version 1.0
 **/
public class IterableClass  implements Iterable<String>{

    protected String[] words = (" we are who we are !").split(" ");
    @Override
    public Iterator<String> iterator() {
        return new Iterator<String>() {
            private int index = 0;
            @Override
            public boolean hasNext() {
                return index < words.length;
            }

            @Override
            public String next() {
                return words[index++];      //index++
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    public static void main(String[] args){
        for(String s : new IterableClass()){
            System.out.print(s + " ");
        }
        System.out.println();
        for(Map.Entry entry : System.getenv().entrySet()){
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
