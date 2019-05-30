import java.util.ArrayList;

public class Encomenda {
    ArrayList<Alimento> alimentos;
    private double precoTotal;
    private double tempoTotal;
    private int totalPaezinhos;
    private int totalDoces;
    private int totalFrios;

    public Encomenda(ArrayList<Alimento> alimentos){
        this.alimentos = new ArrayList<Alimento>();
        this.alimentos = alimentos;
        
        setPrecoTotal();
        setTempoTotal();
        
        setTotalPaezinhos();
        setTotalDoces();
        setTotalFrios();
    }
    
    public ArrayList<Alimento> getAlimentos() {
        return alimentos;
    }

    public void setAlimentos(ArrayList<Alimento> alimentos) {
        this.alimentos = alimentos;
    }  
    
    
    public double getPrecoTotal(){
        return this.precoTotal;
    }
    
    public void setPrecoTotal(){
        double precoTotal = 0;
        
        int i;
        for(i = 0; i < alimentos.size(); i++){
            precoTotal += alimentos.get(i).getPreco();
        }
        
        this.precoTotal = precoTotal;
    }
    
    public double getTempoTotal(){
        return this.tempoTotal;
    }
    
    public void setTempoTotal(){
        double tempoTotal = 0;
        
        int i;
        for(i = 0; i < alimentos.size(); i++){
            tempoTotal += alimentos.get(i).getEntregaMinutos();
        }
        
        this.tempoTotal = tempoTotal;
    }
    
    public int getTotalPaezinhos(){
        return this.totalPaezinhos;
    }
    
    public void setTotalPaezinhos(){
        int totalPaezinhos = 0;
        
        int i;
        for(i = 0; i < alimentos.size(); i++){
            if(alimentos.get(i) instanceof Paezinho){
                totalPaezinhos++;
            }
        }
        
        this.totalPaezinhos = totalPaezinhos;
    }
    
    public int getTotalDoces(){
        return this.totalDoces;
    }
    
    public void setTotalDoces(){
        int totalDoces = 0;
        
        int i;
        for(i = 0; i < alimentos.size(); i++){
            if(alimentos.get(i) instanceof Doce){
                totalDoces++;
            }
        }
        
        this.totalDoces = totalDoces;
    }
    
    public int getTotalFrios(){
        return this.totalFrios;
    }
    
    public void setTotalFrios(){
        int totalFrios = 0;
        
        int i;
        for(i = 0; i < alimentos.size(); i++){
            if(alimentos.get(i) instanceof Frio){
                totalFrios++;
            }
        }
        
        this.totalFrios = totalFrios;
    }
}