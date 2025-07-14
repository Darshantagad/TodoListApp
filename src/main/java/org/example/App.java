package org.example;
 import java.util.ArrayList;
 import java.util.Scanner;

public class  App {
    private static ArrayList<String> tasks = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main( String[] args ) {
        System.out.println("---Welcome to TODO List App---");
        int choice;
        do{
            displayMenu();
            System.out.println("Please enter your choice");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice){
                case 1:
                    addTask();
                    break;
                case 2:
                    viewTasks();
                    break;
                case 3:
                    markTaskDone();
                    break;
                case 4:
                    deleteTask();
                    break;
                case 5:
                    System.out.println("Exiting TODO List App. Goodbye!");
                    break;
                default:
                    System.out.println("Inavalid choice. Please try again.");
            }
            System.out.println();
        }while (choice!=5);
        scanner.close();
    }
    private static void displayMenu(){
        System.out.println("1. Add Task");
        System.out.println("2. View Tasks");
        System.out.println("3. Mark Task as Done");
        System.out.println("4. Delete Task");
        System.out.println("1. Exit");
    }
    private static void addTask(){
        System.out.println("Enter the task to add: ");
        String task = scanner.nextLine();
        tasks.add(task);
        System.out.println("Task added successfully!");
    }
    private  static void viewTasks(){
        if(tasks.isEmpty()){
            System.out.println("No tasks in the list");
            return;
        }
        System.out.println("--- Your Tasks ---");
        for(int i= 0; i<tasks.size(); i++){
            System.out.println((i+1)+ ". " + tasks.get(i));
        }
    }
    private static void markTaskDone(){
        viewTasks();
        if(tasks.isEmpty()){
            return;
        }
        System.out.println("Enter the number of the task to mark as done: ");
        int taskNumber = scanner.nextInt();
        scanner.nextLine();

        if (taskNumber>0 && taskNumber<=tasks.size()){
            String originalTask = tasks.get(taskNumber-1);

            if (!originalTask.startsWith("[Done] ")){
                tasks.set(taskNumber-1, "[Done] " + originalTask);
                System.out.println("Task marked as done!");
            }else{
                System.out.println("Task is already marked as done.");
            }
        }else{
            System.out.println("Invalid task number.");
        }
    }
    private static void deleteTask(){
        viewTasks();
        if(tasks.isEmpty()){
            return;
        }
        System.out.println("Enter the number of the task to delete: ");
        int taskNumber = scanner.nextInt();
        scanner.nextLine();

        if(taskNumber>0 && taskNumber<= tasks.size()){
            String removedTask = tasks.remove(taskNumber-1);
            System.out.println("Task '" + removedTask + "' deleted sucessfully!");
        }else{
            System.out.println("Invalid task number.");
        }
    }
}

