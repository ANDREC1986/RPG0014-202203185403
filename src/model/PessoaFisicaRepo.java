/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author andre
 */
public class PessoaFisicaRepo {
    ArrayList<PessoaFisica> Repositorio;

    public PessoaFisicaRepo() {
        this.Repositorio = new ArrayList<PessoaFisica>();
    };
    
    public void inserir(int id, String nome, String cpf, int idade){
        Repositorio.add(new PessoaFisica(id,nome,cpf,idade));
    };
    
    public void alterar(int id, String param, String value){
       for (PessoaFisica i : Repositorio){
        if (i.getId() ==  id) {
            switch(param) {
                case "nome" -> i.setNome(value);
                case "cpf" -> i.setCpf(value);
                case "idade" -> i.setIdade(Integer.parseInt(value));
            }
            break;
        }
    }};
    
    public void excluir(int id){
        for(int i = 0; i < Repositorio.size(); i++) {
            if(Repositorio.get(i).getId() == id) {
                Repositorio.remove(i);
                break;
            }
        }
    };
    
    public int obter(int id){
    for (PessoaFisica i : Repositorio) {
        if (id == i.getId()) {
            i.exibir();
            return 1;
        }
    }
            System.out.println("Nao Encontrado");
            return 0;
    };
    
    public void obterTodos(){
    for (PessoaFisica i : Repositorio){
            System.out.println("-----------------------------------------");
            i.exibir();
            System.out.println("-----------------------------------------");
        }
    };
    
    public int size(){
    return Repositorio.size();
    };
    
    public void recuperar(String fileToLoad) throws FileNotFoundException, IOException, ClassNotFoundException{
            FileInputStream fis = new FileInputStream(fileToLoad);
            ObjectInputStream ois;
            ois = new ObjectInputStream(fis);
            this.Repositorio = (ArrayList<model.PessoaFisica>) ois.readObject();
            System.out.println("Dados de Pessoa Fisica Recuperados.");

    };
    
    public void persistir(String fileToSaveTo) throws FileNotFoundException, IOException{
            FileOutputStream fos = new FileOutputStream(fileToSaveTo);
            ObjectOutputStream out = new ObjectOutputStream(fos);
            out.writeObject(Repositorio);
            System.out.println("Dados de Pessoa Fisica Armazenados.");
        };
    
}
