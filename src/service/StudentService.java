package service;

import model.Student;

import java.util.ArrayList;
import java.util.Iterator;

public class StudentService {
    private final ArrayList<Student> students = new ArrayList<>();

    public void seed() {
        students.clear();
        students.add(new Student(1, "Aibek", 3.2));
        students.add(new Student(2, "Amina", 1.8));
        students.add(new Student(3, "Bektur", 2.7));
        students.add(new Student(4, "Dinara", 3.9));
        students.add(new Student(5, "Ulan", 2.0));
        students.add(new Student(6, "Eliza", 1.6));
    }

    public void removeStudentsWithLowGpa(double minGpa) {
        students.removeIf(s -> s.getGpa() < minGpa);
    }

    public Student findTopStudentByGpa() {
        if (students.isEmpty()) return null;

        Student best = students.get(0);
        for (Student s : students) {
            if (s.getGpa() > best.getGpa()) {
                best = s;
            }
        }
        return best;
    }

    public void insertStudentAtIndex2(Student newStudent) {
        int index = 2;
        if (index < 0) index = 0;
        if (index > students.size()) index = students.size();
        students.add(index, newStudent);
    }

    public void printAllStudentsWithIterator() {
        System.out.println("All students (Iterator):");
        Iterator<Student> it = students.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}