/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

/**
 *
 * @author Laryssa, Arthur 
 */
import java.util.Random;
import java.util.Scanner;

class Cinema {
    private int capacidadeAssentos;
    private int escolia;
    private int opcaoo;
    private int escolhaopgt;
    private int assentosDisponiveis;
    private int assentosEspeciais;
    private int assentosEscolhidos;
    private int espPv;
    private boolean[] assentos;
    private String nomeUnidade;

    public Cinema(int capacidadeAssentos) {
        this.capacidadeAssentos = capacidadeAssentos;
        this.assentosDisponiveis = capacidadeAssentos;
        this.assentos = new boolean[capacidadeAssentos];
        this.assentosEspeciais = 3;
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
        System.out.println("");
        System.out.println("");
        System.out.println("ASSENTOS DISPONIVEIS:");
        System.out.println("--------------------------");
        for (int i = 0; i < capacidadeAssentos; i++) {
            if (!assentos[i]) {
                System.out.print(i + 1 + " ");
            }
        }
        System.out.println();
    }

    public void exibirAssentosEspeciais() {
        System.out.println("Assentos Especiais");
        for (int i = 0; i < capacidadeAssentos; i++) {
            if (!assentos[i]) {
                System.out.println(i + 1 + "");
            }
        }

        System.out.println();

    }

    public boolean reservarAsssento(int assento) {
        if (assento < 1 || assento > capacidadeAssentos) {
            System.out.println("Assento invalido .Escolha um assento entre 1  e " + capacidadeAssentos);

            return false;

        }
        if (assentos[assento - 1]) {
            System.out.println("O assento" + assento + " ja está ocupado.");
            return false;
        }
        assentos[assento - 1] = true;
        assentosDisponiveis--;
        System.out.println("Assento" + assento + "reservado com sucesso.");
        return true;

    }

}

public class ReservaCinema {
    // Essas são as opções de unidade, ela tem que ser o primeiro na classe para o
    // usuário ter acesso aos filmes em cartaz e assentos daquela região
    static class UnidadeCinema {
        public static int escolherUnidade() {
            Scanner scanner = new Scanner(System.in);
            System.out.println("");
            System.out.println("");
            System.out.println("");
            System.out.println(
                    "=============================================================================================");
            System.out.println("OLÁ, SEJA BEM VINDO!");
            System.out.println(
                    "Para utilizar este sistema, use apenas os numerais correspondentes à frente das informações!");
            System.out.println(
                    "=============================================================================================");
            System.out.println("");
            System.out.println("Para fazer sua reserva escolha uma de nossas unidades:");
            System.out.println("1- Unidade Belo Horizonte");
            System.out.println("2- Unidade São Paulo");
            System.out.println("3- Unidade Curitiba");
            System.out.println("4- Unidade Rio de Janeiro");
            System.out.print("=> ");

            int choice = scanner.nextInt();
            scanner.nextLine();
            return choice;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Cinema cinema = new Cinema(20);
        // Esse while true irá mostrar para o usuário o endereço da unidade
        int escolhaopcao = 0;
        int escolherumaUnidade = 0;
        int opcaohora = 0;
        int valoring = 30;
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
                        cinema = new Cinema(20);// Esse 20 representa o número de assentos em cada unidade
                        cinema.escolheraUnidade("Unidade Belo Horizonte - Avenida Antônio Carlos 1820");
                        break;
                    case 2:
                        cinema = new Cinema(20);// Caso queira aumentar ou diminuir o número da unidade tem que alterar
                                                // esse valor
                        cinema.escolheraUnidade("Unidade São Paulo - Avenida Paulista 668");
                        break;
                    case 3:
                        cinema = new Cinema(20);
                        cinema.escolheraUnidade("Unidade Curitiba - Rua Prudente Moraes 775");
                        break;
                    case 4:
                        cinema = new Cinema(20);
                        cinema.escolheraUnidade("Unidade Rio de Janeiro - Avenida Portugal 9650");
                        break;
                }
            }
            // Infomaçães após escolha da Unidade
            System.out.println("");
            System.out.println("");
            System.out.println("MENU INICIAL");
            System.out.println("--------------------");
            System.out.println("1. Filme em Cartaz:");
            System.out.println("2. Filmes em Pré-venda:");
            System.out.println("3. Escolher outra unidade:");
            System.out.println("4. Sair");
            System.out.println("");
            System.out.print("O Que deseja fazer? ");
            escolhaopcao = scanner.nextInt(); // Recolhe a opção desejado

