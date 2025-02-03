package vvv.controller;
import vvv.model.Local;
import vvv.dao.LocalDAO;
import java.util.List;

public class LocalController {
    private LocalDAO localDAO;

    public LocalController() {
        this.localDAO = new LocalDAO();
    }

    // Método para adicionar um Local
    public void adicionarLocal(String nome, String endereco) {
        Local local = new Local();
        local.setNome(nome);
        local.setEndereco(endereco);
        
        localDAO.adicionarLocal(local);
    }

    // Método para listar todos os Locais
    public void listarLocais() {
        List<Local> locais = localDAO.listarLocais();
        for (Local local : locais) {
            System.out.println("Nome: " + local.getNome() +
                               ", Endereço: " + local.getEndereco());
        }
    }

}