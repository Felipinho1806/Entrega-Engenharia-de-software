package vvv.controller;
import vvv.model.PontoDeVendas;
import vvv.dao.PontoDeVendasDAO;
import java.util.List;


public class PontoDeVendasController {
    private PontoDeVendasDAO pontoDeVendasDAO;

    public PontoDeVendasController() {
        this.pontoDeVendasDAO = new PontoDeVendasDAO();
    }

    // Método para adicionar um PontoDeVendas
    public void adicionarPontoDeVendas(String nome, String endereco, String telefone) {
        PontoDeVendas ponto = new PontoDeVendas();
        ponto.setNome(nome);
        ponto.setEndereco(endereco);
        ponto.setTelefone(telefone);
        
        pontoDeVendasDAO.adicionarPontoDeVendas(ponto);
    }

    // Método para listar todos os PontosDeVendas
    public void listarPontosDeVendas() {
        List<PontoDeVendas> pontos = pontoDeVendasDAO.listarPontosDeVendas();
        for (PontoDeVendas ponto : pontos) {
            System.out.println("Nome: " + ponto.getNome() +
                               ", Endereço: " + ponto.getEndereco() +
                               ", Telefone: " + ponto.getTelefone());
        }
    }

  
}