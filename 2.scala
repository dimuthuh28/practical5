case class Book(title: String, author: String, isbn:String)

object LibraryManagement{
    var library: Set[Book]=Set(
        Book("A", "Kamal Gunaratne","978-3-16-148410-1"),
        Book("B", "Saman Kumara", "978-3-16-148410-2"),
        Book("C", "Susantha Susantha", "978-3-16-148410-3")
    )

    def addBook(book: Book): Unit={
        library+=book
    }

    def removeBook(isbn: String):Unit={
        library=library.filterNot(_.isbn==isbn)
    }

    def isBookInLibrary(isbn: String):Boolean={
        library.exists(_.isbn==isbn)
    }

    def displayLibrary(): Unit={
        library.foreach(book=>println(s"Title:${book.title}, Author: ${book.author}, ISBN: ${book.isbn}"))
    }

    def findBookTitle(title:String): Option[Book]={
        library.find(_.title.toLowerCase==title.toLowerCase)
    }

    def displayBook(author:String): Unit={
        library.filter(_.author.toLowerCase==author.toLowerCase).foreach(book=>println(s"Title: ${book.title}, ISBN: ${book.isbn}"))
    }

    def main(args: Array[String]): Unit = {
        println("Initial Library Collection:")
        displayLibrary()

        println("\nAdd new book")
        val newBook = Book("D", "Kavindu", "978-3-16-148410-4")
        addBook(newBook)
        displayLibrary()

        println("\nRemove book")
        removeBook("978-3-16-148410-2")
        displayLibrary()

        println("\nCheck if a Book is in the Library by ISBN (978-3-16-148410-3):")
        println(isBookInLibrary("978-3-16-148410-3"))

        println("\nSearch for a Book by Title:")
        findBookTitle("C").foreach(book => println(s"Found: Title: ${book.title}, Author: ${book.author}, ISBN: ${book.isbn}"))

        println("\nDisplay Books by Saman Kumara:")
        displayBook("Saman Kumara")
  }
}
