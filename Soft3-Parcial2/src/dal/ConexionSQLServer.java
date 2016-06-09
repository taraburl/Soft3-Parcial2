package dal;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexionSQLServer extends Conexion {

    public static Conexion getOrCreate() {
        if (objSingleton == null) {
            objSingleton = new ConexionSQLServer();
        }
        return objSingleton;
    }

    private ConexionSQLServer() {
        Configuracion objConfiguracion
                = Configuracion.getConfiguracion();
        this.host = objConfiguracion.getDbHost();
        this.dataBase = objConfiguracion.getDbName();
        this.instance = objConfiguracion.getDbInstace();
        this.port = objConfiguracion.getDbPort();
        this.userName = objConfiguracion.getDbUser();
        this.password = objConfiguracion.getDbPassword();
    }

    @Override
    public void conectar() {
        if (this.estaConectado()) {
            return;
        } else {
            try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
            } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
                System.out.println("Class not Found Exception: " + e.toString());
            }
            try {
                String sUrl = "jdbc:sqlserver://" + this.host + ":" + this.port + ";"
                        + "databaseName= " + this.dataBase + ";";
                objConnection = DriverManager.getConnection(sUrl, userName, password);
                if (objConnection != null) {
                    System.out.println("Conexión a base de datos " + this.dataBase + " : OK");
                }
            } catch (SQLException e) {
                System.out.println("SQL Exception: " + e.toString());
            }
        }
    }

    @Override
    public void comenzarTransaccion() {
        if (!this.estaConectado()) {
            this.conectar();
        }

        try {
            objConnection.setAutoCommit(false);
        } catch (SQLException e) {
        }
    }

    @Override
    public void terminarTransaccion() {
        try {
            objConnection.commit();
        } catch (SQLException e) {
        }
    }

    @Override
    public void desconectar() {
        try {
            if (this.estaConectado()) {
                objConnection.close();
            }
        } catch (SQLException e) {
        }
    }

    @Override
    public ResultSet ejecutar(String query) {
        try {
            Statement stmt = objConnection.createStatement();
            ResultSet res = stmt.executeQuery(query);
            return res;
        } catch (SQLException e) {
            System.out.println("Error en el metodo ejecutar(): " + e.toString());
            return null;
        }
    }

    @Override
    public boolean estaConectado() {
        if (this.objConnection == null) {
            return false;
        }
        try {
            if (this.objConnection.isClosed()) {
                return false;
            }
        } catch (SQLException e) {
            this.objConnection = null;
            return false;
        }
        return true;
    }

    @Override
    public int ejecutarSimple(String query) {
        try {
            Statement stmt = objConnection.createStatement();
            int nb = stmt.executeUpdate(query);
            return nb;
        } catch (SQLException e) {
            System.out.println("Error en ejecutarSimple(): " + e.toString());
            return 0;
        }
    }

    @Override
    public int ejecutarInsert(String query) {
        try {
            Statement stmt = objConnection.createStatement();
            stmt.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            return rs.getInt(1);
        } catch (SQLException e) {
            System.out.println("Error al ejecutar el metodo ejecutarInsert() " + e.toString());
            return 0;
        }
    }

    @Override
    public void ejecutarConsulta(String sql) {
        try {
            Statement consulta = objConnection.createStatement();
            consulta.executeUpdate(sql);
        } catch (SQLException e) {

        }
    }

    @Override
    public ResultSet obtenerConsulta(String sql) {
        try {
            Statement consulta = objConnection.createStatement();
            return consulta.executeQuery(sql);
        } catch (SQLException e) {
            return null;
        }
    }
}
