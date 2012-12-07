package senac.lp2.interfaces;

import java.awt.CardLayout;
import java.awt.Frame;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import senac.lp2.interfaces.actions.JProducaoPanelCloseAction;
import senac.lp2.producao.classes.Produto;
import senac.lp2.producao.dao.ProdutoDAO;

@SuppressWarnings("serial")
public class JProdutoPanel extends JPanel {
	private JTextArea dados;
	
	public JProdutoPanel(JPanel principal, CardLayout cards) {
		dados = new JTextArea(20, 60);
		dados.setEditable(false);
		add(dados);
		add(new JButton(new JProducaoPanelCloseAction(principal, cards)));
	}

	public JProdutoPanel() {
		this(null, null);
	}

	@Override
	public void setVisible(boolean aFlag) {
		super.setVisible(aFlag);
		if (aFlag == false) {
			return;
		}
		try {
			ProdutoDAO produtoDAO = new ProdutoDAO();
			if (produtoDAO.listar().size() <= 0) {
				System.out.println("Produtos não encontrados!");
				JOptionPane.showMessageDialog(getRootPane(),
						"Nenhum produto encontrado.", "Operação cancelada",
						JOptionPane.ERROR_MESSAGE);
			} else {
				String res = "";
				for (Produto p : produtoDAO.listar()) {
					res += p.toString();
					System.out.println(p.toString());
				}
				dados.setText(res);
			}
		} catch (Exception e) {
			// TODO
		}
	}

	private static void createAndShowGUI() {
		JFrame frame = new JFrame(
				"Controle de Produção de Roupas");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel painel = new JProdutoPanel();
		frame.getContentPane().add(painel);
		
		frame.pack();
		
		frame.setVisible(true);
		painel.setVisible(true);
	}

	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});
	}
}
