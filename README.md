# Prueba-t-cnica-desarrollador-Android-


Scenario Practico
mostrar en pantalla el resultado de una consulta a un servicio, para ello es necesario cumplir con los siguientes requerimientos:

◦ Tener un título grande y claro que describa la información que se está mostrando

◦ Una barra de búsqueda funcional, la cual debe filtrar el contenido de la lista de acuerdo al nombre de usuario , es decir que el listado se debe actualizar conforme a los resultados obtenidos por la búsqueda

◦ Mostrar en pantalla un listado de usuarios con la siguiente información que suministra el servicio consultado:

▪ id = identificador del usuario.

▪ name = nombre del usuario.

▪ username = alias del usuario.

▪ email = correo del usuario.

▪ phone = teléfono del usuario.

▪ website = sitio web del usuario.





Solución 5. Defina una clase en al cuál se describa el concepto de persona


    public class Persona {

    private String nombre;
    private String apellido;
    private String altura;
    private String peso;

    public Persona(String nombre, String apellido, String altura, String peso) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.altura = altura;
        this.peso = peso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getAltura() {
        return altura;
    }

    public void setAltura(String altura) {
        this.altura = altura;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public String comer() {
        setPeso(peso + 1);
        return getPeso();
    }

    public String crecer() {
        setAltura(altura + 1);
        return getAltura();
    }}
