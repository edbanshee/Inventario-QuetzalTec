/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;

import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.WindowConstants;
import java.sql.*;
import clases.Conexion;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;

public class InfoProducto extends javax.swing.JFrame {

    String user = "", producto_update = "";
    int ID;

    public InfoProducto() {
        initComponents();
        //Recuperamos el usuario de quien inicio sesion y lo asignamos a la variable
        user = Login.user;
        //Recuperamos el nombre del empleado seleccionado en la tabla
        producto_update = GestionarInventario.producto_update;
        //Establecemos el titulo de la ventana
        setTitle("Información del Producto - Sesión de " + user);
        //Reafirmamos el tamaño, lo fijamos y centramos la ventana
        setSize(380, 480);
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
        
        try {
            //Conectamos a la base de datos para recuperar la información del usuario seleccionado
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement(
                    "select * from inventario where Nombre_Producto = '" + producto_update + "'");
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                //Mostramos los datos recuperados de la base de datos
                ID = rs.getInt("ID_inventario");
                txt_nombre.setText(rs.getString("Nombre_Producto"));
                txt_cantidad.setText(rs.getString("Cantidad_Producto"));
                txt_precio.setText(rs.getString("Precio_Unitario"));
            }
            cn.close();
        } catch (SQLException e) {
            System.err.println("Error al cargar la información de usuario " + e);
            JOptionPane.showMessageDialog(null, "Error al cargar la información. Contacte al administrador");
        }

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

