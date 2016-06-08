
package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DepositoAlmas {
       
    public Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost/gerenciador", "root", "1234");
        } catch (ClassNotFoundException e) {
            System.out.println("ERRO: " + e.getMessage());
        } catch (SQLException e) {
            //Lança a exception para outra camada tratar.
            System.out.println("ERRO: " + e.getMessage());
        }        
        return connection;
    }
    
    public void insereAlma(Alma alma){
        PreparedStatement stmt = null;
        Connection connection = getConnection();
        try {
            String sql = "INSERT INTO gerenciador.almas(nome,pecado,status) VALUES (?,?,?)";
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, alma.getNome());
            stmt.setString(2, alma.getPecado());
            stmt.setInt(3, alma.getStatus());
            int result = stmt.executeUpdate();
            if (result == 1) {
                System.out.println("Inserido com sucesso.");
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
            if(connection != null) {
                try {
                    connection.close();
                } catch(SQLException e) {
                    //Lança a exception para outra camada tratar.
                    System.err.println(e.getMessage());
                }
            }	
        }
    }
    
    public void editaAlma(Alma alma){
        PreparedStatement stmt = null;
        Connection connection = getConnection();
        try {
            String sql = "UPDATE gerenciador.almas SET nome = ?, pecado = ?, status = ? WHERE id = ?";
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, alma.getNome());
            stmt.setString(2, alma.getPecado());
            stmt.setInt(3, alma.getStatus());
            stmt.setInt(4, alma.getId());
            int result = stmt.executeUpdate();
            if (result == 1) {
                System.out.println("Atualizado com sucesso.");
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
            if(connection != null) {
                try {
                    connection.close();
                } catch(SQLException e) {
                    //Lança a exception para outra camada tratar.
                    System.err.println(e.getMessage());
                }
            }	
        }
    }
    
    public List<Alma> getAllAlmas() {
        List<Alma> almas = new ArrayList<Alma>();
        Connection connection = getConnection();
        Statement stmt = null;
        try {
            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM gerenciador.almas;");
            while (rs.next()) {
                Alma alma = new Alma();
                alma.setId(rs.getInt("id"));
                alma.setNome(rs.getString("nome"));
                alma.setStatus(rs.getInt("status"));
                alma.setPecado(rs.getString("pecado"));
                almas.add(alma);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if(stmt != null) {
                try {
                    stmt.close();
                } catch(SQLException e) {
                    //Lança a exception para outra camada tratar.
                    System.err.println(e.getMessage());
                }
            }
            if(connection != null) {
                try {
                    connection.close();
                } catch(SQLException e) {
                    //Lança a exception para outra camada tratar.
                    System.err.println(e.getMessage());
                }
            }	
        }

        return almas;
    }
    
    public Alma getAlmaId(Integer id) {
        Alma alma = new Alma();
        PreparedStatement stmt = null;
        Connection connection = getConnection();
        try {
            stmt = connection.prepareStatement("SELECT * FROM gerenciador.almas WHERE id = ?;");
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                alma.setId(rs.getInt("id"));
                alma.setNome(rs.getString("nome"));
                alma.setStatus(rs.getInt("status"));
                alma.setPecado(rs.getString("pecado"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if(stmt != null) {
                try {
                    stmt.close();
                } catch(SQLException e) {
                    //Lança a exception para outra camada tratar.
                    System.err.println(e.getMessage());
                }
            }
            if(connection != null) {
                try {
                    connection.close();
                } catch(SQLException e) {
                    //Lança a exception para outra camada tratar.
                    System.err.println(e.getMessage());
                }
            }	
        }

        return alma;
    }

    public void removeAlma(Integer id){
        PreparedStatement stmt = null;
        Connection connection = getConnection();
        try {
            String sql = "DELETE FROM gerenciador.almas WHERE id = ?";
            stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            int result = stmt.executeUpdate();
            if (result == 1) {
                System.out.println("Excluído com sucesso.");
            } else {
                System.out.println("Problemas com a exclusão.");
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
            if(connection != null) {
                try {
                    connection.close();
                } catch(SQLException e) {
                    //Lança a exception para outra camada tratar.
                    System.err.println(e.getMessage());
                }
            }	
        }
    }
}
