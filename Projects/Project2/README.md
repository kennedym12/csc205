Library Project
This project is a library catalog. It will have a database of the library's books and a 
search based on book title.

LibraryBook Class
- contains 5 basic (private) components of a library book


LibraryCatalog Class (contains librarybook class)
- Catalog | data structure attribute that will hold library books instances
- Input |  method that accepts .dat file, creates librarybook instances, and adds them tothe catalog data structure
- Sort | method to sort library books in data structure
- displayRecords | uses loop to display books in the catalog; takes in boolea value to choose whether to display the titles only (true)
- Menu | displays the catalog actions menu (make it pretty), includes statement to enter a number correlated to an option, include try statement?

User Interaction
- prompts user to enter .dat file to input books into catalog from
- calls sort
- prints statement that tells the user the number of books that have been put into and sorted in the catalog
- prompt the user to hit return when ready to continue
- display the main menu after the user hits return
- Option 1 will call displayRecords
- Option 2 will (use try catch) prompt the user to enter a book title,execute a binary search using the built-in compareTo method within LibraryBook to find the book 
- Option 3 will exit the program and print a goodbye screen
