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
public class Tiquete
{
    //Constantes   
      
    //Constantes descuentos
    public final static double DESCUENTO_ORO = 0.15; 
    public final static double DESCUENTO_PLATA = 0.1; 
    public final static double DESCUENTO_BRONCE = 0.05;
    
    //Constantes métodos de pago
    public final static String EFECTIVO = "Efectivo";
    public final static String TARJETA = "Tarjeta";
    
    private double precio;
    private String metodoPago;
    private ArrayList <ServicioExtra> serviciosExtras;

    public Tiquete(double precio, String metodoPago)
    {
        this.precio = precio;
        this.metodoPago = metodoPago;
        serviciosExtras = new ArrayList<>();
    }

    public double getPrecio()
    {
        return precio;
    }

    public void setPrecio(double precio)
    {
        this.precio = precio;
    }

    public String getMetodoPago()
    {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago)
    {
        this.metodoPago = metodoPago;
    }

    public ArrayList<ServicioExtra> getServiciosExtras()
    {
        return serviciosExtras;
    }

    public void agregarServicioExtra(ServicioExtra pServicioExtra)
    {
        /*for(int i = 0; i < serviciosExtras.size(); i++)
        {
            ServicioExtra servicioExtra = serviciosExtras.get(i);
            
            if(servicioExtra == pServicioExtra)
            {
                break;
            }
           
        }*/
        serviciosExtras.add(pServicioExtra);
    }
    
    public double calcularTotalServiciosExtras()
    {
        double total = 0;
        
        for(int i = 0; i < serviciosExtras.size(); i++)
        {
            ServicioExtra servicioExtra = serviciosExtras.get(i);
            total += servicioExtra.getPrecio();
        }
        return total;
    }
    
    public double calcularTotalTiquete(String pCategoria)
    {
        double total = 0;
        double totalServiciosExtras = calcularTotalServiciosExtras();
        
        if(pCategoria.equals(AfiliadoDTO.ORO))
        {
            total = totalServiciosExtras + (precio * (1 - DESCUENTO_ORO));
        }
        else if(pCategoria.equals(AfiliadoDTO.PLATA))
        {
            total = totalServiciosExtras + (precio * (1 - DESCUENTO_PLATA));
        }
        else if(pCategoria.equals(AfiliadoDTO.BRONCE))
        {
            total = totalServiciosExtras + (precio * (1 - DESCUENTO_BRONCE));
        }
        else
        {
            total = totalServiciosExtras + precio;
        }
        precio += total;
        return total;
    }

    @Override
    public String toString() {
        return "Tiquete" +
               "\nPrecio = " + precio +
               "\nMétodo de pago: " + metodoPago +
               "\nServicios Extras: " + serviciosExtras + "\n";
    }
    
    
}
