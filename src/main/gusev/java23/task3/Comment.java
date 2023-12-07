package gusev.java23.task3;

import java.time.LocalDate;

public class Comment {
    private String name;
    private LocalDate date;
    private boolean isModerated;
    private String text;
    public Comment(String name, LocalDate date, boolean isModerated, String text){
        this.name = name;
        this.date = date;
        this.isModerated = isModerated;
        this.text = text;
    }
    public String getName(){
        return this.name;
    }
    public LocalDate getDate(){
        return this.date;
    }
    public boolean getIsModerated(){
        return this.isModerated;
    }
    public String getText(){
        return this.text;
    }
}
