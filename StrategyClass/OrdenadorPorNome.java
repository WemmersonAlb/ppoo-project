package StrategyClass;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import Model.Tarefa;

public class OrdenadorPorNome implements OrdenadorStrategy{
    public List<Tarefa> ordenadorTarefas(List<Tarefa> tarefas, int operacao){

        if(operacao == 1){
            Comparator<Tarefa> comparador = new Comparator<Tarefa>() {
                public int compare (Tarefa a1, Tarefa a2){
                    return a1.getNome().compareTo(a2.getNome());
                }
            };
            Collections.sort(tarefas, comparador);
            return tarefas;
        }else if(operacao == 2){
            Comparator<Tarefa> comparador = new Comparator<Tarefa>() {
                public int compare (Tarefa a1, Tarefa a2){
                    return a2.getNome().compareTo(a1.getNome());
                }
            };
            Collections.sort(tarefas, comparador);
            return tarefas;
        }else{
            return null;
        }
    }
}
