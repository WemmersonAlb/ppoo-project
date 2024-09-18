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
                break;
            }
        }
    }

    public void delete(Tarefa tOut){
        for(Tarefa t : tarefas){
            if(t.getIdTarefa() == tOut.getIdTarefa()){
                tarefas.remove(t);
                notifyObservers();
                break;
            }
        }
    }

    public void delete(int idTarefa){
        for(Tarefa t : tarefas){
            if(t.getIdTarefa() == idTarefa){
                tarefas.remove(t);
                System.out.println("Removido");
                notifyObservers();
                break;
            }
        }
    }

    public void alterarEstadoTarefa(Tarefa tOut, EstadoTarefa et){
        for(Tarefa t : tarefas){
            if(t.getIdTarefa() == tOut.getIdTarefa()){
                t.setEstadoTarefa(et);
                notifyObservers();
                break;
            }
        }
    }
}
