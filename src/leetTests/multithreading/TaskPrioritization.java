package leetTests.multithreading;

import java.util.concurrent.Semaphore;

public class TaskPrioritization extends Thread {

    Semaphore semaphore;

    private String task;

    public TaskPrioritization(Semaphore sem, String task) {
        this.semaphore = sem;
        this.task = task;
    }

    @Override
    public void run() {
        if (task.equals("A")) {
            try {
                semaphore.acquire();
                System.out.println("Task " + task + " has started");
                semaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        if (task.equals("B")) {
            try {
                semaphore.acquire();
                System.out.println("Task " + task + " has started");
                semaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        if (task.equals("C")) {
            try {
                semaphore.acquire();
                System.out.println("Task " + task + " has started");
                semaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {

        Semaphore semaphore = new Semaphore(1);

        TaskPrioritization task1 = new TaskPrioritization(semaphore, "A");
        TaskPrioritization task2 = new TaskPrioritization(semaphore, "B");
        TaskPrioritization task3 = new TaskPrioritization(semaphore,"C");

        task1.start();
        task2.start();
        task3.start();

        task1.join();
        task2.join();
        task3.join();
    }


}
