# Console-Based To-Do List Application (Java)

A **console-based To-Do List Application** built in **Java** using **Object-Oriented Programming (OOP)** and **File I/O**. This system allows users to manage tasks by adding, marking as completed, deleting, and viewing active/completed tasks, all with persistent storage.

---

## Features

- Add new tasks  
- View active tasks  
- View completed tasks  
- Mark tasks as completed  
- Delete tasks from active or completed lists  
- Auto-stamped tasks with date (`YYYY-MM-DD`)  
- File persistence to save tasks between sessions  

---

## OOP Concepts Used

- Classes & Objects (`ToDo`, `ToDoManager`, `DateGeneratorHelper`, `Main`)  
- Encapsulation (private fields with getters/setters)  
- Separation of responsibilities (Manager class handles data operations)  
- File I/O abstraction (saving and loading tasks)  

---

## Technologies Used

- Java  
- `Scanner` for user input  
- `ArrayList` for task storage  
- `FileReader`, `FileWriter`, `BufferedReader`, `PrintWriter` for file persistence  
- `LocalDate` for task date stamping  

---

## How It Works

1. **Main Menu** displays options:  
   - Show active tasks  
   - Show completed tasks  
   - Add new tasks  
   - Mark tasks as completed  
   - Delete tasks  
   - Exit program
2. Tasks are **auto-stamped** with the current date.  
3. Completed tasks are moved from the active list to the completed list.  
4. All tasks are **saved automatically** in a file (`tasks.txt`).  
5. Data is **loaded at program startup** to restore previous tasks.

---

## Usage

1. **Clone the repository:**
   ```bash
   git clone https://github.com/John-0-6/To-Do-List-Application.git
