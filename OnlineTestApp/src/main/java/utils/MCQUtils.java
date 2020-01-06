/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.util.ArrayList;
import java.util.List;
import object.MultipleChoiceQuestion;

/**
 *
 * @author huyvi
 */
public class MCQUtils {
    private static List<MultipleChoiceQuestion> mcqs;
    
    public static List<MultipleChoiceQuestion> initData(){
        mcqs = new ArrayList<>();
        String question;
        List<String> choices = new ArrayList<>();
        int answer;
        
        question = "1 + 1 = ?";
        choices.add("0");
        choices.add("1");
        choices.add("10");
        choices.add("01");
        answer = 2;
        mcqs.add(new MultipleChoiceQuestion(question, choices, answer));
        
        question = "Có bao nhiêu cạnh trong 1 tam giác?";
        choices = new ArrayList<>();
        choices.add("tri");
        choices.add("nhị");
        choices.add("0");
        choices.add("không có đáp án nào đúng");
        answer = 3;
        mcqs.add(new MultipleChoiceQuestion(question, choices, answer));
        
        question = "Sự kiện nào đã diễn ra vào ngày 30/4/1975";
        choices = new ArrayList<>();
        choices.add("Giải phóng miền nam");
        choices.add("Ngày sinh Chủ tịch Hồ Chí Minh");
        choices.add("C# ra phiên bản 2.0");
        choices.add("Thành lập trường DDHBK Đà Nẵng");
        answer = 0;
        mcqs.add(new MultipleChoiceQuestion(question, choices, answer));
        
        
        question = "Bom nguyên tử được tạo ra dựa trên công thức nào?";
        choices = new ArrayList<>();
        choices.add("P = mg");
        choices.add("S = 4*pi*R^2");
        choices.add("E = mc^2");
        choices.add("F = ma");
        answer = 2;
        mcqs.add(new MultipleChoiceQuestion(question, choices, answer));
        
        question = "Ngỗng là loài động vật thuộc bộ:";
        choices = new ArrayList<>();
        choices.add("Ngỗng");
        choices.add("Thú biết bay");
        choices.add("Chim");
        choices.add("Động vật biết bơi");
        answer = 0;
        mcqs.add(new MultipleChoiceQuestion(question, choices, answer));
        
        return mcqs;
    }
}
