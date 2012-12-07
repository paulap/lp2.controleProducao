package senac.lp2.interfaces;

import java.awt.CardLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import senac.lp2.interfaces.actions.JProducaoPanelAction;
import senac.lp2.interfaces.actions.JProducaoPanelCloseAction;

@SuppressWarnings("serial")
public class JProducaoPanel extends JPanel {

	public JProducaoPanel(JPanel principal, CardLayout cards) {
		add(new JLabel("Produto: "));
		JTextField produto = new JTextField(5);
		add(produto);
		add(new JLabel("Quantidade: "));
		JTextField quantidade = new JTextField(5);
		add(quantidade);
		add(new JButton(new JProducaoPanelAction(principal, cards, produto,
				quantidade)));
		add(new JButton(new JProducaoPanelCloseAction(principal, cards)));
	}

	public JProducaoPanel() {
		this(null, null);
	}

	private static void createAndShowGUI() {
		JFrame frame = new JFrame("Controle de Produção de Roupas");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel painel = new JProducaoPanel();
		frame.getContentPane().add(painel);

		frame.pack();
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});
	}
}
