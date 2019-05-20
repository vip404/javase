package edu.ajz.masterWang.innerClass;

/**
 * @ClassName Outer
 * @Description TODO
 * @Author master wang
 * @Date 2019/4/10 22:16
 * @Version 1.0
 **/
public class Outer {

    public class Inner {

        private String name;

        public Inner(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Inner{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }
}
