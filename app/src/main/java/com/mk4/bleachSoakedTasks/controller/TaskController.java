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
        if (error != null) System.err.println("Erro ao iniciar o banco de dados: " + this.db.initialize());
    }
    
    public int getTaskPos(String title)
    {
        final var task = new Task(title, null, null, 0, null);
        if (title == null || title.isBlank()) return -1;
        if (!this.taskDAO.query(task)) return -1;
        
        return task.getPos();
    }
    
    public String getTaskDescription(String title)
    {
        final var task = new Task(title, null, null, 0, null);
        if (title == null || title.isBlank()) return null;
        if (!this.taskDAO.query(task)) return null;
        
        return task.getDescription();        
    }
    
    public String getTaskStatus(String title)
    {
        final var task = new Task(title, null, null, 0, null);
        if (title == null || title.isBlank()) return null;
        if (!this.taskDAO.query(task)) return null;
        
        return task.getStatus() == Task.Status.PENDING ? "Pendente" : "Concluída";
    }
    
    public Date getTaskExpirationDate(String title)
    {
        final var task = new Task(title, null, null, 0, null);
        if (title == null || title.isBlank()) return null;
        if (!this.taskDAO.query(task)) return null;
        
        return task.getExpirationDate();
    }
    
    public String getTaskByPos(int pos)
    {
        final var task = new Task(null, null, null, pos, null);
        this.taskDAO.queryByPos(task);
        return task.getTitle();
    }
    
    public boolean addTask(String title, String description, Date expirationDate, int pos, int status)
    {
        if (title == null || title.isEmpty()) return false;
        if (status < 0 || status > 1) return false;
        
        return this.taskDAO.insert(new Task(title, description, expirationDate, pos, Task.Status.values()[status]));
    }
    
    public boolean updateTask(String title, String newTitle, String newDescription, Date newExpirationDate, int newPos, int newStatus)
    {
        final var task = new Task(title, null, null, 0, null);
        if (!this.taskDAO.query(task)) return false;
        
        if (newTitle != null && !newTitle.isBlank())
            task.setTitle(newTitle);
        
        if (newDescription != null && !newDescription.isBlank())
            task.setDescription(newDescription);
        
        if (newExpirationDate != null)
            task.setExpirationDate(newExpirationDate);
        
        if (newStatus > 0 && newStatus < 2)
            task.setStatus(Task.Status.values()[newStatus]);
        
        if (newPos > 0)
            task.setPos(newPos);
        
        return this.taskDAO.update(task);
    }
    
    public boolean delTask(String title)
    {
        final var task = new Task(title, null, null, 0, null);
        if (!this.taskDAO.query(task)) return false;
        
        return this.taskDAO.delete(task);
    }
    
    public boolean listTasks(List<String> buffer)
    {
       final var tasks = new ArrayList<Task>();
       if (!this.taskDAO.list(tasks)) return false;
       
       System.out.print("vai se foder");
       
       for (final var task : tasks)
           buffer.add(task.getTitle());
       
       return true;
    }
    
    public String getError()
    {
        return this.taskDAO.getError();
    }
}