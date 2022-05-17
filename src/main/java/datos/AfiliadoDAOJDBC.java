/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import dominio.AfiliadoDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Juan Esteban Caicedo
 */
public class AfiliadoDAOJDBC implements AfiliadoDAO
{
    private Connection conexionTransaccional;

    private static final String SQL_SELECT = "SELECT id_afiliado, categoria, comprobar_afiliado, num_documento, apellidos, nombres FROM afiliados";
    private static final String SQL_SELECT_ID = "SELECT id_afiliado, categoria, comprobar_afiliado, num_documento, apellidos, nombres FROM afiliados WHERE id_afiliado = ?";
    private static final String SQL_INSERT = "INSERT INTO afiliados (categoria, comprobar_afiliado, num_documento, apellidos, nombres) VALUE (?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE afiliados SET categoria = ?, comprobar_afiliado = ?, num_documento = ?, apellidos = ?, nombres = ? WHERE id_afiliado = ?";
    private static final String SQL_DELETE = "DELETE FROM afiliados WHERE id_afiliado = ?";

    public AfiliadoDAOJDBC()
    {

    }

    public AfiliadoDAOJDBC(Connection conexionTransaccional)
    {
        this.conexionTransaccional = conexionTransaccional;
    }
    
    public List<AfiliadoDTO> select() throws SQLException
    {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        AfiliadoDTO afiliado = null;
        List<AfiliadoDTO> afiliados = new ArrayList<AfiliadoDTO>();
        
        try
        {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            
            while (rs.next())
            {
                
                int idAfiliado = rs.getInt("id_afiliado");
                String categoria = rs.getString("categoria");
                String comprobarAfiliado = rs.getString("comprobar_afiliado");
                String numDocumento = rs.getString("num_documento");         
                String apellidos = rs.getString("apellidos");
                String nombres = rs.getString("nombres");

                afiliado = new AfiliadoDTO();
                afiliado.setIdAfiliado(idAfiliado);
                afiliado.setCategoria(categoria);
                afiliado.setAfiliado(comprobarAfiliado);
                afiliado.setNumDocumento(numDocumento);
                afiliado.setApellidos(apellidos);
                afiliado.setNombres(nombres);

                afiliados.add(afiliado);
            }
        }
        finally
        {
            Conexion.close(rs);
            Conexion.close(stmt);
            if(this.conexionTransaccional == null)
            {
                Conexion.close(conn);
            }
        }

        return afiliados;
    }
    