            // condição para o escolhaopcao, Mostrar os filmes em cartaz.
            if (escolhaopcao < 1 || escolhaopcao >= 5) {
                escolhaopcao = 1;
                continue;
            }
            if (escolhaopcao == 0) {
                System.out.println("");
                System.out.println("");
                System.out.println("Opção invalida! Escolha uma opção ente 1 e 4");

            }
            if (escolhaopcao == 3) {
                escolherumaUnidade = 0; // Define escolherumaUnidade como 0 para que o usuário escolha uma nova unidade
                continue;
            }
            // condição para o escolhaopcao, Encerra o programa
            if (escolhaopcao == 4) {
                System.out.println("");
                System.out.println("");
                System.out.println("Saindo do programa. Adeus!");
                return;
            }
            if (escolhaopcao >= 5) {
                System.out.println("");
                System.out.println("");
                System.out.println("Opção invalida! Escolha uma opção ente 1 e 4");

            }

            if (escolhaopcao == 1) {
                System.out.println("");
                System.out.println("");
                System.out.println("FILMES EM CARTAZ");
                System.out.println("--------------------");
                System.out.println("1. O Exorcista - O Devoto");
                System.out.println("2. Patrulha Canina: Um Filme Superpoderoso");
                System.out.println("3. Nosso Sonho");
                System.out.println("4. Os Mercenários 4");
                System.out.println("5. Resistência");
                System.out.println("6. Jogos Mortais X");
                System.out.println("7. A Freira 2");
                System.out.println("8. Som da Liberdade");
                System.out.println("9. Voltar para o Menu Inicial");
                System.out.println("");
                System.out.print("Qual o Filme deseja escolher? ");

                int escolhafilme = scanner.nextInt(); // Recolhe a opção do filme desejado

                // condição para o escolhafilme, onde irá dar as opçoes de horario.
                if (escolhafilme < 1 || escolhafilme >= 9) {
                    escolhafilme = 1;
                    continue;
                }

                if (escolhafilme >= 1 && escolhafilme <= 8) {
                    System.out.println("");
                    System.out.println("");
                    System.out.println("--------------------");
                    System.out.println("Horários disponíveis para hoje: ");
                    System.out.println("1. 9:00");
                    System.out.println("2. 11:00");
                    System.out.println("3. 13:00");
                    System.out.println("4. 15:00");
                    System.out.println("5. 17:00");
                    System.out.println("6. 19:00");
                    System.out.println("7. 21:00");
                    System.out.println("8. 23:00");
                    System.out.println("9. Voltar para o Menu Inicial");
                    System.out.println("--------------------");
                    System.out.println("");
                    System.out.print("=> ");
                    opcaohora = scanner.nextInt(); // valor apenas para perguntar o horario

                    if (opcaohora >= 10 || opcaohora <= 0) {
                        escolhafilme = 1;
                        continue;
                    }

                    // condiçao para validaçao da escolha
                    if (opcaohora >= 1 && opcaohora <= 8) {
                        System.out.println("");
                        System.out.println("");
                        System.out.println("OPÇÕES DE ASSENTO:");
                        System.out.println("--------------------");
                        System.out.println("1. Reservar assento");
                        System.out.println("2. Exibir assentos disponíveis");
                        System.out.println("3. Sair");
                        System.out.println("4. Voltar para o Menu Inicial");
                        System.out.println("");
                        System.out.print("=> ");
                        int opcao = scanner.nextInt(); // Recolhe a opção acima
                        scanner.nextLine();

                        if (opcao == 4) {
                            escolhafilme = 1;
                            continue;
                        }

                        if (opcao == 4) {
                            escolherumaUnidade = 0;
                            continue;
                        }

                        if (opcao < 1 || opcao > 4) {
                            System.out.println("Opção incorreta! ");
                            return;
                        }
                        // condição para sair do sitema
                        if (opcao == 3) {
                            System.out.println("");
                            System.out.println("");
                            System.out.println("Saindo do programa. Adeus!");
                            return;
                        }
                        // Switch para as duas primeiras opcoes
                        switch (opcao) {
                            case 1:
                                System.out.println("");
                                System.out.println("");
                                System.out.println("--------------------------------------------");
                                System.out.println("Seu assento será especial? (1-Sim / 2-Não)");
                                System.out.println("");
                                System.out.print("=> ");
                                int esp = scanner.nextInt();
                                if (esp == 0 || esp >= 3) {
                                    System.out.println("");
                                    System.out.println("Opção de assentos especiais invalido!");
                                    escolhafilme = 1;
                                    continue;
                                }
                                cinema.exibirAssentosDisponiveis();
                                System.out.println("");
                                System.out.print("Escolha um assento: ");
                                int assentoEscolhido = scanner.nextInt();
                                System.out.println("");
                                cinema.reservarAssento(assentoEscolhido);
                                if (assentoEscolhido <= 0 || assentoEscolhido >= 21) {
                                    escolhafilme = 1;
                                    continue;

                                }

                                break;
                            case 2:
                                cinema.exibirAssentosDisponiveis();
                                escolhafilme = 1;
                                continue;

                            default:
                                System.out.println("Opção inválida. Tente novamente.");

                        }

                    }

                    // condiçao para validaçao
                    if (opcaohora == 0) {
                        System.out.println("");
                        System.out.println("");
                        System.out.println("Horario invalido!");

                    }
                    if (opcaohora >= 9) {
                        System.out.println("");
                        System.out.println("");
                        System.out.println("Horario invalido!");

                    }
                }

                if (escolhafilme == 0) {
                    System.out.println("");
                    System.out.println("");
                    System.out.println("Opção invalida! Escolha um filme entre 1 e 8.");

                }
                if (escolhafilme >= 9) {
                    System.out.println("");
                    System.out.println("");
                    System.out.println("Opção invalida! Escolha um filme entre 1 e 8.");

                }

            }

