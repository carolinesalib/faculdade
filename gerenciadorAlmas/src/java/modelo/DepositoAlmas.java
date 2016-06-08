
package modelo;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DepositoAlmas {
    
    private Connection conn = null;
    private PreparedStatement stmt = null;
    
    public DepositoAlmas() {                
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/gerenciador", "root", "1234");
        } catch (ClassNotFoundException e) {
            System.out.println("ERRO: " + e.getMessage());
        } catch (SQLException e) {
            //Lança a exception para outra camada tratar.
            System.out.println("ERRO: " + e.getMessage());
        }
    
    }
    
    public void insereAlma(Alma alma){
        try {
            String sql = "INSERT INTO gerenciador.almas(nome,pecado,status) VALUES (?,?,?)";
            stmt = (PreparedStatement) conn.prepareStatement(sql);
            stmt.setString(1, alma.getNome());
            stmt.setString(2, alma.getPecado());
            stmt.setInt(3, alma.getStatus());
            int result = stmt.executeUpdate();
            if (result == 1) {
                System.out.println("Atualização com sucesso.");
            } else {
                System.out.println("Problemas com a atualização.");
            }
        } catch (SQLException e) {
            //Lança a exception para outra camada tratar.
            System.err.println(e.getMessage());
        } finally {
            if(stmt != null) {
                try {
                    stmt.close();
                } catch(SQLException e) {
                    //Lança a exception para outra camada tratar.
                    System.err.println(e.getMessage());
                }
            }
            if(conn != null) {
                try {
                    conn.close();
                } catch(SQLException e) {
                    //Lança a exception para outra camada tratar.
                    System.err.println(e.getMessage());
                }
            }	
        }
    }
    
    public void removeAlma(Integer id){}
}
