package ventanas;
//Importamos la libreria para SQL y nuestra clase de Conexion

import java.sql.*;
import clases.Conexion;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.WindowConstants;

public class Administrador extends javax.swing.JFrame {

    //Declaramos una variable donde guardar la información del usuario que inicia sesion
    String user, nombre_usuario;
    public static int sesion_usuario;

    public Administrador() {
        initComponents();
        //Recuperamos el usuario que acaba de iniciar sesion en una variable
        user = Login.user;
        sesion_usuario = 1;

        //Centramos la ventana
        setLocationRelativeTo(null);
        //Confirmamos el tamaño
        setSize(500, 440);
        //Fijamos el tamaño
        setResizable(false);
        //Asignamos un titulo
        setTitle("Administrador - Sesión de " + user);

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

        /*Estructura Try Catch para consultar la BD.
        Recuperaremos el nombre completo del usuario que inició sesión*/
        try {
            //establecemos la conexion con la BD utilizando nuestra clase Conexion
            Connection cn = Conexion.conectar();
            //Creamos la consulta SQL que seleccion el nombre completo del usuario loggeado
            PreparedStatement pst = cn.prepareStatement(
                    "select NombreUsuario from usuarios where usuario = '" + user + "'");
            //Ejecutamos la consulta y regresamos los datos pedidos
            ResultSet rs = pst.executeQuery();
            //Condicional para  verificar que haya coincidencias en la BD
            if (rs.next()) {
                //Si hay coincidencias se guarda el nombre en la variable y se muestra en el label
                nombre_usuario = rs.getString("NombreUsuario");
                label_nombre1.setText("Bienvenido, " + nombre_usuario);
            }

        } catch (Exception e) {
            System.err.println("Error en la conexión de la interfaz de Administrador");
        }

        //Nos aseguramos de terminar el programa al cerrar la ventana
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

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
        button_gestionarusuarios = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        button_inventario = new javax.swing.JButton();
        button_acercade = new javax.swing.JButton();
        button_registrarusuario3 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        label_nombre1 = new javax.swing.JLabel();
        label_logo = new javax.swing.JLabel();
        label_wallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Administrador");
        setIconImage(getIconImage());
        setMaximumSize(new java.awt.Dimension(500, 440));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        label_nombre.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        label_nombre.setForeground(new java.awt.Color(0, 0, 0));
        label_nombre.setText("QuetzalTec");
        getContentPane().add(label_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 380, -1, -1));

        button_gestionarusuarios.setBackground(new java.awt.Color(116, 214, 226));
        button_gestionarusuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/usuarios.png"))); // NOI18N
        button_gestionarusuarios.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        button_gestionarusuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_gestionarusuariosActionPerformed(evt);
            }
        });
        getContentPane().add(button_gestionarusuarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 60, 80, 80));

        jLabel1.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Gestionar Empleados");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 140, 160, 30));

        button_inventario.setBackground(new java.awt.Color(116, 214, 226));
        button_inventario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/inventario.png"))); // NOI18N
        button_inventario.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        button_inventario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_inventarioActionPerformed(evt);
            }
        });
        getContentPane().add(button_inventario, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 220, 80, 80));

        button_acercade.setBackground(new java.awt.Color(116, 214, 226));
        button_acercade.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/info.png"))); // NOI18N
        button_acercade.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        button_acercade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_acercadeActionPerformed(evt);
            }
        });
        getContentPane().add(button_acercade, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 220, 80, 80));

        button_registrarusuario3.setBackground(new java.awt.Color(116, 214, 226));
        button_registrarusuario3.setForeground(new java.awt.Color(255, 255, 255));
        button_registrarusuario3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/usuario.png"))); // NOI18N
        button_registrarusuario3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        button_registrarusuario3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_registrarusuario3ActionPerformed(evt);
            }
        });
        getContentPane().add(button_registrarusuario3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 60, 80, 80));

        jLabel2.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Gestionar Inventario");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 300, 160, 30));

        jLabel3.setBackground(new java.awt.Color(0, 204, 204));
        jLabel3.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Acerca de");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 300, 90, 30));

        jLabel4.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Registrar Empleado");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 140, 150, 30));

        label_nombre1.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        label_nombre1.setForeground(new java.awt.Color(51, 51, 51));
        label_nombre1.setText("jLabel1");
        getContentPane().add(label_nombre1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));
        getContentPane().add(label_logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 370, 30, 30));
        getContentPane().add(label_wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 440));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Este método controla el evento al hacer click en el boton de Registrar Empleado
    private void button_registrarusuario3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_registrarusuario3ActionPerformed
        //Creamos un objeto de la venta Registrar usuarios y la mostramos
        RegistrarEmpleado registrarEmpleado = new RegistrarEmpleado();
        registrarEmpleado.setVisible(true);
    }//GEN-LAST:event_button_registrarusuario3ActionPerformed
    //Este método controla el evento al hacer click en el boton de Gestionar Empleados
    private void button_gestionarusuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_gestionarusuariosActionPerformed
        GestionarEmpleados gestionarEmpleados = new GestionarEmpleados();
        gestionarEmpleados.setVisible(true);
    }//GEN-LAST:event_button_gestionarusuariosActionPerformed

    private void button_inventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_inventarioActionPerformed
        GestionarInventario gestionarInventario = new GestionarInventario();
        gestionarInventario.setVisible(true);
    }//GEN-LAST:event_button_inventarioActionPerformed

    private void button_acercadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_acercadeActionPerformed
        Acercade acercade = new Acercade();
        acercade.setVisible(true);
        
    }//GEN-LAST:event_button_acercadeActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Administrador().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton button_acercade;
    private javax.swing.JButton button_gestionarusuarios;
    private javax.swing.JButton button_inventario;
    private javax.swing.JButton button_registrarusuario3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel label_logo;
    private javax.swing.JLabel label_nombre;
    private javax.swing.JLabel label_nombre1;
    private javax.swing.JLabel label_wallpaper;
    // End of variables declaration//GEN-END:variables
}
