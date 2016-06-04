package dto;

public class Cuenta {

    private int idCuenta;
    private double saldo;
    private String nimbreCuenta;

    public Cuenta() {
        ;
    }

    public int getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(int idCuenta) {
        this.idCuenta = idCuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getNimbreCuenta() {
        return nimbreCuenta;
    }

    public void setNimbreCuenta(String nimbreCuenta) {
        this.nimbreCuenta = nimbreCuenta;
    }

}
