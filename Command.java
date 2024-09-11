

import java.util.List;

import Model.Tarefa;
import Repository.TarefasRepository;

public class Command {
    private TarefasRepository tr;

    public void criarTarefa(Tarefa t){
        tr.create(t);
    }
    public List<Tarefa> carregarTarefas(){
        return tr.readAll();
    }
    public void mudarEstadoTarefa(Tarefa t){
        tr.update(t);
    }
    public void deletarTarefa(Tarefa t){
        tr.delete(t);
    }
}