        label_nombre = new javax.swing.JLabel();
        txt_nombre = new javax.swing.JTextField();
        txt_precio = new javax.swing.JTextField();
        label_logo = new javax.swing.JLabel();
        label_empresa = new javax.swing.JLabel();
        label_infousuario = new javax.swing.JLabel();
        label_usuario1 = new javax.swing.JLabel();
        button_update = new javax.swing.JButton();
        label_usuario2 = new javax.swing.JLabel();
        txt_cantidad = new javax.swing.JTextField();
        button_eliminar = new javax.swing.JButton();
        label_wallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        label_nombre.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        label_nombre.setForeground(new java.awt.Color(255, 255, 255));
        label_nombre.setText("Producto:");
        getContentPane().add(label_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 60, -1, -1));

        txt_nombre.setBackground(new java.awt.Color(0, 204, 197));
        txt_nombre.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        txt_nombre.setForeground(new java.awt.Color(255, 255, 255));
        txt_nombre.setAlignmentX(0.0F);
        txt_nombre.setAlignmentY(0.0F);
        txt_nombre.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        getContentPane().add(txt_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 80, 230, 20));

        txt_precio.setBackground(new java.awt.Color(0, 204, 197));
        txt_precio.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        txt_precio.setForeground(new java.awt.Color(255, 255, 255));
        txt_precio.setAlignmentX(0.0F);
        txt_precio.setAlignmentY(0.0F);
        txt_precio.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        getContentPane().add(txt_precio, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 230, 230, 20));
        getContentPane().add(label_logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 400, 30, 30));

        label_empresa.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        label_empresa.setForeground(new java.awt.Color(0, 0, 0));
        label_empresa.setText("QuetzalTec");
        getContentPane().add(label_empresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 410, -1, -1));

        label_infousuario.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        label_infousuario.setForeground(new java.awt.Color(51, 51, 51));
        label_infousuario.setText("Información del producto");
        getContentPane().add(label_infousuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, 350, -1));

        label_usuario1.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        label_usuario1.setForeground(new java.awt.Color(255, 255, 255));
        label_usuario1.setText("Precio Unitario:");
        getContentPane().add(label_usuario1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 210, -1, -1));

        button_update.setBackground(new java.awt.Color(0, 153, 153));
        button_update.setForeground(new java.awt.Color(255, 255, 255));
        button_update.setText("Actualizar información");
        button_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_updateActionPerformed(evt);
            }
        });
        getContentPane().add(button_update, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 310, 170, -1));

        label_usuario2.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        label_usuario2.setForeground(new java.awt.Color(255, 255, 255));
        label_usuario2.setText("Cantidad en Existencia:");
        getContentPane().add(label_usuario2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 130, -1, -1));

        txt_cantidad.setBackground(new java.awt.Color(0, 204, 197));
        txt_cantidad.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        txt_cantidad.setForeground(new java.awt.Color(255, 255, 255));
        txt_cantidad.setAlignmentX(0.0F);
        txt_cantidad.setAlignmentY(0.0F);
        txt_cantidad.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        getContentPane().add(txt_cantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 150, 230, 20));

        button_eliminar.setText("Eliminar Registro");
        button_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_eliminarActionPerformed(evt);
            }
        });
        getContentPane().add(button_eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 350, -1, -1));
        getContentPane().add(label_wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 380, 480));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Evento que controla lo que ocurre al hacer click en el boton de Actualizar empleado
    private void button_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_updateActionPerformed
        //Guardamos los valores actualizados en respectivas variables
        Color color = new Color(0, 204, 197);
        int  validacion = 0;
        String nombre, cantidad, precio;
        nombre = txt_nombre.getText().trim();
        precio = txt_precio.getText().trim();
        cantidad = txt_cantidad.getText().trim();

        //Condicionales para comprobar que ningun campo este vacio
        if (nombre.equals("")) {
            txt_nombre.setBackground(Color.red);
            validacion++;
        }

        if (precio.equals("")) {
            txt_precio.setBackground(Color.red);
            validacion++;
        }
        
        if (cantidad.equals("")) {
            txt_cantidad.setBackground(Color.red);
            validacion++;
        }

        if (validacion == 0) {
            try {
                 //Conectamos a la base de datos y hacemos una consulta para actualizar los datos
                    Connection cn2 = Conexion.conectar();
                    PreparedStatement pst2 = cn2.prepareStatement(
                            "update inventario set Nombre_Producto = ?, Cantidad_Producto = ?, Precio_Unitario = ?"
                            + "where ID_inventario = '" + ID + "'");
                    //Asignamos los valores de las variables a la BD
                    pst2.setString(1, nombre);
                    pst2.setString(2, cantidad);
                    pst2.setString(3, precio);;
                    
                    pst2.executeUpdate();
                    cn2.close();
                    
                    JOptionPane.showMessageDialog(null, "Modificación exitosa");
                    txt_nombre.setBackground(color);
                    txt_cantidad.setBackground(color);
                    txt_precio.setBackground(color);
            } catch (Exception e) {
                System.err.println("Error al actualizar los datos" + e);
                JOptionPane.showMessageDialog(null, "Error al actualizar los datos. Contacte al administrador");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debes llenar todos los campos");
        } 


    }//GEN-LAST:event_button_updateActionPerformed

    private void button_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_eliminarActionPerformed
        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement( //Consulta SQL para llenar la tabla
                "delete from inventario where ID_inventario = ?");
            pst.setInt(1, ID);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Registro eliminado con éxito");

        } catch (SQLException e) {
            System.err.println("Error al eliminar registro" + e);
        }
    }//GEN-LAST:event_button_eliminarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InfoProducto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton button_eliminar;
    private javax.swing.JButton button_update;
    private javax.swing.JLabel label_empresa;
    private javax.swing.JLabel label_infousuario;
    private javax.swing.JLabel label_logo;
    private javax.swing.JLabel label_nombre;
    private javax.swing.JLabel label_usuario1;
    private javax.swing.JLabel label_usuario2;
    private javax.swing.JLabel label_wallpaper;
    private javax.swing.JTextField txt_cantidad;
    private javax.swing.JTextField txt_nombre;
    private javax.swing.JTextField txt_precio;
    // End of variables declaration//GEN-END:variables
}
