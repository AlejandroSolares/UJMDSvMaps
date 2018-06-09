package clases;

/**
 * Created by cesar on 24/4/2018.
 */

public class Usuarios {
    private int cod_usuario;
    private String usuario;
    private String password;

    public Usuarios() {
    }

    public Usuarios(int cod_usuario, String usuario, String password) {
        this.cod_usuario = cod_usuario;
        this.usuario = usuario;
        this.password = password;
    }

    public int getCod_usuario() {
        return cod_usuario;
    }

    public void setCod_usuario(int cod_usuario) {
        this.cod_usuario = cod_usuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    @Override
    public String toString() {
        return "Usuarios{" +
                "cod_usuario=" + cod_usuario +
                ", usuario='" + usuario + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
