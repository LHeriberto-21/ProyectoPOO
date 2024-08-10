class entidad {
    String nombre;
    String codigo;
    
    public entidad(String nombre, String codigo) {
        this.nombre = nombre;
        this.codigo = codigo;
    }
    
    public void imprimir() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Código: " + codigo);
    }
}
