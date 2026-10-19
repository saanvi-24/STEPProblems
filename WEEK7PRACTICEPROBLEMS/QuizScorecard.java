
class Scorecard {
    private final boolean[] answers;
    private int count;

    Scorecard(int totalQuestions) {
        answers = new boolean[totalQuestions];
        count = 0;
    }

    public void recordAnswer(boolean correct) {
        if (count < answers.length) {
            answers[count] = correct;
            count++;
        } else {
            System.out.println("All answers already recorded");
        }
    }

    public int getScore() {
        int score = 0;

        for (int i = 0; i < count; i++) {
            if (answers[i] == true) {
                score++;
            }
        }

        return score;
    }
}

public class QuizScorecard {
    public static void main(String[] args) {
        Scorecard sc = new Scorecard(4);

        sc.recordAnswer(true);
        sc.recordAnswer(true);
        sc.recordAnswer(false);
        sc.recordAnswer(true);

        System.out.println("Final score: " + sc.getScore());
    }
}
