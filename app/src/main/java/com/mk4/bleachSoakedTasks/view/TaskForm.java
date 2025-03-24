package com.mk4.bleachSoakedTasks.view;

import com.mk4.bleachSoakedTasks.controller.TaskController;
import com.mk4.bleachSoakedTasks.controller.WindowPreferencesController;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

/**
 * TaskForm implements the main view for the application
 *
 * @author Arthur de Souza Manske
 */
public class TaskForm extends javax.swing.JFrame {

    private final TaskController tasks;
    private final WindowPreferencesController windowPrefs;

    /**
     * Creates new form TaskForm
     *
     * @param tasks The controller for the tasks
     * @param windowPrefs The controller for window preferences
     */
    public TaskForm(TaskController tasks, WindowPreferencesController windowPrefs) {
        this.tasks = tasks;
        this.windowPrefs = windowPrefs;

        initComponents();

        this.updateTree();
    }

    private void updateTree() {
        final var model = (DefaultTreeModel) this.taskOverviewTree.getModel();
        final var root = (DefaultMutableTreeNode) (model != null ? model.getRoot() : null);

        if (model == null || root == null) {
            return;
        }

        final var contents = new ArrayList<String>();
        if (!this.tasks.listTasks(contents)) {
            JOptionPane.showMessageDialog(null, "Erro no banco de dados: " + this.tasks.getError(), "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        root.removeAllChildren();
        for (final var content : contents) {
            final var newNode = new DefaultMutableTreeNode(content, false);
            final var pos = this.tasks.getTaskPos(content);

            model.insertNodeInto(newNode, root, pos >= 0 ? pos : root.getChildCount());
        }

        model.reload();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        taskOverviewTreeContextMenu = new javax.swing.JPopupMenu();
        taskOverviewTreeCreateMenu = new javax.swing.JMenu();
        taskOverviewTreeCreateGroup = new javax.swing.JMenuItem();
        taskOverviewTreeCreateTask = new javax.swing.JMenuItem();
        taskOverviewTreeDelete = new javax.swing.JMenuItem();

        taskOverviewTreeContextMenu.setInvoker(taskOverviewTree);
        taskOverviewTreeContextMenu.setPopupSize(new java.awt.Dimension(120, 50));

        taskOverviewTreeCreateMenu.setText("Criar");
        taskOverviewTreeCreateMenu.setToolTipText("Menu de criação");

        taskOverviewTreeCreateGroup.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_G, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        taskOverviewTreeCreateGroup.setText("Criar novo grupo de tarefas");
        taskOverviewTreeCreateGroup.setToolTipText("Divide e organiza as tarefas (Ctrl+G)");
        taskOverviewTreeCreateGroup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                taskOverviewTreeCreateGroupActionPerformed(evt);
            }
        });
        taskOverviewTreeCreateMenu.add(taskOverviewTreeCreateGroup);

