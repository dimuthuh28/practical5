import scala.collection.mutable

class Book(val title: String, val author: String, val isbn: String) {
  override def toString: String = s"Book($title, $author, $isbn)"
}

object BookStore {
  var books: mutable.Set[Book] = mutable.Set()

  def addNewBook(title: String, author: String, isbn: String): Unit = {
    val newBook = new Book(title, author, isbn)
    books += newBook
    println(s"Added new book: $newBook")
  }

  def removeBook(isbn: String): Unit = {
      val bookToRemove = books.find(_.isbn == isbn)
      if (bookToRemove.isDefined) {
        books -= bookToRemove.get
        println(s"Removed book: $bookToRemove")
      } else {
        println(s"No book found with ISBN: $isbn")
      }
    }

  def searchBook(isbn: String): Unit = {
    books.find(_.isbn == isbn) match {
      case Some(book) =>
        println(s"Found book: ${book.title} - ${book.author} - ${book.isbn}")
      case None =>
        println(s"No book found with ISBN: $isbn")
    }
  }

  def printAllBooks(): Unit = {
    var index = 1
    for (book <- books) {
      println(s"$index. ${book.title} - ${book.author} - ${book.isbn}")
      index += 1
    }
  }

  def main(args: Array[String]): Unit = {

    addNewBook("A", "Kamal Gunaratne", "978-3-16-148410-0")
    addNewBook("B", "Saman Kumara", "978-3-16-148410-1")
    addNewBook("C", "Susantha Susantha", "978-3-16-148410-2")

    def printAllBooks(): Unit = {
      books.zipWithIndex.foreach { case (book, index) =>
        println(s"${index + 1}. ${book.title} - ${book.author} - ${book.isbn}")
      }
    }

    def searchByTitle(title: String): Unit = {
      val foundBooks = books.filter(_.title == title)
      if (foundBooks.nonEmpty) {
        foundBooks.foreach(book => println(s"Found book: ${book.title} - ${book.author} - ${book.isbn}"))
      } else {
        println(s"No book found with title '$title'")
      }
    }

    def searchBooksByAuthor(author: String): Unit = {
      val foundBooks = books.filter(_.author == author)
      if (foundBooks.nonEmpty) {
        println(s"Books by author '$author':")
        foundBooks.foreach(book => println(s"${book.title} - ${book.author} - ${book.isbn}"))
      } else {
        println(s"No books found by author '$author'")
      }
    }
    
    printAllBooks()

    searchBook("978-3-16-148410-1")

    removeBook("978-3-16-148410-2")

    printAllBooks()
  }
}
