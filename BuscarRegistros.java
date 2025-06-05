package sistemabarbearianovo;

import java.util.Scanner;
import java.util.ArrayList;

public class BuscarRegistros {
    public void executar(Scanner entrada, ArrayList<Cliente> listaClientes) {
        System.out.println("--- Buscar Registros ---");

        if (listaClientes.isEmpty()) {
            System.out.println("Nenhum registro para buscar.");
            return;
        }

        System.out.print("Digite o nome do cliente para buscar: ");
        String termoBusca = entrada.nextLine().toLowerCase();
        boolean encontrado = false;

        for (Cliente cliente : listaClientes) {
            if (cliente.getNome().toLowerCase().contains(termoBusca)) {
                System.out.println("Encontrado: " + cliente);
                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println("Nenhum cliente encontrado com o termo de busca.");
        }
    }
}