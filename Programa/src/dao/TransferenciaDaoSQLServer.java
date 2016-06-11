package dao;

import dal.Conexion;
import dto.Transferencia;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import org.apache.log4j.LogManager;

public class TransferenciaDaoSQLServer extends TransferenciaDao {

    private static final org.apache.log4j.Logger logger = LogManager.getRootLogger();

    

    @Override
    public int insert(Transferencia obj) throws Exception {
        Conexion objConexion = Conexion.getOrCreate();

        int id = 0;

        PreparedStatement ps = objConexion.getObjConnection().prepareStatement("EXEC spInsertTransferencia  ?,?,?,?,?");
        ps.setDouble(1, obj.getMonto());
        ps.setDate(2, (Date) obj.getFechaHora());
        ps.setString(3, obj.getDescripcion());
        ps.setInt(4, obj.getIdCuentaOrigen());
        ps.setInt(5, obj.getIdCuentaDestino());

        id = ps.executeUpdate();

        if (id == 0) {
            throw new Exception("No se pudo insertar la transferencia");
        }

        objConexion.desconectar();
        return id;
    }

    @Override
    public void update(Transferencia obj) throws Exception {
        Conexion objConexion = Conexion.getOrCreate();

        PreparedStatement ps = objConexion.getObjConnection().prepareStatement("EXEC spUpdateTransferencia ?,?,?,?,?,?");
        ps.setInt(1, obj.getIdTransferencia());
        ps.setDouble(2, obj.getMonto());
        ps.setDate(3, (Date) obj.getFechaHora());
        ps.setString(4, obj.getDescripcion());
        ps.setInt(5, obj.getIdCuentaOrigen());
        ps.setInt(6, obj.getIdCuentaDestino());
        int upd = ps.executeUpdate();
        if (upd == 0) {
            throw new Exception("no se pudo editar Transferencia");
        }
        objConexion.desconectar();
    }

    @Override
    public void delete(int id) {
        try {
            Conexion objConexion = Conexion.getOrCreate();
            PreparedStatement ps = objConexion.getObjConnection().prepareStatement("EXEC spDeleteTransferencia ?");
            ps.setInt(1, id);
            ps.executeUpdate();
            objConexion.desconectar();
        } catch (SQLException ex) {
            logger.error("Error al Eliminar: " + ex.toString());
        }
    }

    @Override
    public ArrayList<Transferencia> getList() {
        ArrayList<Transferencia> transacciones = new ArrayList<>();
        try {
            Conexion objConexion = Conexion.getOrCreate();
            PreparedStatement ps = objConexion.getObjConnection().prepareStatement("EXEC spSelectAllTransferencia");
            ResultSet objResultSet = ps.executeQuery();

            while (objResultSet.next()) {
                Transferencia obj = new Transferencia();
                int _idTransferencia = objResultSet.getInt("idTransferencia");
                obj.setIdTransferencia(_idTransferencia);

                Double _monto = objResultSet.getDouble("monto");
                obj.setMonto(_monto);

                Date _fechahora = objResultSet.getDate("fechaHora");
                obj.setFechaHora(_fechahora);

                String _descripcion = objResultSet.getString("descripcion");
                obj.setDescripcion(_descripcion);

                int _idCuentaOrigen = objResultSet.getInt("idCuentaOrigen");
                obj.setIdCuentaOrigen(_idCuentaOrigen);

                int _idCuentaDestino = objResultSet.getInt("idCuentaDestino");
                obj.setIdCuentaDestino(_idCuentaDestino);

                transacciones.add(obj);
            }
        } catch (Exception ex) {
            logger.error("Error al obtener todos las transacciones:" + ex.toString());
        }
        return transacciones;
    }

    @Override
    public Transferencia get(int id) {
        try {
            Conexion objConexion = Conexion.getOrCreate();
            PreparedStatement ps = objConexion.getObjConnection().prepareStatement("EXEC spTransferenciaById ?");
            ps.setInt(1, id);
            ResultSet objResultSet = ps.executeQuery();

            if (objResultSet.next()) {
                Transferencia obj = new Transferencia();
                int _idTransferencia = objResultSet.getInt("idTransferencia");
                obj.setIdTransferencia(_idTransferencia);

                Double _monto = objResultSet.getDouble("monto");
                obj.setMonto(_monto);

                Date _fechahora = objResultSet.getDate("fechaHora");
                obj.setFechaHora(_fechahora);

                String _descripcion = objResultSet.getString("descripcion");
                obj.setDescripcion(_descripcion);

                int _idCuentaOrigen = objResultSet.getInt("idCuentaOrigen");
                obj.setIdCuentaOrigen(_idCuentaOrigen);

                int _idCuentaDestino = objResultSet.getInt("idCuentaDestino");
                obj.setIdCuentaDestino(_idCuentaDestino);

                return obj;
            }
        } catch (Exception ex) {
            logger.error("Error al obtener Transferencia por id: " + ex.toString());
        }
        return null;
    }

}
