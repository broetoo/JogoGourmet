

/**
 * @author Andre Broeto
 *
 */
public class NoArvore	 {
	
	NoArvore direita;
	NoArvore esquerda;
	int id;
	String valor;
	
	/**
	 * @param id
	 */
	NoArvore(int id){
		this.id = id;
		this.direita=null;    
        this.esquerda=null;
        this.valor=null;
	}
	
	/**
	 * @param valor
	 * @param id
	 */
	public NoArvore(String valor, int id){
		this.valor = valor;
		this.id = id;
	}

	/**
	 * @return
	 */
	public NoArvore getDireita() {
		return direita;
	}

	/**
	 * @param direita
	 */
	public void setDireita(NoArvore direita) {
		this.direita = direita;
	}

	/**
	 * @return
	 */
	public NoArvore getEsquerda() {
		return esquerda;
	}

	/**
	 * @param nao
	 */
	public void setNao(NoArvore nao) {
		this.esquerda = nao;
	}

	/**
	 * @return
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return
	 */
	public String getValor() {
		return valor;
	}

	/**
	 * @param valor
	 */
	public void setValor(String valor) {
		this.valor = valor;
	}
	
}
