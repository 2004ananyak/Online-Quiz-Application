package model;

public class Question {
    private int id;
    private int quizId;
    private String questionText;
    private String option_a;
    private String option_b;
    private String option_c;
    private String option_d;
    private String correct_option;

    public Question() {}

    public Question(int id, int quizId, String questionText,
                    String option_a, String option_b, String option_c, String option_d,
                    String correct_option) {
        this.id = id;
        this.quizId = quizId;
        this.questionText = questionText;
        this.option_a = option_a;
        this.option_b = option_b;
        this.option_c = option_c;
        this.option_d = option_d;
        this.correct_option = correct_option;
    }

    public int getId() {
        return id;
    }

    public int getQuizId() {
        return quizId;
    }

    public String getQuestionText() {
        return questionText;
    }

    public String getOption_a() {
        return option_a;
    }

    public String getOption_b() {
        return option_b;
    }

    public String getOption_c() {
        return option_c;
    }

    public String getOption_d() {
        return option_d;
    }

    public String getCorrect_option() {
        return correct_option;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setQuizId(int quizId) {
        this.quizId = quizId;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public void setOption_a(String option_a) {
        this.option_a = option_a;
    }

    public void setOption_b(String option_b) {
        this.option_b = option_b;
    }

    public void setOption_c(String option_c) {
        this.option_c = option_c;
    }

    public void setOption_d(String option_d) {
        this.option_d = option_d;
    }

    public void setCorrect_option(String correct_option) {
        this.correct_option = correct_option;
    }
}
