package Command;

import Model.EstadoTarefa;
import Repository.TarefasRepository;

public class AlterarEstadoTarefaCommand implements Command {
    private TarefasRepository tarefasRepository;
    private int idTarefa;
    private EstadoTarefa et;
  


    public void execute(){
        tarefasRepository.alterarEstadoTarefa(this.idTarefa, this.et);
    }

    


    public int getIdTarefa() {
        return idTarefa;
    }

    public void setIdTarefa(int idTarefa) {
        this.idTarefa = idTarefa;
    }

    public EstadoTarefa getEt() {
        return et;
    }

    public void setEt(EstadoTarefa et) {
        this.et = et;
    }
}
