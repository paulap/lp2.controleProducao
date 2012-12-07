package senac.lp2.producao.classes;

public class MateriaPrima {
	private int codigo;
	private String nome;
	private double valor;
	private String unidade;
	private int quantidade;
	private int quantidadeMinima;

	public MateriaPrima() {

	}

	public MateriaPrima(int codigo, String nome, double valor, String unidade,
			int quantidade, int quantidadeMinima) {
		this.codigo = codigo;
		this.nome = nome;
		this.valor = valor;
		this.unidade = unidade;
		this.quantidade = quantidade;
		this.quantidadeMinima = quantidadeMinima;
	}

	public MateriaPrima(String nome, double valor, String unidade,
			int quantidade, int quantidadeMinima) {
		this.nome = nome;
		this.valor = valor;
		this.unidade = unidade;
		this.quantidade = quantidade;
		this.quantidadeMinima = quantidadeMinima;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public String getUnidade() {
		return unidade;
	}

	public void setUnidade(String unidade) {
		this.unidade = unidade;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public int getQuantidadeMinima() {
		return quantidadeMinima;
	}

	public void setQuantidadeMinima(int quantidadeMinima) {
		this.quantidadeMinima = quantidadeMinima;
	}

	@Override
	public String toString() {
		return nome + "\n" +
				"\n\t[codigo=" + codigo + "] " +
				"\n\t[valor=" + valor + "] " +
				"\n\t[unidade=" + unidade + "]" +
				"\n\t[quantidade=" + quantidade + "] " +
				"\n\t[quantidadeMinima=" + quantidadeMinima + "] \n";
	}
}
