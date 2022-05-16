/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import java.util.ArrayList;

/**
 *
 * @author Juan Esteban Caicedo
 */
public class Caja
{
    private ArrayList<Tiquete> tiquetes;

    public Caja()
    {
        tiquetes = new ArrayList<>();
    }

    public ArrayList<Tiquete> getTiquetes()
    {
        return tiquetes;
    }
    
    public void agregarTiquete(Tiquete pTiquete)
    {
        /*for(int i = 0; i < serviciosExtras.size(); i++)
        {
            ServicioExtra servicioExtra = serviciosExtras.get(i);
            
            if(servicioExtra == pServicioExtra)
            {
                break;
            }
           
        }*/
        tiquetes.add(pTiquete);
    }
    
    public double darRecaudo()
    {
        double total = 0; 
        
        for(int i = 0; i < tiquetes.size(); i++)
        {
            Tiquete tiquete = tiquetes.get(i);
            total = total + tiquete.getPrecio();
        }
        return total;
    }
}
