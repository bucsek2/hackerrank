package hu.bucsek2.java.data_structures.java_priority_queue;

import java.util.*;
/*
 * Create the Student and Priorities classes here.
 */

class Student {
    private final int id;
    private final String name;
    private final double cgpa;

    Student(int id, String name, double cgpa) {
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }

    double getCgpa() {
        return cgpa;
    }

    int getId() {
        return id;
    }

    String getName() {
        return name;
    }
}

class Priorities {
    List<Student> getStudents(List<String> events) {
        Comparator<Student> priority = Comparator.comparing(Student::getCgpa).reversed()
                .thenComparing(Student::getName)
                .thenComparing(Student::getId);

        PriorityQueue<Student> queue = new PriorityQueue<>(priority);

        for (String event : events) {
            String[] eventArray = event.split(" ");
            String eventType = eventArray[0];

            switch (eventType.toUpperCase()) {
                case "ENTER":
                    queue.offer(new Student(Integer.parseInt(eventArray[3]), eventArray[1], Double.parseDouble(eventArray[2])));
                    break;
                case "SERVED":
                    Student student = queue.poll();
            }
        }

        ArrayList<Student> result = new ArrayList<>();
        Student toServe = queue.poll();
        while (toServe != null) {
            result.add(toServe);
            toServe = queue.poll();
        }

        return result;
    }
}


public class Solution {
    private final static Scanner scan = new Scanner(System.in);
    private final static Priorities priorities = new Priorities();

    public static void main(String[] args) {
        int totalEvents = Integer.parseInt(scan.nextLine());
        List<String> events = new ArrayList<>();

        while (totalEvents-- != 0) {
            String event = scan.nextLine();
            events.add(event);
        }

        List<Student> students = priorities.getStudents(events);

        if (students.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            for (Student st : students) {
                System.out.println(st.getName());
            }
        }
    }
}