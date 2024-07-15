import scala.io.StdIn.readLine

object one extends App {

  def getProductList(): List[String] = {
    var items = List[String]()
    var continue = true

    while (continue) {
      println("Enter product name (type 'done' to finish): ")
      val input = readLine()
      if (input == "done") {
        continue = false
      } else {
        items = items :+ input
      }
    }
    items
  }

  def printProductList(items: List[String]): Unit = {
    for (i <- items.indices) {
      println(s"${i + 1}. ${items(i)}")
    }
  }

  def getTotalProducts(items: List[String]): Int = {
    items.length
  }

  val productList = getProductList()

  printProductList(productList)

  println(s"Total number of products: ${getTotalProducts(productList)}")
}
