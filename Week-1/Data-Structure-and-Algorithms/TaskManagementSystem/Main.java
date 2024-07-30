public class Main {
    public static void main(String[] args) {
        TaskLinkedList taskList = new TaskLinkedList();

        Task task1 = new Task("1", "Complete Web Dev", "Pending");
        Task task2 = new Task("2", "Attend Today's Meeting", "Completed");
        Task task3 = new Task("3", "Prepare Presentation", "In Progress");
        Task task4 = new Task("4", "Complete Week 1 task 1", "Complete");

        taskList.addTask(task1);
        taskList.addTask(task2);
        taskList.addTask(task3);
        taskList.addTask(task4);
        taskList.traverseTasks();
        System.out.println();
        System.out.println(taskList.searchTask("4"));
        System.out.println();
        taskList.deleteTask("2");
        taskList.traverseTasks();
    }
}
