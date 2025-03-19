package com.mk4.bleachSoakedTasks.view;

/**
 * TaskForm implements the main view for the application
 * @author Arthur de Souza Manske
 */
public class TaskForm extends javax.swing.JFrame {

    /**
     * Creates new form TaskForm
     */
    public TaskForm() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Main = new javax.swing.JSplitPane();
        taskOverviewPanel = new javax.swing.JPanel();
        taskOverviewScroll = new javax.swing.JScrollPane();
        taskOverviewTree = new javax.swing.JTree();
        taskPanel = new javax.swing.JPanel();
        descriptionScroll = new javax.swing.JScrollPane();
        descriptionArea = new javax.swing.JTextArea();
        expirationDateSpinner = new javax.swing.JSpinner();
        descriptionLabel = new javax.swing.JLabel();
        expirationDateLabel = new javax.swing.JLabel();
        statusLabel = new javax.swing.JComboBox<>();
        expirationDateCheckbox = new javax.swing.JCheckBox();
        fileMenu = new javax.swing.JMenu();
        editMenu = new javax.swing.JMenu();
        viewMenu = new javax.swing.JMenu();
        windowMenu = new javax.swing.JMenu();
        windowMenuDarkModeCheckbox = new javax.swing.JCheckBoxMenuItem();
        helpMenu = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Lista de Tarefas");
        setFocusCycleRoot(false);

        Main.setDividerSize(12);
        Main.setResizeWeight(0.005);
        Main.setToolTipText("");

        taskOverviewTree.setFont(new java.awt.Font("Franklin Gothic Book", 0, 12)); // NOI18N
        taskOverviewTree.setAutoscrolls(true);
        taskOverviewTree.setDragEnabled(true);
        taskOverviewTree.setEditable(true);
        taskOverviewScroll.setViewportView(taskOverviewTree);

        javax.swing.GroupLayout taskOverviewPanelLayout = new javax.swing.GroupLayout(taskOverviewPanel);
        taskOverviewPanel.setLayout(taskOverviewPanelLayout);
        taskOverviewPanelLayout.setHorizontalGroup(
            taskOverviewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(taskOverviewPanelLayout.createSequentialGroup()
                .addComponent(taskOverviewScroll, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
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
                .addGroup(taskPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(expirationDateSpinner, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(taskPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(taskPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(taskPanelLayout.createSequentialGroup()
                                .addComponent(descriptionLabel)
                                .addGap(18, 18, 18)
                                .addComponent(statusLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(descriptionScroll)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, taskPanelLayout.createSequentialGroup()
                                .addComponent(expirationDateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(expirationDateCheckbox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
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
        windowMenuDarkModeCheckbox.setSelected(true);
        windowMenuDarkModeCheckbox.setText("Modo escuro");
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSplitPane Main;
    private javax.swing.JTextArea descriptionArea;
    private javax.swing.JLabel descriptionLabel;
    private javax.swing.JScrollPane descriptionScroll;
    private javax.swing.JMenu editMenu;
    private javax.swing.JCheckBox expirationDateCheckbox;
    private javax.swing.JLabel expirationDateLabel;
    private javax.swing.JSpinner expirationDateSpinner;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenu helpMenu;
    private final javax.swing.JMenuBar menuBar = new javax.swing.JMenuBar();
    private javax.swing.JComboBox<String> statusLabel;
    private javax.swing.JPanel taskOverviewPanel;
    private javax.swing.JScrollPane taskOverviewScroll;
    private javax.swing.JTree taskOverviewTree;
    private javax.swing.JPanel taskPanel;
    private javax.swing.JMenu viewMenu;
    private javax.swing.JMenu windowMenu;
    private javax.swing.JCheckBoxMenuItem windowMenuDarkModeCheckbox;
    // End of variables declaration//GEN-END:variables
}