        taskOverviewTreeCreateTask.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        taskOverviewTreeCreateTask.setText("Criar tarefa");
        taskOverviewTreeCreateTask.setToolTipText("Nova tarefa dentro do grupo atual (Ctrl+N)");
        taskOverviewTreeCreateTask.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                taskOverviewTreeCreateTaskActionPerformed(evt);
            }
        });
        taskOverviewTreeCreateMenu.add(taskOverviewTreeCreateTask);

        taskOverviewTreeContextMenu.add(taskOverviewTreeCreateMenu);

        taskOverviewTreeDelete.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_DELETE, 0));
        taskOverviewTreeDelete.setText("Deletar");
        taskOverviewTreeDelete.setToolTipText("Deleta a seleção atual (Delete)");
        taskOverviewTreeDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                taskOverviewTreeDeleteActionPerformed(evt);
            }
        });
        taskOverviewTreeContextMenu.add(taskOverviewTreeDelete);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Lista de Tarefas");
        setFocusCycleRoot(false);

        Main.setDividerSize(12);
        Main.setResizeWeight(0.005);
        Main.setToolTipText("");

        taskOverviewTree.setFont(new java.awt.Font("Franklin Gothic Book", 0, 12)); // NOI18N
        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("Notas");
        taskOverviewTree.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        taskOverviewTree.setToolTipText("");
        taskOverviewTree.setComponentPopupMenu(taskOverviewTreeContextMenu);
        taskOverviewTree.setDragEnabled(true);
        taskOverviewTree.setEditable(true);
        taskOverviewTree.setRootVisible(false);
        taskOverviewTree.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {
            public void valueChanged(javax.swing.event.TreeSelectionEvent evt) {
                taskOverviewTreeValueChanged(evt);
            }
        });
        taskOverviewTree.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                taskOverviewTreePropertyChange(evt);
            }
        });
        taskOverviewTree.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                taskOverviewTreeKeyPressed(evt);
            }
        });
        taskOverviewScroll.setViewportView(taskOverviewTree);

        javax.swing.GroupLayout taskOverviewPanelLayout = new javax.swing.GroupLayout(taskOverviewPanel);
        taskOverviewPanel.setLayout(taskOverviewPanelLayout);
        taskOverviewPanelLayout.setHorizontalGroup(
            taskOverviewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(taskOverviewPanelLayout.createSequentialGroup()
                .addComponent(taskOverviewScroll, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        taskOverviewPanelLayout.setVerticalGroup(
            taskOverviewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(taskOverviewScroll, javax.swing.GroupLayout.DEFAULT_SIZE, 489, Short.MAX_VALUE)
        );

        Main.setLeftComponent(taskOverviewPanel);

        descriptionArea.setColumns(20);
        descriptionArea.setRows(5);
        descriptionScroll.setViewportView(descriptionArea);

        expirationDateSpinner.setModel(new javax.swing.SpinnerDateModel(new java.util.Date(), null, null, java.util.Calendar.SECOND));
        expirationDateSpinner.setEnabled(expirationDateCheckbox.isSelected());

        descriptionLabel.setText("Descrição da tarefa");

        expirationDateLabel.setText("Prazo para conclusão");

        statusLabel.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pendente", "Concluída" }));
        statusLabel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                statusLabelActionPerformed(evt);
            }
        });

        expirationDateCheckbox.setText("Possui prazo limite");
        expirationDateCheckbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                expirationDateCheckboxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout taskPanelLayout = new javax.swing.GroupLayout(taskPanel);
        taskPanel.setLayout(taskPanelLayout);
        taskPanelLayout.setHorizontalGroup(
            taskPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, taskPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(taskPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(expirationDateSpinner)
                    .addComponent(descriptionScroll)
                    .addGroup(taskPanelLayout.createSequentialGroup()
                        .addComponent(expirationDateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                        .addComponent(expirationDateCheckbox, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(taskPanelLayout.createSequentialGroup()
                        .addComponent(descriptionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(statusLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        taskPanelLayout.setVerticalGroup(
            taskPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(taskPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(taskPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(descriptionLabel)
                    .addComponent(statusLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(descriptionScroll, javax.swing.GroupLayout.DEFAULT_SIZE, 378, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(taskPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(expirationDateLabel)
                    .addComponent(expirationDateCheckbox))
                .addGap(14, 14, 14)
                .addComponent(expirationDateSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        Main.setRightComponent(taskPanel);

        fileMenu.setText("Arquivo");
        menuBar.add(fileMenu);

        editMenu.setText("Editar");
        menuBar.add(editMenu);

        viewMenu.setText("Visualizar");
        menuBar.add(viewMenu);

        windowMenu.setText("Janela");

        windowMenuDarkModeCheckbox.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F2, 0));
        windowMenuDarkModeCheckbox.setSelected(this.windowPrefs.getTheme().equals("dark"));
        windowMenuDarkModeCheckbox.setText("Modo escuro");
        windowMenuDarkModeCheckbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                windowMenuDarkModeCheckboxActionPerformed(evt);
            }
        });
        windowMenu.add(windowMenuDarkModeCheckbox);

        menuBar.add(windowMenu);

        helpMenu.setText("Ajuda");
        menuBar.add(helpMenu);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Main)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(Main)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void statusLabelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_statusLabelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_statusLabelActionPerformed

    private void expirationDateCheckboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_expirationDateCheckboxActionPerformed
        this.expirationDateSpinner.setEnabled(this.expirationDateCheckbox.isSelected());
    }//GEN-LAST:event_expirationDateCheckboxActionPerformed

    private void windowMenuDarkModeCheckboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_windowMenuDarkModeCheckboxActionPerformed
        if (this.windowMenuDarkModeCheckbox.isSelected()) {
            this.windowPrefs.setTheme("dark");
        } else {
            this.windowPrefs.setTheme("light");
        }

        final var error = this.windowPrefs.apply(this);
        if (error != null)
            javax.swing.JOptionPane.showMessageDialog(null, "Não foi possível definir o tema: " + error, "Erro", javax.swing.JOptionPane.ERROR_MESSAGE);
    }//GEN-LAST:event_windowMenuDarkModeCheckboxActionPerformed

    private void taskOverviewTreeCreateTaskActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_taskOverviewTreeCreateTaskActionPerformed
        if (this.taskOverviewTree.isEditing()) {
            return;
        }

        final var model = (javax.swing.tree.DefaultTreeModel) this.taskOverviewTree.getModel();
        final var rootNode = (javax.swing.tree.DefaultMutableTreeNode) model.getRoot();
        final var selectedNode = (javax.swing.tree.DefaultMutableTreeNode) this.taskOverviewTree.getLastSelectedPathComponent();
        final var newNode = new javax.swing.tree.DefaultMutableTreeNode("Nova tarefa", false);

        var parentNode = (selectedNode != null) ? selectedNode : rootNode;
        if (!parentNode.getAllowsChildren()) {
            parentNode = rootNode;
        }

        if (!this.tasks.addTask("Nova tarefa", null, null, parentNode.getChildCount(), 0)) {
            JOptionPane.showMessageDialog(null, "ERRO: " + this.tasks.getError());
            return;
        }

        model.insertNodeInto(newNode, parentNode, parentNode.getChildCount());
        this.taskOverviewTree.scrollPathToVisible(new javax.swing.tree.TreePath(model.getPathToRoot(newNode)));
        this.taskOverviewTree.startEditingAtPath(new javax.swing.tree.TreePath(newNode.getPath()));
    }//GEN-LAST:event_taskOverviewTreeCreateTaskActionPerformed

    private void taskOverviewTreeDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_taskOverviewTreeDeleteActionPerformed
        final var model = (javax.swing.tree.DefaultTreeModel) this.taskOverviewTree.getModel();
        final var selectedNode = (javax.swing.tree.DefaultMutableTreeNode) this.taskOverviewTree.getLastSelectedPathComponent();

        if (selectedNode == null) {
            JOptionPane.showMessageDialog(this, "Por favor, selecione um item para excluir.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(
                this,
                "Tem certeza que deseja excluir o item selecionado?",
                "Confirmação",
                JOptionPane.YES_NO_OPTION
        );

        if (confirm == JOptionPane.YES_OPTION) {
            this.tasks.delTask((String) selectedNode.getUserObject());
            model.removeNodeFromParent(selectedNode);
        }
    }//GEN-LAST:event_taskOverviewTreeDeleteActionPerformed

    private void taskOverviewTreeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_taskOverviewTreeKeyPressed
        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_DELETE) {
            this.taskOverviewTreeDeleteActionPerformed(null);
        }
    }//GEN-LAST:event_taskOverviewTreeKeyPressed

    private void taskOverviewTreeCreateGroupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_taskOverviewTreeCreateGroupActionPerformed
        if (this.taskOverviewTree.isEditing())
            return;

        final var model = (javax.swing.tree.DefaultTreeModel) this.taskOverviewTree.getModel();
        final var rootNode = (javax.swing.tree.DefaultMutableTreeNode) model.getRoot();
        final var selectedNode = (javax.swing.tree.DefaultMutableTreeNode) this.taskOverviewTree.getLastSelectedPathComponent();
        final var newGroupNode = new javax.swing.tree.DefaultMutableTreeNode("Novo Grupo");

        var parentNode = (selectedNode != null) ? selectedNode : rootNode;
        if (!parentNode.getAllowsChildren())
            parentNode = rootNode;

        model.insertNodeInto(newGroupNode, parentNode, parentNode.getChildCount());

        this.taskOverviewTree.scrollPathToVisible(new javax.swing.tree.TreePath(model.getPathToRoot(newGroupNode)));
        this.taskOverviewTree.startEditingAtPath(new javax.swing.tree.TreePath(newGroupNode.getPath()));
    }//GEN-LAST:event_taskOverviewTreeCreateGroupActionPerformed

    private void taskOverviewTreeValueChanged(javax.swing.event.TreeSelectionEvent evt) {//GEN-FIRST:event_taskOverviewTreeValueChanged
        final var selectedNode = (DefaultMutableTreeNode) taskOverviewTree.getLastSelectedPathComponent();
        if (selectedNode == null)
            return;
        
        final var title          = selectedNode.getUserObject().toString();
        final var description    = tasks.getTaskDescription(title);
        final var expirationDate = tasks.getTaskExpirationDate(title);
        final var status         = tasks.getTaskStatus(title);
        
        this.descriptionArea.setText(description);
        if (expirationDate != null) {
            this.expirationDateCheckbox.setSelected(true);
            this.expirationDateSpinner.setEnabled(true);
            this.expirationDateSpinner.setValue(expirationDate);
        } else {
            this.expirationDateCheckbox.setSelected(false);
            this.expirationDateSpinner.setEnabled(false);
        }
                
        this.statusLabel.setSelectedItem(status);
    }//GEN-LAST:event_taskOverviewTreeValueChanged

    private void taskOverviewTreePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_taskOverviewTreePropertyChange
        if ("editingStopped".equals(evt.getPropertyName()) && !taskOverviewTree.isEditing()) {            
            final var selectedNode = (DefaultMutableTreeNode) taskOverviewTree.getLastSelectedPathComponent();
            if (selectedNode == null) return;
        
            final var newName = selectedNode.getUserObject().toString().trim();
            if (newName.isEmpty()) {
                JOptionPane.showMessageDialog(this, "O nome da tarefa não pode ser vazio. Por favor, insira um nome válido.", "Erro", JOptionPane.ERROR_MESSAGE);
                taskOverviewTree.startEditingAtPath(new javax.swing.tree.TreePath(selectedNode.getPath()));
            } else {
                final var parentNode = (DefaultMutableTreeNode) selectedNode.getParent();
                final var index      = parentNode != null ? parentNode.getIndex(selectedNode) : -1;

                if (!tasks.updateTask(tasks.getTaskByPos(index), newName, null, null, -1, -1))
                    JOptionPane.showMessageDialog(this, "Erro ao atualizar a tarefa: " + tasks.getError(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_taskOverviewTreePropertyChange

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private final javax.swing.JSplitPane Main = new javax.swing.JSplitPane();
    private final javax.swing.JTextArea descriptionArea = new javax.swing.JTextArea();
    private final javax.swing.JLabel descriptionLabel = new javax.swing.JLabel();
    private final javax.swing.JScrollPane descriptionScroll = new javax.swing.JScrollPane();
    private final javax.swing.JMenu editMenu = new javax.swing.JMenu();
    private final javax.swing.JCheckBox expirationDateCheckbox = new javax.swing.JCheckBox();
    private final javax.swing.JLabel expirationDateLabel = new javax.swing.JLabel();
    private final javax.swing.JSpinner expirationDateSpinner = new javax.swing.JSpinner();
    private final javax.swing.JMenu fileMenu = new javax.swing.JMenu();
    private final javax.swing.JMenu helpMenu = new javax.swing.JMenu();
    private final javax.swing.JMenuBar menuBar = new javax.swing.JMenuBar();
    private final javax.swing.JComboBox<String> statusLabel = new javax.swing.JComboBox<>();
    private final javax.swing.JPanel taskOverviewPanel = new javax.swing.JPanel();
    private final javax.swing.JScrollPane taskOverviewScroll = new javax.swing.JScrollPane();
    private final javax.swing.JTree taskOverviewTree = new javax.swing.JTree();
    private javax.swing.JPopupMenu taskOverviewTreeContextMenu;
    private javax.swing.JMenuItem taskOverviewTreeCreateGroup;
    private javax.swing.JMenu taskOverviewTreeCreateMenu;
    private javax.swing.JMenuItem taskOverviewTreeCreateTask;
    private javax.swing.JMenuItem taskOverviewTreeDelete;
    private final javax.swing.JPanel taskPanel = new javax.swing.JPanel();
    private final javax.swing.JMenu viewMenu = new javax.swing.JMenu();
    private final javax.swing.JMenu windowMenu = new javax.swing.JMenu();
    private final javax.swing.JCheckBoxMenuItem windowMenuDarkModeCheckbox = new javax.swing.JCheckBoxMenuItem();
    // End of variables declaration//GEN-END:variables
}
