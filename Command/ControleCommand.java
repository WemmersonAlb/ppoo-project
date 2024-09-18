package Command;

import Model.EstadoTarefa;
import Model.Tarefa;

public class ControleCommand {
     private CriarTarefaCommand criarTarefaCommand = new CriarTarefaCommand();
     private DeletarTarefaCommand excluirTarefaCommand = new DeletarTarefaCommand();
     private AlterarEstadoTarefaCommand alterarEstadoTarefaCommand = new AlterarEstadoTarefaCommand();

     public void criarTarefa(Tarefa t) {
          criarTarefaCommand.setTarefa(t);
          criarTarefaCommand.execute();
     }

     public void excluirTarefaCommand(Tarefa tarefa) {
          excluirTarefaCommand.setTarefa(tarefa);
          excluirTarefaCommand.execute();
     }

     public void alterarEstadoTarefa(EstadoTarefa et, Tarefa tarefa) {
          alterarEstadoTarefaCommand.setEt(et);
          alterarEstadoTarefaCommand.setTarefa(tarefa);
          alterarEstadoTarefaCommand.execute();
     }
}
