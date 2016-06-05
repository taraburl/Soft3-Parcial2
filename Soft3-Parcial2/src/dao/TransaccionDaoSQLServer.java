package dao;

import dal.Conexion;
import dto.Transaccion;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TransaccionDaoSQLServer extends TransaccionDao {

    public TransaccionDaoSQLServer() {
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
        id = objConexion.ejecutarInsert(ps.toString());

        if (id == 0) {
            throw new Exception("El registro no pudo ser insertado");
        }

        objConexion.desconectar();
        return id;
    }

    @Override
    public void update(Transaccion obj) throws Exception {
        Conexion objConexion = Conexion.getOrCreate();

        PreparedStatement ps = objConexion.getObjConnection().prepareStatement("EXEC spUpdateTransaccion ?, ?,?,?,?,?,?");
        ps.setInt(1, obj.getIdTransaccion());
        ps.setString(2, obj.getTipo());
        ps.setString(3, obj.getDescripcion());
        ps.setDouble(4, obj.getMonto());
        ps.setString(5, obj.getFecha());
        ps.setString(6, obj.getHora());
        ps.setInt(7, obj.getIdCategoria());
        ps.setInt(8, obj.getIdCuenta());
        int upd = objConexion.ejecutarSimple(ps.toString());
        if (upd == 0) {
            throw new Exception("El registro no pudo ser insertado");
        }
        objConexion.desconectar();
    }

    @Override
    public void delete(int id) {
        try {
            Conexion objConexion = Conexion.getOrCreate();
            PreparedStatement ps = objConexion.getObjConnection().prepareStatement("EXEC spDeleteTransaccion ?");
            ps.setInt(1, id);
            objConexion.ejecutarSimple(ps.toString());
            objConexion.desconectar();
        } catch (SQLException ex) {
            Logger.getLogger(TransaccionDaoSQLServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public ArrayList<Transaccion> getList() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Transaccion get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
