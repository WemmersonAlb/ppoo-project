package Command;

import Model.Tarefa;
import Repository.TarefasRepository;

public class DeletarTarefaCommand implements Command{
    private TarefasRepository tarefasRepository = new TarefasRepository();
    private Tarefa tarefa;

    public Tarefa getTarefa() {
        return this.tarefa;
    }
    public void setTarefa(Tarefa tarefa) {
        this.tarefa = tarefa;
    }

    public void execute(){
        tarefasRepository.delete(this.tarefa);
    }
}
