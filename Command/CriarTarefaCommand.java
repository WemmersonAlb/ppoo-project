package Command;

import Model.Tarefa;
import Repository.TarefasRepository;

public class CriarTarefaCommand implements Command {
    TarefasRepository tarefasRepository = new TarefasRepository();
    
    public void execute(Tarefa t){
        tarefasRepository.create(t);
    }
}
