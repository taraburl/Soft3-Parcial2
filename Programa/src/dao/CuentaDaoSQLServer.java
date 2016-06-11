package dao;

import dal.Conexion;
import dto.Cuenta;
import dto.Transaccion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import org.apache.log4j.LogManager;

public class CuentaDaoSQLServer extends CuentaDao {

    private static final org.apache.log4j.Logger logger = LogManager.getRootLogger();

    public CuentaDaoSQLServer() {
        ;
    }

    @Override
    public int insert(Cuenta obj) throws Exception {
        Conexion objConexion = Conexion.getOrCreate();

        int id = 0;

        PreparedStatement ps = objConexion.getObjConnection().prepareStatement("EXEC spinsertarcuenta  ?,?");
        ps.setDouble(1, obj.getSaldo());
        ps.setString(2, obj.getNombreCuenta());

        id = ps.executeUpdate();

        if (id == 0) {
            throw new Exception("El registro no pudo ser insertado");
        }

        objConexion.desconectar();
        return id;
    }

    @Override
    public void update(Cuenta obj) throws Exception {
        Conexion objConexion = Conexion.getOrCreate();

        PreparedStatement ps = objConexion.getObjConnection().prepareStatement("EXEC spactualizarcuenta ?,?,?");
        ps.setInt(1, obj.getIdCuenta());
        ps.setDouble(2, obj.getSaldo());
        ps.setString(3, obj.getNombreCuenta());

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
            PreparedStatement ps = objConexion.getObjConnection().prepareStatement("EXEC speliminarcuenta ?");
            ps.setInt(1, id);
            ps.executeUpdate();
            objConexion.desconectar();
        } catch (SQLException ex) {
            logger.error("Error al Eliminar: " + ex.toString());
        }
    }

    @Override
    public ArrayList<Cuenta> getList() {
        ArrayList<Cuenta> cuentas = new ArrayList<>();
        try {
            Conexion objConexion = Conexion.getOrCreate();
            PreparedStatement ps = objConexion.getObjConnection().prepareStatement("EXEC spselectCuenta");
            ResultSet objResultSet = ps.executeQuery();

            while (objResultSet.next()) {
                Cuenta obj = new Cuenta();
                int _idCuenta = objResultSet.getInt("idCuenta");
                obj.setIdCuenta(_idCuenta);

                String _nombre = objResultSet.getString("nombreCuenta");
                obj.setNombreCuenta(_nombre);

                Double _saldo = objResultSet.getDouble("saldo");
                obj.setSaldo(_saldo);

                cuentas.add(obj);
            }
        } catch (Exception ex) {
            logger.error("Error al obtener todos las cuentas:" + ex.toString());
        }
        return cuentas;

    }

    @Override
    public Cuenta get(int id) {
        try {
            Conexion objConexion = Conexion.getOrCreate();
            PreparedStatement ps = objConexion.getObjConnection().prepareStatement("EXEC spselectCuentaByid ?");
            ps.setInt(1, id);
            ResultSet objResultSet = ps.executeQuery();

            if (objResultSet.next()) {
                Cuenta obj = new Cuenta();
                int _idCuenta = objResultSet.getInt("idCuenta");
                obj.setIdCuenta(_idCuenta);

                String _tipo = objResultSet.getString("nombreCuenta");
                obj.setNombreCuenta(_tipo);

                Double _saldo = objResultSet.getDouble("saldo");
                obj.setSaldo(_saldo);

                return obj;
            }
        } catch (Exception ex) {
            logger.error("Error al obtener Cuenta por id: " + ex.toString());
        }
        return null;
    }

}
