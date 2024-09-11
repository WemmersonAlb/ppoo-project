package Model;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Tarefa {
    private static int idPrefix = 1;
    private int idTarefa;
    private String nome;
    private long date;
    private EstadoTarefa estadoTarefa;
    private int prioridade;

    public Tarefa(){
        this.estadoTarefa = EstadoTarefa.ParaFazer;
        this.idTarefa = idPrefix;
        idPrefix += 1;
    }
    public Tarefa(String nome,
                    long date,
                    EstadoTarefa et,
                    int prioridade){

        this.nome = nome;
        this.date = date;
        this.estadoTarefa = et;
        this.prioridade = prioridade;

        this.idTarefa = idPrefix;
        idPrefix += 1;
    }

    public int getIdTarefa(){
        return this.idTarefa;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public long getDate() {
        return date;
    }
    public void setDate(long date) {
        this.date = date;
    }
    public void setEstadoTarefa(EstadoTarefa et){
        this.estadoTarefa = et;
    }
    public EstadoTarefa getEstadoTarefa(){
        return this.estadoTarefa;
    }
    public int getPrioridade() {
        return prioridade;
    }
    public void setPrioridade(int prioridade) {
        this.prioridade = prioridade;
    }

    public String formatDate(){
        Date d = new Date(this.date);
        return new SimpleDateFormat("dd-MM-yyyy").format(d);
    }
}
