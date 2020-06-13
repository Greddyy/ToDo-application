package ToDoApplication.Model;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDateTime;


public class ToDo {
    private short id;
    private short user_id;
    private String entryName;
    private String entryContent;
    LocalDateTime localDateTime = LocalDateTime.now();
    private java.sql.Date date = java.sql.Date.valueOf(localDateTime.toLocalDate());
    private java.sql.Time time = java.sql.Time.valueOf(localDateTime.toLocalTime());


    public ToDo(short id, String entryName, String entryContent, java.sql.Date date, java.sql.Time time, short user_id) {
        this.id = id;
        this.entryName = entryName;
        this.entryContent = entryContent;
        this.date = date;
        this.time = time;
        this.user_id = user_id;


    }
    public ToDo(String entryName, String entryContent, java.sql.Date date, java.sql.Time time, short user_id) {
        this.entryName = entryName;
        this.entryContent = entryContent;
        this.date = date;
        this.time = time;
        this.user_id = user_id;

    }





    public short getId() {
        return id;
    }

    public void setId(short id) {
        this.id = id;
    }

    public String getEntryName() {
        return entryName;
    }

    public void setEntryName(String entryName) {
        this.entryName = entryName;
    }

    public String getEntryContent() {
        return entryContent;
    }

    public void setEntryContent(String entryContent) {
        this.entryContent = entryContent;
    }


    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public short getUser_id() {
        return user_id;
    }

    public void setUser_id(short user_id) {
        this.user_id = user_id;
    }
}
