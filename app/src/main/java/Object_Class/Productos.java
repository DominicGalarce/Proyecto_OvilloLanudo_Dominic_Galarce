package Object_Class;

public class Productos {

    private int id;
    private String[] producto = {"lana", "algodón","hilo","trapillo","macrame"};
    private String[] color = {"Rojo", "Azul", "Rosado"};

    public Productos(){
        id = 1;
    }

    public Productos(int id, String[] Producto, String[] color){
        this.id= id;
        this.producto= Producto;
        this.color = color;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String[] getProducto() {
        return producto;
    }

    public void setProducto(String[] producto) {
        this.producto = producto;
    }

    public String[] getColor() {
        return color;
    }

    public void setColor(String[] color) {
        this.color = color;
    }
}
