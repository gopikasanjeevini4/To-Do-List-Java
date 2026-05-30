import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static ArrayList<Task> tasks = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        loadTasks();

        System.out.println("== Welcome to To-Do List App ==");

        while (true) {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Mark Task as Done");
            System.out.println("4. Delete Task");
            System.out.println("5. Exit");
            System.out.print("Choose: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> addTask();
                case 2 -> viewTasks();
                case 3 -> markDone();
                case 4 -> deleteTask();
                case 5 -> {
                    saveTasks();
                    System.out.println("Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid choice!");
            }
        }
    }

    static void addTask() {
        System.out.print("Enter task name: ");
        String name = scanner.nextLine();
        tasks.add(new Task(name));
        System.out.println("Task added: " + name);
    }

    static void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks yet!");
            return;
        }
        System.out.println("\nYour Tasks:");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ". " + tasks.get(i));
        }
    }

    static void markDone() {
        viewTasks();
        if (tasks.isEmpty()) return;

        System.out.print("Enter task number to mark as done: ");
        int num = scanner.nextInt();
        scanner.nextLine();

        if (num < 1 || num > tasks.size()) {
            System.out.println("Invalid number!");
            return;
        }
        tasks.get(num - 1).isDone = true;
        System.out.println("Task marked as done!");
    }

    static void deleteTask() {
        viewTasks();
        if (tasks.isEmpty()) return;

        System.out.print("Enter task number to delete: ");
        int num = scanner.nextInt();
        scanner.nextLine();

        if (num < 1 || num > tasks.size()) {
            System.out.println("Invalid number!");
            return;
        }
        String deleted = tasks.get(num - 1).name;
        tasks.remove(num - 1);
        System.out.println("Deleted: " + deleted);
    }

    static void saveTasks() {
        try {
            FileWriter fw = new FileWriter("tasks.txt");
            for (Task t : tasks) {
                fw.write(t.name + "," + t.isDone + "\n");
            }
            fw.close();
            System.out.println("Tasks saved!");
        } catch (IOException e) {
            System.out.println("Error saving: " + e.getMessage());
        }
    }

    static void loadTasks() {
        File file = new File("tasks.txt");
        if (!file.exists()) return;

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                Task t = new Task(parts[0]);
                t.isDone = Boolean.parseBoolean(parts[1]);
                tasks.add(t);
            }
            br.close();
            System.out.println("Tasks loaded!");
        } catch (IOException e) {
            System.out.println("Error loading: " + e.getMessage());
        }
    }
}