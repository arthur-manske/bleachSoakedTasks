package com.mk4.bleachSoakedTasks.model.database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatabaseOperation implements AutoCloseable {
    private PreparedStatement statement;
    private ResultSet rs;

    private String error;

    public DatabaseOperation(DatabaseContainer father, String sql) 
    {
        this.rs = null;
        this.error = null;
        this.statement = null;

        try {
            this.statement = father.getConn().prepareStatement(sql);
        } catch (SQLException e) {
            this.error = e.getMessage();
            this.statement = null;
        }
    }

    @Override
    public void close() 
    {
        try {
            if (this.rs != null) {
                this.rs.close();
            }
            if (this.statement != null) {
                this.statement.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseContainer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int execute(Object... args)
    {
        this.error = null;

        try {
            for (int i = 0; i < args.length; ++i)
                this.statement.setObject(i + 1, args[i]);

            this.statement.execute();
            this.rs = this.statement.getResultSet();

            return 0;
        } catch (SQLException e) {
            this.error = e.getLocalizedMessage();
            return -1;
        }
    }

    public boolean nextResult()
    {
        this.error = null;

        try {
            return this.rs.next();
        } catch (SQLException e) {
            this.error = e.getLocalizedMessage();
            return false;
        }
    }

    public int getInt(String column)
    {
        this.error = null;

        try {
            return this.rs.getInt(column);
        } catch (SQLException e) {
            this.error = e.getLocalizedMessage();
            return -1;
        }
    }

    public short getShort(String column)
    {
        this.error = null;

        try {
            return this.rs.getShort(column);
        } catch (SQLException e) {
            this.error = e.getLocalizedMessage();
            return -1;
        }
    }

    public long getLong(String column)
    {
        this.error = null;

        try {
            return this.rs.getLong(column);
        } catch (SQLException e) {
            this.error = e.getLocalizedMessage();
            return -1;
        }
    }

    public double getDouble(String column)
    {
        this.error = null;

        try {
            return this.rs.getDouble(column);
        } catch (SQLException e) {
            this.error = e.getLocalizedMessage();
            return Double.NEGATIVE_INFINITY;
        }
    }

    public float getFloat(String column)
    {
        this.error = null;

        try {
            return this.rs.getFloat(column);
        } catch (SQLException e) {
            this.error = e.getLocalizedMessage();
            return Float.NEGATIVE_INFINITY;
        }
    }

    public String getString(String column)
    {
        this.error = null;

        try {
            return this.rs.getString(column);
        } catch (SQLException e) {
            this.error = e.getLocalizedMessage();
            return null;
        }
    }

    public Date getDate(String column)
    {
        this.error = null;

        try {
            return this.rs.getDate(column);
        } catch (SQLException e) {
            this.error = e.getLocalizedMessage();
            return null;
        }
    }

    public String getError()
    {
        return this.error;
    }
}