package org.corpauration.todolist.tache;

import io.quarkus.hibernate.reactive.panache.PanacheEntityBase;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import java.sql.Date;
import java.util.UUID;

@Entity
public class TaskEntity extends PanacheEntityBase {

    @Id
    @GeneratedValue
    @Schema(name = "id", example = "3fa85f64-5717-4562-b3fc-2c963f66afa6", required = true)
    public UUID id;
    public int status = 0; //0=NotStarted;1=Started;2=Finished;3=Late
    public String title = "NoDefined";
    public String description = "NoDefined";
    public Date dueDate = null;

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof TaskEntity task) {
            return task == this;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "Id : " + this.id + ", Status : " + this.status + ", Title : " + this.title + ", Description : " + this.description + ", Due Date : " + this.dueDate;
    }

    public TaskEntity(){

    }

    public TaskEntity(
            TaskInput taskInput
    ){
        this.status = taskInput.status;
        this.title = taskInput.title;
        this.description = taskInput.description;
        this.dueDate = taskInput.dueDate;
    }
}
