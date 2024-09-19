package presentacion;

import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.table.TableRowSorter;
import negocio.CategoriaControl;

public class FrmCategorias extends javax.swing.JInternalFrame {

    //invocamos una clase como propiedad una variable
    private final CategoriaControl CONTROL;
    private String accion;
    private String nombreAnt;
    
    public FrmCategorias() {
        initComponents();
        this.CONTROL=new CategoriaControl();
        this.listar("");
        this.accion = "guardar";
        //tablaListado.setEnabled(false);
        tabGeneral.setEnabledAt(1, false);
    }
    
    //métodos CRUD
    private void listar(String texto){
        tablaListado.setModel(this.CONTROL.listar(texto));
        TableRowSorter orden = new TableRowSorter(tablaListado.getModel());
        tablaListado.setRowSorter(orden);
        txtTotalRegistros.setText("Mostrado " + this.CONTROL.totalMostrados() + " de un total de "
                                 + this.CONTROL.total() + " registros");
        
    }
    
    //método para las ventanas emergentes
    private void mensajeError(String mensaje){
        JOptionPane.showMessageDialog(this, mensaje,"ERROR",JOptionPane.ERROR_MESSAGE);
    }
    private void mensajeOk(String mensaje){
        JOptionPane.showMessageDialog(this, mensaje,"Exitoso",JOptionPane.INFORMATION_MESSAGE);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabGeneral = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        btnNuevo = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaListado = new javax.swing.JTable();
        btnDesactivar = new javax.swing.JButton();
        btnActivar = new javax.swing.JButton();
        txtTotalRegistros = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDescripcion = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        txtID = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Formulario de Categorias", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Categorias");
        setToolTipText("");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/presentacion/imagenes/add-folder.png"))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Escriba la Categoria");

        txtBuscar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtBuscar.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtBuscar.setText("Buscar...");
        txtBuscar.setToolTipText("");
        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBuscarKeyPressed(evt);
            }
        });

        btnBuscar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/presentacion/imagenes/search.png"))); // NOI18N
        btnBuscar.setText("Buscar Categoria");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnNuevo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/presentacion/imagenes/add-folder.png"))); // NOI18N
        btnNuevo.setText("Registrar Categoria");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btnEditar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/presentacion/imagenes/edit.png"))); // NOI18N
        btnEditar.setText("Editar Categoria ");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        tablaListado.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        tablaListado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tablaListado);

        btnDesactivar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/presentacion/imagenes/dislike.png"))); // NOI18N
        btnDesactivar.setText("Desactivar Categoria");
        btnDesactivar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesactivarActionPerformed(evt);
            }
        });

        btnActivar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/presentacion/imagenes/check.png"))); // NOI18N
        btnActivar.setText("Activar Categoria");
        btnActivar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActivarActionPerformed(evt);
            }
        });

        txtTotalRegistros.setText("Total de Registros:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnBuscar)
                                .addGap(18, 18, 18)
                                .addComponent(btnNuevo)
                                .addGap(18, 18, 18)
                                .addComponent(btnEditar)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(btnDesactivar)
                        .addGap(18, 18, 18)
                        .addComponent(btnActivar)
                        .addGap(210, 210, 210)
                        .addComponent(txtTotalRegistros, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar)
                    .addComponent(btnNuevo)
                    .addComponent(btnEditar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDesactivar)
                    .addComponent(btnActivar)
                    .addComponent(txtTotalRegistros))
                .addGap(92, 92, 92))
        );

        tabGeneral.addTab("Lista de Categorias", jPanel1);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Nombre de Categoria(*)");

        txtNombre.setForeground(new java.awt.Color(204, 204, 204));
        txtNombre.setText("Escriba la Categoria");
        txtNombre.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtNombreFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNombreFocusLost(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Descripción:");

        txtDescripcion.setColumns(20);
        txtDescripcion.setRows(5);
        jScrollPane2.setViewportView(txtDescripcion);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("(*) Inidica que es un campo obligatorio");

        btnGuardar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/presentacion/imagenes/save.png"))); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnCancelar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/presentacion/imagenes/cancel.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnGuardar)
                        .addGap(75, 75, 75)
                        .addComponent(btnCancelar))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
                            .addComponent(txtNombre)
                            .addComponent(jScrollPane2))
                        .addGap(28, 28, 28)
                        .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(283, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addGap(52, 52, 52)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        tabGeneral.addTab("Formulario de Categoria", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabGeneral)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabGeneral)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNombreFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNombreFocusGained
        if(txtNombre.getText().equals("Escriba la Categoria")){
            txtNombre.setText("");
            txtNombre.setForeground(new Color(153,153,153));
        }
    }//GEN-LAST:event_txtNombreFocusGained

    private void txtNombreFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNombreFocusLost
        if(txtNombre.getText().equals("Escriba la Categoria")){
            txtNombre.setText("Escriba la Categoria");
            txtNombre.setForeground(new Color(153,153,153));
        }
    }//GEN-LAST:event_txtNombreFocusLost

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        this.listar(txtBuscar.getText());
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void txtBuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyPressed
        
    }//GEN-LAST:event_txtBuscarKeyPressed

    private void btnDesactivarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesactivarActionPerformed
        if(tablaListado.getSelectedRowCount() == 1){
            String id = String.valueOf(tablaListado.getValueAt(tablaListado.getSelectedRow(), 0));
            String nombre = String.valueOf(tablaListado.getValueAt(tablaListado.getSelectedRow(), 1));
            if(JOptionPane.showConfirmDialog(this, "Deseas desactivar el registros: " + nombre + " ?", "Desactivar",JOptionPane.YES_NO_OPTION)==0){
                String resp=this.CONTROL.desactivar(Integer.parseInt(id));
                if(resp.equals("OK")){
                    this.mensajeOk("Registro desactivado");
                    this.listar("");
                }else{
                    this.mensajeError(resp);
                }
                
            }
        }else{
            this.mensajeError("Selecciona 1 registro para desactivar");
        }
        
    }//GEN-LAST:event_btnDesactivarActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        tabGeneral.setEnabledAt(1, true);
        tabGeneral.setEnabledAt(0, false);
        tabGeneral.setSelectedIndex(1);
        this.accion = "guardar";
        btnGuardar.setText("Guardar");
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        tabGeneral.setEnabledAt(0, true);
        tabGeneral.setEnabledAt(1, false);
        tabGeneral.setSelectedIndex(0);
        
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if(txtNombre.getText().length() == 0 || txtNombre.getText().length() > 20){
            JOptionPane.showMessageDialog(this, "Debes ingresar un nombre y no debe ser mayor a 20 caracteres,"
                    + " es obligatorio ","Advertencia" ,JOptionPane.WARNING_MESSAGE);
            txtNombre.requestFocus();
            return;
        }
        if(txtDescripcion.getText().length() == 0 || txtDescripcion.getText().length() > 255){
            JOptionPane.showMessageDialog(this, "Debes ingresar una descripcion y no debe ser mayor a 255 caracteres,"
                    + " es obligatorio ","Advertencia" ,JOptionPane.WARNING_MESSAGE);
            txtDescripcion.requestFocus();
            return;
        }
        String resp;
        if(this.accion.equals("editar")){
            //condicional para editar
            resp = this.CONTROL.actualizar(Integer.parseInt(txtID.getText()), txtNombre.getText(), this.nombreAnt, txtDescripcion.getText());
            if(resp.equals("OK")){
                this.mensajeOk("Actualizado Correctamente");
                this.listar("");
                tabGeneral.setSelectedIndex(0);
                tabGeneral.setEnabledAt(1, false);
                tabGeneral.setEnabledAt(0, true);
            }else{
                this.mensajeError(resp);
            }
        }else{
            //condicionar para guardar
            resp = this.CONTROL.insertar(txtNombre.getText(), txtDescripcion.getText());
            if(resp.equals("OK")){
                this.mensajeOk("Registrado correctamente");
                this.listar("");
                tabGeneral.setSelectedIndex(0);
                tabGeneral.setEnabledAt(1, false);
                tabGeneral.setEnabledAt(0, true);
            }else{
                this.mensajeError(resp);
            }
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        if(tablaListado.getSelectedRowCount() == 1){
            String id = String.valueOf(tablaListado.getValueAt(tablaListado.getSelectedRow(), 0));
            String nombre = String.valueOf(tablaListado.getValueAt(tablaListado.getSelectedRow(), 1));
            this.nombreAnt = String.valueOf(tablaListado.getValueAt(tablaListado.getSelectedRow(), 1));
            String descripcion = String.valueOf(tablaListado.getValueAt(tablaListado.getSelectedRow(), 2));
            
            txtID.setText(id);
            txtNombre.setText(nombre);
            txtDescripcion.setText(descripcion);
            
            tabGeneral.setEnabledAt(0, false);
            tabGeneral.setEnabledAt(1, true);
            tabGeneral.setSelectedIndex(1);
            this.accion = "editar";
            btnGuardar.setText("Editar");
            
        }else{
            this.mensajeError("Seleccionar 1 registro para editar");
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnActivarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActivarActionPerformed
      if(tablaListado.getSelectedRowCount() == 1){
            String id = String.valueOf(tablaListado.getValueAt(tablaListado.getSelectedRow(), 0));
            String nombre = String.valueOf(tablaListado.getValueAt(tablaListado.getSelectedRow(), 1));
            if(JOptionPane.showConfirmDialog(this, "Deseas activar el registros: " + nombre + " ?", "Desactivar",JOptionPane.YES_NO_OPTION)==0){
                String resp=this.CONTROL.activar(Integer.parseInt(id));
                System.out.println("ID: "+resp);
                if(resp.equals("OK")){
                    this.mensajeOk("Registro activado");
                    this.listar("");
                }else{
                    this.mensajeError(resp);
                }
            }
        }else{
            this.mensajeError("Selecciona 1 registro para desactivar");
        }
    }//GEN-LAST:event_btnActivarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActivar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnDesactivar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane tabGeneral;
    private javax.swing.JTable tablaListado;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextArea txtDescripcion;
    private javax.swing.JLabel txtID;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JLabel txtTotalRegistros;
    // End of variables declaration//GEN-END:variables
}
