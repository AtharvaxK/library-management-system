package com.atharva.libraryjdbc;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.atharva.libraryjdbc.Servicelayer.BookServiceImp;
import com.atharva.libraryjdbc.Servicelayer.IssuedBookServiceImp;
import com.atharva.libraryjdbc.Servicelayer.UserServiceImp;
import com.atharva.libraryjdbc.model.Admin;
import com.atharva.libraryjdbc.model.Book;
import com.atharva.libraryjdbc.model.IssuedBooks;
import com.atharva.libraryjdbc.model.Student;



@SpringBootApplication
public class LibraryjdbcApplication {

	

    public static void main(String[] args) {

//		ApplicationContext context=SpringApplication.run(LibraryjdbcApplication.class, args);
//
//		Scanner scanner=new Scanner(System.in);
//
//		System.out.println("Library Management System");
//
//
//		while(true){
//			System.out.println("Enter 1 for Book Operations");
//			System.out.println("Enter 2 for User Related Operations");
//			System.out.println("Enter 3 for Book Issueing Related operations");
//			System.out.println("Enter 0 to Exit the system");
//			System.out.println();
//
//			int operationChoice=scanner.nextInt();
//			scanner.nextLine();
//
//			switch (operationChoice) {
//				case 1:
//					BookServiceImp service=context.getBean(BookServiceImp.class);
//				outer:
//				while(true){
//
//					System.out.println("Enter 1 to Add Books");
//					System.out.println("Enter 2 to Display all Books");
//					System.out.println("Enter 3 to update Quantity");
//					System.out.println("Enter 4 to Delete Book");
//					System.out.println("Enter 5 to search by TITLE");
//					System.out.println("Enter 6 search by Author");
//					System.out.println("Enter 0 to EXIT");
//
//					int bookOperationChoice =scanner.nextInt();
//					scanner.nextLine();
//						switch (bookOperationChoice) {
//							case 1:
//								Book book=context.getBean(Book.class);
//								System.out.println("Enter the Titile of the book: ");
//								String title=scanner.nextLine();
//								System.out.println("Enter the Author");
//								String author=scanner.nextLine();
//								System.out.println("Enter the Quantity of the books");
//								int quantity=scanner.nextInt();
//								scanner.nextLine();
//
//
//								book.setTitle(title);
//								book.setAuthor(author);
//								book.setQuantity(quantity);
//
//								service.addBook(book);
//								break;
//
//							case 2:
//								System.out.println(service.getAllBooks());
//								break;
//
//							case 3:
//
//								System.out.println("Enter the id of the book of which the quantity needs to be updated:");
//								int id=scanner.nextInt();
//								scanner.nextLine();
//								System.out.println("Enter the updated quantity");
//								int updatedQuantity=scanner.nextInt();
//								scanner.nextLine();
//
//								service.updateQuantity(updatedQuantity, id);
//								break;
//
//							case 4:
//								System.out.println("Enter the Id of the book to be deleted");
//								int id1=scanner.nextInt();
//								scanner.nextLine();
//
//								service.deleteBook(id1);
//								break;
//
//							case 5:
//
//								System.out.println("Enter the keywords of the title :");
//								String titleKey=scanner.nextLine();
//
//								System.out.println(service.seachByTitle(titleKey));
//								break;
//
//							case 6:
//
//								System.out.println("Enter the keywords of the Author :");
//								String authorKey=scanner.nextLine();
//
//								System.out.println(service.seachByAuthor(authorKey));
//								break;
//
//							case 0:
//								System.out.println("Exiting to Main Menu");
//								break outer;
//
//							default:
//								System.out.println("Invalid choice");
//						}
//
//
//
//
//
//				}
//				break;
//
//				case 2:
//					UserServiceImp UserService=context.getBean(UserServiceImp.class);
//					outer:
//					while (true) {
//
//						System.out.println("Enter 1 to Add the users");
//						System.out.println("Enter 2 to Fetch user by ID");
//						System.out.println("Enter 3 to Display all the Users");
//						System.out.println("Enter 0 to Exit to Main menu");
//
//						int userChoice=scanner.nextInt();
//						scanner.nextLine();
//
//						switch (userChoice) {
//
//							case 1:
//
//
//								System.out.println("Enter the type of the User");
//								String type=scanner.nextLine();
//								System.out.println("Enter the name of the User");
//								String name=scanner.nextLine();
//
//								if(type.equals("Student")){
//									Student student=context.getBean(Student.class);
//									student.setName(name);
//									student.setType(type);
//
//									UserService.addUsers(student);
//
//								}
//								else{
//									Admin admin=context.getBean(Admin.class);
//									admin.setName(name);
//									admin.setType(type);
//
//									UserService.addUsers(admin);
//								}
//
//								break;
//
//							case 2:
//
//								System.out.println("Enter the ID of the user to be fetched :");
//								int userId=scanner.nextInt();
//								scanner.nextLine();
//
//								System.out.println(UserService.getUserById(userId));
//
//								break;
//
//							case 3:
//								System.out.println(UserService.getAllUsers());
//								break;
//
//							case 0:
//								System.out.println("Exiting to Main Menu");
//								break outer;
//
//							default:
//								System.out.println("Enter a valid choice");
//						}
//
//					}
//					break;
//
//				case 3:
//					IssuedBookServiceImp issuedBooksService=context.getBean(IssuedBookServiceImp.class);
//					outer:
//					while (true) {
//
//						System.out.println("Enter 1 to Issue the Book");
//						System.out.println("Enter 2 Return the book");
//						System.out.println("Enter 3 to Display all the Issueing");
//						System.out.println("Enter 4 to display Issue data by User");
//						System.out.println("Enter 0 to Exit to Main Menu");
//
//						int IssueChoice=scanner.nextInt();
//
//						switch (IssueChoice) {
//							case 1:
//								System.out.println("Enter the Book Id to be issued");
//								int bookId=scanner.nextInt();
//								System.out.println("Enter the User ID of whom the book is to be issued");
//								int userID=scanner.nextInt();
//
//								IssuedBooks issueBook=context.getBean(IssuedBooks.class);
//								issueBook.setBookId(bookId);
//								issueBook.setUserId(userID);
//
//								issuedBooksService.issueBook(issueBook);
//
//
//								break;
//
//							case 2:
//								System.out.println("Enter the Issue ID to Return the Book");
//								int issueId=scanner.nextInt();
//
//								issuedBooksService.returnBook(issueId);
//								break;
//
//							case 3:
//								System.out.println(issuedBooksService.getAllIssuedBooks());
//								break;
//
//							case 4:
//								System.out.println("Enter the User ID to know the issued books of the User");
//								int userId=scanner.nextInt();
//
//								System.out.println(issuedBooksService.getAllIssuedBooksByUser(userId));
//								break;
//
//							case 0:
//								System.out.println("Exiting to Main Menu");
//								break outer;
//
//							default:
//								System.out.println("invaid choice!!");
//						}
//					}
//					break;
//
//
//					case 0:
//						System.exit(0);
//
//
//
//				default:
//					System.out.println("Invalid Choice");
//			}
//
//		}
//
//
//
//
		SpringApplication.run(LibraryjdbcApplication.class, args);

	}

}
