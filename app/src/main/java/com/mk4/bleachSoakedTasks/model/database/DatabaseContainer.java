package com.mk4.bleachSoakedTasks.model.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Arthur de Souza Manske
 */
public class DatabaseContainer implements AutoCloseable {
    private boolean initialized = false;
    
    private final String path;
    private Connection sqlConn;

    public Connection getConn()
    {
        return this.sqlConn;
    }
    
    public DatabaseContainer(String path)
    {
        this.path = "jdbc:sqlite:" + path;
    }
    
    @Override public void close()
    {
        if (this.sqlConn != null) {
            try {
                this.sqlConn.close();
            } catch (SQLException ex) {
                Logger.getLogger(DatabaseContainer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        this.initialized = false;        
    }
    
    public String initialize()
    {
        final var sql = """
        CREATE TABLE IF NOT EXISTS tasks (
            id INTEGER PRIMARY KEY AUTOINCREMENT,
            title TEXT NOT NULL,
            description TEXT,
            expirationDate DATE,
            pos INT NOT NULL,
            status INT
        );""";
        
        if (this.initialized) return null;
        
        try {
           this.sqlConn = DriverManager.getConnection(path); 
        } catch (SQLException e) {
           return e.getLocalizedMessage();
        }
                
        try (var statement = this.sqlConn.createStatement()) {
            statement.execute(sql);
        } catch (SQLException e) {            
            return e.getLocalizedMessage();
        }
        
        this.initialized = true;
        return null;
    }
    
    public DatabaseOperation execute(String sql, Object... args) {
        final var databaseOperation = new DatabaseOperation(this, sql);
        if (databaseOperation.getError() != null) return databaseOperation;
        
        databaseOperation.execute(args);
        return databaseOperation;
    }
        
    public boolean isInitialized()
    {
        return this.initialized;
    }
    
    public PreparedStatement prepareStatement(String sql) throws SQLException
    {
       return this.sqlConn.prepareStatement(sql);
    }
};