package atividade01;

import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Autenticacao {
    // Mapa para armazenar os usuários, onde cada usuário tem um array [hash, salt]
    private static Map<String, String[]> usuarios = new HashMap<>();

    public static void main(String[] args) throws NoSuchAlgorithmException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("1. Registrar");
        System.out.println("2. Login");
        int escolha = scanner.nextInt();
        scanner.nextLine(); // Limpa o buffer

        if (escolha == 1) {
            // Registro de um novo usuário
            System.out.print("Nome de usuário: ");
            String usuario = scanner.nextLine();
            System.out.print("Senha: ");
            String senha = scanner.nextLine();

            String salt = SenhaUtil.gerarSalt();   // Gera um salt aleatório
            String hash = SenhaUtil.gerarHash(senha, salt); // Gera o hash da senha

            usuarios.put(usuario, new String[]{hash, salt});  // Armazena o usuário
            System.out.println("Usuário registrado com sucesso!");

            // Realiza login automaticamente após o registro
            realizarLogin(scanner, usuario, senha);

        } else if (escolha == 2) {
            // Login do usuário
            System.out.print("Nome de usuário: ");
            String usuario = scanner.nextLine();
            System.out.print("Senha: ");
            String senha = scanner.nextLine();

            realizarLogin(scanner, usuario, senha);
        }
        scanner.close();
    }

    // Método para realizar o login
    private static void realizarLogin(Scanner scanner, String usuario, String senha) throws NoSuchAlgorithmException {
        String[] dados = usuarios.get(usuario);  // Recupera os dados armazenados
        if (dados != null) {
            String hashArmazenado = dados[0];
            String salt = dados[1];

            String hash = SenhaUtil.gerarHash(senha, salt);  // Gera o hash da senha informada
            System.out.println(hash);
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
