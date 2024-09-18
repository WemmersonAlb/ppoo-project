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
   
    public static void main(String[] args) {
        TarefasRepository repository = new TarefasRepository();
        ControleCommand controleCommand = new ControleCommand();

        TarefasView taskGUI = new TarefasView();  // Inicializa sem o gerenciador ainda
        GerenciadorTarefas gerenciadorDeTarefas = new GerenciadorTarefas(repository, controleCommand, taskGUI);

        taskGUI.prepararGUI(gerenciadorDeTarefas);
        taskGUI.exibirInterface();

        
    }
}