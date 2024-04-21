import java.util.ArrayList;
import java.util.List;

public class SwimLesson {
    private String dayOfWeek;
    private String timeSlot;
    private int gradeLevel;
    private String instructor;
    private List<String> enrolledstudents;
    private boolean isCancelled;
    private int enrolledstudentsCount; // Number of students booked for the lesson
    private int lessonIdentifier;
    private int weekNumber; // Week number

    public SwimLesson(int lessonIdentifier, String dayOfWeek, String timeSlot, int weekNumber, int gradeLevel, String instructor) {
        this.dayOfWeek = dayOfWeek;
        this.timeSlot = timeSlot;
        this.weekNumber = weekNumber;
        this.gradeLevel = gradeLevel;
        this.instructor = instructor;
        this.enrolledstudents = new ArrayList<>();
        this.isCancelled = false;
        this.enrolledstudentsCount = 0;
        this.lessonIdentifier = lessonIdentifier;
    }

    public int getLessonIdentifier() {
        return lessonIdentifier;
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public String getTimeSlot() {
        return timeSlot;
    }

    public int getWeekNumber() {
        return weekNumber;
    }

    public int getGradeLevel() {
        return gradeLevel;
    }

    public String getInstructor() {
        return instructor;
    }

    public List<String> getEnrolledstudents() {
        return enrolledstudents;
    }

    public boolean isCancelled() {
        return isCancelled;
    }

    public void cancelLesson() {
        isCancelled = true;
    }

    public int getEnrolledstudentsCount() {
        return enrolledstudentsCount;
    }

    public void addstudent(String studentName) {
        enrolledstudents.add(studentName);
        enrolledstudentsCount++;
    }

    public void removestudent(String studentName) {
        enrolledstudents.remove(studentName);
        enrolledstudentsCount--;
    }
}
