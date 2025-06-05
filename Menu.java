package sistemabarbearianovo;

import java.util.Scanner;
import java.util.ArrayList;

public class Menu {
    public static void main(String[] args) {
        try (Scanner entrada = new Scanner(System.in)) {
            ArrayList<Cliente> listaClientes = new ArrayList<>();

            int escolhaMenu;

            System.out.println("Bem vindo ao menu do nosso site da barbearia!");

            do {
                System.out.println("\n-----------------------------------------");
                System.out.println("Por favor, digite o número equivalente ao serviço desejado: ");
                System.out.println("1- Criar novo registro");
                System.out.println("2- Listar todos os registros");
                System.out.println("3- Buscar registros");
                System.out.println("4- Editar registro");
                System.out.println("5- Excluir registro");
                System.out.println("6- Sair");
                System.out.print("Sua escolha: ");

                while (!entrada.hasNextInt()) {
                    System.out.println("Entrada inválida. Por favor, digite um número.");
                    entrada.next();
                    System.out.print("Sua escolha: ");
                }
                escolhaMenu = entrada.nextInt();
                entrada.nextLine();

                System.out.println("-----------------------------------------");
                System.out.println("");

                if (escolhaMenu < 1 || escolhaMenu > 6) {
                    System.out.println("OPÇÃO INVÁLIDA! Tente novamente.");
                } else {
                    switch (escolhaMenu) {
                        case 1 -> {
                            CriarRegistro criarRegistro = new CriarRegistro();
                            criarRegistro.executar(entrada, listaClientes);
                        }

                        case 2 -> {
                            ListarRegistros listarRegistros = new ListarRegistros();
                            listarRegistros.executar(listaClientes);
                        }

                        case 3 -> {
                            BuscarRegistros buscarRegistros = new BuscarRegistros();
                            buscarRegistros.executar(entrada, listaClientes);
                        }

                        case 4 -> {
                            EditarRegistro editarRegistro = new EditarRegistro();
                            editarRegistro.executar(entrada, listaClientes);
                        }

                        case 5 -> {
                            ExcluirRegistro excluirRegistro = new ExcluirRegistro();
                            excluirRegistro.executar(entrada, listaClientes);
                        }

                        case 6 -> {
                            System.out.print("Encerrando... ");
                            try {
                                Thread.sleep(2500);
                            } catch (InterruptedException e) {
                                System.out.println("OPS! Processo interrompido!");
                                Thread.currentThread().interrupt();
                            }
                            System.out.print("Aguarde... ");
                            try {
                                Thread.sleep(5000);
                            } catch (InterruptedException e) {
                                System.out.println("Algo deu errado!");
                                Thread.currentThread().interrupt();
                            }
                            System.out.println("Tudo pronto! Sessão Encerrada!");
                        }
                    }
                }
            } while (escolhaMenu != 6);
        }
    }
}