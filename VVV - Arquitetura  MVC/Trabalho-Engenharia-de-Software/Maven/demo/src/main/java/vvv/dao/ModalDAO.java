package vvv.dao;
import vvv.model.Modal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ModalDAO {
    private static final String URL = "jdbc:mysql://localhost:3306/nomedobanco";  // Substitua pelo nome do seu banco
    private static final String USER = "root";  // Substitua pelo seu usuário do MySQL
    private static final String PASSWORD = "senha";  // Substitua pela sua senha do MySQL

    // Método para estabelecer conexão com o banco de dados
    private Connection conectar() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    // Método para adicionar um Modal no banco de dados
    public void adicionarModal(Modal modal) {
        String sql = "INSERT INTO modal (idProprietario, capacidade, tipo, categoria, marca) VALUES (?, ?, ?, ?, ?)";
        
        try (Connection conn = conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, modal.getIdProprietario());
            stmt.setInt(2, modal.getCapacidade());
            stmt.setString(3, modal.getTipo());
            stmt.setString(4, modal.getCategoria());
            stmt.setString(5, modal.getMarca());
            stmt.executeUpdate();
            System.out.println("Modal adicionado com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para listar os Modais do banco de dados
    public List<Modal> listarModais() {
        List<Modal> modais = new ArrayList<>();
        String sql = "SELECT * FROM modal";
        
        try (Connection conn = conectar(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                int idProprietario = rs.getInt("idProprietario");
                int capacidade = rs.getInt("capacidade");
                String tipo = rs.getString("tipo");
                String categoria = rs.getString("categoria");
                String marca = rs.getString("marca");
                
                Modal modal = new Modal();
                modal.setIdProprietario(idProprietario);
                modal.setCapacidade(capacidade);
                modal.setTipo(tipo);
                modal.setCategoria(categoria);
                modal.setMarca(marca);
                
                modais.add(modal);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return modais;
    }
}