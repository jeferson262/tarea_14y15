package database;

import javax.swing.JOptionPane;

public class MainConectar {

   
    public static void main(String[] args) {
        Conexion conexion = Conexion.getInstancia();
        conexion.conectar();
        if(conexion.cadena!=null){
            JOptionPane.showMessageDialog(null, "Conectado");
        }else{
            System.out.println("Desconectado");
        }
    }
    
}
