/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package capa_presentacion;

import capa_datos.clsMaterialDAO;
import capa_datos.clsPedidoDAO;
import capa_datos.clsProyectoDAO;
import capa_logica.clsDetallePedido;
import capa_logica.clsMaterial;
import capa_logica.clsPedido;
import capa_logica.clsProyecto;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**

 */
public class jdPedido extends javax.swing.JFrame {

    private DefaultTableModel modelo;
    private boolean pedidoBuscado = false;
    private boolean datosPendientes = false;

    public jdPedido(java.awt.Frame parent, boolean modal) {
        initComponents();
        inicializar();

        java.util.Date hoy = new java.util.Date();
        dtFecha.setDate(hoy);
        dtFecha.setMinSelectableDate(hoy);
        dtFecha.setMaxSelectableDate(hoy);

        txtPedido.setEditable(false);

        txtUnidad.setEditable(false);
        txtPrecioU.setEditable(false);
        txtCodigo.setEditable(false);
        txtStock.setEditable(false);

        dtFecha.setEnabled(true);
        cboMaterial.setEnabled(true);
        txtCantidad.setEditable(true);
        clsPedidoDAO.recuperar();

        txtPedido.setText(String.valueOf(clsPedidoDAO.siguienteId()));

        txtPedido.setEditable(false);

        this.setLocationRelativeTo(null);

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent evt) {
                
            }
        });
    }

    private void inicializar() {
        configurarTabla();
        cargarCombos();
        limpiarTodoAlInicio();
    }

    private void limpiarTodoAlInicio() {
        // Limpiar textos
        txtPedido.setText("");
        txtCodigo.setText("");
        txtUnidad.setText("");
        txtPrecioU.setText("");
        txtStock.setText("");
        txtCantidad.setText("");

        // Limpiar combos
        cboMaterial.setSelectedIndex(-1);
        cboSector.setSelectedIndex(-1);

        // Limpiar Fecha (si usas JDateChooser)
        dtFecha.setDate(null);

        // Limpiar tabla por si acaso
        modelo.setRowCount(0);
    }

    private void configurarTabla() {
        modelo = new DefaultTableModel();
        modelo.addColumn("ID PEDIDO");
        modelo.addColumn("COD MATERIAL");
        modelo.addColumn("FECHA");
        modelo.addColumn("PROYECTO");
        modelo.addColumn("MATERIAL");
        modelo.addColumn("UNIDAD");
        modelo.addColumn("CANTIDAD");
        modelo.addColumn("PRECIO");
        modelo.addColumn("SUBTOTAL");
        tblPedido.setModel(modelo);
    }

    private void cargarCombos() {
        clsMaterialDAO.recuperar();
        clsProyectoDAO.recuperar();

        cboMaterial.removeAllItems();
        cboSector.removeAllItems();

        for (clsMaterial m : clsMaterialDAO.listarActivos()) {
            cboMaterial.addItem(m.getNombre());
        }
        for (clsProyecto p : clsProyectoDAO.listarVigentes()) {
            cboSector.addItem(p.getNombre());
        }

        cboMaterial.setSelectedIndex(-1);
        cboSector.setSelectedIndex(-1);
    }

    private void configurarFecha() {
        Calendar hoy = Calendar.getInstance();
        Calendar min = (Calendar) hoy.clone();
        min.add(Calendar.DAY_OF_MONTH, 15);
        Calendar max = (Calendar) hoy.clone();
        max.add(Calendar.DAY_OF_MONTH, 20);

        dtFecha.setMinSelectableDate(min.getTime());
        dtFecha.setMaxSelectableDate(max.getTime());
        dtFecha.setDate(min.getTime());
    }

    private void generarNuevoIdPedido() {
        clsPedidoDAO.recuperar();
        txtPedido.setText(String.valueOf(clsPedidoDAO.siguienteId()));
    }

    private void confirmarSalida() {
    // Obtenemos el modelo para ver si hay filas en la tabla
    javax.swing.table.DefaultTableModel modelo = (javax.swing.table.DefaultTableModel) tblPedido.getModel();

    if (modelo.getRowCount() > 0) {
        // CASO 2: Hay datos sin registrar
        int respuesta = javax.swing.JOptionPane.showConfirmDialog(
                this,
                "Los datos en la tabla NO se han guardado.\n¿Desea salir y regresar al Menú de Opciones?",
                "Advertencia: Datos pendientes",
                javax.swing.JOptionPane.YES_NO_OPTION,
                javax.swing.JOptionPane.WARNING_MESSAGE);

        if (respuesta == javax.swing.JOptionPane.YES_OPTION) {
            this.dispose(); // Cierra esta ventana y libera memoria, regresando al padre (Menú)
        }
    } else {
        // CASO 1: No hay datos, salida limpia
        int respuesta = javax.swing.JOptionPane.showConfirmDialog(
                this,
                "¿Desea salir del reporte de pedidos y volver al Menú?",
                "Confirmar",
                javax.swing.JOptionPane.YES_NO_OPTION,
                javax.swing.JOptionPane.QUESTION_MESSAGE);

        if (respuesta == javax.swing.JOptionPane.YES_OPTION) {
            this.dispose(); // Regresa al menú
        }
    }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtPedido = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cboMaterial = new javax.swing.JComboBox<>();
        txtCantidad = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtStock = new javax.swing.JTextField();
        btnAgregarMaterial = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminarPedido = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPedido = new javax.swing.JTable();
        btnRegistroPedido = new javax.swing.JButton();
        btnSalirRegistro = new javax.swing.JButton();
        cboSector = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        txtPrecioU = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtUnidad = new javax.swing.JTextField();
        btnBuscarPedido = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        btnEliminarRegistro = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        dtFecha = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                WindowClosing(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(0, 204, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 3, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("REGISTRO DE PEDIDOS");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(300, 300, 300)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        jPanel2.setBackground(new java.awt.Color(153, 204, 255));

        jLabel2.setFont(new java.awt.Font("Segoe Print", 0, 12)); // NOI18N
        jLabel2.setText("ID PEDIDO:");

        txtPedido.setFont(new java.awt.Font("Segoe Print", 0, 10)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Segoe Print", 0, 12)); // NOI18N
        jLabel3.setText("SECTOR DE ENTREGA:");

        jLabel4.setFont(new java.awt.Font("Segoe Print", 0, 12)); // NOI18N
        jLabel4.setText("FECHA DEL PEDIDO :");

        jPanel3.setBackground(new java.awt.Color(0, 51, 153));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 23, Short.MAX_VALUE)
        );

        jLabel5.setFont(new java.awt.Font("Segoe Print", 0, 12)); // NOI18N
        jLabel5.setText("MATERIAL:");

        jLabel6.setFont(new java.awt.Font("Segoe Print", 0, 12)); // NOI18N
        jLabel6.setText("CANTIDAD DESEADA:");

        cboMaterial.setFont(new java.awt.Font("Segoe Print", 0, 12)); // NOI18N
        cboMaterial.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboMaterial.addItemListener(this::cboMaterialItemStateChanged);
        cboMaterial.addActionListener(this::cboMaterialActionPerformed);

        txtCantidad.setFont(new java.awt.Font("Segoe Print", 0, 12)); // NOI18N
        txtCantidad.addActionListener(this::txtCantidadActionPerformed);

        jLabel7.setFont(new java.awt.Font("Segoe Print", 0, 12)); // NOI18N
        jLabel7.setText("STOCK DISPONIBLES :");

        txtStock.setFont(new java.awt.Font("Segoe Print", 0, 12)); // NOI18N

        btnAgregarMaterial.setFont(new java.awt.Font("Segoe Print", 1, 12)); // NOI18N
        btnAgregarMaterial.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Recursos/Materiales.png"))); // NOI18N
        btnAgregarMaterial.setText("AGREGAR A LA LISTA");
        btnAgregarMaterial.addActionListener(this::btnAgregarMaterialActionPerformed);

        btnModificar.setFont(new java.awt.Font("Segoe Print", 1, 12)); // NOI18N
        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Recursos/EditarConstru.png"))); // NOI18N
        btnModificar.setText("MODIFICAR LISTA");
        btnModificar.addActionListener(this::btnModificarActionPerformed);

        btnEliminarPedido.setFont(new java.awt.Font("Segoe Print", 1, 12)); // NOI18N
        btnEliminarPedido.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Recursos/borrar.png"))); // NOI18N
        btnEliminarPedido.setText("ELIMINAR MATERIAL DE LA LISTA ");
        btnEliminarPedido.addActionListener(this::btnEliminarPedidoActionPerformed);

        jPanel4.setBackground(new java.awt.Color(0, 51, 153));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        jPanel5.setBackground(new java.awt.Color(0, 204, 255));

        tblPedido.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblPedido.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPedidoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblPedido);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 566, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnRegistroPedido.setFont(new java.awt.Font("Segoe Print", 1, 12)); // NOI18N
        btnRegistroPedido.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Recursos/Registrar.png"))); // NOI18N
        btnRegistroPedido.setText("REGISTRAR");
        btnRegistroPedido.addActionListener(this::btnRegistroPedidoActionPerformed);

        btnSalirRegistro.setFont(new java.awt.Font("Segoe Print", 1, 12)); // NOI18N
        btnSalirRegistro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Recursos/CerrarCliente.png"))); // NOI18N
        btnSalirRegistro.setText("SALIR DEL REGISTRO");
        btnSalirRegistro.addActionListener(this::btnSalirRegistroActionPerformed);

        cboSector.setFont(new java.awt.Font("Segoe Print", 0, 10)); // NOI18N
        cboSector.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel8.setFont(new java.awt.Font("Segoe Print", 0, 12)); // NOI18N
        jLabel8.setText("PRECIO UNITARIO:");

        txtPrecioU.setFont(new java.awt.Font("Segoe Print", 0, 12)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Segoe Print", 0, 12)); // NOI18N
        jLabel9.setText("UNIDAD:");

        txtUnidad.setFont(new java.awt.Font("Segoe Print", 0, 12)); // NOI18N

        btnBuscarPedido.setFont(new java.awt.Font("Segoe Print", 1, 12)); // NOI18N
        btnBuscarPedido.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Recursos/buscar2.png"))); // NOI18N
        btnBuscarPedido.setText("BUSCAR REGISTRO");
        btnBuscarPedido.addActionListener(this::btnBuscarPedidoActionPerformed);

        jLabel10.setFont(new java.awt.Font("Segoe Print", 0, 12)); // NOI18N
        jLabel10.setText("CODIGO:");

        txtCodigo.setFont(new java.awt.Font("Segoe Print", 0, 12)); // NOI18N

        btnEliminarRegistro.setFont(new java.awt.Font("Segoe Print", 1, 12)); // NOI18N
        btnEliminarRegistro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Recursos/EliminarRegistro.png"))); // NOI18N
        btnEliminarRegistro.setText("ELIMINAR REGISTRO");
        btnEliminarRegistro.addActionListener(this::btnEliminarRegistroActionPerformed);

        btnLimpiar.setFont(new java.awt.Font("Segoe Print", 1, 12)); // NOI18N
        btnLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Recursos/LimpiarCliente.png"))); // NOI18N
        btnLimpiar.setText("LIMPIAR");
        btnLimpiar.addActionListener(this::btnLimpiarActionPerformed);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtPedido)
                                .addGap(187, 187, 187)))
                        .addComponent(dtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cboSector, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(btnLimpiar)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(btnRegistroPedido)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnBuscarPedido)
                        .addGap(18, 18, 18)
                        .addComponent(btnEliminarRegistro)
                        .addGap(18, 18, 18)
                        .addComponent(btnSalirRegistro)
                        .addGap(15, 15, 15))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(btnAgregarMaterial)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnEliminarPedido)
                                .addGap(32, 32, 32)
                                .addComponent(btnModificar))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel5)
                                            .addComponent(jLabel10))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(cboMaterial, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jLabel9)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtUnidad))
                                            .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtStock)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel8))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtCantidad)
                                    .addComponent(txtPrecioU, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(30, 30, 30))))
            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(cboSector, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(dtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))))
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cboMaterial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel9)
                            .addComponent(txtUnidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txtPrecioU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(52, 52, 52)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel7)
                                .addComponent(txtStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel6)
                            .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(35, 35, 35)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregarMaterial)
                    .addComponent(btnEliminarPedido)
                    .addComponent(btnModificar))
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(117, 117, 117)
                        .addComponent(btnLimpiar)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnRegistroPedido)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnSalirRegistro)
                        .addComponent(btnEliminarRegistro)
                        .addComponent(btnBuscarPedido)))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void btnRegistroPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistroPedidoActionPerformed
        if (modelo.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "No hay materiales en el pedido");
            return;
        }

        if (cboSector.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un proyecto");
            return;
        }

        if (dtFecha.getDate() == null) {
            JOptionPane.showMessageDialog(this, "Seleccione la fecha del pedido");
            return;
        }

        clsPedidoDAO.recuperar();
        clsProyectoDAO.recuperar();

        clsProyecto proyecto = clsProyectoDAO.buscar(
                cboSector.getSelectedIndex() + 1
        );

        clsPedido pedido = new clsPedido(
                Integer.parseInt(txtPedido.getText()),
                proyecto.getIdProyecto(),
                proyecto.getNombre(),
                dtFecha.getDate(),
                true
        );

        for (int i = 0; i < modelo.getRowCount(); i++) {
            pedido.agregarDetalle(new clsDetallePedido(
                    Integer.parseInt(modelo.getValueAt(i, 1).toString()),
                    modelo.getValueAt(i, 4).toString(),
                    modelo.getValueAt(i, 5).toString(),
                    Double.parseDouble(modelo.getValueAt(i, 7).toString()),
                    Integer.parseInt(modelo.getValueAt(i, 6).toString())
            ));
        }

        clsPedidoDAO.agregar(pedido);
        clsMaterialDAO.recuperar();

        for (int i = 0; i < pedido.getDetalles().size(); i++) {
            clsDetallePedido d = pedido.getDetalles().get(i);

            clsMaterial m = clsMaterialDAO.buscar(d.getIdMaterial());
            if (m != null) {
                m.setStock(m.getStock() - d.getCantidad());
            }
        }

        clsMaterialDAO.grabar();
        clsPedidoDAO.grabar();

        JOptionPane.showMessageDialog(this, "Pedido registrado correctamente");
        limpiarTodo();
        JOptionPane.showMessageDialog(this, "Pedido registrado correctamente");

        datosPendientes = false;
        limpiarTodo();

    }//GEN-LAST:event_btnRegistroPedidoActionPerformed


    private void btnAgregarMaterialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarMaterialActionPerformed
        if (cboSector.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(this,
                    "Debe seleccionar el proyecto primero",
                    "Aviso",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (cboMaterial.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(this,
                    "Seleccione un material",
                    "Aviso",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (dtFecha.getDate() == null) {
            JOptionPane.showMessageDialog(this,
                    "Seleccione la fecha del pedido",
                    "Aviso",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (txtCantidad.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Ingrese la cantidad deseada",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            txtCantidad.requestFocus();
            return;
        }

        int cantidad;
        try {
            cantidad = Integer.parseInt(txtCantidad.getText().trim());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this,
                    "La cantidad debe ser un número entero",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            txtCantidad.requestFocus();
            return;
        }

        if (cantidad <= 0) {
            JOptionPane.showMessageDialog(this,
                    "La cantidad debe ser mayor a 0",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            txtCantidad.requestFocus();
            return;
        }

        int stock;
        try {
            stock = Integer.parseInt(txtStock.getText().trim());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this,
                    "Error en el stock del material",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (cantidad > stock) {
            JOptionPane.showMessageDialog(this,
                    "Stock insuficiente.\nStock disponible: " + stock,
                    "Advertencia",
                    JOptionPane.WARNING_MESSAGE);
            txtCantidad.requestFocus();
            return;
        }

        int codMaterial = Integer.parseInt(txtCodigo.getText());
        double precio = Double.parseDouble(txtPrecioU.getText());
        String fecha = new SimpleDateFormat("dd/MM/yyyy").format(dtFecha.getDate());

        for (int i = 0; i < modelo.getRowCount(); i++) {
            if (Integer.parseInt(modelo.getValueAt(i, 1).toString()) == codMaterial) {
                JOptionPane.showMessageDialog(this,
                        "Este material ya fue agregado al pedido",
                        "Aviso",
                        JOptionPane.INFORMATION_MESSAGE);
                return;
            }
        }

        Object materialSeleccionado = cboMaterial.getSelectedItem();

        modelo.addRow(new Object[]{
            txtPedido.getText(),
            codMaterial,
            fecha,
            cboSector.getSelectedItem(),
            materialSeleccionado,
            txtUnidad.getText(),
            cantidad,
            precio,
            cantidad * precio
        });

        cboMaterial.removeItem(materialSeleccionado);

        cboSector.setEnabled(false);
        dtFecha.setEnabled(false);

        limpiarCamposMaterial();
        datosPendientes = true;
    }//GEN-LAST:event_btnAgregarMaterialActionPerformed

    private void tblPedidoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPedidoMouseClicked
        int fila = tblPedido.getSelectedRow();
        if (fila == -1) {
            return;
        }

        txtCodigo.setText(modelo.getValueAt(fila, 1).toString());
        cboMaterial.setSelectedItem(modelo.getValueAt(fila, 4).toString());
        txtUnidad.setText(modelo.getValueAt(fila, 5).toString());
        txtCantidad.setText(modelo.getValueAt(fila, 6).toString());
        txtPrecioU.setText(modelo.getValueAt(fila, 7).toString());

        clsMaterialDAO.recuperar();
        clsMaterial m = clsMaterialDAO.buscar(
                Integer.parseInt(modelo.getValueAt(fila, 1).toString()));

        if (m != null) {
            txtStock.setText(String.valueOf(m.getStock()));
        }

        txtCodigo.setEditable(false);
        txtUnidad.setEditable(false);
        txtPrecioU.setText(modelo.getValueAt(fila, 7).toString());
        txtPrecioU.setEditable(false);
        txtStock.setEditable(false);

        cboMaterial.setEnabled(false);

        txtCantidad.setEditable(true);
        txtCantidad.requestFocus();
    }//GEN-LAST:event_tblPedidoMouseClicked

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        int fila = tblPedido.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione un material");
            return;
        }

        if (txtCantidad.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese cantidad");
            return;
        }

        try {
            int nuevaCantidad = Integer.parseInt(txtCantidad.getText());
            int stock = Integer.parseInt(txtStock.getText());

            if (nuevaCantidad <= 0 || nuevaCantidad > stock) {
                JOptionPane.showMessageDialog(this, "Cantidad inválida");
                return;
            }

            double precio = Double.parseDouble(modelo.getValueAt(fila, 7).toString());

            modelo.setValueAt(nuevaCantidad, fila, 6);
            modelo.setValueAt(nuevaCantidad * precio, fila, 8);

            JOptionPane.showMessageDialog(this, "Material modificado");

            limpiarCamposMaterial();

            cboMaterial.setEnabled(true);

            txtCantidad.setEditable(true);

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Ingrese un número válido en la cantidad");
        }
        datosPendientes = true;

    }//GEN-LAST:event_btnModificarActionPerformed

    private void cboMaterialItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboMaterialItemStateChanged


    }//GEN-LAST:event_cboMaterialItemStateChanged

    private void btnSalirRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirRegistroActionPerformed
         // Obtenemos el modelo de la tabla para contar las filas
    javax.swing.table.DefaultTableModel modelo = (javax.swing.table.DefaultTableModel) tblPedido.getModel();
    
    // VALIDACIÓN 2: Si hay datos en la tabla pero NO se han registrado
    if (modelo.getRowCount() > 0) {
        int respuesta = javax.swing.JOptionPane.showConfirmDialog(
                this, 
                "Los datos llenados en la tabla no se guardarán porque no han sido registrados.\n¿Desea salir de todos modos?", 
                "Advertencia: Datos no guardados", 
                javax.swing.JOptionPane.YES_NO_OPTION, 
                javax.swing.JOptionPane.WARNING_MESSAGE);
        
        if (respuesta == javax.swing.JOptionPane.YES_OPTION) {
            dispose(); // Regresa al menú
        }
    } 
    // VALIDACIÓN 1: Si la tabla está vacía (ingreso normal y quiere salir)
    else {
        int respuesta = javax.swing.JOptionPane.showConfirmDialog(
                this, 
                "¿Desea salir del reporte de pedidos?", 
                "Confirmar salida", 
                javax.swing.JOptionPane.YES_NO_OPTION, 
                javax.swing.JOptionPane.QUESTION_MESSAGE);
        
        if (respuesta == javax.swing.JOptionPane.YES_OPTION) {
            dispose(); // Regresa al menú
        }
    }
    }//GEN-LAST:event_btnSalirRegistroActionPerformed

    private void btnBuscarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarPedidoActionPerformed
        jdBuscarPedidos dlg = new jdBuscarPedidos(this, true);
        dlg.setVisible(true);

        int idPedido = dlg.getIdPedidoSeleccionado();
        if (idPedido == -1) {
            return;
        }

        cargarPedido(idPedido);
    }//GEN-LAST:event_btnBuscarPedidoActionPerformed


    private void btnEliminarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarPedidoActionPerformed
        int fila = tblPedido.getSelectedRow();

        if (fila != -1) {
            int respuesta = javax.swing.JOptionPane.showConfirmDialog(
                    this,
                    "¿Está seguro de eliminar el material seleccionado de la lista?",
                    "Confirmar eliminación",
                    javax.swing.JOptionPane.YES_NO_OPTION,
                    javax.swing.JOptionPane.WARNING_MESSAGE);

            if (respuesta == javax.swing.JOptionPane.YES_OPTION) {
                DefaultTableModel modelo = (DefaultTableModel) tblPedido.getModel();
                modelo.removeRow(fila);

                javax.swing.JOptionPane.showMessageDialog(this, "Material eliminado de la lista.");
            }
        } else {
            javax.swing.JOptionPane.showMessageDialog(this,
                    "Por favor, seleccione una fila de la tabla para eliminar.",
                    "Aviso",
                    javax.swing.JOptionPane.INFORMATION_MESSAGE);
        }
        modelo.removeRow(fila);
    }//GEN-LAST:event_btnEliminarPedidoActionPerformed

    private void btnEliminarRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarRegistroActionPerformed
        if (txtPedido.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "No hay ningún dato seleccionado. Por favor, busque y seleccione un registro para poder eliminar.",
                    "Aviso",
                    JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        try {
            int id = Integer.parseInt(txtPedido.getText());
            clsPedidoDAO.recuperar();

            if (clsPedidoDAO.buscar(id) == null) {
                JOptionPane.showMessageDialog(this, "El pedido con ID " + id + " no se encuentra registrado en el sistema.");
                return;
            }

            int respuesta = JOptionPane.showConfirmDialog(
                    this,
                    "¿Desea eliminar este registro de pedido con ID " + id + "?",
                    "Confirmar Eliminación",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.WARNING_MESSAGE);

            if (respuesta == JOptionPane.YES_OPTION) {
                if (clsPedidoDAO.eliminar(id)) {
                    clsPedidoDAO.grabar();
                    JOptionPane.showMessageDialog(this, "Pedido eliminado correctamente.");
                    limpiarTodo();
                }
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "El ID del pedido no es válido.");
        }
    }//GEN-LAST:event_btnEliminarRegistroActionPerformed


    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        limpiarTodo();    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void cboMaterialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboMaterialActionPerformed
        // TODO add your handling code here:
        if (cboMaterial.getSelectedIndex() == -1) {
            return;
        }

        clsMaterial m = clsMaterialDAO.buscarPorNombre(cboMaterial.getSelectedItem().toString());
        if (m != null) {
            txtCodigo.setText(String.valueOf(m.getCodigo()));
            txtUnidad.setText(m.getUnidad());
            txtPrecioU.setText(String.valueOf(m.getCosto()));
            txtStock.setText(String.valueOf(m.getStock()));
        }
    }//GEN-LAST:event_cboMaterialActionPerformed

    private void WindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_WindowClosing
        // TODO add your handling code here:
        confirmarSalida();
    }//GEN-LAST:event_WindowClosing

    private void txtCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCantidadActionPerformed
        // TODO add your handling code here:
        datosPendientes = true;
    }//GEN-LAST:event_txtCantidadActionPerformed

    private void cargarPedido(int idPedido) {

        clsPedidoDAO.recuperar();
        clsPedido pedido = clsPedidoDAO.buscar(idPedido);

        if (pedido == null) {
            JOptionPane.showMessageDialog(this, "Pedido no encontrado");
            return;
        }

        modelo.setRowCount(0);

        txtPedido.setText(String.valueOf(pedido.getIdPedido()));
        cboSector.setSelectedItem(pedido.getNombreProyecto());
        dtFecha.setDate(pedido.getFecha());

        cboSector.setEnabled(false);
        dtFecha.setEnabled(false);
        cboMaterial.setEnabled(false);
        txtCantidad.setEnabled(false);
        btnAgregarMaterial.setEnabled(false);
        btnModificar.setEnabled(false);
        btnEliminarPedido.setEnabled(false);
        btnRegistroPedido.setEnabled(false);

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        for (clsDetallePedido d : pedido.getDetalles()) {
            modelo.addRow(new Object[]{
                pedido.getIdPedido(),
                d.getIdMaterial(),
                sdf.format(pedido.getFecha()),
                pedido.getNombreProyecto(),
                d.getNombreMaterial(),
                d.getCategoria(),
                d.getCantidad(),
                d.getCostoUnitario(),
                d.getSubtotal()
            });
        }
    }

    private void limpiarCamposMaterial() {
        txtCodigo.setText("");
        txtUnidad.setText("");
        txtPrecioU.setText("");
        txtStock.setText("");
        txtCantidad.setText("");
        cboMaterial.setSelectedIndex(-1);
    }

    private void limpiarTodo() {
        modelo.setRowCount(0);

        cboSector.setEnabled(true);
        cboSector.setSelectedIndex(-1);

        dtFecha.setEnabled(true);
        dtFecha.setDate(new java.util.Date());

        cboMaterial.setEnabled(true);
        txtCantidad.setEnabled(true);

        btnAgregarMaterial.setEnabled(true);
        btnModificar.setEnabled(true);
        btnEliminarPedido.setEnabled(true);
        btnRegistroPedido.setEnabled(true);

        limpiarCamposMaterial();

        cboMaterial.removeAllItems();
        for (clsMaterial m : clsMaterialDAO.listarActivos()) {
            cboMaterial.addItem(m.getNombre());
        }

        generarNuevoIdPedido();

        datosPendientes = false;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarMaterial;
    private javax.swing.JButton btnBuscarPedido;
    private javax.swing.JButton btnEliminarPedido;
    private javax.swing.JButton btnEliminarRegistro;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnRegistroPedido;
    private javax.swing.JButton btnSalirRegistro;
    private javax.swing.JComboBox<String> cboMaterial;
    private javax.swing.JComboBox<String> cboSector;
    private com.toedter.calendar.JDateChooser dtFecha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblPedido;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtPedido;
    private javax.swing.JTextField txtPrecioU;
    private javax.swing.JTextField txtStock;
    private javax.swing.JTextField txtUnidad;
    // End of variables declaration//GEN-END:variables
}
