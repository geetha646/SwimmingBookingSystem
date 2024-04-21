import java.util.ArrayList;
import java.util.HashMap;

public class Student {
    private String fullName;
    private String gender;
    private int age;
    private String emergencyContactNumber;
    private int gradeLevel;
    private ArrayList<Integer> lessonBookings;
    private ArrayList<Integer> bookingIdentifiers;
    private HashMap<Integer, String> bookingStatusMap;

    public Student(String fullName, String gender, int age, String emergencyContactNumber, int gradeLevel) {
        this.fullName = fullName;
        this.gender = gender;
        this.age = age;
        this.emergencyContactNumber = emergencyContactNumber;
        this.gradeLevel = gradeLevel;
        this.lessonBookings = new ArrayList<>();
        this.bookingIdentifiers = new ArrayList<>();
        this.bookingStatusMap = new HashMap<>();
    }

    public String getFullName() {
        return fullName;
    }

    public String getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public String getEmergencyContactNumber() {
        return emergencyContactNumber;
    }

    public int getGradeLevel() {
        return gradeLevel;
    }

    public void setGradeLevel(int newGradeLevel) {
        this.gradeLevel = newGradeLevel;
    }

    public ArrayList<Integer> getLessonBookings() {
        return lessonBookings;
    }

    public ArrayList<Integer> getBookingIdentifiers() {
        return bookingIdentifiers;
    }

    public void bookLesson(int lessonId) {
        int bookingIdentifier = generateBookingIdentifier();
        lessonBookings.add(lessonId);
        bookingIdentifiers.add(bookingIdentifier);
        bookingStatusMap.put(lessonId, "booked");
    }

    public void setBookingStatus(int lessonId, String status) {
        bookingStatusMap.put(lessonId, status);
    }

    public String getBookingStatus(int lessonId) {
        return bookingStatusMap.getOrDefault(lessonId, "");
    }

    public void cancelLesson(int lessonId) {
        int index = lessonBookings.indexOf(lessonId);
        if (index != -1) {
            int bookingIdentifier = bookingIdentifiers.get(index);
            bookingStatusMap.put(lessonId, "cancelled");
        }
    }

    public int getBookingIdentifier(int lessonId) {
        int index = lessonBookings.indexOf(lessonId);
        return index != -1 ? bookingIdentifiers.get(index) : -1;
    }

    public int getLessonId(int bookingIdentifier) {
        int index = bookingIdentifiers.indexOf(bookingIdentifier);
        return index != -1 ? lessonBookings.get(index) : -1;
    }

    public boolean hasBookedLesson(int lessonId) {
        return lessonBookings.contains(lessonId);
    }

    private int generateBookingIdentifier() {
        return (int) (Math.random() * 1000) + 1000;
    }

    public void updateLessonId(int bookingIdentifier, int newLessonId) {
        int index = bookingIdentifiers.indexOf(bookingIdentifier);
        if (index != -1) {
            lessonBookings.set(index, newLessonId);
            bookingStatusMap.put(newLessonId, "booked");
        }
    }
}
