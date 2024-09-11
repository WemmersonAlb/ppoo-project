import java.util.ArrayList;
import java.util.List;

import Model.EstadoTarefa;
import Model.Tarefa;
import StrategyClass.OrdenadorPorData;
import StrategyClass.OrdenadorPorNome;
import StrategyClass.OrdenadorPorPrioridade;

public class Main{
    public static void main(String[] args) {
        List<Tarefa> tarefas = new ArrayList<>();

        tarefas.add(new Tarefa("Carlos", 1694347200000L, EstadoTarefa.ParaFazer, 1));
        tarefas.add(new Tarefa("Bruno", 1640995200000L, EstadoTarefa.ParaFazer, 2));
        tarefas.add(new Tarefa("Augusto", 1678895400000L, EstadoTarefa.ParaFazer, 4));
        tarefas.add(new Tarefa("Davi", 1766625300000L, EstadoTarefa.ParaFazer, 5));

        OrdenadorPorNome opn = new OrdenadorPorNome();
        OrdenadorPorData opd = new OrdenadorPorData();
        OrdenadorPorPrioridade opp = new OrdenadorPorPrioridade();
        opp.ordenadorTarefas(tarefas, 2);
        for(Tarefa t : tarefas){
            System.out.println("\n\n"+t.getPrioridade());
        }
    }
}