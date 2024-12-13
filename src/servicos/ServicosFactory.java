/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicos;

public class ServicosFactory {
    private static CadastrarServicos cadastrarServicos = new CadastrarServicos();
    
    public static CadastrarServicos getCadastrarServicos(){
        return cadastrarServicos;
    }
}//fim ServicosFactory
