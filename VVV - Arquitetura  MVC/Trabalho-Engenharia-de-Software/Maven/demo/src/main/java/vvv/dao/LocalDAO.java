package vvv.dao;
import vvv.model.Local;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LocalDAO {
    private static final String URL = "jdbc:mysql://localhost:3306/nomedobanco";  // Substitua pelo nome do seu banco
    private static final String USER = "root";  // Substitua pelo seu usuário do MySQL
    private static final String PASSWORD = "senha";  // Substitua pela sua senha do MySQL

    // Método para estabelecer a conexão com o banco de dados
    private Connection conectar() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    // Método para adicionar um Local no banco de dados
    public void adicionarLocal(Local local) {
        String sql = "INSERT INTO local (nome, endereco) VALUES (?, ?)";
        
        try (Connection conn = conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, local.getNome());
            stmt.setString(2, local.getEndereco());
            stmt.executeUpdate();
            System.out.println("Local adicionado com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para listar todos os Locais do banco de dados
    public List<Local> listarLocais() {
        List<Local> locais = new ArrayList<>();
        String sql = "SELECT * FROM local";
        
        try (Connection conn = conectar(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                String nome = rs.getString("nome");
                String endereco = rs.getString("endereco");
                
                Local local = new Local();
                local.setNome(nome);
                local.setEndereco(endereco);
                
                locais.add(local);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return locais;
    }
}