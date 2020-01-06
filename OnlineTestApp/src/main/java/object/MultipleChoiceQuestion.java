/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package object;

import java.util.List;

/**
 *
 * @author huyvi
 */
public class MultipleChoiceQuestion {
    private String question;
    private List<String> choices;
    private int answer;

    public MultipleChoiceQuestion() {
    }

    public MultipleChoiceQuestion(String question, List<String> choices, int answer) {
        this.question = question;
        this.choices = choices;
        this.answer = answer;
    }

    public int getAnswer() {
        return answer;
    }

    public List<String> getChoices() {
        return choices;
    }

    public String getQuestion() {
        return question;
    }

    public void setAnswer(int answer) {
        this.answer = answer;
    }

    public void setChoices(List<String> choices) {
        this.choices = choices;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    @Override
    public String toString() {
        return question 
                + "\n" + choices.get(0)
                + "\n" + choices.get(1)
                + "\n" + choices.get(2)
                + "\n" + choices.get(3)
                + "\n" + answer;
    }

    
}
