package org.corpauration.todolist.tache;

import java.sql.Date;

public class TaskOutput {
    public int status; //0=NotStarted;1=Started;2=Finished;3=Late
    public String title;
    public String description;
    public Date dueDate;
    public Date timeLeft;

    public TaskOutput(TaskEntity taskEntity) {
        this.title = taskEntity.title;
        this.description = taskEntity.description;
        this.dueDate = taskEntity.dueDate;
        this.status = taskEntity.status;
        Date timeLeft = new Date(System.currentTimeMillis());
        this.timeLeft = timeLeft;
    }
}
