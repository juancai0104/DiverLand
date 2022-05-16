/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

/**
 *
 * @author Juan Esteban Caicedo
 */
public class AfiliadoDTO extends ClienteDTO
{
    //Constantes categorías
    public final static String ORO = "ORO";
    public final static String PLATA = "PLATA";
    public final static String BRONCE = "BRONCE"; 
    
    private int idAfiliado;
    private String categoria;

    public AfiliadoDTO()
    {
        
    }

    public AfiliadoDTO(int idAfiliado)
    {
        this.idAfiliado = idAfiliado;
    }
    
    public AfiliadoDTO(String categoria, String afiliado, String numDocumento, String apellidos, String nombres)
    {
        super(afiliado, numDocumento, apellidos, nombres);
        this.categoria = categoria;
    }
      
    public AfiliadoDTO(int idAfiliado, String afiliado, String numDocumento, String apellidos, String nombres)
    {
        super(afiliado, numDocumento, apellidos, nombres);
        this.idAfiliado = idAfiliado;
    }

    public int getIdAfiliado()
    {
        return idAfiliado;
    }

    public void setIdAfiliado(int idAfiliado)
    {
        this.idAfiliado = idAfiliado;
    }

    public String getCategoria()
    {
        return categoria;
    }

    public void setCategoria(String categoria)
    {
        this.categoria = categoria;
    }    
}
