package date1611

object FilterNot extends App{

  def filterNot[A](input:List[A])(fx:A=>Boolean):List[A]={

    def filterNot1(input:List[A],output:List[A])(fx:A=>Boolean):List[A]={

      input match {
        case Nil=>output
        case head::tail=>if(!fx(head)) filterNot1(tail,output.appended(head))(fx)
        else filterNot1(tail,output)(fx)
      }
    }
    filterNot1(input,List.empty)(fx)
  }
  println(filterNot(List(1,2,3,4,5,6))(_%2==0))

}
