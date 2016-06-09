package dao;

import dto.Transaccion;
import java.util.ArrayList;

public abstract class TransaccionDao {

    public abstract int insert(Transaccion obj) throws Exception;

    public abstract void update(Transaccion obj) throws Exception;

    public abstract void delete(int id);

    public abstract ArrayList<Transaccion> getList();

    public abstract Transaccion get(int id);

    public abstract ArrayList<Transaccion> getListByCuenta(int id);

}
