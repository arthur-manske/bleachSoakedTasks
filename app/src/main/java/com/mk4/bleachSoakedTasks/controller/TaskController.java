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
        
        System.err.println("Erro ao iniciar o banco de dados: " + this.db.initialize());
    }
    
    public boolean addTask(String title, String description, Date expirationDate, int status)
    {
        if (title == null || title.isEmpty()) return false;
        if (status < 0 || status > 1) return false;
        
        return this.taskDAO.insert(new Task(title, description, expirationDate, Task.Status.values()[status]));
    }
    
    public boolean updateTask(String title, String newDescription, Date newExpirationDate, int newStatus)
    {
        final var task = new Task(title, null, null, null);
        if (!this.taskDAO.query(task)) return false;
        
        if (newDescription != null && !newDescription.equals(""))
            task.setDescription(newDescription);
        
        if (newExpirationDate != null)
            task.setExpirationDate(newExpirationDate);
        
        if (newStatus > 0 && newStatus < 2)
            task.setStatus(Task.Status.values()[newStatus]);
        
        return this.taskDAO.update(task);
    }
    
    public boolean delTask(String title)
    {
        final var task = new Task(title, null, null, null);
        if (!this.taskDAO.query(task)) return false;
        
        return this.taskDAO.delete(task);
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