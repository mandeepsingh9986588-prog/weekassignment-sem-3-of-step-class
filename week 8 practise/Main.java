import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

abstract class Question {
    protected String text;
    protected String correctAnswer;
    protected String studentAnswer;
    protected int points;

    public Question(String text, String correctAnswer, String studentAnswer, int points) {
        this.text = text;
        this.correctAnswer = correctAnswer;
        this.studentAnswer = studentAnswer;
        this.points = points;
    }

    public abstract double grade();
    public abstract String getTypeName();
}

class MCQQuestion extends Question {
    public MCQQuestion(String text, String correctAnswer, String studentAnswer, int points) {
        super(text, correctAnswer, studentAnswer, points);
    }

    @Override
    public double grade() {
        return studentAnswer.trim().equalsIgnoreCase(correctAnswer.trim()) ? points : 0.0;
    }

    @Override public String getTypeName() { return "MCQ"; }
}

class TFQuestion extends Question {
    public TFQuestion(String text, String correctAnswer, String studentAnswer, int points) {
        super(text, correctAnswer, studentAnswer, points);
    }

    @Override
    public double grade() {
        return studentAnswer.trim().equalsIgnoreCase(correctAnswer.trim()) ? points : 0.0;
    }

    @Override public String getTypeName() { return "TF"; }
}

class EssayQuestion extends Question {
    public EssayQuestion(String text, String correctAnswer, String studentAnswer, int points) {
        super(text, correctAnswer, studentAnswer, points);
    }

    @Override
    public double grade() {
        String[] keywords = correctAnswer.split(",");
        int matchCount = 0;
        for (String kw : keywords) {
            String trimmedKw = kw.trim();
            if (studentAnswer.toLowerCase().contains(trimmedKw.toLowerCase())) {
                matchCount++;
            }
        }

        if (matchCount >= 2) {
            return points * 0.75;
        } else if (matchCount == 1) {
            return points * 0.50;
        }
        return 0.0;
    }

    @Override public String getTypeName() { return "ESSAY"; }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        scanner.nextLine();

        List<Question> questions = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            int firstSpace = line.indexOf(' ');
            String type = line.substring(0, firstSpace);
            String remainder = line.substring(firstSpace + 1);

            List<String> tokens = parseTokens(remainder);
            String qText = tokens.get(0);
            String correctAns = tokens.get(1);
            String studentAns = tokens.get(2);
            int pts = Integer.parseInt(tokens.get(3));

            if (type.equals("MCQ")) {
                questions.add(new MCQQuestion(qText, correctAns, studentAns, pts));
            } else if (type.equals("TF")) {
                questions.add(new TFQuestion(qText, correctAns, studentAns, pts));
            } else if (type.equals("ESSAY")) {
                questions.add(new EssayQuestion(qText, correctAns, studentAns, pts));
            }
        }
        scanner.close();

        double totalScore = 0.0;
        for (Question q : questions) {
            double score = q.grade();
            totalScore += score;
            System.out.printf("%s: %.2f\n", q.getTypeName(), score);
        }
        System.out.printf("Total Score: %.2f\n", totalScore);
    }

    private static List<String> parseTokens(String input) {
        List<String> tokens = new ArrayList<>();
        boolean inQuotes = false;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '"') {
                inQuotes = !inQuotes;
            } else if (c == ' ' && !inQuotes) {
                tokens.add(sb.toString().replace("\"", ""));
                sb = new StringBuilder();
            } else {
                sb.append(c);
            }
        }
        tokens.add(sb.toString().replace("\"", ""));
        return tokens;
    }
}