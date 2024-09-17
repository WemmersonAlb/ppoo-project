package Command;

import Model.Tarefa;
import Repository.TarefasRepository;

public class CriarTarefaCommand implements Command {
    private TarefasRepository tarefasRepository = new TarefasRepository();
    private Tarefa tarefa;
   



    public void execute(){
        tarefasRepository.create(this.tarefa);
    }



    public Tarefa getTarefa() {
        return this.tarefa;
    }
    public void setTarefa(Tarefa t) {
        this.tarefa = t;
    }
}
