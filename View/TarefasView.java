package View;

import Controller.GerenciadorTarefas;
import java.util.List;
import java.util.ArrayList;
import java.awt.*;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JDialog;
import javax.swing.JScrollPane;

import Model.Tarefa;
import StrategyClass.OrdenadorPorData;
import StrategyClass.OrdenadorPorNome;
import StrategyClass.OrdenadorPorPrioridade;

public class TarefasView {
    private GerenciadorTarefas gerenciadorTarefas;
    private List<Tarefa> tarefas = new ArrayList<>();
    private JFrame frame;
    private JPanel painelTarefas;
    JScrollPane painelScroll;

    public TarefasView(GerenciadorTarefas gerenciadorTarefas) {
        this.frame = new JFrame("Gerenciador de Tarefas");
        this.gerenciadorTarefas = gerenciadorTarefas;
        this.painelTarefas = new JPanel();
        this.painelTarefas.setLayout(new BoxLayout(painelTarefas, BoxLayout.Y_AXIS));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        this.painelScroll = new JScrollPane(painelTarefas);
        frame.add(painelScroll, BorderLayout.CENTER);
    }

    public void exibirInterface() {
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        JButton criarTarefaBtn = new JButton("Criar Tarefa");
        panel.add(criarTarefaBtn);

        JComboBox<String> ordenacaoOpcoes = new JComboBox<>(new String[] { "Por Nome (A - Z)", "Por Nome (Z - A)",
                "Por Data (Recente - Antiga)", "Por Data (Antiga - Recente)", "Por Prioridade (Maior - Menor)",
                "Por Prioridade (Menor - Maior)" });
        panel.add(ordenacaoOpcoes);
        frame.add(panel, BorderLayout.NORTH);

        criarTarefaBtn.addActionListener(e -> criarTarefa());
        ordenacaoOpcoes.addActionListener(e -> {
            switch (ordenacaoOpcoes.getSelectedIndex()) {
                case 1:
                    gerenciadorTarefas.setOrdenadorStrategy(new OrdenadorPorNome(), 1);
                    break;
                case 2:
                    gerenciadorTarefas.setOrdenadorStrategy(new OrdenadorPorNome(), 2);
                    break;
                case 3:
                    gerenciadorTarefas.setOrdenadorStrategy(new OrdenadorPorData(), 2);
                    break;
                case 4:
                    gerenciadorTarefas.setOrdenadorStrategy(new OrdenadorPorData(), 1);
                    break;
                case 5:
                    gerenciadorTarefas.setOrdenadorStrategy(new OrdenadorPorPrioridade(), 2);
                    break;
                case 6:
                    gerenciadorTarefas.setOrdenadorStrategy(new OrdenadorPorPrioridade(), 1);
                    break;

                default:
                    break;
            }

        });

        frame.setSize(600, 300);
        frame.setVisible(true);
    }

    public void updateListaTarefas(List<Tarefa> lista) {
        if (lista == null) {
            lista = new ArrayList<>();
        }
        this.tarefas = lista;
        refazerPainelLista();
    }

    public void refazerPainelLista() {

        painelScroll.remove(painelTarefas);
        JPanel novoPainelTarefas = new JPanel();
        novoPainelTarefas.setLayout(new BoxLayout(novoPainelTarefas, BoxLayout.Y_AXIS));
        for (Tarefa t : tarefas) {
            JPanel itensPainelTarefa = new JPanel();
            itensPainelTarefa.setLayout(new FlowLayout(FlowLayout.LEFT));

            JLabel item = new JLabel(t.toString());

            JButton deleteBtn = new JButton("Deletar");
            deleteBtn.addActionListener(e -> gerenciadorTarefas.usarControle("delete", t));

            JButton updateEstadoBtn = new JButton("Alternar Estado");
            updateEstadoBtn.addActionListener(e -> gerenciadorTarefas.usarControle("updateEstado", t));

            itensPainelTarefa.add(item);
            itensPainelTarefa.add(deleteBtn);
            itensPainelTarefa.add(updateEstadoBtn);

            novoPainelTarefas.add(itensPainelTarefa);
        }
        this.painelTarefas = novoPainelTarefas;
        painelTarefas.revalidate();
        painelTarefas.repaint();
        painelScroll.add(painelTarefas);
        painelScroll.revalidate();
        painelScroll.repaint();
        frame.revalidate();
        frame.repaint();
    }

   

    public void criarTarefa() {
        JDialog dialog = new JDialog(frame, "Criar Nova Tarefa", true);
        dialog.setLayout(new GridLayout(0, 2));

        JLabel nomeLabel = new JLabel("Nome da Tarefa:");
        JTextField nomeField = new JTextField();
        dialog.add(nomeLabel);
        dialog.add(nomeField);

        JLabel dataLabel = new JLabel("Data (dd-MM-yyyy):");
        JTextField dataField = new JTextField();
        dialog.add(dataLabel);
        dialog.add(dataField);

        JLabel prioridadeLabel = new JLabel("Prioridade:");
        JComboBox<Integer> prioridadeCombo = new JComboBox<>(new Integer[] { 1, 2, 3, 4, 5 });
        dialog.add(prioridadeLabel);
        dialog.add(prioridadeCombo);

        JButton criarButton = new JButton("Criar");
        criarButton.addActionListener(e -> {
            String nome = nomeField.getText();
            String dataString = dataField.getText();
            int prioridade = (int) prioridadeCombo.getSelectedItem();

            try {
                SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
                Date data = sdf.parse(dataString);

                Tarefa novaTarefa = new Tarefa();
                novaTarefa.setDate(data.getTime());
                novaTarefa.setNome(nome);
                novaTarefa.setPrioridade(prioridade);
                gerenciadorTarefas.usarControle("create", novaTarefa);

                dialog.dispose();
            } catch (ParseException ex) {

            }
        });

        dialog.add(criarButton);

        dialog.setSize(300, 200);
        dialog.setLocationRelativeTo(frame);
        dialog.setVisible(true);
    }
}
