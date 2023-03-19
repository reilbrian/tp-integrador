public class equipo {
    public equipo (String nombre,String descripcion,int id){
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.id=id;
    }
    private String descripcion;
    private String nombre;
    private int id;

    public String getNombre() {
        return nombre;
    }

}
