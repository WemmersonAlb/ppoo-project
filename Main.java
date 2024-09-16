import java.util.ArrayList;
import java.util.List;

import Command.CriarTarefaCommand;
import Command.DeletarTarefaCommand;
import Model.EstadoTarefa;
import Model.Tarefa;
import Repository.TarefasRepository;
import StrategyClass.OrdenadorPorData;
import StrategyClass.OrdenadorPorNome;
import StrategyClass.OrdenadorPorPrioridade;

public class Main{
    public static void main(String[] args) {
        TarefasRepository tarefaRepository = new TarefasRepository();

        Tarefa t = new Tarefa("Carlos", 1694347200000L, EstadoTarefa.ParaFazer, 1);
        Tarefa t1 = new Tarefa("Bruno", 1640995200000L, EstadoTarefa.ParaFazer, 2);
        Tarefa t2 = new Tarefa("Augusto", 1678895400000L, EstadoTarefa.ParaFazer, 4);
        Tarefa t3 = new Tarefa("Davi", 1766625300000L, EstadoTarefa.ParaFazer, 5);

        CriarTarefaCommand ctc = new CriarTarefaCommand();

        ctc.setT(t);
        ctc.execute();

        ctc.setT(t1);
        ctc.execute();

        ctc.setT(t2);
        ctc.execute();

        ctc.setT(t3);
        ctc.execute();



        List<Tarefa> tarefas = tarefaRepository.readAll();

        //OrdenadorPorPrioridade opp = new OrdenadorPorPrioridade();
        OrdenadorPorNome opn = new OrdenadorPorNome();
        //OrdenadorPorData opd = new OrdenadorPorData();


        opn.ordenadorTarefas(tarefas, 1);


        for(Tarefa tar : tarefas){
            System.out.println("\n\n"+tar.getNome()+"   id: "+tar.getIdTarefa());
        }
        DeletarTarefaCommand dtc = new DeletarTarefaCommand();
        dtc.setIdTarefa(1);
        dtc.execute();

        System.out.println("\n\n\n\n");
        for(Tarefa tar : tarefas){
            System.out.println("\n\n"+tar.getNome()+"   id: "+tar.getIdTarefa());
        }

    }
}