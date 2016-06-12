package dao;

import dal.Conexion;
import dto.Transaccion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import org.apache.log4j.LogManager;

public class TransaccionDaoSQLServer extends TransaccionDao {

    private static final org.apache.log4j.Logger logger = LogManager.getRootLogger();

    public TransaccionDaoSQLServer() {
        ;
    }

    @Override
    public int insert(Transaccion obj) throws Exception {
        Conexion objConexion = Conexion.getOrCreate();

        int id = 0;

        PreparedStatement ps = objConexion.getObjConnection().prepareStatement("EXEC spInsertTransaccion  ?,?,?,?,?,?,?");
        ps.setString(1, obj.getTipo());
        ps.setString(2, obj.getDescripcion());
        ps.setDouble(3, obj.getMonto());
        ps.setString(4, obj.getFecha());
        ps.setString(5, obj.getHora());
        ps.setInt(6, obj.getIdCategoria());
        ps.setInt(7, obj.getIdCuenta());
        id = ps.executeUpdate();
        if (id == 0) {
            throw new Exception("El registro no pudo ser insertado");
        }

        objConexion.desconectar();
        return id;
    }

    @Override
    public void update(Transaccion obj) throws Exception {
        Conexion objConexion = Conexion.getOrCreate();

        PreparedStatement ps = objConexion.getObjConnection().prepareStatement("EXEC spUpdateTransaccion ?,?,?,?,?,?,?,?");
        ps.setInt(1, obj.getIdTransaccion());
        ps.setString(2, obj.getTipo());
        ps.setString(3, obj.getDescripcion());
        ps.setDouble(4, obj.getMonto());
        ps.setString(5, obj.getFecha());
        ps.setString(6, obj.getHora());
        ps.setInt(7, obj.getIdCategoria());
        ps.setInt(8, obj.getIdCuenta());
        int upd = ps.executeUpdate();
        ps.getMoreResults();
        if (upd == 0) {
            throw new Exception("El registro no pudo ser actualizado");
        }
        objConexion.desconectar();
    }

    @Override
    public void delete(int id) {
        try {
            Conexion objConexion = Conexion.getOrCreate();
            PreparedStatement ps = objConexion.getObjConnection().prepareStatement("EXEC spDeleteTransaccion ?");
            ps.setInt(1, id);
            ps.executeUpdate();
            objConexion.desconectar();
        } catch (SQLException ex) {
            logger.error("Error al Eliminar: " + ex.toString());
        }
    }

    @Override
    public ArrayList<Transaccion> getList() {
        ArrayList<Transaccion> transacciones = new ArrayList<>();
        try {
            Conexion objConexion = Conexion.getOrCreate();
            PreparedStatement ps = objConexion.getObjConnection().prepareStatement("EXEC spTransacciones");
            ResultSet objResultSet = ps.executeQuery();

            while (objResultSet.next()) {
                Transaccion obj = new Transaccion();
                int _idTransaccion = objResultSet.getInt("idTransaccion");
                obj.setIdTransaccion(_idTransaccion);

                String _tipo = objResultSet.getString("tipo");
                obj.setTipo(_tipo);

                String _descripcion = objResultSet.getString("descripcion");
                obj.setDescripcion(_descripcion);

                Double _monto = objResultSet.getDouble("monto");
                obj.setMonto(_monto);

                int _idCategoria = objResultSet.getInt("idCategoria");
                obj.setIdCategoria(_idCategoria);

                int _idCuenta = objResultSet.getInt("idCuenta");
                obj.setIdCuenta(_idCuenta);

                String _fecha = objResultSet.getString("fecha");
                obj.setFecha(_fecha);

                String _hora = objResultSet.getString("hora");
                obj.setHora(_hora);

                transacciones.add(obj);
            }
        } catch (Exception ex) {
            logger.error("Error al obtener todos las transacciones:" + ex.toString());
        }
        return transacciones;
    }

    @Override
    public Transaccion get(int id) {
        try {
            Conexion objConexion = Conexion.getOrCreate();
            PreparedStatement ps = objConexion.getObjConnection().prepareStatement("EXEC sbTransaccionesById ?");
            ps.setInt(1, id);
            ResultSet objResultSet = ps.executeQuery();

            if (objResultSet.next()) {
                Transaccion obj = new Transaccion();
                int _idTransaccion = objResultSet.getInt("idTransaccion");
                obj.setIdTransaccion(_idTransaccion);

                String _tipo = objResultSet.getString("tipo");
                obj.setTipo(_tipo);

                String _descripcion = objResultSet.getString("descripcion");
                obj.setDescripcion(_descripcion);

                Double _monto = objResultSet.getDouble("monto");
                obj.setMonto(_monto);

                int _idCategoria = objResultSet.getInt("idCategoria");
                obj.setIdCategoria(_idCategoria);

                int _idCuenta = objResultSet.getInt("idCuenta");
                obj.setIdCuenta(_idCuenta);

                String _fecha = objResultSet.getString("fecha");
                obj.setFecha(_fecha);

                String _hora = objResultSet.getString("hora");
                obj.setHora(_hora);

                return obj;
            }
        } catch (Exception ex) {
            logger.error("Error al obtenr Transaccion por id: " + ex.toString());
        }
        return null;
    }

    @Override
    public ArrayList<Transaccion> getListByCuenta(int id) {
        ArrayList<Transaccion> transacciones = new ArrayList<>();
        try {
            Conexion objConexion = Conexion.getOrCreate();
            PreparedStatement ps = objConexion.getObjConnection().prepareStatement("EXEC spTransaccionesByIdCuenta ?");
            ps.setInt(1, id);
            ResultSet objResultSet = ps.executeQuery();

            while (objResultSet.next()) {
                Transaccion obj = new Transaccion();
                int _idTransaccion = objResultSet.getInt("idTransaccion");
                obj.setIdTransaccion(_idTransaccion);

                String _tipo = objResultSet.getString("tipo");
                obj.setTipo(_tipo);

                String _descripcion = objResultSet.getString("descripcion");
                obj.setDescripcion(_descripcion);

                Double _monto = objResultSet.getDouble("monto");
                obj.setMonto(_monto);

                int _idCategoria = objResultSet.getInt("idCategoria");
                obj.setIdCategoria(_idCategoria);

                int _idCuenta = objResultSet.getInt("idCuenta");
                obj.setIdCuenta(_idCuenta);

                String _fecha = objResultSet.getString("fecha");
                obj.setFecha(_fecha);

                String _hora = objResultSet.getString("hora");
                obj.setHora(_hora);

                transacciones.add(obj);
            }
        } catch (Exception ex) {
            logger.error("Error al obtener todos las transacciones:" + ex.toString());
        }
        return transacciones;
    }

}