            // condição para o escolhaopcao, Mostrar os filmes em Pré-venda.
            if (escolhaopcao == 2) {
                System.out.println("");
                System.out.println("");
                System.out.println("FILMES EM PRÉ-VENDA");
                System.out.println("--------------------");
                System.out.println("1. Taylor Swift: The Eras Tour");
                System.out.println("");
                System.out.print("Qual filme em pré-venda deseja escolher? ");
                int escolhafilmePv = scanner.nextInt(); // Recolhe a opção do filme em Pré-venda
                if (escolhafilmePv < 1 || escolhafilmePv > 1) {
                    System.out.println("opção inválida!");
                    escolhaopcao = 1;
                    continue;

                }
                // condição para o escolhafilmePv
                if (escolhafilmePv == 1) { // Atualize o intervalo conforme necessário
                    System.out.println("");
                    System.out.println("");
                    System.out.println("--------------------");
                    System.out.println("Compra programada para 03 de novembro!!");
                    System.out.println("Horários disponíveis: ");
                    System.out.println("1. 9:00");
                    System.out.println("2. 11:00");
                    System.out.println("3. 13:00");
                    System.out.println("4. 15:00");
                    System.out.println("5. 17:00");
                    System.out.println("6. 19:00");
                    System.out.println("7. 21:00");
                    System.out.println("8. 23:00");
                    System.out.println("9. Voltar para o Menu Inicial");
                    System.out.println("--------------------");
                    System.out.println("");
                    opcaohora = scanner.nextInt();

                    if (opcaohora >= 10 || opcaohora <= 0) {
                        escolhaopcao = 1;
                        continue;
                    }
                    if (opcaohora < 1 || opcaohora > 9) {
                        System.out.println("Opção incorreta");
                        break;
                    }

                    // condiçao para validaçao
                    if (opcaohora >= 1 && opcaohora <= 8) {
                        System.out.println("");
                        System.out.println("");
                        System.out.println("OPÇÕES DE ASSENTO:");
                        System.out.println("--------------------");
                        System.out.println("1. Reservar assento");
                        System.out.println("2. Exibir assentos disponíveis");
                        System.out.println("3. Sair");
                        System.out.println("4. Voltar para o Menu Inicial");
                        System.out.println("");
                        System.out.print("=> ");
                        int opcaoo = scanner.nextInt();
                        scanner.nextLine();

                        if (opcaoo >= 5) {
                            System.out.println("Opção inválida!");
                            break;

                        }

                        if (opcaoo == 4) {
                            escolhaopcao = 0;
                            continue;
                        }

                        if (opcaoo == 3) {
                            System.out.println("");
                            System.out.println("");
                            System.out.println("Saindo do programa. Adeus!");
                            return;
                        }
                        // Switch para as duas primeiras opcoes
                        switch (opcaoo) {
                            case 1:
                                System.out.println("");
                                System.out.println("");
                                System.out.println("--------------------------------------------");
                                System.out.println("Seu assento será especial? (1-Sim / 2-Não)");
                                System.out.println("");
                                System.out.print("=> ");
                                int espPv = scanner.nextInt();
                                if (espPv == 0 || espPv >= 3) {
                                    System.out.println("");
                                    System.out.println("Opção de assentos especiais invalido!");
                                    escolhaopcao = 1;
                                    continue;
                                }

                                cinema.exibirAssentosDisponiveis();
                                System.out.print("Escolha um assento: ");
                                int assentoEscolhido = scanner.nextInt();
                                System.out.println("");
                                cinema.reservarAssento(assentoEscolhido);
                                if (assentoEscolhido <= 0 || assentoEscolhido >= 21) {
                                    escolhaopcao = 1;
                                    continue;
                                }

                                break;
                            case 2:
                                cinema.exibirAssentosDisponiveis();
                                escolhaopcao = 1;
                                continue;
                            case 3:
                                cinema.exibirAssentosDisponiveis();
                                break;
                            default:
                                System.out.println("Opção inválida. Tente novamente.");
                        }

                    }

                    if (opcaohora == 0) {
                        System.out.println("Horario invalido!");

                    }
                    if (opcaohora >= 9) {
                        System.out.println("Horario invalido!");
                    }

                }

                if (escolhafilmePv == 0) {
                    System.out.println("");
                    System.out.println("");
                    System.out.println("Opção invalida! Escolha um filme");
                }

                if (escolhafilmePv >= 2) {
                    System.out.println("");
                    System.out.println("");
                    System.out.println("Opção invalida! Escolha um filme");
                }

            }
            // condição para o escolhaopcao, Volta para a Unidade
            System.out.println("");
            // condição para sair do sitema

