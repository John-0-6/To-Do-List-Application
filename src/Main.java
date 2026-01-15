import java.util.Scanner;

public class Main {
  public static void main(String[] args){
    Scanner scanner = new Scanner(System.in);
    ToDoManager manager = new ToDoManager();

    boolean running = true;

    while(running){
      // Main Menu
      System.out.println("\n1. Show Active Task/s");
      System.out.println("2. Show Completed Task/s");
      System.out.println("3. Add Task");
      System.out.println("4. Mark as Completed Task");
      System.out.println("5. Delete Task");
      System.out.println("6. Delete Completed Task");
      System.out.println("7. Exit Program");
      System.out.print("Enter your choice: ");
      int choice = scanner.nextInt();
      scanner.nextLine();

      switch(choice){
        // Show Active Task/s
        case 1:
          if(!manager.showTasks()){
            break;
          }

          System.out.print("\nPress \"Enter\" to go back");
          scanner.nextLine();
          break;

        // Show Completed Task/s
        case 2:
          if(!manager.showCompleteTasks()){
            break;
          }

          System.out.print("\nPress \"Enter\" to go back");
          scanner.nextLine();
          break;

        // Add New Task
        case 3:
          DateGeneratorHelper dateGeneratorHelper = new DateGeneratorHelper();
          String date = dateGeneratorHelper.date();

          System.out.print("Enter task: ");
          String task = scanner.nextLine().toUpperCase();

          ToDo todo = new ToDo(date, task);
          manager.addTask(todo);
          break;

        // Remove Active Task then add it to Completed Task
        case 4:
          System.out.print("Enter Task: ");
          String completedTask = scanner.nextLine().toUpperCase();

          manager.completedTasks(completedTask);
          break;

        // Delete from Active Task/s
        case 5:
          if(!manager.showTasks()){
            break;
          }

          System.out.print("\nEnter Task: ");
          String deleteTask = scanner.nextLine().toUpperCase();

          manager.deleteTask(deleteTask);
          break;

        // Delete from Completed Task/s
        case 6:
          if(!manager.showCompleteTasks()){
            break;
          }

          System.out.print("\nEnter Task: ");
          String deleteCompletedTask = scanner.nextLine().toUpperCase();

          manager.deleteCompletedTask(deleteCompletedTask);
          break;

        // Exit Program
        case 7:
          running = false;
          System.out.println("--- Exiting Program ---");
          break;
      }
    }
    scanner.close();
  }
}
