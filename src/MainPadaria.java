import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class MainPadaria extends JFrame {

    private Encomenda encomenda;
    private ArrayList<Alimento> alimentos;
    
    private Alimento paezinho;
    private Alimento doce;
    private Alimento frio;
    
    private JPanel panelMain, panelNorth, panelWest, panelCenter, panelCenterCenter;
    private JLabel labelTitle, labelMessageQtd, labelMessageSabor, labelMessageTipoDoce, labelMessageDia;
    private JToggleButton buttonBread, buttonDoce, buttonCold;
    private JTextField fieldQuantidade;
    private JComboBox comboSabor, comboTipoDoce, comboDiasSemana;
    private JButton buttonAdicionar, buttonFinalizar;
    
    public MainPadaria(){
        apresentarProdutos();
        instanciarArray();
        createView();
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(new Dimension(400, 175));
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setTitle("Padaria");
    }
    
    public void instanciarArray(){
        alimentos = new ArrayList<Alimento>();
    }
       
    public void apresentarProdutos(){
        JOptionPane.showMessageDialog(null, 
            "Pãezinho - Preço: 0.25 cents | Validade: 2 dias \n"
            + "Doce - Preço: 0.50 cents | Validade: 4 dias \n"
            + "Frio - Preço: 1 real | Validade: 8 dias", "Produtos",
            0,new ImageIcon(getClass().getResource("Cup.png")));       
    }
    
    public void createView(){
        panelMain = new JPanel(new BorderLayout());
        this.getContentPane().add(panelMain);
        panelMain.setBorder(new EmptyBorder(5, 5, 5, 5));
        panelMain.setBackground(Color.WHITE);
        
        //North
        panelNorth = new JPanel(new BorderLayout());
        panelMain.add(panelNorth, BorderLayout.NORTH);
        panelNorth.setBackground(Color.BLACK);
        
        labelTitle = new JLabel(" PADOCA");
        labelTitle.setFont(new Font("Arial", Font.BOLD, 20));
        labelTitle.setForeground(Color.WHITE);
        panelNorth.add(labelTitle, BorderLayout.WEST);
        //
        //West
        panelWest = new JPanel(new GridBagLayout());
        panelWest.setBackground(Color.WHITE);
        panelMain.add(panelWest, BorderLayout.WEST);
        
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        c.anchor = GridBagConstraints.LINE_START;
        
        buttonBread = new JToggleButton("Pãezinhos");
        buttonBread.setFont(new Font("Arial", Font.BOLD, 12));
        buttonBread.setBackground(Color.BLACK);
        buttonBread.setForeground(Color.WHITE);
        buttonBread.setIcon(new ImageIcon(getClass().getResource("Bread.png")));
        panelWest.add(buttonBread, c);
        c.gridy++;
        
        buttonDoce = new JToggleButton("Doces");
        buttonDoce.setFont(new Font("Arial", Font.BOLD, 12));
        buttonDoce.setBackground(Color.BLACK);
        buttonDoce.setForeground(Color.WHITE);
        buttonDoce.setIcon(new ImageIcon(getClass().getResource("Chocolate.png")));
        panelWest.add(buttonDoce, c);
        c.gridy++;
        
        buttonCold = new JToggleButton("Frios");
        buttonCold.setFont(new Font("Arial", Font.BOLD, 12));
        buttonCold.setBackground(Color.BLACK);
        buttonCold.setForeground(Color.WHITE);
        buttonCold.setIcon(new ImageIcon(getClass().getResource("Ice cream.png")));
        panelWest.add(buttonCold, c);
        //
        //Center
        panelCenter = new JPanel(new BorderLayout());
        panelMain.add(panelCenter, BorderLayout.CENTER);
        panelCenter.setBackground(Color.WHITE);
            //CenterCenter
            panelCenterCenter = new JPanel();
            panelCenter.add(panelCenterCenter, BorderLayout.CENTER);
            panelCenterCenter.setBackground(Color.WHITE);
            
            labelMessageDia = new JLabel("Dia: ");
            labelMessageDia.setFont(new Font("Arial", Font.BOLD, 12));
            
            Object[] diasSemana = {" Domingo", " Segunda", " Terça", " Quarta", " Quinta", " Sexta", " Sabado"};
            comboDiasSemana = new JComboBox(diasSemana);
            comboDiasSemana.setFont(new Font("Arial", Font.BOLD, 12));
            comboDiasSemana.setPreferredSize(new Dimension(80, 20));
            comboDiasSemana.setBackground(Color.ORANGE);
            
            panelCenterCenter.add(labelMessageDia);
            panelCenterCenter.add(comboDiasSemana);
            labelMessageDia.setVisible(false);
            comboDiasSemana.setEditable(false);
            comboDiasSemana.setVisible(false);
            //CenterTop
            JPanel panelCenterTop = new JPanel(new GridBagLayout());
            panelCenter.add(panelCenterTop, BorderLayout.NORTH);
            panelCenterTop.setBackground(Color.WHITE);
            panelCenterTop.setBorder(new EmptyBorder(5, 5, 5, 5));
            
            labelMessageQtd = new JLabel("Quantidade: ");
            labelMessageQtd.setFont(new Font("Arial", Font.BOLD, 12));
            
            fieldQuantidade = new JTextField(2);
            fieldQuantidade.setFont(new Font("Arial", Font.BOLD, 12));
            
            labelMessageSabor = new JLabel(" Sabor: ");
            labelMessageSabor.setFont(new Font("Arial", Font.BOLD, 12));
            
            Object[] sabores = {" Sabor X", " Sabor Y", " Sabor Z"};
            comboSabor = new JComboBox(sabores);
            comboSabor.setFont(new Font("Arial", Font.BOLD, 12));
            comboSabor.setPreferredSize(new Dimension(75, 20));
            comboSabor.setBackground(Color.ORANGE);
            
            labelMessageTipoDoce = new JLabel(" Tipo: ");
            labelMessageTipoDoce.setFont(new Font("Arial", Font.BOLD, 12));
            
            Object[] tiposDoces = {" Fino", " Festa", " Gourmet", " Ornamental"};
            comboTipoDoce = new JComboBox(tiposDoces);
            comboTipoDoce.setFont(new Font("Arial", Font.BOLD, 12));
            comboTipoDoce.setPreferredSize(new Dimension(75, 20));
            comboTipoDoce.setBackground(Color.ORANGE);                       
            
            GridBagConstraints x = new GridBagConstraints();
            x.gridy=0;
            x.gridx=0;
            
            panelCenterTop.add(labelMessageQtd, x);
            x.gridx=1;
            panelCenterTop.add(fieldQuantidade, x);
            x.gridx=2;
            panelCenterTop.add(labelMessageSabor, x);
            x.gridx=3;
            panelCenterTop.add(comboSabor, x );
            x.gridx=2;
            panelCenterTop.add(labelMessageTipoDoce, x);
            x.gridx=3;
            panelCenterTop.add(comboTipoDoce, x);
            
            labelMessageQtd.setVisible(false);
            fieldQuantidade.setEditable(false);
            fieldQuantidade.setVisible(false);
            labelMessageSabor.setVisible(false);
            comboSabor.setEditable(false);
            comboSabor.setVisible(false);
            labelMessageTipoDoce.setVisible(false);
            comboTipoDoce.setEditable(false);
            comboTipoDoce.setVisible(false);           
            //
            //CenterBotton
            JPanel panelCenterBotton = new JPanel(new BorderLayout());
            panelCenter.add(panelCenterBotton, BorderLayout.SOUTH);
            panelCenterBotton.setBackground(Color.WHITE);
                //CenterBottonEast
                JPanel panelCenterBottonEast = new JPanel();
                panelCenterBotton.add(panelCenterBottonEast, BorderLayout.EAST);
                panelCenterBottonEast.setBackground(Color.WHITE);
                
                buttonAdicionar = new JButton("Adicionar ao carrinho");
                buttonAdicionar.setFont(new Font("Arial", Font.BOLD, 12));
                buttonAdicionar.setBackground(Color.BLACK);
                buttonAdicionar.setForeground(Color.WHITE);
                
                buttonFinalizar = new JButton("Finalizar");
                buttonFinalizar.setFont(new Font("Arial", Font.BOLD, 12));
                buttonFinalizar.setBackground(Color.BLACK);
                buttonFinalizar.setForeground(Color.WHITE);
                
                panelCenterBottonEast.add(buttonAdicionar);
                panelCenterBottonEast.add(buttonFinalizar);
                
                buttonAdicionar.setEnabled(false);
                buttonAdicionar.setVisible(false);                
                buttonFinalizar.setEnabled(false);
                buttonFinalizar.setVisible(false);
            //
        //
        createListeners();
    }
    
    public void createListeners(){
        buttonBread.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                if(buttonBread.isSelected()){
                    buttonDoce.setSelected(false);
                    buttonCold.setSelected(false);
                    
                    labelMessageQtd.setVisible(true);
                    fieldQuantidade.setEditable(true);
                    fieldQuantidade.setVisible(true);
                    labelMessageDia.setVisible(true);
                    comboDiasSemana.setEditable(true);
                    comboDiasSemana.setVisible(true);
                    labelMessageSabor.setVisible(true);
                    comboSabor.setEditable(true);
                    comboSabor.setVisible(true);
                    labelMessageTipoDoce.setVisible(false);
                    comboTipoDoce.setEditable(false);
                    comboTipoDoce.setVisible(false);
                    
                    buttonAdicionar.setEnabled(true);
                    buttonAdicionar.setVisible(true);
                    buttonFinalizar.setEnabled(true);
                    buttonFinalizar.setVisible(true);
                    
                    fieldQuantidade.setText("");
                    comboSabor.setSelectedIndex(0);
                    comboDiasSemana.setSelectedIndex(0);
                }
            }
        });
        
        buttonBread.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!buttonBread.isSelected()){
                    buttonBread.setSelected(true);
                }
            }
        });
        
        buttonDoce.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                if(buttonDoce.isSelected()){
                    buttonBread.setSelected(false);
                    buttonCold.setSelected(false);
                    
                    labelMessageQtd.setVisible(true);
                    fieldQuantidade.setEditable(true);
                    fieldQuantidade.setVisible(true);
                    labelMessageDia.setVisible(true);
                    comboDiasSemana.setEditable(true);
                    comboDiasSemana.setVisible(true);
                    labelMessageTipoDoce.setVisible(true);
                    comboTipoDoce.setEditable(true);
                    comboTipoDoce.setVisible(true);
                    labelMessageSabor.setVisible(false);
                    comboSabor.setEditable(false);
                    comboSabor.setVisible(false);
                    
                    buttonAdicionar.setEnabled(true);
                    buttonAdicionar.setVisible(true);
                    buttonFinalizar.setEnabled(true);
                    buttonFinalizar.setVisible(true);
                    
                    fieldQuantidade.setText("");
                    comboTipoDoce.setSelectedIndex(0);
                    comboDiasSemana.setSelectedIndex(0);
                }
            }
        });
        
        buttonDoce.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!buttonDoce.isSelected()){
                    buttonDoce.setSelected(true);
                }
            }
        });
        
        buttonCold.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                if(buttonCold.isSelected()){
                    buttonBread.setSelected(false);
                    buttonDoce.setSelected(false);
                    
                    labelMessageQtd.setVisible(true);
                    fieldQuantidade.setEditable(true);
                    fieldQuantidade.setVisible(true);
                    labelMessageDia.setVisible(true);
                    comboDiasSemana.setEditable(true);
                    comboDiasSemana.setVisible(true);
                    labelMessageSabor.setVisible(false);
                    comboSabor.setEditable(false);
                    comboSabor.setVisible(false);
                    labelMessageTipoDoce.setVisible(false);
                    comboTipoDoce.setEditable(false);
                    comboTipoDoce.setVisible(false);
                    
                    buttonAdicionar.setEnabled(true);
                    buttonAdicionar.setVisible(true);
                    buttonFinalizar.setEnabled(true);
                    buttonFinalizar.setVisible(true);
                    
                    fieldQuantidade.setText("");
                    comboDiasSemana.setSelectedIndex(0);
                }
            }
        });
        
        buttonCold.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!buttonCold.isSelected()){
                    buttonCold.setSelected(true);
                }
            }
        });
        
        buttonAdicionar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {               
                DiasSemana dia = DiasSemana.INICIALIZACAO;
                switch(comboDiasSemana.getSelectedItem().toString().substring(1)){
                    case "Domingo":
                        dia = DiasSemana.DOMINGO;
                        break;
                    case "Segunda":
                        dia = DiasSemana.SEGUNDA;
                        break;
                    case "Terça":
                        dia = DiasSemana.TERCA;
                        break;
                    case "Quarta":
                        dia = DiasSemana.QUARTA;
                        break;
                    case "Quinta":
                        dia = DiasSemana.QUINTA;
                        break;
                    case "Sexta":
                        dia = DiasSemana.SEXTA;
                        break;
                    case "Sabado":
                        dia = DiasSemana.SABADO;
                        break;
                }
                try{    
                    int i;
                    if(buttonBread.isSelected()){
                        for(i = 0; i < Integer.parseInt(fieldQuantidade.getText()); i++){
                            paezinho = new Paezinho(0.25, 2, "Carboidrato formoso", comboSabor.getSelectedItem().toString().substring(1), dia);
                            alimentos.add(paezinho);
                        }
                        JOptionPane.showMessageDialog(null, fieldQuantidade.getText() + " pãezinhos adicionados ao carrinho", "Operação realizada", 0, new ImageIcon(getClass().getResource("Bread.png")));
                    }else
                    if(buttonDoce.isSelected()){
                        TipoDoce tipo = TipoDoce.INICIALIZACAO;
                        switch(comboTipoDoce.getSelectedItem().toString().substring(1)){
                            case "Fino":
                                tipo = TipoDoce.FINO;
                                break;
                            case "Festa":
                                tipo = TipoDoce.FESTA;
                                break;
                            case "Gourmet":
                                tipo = TipoDoce.GOURMET;
                                break;
                            case "Ornamental":
                                tipo = TipoDoce.ORNAMENTAL;
                                break;
                         }
                        for(i = 0; i < Integer.parseInt(fieldQuantidade.getText()); i++){
                            doce = new Doce(0.50, 4, "Carboidrato açucarado", tipo, dia);
                            alimentos.add(doce);
                        }
                        JOptionPane.showMessageDialog(null, fieldQuantidade.getText() + " doces adicionados ao carrinho", "Operação realizada", 0, new ImageIcon(getClass().getResource("Chocolate.png")));
                    }else
                    if(buttonCold.isSelected()){
                        for(i = 0; i < Integer.parseInt(fieldQuantidade.getText()); i++){
                            frio = new Frio(1, 8, "Alimento refrigerado", dia);
                            alimentos.add(frio);
                        }
                        JOptionPane.showMessageDialog(null, fieldQuantidade.getText() + " frios adicionados ao carrinho", "Operação realizada", 0, new ImageIcon(getClass().getResource("Ice cream.png")));
                    }
                }catch(NumberFormatException ex){
                    JOptionPane.showMessageDialog(null, "Insira uma quantidade valida", "Erro", JOptionPane.ERROR_MESSAGE);
                }
                fieldQuantidade.setText("");
                comboSabor.setSelectedIndex(0);
                comboTipoDoce.setSelectedIndex(0);
                comboDiasSemana.setSelectedIndex(0);
            }
        });
        
        buttonFinalizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(alimentos.isEmpty()){
                    JOptionPane.showMessageDialog(null, "Você não adicionou nada ao carrinho", "Erro", JOptionPane.ERROR_MESSAGE);
                }else{
                    buttonBread.setSelected(false);
                    buttonDoce.setSelected(false);
                    buttonCold.setSelected(false);
                    
                    labelMessageQtd.setVisible(false);
                    fieldQuantidade.setEditable(false);
                    fieldQuantidade.setVisible(false);
                    labelMessageSabor.setVisible(false);
                    comboSabor.setEditable(false);
                    comboSabor.setVisible(false);
                    labelMessageTipoDoce.setVisible(false);
                    comboTipoDoce.setEditable(false);
                    comboTipoDoce.setVisible(false);
                    labelMessageDia.setVisible(false);
                    comboDiasSemana.setEditable(false);
                    comboDiasSemana.setVisible(false);
                    
                    buttonAdicionar.setEnabled(false);
                    buttonAdicionar.setVisible(false);
                    buttonFinalizar.setEnabled(false);
                    buttonFinalizar.setVisible(false);
                    
                    fieldQuantidade.setText("");
                    comboSabor.setSelectedIndex(0);
                    comboTipoDoce.setSelectedIndex(0);
                    comboDiasSemana.setSelectedIndex(0);
                    
                    encomenda = new Encomenda(alimentos);
                    
                    DecimalFormat df = new DecimalFormat("#.0");
                    
                    JOptionPane.showMessageDialog(null,
                        encomenda.getTotalPaezinhos() + " pãezinhos" + "\n" +
                        encomenda.getTotalDoces() + " doces" + "\n" +
                        encomenda.getTotalFrios() + " frios" + "\n" +
                        "Preço total: R$ " + encomenda.getPrecoTotal() + "\n" +
                        "Tempo estimado: " + df.format(encomenda.getTempoTotal()) + " min", "Operação realizada",
                        0, new ImageIcon(getClass().getResource("Cup.png")));
                    alimentos.clear();
                }
            }
        });
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainPadaria().setVisible(true);
            }
        });
    }
    
}