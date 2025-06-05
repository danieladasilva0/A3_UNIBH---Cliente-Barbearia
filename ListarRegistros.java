package sistemabarbearianovo;

import java.util.ArrayList;

public class ListarRegistros {
    public void executar(ArrayList<Cliente> listaClientes) {
        System.out.println("--- Listar Todos os Registros ---");

        if (listaClientes.isEmpty()) {
            System.out.println("Nenhum registro encontrado.");
            return;
        }

        for (int i = 0; i < listaClientes.size(); i++) {
            System.out.println("ID: " + i + " - " + listaClientes.get(i));
        }
    }
}