            System.out.println("");
            System.out.println("");
            System.out.println("Formas de pagamento");
            System.out.println("--------------------");
            System.out.println("1. Pix");
            System.out.println("2. Cartão crédito");
            System.out.println("3. Cartão débito");
            System.out.println("4. Cartão fidelidade - 25% de desconto");
            System.out.println("5. Cartão Santander - 50% Desconto Esfera");
            System.out.println("6. Voltar para o Menu Inicial");
            System.out.println("");
            System.out.print("=> ");
            int escolhaopgt = scanner.nextInt();
            Random random = new Random();
            int valorPagamento = random.nextInt(10000) + 1;

            if (escolhaopgt >= 1 && escolhaopgt <= 3) {
                System.out.println("");
                System.out.println("");
                System.out.println("TIPO DE INGRESSO:");
                System.out.println("-------------------------");
                System.out.println("1. Meia - R$15,00");
                System.out.println("2. Inteira - R$30,00");
                System.out.println("");
                System.out.print("Escolha o tipo de ingresso desejado: ");
                int escolia = scanner.nextInt();
                if (escolia == 1) {
                    System.out.println("");
                    System.out.println("");
                    System.out.println("Ingresso meia entrada para estudantes, idosos, e menores de 21 anos");
                }
                if (escolia == 2) {
                    System.out.println("");
                    System.out.println("");
                    System.out.println("Ingresso inteiro");
                }

                if (escolia < 1 || escolia > 2) {
                    System.out.println("");
                    System.out.println("");
                    System.out.println("Opção inválida, tente novamente");

                    continue;

                }

                if (escolia == 1) {
                    System.out.println("");
                    System.out.println("");
                    System.out.println(
                            "==============================================================================================================================");
                    System.out.println("RESUMO DO PEDIDO:");
                    System.out.println("Seu assento no valor de: R$" + valoring / 2
                            + " foi reservado e terá validade até 20 minutos depois do inicio do filme. ");
                    System.out.println("Apresente o codigo " + valorPagamento + " na bilheteria e pegue seu ingresso.");
                    System.out.println(
                            "==============================================================================================================================");

                }

                if (escolia == 2) {

                    System.out.println("");
                    System.out.println("");
                    System.out.println(
                            "==============================================================================================================================");
                    System.out.println("RESUMO DO PEDIDO:");
                    System.out.println("Seu assento no valor de: R$" + valoring
                            + " foi reservado e terá validade até 20 minutos depois do inicio do filme. ");
                    System.out.println("Apresente o codigo " + valorPagamento + " na bilheteria e pegue seu ingresso.");
                    System.out.println(
                            "==============================================================================================================================");
                }
            }

