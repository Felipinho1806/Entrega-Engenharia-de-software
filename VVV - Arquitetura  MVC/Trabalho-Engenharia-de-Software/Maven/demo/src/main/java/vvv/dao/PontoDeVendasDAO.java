package vvv.dao;

import vvv.model.PontoDeVendas;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PontoDeVendasDAO {
    private static final String URL = "jdbc:mysql://localhost:3306/nomedobanco";  // Substitua pelo nome do seu banco
    private static final String USER = "root";  // Substitua pelo seu usuário do MySQL
    private static final String PASSWORD = "senha";  // Substitua pela sua senha do MySQL

    // Método para estabelecer a conexão com o banco de dados
    private Connection conectar() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    // Método para adicionar um PontoDeVendas no banco de dados
    public void adicionarPontoDeVendas(PontoDeVendas ponto) {
        String sql = "INSERT INTO ponto_de_vendas (nome, endereco, telefone) VALUES (?, ?, ?)";
        
        try (Connection conn = conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, ponto.getNome());
            stmt.setString(2, ponto.getEndereco());
            stmt.setString(3, ponto.getTelefone());
            stmt.executeUpdate();
            System.out.println("Ponto de Vendas adicionado com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para listar os PontosDeVendas do banco de dados
    public List<PontoDeVendas> listarPontosDeVendas() {
        List<PontoDeVendas> pontos = new ArrayList<>();
        String sql = "SELECT * FROM ponto_de_vendas";
        
        try (Connection conn = conectar(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                String nome = rs.getString("nome");
                String endereco = rs.getString("endereco");
                String telefone = rs.getString("telefone");
                
                PontoDeVendas ponto = new PontoDeVendas();
                ponto.setNome(nome);
                ponto.setEndereco(endereco);
                ponto.setTelefone(telefone);
                
                pontos.add(ponto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pontos;
    }
}