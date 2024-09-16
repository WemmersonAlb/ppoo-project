package Command;

import Repository.TarefasRepository;

public class DeletarTarefaCommand implements Command{
    private TarefasRepository tarefasRepository = new TarefasRepository();
    private int idTarefa;

    public int getIdTarefa() {
        return idTarefa;
    }
    public void setIdTarefa(int idTarefa) {
        this.idTarefa = idTarefa;
    }

    public void execute(){
        tarefasRepository.delete(this.idTarefa);
    }
}
