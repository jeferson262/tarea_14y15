package datos.CrudInterface;

import java.util.List;

public interface ProductoInterface<t> {

    public List<t> listar(String texto);

    public boolean insertar(t obj);
    public boolean actualizar(t obj);
    public boolean desactivar(int id);
    public boolean activar(int id);
    public int total();
    public boolean existe(String texto);
}
