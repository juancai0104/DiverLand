/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoDiverLand;

import controlador.Controlador;
import vista.DialogoAgregarAfiliado;
import vista.InterfazDiverland;

/**
 *
 * @author Juan Esteban Caicedo
 */
public class ProyectoDiverLand
        
{
    public static void main(String[] args)
    {
        InterfazDiverland vistaPrincipal = new InterfazDiverland();
        //DialogoAgregarAfiliado dialogoAgregarAfiliado = new DialogoAgregarAfiliado(null, true);
        //DialogoInsertarEstudiante vistaInsertarEstudiante = new DialogoInsertarEstudiante(null, true);
        //DialogoListarEstudiante vistaListarEstudiante = new DialogoListarEstudiante(null, true);
        //EstudianteDAOJDBC modeloEstudiante = new EstudianteDAOJDBC();
        
        Controlador controlador = new Controlador(vistaPrincipal);
    
        vistaPrincipal.setVisible(true);
        vistaPrincipal.setLocationRelativeTo(null);
    }
}
