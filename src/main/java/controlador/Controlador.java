/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import datos.AfiliadoDAO;
import datos.AfiliadoDAOJDBC;
import datos.Conexion;
import dominio.AfiliadoDTO;
import dominio.Caja;
import dominio.ServicioExtra;
import dominio.Tiquete;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import vista.DialogoAgregarAfiliado;
import vista.InterfazDiverland;

/**
 *
 * @author Juan Esteban Caicedo
 */
public class Controlador implements ActionListener
{
    InterfazDiverland vistaPrincipal = new InterfazDiverland();
    //DialogoAgregarAfiliado dialogoAgregarAfiliado = new DialogoAgregarAfiliado(null, true);
    private Caja caja;

    public Controlador(InterfazDiverland vista)
    {
        vistaPrincipal = vista;
        //dialogoAgregarAfiliado = vistaDos;
        caja = new Caja();
        
        vistaPrincipal.btnValidar.addActionListener(this);
        vistaPrincipal.btnAgregar.addActionListener(this);
        vistaPrincipal.btnVender.addActionListener(this);
        vistaPrincipal.btnRecaudo.addActionListener(this);
        //dialogoAgregarAfiliado.btnAgregarAfiliado.addActionListener(this);
    }
    
    public void inicializar()
    {
        
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == vistaPrincipal.btnValidar)
        {
            boolean parametrosOK = true;
            String idTexto = vistaPrincipal.txtIdAfiliado.getText();
            int id = Integer.parseInt(idTexto);
            AfiliadoDTO afiliado = null;
        
            if(idTexto.equals(""))
            {
                parametrosOK = false;
                JOptionPane.showMessageDialog(null, "Se deben ingresar los datos básicos");
            }
            if(parametrosOK)
            {  
                Connection conexion = null;
                try
                {
                    conexion = Conexion.getConnection();
                
                    if(conexion.getAutoCommit())
                    {
                        conexion.setAutoCommit(false);
                    }

                    AfiliadoDAO estudianteDAO = new AfiliadoDAOJDBC(conexion);
            
                    afiliado = new AfiliadoDTO(id);
                   
                    if(estudianteDAO.selectId(afiliado) == null)
                    {
                        JOptionPane.showMessageDialog(null, "El ID digitado no coincide con algún afiliado");
                        vistaPrincipal.txtNoDocumento.setText("");
                        vistaPrincipal.txtApellidos.setText("");
                        vistaPrincipal.txtNombres.setText("");
                        vistaPrincipal.txtCategoria.setText("");
                    }
                    else
                    {
                        vistaPrincipal.txtNoDocumento.setText(estudianteDAO.selectId(afiliado).getNumDocumento());
                        vistaPrincipal.txtApellidos.setText(estudianteDAO.selectId(afiliado).getApellidos());
                        vistaPrincipal.txtNombres.setText(estudianteDAO.selectId(afiliado).getNombres());
                        vistaPrincipal.txtCategoria.setText(estudianteDAO.selectId(afiliado).getCategoria());
                    }

                    conexion.commit();
                    System.out.println("Se ha hecho commit de la transaccion");
                }
                catch(SQLException ex)
                {            
                    ex.printStackTrace(System.out);                
                    System.out.println("Entramos al rollback");
                    try
                    {
                        conexion.rollback();
                    }
                    catch(SQLException ex1)
                    {
                        ex1.printStackTrace(System.out);
                    }
                }        
            }
        }
        
