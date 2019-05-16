

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 * @author Andre Broeto
 *
 */
public class Jogo extends Arvore implements ActionListener
{
	private static final long serialVersionUID = 1L;
	JLabel      texto       = new JLabel("Pense em um prato que gosta ");
    JButton     botao       = new JButton("OK");
    static int sequencia = 1;
    
    /**
     * @param args 
     */
    public static void main(String[] args) {
		inicializarVariaveisJogo();
		new Jogo(true);
	}
   
    /**
     * Carregar Jogo
     * @param carregarPergunta - indicador para carregar primeira pergunta(verdadeiro = carrega)
     */
    public Jogo(Boolean carregarPergunta)
    {
    	if(carregarPergunta){
		    carregarFrameInicial();
		    
		    //Adiciona o JLabel no JFrame
		    this.setLocationRelativeTo(null);
		    this.setVisible(true);
    	}
        
        
    }
    
	/**
	 * Inicializa Primeira Pergunta
	 */
    
   
    
	private void carregarFrameInicial() {
		int w = 285;
	    int h =	130;
		this.setSize(w,h);
		this.setTitle("Jogo Gourmet");
        
		//define tamanho para janela
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //Para de executar ao fechar o programa ^
        this.setLayout(null);
        texto.setBounds(50,20,250,20);
        texto.setVerticalTextPosition(JLabel.BOTTOM);
        texto.setHorizontalTextPosition(JLabel.CENTER);

        //define as coordenadas da JTextField (posição X, posição Y, Largura, Altura)
        this.add(texto);
        
        //Adiciona o JLabel no JFrame
        botao.setBounds(110,50,52,27);
        
        //define as coordenadas do JButton (posição X, posição Y, Largura, Altura)
        botao.addActionListener(this);
        
        //Adiciona evento para este botão
        this.add(botao);
	}
    
	
	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 * Aguarda click botao 'OK' originado JFrame Inicial
	 */
	public void actionPerformed(ActionEvent e)
    {
		String opcoes[] = { "Sim", "Não" };
 		int resp =  JOptionPane.showOptionDialog(this, 
 					"O prato que voce pensou" + getArvore().valor+"", "Confirm", 
 					JOptionPane.YES_NO_OPTION,
 					JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[0]);
 		
 		if ( resp == JOptionPane.CLOSED_OPTION ) {
             System.exit( 0 );
        }
 		
 		if (resp == 0) {
 			perguntar(getArvore().esquerda);
 		} else {
 			perguntar(getArvore().direita);
 		}
    }
    
    
    /** Perguntas para inserir novo objeto prato
     * @param opcoes
     */
    private void inserirPratoNovo(NoArvore opcoes) {
			++sequencia;
			String prato = JOptionPane.showInputDialog(this,  "Qual prato você pensou?",  "Desisto", JOptionPane.QUESTION_MESSAGE);
			
			++sequencia;
			String caracteristica = JOptionPane.showInputDialog(this, prato + " é _________ mas "+ opcoes.getValor() +" não.", "Complete", JOptionPane.QUESTION_MESSAGE);
			
			inserirNoArvore(opcoes, caracteristica, prato);
			new Jogo(false);
	
	}
	
	/** Método tenta identificar resposta e/ou solicita cadastro prato novo  
	 * @param opcoes
	 */
	private void perguntar(NoArvore opcoes) {
		String str[] = { "Sim", "Não" };
	
		int respSim = JOptionPane.showOptionDialog(this, "O prato que você pensou é "
				+ opcoes.valor+"?", "Confirm", JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE, null, str, str[0]);
	
		if (respSim == 0) {
			if (opcoes.getDireita() == null){
				JOptionPane.showMessageDialog(this, "Acertei de novo!", "Jogo Gourmet", JOptionPane.INFORMATION_MESSAGE);
				new Jogo(false);
			}else{
				perguntar(opcoes.getDireita());
			}
	
		} else {
			if (opcoes.getEsquerda() == null){
				inserirPratoNovo(opcoes);
			}else {
				perguntar(opcoes.getEsquerda());
			}
		}
	
	}
	
	/**
	 * Inicializa Arvore
	 */
	private static void inicializarVariaveisJogo() {
		if (getArvore() == null) {
 			setArvore(new NoArvore(" é massa? ", sequencia));
 			getArvore().esquerda = new NoArvore("Lasanha", ++sequencia);
 			getArvore().direita  = new NoArvore("Bolo de Chocolate", ++sequencia);
 			
 		}
	}
}