public class Doce extends Alimento {
    private TipoDoce tipo;

    public Doce(double preco, int validadeDias, String especificacao, TipoDoce tipo, DiasSemana dia) {
        super(preco, validadeDias, especificacao, dia);
        this.tipo = tipo;
    }

    public TipoDoce getTipo() {
        return tipo;
    }

    public void setTipo(TipoDoce tipo) {
        this.tipo = tipo;
    } 
}