import java.util.ArrayList;
import java.util.Scanner;

public class StudentGradeTracker {

    // Student class to store name and grades
    static class Student {
        String name;
        ArrayList<Integer> grades;

        Student(String name) {
            this.name = name;
            this.grades = new ArrayList<>();
        }

        double getAverage() {
            if (grades.isEmpty()) return 0;
            int sum = 0;
            for (int g : grades) sum += g;
            return (double) sum / grades.size();
        }

        int getHighest() {
            if (grades.isEmpty()) return 0;
            int high = grades.get(0);
            for (int g : grades) if (g > high) high = g;
            return high;
        }

        int getLowest() {
            if (grades.isEmpty()) return 0;
            int low = grades.get(0);
            for (int g : grades) if (g < low) low = g;
            return low;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        sc.nextLine(); // consume newline

        for (int i = 0; i < n; i++) {
            System.out.print("\nEnter student name: ");
            String name = sc.nextLine();
            Student s = new Student(name);

            System.out.print("Enter number of grades for " + name + ": ");
            int g = sc.nextInt();

            for (int j = 0; j < g; j++) {
                System.out.print("  Enter grade #" + (j + 1) + ": ");
                int grade = sc.nextInt();
                s.grades.add(grade);
            }
            sc.nextLine(); // consume newline
            students.add(s);
        }

        // Display summary report
        System.out.println("\n===== STUDENT GRADE SUMMARY REPORT =====");
        for (Student s : students) {
            System.out.println("\nName: " + s.name);
            System.out.println("Grades: " + s.grades);
            System.out.printf("Average: %.2f\n", s.getAverage());
            System.out.println("Highest Grade: " + s.getHighest());
            System.out.println("Lowest Grade: " + s.getLowest());
        }

        sc.close();
    }
}