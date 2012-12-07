package senac.lp2.interfaces;

import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import senac.lp2.producao.classes.Produto;
import senac.lp2.producao.dao.ProdutoDAO;

@SuppressWarnings("serial")
public class JSobrePanel extends JPanel {

	public JSobrePanel(JPanel principal, CardLayout cards) {
		
	}

	public JSobrePanel() {
		this(null, null);
	}
	
	@Override
	public void setVisible(boolean aFlag) {
		super.setVisible(aFlag);
		if (aFlag == false) {
			return;
		}
		
		JOptionPane.showMessageDialog(getRootPane(),
						"Faculdade Senac RS " +
						"\nCurso: Analise e Desenvolvimento de Sistemas" +
						"\nDisciplina: Linguagem de Programação II" +
						"\nAluna: Paula Maiara Prado Silveira", "Info",
						JOptionPane.INFORMATION_MESSAGE);
	}
	

	private static void createAndShowGUI() {
		JFrame frame = new JFrame("Controle de Produção de Roupas");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel painel = new JSobrePanel();
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
