
package ventanas;

import clases.Conexion;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import static ventanas.GestionarEmpleados.user_update;

public class GestionarInventario extends javax.swing.JFrame {
String user;
public static String producto_update = "";
DefaultTableModel model = new DefaultTableModel();
    public GestionarInventario() {
        initComponents();
        //Recuperamos el usuario de quien inicio sesion y lo asignamos a la variable
        user = Login.user;
        //Establecemos el titulo de la ventana
        setTitle("Inventario - Sesión de " + user);
        //Reafirmamos el tamaño, lo fijamos y centramos la ventana
        setSize(750, 470);
        setResizable(false);
        setLocationRelativeTo(null);
        
        //Establecemos que al cerrar la ventana no se cierre el programa completo
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        
        //Metodo para cambiar la imagen de fondo
        //Instanciamos la imagen de fondo
        ImageIcon wallpaper = new ImageIcon("src/imagenes/background.png");
        //Asignamos la imagen de fondo al label de fondo y la redimensionamos junto al label
        Icon icono = new ImageIcon(wallpaper.getImage().getScaledInstance(label_wallpaper.getWidth(),
                label_wallpaper.getHeight(), Image.SCALE_DEFAULT));
        label_wallpaper.setIcon(icono);
        this.repaint();
        
        //Metodo para poner el logo
        //Instanciamos la imagen del logo
        ImageIcon logo = new ImageIcon("src/imagenes/logo.png");
        //Asignamos la imagen de logo al label de logo y la redimensionamos junto al label
        Icon iconlogo = new ImageIcon(logo.getImage().getScaledInstance(label_logo.getWidth(),
                label_logo.getHeight(), Image.SCALE_SMOOTH));
        label_logo.setIcon(iconlogo);
        this.repaint();


        //Estructura Try Catch para mostrar posibles errores al consultar la BD
        try {
            Connection cn = Conexion.conectar(); //Conecta a BD
            PreparedStatement pst = cn.prepareStatement( //Consulta SQL para llenar la tabla
                    "select ID_inventario, Nombre_Producto, Cantidad_Producto, Precio_Unitario from inventario");

            ResultSet rs = pst.executeQuery(); //Ejecutar la consulta

            table_inventario = new JTable(model); //Instanciamos la tabla
            //Colocamos la tabla en un panel de desplazamiento
            jScrollPane1.setViewportView(table_inventario);
            //Agregamos las columnas necesarias a la tabla
            model.addColumn("ID");
            model.addColumn("Producto");
            model.addColumn("Cantidad en existencia");
            model.addColumn("Precio Unitario");

            /* Este ciclo se encarga de llenar las columnas de la tabla con la información
            obtenida de la base de datos */
            while (rs.next()) {
                Object[] fila = new Object[5];

                for (int i = 0; i < 4; i++) {
                    fila[i] = rs.getObject(i + 1);
                }
                model.addRow(fila);
            }
            cn.close();

        } catch (SQLException e) {
            System.err.println("Error al llenar la tabla" + e);
            JOptionPane.showMessageDialog(null, "Error al mostrar la información. Contacte a un administrador");
        }
        
        /* Este evento obtiene la fila que haya sido seleccionada y muestra una ventana de modificación 
        del empleado seleccionado en dicha fila*/
        table_inventario.addMouseListener(new MouseAdapter() { //Escucha los clicks del mouse
        @Override
        public void  mouseClicked(MouseEvent e){
            int fila_point =  table_inventario.rowAtPoint(e.getPoint()); //Obtenemos la fila que se ha seleccionado
            int columna_point = 1; //Se selecciona la columna donde esta el nombre del producto
            //Guardamos el nombre del empleado seleccionado para llamarlo en otra ventana
            if(fila_point > -1){
                producto_update = (String)model.getValueAt(fila_point, columna_point);
                //Abrimos la ventana de información de empleado al hacer click en alguno
                InfoProducto infoProducto = new InfoProducto();
                infoProducto.setVisible(true);
            }
            
            
        }
        });
        
    }