            if (escolhaopgt == 4) {
                System.out.println("");
                System.out.println("");
                System.out.println("TIPO DE INGRESSO:");
                System.out.println("-------------------------");
                System.out.println("Você escolheu a opção promocional Cartão fidelidade - 25% de desconto ");
                System.out.println("O valor de seu ingresso e R$22,50");
                System.out.print(" ");
                System.out.println("");
                System.out.println(
                        "==============================================================================================================================");
                System.out.println("RESUMO DO PEDIDO:");
                System.out.println(
                        "Seu assento no valor de: R$22,50 foi reservado e terá validade até 20 minutos depois do inicio do filme. ");
                System.out.println("Apresente o codigo " + valorPagamento + " na bilheteria e pegue seu ingresso.");
                System.out.println(
                        "==============================================================================================================================");
            }
            if (escolhaopgt == 5) {
                System.out.println("");
                System.out.println("");
                System.out.println("TIPO DE INGRESSO:");
                System.out.println("-------------------------");
                System.out.println("Você escolheu a opção promocional Cartão Santander - 50% Desconto Esfera ");
                System.out.println("O valor de seu ingresso e R$15");
                System.out.print(" ");
                System.out.println("");
                System.out.println(
                        "==============================================================================================================================");
                System.out.println("RESUMO DO PEDIDO:");
                System.out.println("Seu assento no valor de: R$" + valoring / 2
                        + " foi reservado e terá validade até 20 minutos depois do inicio do filme. ");
                System.out.println("Apresente o codigo " + valorPagamento + " na bilheteria e pegue seu ingresso.");
                System.out.println(
                        "==============================================================================================================================");
            }
            if (escolhaopgt == 6) {
                escolhaopcao = 1;
                continue;
            }
            if (escolhaopgt >= 7 || escolhaopgt <= 0) {
                System.out.println("Opção inválida! Tente novamente.");
                continue;
            }
            System.out.println("");
            System.out.println("");
            System.out.println("Você deseja fazer outra compra? (1-Sim / 2-Não):");
            System.out.print("=> ");
            int escF = scanner.nextInt();
            if (escF == 1) {
                escolhaopcao = 1;
                continue;
            }
            if (escF == 2) {
                System.out.println("");
                System.out.println("");
                System.out.println("Saindo do programa. Adeus!");
                break;
            }
            if (escF == 0 || escF >= 3) {
                System.out.println("");
                System.out.println("Valor inválido");
                escolhaopcao = 1;
                continue;
            }

        }

    }
}