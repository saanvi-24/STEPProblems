
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

abstract class Question {
    String questionText;
    String correctAnswer;
    String studentAnswer;
    double points;

    Question(String questionText, String correctAnswer,
             String studentAnswer, double points) {
        this.questionText = questionText;
        this.correctAnswer = correctAnswer;
        this.studentAnswer = studentAnswer;
        this.points = points;
    }

    abstract double calculateScore();

    abstract String getType();
}

class MCQ extends Question {
    MCQ(String q, String correct, String student, double points) {
        super(q, correct, student, points);
    }

    double calculateScore() {
        return studentAnswer.equalsIgnoreCase(correctAnswer)
            ? points : 0;
    }

    String getType() {
        return "MCQ";
    }
}

class TrueFalse extends Question {
    TrueFalse(String q, String correct, String student, double points) {
        super(q, correct, student, points);
    }

    double calculateScore() {
        return studentAnswer.equalsIgnoreCase(correctAnswer)
            ? points : 0;
    }

    String getType() {
        return "TF";
    }
}

class Essay extends Question {
    Essay(String q, String correct, String student, double points) {
        super(q, correct, student, points);
    }

    double calculateScore() {
        String[] keywords = correctAnswer.split(",");
        int matches = 0;

        for (String keyword : keywords) {
            if (studentAnswer.toLowerCase().contains(
                    keyword.trim().toLowerCase())) {
                matches++;
            }
        }

        if (matches >= 2) {
            return points * 0.75;
        } else if (matches == 1) {
            return points * 0.50;
        } else {
            return 0;
        }
    }

    String getType() {
        return "ESSAY";
    }
}

public class ExaminationGrader {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        Question[] questions = new Question[n];

        Pattern pattern = Pattern.compile("\"([^\"]*)\"|(\\S+)");

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            Matcher matcher = pattern.matcher(line);

            String[] data = new String[5];
            int count = 0;

            while (matcher.find()) {
                if (matcher.group(1) != null) {
                    data[count++] = matcher.group(1);
                } else {
                    data[count++] = matcher.group(2);
                }
            }

            String type = data[0];
            String questionText = data[1];
            String correctAnswer = data[2];
            String studentAnswer = data[3];
            double points = Double.parseDouble(data[4]);

            if (type.equals("MCQ")) {
                questions[i] = new MCQ(
                    questionText, correctAnswer, studentAnswer, points
                );
            } else if (type.equals("TF")) {
                questions[i] = new TrueFalse(
                    questionText, correctAnswer, studentAnswer, points
                );
            } else {
                questions[i] = new Essay(
                    questionText, correctAnswer, studentAnswer, points
                );
            }
        }

        double total = 0;

        for (Question q : questions) {
            double score = q.calculateScore();
            System.out.printf("%s: %.2f%n", q.getType(), score);
            total += score;
        }

        System.out.printf("Total Score: %.2f%n", total);
        sc.close();
    }
}
