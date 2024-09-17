package Repository;

import java.util.ArrayList;
import java.util.List;

import Model.EstadoTarefa;
import Model.Tarefa;
import Observer.Subject;

public class TarefasRepository implements Subject{
    private static List<Tarefa> tarefas = new ArrayList<>();

    public void create(Tarefa t){
        tarefas.add(t);
        notifyObservers();
    }

    public List<Tarefa> readAll(){
        return tarefas;
    }

    public void update(Tarefa tOut){
        for(Tarefa t : tarefas){
            if(t.getIdTarefa() == tOut.getIdTarefa()){
                t.setEstadoTarefa(tOut.getEstadoTarefa());
            }
        }
    }

    public void delete(Tarefa tOut){
        for(Tarefa t : tarefas){
            if(t.getIdTarefa() == tOut.getIdTarefa()){
                tarefas.remove(t);
                notifyObservers();
            }
        }
    }

    public void delete(int idTarefa){
        for(Tarefa t : tarefas){
            if(t.getIdTarefa() == idTarefa)
                tarefas.remove(t);
                notifyObservers();
        }
    }

    public void alterarEstadoTarefa(int idTarefa, EstadoTarefa et){
        for(Tarefa t : tarefas){
            if(t.getIdTarefa() == idTarefa)
                t.setEstadoTarefa(et);
                notifyObservers();
        }
    }
}
