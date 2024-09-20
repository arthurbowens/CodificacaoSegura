package atividade02;

import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AutenticacaoAvancada {
    private static Map<String, String[]> usuarios = new HashMap<>(); // Mapa para armazenar [hash, salt]

    public static void main(String[] args) throws NoSuchAlgorithmException {
        Scanner scanner = new Scanner(System.in);
        boolean executando = true;

        while (executando) {
            // Exibe as opções de menu
            System.out.println("\n1. Registrar");
            System.out.println("2. Login");
            System.out.println("3. Sair");
            System.out.print("Escolha uma opção: ");
            
            int escolha = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer

            switch (escolha) {
                case 1:
                    // Registro de um novo usuário
                    registrarUsuario(scanner);
                    break;
                case 2:
                    // Login do usuário
                    realizarLogin(scanner);
                    break;
                case 3:
                    // Opção de sair
                    executando = false;
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
                    break;
            }
        }
        scanner.close();
    }

    // Método para registrar um novo usuário
    private static void registrarUsuario(Scanner scanner) throws NoSuchAlgorithmException {
        System.out.print("Nome de usuário: ");
        String usuario = scanner.nextLine();
        System.out.print("Senha: ");
        String senha = scanner.nextLine();

        String salt = SenhaUtilAvancada.gerarSalt();   // Gera um salt aleatório
        String hash = SenhaUtilAvancada.gerarHash(senha, salt); // Gera o hash da senha

        usuarios.put(usuario, new String[]{hash, salt});  // Armazena o usuário
        System.out.println("Usuário registrado com sucesso!");
    }

    // Método para realizar o login
    private static void realizarLogin(Scanner scanner) throws NoSuchAlgorithmException {
        System.out.print("Nome de usuário: ");
        String usuario = scanner.nextLine();
        System.out.print("Senha: ");
        String senha = scanner.nextLine();

        String[] dados = usuarios.get(usuario);  // Recupera os dados armazenados
        if (dados != null) {
            String hashArmazenado = dados[0];
            String salt = dados[1];

            String hash = SenhaUtilAvancada.gerarHash(senha, salt);  // Gera o hash da senha informada
            if (hash.equals(hashArmazenado)) {
                System.out.println("Login bem-sucedido!");
            } else {
                System.out.println("Senha incorreta!");
            }
        } else {
            System.out.println("Usuário não encontrado!");
        }
    }
}
