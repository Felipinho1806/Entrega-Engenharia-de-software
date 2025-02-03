package vvv.controller;
import java.util.Date;
import vvv.model.Bilhete;
import vvv.dao.BilheteDAO;
import java.util.List;

public class BilheteController {
    private BilheteDAO bilheteDAO;
// 
    public BilheteController() {
        this.bilheteDAO = new BilheteDAO();
    }

    // Método para adicionar um Bilhete
    public void adicionarBilhete(Date dataEmissao) {
        Bilhete bilhete = new Bilhete();
        bilhete.setDataEmissao(dataEmissao);
        
        bilheteDAO.adicionarBilhete(bilhete);
    }

    // Método para listar todos os Bilhetes
    public void listarBilhetes() {
        List<Bilhete> bilhetes = bilheteDAO.listarBilhetes();
        for (Bilhete bilhete : bilhetes) {
            System.out.println("Data de Emissão: " + bilhete.getDataEmissao());
        }
    }

}