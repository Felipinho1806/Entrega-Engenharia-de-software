package vvv.controller;
import vvv.model.ProprietarioModal;
import vvv.dao.ProprietarioModalDAO;
import java.util.List;

public class ProprietarioModalController {
    private ProprietarioModalDAO proprietarioModalDAO;

    public ProprietarioModalController() {
        this.proprietarioModalDAO = new ProprietarioModalDAO();
    }

    // Método para adicionar um ProprietarioModal
    public void adicionarProprietarioModal(String email, String telefone) {
        ProprietarioModal proprietario = new ProprietarioModal();
        proprietario.setEmail(email);
        proprietario.setTelefone(telefone);
        
        proprietarioModalDAO.adicionarProprietarioModal(proprietario);
    }

    // Método para listar todos os ProprietariosModal
    public void listarProprietariosModal() {
        List<ProprietarioModal> proprietarios = proprietarioModalDAO.listarProprietarios();
        for (ProprietarioModal proprietario : proprietarios) {
            System.out.println("Email: " + proprietario.getEmail() +
                               ", Telefone: " + proprietario.getTelefone());
        }
    }

}