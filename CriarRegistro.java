package sistemabarbearianovo;

import java.util.Scanner;
import java.util.ArrayList;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class CriarRegistro {
    public void executar(Scanner entrada, ArrayList<Cliente> listaClientes) {
        System.out.println("--- Criar Novo Registro ---");

        System.out.print("Digite o nome do cliente: ");
        String nome = entrada.nextLine();

        System.out.print("Digite o telefone do cliente: ");
        String telefone = entrada.nextLine();

        LocalDate dataNascimento = null;
        boolean dataValida = false;
        while (!dataValida) {
            System.out.print("Digite a data de nascimento do cliente (AAAA-MM-DD): ");
            String dataStr = entrada.nextLine();
            try {
                dataNascimento = LocalDate.parse(dataStr);
                dataValida = true;
            } catch (DateTimeParseException e) {
                System.out.println("Formato de data inválido. Use AAAA-MM-DD.");
            }
        }

        System.out.print("Digite o email do cliente: ");
        String email = entrada.nextLine();

        Cliente novoCliente = new Cliente(nome, telefone, dataNascimento, email);
        listaClientes.add(novoCliente);

        System.out.println("Registro criado com sucesso!");
    }
}