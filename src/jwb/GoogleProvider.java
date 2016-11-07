package jwb;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class GoogleProvider implements ActionListener {
	private SearchProviders _provider;

	public GoogleProvider(SearchProviders providers) {
		this._provider = providers;
	}

	public void actionPerformed(ActionEvent e) {
		try {
			this._provider.getMyClass().buttonClicked("bing.com");
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		this._provider.outputProvider();
	}
}
