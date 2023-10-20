/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.reservacinema;

/**
 *
 * @author Laryssa, Arthur 
 */
import java.util.Scanner;

class Cinema {
    private int capacidadeAssentos;
    private int assentosDisponiveis;
    private boolean[] assentos;
    private String nomeUnidade;

    public Cinema(int capacidadeAssentos) {
        this.capacidadeAssentos = capacidadeAssentos;
        this.assentosDisponiveis = capacidadeAssentos;
        this.assentos = new boolean[capacidadeAssentos];
    }

    // Esse método irá fazer com que o usuário possa escolher a unidade que ele quer
    // reservar o assento
    public void escolheraUnidade(String escolheraUnidade) {
        this.nomeUnidade = escolheraUnidade;
    }

    public boolean reservarAssento(int assento) {
        if (assento < 1 || assento > capacidadeAssentos) {
            System.out.println("Assento inválido. Escolha um assento entre 1 e " + capacidadeAssentos);
            return false;
        }

        if (assentos[assento - 1]) {
            System.out.println("O assento " + assento + " já está ocupado.");
            return false;
        }

        assentos[assento - 1] = true;
        assentosDisponiveis--;
        System.out.println("Assento " + assento + " reservado com sucesso.");
        return true;
    }

    public void exibirAssentosDisponiveis() {
        System.out.println("Assentos disponíveis:");
        for (int i = 0; i < capacidadeAssentos; i++) {
            if (!assentos[i]) {
                System.out.print(i + 1 + " ");
            }
        }
        System.out.println();
    }
}

