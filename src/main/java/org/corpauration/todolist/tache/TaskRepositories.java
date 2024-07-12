package org.corpauration.todolist.tache;

import io.quarkus.hibernate.reactive.panache.Panache;
import io.quarkus.hibernate.reactive.panache.PanacheRepository;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class TaskRepositories implements PanacheRepository<TaskEntity> {
    public Uni<List<TaskEntity>> getAllTasks() {
        return this.listAll();
    }

    public Uni<TaskEntity> findByTitle(String title) {
        return this.find("title",title).firstResult();
    }

    public Uni<List<TaskEntity>> findByStatus(int status) {
        return  this.find("status",status).list();
    }

    public Uni<TaskEntity> addTask(TaskEntity task) {
        return Panache.withTransaction(() -> this.persist(task));
    }

    public void deleteTask(String title, TaskEntity task) {
        this.delete("title",title);
    }

    public void updateTask(String title, TaskEntity task) {
        addTask(task);
        deleteTask(title, task);
    }
}
