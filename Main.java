import java.util.List;

import Command.ControleCommand;
import Command.CriarTarefaCommand;
import Command.DeletarTarefaCommand;
import Model.EstadoTarefa;
import Model.Tarefa;
import Repository.TarefasRepository;
import StrategyClass.OrdenadorPorNome;
import View.TarefasView;
import Controller.GerenciadorTarefas;

public class Main{
    public static void main2(String[] args) {
        TarefasRepository tarefaRepository = new TarefasRepository();

        Tarefa t = new Tarefa("Carlos", 1694347200000L, EstadoTarefa.ParaFazer, 1);
        Tarefa t1 = new Tarefa("Bruno", 1640995200000L, EstadoTarefa.ParaFazer, 2);
        Tarefa t2 = new Tarefa("Augusto", 1678895400000L, EstadoTarefa.ParaFazer, 4);
        Tarefa t3 = new Tarefa("Davi", 1766625300000L, EstadoTarefa.ParaFazer, 5);

        CriarTarefaCommand ctc = new CriarTarefaCommand();

        ctc.setTarefa(t);
        ctc.execute();

        ctc.setTarefa(t1);
        ctc.execute();

        ctc.setTarefa(t2);
        ctc.execute();

        ctc.setTarefa(t3);
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

    public static void main(String[] args) {
        TarefasRepository repository = new TarefasRepository();
        ControleCommand controleCommand = new ControleCommand();

        TarefasView taskGUI = new TarefasView(null);  // Inicializa sem o gerenciador ainda
        GerenciadorTarefas gerenciadorDeTarefas = new GerenciadorTarefas(repository, controleCommand, taskGUI);

        taskGUI = new TarefasView(gerenciadorDeTarefas);
        taskGUI.exibirInterface();

        
    }
}