public class ReservaCinema {
    // Essas são as opções de unidade, ela tem que ser o primeiro na classe para o
    // usuário ter acesso aos filmes em cartaz e assentos daquela região
    static class UnidadeCinema {
        public static int escolherUnidade() {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Olá, Seja bem vindo! Para fazer sua reserva escolha uma de nossas unidades:");
            System.out.println("1- Unidade Belo Horizonte");
            System.out.println("2- Unidade São Paulo");
            System.out.println("3- Unidade Curitiba");
            System.out.println("4- Unidade Rio de Janeiro");

            int choice = scanner.nextInt();
            scanner.nextLine();
            return choice;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Cinema cinema = null;// Esse valor nulo irá permitir manipular o numero de cadeiras em cada unidade
        // Esse while true irá mostrar para o usuário o endereço da unidade
        int escolhaopcao = 0;
        int escolherumaUnidade = 0;
        // As variaveis a cima estao com "=0", para dar um valor inicial a elas.

        // Se o usuário digitar um número fora das opções esse while fará com que o
        // programa reinicie
        while (escolhaopcao != 4) {
            // Seção de escolha da unidade
            if (escolherumaUnidade == 0) {
                while (true) {
                    escolherumaUnidade = UnidadeCinema.escolherUnidade();
                    if (escolherumaUnidade >= 1 && escolherumaUnidade <= 4) {
                        break;
                    } else {
                        System.out.println("Opção inválida! Tente novamente");
                    }
                }
                // Indica o que vai acontecer ao digitar a opção válida
                switch (escolherumaUnidade) {
                    case 1:
                        cinema = new Cinema(10);// Esse 10 representa o número de assentos em cada unidade
                        cinema.escolheraUnidade("Unidade Belo Horizonte - Avenida Antônio Carlos 1820");
                        break;
                    case 2:
                        cinema = new Cinema(10);// Caso queira aumentar ou diminuir o número da unidade tem que alterar
                                                // esse valor
                        cinema.escolheraUnidade("Unidade São Paulo - Avenida Paulista 668");
                        break;
                    case 3:
                        cinema = new Cinema(10);
                        cinema.escolheraUnidade("Unidade Curitiba - Rua Prudente Moraes 775");
                        break;
                    case 4:
                        cinema = new Cinema(10);
                        cinema.escolheraUnidade("Unidade Rio de Janeiro - Avenida Portugal 9650");
                        break;
                }
            }
            // Infomaçães após escolha da Unidade
            System.out.println("");
            System.out.println("");
            System.out.println("O Que deseja fazer agora?");
            System.out.println("1. Filme em Catalogo:");
            System.out.println("2. Filmes em Pré-venda:");
            System.out.println("3. Escolher outra unidade:");
            System.out.println("4. Sair");
            escolhaopcao = scanner.nextInt(); // Recolhe a opção desejado
            System.out.println("");
            System.out.println("");

            // condição para o escolhaopcao, Mostrar os filmes em cartaz.
            if (escolhaopcao == 1) {
                System.out.println("FILMES EM CARTAZ");
                System.out.println("1. O Exorcista - O Devoto");
                System.out.println("2. Patrulha Canina: Um Filme Superpoderoso");
                System.out.println("3. Nosso Sonho");
                System.out.println("4. Os Mercenários 4");
                System.out.println("5. Resistência");
                System.out.println("6. Jogos Mortais X");
                System.out.println("7. A Freira 2");
                System.out.println("8. Som da Liberdade");
                System.out.println("");
                System.out.println("Qual o Filme deseja escolher?");
                int escolhafilme = scanner.nextInt(); // Recolhe a opção do filme desejado
                System.out.println("");
                System.out.println("");

                // condição para o escolhafilme, onde irá dar as opçoes de assento.
                if (escolhafilme >= 1 && escolhafilme <= 8) {
                    System.out.println("Escolha uma opção:");
                    System.out.println("1. Reservar assento");
                    System.out.println("2. Exibir assentos disponíveis");
                    System.out.println("3. Sair");
                    int opcao = scanner.nextInt(); // Recolhe a opção acima
                    scanner.nextLine();
                    System.out.println("");
                    System.out.println("");
                    // condição para sair do sitema
                    if (opcao == 3) {
                        System.out.println("Saindo do programa. Adeus!");
                        return;
                    }
                    // Switch para as duas primeiras opcoes
                    switch (opcao) {
                        case 1:
                            cinema.exibirAssentosDisponiveis();
                            System.out.print("Escolha um assento: ");
                            int assentoEscolhido = scanner.nextInt();
                            cinema.reservarAssento(assentoEscolhido);
                            break;
                        case 2:
                            cinema.exibirAssentosDisponiveis();
                            break;
                        default:
                            System.out.println("Opção inválida. Tente novamente.");
                    }

                    System.out.println("Saindo do programa. Adeus!");
                }
            }

            // condição para o escolhaopcao, Mostrar os filmes em Pré-venda.
            if (escolhaopcao == 2) {
                System.out.println("FILMES EM PRÉ-VENDA");
                System.out.println("1. Taylor Swift: The Eras Tour");
                System.out.println("");
                System.out.println("Qual filme em pré-venda deseja escolher?");
                int escolhafilmePv = scanner.nextInt(); // Recolhe a opção do filme em Pré-venda
                System.out.println("");

                // condição para o escolhafilmePv
                if (escolhafilmePv >= 1 && escolhafilmePv <= 2) { // Atualize o intervalo conforme necessário
                    System.out.println("Escolha uma opção:");
                    System.out.println("1. Reservar assento");
                    System.out.println("2. Exibir assentos disponíveis");
                    System.out.println("3. Sair");
                    int opcao = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("");
                    // condição para sair do sitema
                    if (opcao == 3) {
                        System.out.println("Saindo do programa. Adeus!");
                        return;
                    }
                    // Switch para as duas primeiras opcoes
                    switch (opcao) {
                        case 1:
                            cinema.exibirAssentosDisponiveis();
                            System.out.print("Escolha um assento: ");
                            int assentoEscolhido = scanner.nextInt();
                            cinema.reservarAssento(assentoEscolhido);
                            break;
                        case 2:
                            cinema.exibirAssentosDisponiveis();
                            break;
                        default:
                            System.out.println("Opção inválida. Tente novamente.");
                    }
                }
            }

            // condição para o escolhaopcao, Volta para a Unidade
            if (escolhaopcao == 3) {
                escolherumaUnidade = 0;

            }
            // condição para o escolhaopcao, Encerra o programa
            if (escolhaopcao == 4) {
                System.out.println("Saindo do programa. Adeus!");
                return;
            }

        }
    }
}
