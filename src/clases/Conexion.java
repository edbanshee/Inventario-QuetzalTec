//En esta clase creamos una conexión a la base de datos, importando primero la libreria SQL
package clases;
import java.sql.*;

public class Conexion {
    //Utilizamos este metodo para la conexión local a la base de datos
    public static Connection conectar(){
        try{
            //Esta linea se encarga de crear una conexion con la base de datos
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/bd_quetzaltec", "root", "");
                    return cn;
        }catch(SQLException e){
            System.out.println("Error en la conexión con la base de datos " + e);
        }
        return (null);
    }
}
