package Command;

import Model.EstadoTarefa;
import Model.Tarefa;
import Repository.TarefasRepository;

public class AlterarEstadoTarefaCommand implements Command {
    private TarefasRepository tarefasRepository = new TarefasRepository();
    private Tarefa tarefa;
    private EstadoTarefa et;
  


    public void execute(){
        tarefasRepository.alterarEstadoTarefa(this.tarefa, this.et);
    }

    


    public Tarefa getTarefa() {
        return this.tarefa;
    }

    public void setTarefa(Tarefa tarefa) {
        this.tarefa = tarefa;
    }

    public EstadoTarefa getEt() {
        return et;
    }

    public void setEt(EstadoTarefa et) {
        this.et = et;
    }
}
