package Command;

import Model.Tarefa;
import Repository.TarefasRepository;

public class CriarTarefaCommand implements Command {
    private TarefasRepository tarefasRepository = new TarefasRepository();
    private Tarefa t;
   



    public void execute(){
        tarefasRepository.create(this.t);
    }



    public Tarefa getT() {
        return t;
    }
    public void setT(Tarefa t) {
        this.t = t;
    }
}
