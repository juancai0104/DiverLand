/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import java.util.Date;

/**
 *
 * @author Juan Esteban Caicedo
 */
public class PersonaDTO
{
    private String numDocumento;
    private String apellidos;
    private String nombres;

    public PersonaDTO()
    {
        
    }  

    public PersonaDTO(String numDocumento, String apellidos, String nombres)
    {
        this.numDocumento = numDocumento;
        this.apellidos = apellidos;
        this.nombres = nombres;
    }

    public String getNumDocumento()
    {
        return numDocumento;
    }

    public void setNumDocumento(String numDocumento)
    {
        this.numDocumento = numDocumento;
    }

    public String getApellidos()
    {
        return apellidos;
    }

    public void setApellidos(String apellidos)
    {
        this.apellidos = apellidos;
    }

    public String getNombres()
    {
        return nombres;
    }

    public void setNombres(String nombres)
    {
        this.nombres = nombres;
    }

    @Override
    public String toString()
    {
        return apellidos + nombres;
    }
}
