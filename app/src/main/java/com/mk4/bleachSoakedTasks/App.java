package com.mk4.bleachSoakedTasks;

import com.mk4.bleachSoakedTasks.controller.WindowPreferencesController;

import com.mk4.bleachSoakedTasks.view.TaskForm;

/**
 * Initializes the program main window
 * @author Arthur de Souza Manske
 */
public class App {
    private WindowPreferencesController winPrefsController;
    private TaskForm                    taskForm;

    private App()
    {
        this.winPrefsController = new WindowPreferencesController(this.getClass().getName());

        this.winPrefsController.apply(null);
        this.taskForm = new TaskForm(this.winPrefsController);
    }

    private void run()
    {
        this.winPrefsController.apply(this.taskForm);
        this.taskForm.setVisible(true);
    }

    /**
     * Initializes the application
     * @param args - Command line arguments
     */
    public static void main(String[] args)
    {
        final var app = new App();
        app.run();
    }
}