        if(e.getSource() == vistaPrincipal.btnAgregar)
        {
            boolean parametrosOK = true;
            String categoria = vistaPrincipal.txtCategoriaNuevo.getText();
            String afiliadoSi = vistaPrincipal.comboBoxAfiliadoSi.getSelectedItem().toString();
            String noDocumento = vistaPrincipal.txtNoDocumentoNuevo.getText();
            String apellidos = vistaPrincipal.txtApellidosNuevo.getText();
            String nombres = vistaPrincipal.txtNombresNuevo.getText();
            
            AfiliadoDTO afiliadoNuevo = null;
        
            if((categoria.equals("")) ||(afiliadoSi.equals("")) ||(noDocumento.equals("")) ||(apellidos.equals("")) || nombres.equals(""))
            {
                parametrosOK = false;
                JOptionPane.showMessageDialog(null, "Se deben ingresar todos los datos para poder agregar al nuevo afiliado");
            }
            if(parametrosOK)
            {  
                Connection conexion = null;
                try
                {
                    conexion = Conexion.getConnection();
                
                    if(conexion.getAutoCommit())
                    {
                        conexion.setAutoCommit(false);
                    }

                    AfiliadoDAO afiliadoDAO = new AfiliadoDAOJDBC(conexion);
            
                    afiliadoNuevo = new AfiliadoDTO(categoria, afiliadoSi, noDocumento, apellidos, nombres);
                    
                    afiliadoDAO.insert(afiliadoNuevo);
                    JOptionPane.showMessageDialog(null, "Estudiante guardado");
                    vistaPrincipal.txtCategoriaNuevo.setText("");
                    //vistaPrincipal.comboBoxAfiliadoSi.setSelectedItem("");
                    vistaPrincipal.txtNoDocumentoNuevo.setText("");
                    vistaPrincipal.txtApellidosNuevo.setText("");
                    vistaPrincipal.txtNombresNuevo.setText("");
                    //UsuarioDTO newPerson = new UsuarioDTO("Pedro", "263241");
                    //usuarioDao.insert(newPerson);
                    //List<UsuarioDTO> usuarios = usuarioDao.select();

                    //for (UsuarioDTO usuario : usuarios) {
                    //    System.out.println("Usuario DTO:" + usuario);
                    //}

                    conexion.commit();
                    System.out.println("Se ha hecho commit de la transaccion");
                }
                catch(SQLException ex)
                {
                    ex.printStackTrace(System.out);
                    JOptionPane.showMessageDialog(null, "Estudiante ya existe");
                    System.out.println("Entramos al rollback");
                    try
                    {
                        conexion.rollback();
                    }
                    catch(SQLException ex1)
                    {
                        ex1.printStackTrace(System.out);
                    }
                }        
            }
        }
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        
        
        if(e.getSource() == vistaPrincipal.btnVender)
        {
            String metodoPago = vistaPrincipal.comboBoxMetodoPago.getSelectedItem().toString();
            Tiquete tiqueteVender = new Tiquete(20000, metodoPago);
            
            if(vistaPrincipal.checkBoxAlmuerzoServiciosExtras.isSelected())
            {
                ServicioExtra servicioExtra = new ServicioExtra("Almuerzo", 15000);
                tiqueteVender.agregarServicioExtra(servicioExtra);
            }
            if(vistaPrincipal.checkBoxSnacksServiciosExtras.isSelected())
            {
                ServicioExtra servicioExtra = new ServicioExtra("Snacks", 10000);
                tiqueteVender.agregarServicioExtra(servicioExtra);
            }
            if(vistaPrincipal.checkBoxSalaDescansoServiciosExtras.isSelected())
            {
                ServicioExtra servicioExtra = new ServicioExtra("Sala de descanso", 50000);
                tiqueteVender.agregarServicioExtra(servicioExtra);
            }
            
            double totalServiciosExtras = tiqueteVender.calcularTotalServiciosExtras();
            double totalTiquete = tiqueteVender.calcularTotalTiquete(vistaPrincipal.txtCategoria.getText());
            
            
            if(metodoPago.equals("Seleccionar"))
            {
                 JOptionPane.showMessageDialog(null, "Por favor seleccionar método de pago");
            }
            else if((metodoPago.equals("Tarjeta")) && ((vistaPrincipal.txtNumeroCuenta.getText().equals(""))
                                  || (vistaPrincipal.passxtContrasenia.getPassword().length == 0)))
            {
                JOptionPane.showMessageDialog(null, "Por favor digitar número de cuenta y contraseña");
            }
            else
            {
                tiqueteVender.setPrecio(totalTiquete);
                caja.agregarTiquete(tiqueteVender);
                /*JOptionPane.showMessageDialog(null, "Total Servicios Extras = " + totalServiciosExtras
                                                + "\nTotal Tiquete = " + totalTiquete);*/
                
                JOptionPane.showMessageDialog(null, "              DIVERLAND"
                                                  + "\n*******************************"
                                                  + "\nNo. de documento: " + vistaPrincipal.txtNoDocumento.getText()
                                                  + "\nNombre: " + vistaPrincipal.txtNombres.getText()
                                                  + "\nCategoría = " + vistaPrincipal.txtCategoria.getText()
                                                  + "\n*******************************"
                                                  + "\nTotal Servicios Extras = " + totalServiciosExtras
                                                  + "\nTotal Tiquete = " + totalTiquete);
                
                vistaPrincipal.txtIdAfiliado.setText("");
                vistaPrincipal.txtNoDocumento.setText("");
                vistaPrincipal.txtApellidos.setText("");
                vistaPrincipal.txtNombres.setText("");
                vistaPrincipal.txtCategoria.setText("");
                vistaPrincipal.txtNumeroCuenta.setText("");
                vistaPrincipal.passxtContrasenia.setText("");
            }          
        }
        
        if(e.getSource() == vistaPrincipal.btnRecaudo)
        { 
            JOptionPane.showMessageDialog(null, "Recaudo = " + caja.darRecaudo() + "\n" + caja.getTiquetes());
        }
    }    
}
