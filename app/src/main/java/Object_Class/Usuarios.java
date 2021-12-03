package Object_Class;

public class Usuarios {

    private int[] id = {1,2,3};
    private String[] usuario = {"Dominic","Roberto","Susan"};
    private String[] password = {"Domi2021","Robert2021","Sus2021"};

    public Usuarios() {

    }

    public Usuarios(int[] id, String[] usuario, String[] password) {
        this.id = id;
        this.usuario = usuario;
        this.password = password;
    }

    public int[] getId() {
        return id;
    }

    public void setId(int[] id) {
        this.id = id;
    }

    public String[] getUsuario() {
        return usuario;
    }

    public void setUsuario(String[] usuario) {
        this.usuario = usuario;
    }

    public String[] getPassword() {
        return password;
    }

    public void setPassword(String[] password) {
        this.password = password;
    }
}
