/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

public class DAOFactory {
    
    //Instanciando o objeto a classe CadastroDAO
    private static CadastroDAO cadastroDAO = new CadastroDAO();
    
    
    //Fazendo uma cópia dos métodos da classe CadastroDAO e disponibilizar para a classe que solicitar
    public static CadastroDAO getCadastroDAO(){
        return cadastroDAO;
    }//fim getProdutoDAO
    
}//fim DAOFactory
