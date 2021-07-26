package ventanas;

import clases.Conexion;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.*;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

public class RestablecerPass extends javax.swing.JFrame {

    String user, user_update = "";

    public RestablecerPass() {
        initComponents();

        //Recuperamos el usuario de quien inicio sesion y lo asignamos a la variable
        user = Login.user;
        user_update = GestionarEmpleados.user_update;

        //Establecemos el titulo de la ventana
        setTitle("Restablecer contraseña - Sesión de " + user);
        //Reafirmamos el tamaño, lo fijamos y centramos la ventana
        setSize(400, 320);
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

        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        checkbox_pass = new javax.swing.JCheckBox();
        txt_pass = new javax.swing.JPasswordField();
        checkbox_pass2 = new javax.swing.JCheckBox();
        txt_pass2 = new javax.swing.JPasswordField();
        jLabel6 = new javax.swing.JLabel();
        button_aceptar = new javax.swing.JButton();
        label_empresa = new javax.swing.JLabel();
        label_logo = new javax.swing.JLabel();
        label_wallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Consolas", 0, 20)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("Restablecer Contraseña");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, -1, -1));

        jLabel4.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Nueva Contraseña:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 50, -1, -1));

        checkbox_pass.setBackground(new java.awt.Color(87, 161, 170));
        checkbox_pass.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        checkbox_pass.setForeground(new java.awt.Color(255, 255, 255));
        checkbox_pass.setText("Mostrar");
        checkbox_pass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkbox_passActionPerformed(evt);
            }
        });
        getContentPane().add(checkbox_pass, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 90, -1, -1));

        txt_pass.setBackground(new java.awt.Color(0, 204, 197));
        txt_pass.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        txt_pass.setForeground(new java.awt.Color(255, 255, 255));
        txt_pass.setAlignmentX(0.0F);
        txt_pass.setAlignmentY(0.0F);
        txt_pass.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        txt_pass.setPreferredSize(new java.awt.Dimension(4, 19));
        getContentPane().add(txt_pass, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, 230, 20));

        checkbox_pass2.setBackground(new java.awt.Color(87, 161, 170));
        checkbox_pass2.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        checkbox_pass2.setForeground(new java.awt.Color(255, 255, 255));
        checkbox_pass2.setText("Mostrar");
        checkbox_pass2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkbox_pass2ActionPerformed(evt);
            }
        });
        getContentPane().add(checkbox_pass2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 180, -1, -1));

        txt_pass2.setBackground(new java.awt.Color(0, 204, 197));
        txt_pass2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        txt_pass2.setForeground(new java.awt.Color(255, 255, 255));
        txt_pass2.setAlignmentX(0.0F);
        txt_pass2.setAlignmentY(0.0F);
        txt_pass2.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        txt_pass2.setPreferredSize(new java.awt.Dimension(4, 19));
        getContentPane().add(txt_pass2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 160, 230, 20));

        jLabel6.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Confirmar Contraseña:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 140, -1, -1));

        button_aceptar.setBackground(new java.awt.Color(0, 153, 153));
        button_aceptar.setForeground(new java.awt.Color(255, 255, 255));
        button_aceptar.setText("Aceptar");
        button_aceptar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        button_aceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_aceptarActionPerformed(evt);
            }
        });
        getContentPane().add(button_aceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 230, 80, 30));

        label_empresa.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        label_empresa.setForeground(new java.awt.Color(0, 0, 0));
        label_empresa.setText("QuetzalTec");
        getContentPane().add(label_empresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 290, -1, -1));
        getContentPane().add(label_logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 280, 30, 30));
        getContentPane().add(label_wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 320));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void checkbox_passActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkbox_passActionPerformed
//Condicional que verifica si la caja esta marcada
        if (checkbox_pass.isSelected()) {
            //Si la caja esta marcada muestra los caracteres de la contraseña
            txt_pass.setEchoChar((char)0);
            //Si la caja no esta marcada muestra asteriscos
        } else {
            txt_pass.setEchoChar('*');
        }
    }//GEN-LAST:event_checkbox_passActionPerformed

    private void checkbox_pass2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkbox_pass2ActionPerformed
        //Condicional que verifica si la caja esta marcada
        if (checkbox_pass2.isSelected()) {
            //Si la caja esta marcada muestra los caracteres de la contraseña
            txt_pass2.setEchoChar((char)0);
            //Si la caja no esta marcada muestra asteriscos
        } else {
            txt_pass2.setEchoChar('*');
        }
    }//GEN-LAST:event_checkbox_pass2ActionPerformed

    private void button_aceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_aceptarActionPerformed
        String password, confirmar_password;
        password = txt_pass.getText().trim();
        confirmar_password = txt_pass2.getText().trim();

        if (!password.equals("") && !confirmar_password.equals("")) {

            if (password.equals(confirmar_password)) {
                try {
                    Connection cn = Conexion.conectar();
                    PreparedStatement pst = cn.prepareStatement(
                            "update usuarios set password=? where usuario = '" + user_update + "'");

                    pst.setString(1, password);
                    pst.executeUpdate();
                    cn.close();

                    txt_pass.setBackground(Color.green);
                    txt_pass2.setBackground(Color.green);
                    
                    JOptionPane.showMessageDialog(null, "Reestablecimiento Exitoso");
                    this.dispose();

                } catch (SQLException e) {
                    System.err.println("Error al restaurar contraseña" + e);
                }

            } else {
                txt_pass2.setBackground(Color.red);
                JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden");
            }

        } else {
            txt_pass.setBackground(Color.red);
            txt_pass2.setBackground(Color.red);
            JOptionPane.showMessageDialog(null, "Rellena ambos campos");
        }

    }//GEN-LAST:event_button_aceptarActionPerformed

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
            java.util.logging.Logger.getLogger(RestablecerPass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RestablecerPass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RestablecerPass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RestablecerPass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RestablecerPass().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton button_aceptar;
    private javax.swing.JCheckBox checkbox_pass;
    private javax.swing.JCheckBox checkbox_pass2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel label_empresa;
    private javax.swing.JLabel label_logo;
    private javax.swing.JLabel label_wallpaper;
    private javax.swing.JPasswordField txt_pass;
    private javax.swing.JPasswordField txt_pass2;
    // End of variables declaration//GEN-END:variables
}
