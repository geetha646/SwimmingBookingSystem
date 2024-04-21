import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SwimmingBookingSystem {
    private List<SwimLesson> swimLessons;
    private List<Student> students;
    private List<SwimInstructor> instructors;

    public SwimmingBookingSystem() {
        this.swimLessons = new ArrayList<>();
        this.students = new ArrayList<>();
        this.instructors = new ArrayList<>();
        initializeData();
        generateTimetable();
    }

    private void initializeData() {
        instructors.add(new SwimInstructor("Vidya"));
        instructors.add(new SwimInstructor("Ravi"));
        instructors.add(new SwimInstructor("Lakshmi"));

        students.add(new Student("Ananya", "Female", 7, "123-456-7890", 2));
        students.add(new Student("Bhaskar", "Male", 5, "987-654-3210", 0));
        students.add(new Student("Chaitanya", "Male", 6, "456-789-0123", 1));
        students.add(new Student("Deepika", "Female", 9, "321-654-0987", 3));
        students.add(new Student("Esha", "Female", 8, "789-012-3456", 2));
        students.add(new Student("Farhan", "Male", 4, "654-987-2103", 0));
        students.add(new Student("Geeta", "Female", 7, "210-543-8769", 2));
        students.add(new Student("Harish", "Male", 5, "876-321-0987", 1));
        students.add(new Student("Indira", "Female", 6, "543-876-2109", 1));
        students.add(new Student("Jagan", "Male", 7, "098-765-4321", 2));
        students.add(new Student("Kavita", "Female", 8, "321-098-7654", 3));
        students.add(new Student("Lalit", "Male", 9, "654-321-9870", 4));
        students.add(new Student("Meera", "Female", 5, "432-109-8765", 0));
        students.add(new Student("Naveen", "Male", 6, "109-876-5432", 1));
        students.add(new Student("Ojaswi", "Female", 7, "876-543-2109", 2));
        students.add(new Student("Pranav", "Male", 8, "543-210-9876", 3));
        students.add(new Student("Quintessence", "Female", 4, "210-987-6543", 0));

    }

    private void generateTimetable() {
        int lessonIdCounter = 1;
        for (int week = 1; week <= 4; week++) {
            // Monday
            addLesson(lessonIdCounter++, "Monday", "4-5pm", week, getRandomGrade(), "Vidya");
            addLesson(lessonIdCounter++, "Monday", "5-6pm", week, getRandomGrade(), "Ravi");
            addLesson(lessonIdCounter++, "Monday", "6-7pm", week, getRandomGrade(), "Vidya");

            // Wednesday
            addLesson(lessonIdCounter++, "Wednesday", "4-5pm", week, getRandomGrade(), "Ravi");
            addLesson(lessonIdCounter++, "Wednesday", "5-6pm", week, getRandomGrade(), "Vidya");
            addLesson(lessonIdCounter++, "Wednesday", "6-7pm", week, getRandomGrade(), "Ravi");

            // Friday
            addLesson(lessonIdCounter++, "Friday", "4-5pm", week, getRandomGrade(), "Vidya");
            addLesson(lessonIdCounter++, "Friday", "5-6pm", week, getRandomGrade(), "Ravi");
            addLesson(lessonIdCounter++, "Friday", "6-7pm", week, getRandomGrade(), "Vidya");

            // Saturday
            addLesson(lessonIdCounter++, "Saturday", "2-3pm", week, getRandomGrade(), "Vidya");
            addLesson(lessonIdCounter++, "Saturday", "3-4pm", week, getRandomGrade(), "Ravi");

        }
    }

    private int getRandomGrade() {
        // Simulate generating a random grade
        return (int) (Math.random() * 5) + 1;
    }

    public void addLesson(int lessonId, String day, String timeSlot, int week, int gradeLevel, String instructorName) {
        SwimLesson lesson = new SwimLesson(lessonId, day, timeSlot, week, gradeLevel, instructorName);
        swimLessons.add(lesson);
    }

}