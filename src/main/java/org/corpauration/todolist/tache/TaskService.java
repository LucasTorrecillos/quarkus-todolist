package org.corpauration.todolist.tache;

import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class TaskService {
    @Inject
    TaskRepositories repositories;

    public Uni<List<TaskOutput>> getAllTasks() {
        return repositories.getAllTasks().map(
                taskEntities -> taskEntities.stream().map(TaskOutput::new).toList()
        );
    }

    public Uni<TaskOutput> getTaskByTitle(String title) {
        return repositories.findByTitle(title).map(TaskOutput::new);
    }

    public Uni<List<TaskOutput>> getTaskByStatus(int status) {
        return repositories.findByStatus(status).map(
                taskEntities -> taskEntities.stream().map(TaskOutput::new).toList()
        );
    }

    public Uni<TaskOutput> createTask(TaskInput taskInput) {
        TaskEntity taskEntity = new TaskEntity(taskInput);
        return repositories.addTask(taskEntity).map(TaskOutput::new);
    }


    public void deleteTask(String title) {
        repositories.delete("title", title);
    }

    public void updateTask(String title, TaskInput taskInput) {
        repositories.updateTask(title, new TaskEntity(taskInput));
    }
}
