package dao;

import dto.Cuenta;
import java.util.ArrayList;

public abstract class CuentaDao {

    public abstract int insert(Cuenta obj) throws Exception;

    public abstract void update(Cuenta obj) throws Exception;

    public abstract void delete(int id);

    public abstract ArrayList<Cuenta> getList();

    public abstract Cuenta get(int id);

}
