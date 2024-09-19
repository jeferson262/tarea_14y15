package database;

//libreria para la conexion a mysql
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane; //para ocultar errores de conexion a la bd

public class Conexion {
    
    //variables
    private final String DRIVER="com.mysql.jdbc.Driver";
    private final String URL="jdbc:mysql://localhost:3306/";
    private final String DB="dbalmacen";
    private final String USER="root";
    private final String PASSWORD="";
    
    public Connection cadena; //variable que importa la libreria sql
    public static Conexion instancia; //variable de instancia a la clase
    
    //constructor
    public Conexion() {
        this.cadena=null;
    }
    
    //método conectar a la bd
    public Connection conectar(){
        
        try {
            Class.forName(DRIVER);
            this.cadena=DriverManager.getConnection(URL+DB,USER,PASSWORD);
            System.out.println("Conexión establecida");
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, " Error de conexión a la BD " + e.getMessage());
            System.out.println("Error de conexion a la base de datos");
            System.exit(0);
        }
        return this.cadena;
    }
    
    //método para desconectar la bd
    public void desconectar(){
        
        try {
            this.cadena.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null," No se pudo cerrar la consulta Statement " + e.getMessage());
        }
        
    }
    
    //método para instanciar o conectar de forma automatica a la bd
    public synchronized static Conexion getInstancia(){
        
        if(instancia==null){
            instancia=new Conexion();
        }
        return instancia;
    }
    
    
}
