package com.mk4.bleachSoakedTasks.model;

import com.mk4.bleachSoakedTasks.model.database.DatabaseContainer;
import com.mk4.bleachSoakedTasks.model.database.DatabaseOperation;
import java.util.List;

/**
 * Task Data Access Object (DAO) for Database interactions.
 * Handles CRUD operations for Task objects.
 * 
 * @author Natan Gabriel Wildner
 */
public class TaskDAO {
    private final DatabaseContainer db;
    private DatabaseOperation       dbOp;
    
    public TaskDAO(DatabaseContainer db)
    {
        this.db   = db;
        this.dbOp = null;
    }
    
    public String getError()
    {
        return this.dbOp.getError();
    }
    
    public boolean insert(Task task)
    {
        if (!this.db.isInitialized()) return false;
        
        this.dbOp = this.db.execute(
                """
                INSERT INTO tasks(title, description, status, expirationDate) VALUES (?, ?, ?, ?);
                """,
                task.getTitle(),
                task.getDescription(),
                task.getStatus(),
                task.getExpirationDate()
        );        
        
        return (this.dbOp.getError() == null);
    }
    
    public boolean delete(Task task)
    {
        if (!this.db.isInitialized()) return false;
        if (task.getId() == -1)       return false;
        
        this.dbOp = this.db.execute(
                """
                DELETE FROM tasks WHERE id = ?;
                """,
                task.getId()
        );
        
        return (this.dbOp.getError() == null);
    }
    
    public boolean update(Task task)
    {
        if (!this.db.isInitialized()) return false;
        if (task.getId() == -1) return false;
        if (task.getTitle() == null || task.getStatus() == null) return false;
        
        this.dbOp = this.db.execute(
                """
                UPDATE tasks SET title = ?, description = ?, expirationDate = ?, status = ? WHERE id = ?;
                """,
                task.getTitle(),
                task.getDescription(),
                task.getExpirationDate(),
                task.getStatus().ordinal(),
                task.getId()
        );
        
        return (this.dbOp.getError() == null);
    }
    
    public boolean query(Task task)
    {        
        this.dbOp = this.db.execute(
                """
                SELECT id, description, expirationDate, status FROM tasks WHERE title = ?
                """,
                task.getTitle()
        );
        
        if (!this.dbOp.nextResult())
            return false;
        
        task.setId(this.dbOp.getInt("id"));
        task.setDescription(this.dbOp.getString("description"));
        task.setExpirationDate(this.dbOp.getDate("expirationDate"));
        task.setStatus(Task.Status.values()[this.dbOp.getInt("status")]);
        
        return (this.dbOp.getError() == null);
    }
    
    public boolean list(List<Task> buffer)
    {
       if (!this.db.isInitialized()) return false;
       if (buffer == null) return false;
       
       this.dbOp = this.db.execute(
               """
               SELECT id, title, description, expirationDate, status FROM tasks;
               """
       );
       
       if (this.dbOp == null || this.dbOp.getError() != null) return false;

       while (this.dbOp.nextResult()) {
           final var task = new Task(
                   this.dbOp.getString("title"),
               this.dbOp.getString("description"),
            this.dbOp.getDate("expirationDate"),
                    Task.Status.values()[this.dbOp.getInt("status")]
           );
           
           task.setId(this.dbOp.getInt("id"));
           buffer.add(task);
       }
       
       return (this.dbOp.getError() == null);
    }
}