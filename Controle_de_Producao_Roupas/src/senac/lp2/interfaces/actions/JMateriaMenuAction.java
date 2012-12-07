package senac.lp2.interfaces.actions;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class JMateriaMenuAction extends AbstractAction {
	public static final String CONSULTAR2 = "CONSULTAR2";

	private JPanel principal;
	private CardLayout cards;

	public JMateriaMenuAction(JPanel principal, CardLayout cards) {
		super("Consultar Materia");
		this.principal = principal;
		this.cards = cards;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		cards.show(principal, CONSULTAR2);
	}
}
