package jwb;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BackButtonListener implements ActionListener {
	private MyClass _myClass;

	public BackButtonListener(MyClass myClass) {
		this._myClass = myClass;
	}

	public void actionPerformed(ActionEvent e) {
		this._myClass.goToLastPage();
	}
}
