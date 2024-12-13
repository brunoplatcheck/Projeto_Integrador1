/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.CadastroVO;
import persistencia.ConexaoBanco;

/**
 *
 * @author 181700028
 */
public class CadastroDAO {
    public void cadastrarUsuario(CadastroVO cVO)throws SQLException{
        
        Connection con = new ConexaoBanco().getConexao();
        
        try {
            String sql = "insert into cadastro values(null, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, cVO.getNome());
            pstm.setString(2, cVO.getEmail());
            pstm.setString(3, cVO.getLogin());
            pstm.setString(4, cVO.getPassword());
            pstm.setString(5, cVO.getCpf());
            pstm.setString(6, cVO.getEndereco());
            pstm.setString(7, cVO.getCep());
            pstm.setString(8, cVO.getTelefone());
            pstm.setString(9,cVO.getDiscord());
            pstm.setString(10, cVO.getSteam());
            pstm.setString(11, cVO.getJogo1());
            pstm.setString(12, cVO.getJogo2());
            pstm.setString(13, cVO.getJogo3());
            pstm.setString(14, cVO.getJogo4());
            pstm.setString(15,cVO.getJogo5());
            pstm.execute();
            pstm.close();
            
        } catch (SQLException se) {
            throw new SQLException("Erro no cadastro de usuario!");
        }finally{
            con.close();
        }//fim do try catch finally
        
    }//fim cadastrarUsuario
    public ArrayList<CadastroVO> filtrarUsuario(String query)throws SQLException {
    
        Connection con = new ConexaoBanco().getConexao();
        
        try {
            
            String sql = "select * from cadastro " + query;
            
            PreparedStatement pstm = con.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            
            ArrayList<CadastroVO> pro = new ArrayList<>();
            
            while(rs.next()){
                CadastroVO cVO = new CadastroVO();
                
                cVO.setIdCadastro(rs.getInt("idcadastro"));
                cVO.setNome(rs.getString("nome"));
                cVO.setEmail(rs.getString("email"));
                cVO.setLogin(rs.getString("login"));
                cVO.setPassword(rs.getString("password"));
                cVO.setCpf(rs.getString("cpf"));
                cVO.setEndereco(rs.getString("endereco"));
                cVO.setCep(rs.getString("cep"));
                cVO.setTelefone(rs.getString("telefone"));
                cVO.setDiscord(rs.getString("discord"));
                cVO.setSteam(rs.getString("steamfriend"));
                cVO.setJogo1(rs.getString("jogos1"));
                cVO.setJogo2(rs.getString("jogos2"));
                cVO.setJogo3(rs.getString("jogos3"));
                cVO.setJogo4(rs.getString("jogos4"));
                cVO.setJogo5(rs.getString("jogos5"));
                
                
                pro.add(cVO);                               
            }//fim do while
            
            pstm.close();
            
            return pro;
            
        } catch (SQLException se) {
            throw new SQLException("Erro ao filtrar usuarios" + se.getMessage());
        }finally{
            con.close();
        }//fim do try catch finally
        
}
    public ArrayList<CadastroVO> buscarUsuario() throws SQLException{
        
        Connection con = new ConexaoBanco().getConexao(); // faz conexão com o BD
               
        try {
            String sql = "Select * from cadastro";
            
            PreparedStatement pstm = con.prepareStatement(sql); //pstm q faz as alterações no BD
            
            ResultSet rs = pstm.executeQuery(); //armazena os dados que vieram
            ArrayList<CadastroVO> pro = new ArrayList<>();
            
            while(rs.next()){//rs.next = enquanto tiver um proximo, faz uma linha de cada vez
                CadastroVO cVO = new CadastroVO();
                
                cVO.setIdCadastro(rs.getInt("idcadastro"));
                cVO.setNome(rs.getString("nome"));
                cVO.setEmail(rs.getString("email"));
                cVO.setLogin(rs.getString("login"));
                cVO.setPassword(rs.getString("password"));
                cVO.setCpf(rs.getString("cpf"));
                cVO.setEndereco(rs.getString("endereco"));
                cVO.setCep(rs.getString("cep"));
                cVO.setTelefone(rs.getString("telefone"));
                cVO.setDiscord(rs.getString("discord"));
                cVO.setSteam(rs.getString("steamfriend"));
                cVO.setJogo1(rs.getString("jogos1"));
                cVO.setJogo2(rs.getString("jogos2"));
                cVO.setJogo3(rs.getString("jogos3"));
                cVO.setJogo4(rs.getString("jogos4"));
                cVO.setJogo5(rs.getString("jogos5"));
                
                pro.add(cVO); //adiciona ao pro(arraylist) o cVO(informações do banco)
                
            }//fim do while
            
            pstm.close();
            
            return pro;
                        
        } catch(SQLException se){
            throw new SQLException("Erro ao buscar cadastro"+ se.getMessage());
        }finally{
            con.close();
        }
        
    }//fim buscarUsuario
    
   
    
    public void deletarUsuario(long idcadastro) throws SQLException{
       
        Connection con = new ConexaoBanco().getConexao();
        
        try {
            String sql = "delete from cadastro where idcadastro = ?";
            
            PreparedStatement pstm = con.prepareStatement(sql);
            
            pstm.setLong(1, idcadastro);
            pstm.execute();
            pstm.close();
            
        } catch (SQLException se) {
            throw new SQLException("Erro ao deletar usuario!UsuarioDAO"+ se.getMessage());
        }finally{
            con.close();
        }//fim da try catch finally
        
    }
    public void alterarUsuario(CadastroVO cVO) throws SQLException {
        Connection con = new ConexaoBanco().getConexao();

        try {
            String sql;
            sql = "Update cadastro set "
                    + "nome = ' " + cVO.getNome() + " ', " 
                    + "email = ' " + cVO.getEmail()+ " ', "
                    + "login = ' " + cVO.getLogin()+ " ', "
                    + "password = ' " + cVO.getPassword()+ " ', "
                    + "cpf = ' " + cVO.getCpf()+ " ', "
                    + "endereco = ' " + cVO.getEndereco()+ " ', "
                    + "cep = ' " + cVO.getCep()+ " ',  "
                    + "telefone = ' " + cVO.getTelefone()+ " ', "
                    + "discord = ' " + cVO.getDiscord()+ " ', "
                    + "steamfriend = ' " + cVO.getSteam()+ " ', "
                    + "jogos1 = ' " + cVO.getJogo1()+ " ', "
                    + "jogos2 = ' " + cVO.getJogo2()+ " ', "
                    + "jogos3 = ' " + cVO.getJogo3()+ " ',  "
                    + "jogos4 = ' " + cVO.getJogo4()+ " ', "
                    + "jogos5 = ' " + cVO.getJogo5()+ " '  "
                    + " where idcadastro = " + cVO.getIdCadastro()+ " ";

            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.executeUpdate();
            pstm.close();

        } catch (SQLException se) {
            throw new SQLException("Erro ao Alterar cadastro! " + se.getMessage());
        } finally {
            con.close();
        }//fim do Try catch finally
    }
}
