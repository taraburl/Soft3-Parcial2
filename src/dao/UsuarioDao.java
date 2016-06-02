package dao;

import dto.Usuario;
import java.util.ArrayList;

public abstract class UsuarioDao {

    public abstract int insert(Usuario obj) throws Exception;

    public abstract void update(Usuario obj) throws Exception;

    public abstract void delete(int id);

    public abstract ArrayList<Usuario> getList();

    public abstract Usuario get(int id);
}
