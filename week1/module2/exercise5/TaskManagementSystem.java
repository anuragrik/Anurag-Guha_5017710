package week1.module2.exercise5;
public class TaskManagementSystem {
    private Node head;

    // Node class
    private class Node {
        Task task;
        Node next;

        Node(Task task) {
            this.task = task;
            this.next = null;
        }
    }

    // Add a task
    public void addTask(Task task) {
        Node newNode = new Node(task);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    // Search for a task by ID
    public Task searchTask(String taskId) {
        Node current = head;
        while (current != null) {
            if (current.task.getTaskId().equals(taskId)) {
                return current.task;
            }
            current = current.next;
        }
        return null; // Task not found
    }

    // Traverse and display all tasks
    public void traverseTasks() {
        Node current = head;
        while (current != null) {
            System.out.println(current.task);
            current = current.next;
        }
    }

    // Delete a task by ID
    public void deleteTask(String taskId) {
        if (head == null) {
            System.out.println("Task list is empty.");
            return;
        }

        // Handle deletion of the head node
        if (head.task.getTaskId().equals(taskId)) {
            head = head.next;
            return;
        }

        Node current = head;
        while (current.next != null && !current.next.task.getTaskId().equals(taskId)) {
            current = current.next;
        }

        if (current.next != null) {
            current.next = current.next.next;
        } else {
            System.out.println("Task with ID " + taskId + " not found.");
        }
    }

    public static void main(String[] args) {
        TaskManagementSystem system = new TaskManagementSystem();

        // Add some tasks
        system.addTask(new Task("T001", "Task A", "Incomplete"));
        system.addTask(new Task("T002", "Task B", "Complete"));
        system.addTask(new Task("T003", "Task C", "Incomplete"));

        // Traverse tasks
        system.traverseTasks();

        // Search for a task
        System.out.println("Searching for T002: " + system.searchTask("T002"));

        // Delete a task
        system.deleteTask("T002");

        // Traverse tasks after deletion
        system.traverseTasks();
    }
}
