/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicos;

import dao.CadastroDAO;
import dao.DAOFactory;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.CadastroVO;

/**
 *
 * @author 181700028
 */
public class CadastrarServicos {
       public void cadastrarUsuario(CadastroVO cVO)throws SQLException{
        
        CadastroDAO cDAO = DAOFactory.getCadastroDAO();
        cDAO.cadastrarUsuario(cVO);
        
    }//fim cadastrarUsuario
    
    public ArrayList<CadastroVO> buscarUsuario() throws SQLException{
        
        CadastroDAO cDAO = DAOFactory.getCadastroDAO();
        return cDAO.buscarUsuario();
        
    }//fim buscarUsuario
    
    public ArrayList<CadastroVO> filtrarUsuario(String query) throws SQLException{
        
        CadastroDAO cDAO = DAOFactory.getCadastroDAO();
        return cDAO.filtrarUsuario(query);        
    }//fim filtrarUsuario
    
    public void deletarUsuario(long idcadastro) throws SQLException{
        CadastroDAO cDAO = DAOFactory.getCadastroDAO();
        cDAO.deletarUsuario(idcadastro);
    }
        public void alterarUsuario(CadastroVO cVO) throws SQLException{
        CadastroDAO cDAO = DAOFactory.getCadastroDAO();
        cDAO.alterarUsuario(cVO);
    
    }
}
