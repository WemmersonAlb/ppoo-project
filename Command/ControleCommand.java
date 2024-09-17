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

     public void excluirTarefaCommand(int idTarefa) {
          excluirTarefaCommand.setIdTarefa(idTarefa);
          excluirTarefaCommand.execute();
     }

     public void alterarEstadoTarefa(EstadoTarefa et, int idTarefa) {
          alterarEstadoTarefaCommand.setEt(et);
          alterarEstadoTarefaCommand.setIdTarefa(idTarefa);
          alterarEstadoTarefaCommand.execute();
     }
}
