package jwb;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ForwardButtonListener implements ActionListener {
	private MyClass _myClass;

	public ForwardButtonListener(MyClass myClass) {
		this._myClass = myClass;
	}

	public void actionPerformed(ActionEvent e) {
		this._myClass.goToNextPage();
	}
}
