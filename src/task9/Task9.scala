package task9

object Task9 extends App{

//  val input = readLine("enter a file name")
//  val file = scala.io.Source.fromFile("src/task9/test")
//
//  val fm = file.getLines()
//    .flatMap(_.split("\\W+"))
//    .foldLeft(Map.empty[String, Int]){
//      (count, word) => count + (word -> (count.getOrElse(word, 0) + 1))
//    }
//
//  println(fm)
//
  val file2 = scala.io.Source.fromFile("src/task9/test")

//  val fm3 = file2.getLines().flatMap(_.split("\\W+")).toList.groupBy(x => x).mapValues(_.length)
//  println(fm3)
  val l = file2.getLines().flatMap(_.split("\\W+")).toList
  println(l)
  val m = l.map(x => (x, l.count(_ == x)))
  println(m)


  val str = "aaa bbbb ccccc ddd"
  val strfm = str.filter(_ != ' ').groupBy(c => c).mapValues(_.length)
  println(strfm)

//  val fm2 = file2.getLines()
//  .flatMap(_.split("\\s")) // or .flatMap(_.split("\\W+"))
//  .toList
//  .groupBy(x => x)
//  .map(x => (x._1, x._2.length))
//
//  println(fm2)


  //FLATTEN
  def flatten2[A](as: List[List[A]]): List[A] = as match {
    case Nil => Nil
    case xs :: bs => xs ::: flatten2(bs)
  }

  val list = List(List(1,2,3), List(3,4,5), List(6,7,8))
  println(flatten2(list))


/// what it outputs ?
  val res0 = List(List("a"), List("ab"), List("abc"), List("abcd")).map(x => x.count(s => s.length > 1))
  println(res0)

  println(List("abc", "fff").count(s => s.length > 1))

  val res1 = List(1,1,2,3,4,5)
  res1.reduceLeft((a,b) => {print(a + "," + b+ " "); a*b})
  println()
  res1.reduceRight((a,b) => {print(a + "," + b+ " "); a*b})

}
