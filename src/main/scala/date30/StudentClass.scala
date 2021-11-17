package date30

import java.util.Objects

class StudentClass(val age:Int,val name:String) extends Serializable with Product {



  override def toString: String = {
    s"StudentClass($age,$name)"
  }

  override def hashCode(): Int = {
    Objects.hash(age,name)
  }

  override def equals(obj: Any): Boolean = {

    if(obj==null) false
    else if(!obj.isInstanceOf[StudentClass]) false
    else{
      val temp=obj.asInstanceOf[StudentClass]
      temp.age == this.age && temp.name == this.name
    }

  }

  override def productArity: Int = 2

  override def productElement(n: Int): Any = {
    if(n==0)  this.age
    else if (n == 1) {
      this.name
    } else {
      throw new IndexOutOfBoundsException
    }
  }

  override def productElementName(n: Int): String = {
    if(n==0)   "age"
    else if (n == 1)
      "name"
      else throw new IndexOutOfBoundsException

  }
  override def canEqual(that: Any): Boolean =  equals(that)
}
object StudentClass{

  def apply(age:Int,name:String): StudentClass =new StudentClass(age,name)

  def unapply(studentClass: StudentClass): Option[(Int, String)] =
    Option(studentClass.age,studentClass.name)
}