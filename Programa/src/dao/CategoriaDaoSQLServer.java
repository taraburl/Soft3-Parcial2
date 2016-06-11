package dao;

import dal.Conexion;
import dto.Categoria;
import dto.Cuenta;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import org.apache.log4j.LogManager;

public class CategoriaDaoSQLServer extends CategoriaDao {

    private static final org.apache.log4j.Logger logger = LogManager.getRootLogger();

    public CategoriaDaoSQLServer() {
        ;
    }

    @Override
    public int insert(Categoria obj) throws Exception {
        Conexion objConexion = Conexion.getOrCreate();

        int id = 0;

        PreparedStatement ps = objConexion.getObjConnection().prepareStatement("EXEC spinsertarcategoria  ?,?");
        ps.setString(1, obj.getNombre());
        ps.setString(2, obj.getTipo());
        id = ps.executeUpdate();

        if (id == 0) {
            throw new Exception("El registro no pudo ser insertado");
        }

        objConexion.desconectar();
        return id;

    }

    @Override
    public void update(Categoria obj) throws Exception {
        Conexion objConexion = Conexion.getOrCreate();

        PreparedStatement ps = objConexion.getObjConnection().prepareStatement("EXEC spactualizarcategoria ?,?,?");
        ps.setInt(1, obj.getIdCategoria());
        ps.setString(2, obj.getNombre());
        ps.setString(3, obj.getTipo());
        int upd = ps.executeUpdate();
        if (upd == 0) {
            throw new Exception("El registro no pudo ser insertado");
        }
        objConexion.desconectar();
    }

    @Override
    public void delete(int id) {
        try {
            Conexion objConexion = Conexion.getOrCreate();
            PreparedStatement ps = objConexion.getObjConnection().prepareStatement("EXEC speliminarcategoria ?");
            ps.setInt(1, id);
            ps.executeUpdate();
            objConexion.desconectar();
        } catch (SQLException ex) {
            logger.error("Error al Eliminar: " + ex.toString());
        }
    }

    @Override
    public ArrayList<Categoria> getList() {
        ArrayList<Categoria> categoria = new ArrayList<>();
        try {
            Conexion objConexion = Conexion.getOrCreate();
            PreparedStatement ps = objConexion.getObjConnection().prepareStatement("EXEC spselectCategoria");
            ResultSet objResultSet = ps.executeQuery();

            while (objResultSet.next()) {
                Categoria obj = new Categoria();
                int _idCuenta = objResultSet.getInt("idCategoria");
                obj.setIdCategoria(_idCuenta);

                String _nombre = objResultSet.getString("nombre");
                obj.setNombre(_nombre);

                String _tipo = objResultSet.getString("tipo");
                obj.setTipo(_tipo);

                categoria.add(obj);
            }
        } catch (Exception ex) {
            logger.error("Error al obtener todos las categoria:" + ex.toString());
        }
        return categoria;
    }

    @Override
    public Categoria get(int id) {

        try {
            Conexion objConexion = Conexion.getOrCreate();
            PreparedStatement ps = objConexion.getObjConnection().prepareStatement("EXEC spselectCategoriaByid ?");
            ps.setInt(1, id);
            ResultSet objResultSet = ps.executeQuery();

            if (objResultSet.next()) {
                Categoria obj = new Categoria();
                int _idCuenta = objResultSet.getInt("idCategoria");
                obj.setIdCategoria(_idCuenta);

                String _nombre = objResultSet.getString("nombre");
                obj.setNombre(_nombre);

                String _tipo = objResultSet.getString("tipo");
                obj.setTipo(_tipo);
                return obj;

            }
        } catch (Exception ex) {
            logger.error("Error al obtener todos las categoria:" + ex.toString());
        }
        return null;
    }

    @Override
    public ArrayList<Categoria> getListByTipo(String tipo) {
        ArrayList<Categoria> categorias = new ArrayList<>();
        try {
            Conexion objConexion = Conexion.getOrCreate();

            PreparedStatement ps = objConexion.getObjConnection().prepareStatement("EXEC spCategoriaPorTipo  ?");
            ps.setString(1, tipo);
            ResultSet objResultSet = ps.executeQuery();

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
            logger.error("Error al obtener categoria por tipo: " + e.toString());
        }
        return categorias;
    }

}
