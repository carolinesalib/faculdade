
package modelo;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Alma {
    
    private Connection conn = null;
    private PreparedStatement stmt = null;
    
    public Alma() {                
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
    
    public void insert(String nome, String pecado, Integer status){
        try {
            String sql = "INSERT INTO gerenciador.almas(nome,pecado,status) VALUES (?,?,?)";
            stmt = (PreparedStatement) conn.prepareStatement(sql);
            stmt.setString(1, nome);
            stmt.setString(2, pecado);
            stmt.setInt(3, status);
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
    
}
