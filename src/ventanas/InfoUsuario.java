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
import static ventanas.GestionarEmpleados.user_update;

public class InfoUsuario extends javax.swing.JFrame {

    String user = "", user_update = "";
    int ID;

    public InfoUsuario() {
        initComponents();
        //Recuperamos el usuario de quien inicio sesion y lo asignamos a la variable
        user = Login.user;
        //Recuperamos el nombre del empleado seleccionado en la tabla
        user_update = GestionarEmpleados.user_update;
        //Establecemos el titulo de la ventana
        setTitle("Información de empleado - Sesión de " + user);
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
        //recuperamos el usuario del empleado seleccionado y lo mostramos en el label
        label_infousuario.setText("Información del usuario " + user_update);

        try {
            //Conectamos a la base de datos para recuperar la información del usuario seleccionado
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement(
                    "select * from usuarios where usuario = '" + user_update + "'");
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                //Mostramos los datos recuperados de la base de datos
                ID = rs.getInt("ID_usuario");
                txt_nombre.setText(rs.getString("NombreUsuario"));
                txt_usuario.setText(rs.getString("usuario"));
                label_registradopor.setText(rs.getString("registrado_por"));
                cmb_niveles.setSelectedItem(rs.getString("tipo_nivel"));
                cmb_estado.setSelectedItem(rs.getString("estado"));
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
        label_registradopor = new javax.swing.JLabel();
        txt_nombre = new javax.swing.JTextField();
        txt_usuario = new javax.swing.JTextField();
        label_permisos = new javax.swing.JLabel();
        cmb_niveles = new javax.swing.JComboBox<>();
        label_logo = new javax.swing.JLabel();
        label_empresa = new javax.swing.JLabel();
        label_infousuario = new javax.swing.JLabel();
        label_usuario1 = new javax.swing.JLabel();
        label_r = new javax.swing.JLabel();
        label_estado = new javax.swing.JLabel();
        cmb_estado = new javax.swing.JComboBox<>();
        button_update = new javax.swing.JButton();
        button_password = new javax.swing.JButton();
        button_eliminar = new javax.swing.JButton();
        label_wallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        label_nombre.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        label_nombre.setForeground(new java.awt.Color(255, 255, 255));
        label_nombre.setText("Nombre:");
        getContentPane().add(label_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 60, -1, -1));

        label_registradopor.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        label_registradopor.setForeground(new java.awt.Color(255, 255, 255));
        label_registradopor.setText("edbanshee");
        getContentPane().add(label_registradopor, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 310, 100, -1));

