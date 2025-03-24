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
               
        if (task.getId() != -1)       return false;
        if (task.getTitle() == null)  return false;
        if (task.getStatus() == null) return false;
        
        this.dbOp = this.db.execute(
                """
                INSERT INTO tasks(title, description, pos, status, expirationDate) VALUES (?, ?, ?, ?, ?);
                """,
                task.getTitle(),
                task.getDescription(),
                task.getStatus().ordinal(),
                task.getPos(),
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
                UPDATE tasks SET title = ?, description = ?, expirationDate = ?, pos = ?, status = ? WHERE id = ?;
                """,
                task.getTitle(),
                task.getDescription(),
                task.getExpirationDate(),
                task.getPos(),
                task.getStatus().ordinal(),
                task.getId()
        );
        
        return (this.dbOp.getError() == null);
    }
    
    public boolean queryByPos(Task task)
    {
        if (!this.db.isInitialized()) return false;
        if (task.getId() != -1)       return false;
        if (task.getPos() < 0)        return false;
        
        this.dbOp = this.db.execute(
                """
                SELECT id, description, expirationDate, pos, status FROM tasks WHERE pos = ?
                """,
                task.getPos()
        );
        
        if (this.dbOp == null) return false;
        
        final var status = this.dbOp.getInt("status");

        task.setId(this.dbOp.getInt("id"));
        task.setDescription(this.dbOp.getString("description"));
        task.setExpirationDate(this.dbOp.getDate("expirationDate"));
        task.setId(this.dbOp.getInt("pos"));
        task.setStatus(Task.Status.values()[status > 0 && status < 3 ? status : 0]);
        
        return (this.dbOp.getError() != null);
    }
    
    public boolean query(Task task)
    {
        if (!this.db.isInitialized()) return false;
        if (task.getId() != -1)       return false;
        if (task.getTitle() == null)  return false;
        
        this.dbOp = this.db.execute(
                """
                SELECT id, description, expirationDate, pos, status FROM tasks WHERE title = ?
                """,
                task.getTitle()
        );
        
        if (this.dbOp == null) return false;

        final var status = this.dbOp.getInt("status");

        task.setId(this.dbOp.getInt("id"));
        task.setDescription(this.dbOp.getString("description"));
        task.setExpirationDate(this.dbOp.getDate("expirationDate"));
        task.setId(this.dbOp.getInt("pos"));
        task.setStatus(Task.Status.values()[status > 0 && status < 3 ? status : 1]);
        
        return (this.dbOp.getError() != null);
    }
    
    public boolean list(List<Task> buffer)
    {
       if (!this.db.isInitialized()) return false;
       if (buffer == null) return false;


       this.dbOp = this.db.execute(
               """
               SELECT id, title, description, expirationDate, pos, status FROM tasks;
               """
       );
       
       if (this.dbOp == null || this.dbOp.getError() != null) return false;

       do {
           final var id     = this.dbOp.getInt("id");
           final var status = this.dbOp.getInt("status");
           final var task   = new Task(
                   this.dbOp.getString("title"),
                   this.dbOp.getString("description"),
                   this.dbOp.getDate("expirationDate"),
                   this.dbOp.getInt("pos"),
                   Task.Status.values()[status > 0 && status < 3 ? status : 0]
           );
           
           task.setId(id);
           buffer.add(task);
       } while (this.dbOp.nextResult());

       return true;
       //return (this.dbOp.getError() != null);
    }
}