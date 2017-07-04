package jp.drjoy.service.registration.service;

import java.util.*;
/**
 * Created by James on 6/30/2017.
 */
class Bike9{
    static final HaiDang haiDang= new HaiDang();
    static final List<String> speedlimit=new ArrayList<>();//final variable
    static final Integer a=new Integer(3);//final variable
    static final HashMap<String, String> h = new HashMap<String, String>();
    static final String[] bien2= {"1","2","3"};
    static final String[] bien= bien2;
    static void run(){
        speedlimit.add("1");
        System.out.println(speedlimit.size());
        haiDang.age="fef";
        System.out.println(haiDang.age);
        h.put("1","1");
        bien[1]=bien[2];

    }
    public static void main(String args[]){
        Bike9 obj=new  Bike9();
        Bike9.run();
    }
}//end of class

class HaiDang{
    String age ="sdfdf";
}