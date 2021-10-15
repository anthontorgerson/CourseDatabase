
/**
 * @author Dylan Thomas - djthomas4
 * CIS175 - Fall 2021
 * Oct 14, 2021
 */
import java.util.List;
import java.util.Scanner;

import controller.StudentHelper;
import model.Student;


public class RunProgram {

		static Scanner in = new Scanner(System.in);
		static StudentHelper studh = new StudentHelper();

		private static void addStudent() {
			System.out.print("\nEnter the student name: ");
			String name = in.nextLine();
			
			Student toAdd = new Student(name);
			studh.insertEntry(toAdd);
		}

		private static void deleteStudent() {
			System.out.print("\nEnter the student name to delete: ");
			String name = in.nextLine();
			
			Student toDelete =	new	Student(name);
			studh.deleteEntry(toDelete);
		}

		

		public static void main(String[] args) {
			runMenu();
		}

		public static void runMenu() {
			boolean restart = true;
			System.out.println("----- Course Database -----");
			while (restart) {
				System.out.println("\n     MENU\n---------------");
				System.out.println("  1. Add");
				System.out.println("  2. Delete");
				System.out.println("  3. Edit");
				System.out.println("  4. View collection");
				System.out.println("  5. Quit");
				System.out.print("  Enter a menu choice: ");
				int choice = in.nextInt();
				in.nextLine();

				if (choice == 1) {
					addStudent();
				} else if (choice == 2) {
					deleteStudent();
				} //else if (choice == 3) {
					//updateStudent();
				//} 
				else if (choice == 4) {
					viewStudentList();
				} else {
					studh.cleanUp();
					System.out.println("\nGoodbye.");
					restart = false;
				}

			}

		}

		private static void viewStudentList() {
			List<Student> allStudents = studh.showAllEntries();
			System.out.println("");
			for(Student singleStudent : allStudents){
				System.out.println(singleStudent.toString());
			}

		}
		

	}
