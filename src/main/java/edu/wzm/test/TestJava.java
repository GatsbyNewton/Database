package edu.wzm.test;

import edu.wzm.db.java.Operators;
import edu.wzm.entities.User;

/**
 * Created by Administrator on 2015/10/13.
 */
public class TestJava {

    public static void main(String[] args){
        try{
            User user = new User("4", "Test", 60);
            Operators op = new Operators();

            //add
//            System.out.println(op.add(user));

            //modify
//            System.out.println(op.modify(user));

            //query
            System.out.println(op.query(1));

            //delete
//            System.out.println(op.delete("4"));
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
