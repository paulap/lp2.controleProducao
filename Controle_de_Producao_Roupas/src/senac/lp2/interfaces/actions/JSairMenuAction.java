package senac.lp2.interfaces.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

@SuppressWarnings("serial")
public class JSairMenuAction extends AbstractAction{

	public JSairMenuAction() {
		super("Sair");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.exit(0);
	}

}
