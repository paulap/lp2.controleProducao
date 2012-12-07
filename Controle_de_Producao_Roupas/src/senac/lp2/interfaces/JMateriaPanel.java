package senac.lp2.interfaces;

import java.awt.CardLayout;
import java.awt.Frame;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import senac.lp2.interfaces.actions.JProducaoPanelCloseAction;
import senac.lp2.producao.classes.MateriaPrima;
import senac.lp2.producao.classes.Produto;
import senac.lp2.producao.dao.MateriaPrimaDAO;
import senac.lp2.producao.dao.ProdutoDAO;

@SuppressWarnings("serial")
public class JMateriaPanel extends JPanel {
	private JTextArea dados;

	public JMateriaPanel(JPanel principal, CardLayout cards) {
		dados = new JTextArea(20, 60);
		dados.setEditable(false);
		add(dados);
		add(new JButton(new JProducaoPanelCloseAction(principal, cards)));
	}

	public JMateriaPanel() {
		this(null, null);
	}

	@Override
	public void setVisible(boolean aFlag) {
		super.setVisible(aFlag);
		if (aFlag == false) {
			return;
		}
		try {
			MateriaPrimaDAO materiaDAO = new MateriaPrimaDAO();
			if (materiaDAO.listar().size() <= 0) {
				System.out.println("Materia não encontrada!");
				JOptionPane.showMessageDialog(getRootPane(),
						"Nenhuma materia encontrado.", "Operação cancelada",
						JOptionPane.ERROR_MESSAGE);
			} else {
				String res = "";
				for (MateriaPrima m : materiaDAO.listar()) {
					res += m.toString();
					System.out.println(m.toString());
				}
				dados.setText(res);
			}
		} catch (Exception e) {
			// TODO
		}
	}

	private static void createAndShowGUI() {
		JFrame frame = new JFrame("Controle de Produção de Roupas");
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
