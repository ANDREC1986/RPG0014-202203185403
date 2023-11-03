/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cadastropoo;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import model.PessoaFisicaRepo;
import model.PessoaJuridicaRepo;



/**
 *
 * @author André Carvalhal
 */

public class CadastroPOO {
    static Boolean running = true;
    static PessoaFisicaRepo repo1 = new PessoaFisicaRepo();
    static PessoaJuridicaRepo repo2 = new PessoaJuridicaRepo();
    static Scanner kb = new Scanner(System.in);
    public static void main(String[] args) throws FileNotFoundException, ClassNotFoundException {
/*      PessoaFisicaRepo repo1 = new PessoaFisicaRepo();
        repo1.inserir(1, "André", "12345678912", 37);
        repo1.inserir(1, "Anna", "12345678912", 72);
        try {
            repo1.persistir("testePF.bin");
            PessoaFisicaRepo repo2 = new PessoaFisicaRepo();
            repo2.recuperar("testePF.bin");
            repo2.obterTodos();
        } catch (IOException ex) {
            Logger.getLogger(CadastroPOO.class.getName()).log(Level.SEVERE, null, ex);
        }
        PessoaJuridicaRepo repo3 = new PessoaJuridicaRepo();
        repo3.inserir(1, "Fernanda", "123124124124122");
        repo3.inserir(2, "Calors", "123124124124122");
        try {
            repo3.persistir("testePJ.bin");
            PessoaJuridicaRepo repo4 = new PessoaJuridicaRepo();
            repo4.recuperar("testePJ.bin");
            repo4.obterTodos();
        } catch (IOException ex) {
            Logger.getLogger(CadastroPOO.class.getName()).log(Level.SEVERE, null, ex);
        } */
        
        
        
        
        
        
            do {
            // TODO code application logic here
            Boolean navFlag = true;
            System.out.println("""
            ===============================
            1 - Incluir Pessoa
            2 - Alterar Pessoa1
            3 - Excluir Pessoa
            4 - Buscar pelo Id
            5 - Exibir Todos
            6 - Persistir Dados
            7 - Recuperar Dados
            0 - Finalizar Programa
            ===============================
            """);
            String selected = kb.nextLine();
            
            switch (selected) {
            case "1" -> {
            int tipo = tipo();
            switch (tipo){
            case 1 -> {
            System.out.println("Insira o Nome:");
            String nome = kb.nextLine();
            System.out.println("Insira o CPF:");
            String cpf = checked();
            cpf = cpf.replace(".","");
            System.out.println("Insira a Idade:");
            String idade = checked();
            repo1.inserir(repo1.size() + 1, nome, cpf, Integer.parseInt(idade));
            }
            case 2 -> {                
            System.out.println("Insira o Nome:");
            String nome = kb.nextLine();
            System.out.println("Insira o CNPJ:");
            String cnpj = checked();
            repo2.inserir(repo2.size() + 1, nome, cnpj);
            }
            }
            }
            
            case "2" -> {
            int tipo2 = tipo();
            System.out.print("Informe a ID:");
            int alterar = kb.nextInt();
            switch(tipo2){
            case 1 -> {
            System.out.println("-----------------------------------------");
            int pessoa = repo1.obter(alterar);
            System.out.println("-----------------------------------------");
            if (pessoa == 1) {
            Boolean flag = false;
            System.out.println("""
            Deseja Editar:
            N - Nome
            C - CPF
            I - IDADE
            R - RETORNAR
            """);
            while (navFlag == true){
            switch(kb.nextLine().toLowerCase()){
            case "n" -> {
            System.out.println("Novo nome:");
            String nome = kb.nextLine();
            repo1.alterar(alterar, "nome", nome);
            navFlag = false;
            }
            case "c" -> {
            System.out.println("Novo CPF:");
            String cpf = checked();
            repo1.alterar(alterar, "cpf", cpf);
            navFlag = false;
            }
            case "i" -> {
            System.out.println("Nova idade:");
            String idade = checked();
            repo1.alterar(alterar, "idade", idade);
            navFlag = false;
            }
            
            case "r" -> {
            navFlag = false;
            }
            }
            }
            } else {
            kb.nextLine();
            }
            }
            case 2 -> {
            System.out.println("-----------------------------------------");
            int pessoa = repo2.obter(alterar);
            System.out.println("-----------------------------------------");
            if (pessoa == 1) {
            System.out.println("""
            Deseja Editar:
            N - Nome
            C - CNPJ
            R - RETORNAR
            """);
            while (navFlag == true){
            switch(kb.nextLine().toLowerCase()){
            case "n" -> {
            System.out.println("Novo nome:");
            String nome = kb.nextLine();
            repo1.alterar(alterar, "nome", nome);
            navFlag = false;
            }
            case "c" -> {
            System.out.println("Novo cnpj:");
            String cpf = checked();
            repo2.alterar(alterar, "cnpj", cpf);
            navFlag = false;
            }
            
            case "r" -> {
            navFlag = false;
            }
            }
            }
            }else {
            kb.nextLine();
            }
            }
            }
            }
            
            case "3" -> {
            int tipo3 = tipo();
            System.out.println("Informe o ID:");
            int id = kb.nextInt();
            switch(tipo3) {
            case 1 ->  {
            System.out.println("-----------------------------------------");
            int confirma = repo1.obter(id);
            System.out.println("-----------------------------------------");
            if(confirma == 1) { System.out.println("Excluido com Sucesso!");};
            repo1.excluir(id);
            }
            case 2 -> {
            System.out.println("-----------------------------------------");
            int confirma = repo2.obter(id);
            System.out.println("-----------------------------------------");
            if(confirma == 1) { System.out.println("Excluido com Sucesso!");};
            repo2.excluir(id);
            
            }
            }
            System.out.println("Insira R para retornar.");
            do {
            String wait = kb.next().toLowerCase();
            if ("r".equals(wait)){
            navFlag = false;
            }
            } while(navFlag == true);
            }
            
            case "4" -> {
            int tipo4 = tipo();
            System.out.println("Informe o ID:");
            int id = kb.nextInt();
            switch(tipo4) {
            case 1 -> {
            System.out.println("-----------------------------------------");
            repo1.obter(id);
            System.out.println("-----------------------------------------");
            }
            case 2 -> {
            System.out.println("-----------------------------------------");
            repo2.obter(id);
            System.out.println("-----------------------------------------");
            }
            }
            System.out.println("Insira R para retornar.");
            do {
            String wait = kb.next().toLowerCase();
            if ("r".equals(wait)){
            navFlag = false;
            }
            } while(navFlag == true);
            }
            
            case "5" -> {
            int tipo5 = tipo();
            switch(tipo5) {
            case 1 -> {
            repo1.obterTodos();}
            case 2-> {
            repo2.obterTodos();}
            }
            System.out.println("Insira R para retornar.");
            do {
            String wait = kb.next().toLowerCase();
            if ("r".equals(wait)){
            navFlag = false;
            }
            } while(navFlag == true);
            }
            
            case "6" -> {
            int tipo6 = tipo();
            System.out.println("Nome do Arquivo a ser salvo:");
            String nome = kb.nextLine();
            switch(tipo6) {
            case 1 -> {
            try {
            nome = nome + ".fisica.bin";
            repo1.persistir(nome);
            } catch (IOException ex) {
            System.out.print("Falha ao salvar o arquivo!");
            }
            }
            case 2 -> {
            try {
            nome = nome + ".juridica.bin";
            repo2.persistir(nome);
            } catch (IOException ex) {
            System.out.print("Falha ao salvar o arquivo!");
            }
            }
            
            }
            }
            case "7" -> {
            int tipo7 = tipo();
            System.out.println("Nome do arquivo a recuperar:");
            String arquivo = kb.nextLine();
            switch(tipo7) {
            case 1 -> {
            try {
            arquivo = arquivo + ".fisica.bin";
            repo1.recuperar(arquivo);
            } catch (IOException | ClassNotFoundException ex) {
            System.out.println("Nao foi possivel encontrar o arquivo!");
            }
            }
            
            case 2 -> {
            try {
            arquivo = arquivo + ".juridica.bin";
            repo1.recuperar(arquivo);
            } catch (IOException | ClassNotFoundException ex) {
            System.out.println("Nao foi possivel encontrar o arquivo!");
            }
            }
            
            }
            
            }
            case "0" -> {
            running = false;}
            }
            } while (running == true);
            }
            
            public static String checked(){
            String value = "null";
            Scanner valor = new Scanner(System.in);
            while (value == "null"){
            value = valor.nextLine();
            value = value.replace(".","");
            try {
            Long.parseLong(value);
            }
            catch (NumberFormatException e) {
            System.out.println("Valor deve ser numerico");
            value = "null";
            }
            }
            return value;
            };
            
            public static int tipo(){
            int selecionado = 0;
            Scanner selecionar = new Scanner(System.in);
            while (selecionado == 0) {
            System.out.println("F - Pessoa Fisica | J - Pessoa Jurifica");
            String tipo = selecionar.nextLine().toLowerCase();
            switch(tipo){
            case "f" -> {
            selecionado = 1;
            }
            case "j" -> {
            selecionado = 2;
            }
            default -> {
            System.out.println("Tipo Invalido");
            }
            }
            }
            return selecionado;
            };            
    }