    //Creamos un metodo sobreescrito que sustituya el icono de la ventana por nuestro logo
    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("imagenes/Icon.jpg"));
        return retValue;
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        table_inventario = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        label_nombre = new javax.swing.JLabel();
        label_logo = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        button_update = new javax.swing.JButton();
        button_buscar = new javax.swing.JButton();
        txt_buscar = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        label_wallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        table_inventario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Producto", "Cantidad en existencia", "Precio Unitario"
            }
        ));
        jScrollPane1.setViewportView(table_inventario);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 690, 330));

        jLabel3.setFont(new java.awt.Font("Consolas", 0, 20)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("Inventario");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 20, -1, -1));

        label_nombre.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        label_nombre.setForeground(new java.awt.Color(0, 0, 0));
        label_nombre.setText("QuetzalTec");
        getContentPane().add(label_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 410, -1, -1));
        getContentPane().add(label_logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 400, 30, 30));

        jButton1.setBackground(new java.awt.Color(0, 153, 153));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Agregar Nuevo");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 20, -1, -1));

        button_update.setBackground(new java.awt.Color(0, 153, 153));
        button_update.setForeground(new java.awt.Color(255, 255, 255));
        button_update.setText("Actualizar");
        button_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_updateActionPerformed(evt);
            }
        });
        getContentPane().add(button_update, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 390, -1, -1));

        button_buscar.setBackground(new java.awt.Color(0, 153, 153));
        button_buscar.setForeground(new java.awt.Color(255, 255, 255));
        button_buscar.setText("Buscar");
        button_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_buscarActionPerformed(evt);
            }
        });
        getContentPane().add(button_buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 390, -1, -1));

        txt_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_buscarActionPerformed(evt);
            }
        });
        getContentPane().add(txt_buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 390, 50, 20));

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("ID:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 390, 20, 20));
        getContentPane().add(label_wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 750, 470));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        AgregarProducto agregarProducto = new AgregarProducto();
        agregarProducto.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void button_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_updateActionPerformed
        model.setRowCount(0);
        model.setColumnCount(0);
        //Estructura Try Catch para mostrar posibles errores al consultar la BD
        try {
            Connection cn = Conexion.conectar(); //Conecta a BD
            PreparedStatement pst = cn.prepareStatement( //Consulta SQL para llenar la tabla
                "select ID_inventario, Nombre_Producto, Cantidad_Producto, Precio_Unitario from inventario");

            ResultSet rs = pst.executeQuery(); //Ejecutar la consulta

            table_inventario = new JTable(model); //Instanciamos la tabla
            //Colocamos la tabla en un panel de desplazamiento
            jScrollPane1.setViewportView(table_inventario);
            //Agregamos las columnas necesarias a la tabla
            model.addColumn("ID");
            model.addColumn("Producto");
            model.addColumn("Cantidad en existencia");
            model.addColumn("Precio Unitario");

            /* Este ciclo se encarga de llenar las columnas de la tabla con la información
            obtenida de la base de datos */
            while (rs.next()) {
                Object[] fila = new Object[5];

                for (int i = 0; i < 4; i++) {
                    fila[i] = rs.getObject(i + 1);
                }
                model.addRow(fila);
            }
            cn.close();

        } catch (SQLException e) {
            System.err.println("Error al llenar la tabla" + e);
            JOptionPane.showMessageDialog(null, "Error al mostrar la información. Contacte a un administrador");
        }
        /* Este evento obtiene la fila que haya sido seleccionada y muestra una ventana de modificación 
        del empleado seleccionado en dicha fila*/
        table_inventario.addMouseListener(new MouseAdapter() { //Escucha los clicks del mouse
        @Override
        public void  mouseClicked(MouseEvent e){
            int fila_point =  table_inventario.rowAtPoint(e.getPoint()); //Obtenemos la fila que se ha seleccionado
            int columna_point = 1; //Se selecciona la columna donde esta el nombre del producto
            //Guardamos el nombre del empleado seleccionado para llamarlo en otra ventana
            if(fila_point > -1){
                producto_update = (String)model.getValueAt(fila_point, columna_point);
                //Abrimos la ventana de información de empleado al hacer click en alguno
                InfoProducto infoProducto = new InfoProducto();
                infoProducto.setVisible(true);
            }
            
            
        }
        });
    }//GEN-LAST:event_button_updateActionPerformed

    private void button_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_buscarActionPerformed
        //Este evento se encarga de lo que ocurre al apretar el boton buscar
        model.setRowCount(0);
        model.setColumnCount(0);
        //Estructura Try Catch para mostrar posibles errores al consultar la BD
        try {
            Connection cn = Conexion.conectar(); //Conecta a BD
            PreparedStatement pst = cn.prepareStatement( //Consulta SQL para llenar la tabla con el ID buscado
                "select ID_inventario, Nombre_Producto, Cantidad_Producto, Precio_Unitario from inventario where ID_inventario = ?");
            pst.setString(1, txt_buscar.getText().trim());
            ResultSet rs = pst.executeQuery(); //Ejecutar la consulta

           table_inventario = new JTable(model); //Instanciamos la tabla
            //Colocamos la tabla en un panel de desplazamiento
            jScrollPane1.setViewportView(table_inventario);
            //Agregamos las columnas necesarias a la tabla
            model.addColumn("ID");
            model.addColumn("Producto");
            model.addColumn("Cantidad en existencia");
            model.addColumn("Precio Unitario");

            /* Este ciclo se encarga de llenar las columnas de la tabla con la información
            obtenida de la base de datos al buscar el ID */
            while (rs.next()) {
                Object[] fila = new Object[5];

                for (int i = 0; i < 4; i++) {
                    fila[i] = rs.getObject(i + 1);
                }
                model.addRow(fila);
            }
            cn.close();

        } catch (SQLException e) {
            System.err.println("Error al llenar la tabla" + e);
            JOptionPane.showMessageDialog(null, "Error al mostrar la información. Contacte a un administrador");
        }
        /* Este evento obtiene la fila que haya sido seleccionada y muestra una ventana de modificación 
        del empleado seleccionado en dicha fila*/
        table_inventario.addMouseListener(new MouseAdapter() { //Escucha los clicks del mouse
        @Override
        public void  mouseClicked(MouseEvent e){
            int fila_point =  table_inventario.rowAtPoint(e.getPoint()); //Obtenemos la fila que se ha seleccionado
            int columna_point = 1; //Se selecciona la columna donde esta el nombre del producto
            //Guardamos el nombre del empleado seleccionado para llamarlo en otra ventana
            if(fila_point > -1){
                producto_update = (String)model.getValueAt(fila_point, columna_point);
                //Abrimos la ventana de información de empleado al hacer click en alguno
                InfoProducto infoProducto = new InfoProducto();
                infoProducto.setVisible(true);
            }
            
            
        }
        });
    }//GEN-LAST:event_button_buscarActionPerformed

    private void txt_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_buscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_buscarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GestionarInventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GestionarInventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GestionarInventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GestionarInventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GestionarInventario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton button_buscar;
    private javax.swing.JButton button_update;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label_logo;
    private javax.swing.JLabel label_nombre;
    private javax.swing.JLabel label_wallpaper;
    private javax.swing.JTable table_inventario;
    private javax.swing.JTextField txt_buscar;
    // End of variables declaration//GEN-END:variables
}
