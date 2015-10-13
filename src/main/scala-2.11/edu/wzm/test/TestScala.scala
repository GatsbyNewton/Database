package edu.wzm.test

import edu.wzm.db.scala.Operators

/**
 * Created by GatsbyNewton on 2015/10/12.
 */
object TestScala {

  def main(args: Array[String]): Unit ={
    try{
      //    println(DBUtils.getConnection())
      val op = new Operators()
      val user = op.User("4", "Test", 40)

      //add
//      println(op.add(user))

      //modify
//      println(op.modify(user))

      //query
      println(op.query(1))

      //delete
//      println(op.delete("4"))
    }
    catch {
      case ex:Exception => ex.printStackTrace()
    }
  }
}
