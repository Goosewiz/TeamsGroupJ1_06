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
        String[] answer = listStream.filter(i -> i.isModerated())
                .sorted(Comparator.comparing(Comment::date))
                .map(i -> i.text())
                .toArray(String[]::new);
        Collections.reverse(Arrays.asList(answer));
        return answer;
    }

    public String[] getComments(int page, int pageSize) {
        String[] answer = getComments();
        answer = answerByPages(answer, page, pageSize);
        return answer;
    }

    public String[] getCommentsOfAuthor(String name) {
        Stream<Comment> listStream = list.stream();
        String[] answer = listStream.filter(i -> i.name().equals(name))
                .sorted(Comparator.comparing(Comment::isModerated))
                .map(i -> i.text())
                .toArray(String[]::new);
        return answer;
    }

    public String[] getCommentsOfAuthor(String name, int page, int pageSize) {
        String[] answer = getCommentsOfAuthor(name);
        answer = answerByPages(answer, page, pageSize);
        return answer;
    }

    public String[] getAuthorsAfterDate(LocalDate date) {
        Stream<Comment> listStream = list.stream();
        String[] answer = listStream.filter(i -> i.date().isAfter(date))
                .map(i -> i.name())
                .distinct()
                .toArray(String[]::new);
        return answer;
    }

    public String[] getAuthorsAfterDate(LocalDate date, int page, int pageSize) {
        String[] answer = getAuthorsAfterDate(date);
        answer = answerByPages(answer, page, pageSize);
        return answer;
    }
    public String[] answerByPages(String[] array, int page, int pageSize){
        Stream<String> stringStream = Arrays.stream(array);
        String[] answer = stringStream.skip(page*pageSize)
                .limit(pageSize)
                .toArray(String[]::new);
        return answer;
    }
}
