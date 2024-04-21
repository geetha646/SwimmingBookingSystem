import java.util.ArrayList;
import java.util.List;

public class SwimInstructor {
    private String fullName;
    private List<SwimReview> swimReviews;

    public SwimInstructor(String fullName) {
        this.fullName = fullName;
        this.swimReviews = new ArrayList<>();
    }

    public String getFullName() {
        return fullName;
    }

    public void addSwimReview(SwimReview swimReview) {
        swimReviews.add(swimReview);
    }

    public List<SwimReview> getSwimReviews() {
        return swimReviews;
    }

    public double calculateAverageScore() {
        if (swimReviews.isEmpty()) {
            return 0.0;
        }

        double totalScore = 0.0;
        for (SwimReview swimReview : swimReviews) {
            totalScore += swimReview.getScore();
        }
        return totalScore / swimReviews.size();
    }
}
