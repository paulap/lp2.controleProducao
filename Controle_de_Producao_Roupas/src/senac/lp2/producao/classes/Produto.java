package senac.lp2.producao.classes;

public class Produto {
	private int codigo;
	private String nome;
	private double valor;
	private int quantidade;
	private int quantidadeMinima;

	public Produto() {

	}

	public Produto(int codigo, String nome, double valor, int quantidade,
			int quantidadeMinima) {
		this.codigo = codigo;
		this.nome = nome;
		this.valor = valor;
		this.quantidade = quantidade;
		this.quantidadeMinima = quantidadeMinima;
	}

	public Produto(String nome, double valor, int quantidade,
			int quantidadeMinima) {
		this.nome = nome;
		this.valor = valor;
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
}
