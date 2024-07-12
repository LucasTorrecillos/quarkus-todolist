package org.corpauration.todolist.tache;



import io.quarkus.hibernate.reactive.panache.common.WithSession;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("tasks")
@ApplicationScoped
public class TaskRessource {
    @Inject
    TaskService taskService;

    @GET
    @WithSession
    @Path("/getAllTasks")
    @Produces(MediaType.APPLICATION_JSON)
    public Uni<List<TaskOutput>> getAllTasks() {
        return taskService.getAllTasks();
    }

    @POST
    @WithSession
    @Path("/createTask")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Uni<TaskOutput> createTask(TaskInput taskInput) {
        return taskService.createTask(taskInput);
    }

    @POST
    @WithSession
    @Path("/deleteTask")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Uni<List<TaskOutput>> deleteTask(String title) {
        taskService.deleteTask(title);
        return getAllTasks();
    }

    @PUT
    @WithSession
    @Path("/updateTask")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Uni<List<TaskOutput>> updateTask(String title, TaskInput taskInput) {
        taskService.updateTask(title, taskInput);
        return getAllTasks();
    }
}