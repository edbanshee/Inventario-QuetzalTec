/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;
//Importamos las librerias necesarias

import clases.Conexion;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.*;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

public class RegistrarEmpleado extends javax.swing.JFrame {
//Declaramos una variable que recuperara el usuario de quien realiza el registro

    String user;

    public RegistrarEmpleado() {
        initComponents();
        //Recuperamos el usuario de quien inicio sesion y lo asignamos a la variable
        user = Login.user;
        //Establecemos el titulo de la ventana
        setTitle("Registrar nuevo empleado - Sesión de " + user);
        //Reafirmamos el tamaño, lo fijamos y centramos la ventana
        setSize(390, 450);
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

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txt_usuario = new javax.swing.JTextField();
        txt_nombre = new javax.swing.JTextField();
        label_nombre = new javax.swing.JLabel();
        label_logo = new javax.swing.JLabel();
        txt_password = new javax.swing.JPasswordField();
        checkbox_pass = new javax.swing.JCheckBox();
        cmb_niveles = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        label_wallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Consolas", 0, 20)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("Registro de Empleado");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jLabel3.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Usuario:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 120, -1, -1));

        jLabel4.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Contraseña:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 190, -1, -1));

        jLabel5.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Permisos de:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 260, -1, -1));

        jLabel6.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Nombre:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 50, -1, -1));

        txt_usuario.setBackground(new java.awt.Color(0, 204, 197));
        txt_usuario.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        txt_usuario.setForeground(new java.awt.Color(255, 255, 255));
        txt_usuario.setAlignmentX(0.0F);
        txt_usuario.setAlignmentY(0.0F);
        txt_usuario.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        getContentPane().add(txt_usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 140, 230, 20));

        txt_nombre.setBackground(new java.awt.Color(0, 204, 197));
        txt_nombre.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        txt_nombre.setForeground(new java.awt.Color(255, 255, 255));
        txt_nombre.setAlignmentX(0.0F);
        txt_nombre.setAlignmentY(0.0F);
        txt_nombre.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        getContentPane().add(txt_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, 230, 20));

        label_nombre.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        label_nombre.setForeground(new java.awt.Color(0, 0, 0));
        label_nombre.setText("QuetzalTec");
        getContentPane().add(label_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 390, -1, -1));
        getContentPane().add(label_logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 380, 30, 30));

        txt_password.setBackground(new java.awt.Color(0, 204, 197));
        txt_password.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        txt_password.setForeground(new java.awt.Color(255, 255, 255));
        txt_password.setAlignmentX(0.0F);
        txt_password.setAlignmentY(0.0F);
        txt_password.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        txt_password.setPreferredSize(new java.awt.Dimension(4, 19));
        getContentPane().add(txt_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 210, 230, 20));

        checkbox_pass.setBackground(new java.awt.Color(87, 161, 170));
        checkbox_pass.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        checkbox_pass.setForeground(new java.awt.Color(255, 255, 255));
        checkbox_pass.setText("Mostrar");
        checkbox_pass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkbox_passActionPerformed(evt);
            }
        });
        getContentPane().add(checkbox_pass, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 230, -1, -1));

        cmb_niveles.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        cmb_niveles.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Administrador", "Empleado" }));
        getContentPane().add(cmb_niveles, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 280, 130, -1));

        jButton1.setBackground(new java.awt.Color(0, 153, 153));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Registrar");
        jButton1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 330, 80, 30));
        getContentPane().add(label_wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 390, 450));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Evento que verifica si la caja esta marcada y muestra la contraseña
    private void checkbox_passActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkbox_passActionPerformed
        //Condicional que verifica si la caja esta marcada
        if (checkbox_pass.isSelected()) {
            //Si la caja esta marcada muestra los caracteres de la contraseña
            txt_password.setEchoChar((char) 0);
            //Si la caja no esta marcada muestra asteriscos
        } else {
            txt_password.setEchoChar('*');
        }
    }//GEN-LAST:event_checkbox_passActionPerformed

    //Evento controlado al hacer click en el boton Registrar
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        //Declaramos variables para cada uno de nuestros campos y una variable bandera para validación
        int permisos_cmb, validacion = 0;
        String nombre, usuario, password, permisos_string = null;

        //Asignamos el texto introducido en los campos a sus respectivas variables
        nombre = txt_nombre.getText().trim();
        usuario = txt_usuario.getText().trim();
        password = txt_password.getText().trim();
        permisos_cmb = cmb_niveles.getSelectedIndex() + 1;

        //Condicionales para evitar que algún campo quede vacio
        //Verificamos que el campo nombre no este vacio. De estarlo el campo se colorea rojo
        if (nombre.equals("")) {
            txt_nombre.setBackground(Color.red);
            validacion++;
        }
        //Verificamos que el campo usuario no este vacio. De estarlo el campo se colorea rojo
        if (usuario.equals("")) {
            txt_usuario.setBackground(Color.red);
            validacion++;
        }
        //Verificamos que el campo contraseña no este vacio. De estarlo el campo se colorea rojo
        if (password.equals("")) {
            txt_password.setBackground(Color.red);
            validacion++;
        }

        /*Esta condicional recupera el valor entero de la opción seleccionada en el campo Permisos
        La opcion seleccionada se guarda en una variable String para poder guardarse en la BD
         */
        if (permisos_cmb == 1) {
            permisos_string = "Administrador";
        } else if (permisos_cmb == 2) {
            permisos_string = "Empleado";
        }

        //Estructura Try Catch para mostrar posibles errores
        try {
            //Conectamos a la base de datos utilizando nuestra clase Conexion
            Connection cn = Conexion.conectar();
            //Declaramos una consulta SQL que recupere los usuarios de la BD
            PreparedStatement pst = cn.prepareStatement(
                    "select usuario from usuarios where usuario = '" + usuario + "'");
            ResultSet rs = pst.executeQuery();

            /*Esta condicional verifica si el usuario introducido en el campo ya 
         existe en la BD comparando con la consulta anterior 
         Si el usuario ya existe en la BD, el campo se colorea rojo, se muestra
         un mensaje y se cierra la conexion con la BD
             */
            if (rs.next()) {
                txt_usuario.setBackground(Color.red);
                JOptionPane.showMessageDialog(null, "El usuario introducido ya existe\n"
                        + "Intente con uno diferente");
                cn.close();
            } else {
                cn.close();
                //Esta codicional verifica nuestra variable bandera para confirmar que no haya campos vacios
                if (validacion == 0) {
                //Estructura Try Catch para mostrar posibes errores al conectar a la BD
                try {
                    //Conexion a la BD usando nuestra clase Conexion
                    Connection cn2 = Conexion.conectar();
                    //Consulta SQL para registrar los datos de los campos en la BD
                    PreparedStatement pst2 = cn2.prepareStatement(
                    "insert into usuarios values (?,?,?,?,?,?,?)");
                    
                    //Insertamos los valores en sus respectivos campos
                    pst2.setInt(1, 0); //ID
                    pst2.setString(2, nombre);          //Nombre
                    pst2.setString(3, usuario);         //Usuario
                    pst2.setString(4, password);        //Contraseña
                    pst2.setString(5, permisos_string); //Tipo_nivel
                    pst2.setString(6, user);            //Registrado_Por
                    pst2.setString(7, "Activo");        //Estado
                    
                    pst2.executeUpdate(); //Actualizamos la BD
                    cn2.close();
                    
                    Limpiar(); //Limpiamos los campos
                    //Coloreamos los campos a su color original
                    Color color = new Color(0,204,197);
                    txt_nombre.setBackground(color);
                    txt_password.setBackground(color);
                    txt_usuario.setBackground(color);
                    
                    //Mostramos un mensaje de que la operación fue exitosa
                    JOptionPane.showMessageDialog(null, "Registro exitoso");
                    this.dispose();
                    
         
                } catch (SQLException e) {
                    System.err.println("Error al registrar empleado" + e);
                    JOptionPane.showMessageDialog(null, "Error al registrar empleado. "
                            + "\nContacte al administrador");
                }
                } else {
                    JOptionPane.showMessageDialog(null, "Debes rellenar todos los campos");
                }
            }

        } catch (SQLException e) {
            System.err.println("Error en validar nombre de usuario" + e);
            JOptionPane.showMessageDialog(null, "Error al comparar usuario\n" + "Contacte con el Administrador");
        }
        

    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistrarEmpleado().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox checkbox_pass;
    private javax.swing.JComboBox<String> cmb_niveles;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel label_logo;
    private javax.swing.JLabel label_nombre;
    private javax.swing.JLabel label_wallpaper;
    private javax.swing.JTextField txt_nombre;
    private javax.swing.JPasswordField txt_password;
    private javax.swing.JTextField txt_usuario;
    // End of variables declaration//GEN-END:variables

//Metodo para limpiar campos de texto
    public void Limpiar(){
        txt_nombre.setText("");
        txt_password.setText("");
        txt_usuario.setText("");
        cmb_niveles.setSelectedIndex(0);
    }

}
