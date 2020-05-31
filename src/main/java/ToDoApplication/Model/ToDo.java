package ToDoApplication.Model;

import java.time.LocalDateTime;

public class ToDo {
    private short id;
    private String entryName;
    private String entryContent;
    private LocalDateTime dateTime;

    public ToDo(short id, String entryName, String entryContent, LocalDateTime dateTime) {
        this.id = id;
        this.entryName = entryName;
        this.entryContent = entryContent;
        this.dateTime = dateTime;
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

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
}
