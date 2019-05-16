

import javax.swing.JFrame;

/**
 * @author Andre Broeto
 *
 */
public class Arvore extends JFrame {
 
	private static final long serialVersionUID = 1L;
	private static NoArvore no;

	/**
	 * @return tipos de repostas
	 */
	public static NoArvore getArvore() {
		return no;
	}

	/**
	 * @param opcs - opcoes dir/esq selecionadas
	 */
	public static void setArvore(NoArvore opcs) {
		no = opcs;
	}

	protected void inserirNoArvore(NoArvore no, String valor1, String valor2) {
		String aux = no.valor;
		no.valor = valor1;
		no.direita = new NoArvore(valor2, ++Jogo.sequencia);
		no.esquerda = new NoArvore(aux, ++Jogo.sequencia);

	}

}