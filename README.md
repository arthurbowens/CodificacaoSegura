# Sistema de Autenticação com Hash e Salt usando PBKDF2

Este projeto implementa um sistema de autenticação simples em Java que utiliza a função PBKDF2 para proteger as senhas dos usuários, aplicando salt e múltiplas iterações para fortalecer a segurança.

## Tecnologias Utilizadas

- **Java 8+**
- **PBKDF2 (Password-Based Key Derivation Function 2)** para hashing seguro de senhas
- **SecureRandom** para a geração de salt aleatório

## Funcionalidades

1. **Registro de Usuário**:
   - Ao registrar, o sistema solicita um nome de usuário e senha.
   - A senha é combinada com um salt aleatório e processada usando PBKDF2 para gerar um hash seguro.
   - O sistema armazena o nome do usuário, o hash da senha e o salt.

2. **Login de Usuário**:
   - Durante o login, o sistema pede o nome de usuário e a senha.
   - A senha fornecida é combinada com o salt armazenado e processada novamente com PBKDF2.
   - O hash gerado durante o login é comparado com o hash armazenado. Se forem iguais, o login é bem-sucedido.

## Estrutura do Projeto

O projeto é composto por duas classes principais:

- **SenhaUtilAvancada**: Responsável por gerar o hash da senha usando PBKDF2 e criar salt aleatório.
- **AutenticacaoAvancada**: Gerencia o registro, login e a lógica de armazenamento dos usuários.

## Como Rodar o Projeto

### Requisitos

- **Java 8+** instalado.
- **IDE** como Eclipse ou IntelliJ (ou linha de comando).

### Passos

1. **Clone o Repositório**:
   ```bash
   git clone https://github.com/seu-usuario/nome-do-projeto.git
