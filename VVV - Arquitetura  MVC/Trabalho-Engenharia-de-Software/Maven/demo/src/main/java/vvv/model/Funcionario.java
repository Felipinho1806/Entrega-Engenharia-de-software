package vvv.model;

public class Funcionario extends Usuario {

    
    public Funcionario(String nome, String email, String senha, int id) {
        super(nome, email, senha, id);
    }
    public Funcionario(){
        
    }

    public void realizarVenda() {
        System.out.println("Venda realizada pelo funcionário: " + getNome());
        // Aqui poderia ter lógica para registrar a venda no banco
    }

    public void consultarReserva() {
        System.out.println("Consulta de reserva realizada pelo funcionário: " + getNome());
        // Aqui poderia ter lógica para buscar reservas no banco
    }
}