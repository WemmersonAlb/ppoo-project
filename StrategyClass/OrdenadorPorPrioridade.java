package StrategyClass;

import java.util.List;
import Model.Tarefa;

public class OrdenadorPorPrioridade implements OrdenadorStrategy {
    public List<Tarefa> ordenadorTarefas(List<Tarefa> tarefas, int operacao) {
        if (operacao == 1) {
            
            tarefas.sort((t1, t2) -> Integer.compare(t1.getPrioridade(), t2.getPrioridade()));
            return tarefas;
        } else if (operacao == 2) {
            
            tarefas.sort((t1, t2) -> Integer.compare(t2.getPrioridade(), t1.getPrioridade()));
            return tarefas;
        } else {
            return null;
        }
    }
}