        txt_nombre.setBackground(new java.awt.Color(0, 204, 197));
        txt_nombre.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        txt_nombre.setForeground(new java.awt.Color(255, 255, 255));
        txt_nombre.setAlignmentX(0.0F);
        txt_nombre.setAlignmentY(0.0F);
        txt_nombre.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        getContentPane().add(txt_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 80, 230, 20));

        txt_usuario.setBackground(new java.awt.Color(0, 204, 197));
        txt_usuario.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        txt_usuario.setForeground(new java.awt.Color(255, 255, 255));
        txt_usuario.setAlignmentX(0.0F);
        txt_usuario.setAlignmentY(0.0F);
        txt_usuario.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        getContentPane().add(txt_usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 150, 230, 20));

        label_permisos.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        label_permisos.setForeground(new java.awt.Color(255, 255, 255));
        label_permisos.setText("Permisos de:");
        getContentPane().add(label_permisos, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, -1, -1));

        cmb_niveles.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        cmb_niveles.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Administrador", "Empleado" }));
        getContentPane().add(cmb_niveles, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 130, -1));
        getContentPane().add(label_logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 400, 30, 30));

        label_empresa.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        label_empresa.setForeground(new java.awt.Color(0, 0, 0));
        label_empresa.setText("QuetzalTec");
        getContentPane().add(label_empresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 410, -1, -1));

        label_infousuario.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        label_infousuario.setForeground(new java.awt.Color(51, 51, 51));
        label_infousuario.setText("Información del usuario edbanshee");
        getContentPane().add(label_infousuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 350, -1));

        label_usuario1.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        label_usuario1.setForeground(new java.awt.Color(255, 255, 255));
        label_usuario1.setText("Usuario:");
        getContentPane().add(label_usuario1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 130, -1, -1));

        label_r.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        label_r.setForeground(new java.awt.Color(255, 255, 255));
        label_r.setText("Registrado por:");
        getContentPane().add(label_r, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 290, -1, -1));

        label_estado.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        label_estado.setForeground(new java.awt.Color(255, 255, 255));
        label_estado.setText("Estado:");
        getContentPane().add(label_estado, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 210, -1, -1));

        cmb_estado.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        cmb_estado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Activo", "Inactivo" }));
        getContentPane().add(cmb_estado, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 230, 130, -1));

        button_update.setBackground(new java.awt.Color(0, 153, 153));
        button_update.setForeground(new java.awt.Color(255, 255, 255));
        button_update.setText("Actualizar información");
        button_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_updateActionPerformed(evt);
            }
        });
        getContentPane().add(button_update, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, 170, -1));

        button_password.setBackground(new java.awt.Color(0, 153, 153));
        button_password.setForeground(new java.awt.Color(255, 255, 255));
        button_password.setText("Reestablecer contraseña");
        button_password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_passwordActionPerformed(evt);
            }
        });
        getContentPane().add(button_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, -1, -1));

        button_eliminar.setText("Eliminar Registro");
        button_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_eliminarActionPerformed(evt);
            }
        });
        getContentPane().add(button_eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 330, -1, -1));
        getContentPane().add(label_wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 380, 480));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Evento que controla lo que ocurre al hacer click en el boton de Actualizar empleado
    private void button_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_updateActionPerformed
        //Guardamos los valores actualziados en respectivas variables
        Color color = new Color(0, 204, 197);
        int permisos_cmb, estado_cmb, validacion = 0;
        String nombre, usuario, pass, permisos_string = "", estado_string = "";
        nombre = txt_nombre.getText().trim();
        usuario = txt_usuario.getText().trim();
        permisos_cmb = cmb_niveles.getSelectedIndex() + 1;
        estado_cmb = cmb_estado.getSelectedIndex() + 1;

        //Condicionales para comprobar que ningun campo este vacio
        if (nombre.equals("")) {
            txt_nombre.setBackground(Color.red);
            validacion++;
        }

        if (usuario.equals("")) {
            txt_usuario.setBackground(Color.red);
            validacion++;
        }

        if (validacion == 0) {
            //Condicionales para definir los datos seleccionados del usuario
            if (permisos_cmb == 1) {
                permisos_string = "Administrador";
            } else if (permisos_cmb == 2) {
                permisos_string = "Empleado";
            }

            if (estado_cmb == 1) {
                estado_string = "Activo";
            } else if (estado_cmb == 2) {
                estado_string = "Inactivo";
            }

            try {
                //Conectamos a la base de datos y hacemos una consulta para validar que el usuario no exista
                Connection cn = Conexion.conectar();
                PreparedStatement pst = cn.prepareStatement(
                        "select usuario from usuarios where usuario = '" + usuario + "' and not ID_usuario = '" + ID + "'");
                ResultSet rs = pst.executeQuery();
                if (rs.next()) {
                    txt_usuario.setBackground(Color.red);
                    JOptionPane.showMessageDialog(null, "Nombre de usuario no disponible");
                    cn.close();
                } else {
                    //Conectamos a la base de datos y hacemos una consulta para actualizar los datos
                    Connection cn2 = Conexion.conectar();
                    PreparedStatement pst2 = cn2.prepareStatement(
                            "update usuarios set NombreUsuario = ?, usuario = ?, tipo_nivel = ?, estado = ?"
                            + "where ID_usuario = '" + ID + "'");
                    //Asignamos los valores de las variables a la BD
                    pst2.setString(1, nombre);
                    pst2.setString(2, usuario);
                    pst2.setString(3, permisos_string);
                    pst2.setString(4, estado_string);
                    
                    pst2.executeUpdate();
                    cn2.close();
                    
                    JOptionPane.showMessageDialog(null, "Modificación exitosa");
                    txt_nombre.setBackground(color);
                    txt_usuario.setBackground(color);

                }

            } catch (SQLException e) {
                System.err.println("Error al actualizar los datos" + e);
                JOptionPane.showMessageDialog(null, "Error al actualizar los datos. Contacte al administrador");
            }

        } else {
            JOptionPane.showMessageDialog(null, "Debes llenar todos los campos");
        }


    }//GEN-LAST:event_button_updateActionPerformed

    private void button_passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_passwordActionPerformed
       RestablecerPass restablecerPass = new RestablecerPass();
       restablecerPass.setVisible(true);
    }//GEN-LAST:event_button_passwordActionPerformed

    private void button_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_eliminarActionPerformed
        try {
              Connection cn = Conexion.conectar();
        PreparedStatement pst = cn.prepareStatement( //Consulta SQL para llenar la tabla
                    "delete from usuarios where ID_usuario = ?");
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
                new InfoUsuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton button_eliminar;
    private javax.swing.JButton button_password;
    private javax.swing.JButton button_update;
    private javax.swing.JComboBox<String> cmb_estado;
    private javax.swing.JComboBox<String> cmb_niveles;
    private javax.swing.JLabel label_empresa;
    private javax.swing.JLabel label_estado;
    private javax.swing.JLabel label_infousuario;
    private javax.swing.JLabel label_logo;
    private javax.swing.JLabel label_nombre;
    private javax.swing.JLabel label_permisos;
    private javax.swing.JLabel label_r;
    private javax.swing.JLabel label_registradopor;
    private javax.swing.JLabel label_usuario1;
    private javax.swing.JLabel label_wallpaper;
    private javax.swing.JTextField txt_nombre;
    private javax.swing.JTextField txt_usuario;
    // End of variables declaration//GEN-END:variables
}
