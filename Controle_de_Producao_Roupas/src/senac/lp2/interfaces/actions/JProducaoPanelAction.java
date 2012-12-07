package senac.lp2.interfaces.actions;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import senac.lp2.producao.dao.ProdutoDAO;

@SuppressWarnings("serial")
public class JProducaoPanelAction extends AbstractAction {

	private JPanel principal;
	private CardLayout cards;
	
	private JTextField produto;
	private JTextField quantidade;
	
	public JProducaoPanelAction(JPanel principal, CardLayout cards,
			JTextField produto, JTextField quantidade) {
		super("Produzir");
		this.principal = principal;
		this.cards = cards;
		this.produto = produto;
		this.quantidade = quantidade;
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		ProdutoDAO p = new ProdutoDAO();
		try {
			int codP = Integer.parseInt(produto.getText());
			int qnt = Integer.parseInt(quantidade.getText());
			
			int res = p.produzir(codP, qnt);
			if(res == 1){
				System.out.println("ok");
//				JOptionPane.showMessageDialog(principal.getRootPane(),
//						"Nova produção registrada com sucesso.", "Operação efetuada com sucesso",
//						JOptionPane.INFORMATION_MESSAGE);
			}else{
				JOptionPane.showMessageDialog(principal.getRootPane(),
						"Verifique se há materia-prima disponível ou se o produto está cadastrado.", "Operação cancelada",
						JOptionPane.ERROR_MESSAGE);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
	}

}
