package gusev.java23.task3;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CommentServiceTest {

    @Test
    void result() {
        ArrayList<Comment> list = new ArrayList<>();
        LocalDate ld = LocalDate.of(2023, Month.NOVEMBER, 23);
        Comment comm = new Comment("Алексей", ld, true, "а");
        list.add(comm);
        ld = LocalDate.of(1990, Month.NOVEMBER, 23);
        comm = new Comment("Алексей", ld, true, "б");
        list.add(comm);
        ld = LocalDate.of(1991, Month.NOVEMBER, 23);
        comm = new Comment("Алексей", ld, true, "в");
        list.add(comm);
        ld = LocalDate.of(1992, Month.NOVEMBER, 23);
        comm = new Comment("Алексей", ld, false, "г");
        list.add(comm);
        CommentService cs = new CommentService(list);
        String[] answer = cs.getComments();
        assertEquals(3, answer.length, "getComments");
        assertEquals("а", answer[0], "getComments");
        assertEquals("в", answer[1], "getComments");
        assertEquals("б", answer[2], "getComments");
        answer = cs.getCommentsOfAuthor("Алексей");
        assertEquals(4, answer.length, "getCommentsOfAuthor");
        assertEquals("г", answer[0], "getCommentsOfAuthor");
        assertEquals("а", answer[1], "getCommentsOfAuthor");
        assertEquals("б", answer[2], "getCommentsOfAuthor");
        assertEquals("в", answer[3], "getCommentsOfAuthor");
        answer = cs.getAuthorsAfterDate(LocalDate.of(1889, Month.NOVEMBER, 23));
        assertEquals(1, answer.length, "getAuthorsAfterDate");
        assertEquals("Алексей", answer[0], "getAuthorsAfterDate");
        answer = cs.getComments(1, 1);
        assertEquals(1, answer.length, "getComments");
        assertEquals("в", answer[0], "getComments");
        answer = cs.getComments(1, 4);
        assertEquals(0, answer.length, "getComments");
        list = new ArrayList<>();
        cs = new CommentService(list);
        answer = cs.getComments();
        assertEquals(0, answer.length, "getComments");
        answer = cs.getCommentsOfAuthor("Алексей");
        assertEquals(0, answer.length, "getCommentsOfAuthor");
        answer = cs.getAuthorsAfterDate(LocalDate.of(1889, Month.NOVEMBER, 23));
        assertEquals(0, answer.length, "getAuthorsAfterDate");
    }
}