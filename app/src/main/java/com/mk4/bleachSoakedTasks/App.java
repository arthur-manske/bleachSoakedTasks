package com.mk4.bleachSoakedTasks;

import com.mk4.bleachSoakedTasks.controller.TaskController;
import com.mk4.bleachSoakedTasks.controller.WindowPreferencesController;

import com.mk4.bleachSoakedTasks.view.TaskForm;

/**
 * Initializes the program main window
 * @author Arthur de Souza Manske
 */
public class App {
    private final TaskController              taskController;
    private final WindowPreferencesController winPrefsController;
    private final TaskForm                    taskForm;

    private App()
    {
        this.winPrefsController = new WindowPreferencesController(this.getClass().getName());
        this.taskController     = new TaskController("tasks.db");

        this.winPrefsController.apply(null);
        this.taskForm = new TaskForm(this.taskController, this.winPrefsController);
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
