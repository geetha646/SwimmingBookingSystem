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

    // Function to display the timetable
    public void displayTimetable() {
        System.out.println("Timetable for 4 Weeks:");

        int lessonsPerWeek = swimLessons.size() / 4;
        for (int i = 0; i < 4; i++) {
            int startLessonIndex = i * lessonsPerWeek;
            int endLessonIndex = Math.min((i + 1) * lessonsPerWeek, swimLessons.size());

            System.out.println("Week " + (i + 1) + ":");
            for (int j = startLessonIndex; j < endLessonIndex; j++) {
                SwimLesson lesson = swimLessons.get(j);
                System.out.println("id:" + lesson.getLessonIdentifier() + ", Week: " + lesson.getWeekNumber() + ", Day: " + lesson.getDayOfWeek() + ", Time: " + lesson.getTimeSlot() + ", Grade: " + lesson.getGradeLevel() + ", Instructor: " + lesson.getInstructor());
            }
            System.out.println();
        }
    }

    private void displayTimetableByDay(String targetDay) {
        for (SwimLesson lesson : swimLessons) {
            if (lesson.getDayOfWeek().equalsIgnoreCase(targetDay)) {
                displayLessonDetails(lesson);
            }
        }
    }

    private void displayTimetableByGradeLevel(int targetGradeLevel) {
        for (SwimLesson lesson : swimLessons) {
            if (lesson.getGradeLevel() == targetGradeLevel) {
                displayLessonDetails(lesson);
            }
        }
    }

    private void displayTimetableByCoach(String targetCoachName) {
        for (SwimLesson lesson : swimLessons) {
            if (lesson.getInstructor().equalsIgnoreCase(targetCoachName)) {
                displayLessonDetails(lesson);
            }
        }
    }

    private void displayLessonDetails(SwimLesson lesson) {
        System.out.println("ID: " + lesson.getLessonIdentifier() + ", Week: " + lesson.getWeekNumber() + ", Day: " + lesson.getDayOfWeek() + ", Time: " + lesson.getTimeSlot() + ", Grade: " + lesson.getGradeLevel() + ", Instructor: " + lesson.getInstructor() + ", Enrolled students: " + lesson.getEnrolledstudents().size() + "/4");
    }


    // Function to book a swimming lesson
    public void bookLesson() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please select the way to view the timetable:");
        System.out.println("1. View by day");
        System.out.println("2. View by grade level");
        System.out.println("3. View by coach's name");
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                // View by day
                System.out.println("Enter the day (e.g., Monday, Wednesday):");
                String day = scanner.nextLine();
                displayTimetableByDay(day);
                break;
            case 2:
                // View by grade level
                System.out.println("Enter the grade level (0-5):");
                int gradeLevel = scanner.nextInt();
                displayTimetableByGradeLevel(gradeLevel);
                break;
            case 3:
                // View by coach's name
                System.out.println("Enter the coach's name:");
                String coachName = scanner.nextLine();
                displayTimetableByCoach(coachName);
                break;
            default:
                System.out.println("Invalid choice.");
                return;
        }

        System.out.println("Enter the lesson ID to book:");
        int lessonId = scanner.nextInt();
        scanner.nextLine();

        // Find the lesson
        SwimLesson lesson = null;
        for (SwimLesson l : swimLessons) {
            if (l.getLessonIdentifier() == lessonId) {
                lesson = l;
                break;
            }
        }

        if (lesson == null) {
            System.out.println("Lesson not found.");
            return;
        }

        System.out.println("Enter your name:");
        String studentName = scanner.nextLine();

        // Find the student
        Student student = null;
        for (Student l : students) {
            if (l.getFullName().equalsIgnoreCase(studentName)) {
                student = l;
                break;
            }
        }

        if (student == null) {
            System.out.println("student not found.");
            return;
        }

        if (student.hasBookedLesson(lessonId)) {
            System.out.println("You have already booked this lesson.");
            return;
        }

        if (!canBookLesson(lesson, student)) {
            System.out.println("Cannot book this lesson. Capacity exceeded or not allowed grade level.");
            return;
        }

        lesson.addstudent(studentName);
        student.bookLesson(lessonId);
        student.setBookingStatus(lessonId, "booked");
        System.out.println("Lesson booked successfully. Your booking ID is: " + student.getBookingIdentifier(lessonId));
    }

    private boolean canBookLesson(SwimLesson lesson, Student student) {
        if (lesson.getEnrolledstudentsCount() >= 4) {
            return false;
        }

        if (Math.abs(lesson.getGradeLevel() - student.getGradeLevel()) > 1) {
            return false;
        }

        return true;
    }

    // Function to change/cancel a booking
    public void changeOrCancelBooking() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the name of student:");
        String studentName = scanner.nextLine();

        // Find the student
        Student student = null;
        for (Student l : students) {
            if (l.getFullName().equalsIgnoreCase(studentName)) {
                student = l;
                break;
            }
        }

        if (student == null) {
            System.out.println("student not found.");
            return;
        }
        // Check if the student has any bookings
        if (student.getLessonBookings().isEmpty()) {
            System.out.println("No bookings found for " + studentName);
            return;
        }

        int bookingsCount = 0;
        // Inside the changeOrCancelBooking method
        System.out.println("Bookings for " + studentName + ":");
        for (int i = 0; i < student.getLessonBookings().size(); i++) {
            int lessonId = student.getLessonBookings().get(i);
            int bookingId = student.getBookingIdentifiers().get(i);
            String bookingStatus = student.getBookingStatus(lessonId);
            if (bookingStatus.equalsIgnoreCase("booked")) {
                bookingsCount++;
                System.out.println("Booking ID: " + bookingId + ", Lesson ID: " + lessonId);
            }
        }

        if (bookingsCount <= 0) {
            System.out.println("No bookings found");
            return;
        }

        System.out.println("Enter the booking ID to change/cancel booking:");
        int bookingId = scanner.nextInt();
        scanner.nextLine();

        // Find the index of booking ID
        int index = student.getBookingIdentifiers().indexOf(bookingId);
        if (index == -1) {
            System.out.println("Booking ID not found.");
            return;
        }

        // Get the lesson ID associated with the booking ID
        int lessonId = student.getLessonBookings().get(index);

        // Find the lesson
        SwimLesson lesson = null;
        for (SwimLesson l : swimLessons) {
            if (l.getLessonIdentifier() == lessonId) {
                lesson = l;
                break;
            }
        }

        if (lesson == null) {
            System.out.println("Lesson not found.");
            return;
        }

        System.out.println("Do you want to change (X) or cancel (C) the booking?");
        String action = scanner.nextLine().toUpperCase();

        switch (action) {
            case "C":
                lesson.removestudent(studentName);
                student.cancelLesson(lessonId);
                student.setBookingStatus(lessonId, "cancelled");
                System.out.println("Booking cancelled successfully.");
                break;
            case "X":
                // Display available lessons
                System.out.println("Available lessons:");
                displayTimetable();

                // Prompt for new lesson ID
                System.out.println("Enter the ID of the new lesson:");
                int newLessonId = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                // Find the new lesson
                SwimLesson newLesson = null;
                for (SwimLesson l : swimLessons) {
                    if (l.getLessonIdentifier() == newLessonId) {
                        newLesson = l;
                        break;
                    }
                }

                if (newLesson == null) {
                    System.out.println("New lesson not found.");
                    return;
                }

                // Check if student can book this lesson
                if (!canBookLesson(newLesson, student)) {
                    System.out.println("Cannot book this lesson. Capacity exceeded or not allowed grade level.");
                    return;
                }

                // Remove student from current lesson and add to new lesson
                lesson.removestudent(studentName);
                newLesson.addstudent(studentName);
                // Update the lesson ID associated with the booking ID
                student.updateLessonId(bookingId, newLessonId);

                System.out.println("Booking changed successfully.");
                break;
            default:
                System.out.println("Invalid action.");
                break;
        }
    }

    // Function to attend a swimming lesson
    public void attendLesson() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the name of the student:");
        String studentName = scanner.nextLine();

        // Find the student
        Student student = findStudentByName(studentName);

        if (student == null) {
            System.out.println("student not found.");
            return;
        }

        // Check if the student has any bookings
        if (student.getLessonBookings().isEmpty()) {
            System.out.println("No bookings found for " + studentName);
            return;
        }

        System.out.println("Bookings for " + studentName + ":");
        for (int i = 0; i < student.getLessonBookings().size(); i++) {
            int lessonId = student.getLessonBookings().get(i);
            int bookingId = student.getBookingIdentifiers().get(i);
            String bookingStatus = student.getBookingStatus(lessonId);
            if (bookingStatus.equalsIgnoreCase("booked")) {
                System.out.println("Booking ID: " + bookingId + ", Lesson ID: " + lessonId);
            }
        }

        System.out.println("Enter the booking ID to attend:");
        int bookingId = scanner.nextInt();
        scanner.nextLine();

        // Get the lesson ID associated with the booking ID
        int lessonId = student.getLessonId(bookingId);

        if (lessonId == -1) {
            System.out.println("Invalid booking ID.");
            return;
        }

        // Find the lesson
        SwimLesson lesson = findLessonById(lessonId);

        if (lesson == null) {
            System.out.println("Lesson not found.");
            return;
        }

        // Check if student has already attended this lesson
        if (student.getBookingStatus(bookingId).equalsIgnoreCase("attended")) {
            System.out.println("You have already attended this lesson.");
            return;
        }

        // Attend lesson
        lesson.removestudent(studentName);
        student.cancelLesson(lessonId);
        student.setBookingStatus(lessonId, "attended");
        System.out.println("Lesson attended successfully.");

        // Check if student's current grade level needs to be updated
        if (lesson.getGradeLevel() > student.getGradeLevel()) {
            student.setGradeLevel(lesson.getGradeLevel());
            System.out.println("Congratulations! Your grade level has been updated to " + lesson.getGradeLevel());
        }

        // Provide instructor review
        System.out.println("Please provide a review for the instructor (optional):");
        String instructorReview = scanner.nextLine();

        System.out.println("Please provide a rating for the instructor (1-5):");
        int instructorRating = scanner.nextInt();
        scanner.nextLine();

        if (instructorRating < 1 || instructorRating > 5) {
            System.out.println("Invalid rating. Rating must be between 1 and 5.");
            return;
        }

        // Record instructor review and rating
        for (SwimInstructor instructor : instructors) {
            if (instructor.getFullName().equalsIgnoreCase(lesson.getInstructor())) {
                instructor.addSwimReview(new SwimReview(instructorReview, instructorRating));
                System.out.println("Instructor review and rating recorded successfully.");
                break;
            }
        }
    }

    // Helper method to find a student by name
    private Student findStudentByName(String name) {
        for (Student student : students) {
            if (student.getFullName().equalsIgnoreCase(name)) {
                return student;
            }
        }
        return null;
    }

    // Helper method to find a lesson by ID
    private SwimLesson findLessonById(int lessonId) {
        for (SwimLesson lesson : swimLessons) {
            if (lesson.getLessonIdentifier() == lessonId) {
                return lesson;
            }
        }
        return null;
    }

    public void generateMonthlyStudentReport(int month) {
        System.out.println("Monthly student Report for Month " + month + ":");

        for (Student student : students) {
            System.out.println("Student: " + student.getFullName());
            int bookedCount = 0;
            int cancelledCount = 0;
            int attendedCount = 0;

            // Count booked, cancelled, and attended lessons
            for (SwimLesson lesson : swimLessons) {
                if (student.hasBookedLesson(lesson.getLessonIdentifier())) {
                    String bookingStatus = student.getBookingStatus(lesson.getLessonIdentifier());
                    if (bookingStatus.equalsIgnoreCase("booked")) {
                        bookedCount++;
                    } else if (bookingStatus.equalsIgnoreCase("cancelled")) {
                        cancelledCount++;
                    } else if (bookingStatus.equalsIgnoreCase("attended")) {
                        attendedCount++;
                    }
                }
            }

            System.out.println("Booked: " + bookedCount);
            System.out.println("Cancelled: " + cancelledCount);
            System.out.println("Attended: " + attendedCount);
            System.out.println();
        }
    }


    public void generateMonthlyInstructorReport(int month) {
        System.out.println("Monthly Coach Report for Month " + month + ":");

        for (SwimInstructor instructor : instructors) {
            System.out.println("Instructor: " + instructor.getFullName());
            List<SwimReview> swimReviews = instructor.getSwimReviews();
            if (!swimReviews.isEmpty()) {
                double totalRating = 0.0;
                int count = 0;
                for (SwimReview review : swimReviews) {
                    totalRating += review.getScore();
                    count++;
                }
                double averageRating = totalRating / count;
                System.out.println("Average Rating: " + averageRating);
            } else {
                System.out.println("No ratings available.");
            }
            System.out.println();
        }
    }


    public void registerNewStudent() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter student's name:");
        String name = scanner.nextLine();
        System.out.println("Enter student's gender:");
        String gender = scanner.nextLine();
        System.out.println("Enter student's age:");
        int age = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.println("Enter student's emergency contact:");
        String emergencyContact = scanner.nextLine();
        System.out.println("Enter student's current grade level:");
        int gradeLevel = scanner.nextInt();
        scanner.nextLine();

        if (age < 5 || age > 10) {
            System.out.println("Error: Age must be between 5 and 10.");
            return;
        }

        if (gradeLevel < 1 || gradeLevel > 6) {
            System.out.println("Error: Grade level must be between 1 and 6.");
            return;
        }

        Student newstudent = new Student(name, gender, age, emergencyContact, gradeLevel);
        students.add(newstudent);
        System.out.println("New student registered successfully.");
    }


    private int generateBookingIdentifier() {
        return (int) (Math.random() * 1000) + 1000;
    }

    public static void main(String[] args) {
        SwimmingBookingSystem system = new SwimmingBookingSystem();
        int choice = 1;
        int month;
        Scanner scanner = new Scanner(System.in);
        do {
            // Menu
            System.out.println("*********************************************************************");
            System.out.println("Swimming Booking System");
            System.out.println("*********************************************************************");
            System.out.println("1. Display timetable");
            System.out.println("2. Book a lesson");
            System.out.println("3. Change or Cancel Booking");
            System.out.println("4. Attend lesson");
            System.out.println("5. Generate Monthly student Report");
            System.out.println("6. Generate Monthly Coach Report");
            System.out.println("7. Register a new student");
            System.out.println("8. Exit");
            System.out.println("Please select an option");

            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            // Perform actions based on user choice
            switch (choice) {
                case 1:
                    system.displayTimetable();
                    break;
                case 2:
                    system.bookLesson();
                    break;
                case 3:
                    system.changeOrCancelBooking();
                    break;
                case 4:
                    system.attendLesson();
                    break;
                case 5:
                    System.out.println("Please enter the month (e.g., 1 for January, 2 for February):");
                    month = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    system.generateMonthlyStudentReport(month);
                    break;
                case 6:
                    System.out.println("Please enter the month (e.g., 1 for January, 2 for February):");
                    month = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    system.generateMonthlyInstructorReport(month);
                    break;
                case 7:
                    system.registerNewStudent();
                    break;
                case 8:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        } while (choice != 0);
        scanner.close();
    }

}
