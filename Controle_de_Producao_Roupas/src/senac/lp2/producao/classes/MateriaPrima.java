package senac.lp2.producao.classes;

public class MateriaPrima {
	private long codigo;
	private String nome;
	private double valor;
	private String unidade;
	private long quantidade;
	private long quantidadeMinima;

	public MateriaPrima() {

	}

	public MateriaPrima(long codigo, String nome, double valor, String unidade,
			long quantidade, long quantidadeMinima) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.valor = valor;
		this.unidade = unidade;
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

	public String getUnidade() {
		return unidade;
	}

	public void setUnidade(String unidade) {
		this.unidade = unidade;
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
