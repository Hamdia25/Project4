import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collection;
import java.util.*;
public class Main {
    //Hamdi Aden 4/6/25 CSCI1660
    static Scanner input = new Scanner(System.in);
    static ArrayList<String> taskList = new ArrayList<>();
    static List<ToDoList> task = new ArrayList<>();
static                 ObjectMapper map = new ObjectMapper();

    public static void main(String[] args) throws IOException {
        File file = new File("data.json");
        BufferedReader br = new BufferedReader(new FileReader(file));

        String st;
        String total = "";
        while((st = br.readLine())!= null){
            total = total + st;
        }
        taskList = map.readValue(total, new TypeReference<ArrayList<ToDoList>>() {});
        int options = 0;
        while (options != 6) {
            System.out.println("Please choose an option:");
            System.out.println("(1) Add a Task");
            System.out.println("(2) Remove a Task");
            System.out.println("(3) Update a Task");
            System.out.println("(4) List all Tasks");
            System.out.println("(5) List all tasks of certain priority");
            System.out.println("(6) Exit");
            options = input.nextInt();
            input.nextLine();


            if (options == 1) {
                addTask((ArrayList<String>) taskList);
            } else if (options == 2) {
                removeTask((ArrayList<String>) taskList);
            } else if (options == 3) {
                updateTask((ArrayList<String>) taskList);
            } else if (options == 4) {
                listTask((ArrayList<String>) taskList);
            } else if (options == 5) {
                listAllTasks((List<ToDoList>) task);
            }
            else if(options == 6){
                dataChart((ArrayList<String>) taskList);
            }
            else if (options == 7) {
                map.writeValue(new File("data.json"),task);
                System.exit(0);
            } else {
                System.out.println("Invalid option. Please try again.");
            }


        }


    }

    static String addTask(ArrayList<String> a) {

        System.out.println("What task should I add?");
        String title = input.nextLine();
        System.out.println("Give me a description of the task");
        String description = input.nextLine();
        try {
            System.out.println("What is the priority of the task 0-5?");
            System.out.println("5 is high priority. 0 is low priority");
            int prio = input.nextInt();
            input.nextLine();
            ToDoList b = new ToDoList(title, description, prio);
            task.add(b);
        } catch (Exception e) {
            System.out.println("Please use int");
        }
        taskList.add(title);
        System.out.println(taskList);
        return title;

    }

    static void updateTask(ArrayList<String> a) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(taskList);
        System.out.println("Which task do you wish to update?");
        String taskToUpdate = scanner.nextLine();
        int index = taskList.indexOf(taskToUpdate);
        if (index != -1) {
            System.out.println("Enter a new description for the task:");
            String newTaskDescription = scanner.nextLine();
            System.out.println("Enter description for the task");
            taskList.set(index, newTaskDescription);
            System.out.println(taskList);
        } else {
            System.out.println("Task not found. Please try again.");


        }
    }

    static void listTask(ArrayList<String> a) {
        Collections.sort(taskList);
        for (int i = 0; i < taskList.size(); i++) {
            System.out.println(taskList);
        }
    }

    static void removeTask(ArrayList<String> a) {
        System.out.println("Which item should I remove?");
        String remove = input.nextLine();
        taskList.remove(remove);
        System.out.println(taskList);
    }

    static void listAllTasks(List<ToDoList> b) {
        try {
            System.out.println("What priority would you like to list?");
            int prio = input.nextInt();
            if (prio > 0 && prio < 6) {
                boolean found = false;
                for (ToDoList a : task) {
                    System.out.println("Checking for: " + a.getPriority());
                    if (a.getPriority() == prio) {
                        System.out.println(a);
                        found = true;
                    }
                }
                if (!found) {
                    System.out.println("No tasks found with priority: " + prio);
                }
                if (prio >= 0 && prio <= 5){

                }
                else{
                    System.out.println("Please enter a number 0 through 5");
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("Please use an integer.");
            input.nextLine();
        }
    }
    static void dataChart(ArrayList<String>a) throws IOException {
        System.out.println(task);

        
    }
}