package gusev.java23.task3;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Stream;

public class CommentService {
    private ArrayList<Comment> list;

    CommentService(ArrayList<Comment> list) {
        this.list = list;
    }

    public String[] getComments() {
        Stream<Comment> listStream = list.stream();
        String[] answer = listStream.filter(i -> i.getIsModerated())
                .sorted(Comparator.comparing(Comment::getDate))
                .map(i -> i.getText())
                .toArray(String[]::new);
        Collections.reverse(Arrays.asList(answer));
        return answer;
    }

    public String[] getComments(int page, int pageSize) {
        String[] answer = getComments();
        String[] output = sharedCode(answer, page, pageSize);
        return output;
    }

    public String[] getCommentsOfAuthor(String name) {
        Stream<Comment> listStream = list.stream();
        String[] answer = listStream.filter(i -> i.getName().equals(name))
                .sorted(Comparator.comparing(Comment::getIsModerated))
                .map(i -> i.getText())
                .toArray(String[]::new);
        return answer;
    }

    public String[] getCommentsOfAuthor(String name, int page, int pageSize) {
        String[] answer = getCommentsOfAuthor(name);
        String[] output = sharedCode(answer, page, pageSize);
        return output;
    }

    public String[] getAuthorsAfterDate(LocalDate date) {
        Stream<Comment> listStream = list.stream();
        String[] answer = listStream.filter(i -> i.getDate().isAfter(date))
                .map(i -> i.getName())
                .distinct()
                .toArray(String[]::new);
        return answer;
    }

    public String[] getAuthorsAfterDate(LocalDate date, int page, int pageSize) {
        String[] answer = getAuthorsAfterDate(date);
        String[] output = sharedCode(answer, page, pageSize);
        return output;
    }
    public String[] sharedCode(String[] answer, int page, int pageSize){
        int len;
        String[] output;
        if (pageSize > answer.length) {
            len = answer.length;
        } else {
            len = pageSize;
        }
        int startPoint = page * pageSize;
        if (startPoint > answer.length)
            return new String[] {};
        output = new String[len];
        int i = 0;
        while (startPoint != answer.length && i != output.length) {
            output[i] = answer[startPoint];
            i++;
            page++;
        }
        return output;
    }
}
