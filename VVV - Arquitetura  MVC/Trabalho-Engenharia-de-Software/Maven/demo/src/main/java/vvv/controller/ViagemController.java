package vvv.controller;
import java.util.Date;
import vvv.model.Viagem;
import vvv.dao.ViagemDAO;
import java.util.List;

public class ViagemController {
    private ViagemDAO viagemDAO;

    public ViagemController() {
        this.viagemDAO = new ViagemDAO();
    }

    // Método para adicionar uma Viagem
    public void adicionarViagem(Date data, String horaPartida, String horaChegada) {
        Viagem viagem = new Viagem();
        viagem.setData(data);
        viagem.setHoraPartida(horaPartida);
        viagem.setHoraChegada(horaChegada);
        
        viagemDAO.adicionarViagem(viagem);
    }

    // Método para listar todas as Viagens
    public void listarViagens() {
        List<Viagem> viagens = viagemDAO.listarViagens();
        for (Viagem viagem : viagens) {
            System.out.println("Data: " + viagem.getData() +
                               ", Hora Partida: " + viagem.getHoraPartida() +
                               ", Hora Chegada: " + viagem.getHoraChegada());
        }
    }

}