    public AfiliadoDTO selectId(AfiliadoDTO pAfiliado) throws SQLException
    {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        AfiliadoDTO afiliado = null;
        //List<EstudianteDTO> estudiantes = new ArrayList<EstudianteDTO>();
        
        try
        {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_ID);
            stmt.setInt(1, pAfiliado.getIdAfiliado());
            rs = stmt.executeQuery();
            
            if (rs.next())
            {
                
                //String idEstudiante = rs.getString("idEstudiante");
                String categoria = rs.getString("categoria");
                String comprobarAfiliado = rs.getString("comprobar_afiliado");
                String numDocumento = rs.getString("num_documento");
                String apellidos = rs.getString("apellidos");
                String nombres = rs.getString("nombres");

                //if(idEstudiante.equals(pIdEstudiante))
                //{
                afiliado = new AfiliadoDTO();
                afiliado.setIdAfiliado(pAfiliado.getIdAfiliado());
                afiliado.setCategoria(categoria);
                afiliado.setAfiliado(comprobarAfiliado);
                afiliado.setNumDocumento(numDocumento);
                afiliado.setApellidos(apellidos);
                afiliado.setNombres(nombres);

                //estudiantes.add(estudiante);
                //}       
            }
        }
        finally
        {
            Conexion.close(rs);
            Conexion.close(stmt);
            if(this.conexionTransaccional == null)
            {
                Conexion.close(conn);
            }
        }
        return afiliado;
    }
    
    /*public List<EstudianteDTO> selectId(String pIdEstudiante) throws SQLException
    {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        EstudianteDTO estudiante = null;
        List<EstudianteDTO> estudiantes = new ArrayList<EstudianteDTO>();
        String SQL_SELECT_ID = "SELECT idEstudiante, primerApellidoEstudiante, segundoApellidoEstudiante, primerNombreEstudiante, segundoNombreEstudiante FROM estudiantes WHERE idEstudiante ='"+pIdEstudiante+"'";
        
        try
        {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_ID);
            stmt.setString(1, pIdEstudiante);
            rs = stmt.executeQuery();
            
            while (rs.next())
            {
                
                //String idEstudiante = rs.getString("idEstudiante");
                String primerApellidoEstudiante = rs.getString("primerApellidoEstudiante");
                String segundoApellidoEstudiante = rs.getString("segundoApellidoEstudiante");
                String primerNombreEstudiante = rs.getString("primerNombreEstudiante");
                String segundoNombreEstudiante = rs.getString("segundoNombreEstudiante");

                //if(idEstudiante.equals(pIdEstudiante))
                //{
                    estudiante = new EstudianteDTO();
                    estudiante.setIdEstudiante(pIdEstudiante);
                    estudiante.setPrimerApellidoEstudiante(primerApellidoEstudiante);
                    estudiante.setSegundoApellidoEstudiante(segundoApellidoEstudiante);
                    estudiante.setPrimerNombreEstudiante(primerNombreEstudiante);
                    estudiante.setSegundoNombreEstudiante(segundoNombreEstudiante);

                    estudiantes.add(estudiante);
                //}       
            }
        }
        finally
        {
            Conexion.close(rs);
            Conexion.close(stmt);
            if(this.conexionTransaccional == null)
            {
                Conexion.close(conn);
            }
        }
        return estudiantes;
    }*/
    
    /*public List<EstudianteDTO> selectId(String pIdEstudiante) throws SQLException
    {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        EstudianteDTO estudiante = null;
        List<EstudianteDTO> estudiantes = new ArrayList<EstudianteDTO>();
        
        try
        {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_ID);
            stmt.setString(1, pIdEstudiante);
            rs = stmt.executeQuery();
            
            while (rs.next())
            {
                
                //String idEstudiante = rs.getString("idEstudiante");
                String primerApellidoEstudiante = rs.getString("primerApellidoEstudiante");
                String segundoApellidoEstudiante = rs.getString("segundoApellidoEstudiante");
                String primerNombreEstudiante = rs.getString("primerNombreEstudiante");
                String segundoNombreEstudiante = rs.getString("segundoNombreEstudiante");

                //if(idEstudiante.equals(pIdEstudiante))
                //{
                    estudiante = new EstudianteDTO();
                    estudiante.setIdEstudiante(pIdEstudiante);
                    estudiante.setPrimerApellidoEstudiante(primerApellidoEstudiante);
                    estudiante.setSegundoApellidoEstudiante(segundoApellidoEstudiante);
                    estudiante.setPrimerNombreEstudiante(primerNombreEstudiante);
                    estudiante.setSegundoNombreEstudiante(segundoNombreEstudiante);

                    estudiantes.add(estudiante);
                //}       
            }
        }
        finally
        {
            Conexion.close(rs);
            Conexion.close(stmt);
            if(this.conexionTransaccional == null)
            {
                Conexion.close(conn);
            }
        }
        return estudiantes;
    }*/

    public int insert(AfiliadoDTO afiliado) throws SQLException
    {
        Connection conn = null;
        PreparedStatement stmt = null;
        int filas = 0;
        
        try
        {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            
            stmt.setString(1, afiliado.getCategoria());
            stmt.setString(2, afiliado.getAfiliado());
            stmt.setString(3, afiliado.getNumDocumento());
            stmt.setString(4, afiliado.getApellidos());
            stmt.setString(5, afiliado.getNombres());

            System.out.println("ejecutando query:" + SQL_INSERT);
            filas = stmt.executeUpdate();
            System.out.println("Registros afectados:" + filas);
        }
        finally
        {
            Conexion.close(stmt);
            if(this.conexionTransaccional == null)
            {
                Conexion.close(conn);
            }
        }

        return filas;
    }

    public int update(AfiliadoDTO afiliado) throws SQLException
    {
        Connection conn = null;
        PreparedStatement stmt = null;
        int filas = 0;
        
        try
        {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            
            stmt.setInt(1, afiliado.getIdAfiliado());
            stmt.setString(2, afiliado.getCategoria());
            stmt.setString(3, afiliado.getAfiliado());
            stmt.setString(4, afiliado.getNumDocumento());
            stmt.setString(5, afiliado.getApellidos());
            stmt.setString(6, afiliado.getNombres());

            filas = stmt.executeUpdate();
            System.out.println("Registros actualizado:" + filas);
        }
        finally
        {
            Conexion.close(stmt);
            if(this.conexionTransaccional == null)
            {
                Conexion.close(conn);
            }
        }

        return filas;
    }

    public int delete(AfiliadoDTO afiliado) throws SQLException
    {
        Connection conn = null;
        PreparedStatement stmt = null;
        int filas = 0;
        
        try
        {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            
            stmt.setInt(1, afiliado.getIdAfiliado());
            filas = stmt.executeUpdate();
            System.out.println("Registros eliminados:" + filas);           
        }
        finally
        {
            Conexion.close(stmt);
            if(this.conexionTransaccional == null)
            {
                Conexion.close(conn);
            }
        }

        return filas;
    }
}
