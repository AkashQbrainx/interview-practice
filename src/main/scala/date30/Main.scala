package date30

import date30.StudentClass.unapply

object Main extends App {

  val student=Student(12,"aakash")
  val student1=Student(12,"aakash")
  val studentClass=StudentClass(14,"akshay")
  val studentClass1=StudentClass(14,"akshay")
  val Student(age,name)=student
  println(age)
  println(name)

  println(student)
  println(studentClass)
  println(">>>>>>>>>>>>>>")
  println(student.hashCode())
  println(student1.hashCode())
  println(studentClass.hashCode())
  println(studentClass1.hashCode())
  println(">>>>>>>>>....")
  println(student.equals(student1))
  println(studentClass.equals(studentClass1))
  println(">>>>>>>>>>>>")
  println(student.isInstanceOf[Serializable])
  println(studentClass.isInstanceOf[Serializable])
  println(student.productArity)
  println(student.productElementName(0))
  println(student.productElement(0))
  println(studentClass.productArity)
  println(studentClass.productElement(0))
  println(">>>>>>>>>>.")
  val a=studentClass.productIterator
  while(a.hasNext){
    println(a.next())
  }
}
