
/**
 *
 *
 *La clase Libro representa un libro con los atributos privados titulo, 
 *edicion, editorial, y anio, que almacenan información básica sobre el libro, como su título, edición, editorial, y año de publicación. Incluye los siguientes métodos públicos:

 *+prestado(): boolean: Devuelve un valor booleano que indica si el libro está prestado.
 *+ultimoPrestamo(): Prestamo: Retorna un objeto de tipo Prestamo que representa la información del último préstamo realizado para el libro.
 *+toString(): String: Devuelve una representación en texto del objeto Libro, usualmente con una descripción de sus atributos.
 * @author Valenzuela Jose Lisandro
 * @version 11032002
 */
public class Libro
{
    private String titulo;
    private int edicion;
    private String editorial;
    private int anio;
    private Prestamo ultimoPrestamo;
    /**
     * Sobre los constructores.
     * decidi utilizar dos constructores para contemplar los casos donde el libro este o no prestado.
     * dado que la relacion es bidireccional con la clase Prestamo hay que tener en cuenta que un libro
     * puede poseer un estado en el que se encuentra prestado.
    */
    public Libro(String p_titulo,int p_edicion,String p_editorial,int p_anio){
        this.setTitulo(p_titulo);
        this.setEdicion(p_edicion);
        this.setEditorial(p_editorial);
        this.setAnio(p_anio);
        this.setUltimoPrestamo(null)
    }
    
     public Libro(String p_titulo,int p_edicion,String p_editorial,int p_anio,Prestamo p_prestamo){
        this.setTitulo(p_titulo);
        this.setEdicion(p_edicion);
        this.setEditorial(p_editorial);
        this.setAnio(p_anio);
        this.setUltimoPrestamo(p_prestamo);
    }
    
    private void setUltimoPrestamo(Prestamo p_prestamo){
        this.ultimoPrestamo=p_prestamo;
    }
    
    private void setTitulo(String p_titulo){
        this.titulo=p_titulo;
    }
    private void setEdicion(int p_edicion){
        this.edicion=p_edicion;
    }
    private void setEditorial(String p_editorial){
        this.editorial=p_editorial;
    }
    private void setAnio(int p_anio){
        this.anio=p_anio;
    }
    
    public String getTitulo(){
        return this.titulo;
    }
    
    public int getEdicion(){
        return this.edicion;
    }
    
    public String getEditorial(){
        return this.editorial;
    }
    
    public int getAnio(){
        return this.anio;
    }
    public Prestamo getUltimoPrestamo(){
        return this.ultimoPrestamo;
    }
    
/**
 * Verifica si el libro está prestado.
 *
 * Este método retorna "Sí" si el libro tiene un préstamo activo 
 * y "No" si no lo está.
 *
 * @return "Sí" si el libro está prestado, "No" en caso contrario.
 * 
 * nota! utilizar esto para las impresiones de estado donde el formato sea "PRESTADO: SI"
 */
    public String prestadoString() {
        return this.getPrestamo() != null ? "Sí" : "No"; // Retorna "Sí" si hay un préstamo, "No" si no
    }
/**
 * NOTA: este metodo puede ser mas util para casos donde se deba contar la cantidad de libros prestados 
 * 
*/
    public boolean prestado(){
        if(this.getUltimoPrestamo()==null){
           return false;
        }else{
            return true;
        }
    }
/**
 * Metodo ultimoPrestamo
 * 
 * Este metodo comprueba el estado de un libro,que puede ser prestado. Si se intenta acceder al último préstamo
 * cuando no hay ninguno, se lanzará LibroNoPrestadoException;
 * 
 * @return retorna el prestamo siempre y cuando este exista.
 * @throw si el prestamo no se ha realizado se tira una excepcion de tipo LibroNoPrestadoException.
 * 
 * Sobre Incluir throws en la firma de un método: es una forma de indicar que el método puede lanzar
 * una excepción específica.
 * 
 * Al declarar throws en la firma de un método, se define un contrato.
 * Este contrato especifica que, al utilizar este método, el llamador debe estar preparado para manejar la excepción indicada.
 * Si no se maneja, el programa puede fallar inesperadamente en tiempo de ejecución.
 * 
 * en resumen: utilizar este metodo dentro de un bloque seguro try-catch.
 */
   public Prestamo ultimoPrestamo() throws LibroNoPrestadoException {
    if (this.getUltimoPrestamo() == null) {
        throw new LibroNoPrestadoException("El libro no ha sido solicitado para préstamo");
    }
    return this.getUltimoPrestamo();
    }
    
 /**
  * - toString(): devuelve el siguiente String: Titulo: <<titulo>>
  * Ejemplo: Titulo: JAVA. Como Programar
  * @return String.
 */

    public String toString(){
        return "Titulo: "+this.getTitulo();
    }
    
}
