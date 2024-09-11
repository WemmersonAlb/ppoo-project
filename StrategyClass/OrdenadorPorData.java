package StrategyClass;


import java.util.List;

import Model.Tarefa;

public class OrdenadorPorData implements OrdenadorStrategy{
    public List<Tarefa> ordenadorTarefas(List<Tarefa> tarefas, int operacao){
        
        if(operacao == 1){
            tarefas.sort((d1, d2) -> Long.compare(d1.getDate(), d2.getDate()));
            return tarefas;
        }else if(operacao == 2){
            tarefas.sort((d1, d2) -> Long.compare(d2.getDate(), d1.getDate()));
            return tarefas;
        }else{
            return null;
        }
    }
}
