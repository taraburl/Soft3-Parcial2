package dao;

import dto.Transferencia;
import java.util.ArrayList;

public abstract class TransferenciaDao {

    public abstract int insert(Transferencia obj) throws Exception;

    public abstract void update(Transferencia obj) throws Exception;

    public abstract void delete(int id);

    public abstract ArrayList<Transferencia> getList();

    public abstract Transferencia get(int id);

}
