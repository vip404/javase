package edu.ajz.masterWang.RTTI.generics;

import javax.swing.plaf.BorderUIResource;

/**
 * @ClassName ClassCasts
 * @Description Class引用的cast()方法
 * @Author master wang
 * @Date 2019/5/12 20:31
 * @Version 1.0
 **/
public class ClassCasts {

    public static void main(String[] args){
        Building building = new House();
        Class<House> houseClass = House.class;
        System.out.println(houseClass.getName());
        House house = houseClass.cast(building);           //向下转型
        System.out.println(house);
        house = (House) building;       //或者这样
        System.out.println(house);
        try {
            house = houseClass.newInstance();
            System.out.println(house);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }
}
class Building{}

class House extends Building{

}