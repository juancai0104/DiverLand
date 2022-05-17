/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package datos;

import dominio.AfiliadoDTO;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Juan Esteban Caicedo
 */
public interface AfiliadoDAO
{
    public List<AfiliadoDTO> select() throws SQLException;
    
    public AfiliadoDTO selectId(AfiliadoDTO afiliado) throws SQLException;
    
    public int insert(AfiliadoDTO afiliado) throws SQLException;
    
    public int update(AfiliadoDTO afiliado) throws SQLException;
    
    public int delete(AfiliadoDTO afiliado) throws SQLException;
}
