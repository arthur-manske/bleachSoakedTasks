package com.mk4.bleachSoakedTasks;

import com.mk4.bleachSoakedTasks.view.SwingConfig;
import com.mk4.bleachSoakedTasks.view.TaskForm;

/**
 * 
 * @author Arthur de Souza Manske
 */
public class App {
    
    /**
     * Initializes the application
     * @param args - Command line arguments
     */
    public static void main(String[] args)
    {
        SwingConfig.setFlatLafTheme(true, null);
        new TaskForm().setVisible(true);
    }
}