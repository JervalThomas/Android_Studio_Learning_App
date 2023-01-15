package com.example.assigmnment_2;

public class Question {

    String question;
    String qA;
    String qB;
    String qC;
    String qD;
    String ans;

    public Question(String question, String qA, String qB, String qC, String qD, String ans) {
        this.question = question;
        this.qA = qA;
        this.qB = qB;
        this.qC = qC;
        this.qD = qD;
        this.ans = ans;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getqA() {
        return qA;
    }

    public void setqA(String qA) {
        this.qA = qA;
    }

    public String getqB() {
        return qB;
    }

    public void setqB(String qB) {
        this.qB = qB;
    }

    public String getqC() {
        return qC;
    }

    public void setqC(String qC) {
        this.qC = qC;
    }

    public String getqD() {
        return qD;
    }

    public void setqD(String qD) {
        this.qD = qD;
    }

    public String getAns() {
        return ans;
    }

    public void setAns(String ans) {
        this.ans = ans;
    }
}
