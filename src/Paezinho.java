public class Paezinho extends Alimento {
    private String sabor;

    public Paezinho(double preco, int validadeDias, String especificacao, String sabor, DiasSemana dia) {
        super(preco, validadeDias, especificacao, dia);
        this.sabor = sabor;
    }
 
    public String getSabor() {
        return sabor;
    }

    public void setSabor(String sabor) {
        this.sabor = sabor;
    }  
}