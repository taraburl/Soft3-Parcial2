package factory;

import dal.Configuracion;
import dao.*;

public abstract class FactoryDao {

    protected static FactoryDao instancia;
    protected String dbEngine;

    public static FactoryDao getFactoryInstance() {
        Configuracion config = Configuracion.getConfiguracion();
        if (instancia == null || !instancia.getDbEngine().equals(config.getDbEngine())) {

            if (config.getDbEngine().equals("SQLServer"));
            instancia = FactoryDaoSQLServer.getFactoryInstance();
        }
        return instancia;
    }

    public abstract CategoriaDao getNewCategoriaDao();

    public abstract CuentaDao getNewCuentaDao();

    public abstract TransferenciaDao getNewTransferenciaDao();

    public abstract TransaccionDao getNewTransaccionDao();
    
    private String getDbEngine() {
        return dbEngine;
    }

    private void setDbEngine(String dbEngine) {
        this.dbEngine = dbEngine;
    }
}
