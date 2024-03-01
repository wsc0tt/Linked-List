/**
 * @author William Scott
 *  CSC 130 - Project 1
 *  Linked List Driver/Main File
 *  Menu driven program to test the Linked List methods
 */

import java.io.*;
import java.util.*;

public class LinkedListMain {
    public static void main(String[] args) throws FileNotFoundException {
        LinkedList list = new LinkedList();
        System.out.println("--- \"Proper\" Linked List Testing ---");
        System.out.println("Enter the name of the file you would like to test:");
        Scanner console = new Scanner(System.in);
        Scanner file = new Scanner(new File("test/" + console.next())); // read user input test file from test folder

        // while the file has another line read the file and build linked list
        while (file.hasNextLine()) {
            String line = file.nextLine().trim();
            if (!line.equals("END")) {  // if the string != "END" add string to linked list
                list.addTail(line);
            }
        }

        menu(console, list);

    }

    // menu interface to test Linked List methods
    public static void menu(Scanner console, LinkedList list) {
        int choice;
        do {
            System.out.println();
            System.out.println("--- Testing Menu ---");
            System.out.println("1. Display List");
            System.out.println("2. Display List in Reverse");
            System.out.println("3. Add Head Node");
            System.out.println("4. Add Tail Node");
            System.out.println("5. Remove Head Node");
            System.out.println("6. Remove Tail Node");
            System.out.println("7. Check isEmpty()");
            System.out.println("8. About Me");
            System.out.println("9. Quit");

            choice = console.nextInt();
            switch(choice) {
                case 1:
                    System.out.println(list);
                    break;
                case 2:
                    System.out.println(list.toStringReverse());
                    break;
                case 3:
                    System.out.println("Name new head: ");
                    console.nextLine();
                    list.addHead(console.nextLine());
                    System.out.println("Head successfully added");
                    break;
                case 4:
                    System.out.println("Name new tail: ");
                    console.nextLine();
                    list.addTail(console.nextLine());
                    System.out.println("Tail successfully added");
                    break;
                case 5:
                    System.out.println("Removing head...");
                    System.out.println(list.removeHead() + " successfully removed");
                    break;
                case 6:
                    System.out.println("Removing tail...");
                    System.out.println(list.removeTail() + " successfully removed");
                    break;
                case 7:
                    if (list.isEmpty()) {
                        System.out.println("The list is empty...");
                    }
                    else {
                        System.out.println("The list is not empty...");
                    }
                    break;
                case 8:
                    System.out.println(list.about());
                    break;
                case 9:
                    System.out.println("GOODBYE");
                    break;
                default:
                    System.out.println("Please enter 1-9");
                    break;
            }
        } while (choice != 9);
    }
}