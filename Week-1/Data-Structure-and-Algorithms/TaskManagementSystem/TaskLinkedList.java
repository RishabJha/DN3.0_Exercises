public class TaskLinkedList {

    class TaskNode {
        Task task;
        TaskNode next;

        public TaskNode(Task task) {
            this.task = task;
            this.next = null;
        }
    }

    private TaskNode head;
    private TaskNode tail;

    public TaskLinkedList() {
        this.head = null;
    }

    public void addTask(Task task) {
        TaskNode newNode = new TaskNode(task);
        if (head == null) {
            head = newNode;
            tail = head;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    public boolean searchTask(String taskId) {
        TaskNode temp = head;
        while (temp != null) {
            if (temp.task.getTaskId().equalsIgnoreCase(taskId)) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    public void deleteTask(String taskId) {
        if (head == null) {
            return;
        }
        if (head.task.getTaskId().equals(taskId)) {
            head = head.next;
            return;
        }
        TaskNode temp = head;
        while (temp.next != null && !temp.next.task.getTaskId().equals(taskId)) {
            temp = temp.next;
        }
        if (temp.next != null) {
            temp.next = temp.next.next;
        }
    }

    public void traverseTasks() {
        TaskNode temp = head;
        while (temp != null) {
            System.out.println(temp.task.toString());
            temp = temp.next;
        }
    }
}