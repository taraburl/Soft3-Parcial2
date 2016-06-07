package dao;

import dal.Conexion;
import dto.Categoria;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class CategoriaDaoSQLServer extends CategoriaDao {

    public CategoriaDaoSQLServer() {
        ;
    }

    @Override
    public int insert(Categoria obj) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Categoria obj) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Categoria> getList() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Categoria get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Categoria> getListByTipo(String tipo) {
        ArrayList<Categoria> categorias = new ArrayList<>();
        try {
            Conexion objConexion = Conexion.getOrCreate();

            PreparedStatement ps = objConexion.getObjConnection().prepareStatement("EXEC spCategoriaPorTipo  ?");
            ps.setString(1, tipo);

            ResultSet objResultSet = objConexion.ejecutar(ps.toString());
            while (objResultSet.next()) {
                Categoria categoria = new Categoria();
                int _categoriaId = objResultSet.getInt("idCategoria");
                categoria.setIdCategoria(_categoriaId);

                String _nombre = objResultSet.getString("nombre");
                categoria.setNombre(_nombre);

                String _tipo = objResultSet.getString("tipo");
                categoria.setTipo(_tipo);
                
                categorias.add(categoria);
            }

            objConexion.desconectar();
        } catch (Exception e) {
        }
        return categorias;
    }

}
