public abstract class Alimento {
    protected double preco;
    protected int validadeDias;
    protected String especificacao;
    protected double entregaMinutos;

    public Alimento(double preco, int validadeDias, String especificacao, DiasSemana dia){
        this.preco = preco;
        this.validadeDias = validadeDias;
        this.especificacao = especificacao;
        setEntregaMinutos(dia);
    }
    
    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getValidadeDias() {
        return validadeDias;
    }

    public void setValidadeDias(int validadeDias) {
        this.validadeDias = validadeDias;
    }

    public String getEspecificacao() {
        return especificacao;
    }

    public void setEspecificacao(String especificacao) {
        this.especificacao = especificacao;
    }

    public double getEntregaMinutos() {
        return entregaMinutos;
    }

    public void setEntregaMinutos(DiasSemana dia){
        //Set tempo padrão
        if(this instanceof Paezinho){
            this.entregaMinutos = 2d;
        }
        if(this instanceof Doce){
            this.entregaMinutos = 5d;
        }
        if(this instanceof Frio){
            this.entregaMinutos = 6d;
        }
        
        //Set tempo variado
        if(this instanceof Doce && (dia.equals(DiasSemana.SABADO) || dia.equals(DiasSemana.DOMINGO))){
            this.entregaMinutos = (5d - ((20d*5d)/100d));
        }
        if(this instanceof Paezinho && (dia.equals(DiasSemana.SABADO) || dia.equals(DiasSemana.DOMINGO))){
            this.entregaMinutos = (2d - ((15d*2d)/100d));
        }
        if(this instanceof Frio && dia.equals(DiasSemana.DOMINGO)){
            this.entregaMinutos = (6d - ((10d*6d)/100d));
        }
    }
}