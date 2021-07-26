/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;

//Importamos librerias necesarias
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.sql.*;
//Importamos la clase que conecta a la base de datos
import clases.Conexion;
import javax.swing.JOptionPane;

public class Login extends javax.swing.JFrame {

    //Declaramos variables para el usuario y contraseña
    public static String user = "";
    String pass = "";

    //Constructor de la ventana Login
    public Login() {
        initComponents();
        //Centramos la ventana
        setLocationRelativeTo(null);
        //Confirmamos el tamaño
        setSize(375, 510);
        //Hacemos el tamaño fijo
        setResizable(false);
        
        //Metodo para cambiar la imagen de fondo
        //Instanciamos la imagen de fondo
        ImageIcon wallpaper = new ImageIcon("src/imagenes/wallpaperlogo.png");
        //Asignamos la imagen de fondo al label de fondo y la redimensionamos junto al label
        Icon icono = new ImageIcon(wallpaper.getImage().getScaledInstance(label_wallpaper.getWidth(),
                label_wallpaper.getHeight(), Image.SCALE_DEFAULT));
        label_wallpaper.setIcon(icono);
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

        jLabel1 = new javax.swing.JLabel();
        txt_user = new javax.swing.JTextField();
        txt_password = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        button_login = new javax.swing.JButton();
        checkbox_pass = new javax.swing.JCheckBox();
        label_wallpaper = new javax.swing.JLabel();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Inicio de sesión");
        setBackground(new java.awt.Color(240, 184, 206));
        setForeground(java.awt.Color.black);
        setIconImage(getIconImage());
        setLocation(new java.awt.Point(0, 0));
        setMaximumSize(new java.awt.Dimension(375, 510));
        setMinimumSize(new java.awt.Dimension(375, 510));
        setPreferredSize(new java.awt.Dimension(375, 510));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_user.setBackground(new java.awt.Color(2, 205, 173));
        txt_user.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txt_user.setForeground(new java.awt.Color(255, 255, 255));
        txt_user.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_user.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        getContentPane().add(txt_user, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 220, 170, -1));

        txt_password.setBackground(new java.awt.Color(2, 205, 173));
        txt_password.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txt_password.setForeground(new java.awt.Color(255, 255, 255));
        txt_password.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_password.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        getContentPane().add(txt_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 290, 170, -1));

        jLabel2.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Usuario:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 190, 70, 30));

        jLabel3.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Contraseña:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 270, 100, -1));

        button_login.setBackground(new java.awt.Color(0, 153, 153));
        button_login.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        button_login.setForeground(new java.awt.Color(255, 255, 255));
        button_login.setText("Iniciar sesión");
        button_login.setAlignmentY(0.0F);
        button_login.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        button_login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_loginActionPerformed(evt);
            }
        });
        getContentPane().add(button_login, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 390, 140, 40));

        checkbox_pass.setBackground(new java.awt.Color(1, 99, 148));
        checkbox_pass.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        checkbox_pass.setForeground(new java.awt.Color(255, 255, 255));
        checkbox_pass.setText("Mostrar");
        checkbox_pass.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        checkbox_pass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkbox_passActionPerformed(evt);
            }
        });
        getContentPane().add(checkbox_pass, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 320, -1, -1));
        getContentPane().add(label_wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 370, 510));

        pack();
    }// </editor-fold>//GEN-END:initComponents
//Evento de código para el comportamiento del boton de Iniciar Sesión
    private void button_loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_loginActionPerformed
        /*Recuperamos los valores escritos en los campos de usuario y contraseña 
        y los asignamos a sus respectivas variables*/
        user = txt_user.getText().trim();
        pass = txt_password.getText().trim();

        //Utilizamos una condicional para verificar que los campos no esten vacios
        if (user.equals("") || pass.equals("")) {
            JOptionPane.showMessageDialog(null, "Debes llenar todos los campos.");
        } else {
            //Estructura Try Catch para el manejo de errores
            try {
                //Creamos una conexion a la BD llamando al método de la clase Conexión
                Connection cn = Conexion.conectar();
                /*Query SQL que selecciona de la base de datos el tipo de nivel, estado, usuario y contraseña y los 
            compara con los introducidos por el usuario para verificar que el usuario exista y se encuentre activo*/
                PreparedStatement pst = cn.prepareStatement(
                        "select tipo_nivel, estado from usuarios where usuario = '" + user
                        + "' and password = '" + pass + "'");
                //Ejecutamos la Query con una condicional que verifica si el usuario existe y se encuentra activo
                ResultSet rs = pst.executeQuery();
                if (rs.next()) {
                    //se recuperan los datos obtenidos de la BD y se asignan a unas variables
                    String tipo_nivel = rs.getString("tipo_nivel");
                    String estado = rs.getString("estado");
                    /*Utilizamos condicionales para verificar el tipo de nivel del usuario, si se encuentra activo se abrirá un menú
                distinto dependiendo de su tipo de nivel*/
                    if (tipo_nivel.equalsIgnoreCase("Administrador") && estado.equalsIgnoreCase("Activo")) {
                        //Cerramos la ventana de Login y abrimos el Menú de Administrador
                        dispose();
                        new Administrador().setVisible(true);
                        //Cerramos la conexion a la BD
                        cn.close();
                    
                    } else if (tipo_nivel.equalsIgnoreCase("Empleado") && estado.equalsIgnoreCase("Activo")) {
                        //Cerramos la ventana de Login y abrimos el Menú de Empleado
                        dispose();
                        new Empleado().setVisible(true);
                        //Cerramos la conexion a la BD
                        cn.close();
                    }

                } else {
                    //Si los datos no se encontraron en la BD
                    JOptionPane.showMessageDialog(null, "Datos de acceso incorrectos");
                    //Limpiamos los campos
                    txt_user.setText("");
                    txt_password.setText("");
                }

            } catch (SQLException e) {
                System.err.println("Error en el botón de Iniciar Sesión. " + e);
                JOptionPane.showMessageDialog(null, "¡Error al iniciar sesión! Contacte a un administrador.");
            }
        }
    }//GEN-LAST:event_button_loginActionPerformed

    //Este evento se encarga de mostrar la contraseña al marcar la caja
    private void checkbox_passActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkbox_passActionPerformed
        //Condicional que verifica si la caja esta marcada
        if (checkbox_pass.isSelected()) {
            //Si la caja esta marcada muestra los caracteres de la contraseña
            txt_password.setEchoChar((char)0);
            //Si la caja no esta marcada muestra asteriscos
        } else {
            txt_password.setEchoChar('*');
        }
    }//GEN-LAST:event_checkbox_passActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton button_login;
    private javax.swing.JCheckBox checkbox_pass;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel label_wallpaper;
    private javax.swing.JPasswordField txt_password;
    private javax.swing.JTextField txt_user;
    // End of variables declaration//GEN-END:variables
}
