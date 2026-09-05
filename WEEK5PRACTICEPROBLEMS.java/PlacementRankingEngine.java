import java.util.Arrays;

public class PlacementRankingEngine {

    static class Candidate implements Comparable<Candidate> {

        private String name;
        private double cgpa;
        private int codingScore;

        // Constructor
        public Candidate(String name, double cgpa, int codingScore) {
            this.name = name;
            this.cgpa = cgpa;
            this.codingScore = codingScore;
        }

        // CGPA-only eligibility
        static boolean isEligible(double cgpa) {
            return cgpa >= 7.0;
        }

        // CGPA + coding score eligibility
        static boolean isEligible(double cgpa, int codingScore) {
            return cgpa >= 6.5 && codingScore >= 60;
        }

        // Composite score
        private double getCompositeScore() {
            return (cgpa * 10) + codingScore;
        }

        // Compare candidates by composite score descending
        @Override
        public int compareTo(Candidate other) {

            return Double.compare(
                other.getCompositeScore(),
                this.getCompositeScore()
            );
        }

        public String getName() {
            return name;
        }

        public double getCompositeScoreValue() {
            return getCompositeScore();
        }
    }

    static String shortlistAndRank(Candidate[] candidates) {

        // First count eligible candidates
        int count = 0;

        for (Candidate candidate : candidates) {

            if (Candidate.isEligible(candidate.cgpa) ||
                Candidate.isEligible(candidate.cgpa, candidate.codingScore)) {

                count++;
            }
        }

        // Create shortlisted array
        Candidate[] shortlisted = new Candidate[count];

        int index = 0;

        for (Candidate candidate : candidates) {

            if (Candidate.isEligible(candidate.cgpa) ||
                Candidate.isEligible(candidate.cgpa, candidate.codingScore)) {

                shortlisted[index] = candidate;
                index++;
            }
        }

        // Sort using Comparable
        Arrays.sort(shortlisted);

        // Build output
        String result = "";

        for (int i = 0; i < shortlisted.length; i++) {

            result = result
                    + (i + 1)
                    + ". "
                    + shortlisted[i].getName()
                    + " ("
                    + shortlisted[i].getCompositeScoreValue()
                    + ")";

            if (i < shortlisted.length - 1) {
                result = result + " | ";
            }
        }

        return result;
    }

    public static void main(String[] args) {

        Candidate[] candidates = {

            new Candidate("Aisha", 8.2, 40),

            new Candidate("Rohit", 6.8, 65),

            new Candidate("Meena", 6.0, 90),

            new Candidate("Karan", 7.5, 20)
        };

        System.out.println(
            shortlistAndRank(candidates)
        );
    }
}