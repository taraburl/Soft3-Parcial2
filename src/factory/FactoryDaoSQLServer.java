package factory;

import dao.*;

public class FactoryDaoSQLServer extends FactoryDao {

    private FactoryDaoSQLServer() {
        dbEngine = "SQLServer";
    }

    public static FactoryDao getFactoryInstance() {
        if (instancia == null) {
            instancia = new FactoryDaoSQLServer();
        }
        return instancia;
    }

    @Override
    public CategoriaDao getNewCategoriaDao() {
        return new CategoriaDaoSQLServer();
    }

    @Override
    public CuentaDao getNewCuentaDao() {
        return new CuentaDaoSQLServer();
    }

    @Override
    public TransferenciaDao getNewTransferenciaDao() {
        return new TransferenciaDaoSQLServer();
    }

    @Override
    public TransaccionDao getNewTransaccionDao() {
        return new TransaccionDaoSQLServer();
    }

    @Override
    public UsuarioDao getNewUsuarioDao() {
        return new UsuarioDaoSQLServer();
    }

}
