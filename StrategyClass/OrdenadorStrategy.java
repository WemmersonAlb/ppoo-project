package StrategyClass;
import java.util.List;

import Model.Tarefa;

public interface OrdenadorStrategy {
    public List<Tarefa> ordenadorTarefas(List<Tarefa> tarefas, int operacao); //operacao = 1 (ascendente); = 2 (descendente)
    
}
