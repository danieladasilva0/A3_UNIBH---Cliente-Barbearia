package sistemabarbearianovo;

import java.util.Scanner;
import java.util.ArrayList;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class EditarRegistro {
    public void executar(Scanner entrada, ArrayList<Cliente> listaClientes) {
        System.out.println("--- Editar Registro ---");

        if (listaClientes.isEmpty()) {
            System.out.println("Nenhum registro para editar.");
            return;
        }

        System.out.print("Digite o ID do cliente a ser editado: ");
        int id = entrada.nextInt();
        entrada.nextLine();

        if (id >= 0 && id < listaClientes.size()) {
            Cliente clienteParaEditar = listaClientes.get(id);

            System.out.println("Cliente selecionado: " + clienteParaEditar);

            System.out.print("Novo nome (deixe em branco para manter o atual: " + clienteParaEditar.getNome() + "): ");
            String novoNome = entrada.nextLine();
            if (!novoNome.isEmpty()) {
                clienteParaEditar.setNome(novoNome);
            }

            System.out.print("Novo telefone (deixe em branco para manter o atual: " + clienteParaEditar.getTelefone() + "): ");
            String novoTelefone = entrada.nextLine();
            if (!novoTelefone.isEmpty()) {
                clienteParaEditar.setTelefone(novoTelefone);
            }

            boolean dataValida = false;
            while (!dataValida) {
                System.out.print("Nova data de nascimento (AAAA-MM-DD, deixe em branco para manter: " + clienteParaEditar.getDataNascimento() + "): ");
                String novaDataStr = entrada.nextLine();
                if (novaDataStr.isEmpty()) {
                    dataValida = true;
                } else {
                    try {
                        clienteParaEditar.setDataNascimento(LocalDate.parse(novaDataStr));
                        dataValida = true;
                    } catch (DateTimeParseException e) {
                        System.out.println("Formato de data inválido. Use AAAA-MM-DD.");
                    }
                }
            }

            System.out.print("Novo email (deixe em branco para manter o atual: " + clienteParaEditar.getEmail() + "): ");
            String novoEmail = entrada.nextLine();
            if (!novoEmail.isEmpty()) {
                clienteParaEditar.setEmail(novoEmail);
            }

            System.out.println("Registro atualizado com sucesso!");
        } else {
            System.out.println("ID inválido.");
        }
    }
}