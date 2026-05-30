# To-Do List App - Java

A simple console-based To-Do List application built with core Java.

---

## Features

- Add a task
- View all tasks
- Mark task as done
- Delete a task
- Auto save tasks to file
- Auto load tasks on startup

---

## Project Structure

```
To-Do-List/
├── Task.java       -> Task blueprint (name + status)
├── Main.java       -> All logic + menu
└── tasks.txt       -> Auto-created when you exit the app
```

---

## How to Run

### Step 1 - Compile
Open terminal in the project folder and type:
```bash
javac Task.java Main.java
```

### Step 2 - Run
```bash
java Main
```

---

## How to Use

```
== Welcome to To-Do List App ==

===== MENU =====
1. Add Task
2. View Tasks
3. Mark Task as Done
4. Delete Task
5. Exit
Choose:
```

- Type **1** to add a task
- Type **2** to view all tasks
- Type **3** to mark a task as done
- Type **4** to delete a task
- Type **5** to save and exit

---

## Example Output

```
Your Tasks:
1. [TODO] Buy milk
2. [TODO] Study Java
3. [DONE] Complete assignment

Enter task number to mark as done: 2
Task marked as done!

Your Tasks:
1. [TODO] Buy milk
2. [DONE] Study Java
3. [DONE] Complete assignment
```

---

## Concepts Used

- Classes and Objects
- ArrayList
- Loops and Switch-case
- File I/O (read and write)
- Scanner for user input
- Boolean logic

---

## Requirements

- Java 8 or higher
- VS Code or any Java IDE

---

## Author

Made by Gopika Sanjeevini
