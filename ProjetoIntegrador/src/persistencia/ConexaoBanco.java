
package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author 181700028
 */
public class ConexaoBanco {
    
    public Connection getConexao(){
        Connection c = null;
        try {
            String url = "jdbc:mysql://localhost:3306/projetoInt?user=root&password=";
            c = DriverManager.getConnection(url);
        } catch (SQLException se) {
            JOptionPane.showMessageDialog(
                    null,
                    "Erro ao Conectar! " + se.getMessage());
        }
        return c;
    }
    
}
