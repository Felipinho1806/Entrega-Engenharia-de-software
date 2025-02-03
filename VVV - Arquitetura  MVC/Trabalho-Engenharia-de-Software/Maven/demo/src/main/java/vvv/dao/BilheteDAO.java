package vvv.dao;
import vvv.model.Bilhete;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BilheteDAO {
    private static final String URL = "jdbc:mysql://localhost:3306/nomedobanco";  // Substitua pelo nome do seu banco
    private static final String USER = "root";  // Substitua pelo seu usuário do MySQL
    private static final String PASSWORD = "senha";  // Substitua pela sua senha do MySQL

    // Método para estabelecer a conexão com o banco de dados
    private Connection conectar() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    // Método para adicionar um Bilhete no banco de dados
    public void adicionarBilhete(Bilhete bilhete) {
        String sql = "INSERT INTO bilhete (data_emissao) VALUES (?)";
        
        try (Connection conn = conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setDate(1, new java.sql.Date(bilhete.getDataEmissao().getTime()));
            stmt.executeUpdate();
            System.out.println("Bilhete adicionado com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para listar todos os Bilhetes do banco de dados
    public List<Bilhete> listarBilhetes() {
        List<Bilhete> bilhetes = new ArrayList<>();
        String sql = "SELECT * FROM bilhete";
        
        try (Connection conn = conectar(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Date dataEmissao = rs.getDate("data_emissao");
                
                Bilhete bilhete = new Bilhete();
                bilhete.setDataEmissao(dataEmissao);
                
                bilhetes.add(bilhete);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bilhetes;
    }
}