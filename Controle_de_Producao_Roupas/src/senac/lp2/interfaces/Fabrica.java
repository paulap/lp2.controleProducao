package senac.lp2.interfaces;

import java.awt.CardLayout;
import java.awt.Dimension;

import javax.swing.Action;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

import senac.lp2.interfaces.actions.JProducaoMenuAction;
import senac.lp2.interfaces.actions.JSairMenuAction;

public class Fabrica {
	private static JFrame frame = new JFrame("Controle de Produção de Roupas");
	public static final String PRINCIPAL = "PRINCIPAL";
	
	private static void createAndShowGUI() {

//		getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		CardLayout cards = new CardLayout();
		JPanel principal = new JPanel(cards);

		JPanel producao = new JProducaoPanel(principal, cards);
		JPanel vazio = new JPanel();
		JLabel label = new JLabel("Fábrica de Roupas");
		vazio.add(label);

		principal.add(vazio, PRINCIPAL);
		principal.add(producao, JProducaoMenuAction.PRODUZIR);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// frame.setIconImage(new ImageIcon("pindorama.jpg").getImage());

		frame.getContentPane().add(principal);
		// ----------------------------------------------------------------------------
		JMenuBar menubar = new JMenuBar();
		// ----------------------------------------------------------------------------
		JMenu file = new JMenu("Arquivo");
		menubar.add(file);
		
		Action exitAction = new JSairMenuAction();
		file.add(exitAction);
		// ----------------------------------------------------------------------------
		JMenu edit = new JMenu("Editar");
		menubar.add(edit);

		Action producaoAction = new JProducaoMenuAction(principal, cards);
		edit.add(producaoAction);
		
//		JMenuItem consultaProduto = new JMenuItem("Produto");
//		edit.add(consultaProduto);
//		JMenuItem consultaMateria = new JMenuItem("Materia");
//		edit.add(consultaMateria);
//		JMenuItem produzir = new JMenuItem("Nova produção");
//		edit.add(produzir);
		// ----------------------------------------------------------------------------
		JMenu help = new JMenu("Ajuda");
		menubar.add(help);
		// ----------------------------------------------------------------------------

//		Action extratoAction = new JConsultarExtratoMenuAction();
//		terminal.add(extratoAction);
//		Action aboutAction = new JAboutMenuAction(frame);
//		help.add(aboutAction);

		frame.setJMenuBar(menubar);

		frame.setMinimumSize(new Dimension(600, 450));

		frame.pack();
		frame.setVisible(true);
	}

	public static JFrame getFrame() {
		return frame;
	}

	@SuppressWarnings("static-access")
	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public static void setPanel(JPanel panel) {
		getFrame().add(panel);
	}

	public static void display() {
		frame.pack();
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		// Schedule a job for the event-dispatching thread:
		// creating and showing this application's GUI.
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});
	}
}
