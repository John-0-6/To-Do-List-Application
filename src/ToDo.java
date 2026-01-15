public class ToDo {

  private final String date;
  private final String task;
  private boolean isActive;

  public ToDo(String date, String task){
    this.date = date;
    this.task = task;
    this.isActive = true;
  }

  public String getDate() {
    return date;
  }

  public String getTask() {
    return task;
  }

  public boolean isActive() {
    return isActive;
  }

  public void setActive(boolean isActive){
    this.isActive = isActive;
  }

  @Override
  public String toString(){
    return "\n" + date + " : " + task;
  }
}
