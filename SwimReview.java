public class SwimReview {
    private String feedback;
    private int score;

    public SwimReview(String feedback, int score) {
        this.feedback = feedback;
        this.score = score;
    }

    public String getFeedback() {
        return feedback;
    }

    public int getScore() {
        return score;
    }
}
