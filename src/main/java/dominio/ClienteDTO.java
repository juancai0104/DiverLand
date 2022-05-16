/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

/**
 *
 * @author Juan Esteban Caicedo
 */
public class ClienteDTO extends PersonaDTO
{
    private String afiliado;

    public ClienteDTO()
    {
        
    } 

    public ClienteDTO(String afiliado, String numDocumento, String apellidos, String nombres)
    {
        super(numDocumento, apellidos, nombres);
        this.afiliado = afiliado;
    }

    public String getAfiliado()
    {
        return afiliado;
    }

    public void setAfiliado(String afiliado)
    {
        this.afiliado = afiliado;
    }  
}
