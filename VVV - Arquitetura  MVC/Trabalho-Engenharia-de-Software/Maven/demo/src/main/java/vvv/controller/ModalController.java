package vvv.controller;
import vvv.model.Modal;
import vvv.dao.ModalDAO;
import java.util.List;

public class ModalController {
    private ModalDAO modalDAO;

    public ModalController() {
        this.modalDAO = new ModalDAO();
    }

    // Método para adicionar um Modal
    public void adicionarModal(int idProprietario, int capacidade, String tipo, String categoria, String marca) {
        Modal modal = new Modal();
        modal.setIdProprietario(idProprietario);
        modal.setCapacidade(capacidade);
        modal.setTipo(tipo);
        modal.setCategoria(categoria);
        modal.setMarca(marca);
        
        modalDAO.adicionarModal(modal);
    }

    // Método para listar todos os Modais
    public void listarModais() {
        List<Modal> modais = modalDAO.listarModais();
        for (Modal modal : modais) {
            System.out.println("Proprietário ID: " + modal.getIdProprietario() +
                               ", Capacidade: " + modal.getCapacidade() +
                               ", Tipo: " + modal.getTipo() +
                               ", Categoria: " + modal.getCategoria() +
                               ", Marca: " + modal.getMarca());
        }
    }

}