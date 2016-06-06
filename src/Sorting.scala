object Sorting extends App {

  def quickSort(xs: Array[Int]): Array[Int] = {
    if (xs.length <= 1) xs
    else {
      val mid = xs(xs.length/2)
      Array.concat(
        quickSort(xs filter (mid <)),
        quickSort(xs filter (mid ==)),
        quickSort(xs filter (mid >))
      )
    }
  }

  val xs = Array(10,0,30,4,5,6,0,88,9)
  for (x <- xs ) println (x)

//  val mid = xs(xs.length/2)
//  println("Mid is " + mid)
  val sorted = quickSort(xs)

  for(x <- sorted) print(x)

}
