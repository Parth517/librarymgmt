#Library Management System Kata
<p>This is an Exercise that follows the TDD approach-Writing tests first,implementing methods to pass those tests and refactor the code</p>

##How Does it work
This program is written in TDD format and is written step by step.
<p>Create a LibraryManagement System Class that is responsible for managing collection of books in the
library.It implements the BookManager interface and interActs with the BookInventory interface to keep track of each book in the collection</p>
<p>Books class is responsible for maintaining state of books and create new books</p>
<p>Simple Book Inventory class is used to provide implementation for BookInventory to keep track of number of books when they are borrowed or returned</p>
<p>The book Inventory Interface is responsible for declaring methods to count the books currently in library 
and increment and decrement function</p>
<p>Book Manager inteface is responsible for decalring methods for adding books and viewing book in library</p>
<p>The book not available Exception is raised when a person tries to borrow a book that doesnt exist in the system</p>
<p>The invalidbookdetails Exception is raised when invalid details for the book are added when book is added,exception will be raised when the book name is missing,author name is missing,isbn number is missing or publication year is missing</p>

##How to run?
Clone this repo
<p>Run the test by librarymgmt/tree/main/src/test/java/com/example/LibraryManagementSystemTest.java</p>
Result of tests


##Version and library used
<p>Java Version: java 16.0.2</p>
<p>Test Version:JUNIT</p>