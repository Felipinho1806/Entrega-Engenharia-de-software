package vvv.model;

public class Cliente extends Usuario {
    private int cpf;
    private String telefone;

    public Cliente (String nome, String email, String senha, int id) {
        super(nome, email, senha, id);
    }
    public Cliente() {
        
    }

    public int getCpf() {
        return cpf;
    }

    public String getTelefone() {
        return telefone;
    }

   
}