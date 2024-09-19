package datos;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import database.Conexion;
import datos.CrudInterface.ProductoInterface;
import entidades.Productos;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import java.sql.ResultSet;

public class productoDAO implements ProductoInterface<Productos> {
    //variables

    private final Conexion CON;
    private PreparedStatement ps;
    private ResultSet as;
    private boolean resp;

    //constructor
    public productoDAO() {
        CON = Conexion.getInstancia();
    }

    public List<Productos> listar(String texto) {
        List<Productos> registros = new ArrayList<>();
        try {
            ps =CON.conectar().prepareStatement("SELECT * FROM productos WHERE nombre_producto LIKE ?");
            ps.setString(1, "%" + texto + "%");
            as = ps.executeQuery();
            while (as.next()) {
                registros.add(new Productos(as.getInt(1),as.getInt(2),as.getString(3), as.getString(4), as.getString(5), as.getString(6), as.getString(7), as.getInt(8), as.getString(9), as.getDouble(10), as.getBoolean(11)));
            }
            ps.close();
            as.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, " No se puede mostrar datos en la tabla " + e.getMessage());
        } finally {
            ps = null;
            as = null;
            CON.desconectar();
        }
        return registros;
    }

    public boolean insertar(Productos obj) {
        resp = false;
        try {
            ps = (PreparedStatement) CON.conectar().prepareStatement("INSERT INTO productos(nombre_producto,descripcion_producto,marca_producto,cantidad_producto,fecha_vencimiento,"
                    + "precio_compra,condicion,imagen_producto) VALUES(?,?,1)");
            ps.setString(1, obj.getNombre_producto());
            ps.setString(2, obj.getDescripcion_producto());
            ps.setString(3, obj.getImagen_producto());
            ps.setString(4, obj.getCodigo_producto());
            ps.setString(5, obj.getMarca_producto());
            ps.setInt(6, obj.getCantidad_producto());
            ps.setString(7, obj.getFecha_vencimiento());
            ps.setDouble(3, obj.getPrecio_compra());

            if (ps.executeUpdate() > 0) {
                resp = true;
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, " Error al registrar productos " + e.getMessage());
        } finally {
            ps = null;
            CON.desconectar();
        }
        return resp;
    }

    public boolean actualizar(Productos obj) {
        resp = false;
        try {
            ps = (PreparedStatement) CON.conectar().prepareStatement("UPDATE producto SET nombre_producto=?, descripcion_producto=? WHERE idproducto=?");
            ps.setString(1, obj.getNombre_producto());
            ps.setString(2, obj.getDescripcion_producto());
            ps.setString(3, obj.getImagen_producto());
            ps.setString(4, obj.getCodigo_producto());
            ps.setString(5, obj.getMarca_producto());
            ps.setInt(6, obj.getCantidad_producto());
            ps.setString(7, obj.getFecha_vencimiento());
            ps.setDouble(3, obj.getPrecio_compra());
            if (ps.executeUpdate() > 0) {
                resp = true;
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se puede actualizar los datos " + e.getMessage());
        } finally {
            ps = null;
            CON.desconectar();
        }
        return resp;
    }

    public boolean desactivar(int id) {
        resp = false;
        try {
            ps = (PreparedStatement) CON.conectar().prepareStatement("UPDATE productos SET condicion=0 WHERE idproducto=?");
            ps.setInt(1, id);
            if (ps.executeUpdate() > 0) {
                resp = true;
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se puede desactivar producto " + e.getMessage());
        } finally {
            ps = null;
            CON.desconectar();
        }
        return resp;
    }


    public int total() {
        int totalRegistros = 0;
        try {
            ps = (PreparedStatement) CON.conectar().prepareStatement("SELECT COUNT(idproducto) FROM productos");
            as = ps.executeQuery();
            while (as.next()) {
                totalRegistros = as.getInt("COUNT(idproducto)");
            }
            ps.close();
            as.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se puede obtener el total de productos" + e.getMessage());
        } finally {
            ps = null;
            as = null;
            CON.desconectar();
        }
        return totalRegistros;
    }

    public boolean existe(String texto) {
        resp = false;
        try {
            ps =CON.conectar().prepareStatement("SELECT nombre FROM productos WHERE nombre_producto=?");
            ps.setString(1, texto);
            as = ps.executeQuery();
            as.last();
            if (as.getRow() > 0) {
                resp = true;
            }
            ps.close();
            as.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se puede validar datos " + e.getMessage());
        } finally {
            ps = null;
            as = null;
            CON.desconectar();
        }
        return resp;
    }

    //método para la consulta sql para seleccionar categorias
    public List<Productos> seleccionar() {
        List<Productos> registros = new ArrayList();
        try {
            ps =CON.conectar().prepareStatement("SELECT (idproducto,categoria_id), nombre_producto FROM productos ORDER BY nombre_producto ASC");
            as = ps.executeQuery();
            while (as.next()){
                registros.add(new Productos(as.getInt(1),as.getInt(2),as.getString(3)));
            }
            ps.close();
            as.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se puede cargar productos " + e.getMessage());
        } finally {
            ps = null;
            as = null;
            CON.desconectar();
        }
        return registros;
    }

}
