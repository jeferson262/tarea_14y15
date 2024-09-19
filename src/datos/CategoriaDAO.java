package datos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import database.Conexion;
import datos.CrudInterface.CategoriaInterface;
import entidades.Categoria;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class CategoriaDAO implements CategoriaInterface<Categoria>{
    
    //variables
    private final Conexion CON;
    private PreparedStatement ps;
    private ResultSet rs;
    private boolean resp;
    
    //constructor
    public CategoriaDAO(){
        CON=Conexion.getInstancia();
    }

    @Override
    public List<Categoria> listar(String texto) {
        List<Categoria> registros = new ArrayList<>();
        try {
            ps=CON.conectar().prepareStatement("SELECT * FROM categorias WHERE nombre LIKE ?");
            ps.setString(1, "%" + texto + "%");
            rs=ps.executeQuery();
            while(rs.next()){
                registros.add(new Categoria(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getBoolean(4)));
            }
            ps.close();
            rs.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, " No se puede mostrar datos en la tabla " + e.getMessage());
        }finally{
            ps=null;
            rs=null;
            CON.desconectar();
        }
        return registros;
    }

    @Override
    public boolean insertar(Categoria obj) {
           resp=false;
           try {
            ps=CON.conectar().prepareStatement("INSERT INTO categorias(nombre,descripcion,condicion) VALUES(?,?,1)");
            ps.setString(1, obj.getNombre());
            ps.setString(2, obj.getDescripcion());
            if(ps.executeUpdate()>0){
                resp=true;
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, " Error al registrar categoria " + e.getMessage());
        }finally{
               ps=null;
               CON.desconectar();
           }
           return resp;
    }

    @Override
    public boolean actualizar(Categoria obj) {
       resp=false;
        try {
            ps=CON.conectar().prepareStatement("UPDATE categorias SET nombre=?, descripcion=? WHERE idcategoria=?");
            ps.setString(1, obj.getNombre());
            ps.setString(2, obj.getDescripcion());
            ps.setInt(3, obj.getIdcategoria());
            if(ps.executeUpdate()>0){
                resp=true;
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se puede actualizar los datos " + e.getMessage());
        }finally{
            ps=null;
            CON.desconectar();
        }
        return resp;
    }

    @Override
    public boolean desactivar(int id) {
         resp=false;
         try {
            ps=CON.conectar().prepareStatement("UPDATE categorias SET condicion=0 WHERE idcategoria=?");
            ps.setInt(1, id);
            if(ps.executeUpdate()>0){
                resp=true;
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se puede desactivar categoria " + e.getMessage());
        }finally{
             ps=null;
             CON.desconectar();
         }
            return resp;
    }
    
    
    
    public boolean activar(int id) {
         resp=false;
         try {
            ps=CON.conectar().prepareStatement("UPDATE categorias SET condicion=1 WHERE idcategoria=?");
            ps.setInt(1, id);
            if(ps.executeUpdate()>0){
                resp=true;
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se puede desactivar categoria " + e.getMessage());
        }finally{
             ps=null;
             CON.desconectar();
         }
            return resp;
    }
    
    
    
    
    

    @Override
    public int total() {
           int totalRegistros=0;
           try {
            ps=CON.conectar().prepareStatement("SELECT COUNT(idcategoria) FROM categorias");
            rs=ps.executeQuery();
            while(rs.next()){
                totalRegistros=rs.getInt("COUNT(idcategoria)");
            }
            ps.close();
            rs.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se puede obtener el total de categorias " + e.getMessage());
        }finally{
               ps=null;
               rs=null;
               CON.desconectar();
           }
           return totalRegistros;
    }

    @Override
    public boolean existe(String texto) {
        resp=false;
        try {
            ps=CON.conectar().prepareStatement("SELECT nombre FROM categorias WHERE nombre=?");
            ps.setString(1, texto);
            rs=ps.executeQuery();
            rs.last();
            if(rs.getRow()>0){
                resp=true;
            }
            ps.close();
            rs.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se puede validar datos " + e.getMessage());
        }finally{
            ps=null;
            rs=null;
            CON.desconectar();
        }
        return resp;
    }
    
    //método para la consulta sql para seleccionar categorias
    public List<Categoria> seleccionar(){
        List<Categoria> registros = new ArrayList();
        try {
            ps=CON.conectar().prepareStatement("SELECT idcategoria,nombre FROM categorias ORDER BY nombre ASC");
            rs=ps.executeQuery();
            while(rs.next()){
                registros.add(new Categoria(rs.getInt(1), rs.getString(2)));
            }
            ps.close();
            rs.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se puede cargar categorias " + e.getMessage());
        }finally{
            ps=null;
            rs=null;
            CON.desconectar();
        }
        return registros;
    }
    
}
