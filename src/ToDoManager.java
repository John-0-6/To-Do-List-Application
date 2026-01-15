import java.io.*;
import java.util.ArrayList;

public class ToDoManager {

  ArrayList<ToDo> todoLists;
  ArrayList<ToDo> completedTasks;
  private final String FILE_NAME = "tasks.txt";

  public ToDoManager(){
    todoLists = new ArrayList<>();
    completedTasks = new ArrayList<>();
    loadTasksFromFile();
  }

  // Show Active Task/s
  public boolean showTasks(){
    if(todoLists.isEmpty()){
      System.out.println("--- No tasks ---");
      return false;
    }

    for(ToDo todo : todoLists){
      System.out.println(todo);
    }
    return true;
  }

  // Show Completed Task/s
  public boolean showCompleteTasks(){
    if(completedTasks.isEmpty()){
      System.out.println("--- No tasks ---");
      return false;
    }

    for(ToDo todo : completedTasks){
      System.out.println(todo);
    }
    return true;
  }

  // Add New Task
  public void addTask(ToDo todo){
    todoLists.add(todo);
    saveTaskToFile();
  }

  // Remove Active Task then add it to Completed Task
  public void completedTasks(String completedTask){
    for(int i = 0; i < todoLists.size(); i++){
      ToDo todo = todoLists.get(i);
      if(todoLists.get(i).getTask().equalsIgnoreCase(completedTask)){
        todoLists.remove(i);
        completedTasks.add(todo);
        saveTaskToFile();
        System.out.println("--- Task marked as Completed ---");
        return;
      }
    }
    System.out.println("--- Task not found ---");
  }

  // Delete from Active Tasks
  public void deleteTask(String deleteTask){
    for(int i = 0; i < todoLists.size(); i++){
      if (todoLists.get(i).getTask().equalsIgnoreCase(deleteTask)){
        todoLists.remove(i);
        saveTaskToFile();
        return;
      }
    }
  }

  // Delete from Completed Tasks
  public void deleteCompletedTask(String deleteCompletedTask){
    for(int i = 0; i < completedTasks.size(); i++){
      if (completedTasks.get(i).getTask().equalsIgnoreCase(deleteCompletedTask)){
        completedTasks.remove(i);
        saveTaskToFile();
        return;
      }
    }
  }


//  ------------------- FILE I/O METHODS -------------------

  // Save Tasks to File
  private void saveTaskToFile(){

    try(PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME))){

      // Save active tasks
      for(ToDo todo : todoLists){
        writer.println(todo.getDate() + " : " + todo.getTask() + " : active");
      }

      // Save completed tasks
      for(ToDo todo : completedTasks){
        writer.println(todo.getDate() + " : " + todo.getTask() + " : completed");
      }

    } catch (IOException e) {
      System.out.println("--- Error saving task ---");
    }
  }

  // Load Tasks to Program
  private void loadTasksFromFile() {
    try(BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))){
      String line;
      while ((line = reader.readLine()) != null) {
        String[] parts = line.split(" : ");
        if (parts.length == 3) { // now we expect 3 parts
          String date = parts[0];
          String task = parts[1];
          String status = parts[2];

          ToDo todo = new ToDo(date, task);

          // Look for Active then add to todoLists
          if(status.equalsIgnoreCase("active")){
            todoLists.add(todo);
          }
          // Look for Completed then add to completedTasks
          else if(status.equalsIgnoreCase("completed")){
            completedTasks.add(todo);
          }
        }
      }
    }
    catch(FileNotFoundException e){
      System.out.println("--- Account not Found ---");
    }
    catch(IOException e){
      System.out.println("--- Error Loading Tasks ---");
    }
  }
}
