package senac.lp2.producao.classes;

public class Produto {
	private long codigo;
	private String nome;
	private double valor;
	private long quantidade;
	private long quantidadeMinima;

	public Produto() {

	}

	public Produto(long codigo, String nome, double valor, long quantidade,
			long quantidadeMinima) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.valor = valor;
		this.quantidade = quantidade;
		this.quantidadeMinima = quantidadeMinima;
	}

	public long getCodigo() {
		return codigo;
	}

	public void setCodigo(long codigo) {
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

	public long getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(long quantidade) {
		this.quantidade = quantidade;
	}

	public long getQuantidadeMinima() {
		return quantidadeMinima;
	}

	public void setQuantidadeMinima(long quantidadeMinima) {
		this.quantidadeMinima = quantidadeMinima;
	}
}
