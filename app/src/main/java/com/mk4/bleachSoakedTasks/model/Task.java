package com.mk4.bleachSoakedTasks.model;

import java.util.Date;

/**
 * Task model
 * @author Natan Gabriel Wildner
 */
public class Task {
    public enum Status {
        PENDING, COMPLETED
    };

    private int    id;
    private String title;
    private String description;
    private Date   expirationDate;
    private Status status;
    private int    pos;

    public Task(String title, String description, Date expirationDate, int pos, Status status)
    {
        this.title          = title;
        this.description    = description;
        this.pos            = pos;
        this.status         = status;
        this.expirationDate = expirationDate;
        this.id             = -1;
    }
    
    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public Date getExpirationDate()
    {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate)
    {
        this.expirationDate = expirationDate;
    }
    
    public int getPos()
    {
        return pos;
    }
    
    public void setPos(int pos)
    {
        this.pos = pos;
    }

    public Status getStatus()
    {
        return status;
    }
    
    public void setStatus(Status status)
    {
        this.status = status;
    }

    public boolean isCompleted()
    {
        return this.status == Status.COMPLETED;
    }

    public boolean hasExpirationDate()
    {
        return this.expirationDate != null;
    }
}
