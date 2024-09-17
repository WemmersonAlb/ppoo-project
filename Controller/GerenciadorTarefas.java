package Controller;

import Observer.Observer;
import Repository.TarefasRepository;
import StrategyClass.OrdenadorPorNome;
import StrategyClass.OrdenadorStrategy;
import View.TarefasView;

import java.util.List;

import Model.EstadoTarefa;
import Model.Tarefa;
import Command.ControleCommand;

public class GerenciadorTarefas implements Observer{
    private TarefasRepository tarefasRepository;
    private OrdenadorStrategy ordenadorStrategy;
    private int ascendenteOUdescendente;
    private ControleCommand controleCommand;
    private TarefasView tarefasView;



    public GerenciadorTarefas(TarefasRepository tr, ControleCommand cc, TarefasView tv){
        this.tarefasRepository = tr;
        this.controleCommand = cc;
        this.tarefasView = tv;
        this.ordenadorStrategy = new OrdenadorPorNome();
        this.ascendenteOUdescendente = 1;
        this.tarefasRepository.addObserver(this);
    }
    public void setOrdenadorStrategy(OrdenadorStrategy os, int ad){
        this.ordenadorStrategy = os;
        this.ascendenteOUdescendente = ad;
        update();
    }
    public void update(){
        List<Tarefa> tarefas = tarefasRepository.readAll();
        
        tarefasView.updateListaTarefas(ordenadorStrategy.ordenadorTarefas(tarefas, this.ascendenteOUdescendente));
    }

    public void usarControle(String comando, Tarefa t){
        switch (comando) {
            case "delete":
                controleCommand.excluirTarefaCommand(t.getIdTarefa());
                break;
            case "updateEstado":
                
                if(t.getEstadoTarefa().equals(EstadoTarefa.ParaFazer))
                    controleCommand.alterarEstadoTarefa(EstadoTarefa.Fazendo, t.getIdTarefa());

                if(t.getEstadoTarefa().equals(EstadoTarefa.Fazendo))
                    controleCommand.alterarEstadoTarefa(EstadoTarefa.Completado, t.getIdTarefa());

                if(t.getEstadoTarefa().equals(EstadoTarefa.Completado))
                    controleCommand.alterarEstadoTarefa(EstadoTarefa.ParaFazer, t.getIdTarefa());

                break;
            case "create":
                controleCommand.criarTarefa(t);
                break;
        
            default:
                break;
        }
    }
}
