package vvv.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import vvv.model.Cliente;

public class ClienteDAO {
    private static final String URL = "jdbc:mysql://localhost:3306";  // Substitua pelo nome do seu banco
    private static final String USER = "root";  // Substitua pelo seu usuário do MySQL
    private static final String PASSWORD = "senha";  // Substitua pela sua senha do MySQL

    // Método para estabelecer conexão com o banco de dados
    private Connection conectar() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    // Método para adicionar cliente no banco de dados
    public void adicionarCliente(Cliente cliente) {
        String sql = "INSERT INTO cliente (nome, email, cpf, telefone) VALUES (?, ?, ?, ?)"; // PRECISA CORRIGIR OS ATRIBUTOS A SEREM PASSADOS 
        
        try (Connection conn = conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getEmail());
            stmt.setInt(3, cliente.getCpf());
            stmt.setString(4, cliente.getTelefone());
            stmt.executeUpdate();
            System.out.println("Cliente adicionado com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para listar os clientes do banco de dados
    public List<Cliente> listarClientes() {
        List<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT * FROM clientes";
        
        try (Connection conn = conectar(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                String nome = rs.getString("nome");
                String email = rs.getString("email");
                int cpf = rs.getInt("cpf");
                String telefone = rs.getString("telefone");
                Cliente cliente = new Cliente(); // ----------------- PRECISA PASSAR OS ATRIBUTOS PARA O CONSTRUTOR ------------
                clientes.add(cliente);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clientes;
    }
}