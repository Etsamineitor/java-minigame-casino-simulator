/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package capa_presentacion;

import Complemento.Funciones;
import capa_datos.clsMaterialDAO;
import capa_logica.clsMaterial;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**

 */
public class frmManMateriales extends javax.swing.JDialog {

    private int posActual = -1;
    private boolean modoNuevo = true;
    private boolean datosPendientes = false;
    private static final String CARPETA = "src/Construccion";

    /**
     * Creates new form frmManLibros
     */
    public frmManMateriales(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        listado();
        prepararNuevoCodigo();

        this.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        this.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                confirmarSalida();
            }
        });
    }

    private void confirmarSalida() {

        if (datosPendientes) {
            int resp = JOptionPane.showConfirmDialog(
                    this,
                    "Hay datos no guardados.\n¿Desea salir del mantenimiento de Materiales?",
                    "Advertencia",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.WARNING_MESSAGE
            );

            if (resp == JOptionPane.YES_OPTION) {
                dispose();
            }
        } else {
            dispose();
        }
    }

    private boolean validarCamposVacios() {
        if (txtCodigo.getText().trim().isEmpty()
                || txtNombre.getText().trim().isEmpty()
                || txtUnidad.getText().trim().isEmpty()
                || txtCosto.getText().trim().isEmpty()
                || txtStock.getText().trim().isEmpty()) {

            JOptionPane.showMessageDialog(this,
                    "Faltan datos",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    private boolean validarCodigoNumerico() {
        if (!txtCodigo.getText().trim().matches("\\d+")) {
            JOptionPane.showMessageDialog(this,
                    "El código debe ser numérico",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            txtCodigo.requestFocus();
            return false;
        }
        return true;
    }

    private boolean validarNumerosCostoStock() {
        if (!txtStock.getText().trim().matches("\\d+")) {
            JOptionPane.showMessageDialog(this,
                    "El stock debe ser numérico",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            txtStock.requestFocus();
            return false;
        }

        try {
            double costo = Double.parseDouble(txtCosto.getText().trim());
            if (costo <= 0) {
                JOptionPane.showMessageDialog(this,
                        "El costo debe ser mayor a 0",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
                txtCosto.requestFocus();
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                    "El costo debe ser numérico (ej: 45.50)",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            txtCosto.requestFocus();
            return false;
        }

        int stock = Integer.parseInt(txtStock.getText().trim());
        if (stock < 0) {
            JOptionPane.showMessageDialog(this,
                    "El stock no puede ser negativo",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            txtStock.requestFocus();
            return false;
        }

        return true;
    }

    private void limpiar() {
        txtNombre.setText("");
        txtUnidad.setText("");
        txtCosto.setText("");
        txtStock.setText("");
        chkActivo.setSelected(true);

        prepararNuevoCodigo();
    }

    private void prepararNuevoCodigo() {
        modoNuevo = true;
        posActual = -1;

        txtCodigo.setText(String.valueOf(clsMaterialDAO.generarCodigo()));
        txtCodigo.setEditable(false);
        btnBuscar.setEnabled(false);

        txtNombre.requestFocus();
    }

    private void activarModoBusqueda() {
        modoNuevo = false;
        posActual = -1;

        txtCodigo.setText("");
        txtCodigo.setEditable(true);
        btnBuscar.setEnabled(true);

        txtNombre.setText("");
        txtUnidad.setText("");
        txtCosto.setText("");
        txtStock.setText("");
        chkActivo.setSelected(true);

        txtCodigo.requestFocus();
    }

    private void listado() {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Código");
        modelo.addColumn("Nombre");
        modelo.addColumn("Unidad");
        modelo.addColumn("Costo");
        modelo.addColumn("Stock");
        modelo.addColumn("Estado");

        for (clsMaterial m : clsMaterialDAO.obtener()) {
            String estado = m.isActivo() ? "Vigente" : "No vigente";
            modelo.addRow(new Object[]{
                m.getCodigo(),
                m.getNombre(),
                m.getUnidad(),
                m.getCosto(),
                m.getStock(),
                estado
            });
        }

        tblMateriales.setModel(modelo);
    }

    private void cargarDesdeTabla() {
        int fila = tblMateriales.getSelectedRow();
        if (fila == -1) {
            return;
        }

        activarModoBusqueda();
        txtCodigo.setText(tblMateriales.getValueAt(fila, 0).toString());
        btnBuscarActionPerformed(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblMarcas = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        Codigo = new javax.swing.JLabel();
        Titulo = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        Estado = new javax.swing.JLabel();
        chkActivo = new javax.swing.JCheckBox();
        btnBuscar = new javax.swing.JToggleButton();
        Autor = new javax.swing.JLabel();
        txtUnidad = new javax.swing.JTextField();
        Editorial = new javax.swing.JLabel();
        txtCosto = new javax.swing.JTextField();
        Stock = new javax.swing.JLabel();
        txtStock = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblMateriales = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        btnNuevo = new javax.swing.JToggleButton();
        btnModificar = new javax.swing.JToggleButton();
        btnEliminar = new javax.swing.JToggleButton();
        btnLimpiar = new javax.swing.JToggleButton();
        btnDarBaja = new javax.swing.JToggleButton();
        btnCerrar = new javax.swing.JToggleButton();

        tblMarcas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblMarcas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblMarcasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblMarcas);

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mouseCliked(evt);
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                WindowClosing(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(153, 51, 0));
        jPanel3.setForeground(new java.awt.Color(51, 0, 153));

        jLabel6.setFont(new java.awt.Font("Eras Bold ITC", 0, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("MANTENIMIENTO DE MATERIALES");

        jLabel4.setForeground(new java.awt.Color(0, 51, 102));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(191, 191, 191)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 467, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(367, 367, 367)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 586, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel1.setBackground(new java.awt.Color(246, 179, 145));

        Codigo.setFont(new java.awt.Font("Segoe Print", 0, 14)); // NOI18N
        Codigo.setText("Codigo:");

        Titulo.setFont(new java.awt.Font("Segoe Print", 0, 14)); // NOI18N
        Titulo.setText("Nombre:");

        txtCodigo.addActionListener(this::txtCodigoActionPerformed);

        txtNombre.addActionListener(this::txtNombreActionPerformed);

        Estado.setFont(new java.awt.Font("Segoe Print", 0, 14)); // NOI18N
        Estado.setText("Estado:");

        chkActivo.setBackground(new java.awt.Color(255, 255, 255));
        chkActivo.setFont(new java.awt.Font("Segoe Print", 0, 14)); // NOI18N
        chkActivo.setText("Vigente");
        chkActivo.addActionListener(this::chkActivoActionPerformed);

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Recursos/lupa (1).png"))); // NOI18N
        btnBuscar.addActionListener(this::btnBuscarActionPerformed);

        Autor.setFont(new java.awt.Font("Segoe Print", 0, 14)); // NOI18N
        Autor.setText("Unidad:");

        txtUnidad.addActionListener(this::txtUnidadActionPerformed);

        Editorial.setFont(new java.awt.Font("Segoe Print", 0, 14)); // NOI18N
        Editorial.setText("Costo:");

        txtCosto.addActionListener(this::txtCostoActionPerformed);

        Stock.setFont(new java.awt.Font("Segoe Print", 0, 14)); // NOI18N
        Stock.setText("Stock:");

        txtStock.addActionListener(this::txtStockActionPerformed);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Recursos/2.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtNombre)
                        .addComponent(txtUnidad)
                        .addComponent(txtCosto)
                        .addComponent(txtCodigo)
                        .addComponent(txtStock)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(Codigo)
                                .addComponent(Autor, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(Editorial, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(Titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(Stock, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(0, 0, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(Estado, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(chkActivo)
                        .addGap(137, 137, 137)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(Codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Titulo)
                        .addGap(9, 9, 9)
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Autor, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtUnidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Editorial, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCosto, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Stock, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Estado)
                            .addComponent(chkActivo)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tblMateriales.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblMateriales.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblMaterialesMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tblMaterialesMouseEntered(evt);
            }
        });
        jScrollPane2.setViewportView(tblMateriales);

        jPanel2.setBackground(new java.awt.Color(204, 102, 0));

        btnNuevo.setFont(new java.awt.Font("Segoe Print", 0, 14)); // NOI18N
        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Recursos/Materiales.png"))); // NOI18N
        btnNuevo.setText(" Nuevo");
        btnNuevo.addActionListener(this::btnNuevoActionPerformed);

        btnModificar.setFont(new java.awt.Font("Segoe Print", 0, 14)); // NOI18N
        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Recursos/EditarConstru.png"))); // NOI18N
        btnModificar.setText("Modificar");
        btnModificar.addActionListener(this::btnModificarActionPerformed);

        btnEliminar.setFont(new java.awt.Font("Segoe Print", 0, 14)); // NOI18N
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Recursos/borrar.png"))); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(this::btnEliminarActionPerformed);

        btnLimpiar.setFont(new java.awt.Font("Segoe Print", 0, 14)); // NOI18N
        btnLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Recursos/LimpiarCliente.png"))); // NOI18N
        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(this::btnLimpiarActionPerformed);

        btnDarBaja.setFont(new java.awt.Font("Segoe Print", 0, 14)); // NOI18N
        btnDarBaja.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Recursos/Darbaja.png"))); // NOI18N
        btnDarBaja.setText("Dar de Baja");
        btnDarBaja.addActionListener(this::btnDarBajaActionPerformed);

        btnCerrar.setFont(new java.awt.Font("Segoe Print", 0, 14)); // NOI18N
        btnCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Recursos/CerrarCliente.png"))); // NOI18N
        btnCerrar.setText("Cerrar");
        btnCerrar.addActionListener(this::btnCerrarActionPerformed);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(10, 10, 10)
                            .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnModificar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDarBaja, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCerrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(12, 12, 12))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnNuevo, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                    .addComponent(btnModificar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
                    .addComponent(btnDarBaja, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(13, 13, 13)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnLimpiar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCerrar, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2))
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 1029, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoActionPerformed

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
        datosPendientes = true;
    }//GEN-LAST:event_txtNombreActionPerformed

    private void chkActivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkActivoActionPerformed
        // TODO add your handling code here:
        datosPendientes = true;
    }//GEN-LAST:event_chkActivoActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:        
        if (txtCodigo.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese el código",
                    "Error", JOptionPane.ERROR_MESSAGE);
            posActual = -1;
            return;
        }
        if (!validarCodigoNumerico()) {
            posActual = -1;
            return;
        }

        int codigo = Integer.parseInt(txtCodigo.getText().trim());
        int pos = clsMaterialDAO.posicion(codigo);

        if (pos == -1) {
            JOptionPane.showMessageDialog(this, "Material no encontrado",
                    "Error", JOptionPane.ERROR_MESSAGE);
            posActual = -1;
            return;
        }

        clsMaterial m = clsMaterialDAO.obtener().get(pos);

        txtNombre.setText(m.getNombre());
        txtUnidad.setText(m.getUnidad());
        txtCosto.setText(String.valueOf(m.getCosto()));
        txtStock.setText(String.valueOf(m.getStock()));
        chkActivo.setSelected(m.isActivo());

        posActual = pos;
        modoNuevo = false;

        txtCodigo.setEditable(true);
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void txtUnidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUnidadActionPerformed
        // TODO add your handling code here:
        datosPendientes = true;
    }//GEN-LAST:event_txtUnidadActionPerformed

    private void tblMarcasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMarcasMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tblMarcasMouseClicked

    private void tblMaterialesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMaterialesMouseClicked
        // TODO add your handling code here:
        cargarDesdeTabla();
    }//GEN-LAST:event_tblMaterialesMouseClicked

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        // TODO add your handling code here:
        if (!modoNuevo) {
            prepararNuevoCodigo();
            return;
        }

        if (!validarCamposVacios()) {
            return;
        }
        if (!validarNumerosCostoStock()) {
            return;
        }

        int codigo = Integer.parseInt(txtCodigo.getText().trim());
        String nombre = txtNombre.getText().trim().toUpperCase();
        String unidad = txtUnidad.getText().trim();
        double costo = Double.parseDouble(txtCosto.getText().trim());
        int stock = Integer.parseInt(txtStock.getText().trim());
        boolean estado = chkActivo.isSelected();

        if (clsMaterialDAO.existeNombre(nombre)) {
            JOptionPane.showMessageDialog(this,
                    "Ya existe un material con ese nombre",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            txtNombre.requestFocus();
            return;
        }

        int resp = Funciones.dialogoPregunta("¿Desea registrar este material?");
        if (resp != 0) {
            return;
        }

        clsMaterial nuevo = new clsMaterial(
                codigo,
                nombre,
                unidad,
                costo,
                stock,
                estado
        );

        clsMaterialDAO.agregar(nuevo);
        clsMaterialDAO.grabar();

        JOptionPane.showMessageDialog(this,
                "Material registrado correctamente",
                "Mensaje",
                JOptionPane.INFORMATION_MESSAGE);

        listado();
        limpiar();
    }//GEN-LAST:event_btnNuevoActionPerformed


    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        // TODO add your handling code here:
        int fila = tblMateriales.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(this,
                    "Seleccione un material para modificar",
                    "Error",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (!validarCamposVacios()) {
            return;
        }
        if (!validarCodigoNumerico()) {
            return;
        }
        if (!validarNumerosCostoStock()) {
            return;
        }

        clsMaterial m = clsMaterialDAO.obtener().get(fila);

        int codigo = Integer.parseInt(txtCodigo.getText().trim());
        String nombre = txtNombre.getText().trim().toUpperCase();
        String unidad = txtUnidad.getText().trim();
        double costo = Double.parseDouble(txtCosto.getText().trim());
        int stock = Integer.parseInt(txtStock.getText().trim());
        boolean estado = chkActivo.isSelected();

        boolean sinCambios
                = m.getCodigo() == codigo
                && m.getNombre().equals(nombre)
                && m.getUnidad().equals(unidad)
                && m.getCosto() == costo
                && m.getStock() == stock
                && m.isActivo() == estado;

        if (sinCambios) {
            JOptionPane.showMessageDialog(this,
                    "No has modificado ningún dato",
                    "Aviso",
                    JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        int resp = JOptionPane.showOptionDialog(this,
                "¿Está seguro que desea modificar este material?",
                "Confirmación",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                new Object[]{"Sí", "No"},
                "No");

        if (resp != JOptionPane.YES_OPTION) {
            return;
        }

        clsMaterial nuevo = new clsMaterial(
                codigo,
                nombre,
                unidad,
                costo,
                stock,
                estado
        );

        clsMaterialDAO.modificar(fila, nuevo);
        clsMaterialDAO.grabar();

        JOptionPane.showMessageDialog(this,
                "Material modificado correctamente",
                "Mensaje",
                JOptionPane.INFORMATION_MESSAGE);

        listado();
        limpiar();
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        if (txtCodigo.getText().trim().isEmpty() || !validarCodigoNumerico()) {
            JOptionPane.showMessageDialog(this,
                    "Ingrese un código válido",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        int codigo = Integer.parseInt(txtCodigo.getText().trim());
        int pos = clsMaterialDAO.posicion(codigo);

        if (pos == -1) {
            JOptionPane.showMessageDialog(this,
                    "Material no encontrado",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        int op = Funciones.dialogoPregunta("¿Está seguro de eliminar este material?");
        if (op != 0) {
            return;
        }

        clsMaterialDAO.eliminar(pos);
        clsMaterialDAO.grabar();

        JOptionPane.showMessageDialog(this,
                "Material eliminado",
                "Mensaje",
                JOptionPane.INFORMATION_MESSAGE);

        listado();
        limpiar();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        // TODO add your handling code here:
        // Preguntamos antes de actuar
    int respuesta = JOptionPane.showConfirmDialog(
            this, 
            "¿Desea borrar todos los datos escritos?", 
            "Confirmar", 
            JOptionPane.YES_NO_OPTION
    );

    if (respuesta == JOptionPane.YES_OPTION) {
        limpiar(); // Aquí llamas a tu método
    }
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnDarBajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDarBajaActionPerformed
        // TODO add your handling code here:
        if (txtCodigo.getText().trim().isEmpty() || !validarCodigoNumerico()) {
            JOptionPane.showMessageDialog(this,
                    "Ingrese un código válido",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        int codigo = Integer.parseInt(txtCodigo.getText().trim());
        int pos = clsMaterialDAO.posicion(codigo);

        if (pos == -1) {
            JOptionPane.showMessageDialog(this,
                    "Material no encontrado",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        int op = Funciones.dialogoPregunta("¿Está seguro de dar de baja este material?");
        if (op != 0) {
            return;
        }

        clsMaterialDAO.darBaja(pos);
        clsMaterialDAO.grabar();

        JOptionPane.showMessageDialog(this,
                "Material dado de baja",
                "Mensaje",
                JOptionPane.INFORMATION_MESSAGE);

        listado();
        limpiar();
    }//GEN-LAST:event_btnDarBajaActionPerformed

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        // TODO add your handling code here:
        int respuesta = JOptionPane.showConfirmDialog(
            this, 
            "¿Está seguro de que desea cerrar la ventana de Mantenimiento Materiales?", 
            "Confirmar Salida", 
            JOptionPane.YES_NO_OPTION, 
            JOptionPane.QUESTION_MESSAGE
    );

    if (respuesta == JOptionPane.YES_OPTION) {
        this.dispose(); // Cierra solo esta ventana
    }

    }//GEN-LAST:event_btnCerrarActionPerformed

    private void tblMaterialesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMaterialesMouseEntered
        // TODO add your handling code here:
        cargarDesdeTabla();
    }//GEN-LAST:event_tblMaterialesMouseEntered

    private void txtCostoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCostoActionPerformed
        // TODO add your handling code here:
        datosPendientes = true;
    }//GEN-LAST:event_txtCostoActionPerformed

    private void txtStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtStockActionPerformed
        // TODO add your handling code here:
        datosPendientes = true;
    }//GEN-LAST:event_txtStockActionPerformed

    private void mouseCliked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mouseCliked
      // TODO add your handling code here:
        int respuesta = JOptionPane.showConfirmDialog(
            this, 
            "¿Está seguro de que desea cerrar la ventana de Mantenimiento Materiales?", 
            "Confirmar Salida", 
            JOptionPane.YES_NO_OPTION, 
            JOptionPane.QUESTION_MESSAGE
    );

    if (respuesta == JOptionPane.YES_OPTION) {
        this.dispose(); // Cierra solo esta ventana
    }
    }//GEN-LAST:event_mouseCliked

    private void WindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_WindowClosing
        // TODO add your handling code here:
        verificion();
    }//GEN-LAST:event_WindowClosing
    
    private void verificion(){
    // TODO add your handling code here:
        int respuesta = JOptionPane.showConfirmDialog(
            this, 
            "¿Está seguro de que desea cerrar la ventana de Mantenimiento Materiales?", 
            "Confirmar Salida", 
            JOptionPane.YES_NO_OPTION, 
            JOptionPane.QUESTION_MESSAGE
    );

    if (respuesta == JOptionPane.YES_OPTION) {
        this.dispose(); // Cierra solo esta ventana
    }
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Autor;
    private javax.swing.JLabel Codigo;
    private javax.swing.JLabel Editorial;
    private javax.swing.JLabel Estado;
    private javax.swing.JLabel Stock;
    private javax.swing.JLabel Titulo;
    private javax.swing.JToggleButton btnBuscar;
    private javax.swing.JToggleButton btnCerrar;
    private javax.swing.JToggleButton btnDarBaja;
    private javax.swing.JToggleButton btnEliminar;
    private javax.swing.JToggleButton btnLimpiar;
    private javax.swing.JToggleButton btnModificar;
    private javax.swing.JToggleButton btnNuevo;
    private javax.swing.JCheckBox chkActivo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblMarcas;
    private javax.swing.JTable tblMateriales;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtCosto;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtStock;
    private javax.swing.JTextField txtUnidad;
    // End of variables declaration//GEN-END:variables
}
