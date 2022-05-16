/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

/**
 *
 * @author Juan Esteban Caicedo
 */
public class Atraccion
{
   private String nombre;
   private String disponibilidad;
   private String rutaImagen;

    public Atraccion(String nombre, String disponibilidad, String rutaImagen)
    {
        this.nombre = nombre;
        this.disponibilidad = disponibilidad;
        this.rutaImagen = rutaImagen;
    }

    public String getNombre()
    {
        return nombre;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    public String getDisponibilidad()
    {
        return disponibilidad;
    }

    public void setDisponibilidad(String disponibilidad)
    {
        this.disponibilidad = disponibilidad;
    }

    public String getRutaImagen()
    {
        return rutaImagen;
    }

    public void setRutaImagen(String rutaImagen)
    {
        this.rutaImagen = rutaImagen;
    }
   
   
}
