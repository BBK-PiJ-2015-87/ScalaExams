package inheritance

class A {
  override def toString = "A " + super.toString
}

trait B extends A {
  override def toString = "B " + super.toString
}

trait C extends A {
  override def toString = "C " + super.toString
}

trait Higher extends C {
  override def toString = "Higher " + super.toString
}

trait Traits extends B {
  override def toString = "Traits " + super.toString
}

class Scala extends A with Traits with Higher {
  override def toString = "Scala -> " + super.toString
}

object Run extends App {
  val scala = new Scala
  println(scala.toString) //Scala -> Higher -> C -> A -> Traits -> B -> A -> A
}

