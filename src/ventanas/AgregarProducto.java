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

public class AgregarProducto extends javax.swing.JFrame {

    String user = "", user_update = "";
    int ID;

    public AgregarProducto() {
        initComponents();
        //Recuperamos el usuario de quien inicio sesion y lo asignamos a la variable
        user = Login.user;
        //Recuperamos el nombre del empleado seleccionado en la tabla
        user_update = GestionarEmpleados.user_update;
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
        //recuperamos el usuario del empleado seleccionado y lo mostramos en el label

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
        button_add = new javax.swing.JButton();
        label_cantidad = new javax.swing.JLabel();
        txt_cantidad = new javax.swing.JTextField();
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
        label_infousuario.setText("Agregar nuevo producto");
        getContentPane().add(label_infousuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, 350, -1));

        label_usuario1.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        label_usuario1.setForeground(new java.awt.Color(255, 255, 255));
        label_usuario1.setText("Precio Unitario:");
        getContentPane().add(label_usuario1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 210, -1, -1));

        button_add.setBackground(new java.awt.Color(0, 153, 153));
        button_add.setForeground(new java.awt.Color(255, 255, 255));
        button_add.setText("Agregar");
        button_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_addActionPerformed(evt);
            }
        });
        getContentPane().add(button_add, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 310, 170, -1));

        label_cantidad.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        label_cantidad.setForeground(new java.awt.Color(255, 255, 255));
        label_cantidad.setText("Cantidad en Existencia:");
        getContentPane().add(label_cantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 130, 210, -1));

        txt_cantidad.setBackground(new java.awt.Color(0, 204, 197));
        txt_cantidad.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        txt_cantidad.setForeground(new java.awt.Color(255, 255, 255));
        txt_cantidad.setAlignmentX(0.0F);
        txt_cantidad.setAlignmentY(0.0F);
        txt_cantidad.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        getContentPane().add(txt_cantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 150, 230, 20));
        getContentPane().add(label_wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 380, 480));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Evento que controla lo que ocurre al hacer click en el boton de Actualizar empleado
    private void button_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_addActionPerformed
        //Declaramos variables para cada uno de nuestros campos y una variable bandera para validación
        int validacion = 0;
        String nombre, cantidad, precio;

        //Asignamos el texto introducido en los campos a sus respectivas variables
        nombre = txt_nombre.getText().trim();
        cantidad = txt_cantidad.getText().trim();
        precio = txt_precio.getText().trim();

        //Condicionales para evitar que algún campo quede vacio
        //Verificamos que el campo nombre no este vacio. De estarlo el campo se colorea rojo
        if (nombre.equals("")) {
            txt_nombre.setBackground(Color.red);
            validacion++;
        }
        //Verificamos que el campo usuario no este vacio. De estarlo el campo se colorea rojo
        if (cantidad.equals("")) {
            txt_cantidad.setBackground(Color.red);
            validacion++;
        }
        //Verificamos que el campo contraseña no este vacio. De estarlo el campo se colorea rojo
        if (precio.equals("")) {
            txt_precio.setBackground(Color.red);
            validacion++;
        }

        //Estructura Try Catch para mostrar posibles errores
        try {
            //Conectamos a la base de datos utilizando nuestra clase Conexion
            Connection cn = Conexion.conectar();
            //Declaramos una consulta SQL que recupere los usuarios de la BD
            PreparedStatement pst = cn.prepareStatement(
                    "select Nombre_Producto from inventario where Nombre_Producto = '" + nombre + "'");
            ResultSet rs = pst.executeQuery();

            /*Esta condicional verifica si el nombre del prodcuto introducido en el campo ya 
         existe en la BD comparando con la consulta anterior 
         Si el producto ya existe en la BD, el campo se colorea rojo, se muestra
         un mensaje y se cierra la conexion con la BD
             */
            if (rs.next()) {
                txt_nombre.setBackground(Color.red);
                JOptionPane.showMessageDialog(null, "El producto introducido ya existe\n"
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
                                "insert into inventario values (?,?,?,?)");

                        //Insertamos los valores en sus respectivos campos
                        pst2.setInt(1, 0);          //ID
                        pst2.setString(2, nombre);  //Nombre
                        pst2.setString(3, cantidad);//Cantidad
                        pst2.setString(4, precio);  //Precio unitario
        
                        pst2.executeUpdate(); //Actualizamos la BD
                        cn2.close();

                        Limpiar(); //Limpiamos los campos
                        //Coloreamos los campos a su color original
                        Color color = new Color(0, 204, 197);
                        txt_nombre.setBackground(color);
                        txt_cantidad.setBackground(color);
                        txt_precio.setBackground(color);

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


    }//GEN-LAST:event_button_addActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AgregarProducto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton button_add;
    private javax.swing.JLabel label_cantidad;
    private javax.swing.JLabel label_empresa;
    private javax.swing.JLabel label_infousuario;
    private javax.swing.JLabel label_logo;
    private javax.swing.JLabel label_nombre;
    private javax.swing.JLabel label_usuario1;
    private javax.swing.JLabel label_wallpaper;
    private javax.swing.JTextField txt_cantidad;
    private javax.swing.JTextField txt_nombre;
    private javax.swing.JTextField txt_precio;
    // End of variables declaration//GEN-END:variables

//Metodo para limpiar campos de texto
    public void Limpiar(){
        txt_nombre.setText("");
        txt_cantidad.setText("");
        txt_precio.setText("");
    }



}

