package universe;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public final class StartButton extends JButton {
	private static final long serialVersionUID = 2329855181937672031L;

	private final Universe universe;
	private final StartListener startListener = new StartListener();

	class StartListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			universe.start();
		}
	}

	StartButton(Universe universe) {
		super("START");
		this.universe = universe;
		addActionListener(startListener);
	}

}
