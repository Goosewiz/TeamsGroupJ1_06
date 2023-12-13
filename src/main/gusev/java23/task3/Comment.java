package gusev.java23.task3;

import java.time.LocalDate;

public record Comment(String name, LocalDate date, boolean isModerated, String text) {
}
