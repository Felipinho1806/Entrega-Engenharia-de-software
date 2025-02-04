package vvv.model;

public class Funcionario extends Usuario {
    private double totalVendas;

     public Funcionario(String nome, String email, String senha, double totalVendas) {
        super(nome, email, senha);
        this.totalVendas = totalVendas;
    }
    public Funcionario(){
        
    }
    
    public double getTotalVendas() {
        return totalVendas;
    }
    public void setTotalVendas(double totalVendas) {
        this.totalVendas = totalVendas;
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