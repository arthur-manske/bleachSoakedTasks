package com.mk4.bleachSoakedTasks;

import com.mk4.bleachSoakedTasks.controller.WindowPreferencesController;

import com.mk4.bleachSoakedTasks.view.TaskForm;

/**
 * Initializes the program main window
 * @author Arthur de Souza Manske
 */
public class App {
    /**
     * Initializes the application
     * @param args - Command line arguments
     */
    public static void main(String[] args)
    {
    	final var app = new App();
	final var winPrefsController = new WindowPreferencesController(app.getClass().getName());
	
	new TaskForm(winPrefsController).setVisible(true);
    }
}
