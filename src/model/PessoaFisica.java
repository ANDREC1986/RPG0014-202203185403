package model;

import java.io.Serializable;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author André Carvalhal
 */
public class PessoaFisica extends Pessoa implements Serializable {
    protected String cpf;
    protected int idade;
    
    /**
     *
     * @param id
     * @param nome
     * @param cpf
     * @param idade
     */
    
    public PessoaFisica(int id, String nome, String cpf, int idade) {
        super(id, nome);
        this.cpf = cpf;
        this.idade = idade;
    }
    
    @Override
    public void exibir() {
        super.exibir();
        System.out.println("CPF: "+cpf);
        System.out.println("Idade: "+idade);
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
    
    
    
}
