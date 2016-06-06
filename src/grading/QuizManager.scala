package grading

/**
 * Created by vladimirsivanovs on 06/06/2016.
 */
class QuizManager {
  type Result = (String, Int)
  type Quiz = Seq[Result]
  type Course = Seq[Quiz]


}

object Run extends App{
  type Result = (String, Int)
  type Quiz = Seq[Result]
  type Course = Seq[Quiz]

  val quiz1 = Seq(("a1", 100), ("b1", 2), ("c1", 3))
  val quiz2 = Seq(("a1", 4), ("b1", 3), ("c1", 5))
  val quiz3 = Seq(("a1", 10), ("b1", 11), ("c1", 9))

  val course = Seq(quiz1, quiz2, quiz3)

  def quizAvarage(quiz:Quiz): Float = {
    val sum = quiz.map(_._2).sum / quiz.length
    sum
  }



  def courseMean(course:Seq[Quiz]):Seq[Float] ={
    return course.map(quizAvarage)
  }

  println(courseMean(Seq(quiz1,quiz2,quiz3)))

  def studentMeans(course: Course): Map[String, Float] = {
    course.flatten.groupBy(_._1).map{
      case (student, grades) => (student, grades.foldLeft(0.0f)(_ + _._2)/grades.length)
    }
  }

  def topStudents(course: Course, n: Int): Seq[String] = {
    studentMeans(course).toList.sortBy(-_._2).map(_._1).takeRight(n)
  }

  def passingStudents(course: Course): Seq[String] = {
    studentMeans(course).toList.filter(_._2 >= 3.5f).map(_._1)
  }

  def histogram(course: Course): Map[Int,Int] = {
    return Map()
  }

  println(studentMeans(course).toSeq.sortBy(_._2).takeRight(3))
  println(topStudents(course, 2))
  println(studentMeans(course).groupBy{
    case (a,b) => math.round(b)
  }.map{
    case (grade, student) => (grade, student.size)
  })






}
