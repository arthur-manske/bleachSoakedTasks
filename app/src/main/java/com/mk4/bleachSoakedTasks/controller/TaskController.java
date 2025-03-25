package com.mk4.bleachSoakedTasks.controller;

import com.mk4.bleachSoakedTasks.model.Task;
import com.mk4.bleachSoakedTasks.model.TaskDAO;
import com.mk4.bleachSoakedTasks.model.database.DatabaseContainer;
import java.util.ArrayList;

import java.util.Date;
import java.util.List;

/**
 *
 * @author Ariel Lorenz
 */
public class TaskController {
    private final DatabaseContainer db;
    private final TaskDAO           taskDAO;
    
    public TaskController(String dbPath)
    {
        this.db      = new DatabaseContainer(dbPath);
        this.taskDAO = new TaskDAO(this.db);
        
        final var error = this.db.initialize();
        if (error != null)
            System.err.println("Erro ao iniciar o banco de dados: " + this.db.initialize());
    }
    
    public boolean addTask(String title, String description, Date expirationDate, int status)
    {
        if (title != null && title.isBlank()) title = null;    
        
        return this.taskDAO.insert(new Task(title, description, expirationDate, (status > -1 && status < 2) ? Task.Status.values()[status] : null));
    }
    
    public boolean updateTask(String title, String newDescription, Date newExpirationDate, int newStatus)
    {
        final var task = new Task(title, null, null, null);
        if (!this.taskDAO.query(task)) return false;
        
        if (newDescription != null && !newDescription.isBlank())
            task.setDescription(newDescription);
        
        if (newExpirationDate != null)
            task.setExpirationDate(newExpirationDate);
        
        if (newStatus > -1 && newStatus < 2)
            task.setStatus(Task.Status.values()[newStatus]);
        
        return this.taskDAO.update(task);
    }
    
    public boolean delTask(String title)
    {
        final var task = new Task(title, null, null, null);
        if (!this.taskDAO.query(task)) return false;
        
        return this.taskDAO.delete(task);
    }
    
    public String getTaskDescription(String title)
    {
        final var task = new Task(title, null, null, null);
        if (!this.taskDAO.query(task)) return null;
        
        return task.getDescription();
    }
    
    public Date getTaskExpirationDate(String title)
    {
        final var task = new Task(title, null, null, null);
        if (!this.taskDAO.query(task)) return null;
        
        return task.getExpirationDate();
    }
    
    public String getTaskStatus(String title)
    {
        final var task = new Task(title, null, null, null);
        System.err.println("getTaskStatus: Chegou no primeiro checkpoint");
        if (!this.taskDAO.query(task)) return null;
        System.err.println("getTaskStatus: Chegou no segundo checkpoint");

        return task.getStatus() == Task.Status.PENDING ? "Pendente" : "Concluída";
    }
    
    public boolean listTasks(List<String> buffer)
    {
       final var tasks = new ArrayList<Task>();
       if (!this.taskDAO.list(tasks)) return false;
       
       for (final var task : tasks)
           buffer.add(task.getTitle());
       
       return true;
    }
    
    public String getError()
    {
        return this.taskDAO.getError();
    }
}