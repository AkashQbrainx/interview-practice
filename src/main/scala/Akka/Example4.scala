package Akka

object Example4 extends App{
  // Either
  def Name(name: String): Either[String, String] =
  {

    if (name.isEmpty)
    // Left child for failure
      Left("There is no name.")

    else
    // Right child for success
      Right(name)
  }

  println(Name("GeeksforGeeks"))

  println(Name(""))

}
