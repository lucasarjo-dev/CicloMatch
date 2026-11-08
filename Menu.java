package org.example.app;

import org.example.model.*;
import org.example.service.*;

import java.sql.SQLException;
import java.util.Scanner;

public class Menu {

    private Scanner teclado = new Scanner(System.in);
    private TipoService tipoService = new TipoService();
    private GeradorService geradorService = new GeradorService();
    private ReceptorService receptorService = new ReceptorService();
    private GeradorTipoService geracaoService = new GeradorTipoService();
    private RetiradaService retiradaService = new RetiradaService();

    public void executar() {
        while (true) {
            System.out.println();
            System.out.println("===== CicloMatch =====");
            System.out.println("1 - Cadastrar tipo de material");
            System.out.println("2 - Cadastrar gerador");
            System.out.println("3 - Cadastrar receptor");
            System.out.println("4 - Registrar geração (gerador gerou material)");
            System.out.println("5 - Registrar retirada (receptor pegou material)");
            System.out.println("6 - Listar tudo");
            System.out.println("0 - Sair");
            String opcao = ler("Escolha: ");

            try {
                switch (opcao) {
                    case "1": cadastrarTipo(); break;
                    case "2": cadastrarGerador(); break;
                    case "3": cadastrarReceptor(); break;
                    case "4": registrarGeracao(); break;
                    case "5": registrarRetirada(); break;
                    case "6": listarTudo(); break;
                    case "0": System.out.println("Até logo!"); return;
                    default: System.out.println("Opção inválida.");
                }
            } catch (IllegalArgumentException e) {
                System.out.println("[ERRO] " + e.getMessage());
            } catch (SQLException e) {
                System.out.println("[ERRO no banco] " + e.getMessage());
            }
        }
    }

    private void cadastrarTipo() throws SQLException {
        String nome = ler("Nome do material (ex.: Óleo de cozinha usado): ");
        tipoService.cadastrar(nome);
        System.out.println("[OK] Tipo cadastrado.");
    }

    private void cadastrarGerador() throws SQLException {
        String nome = ler("Nome: ");
        String cpf = ler("CPF (só números, Enter se não tiver): ");
        String cnpj = ler("CNPJ (só números, Enter se não tiver): ");
        String endereco = ler("Endereço: ");
        String numero = ler("Número: ");
        String bairro = ler("Bairro: ");
        String estado = ler("Estado (2 letras): ");
        String email = ler("E-mail de contato: ");
        geradorService.cadastrar(nome, endereco, numero, bairro, estado, email, cpf, cnpj);
        System.out.println("[OK] Gerador cadastrado.");
    }

    private void cadastrarReceptor() throws SQLException {
        String nome = ler("Nome: ");
        String cpf = ler("CPF (só números, Enter se não tiver): ");
        String cnpj = ler("CNPJ (só números, Enter se não tiver): ");
        String email = ler("E-mail: ");
        receptorService.cadastrar(nome, email, cpf, cnpj);
        System.out.println("[OK] Receptor cadastrado.");
    }

    private void registrarGeracao() throws SQLException {
        listarGeradores();
        listarTipos();
        int codGerador = lerInt("Código do gerador: ");
        int codTipo = lerInt("Código do tipo: ");
        String quantidade = ler("Quantidade em kg: ");
        String data = ler("Data (aaaa-mm-dd): ");
        geracaoService.registrar(codGerador, codTipo, quantidade, data);
        System.out.println("[OK] Geração registrada.");
    }

    private void registrarRetirada() throws SQLException {
        listarReceptores();
        listarGeracoes();
        int codReceptor = lerInt("Código do receptor: ");
        int codGeracao = lerInt("Código da geração: ");
        String quantidade = ler("Quantidade em kg: ");
        String data = ler("Data (aaaa-mm-dd): ");
        retiradaService.registrar(codReceptor, codGeracao, quantidade, data);
        System.out.println("[OK] Retirada registrada.");
    }

    private void listarTudo() throws SQLException {
        listarTipos();
        listarGeradores();
        listarReceptores();
        listarGeracoes();
        listarRetiradas();
    }



    private void listarTipos() throws SQLException {
        System.out.println("\nTIPOS");
        for (Tipo t : tipoService.listar()) {
            System.out.println("  " + t.getCodTipo() + " - " + t.getNome());
        }
    }

    private void listarGeradores() throws SQLException {
        System.out.println("\nGERADORES");
        for (Gerador g : geradorService.listar()) {
            System.out.println("  " + g.getCodGerador() + " - " + g.getNome()
                    + " | CPF: " + g.getCpf() + " | CNPJ: " + g.getCnpj());
        }
    }

    private void listarReceptores() throws SQLException {
        System.out.println("\nRECEPTORES");
        for (Receptor r : receptorService.listar()) {
            System.out.println("  " + r.getCodReceptor() + " - " + r.getNome()
                    + " | CPF: " + r.getCpf() + " | CNPJ: " + r.getCnpj());
        }
    }

    private void listarGeracoes() throws SQLException {
        System.out.println("\nGERAÇÕES (gerador_tipo)");
        for (GeradorTipo g : geracaoService.listar()) {
            System.out.println("  " + g.getCodGeradorTipo() + " - gerador " + g.getCodGerador()
                    + ", tipo " + g.getCodTipo() + ", " + g.getQuantidade() + " kg, " + g.getData());
        }
    }

    private void listarRetiradas() throws SQLException {
        System.out.println("\nRETIRADAS (receptor_gerador_tipo)");
        for (ReceptorGeradorTipo r : retiradaService.listar()) {
            System.out.println("  " + r.getCodReceptorGeradorTipo() + " - receptor " + r.getCodReceptor()
                    + ", geração " + r.getCodGeradorTipo() + ", " + r.getQuantidade() + " kg, " + r.getData());
        }
    }



    private String ler(String pergunta) {
        System.out.print(pergunta);
        return teclado.nextLine();
    }


    private int lerInt(String pergunta) {
        while (true) {
            try {
                return Integer.parseInt(ler(pergunta).trim());
            } catch (NumberFormatException e) {
                System.out.println("Digite apenas um número inteiro.");
            }
        }
    }
}
