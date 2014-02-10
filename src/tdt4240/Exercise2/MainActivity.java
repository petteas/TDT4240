package tdt4240.Exercise2;

import sheep.game.Game;

import android.R;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//Create the game.
		Game game = new Game(this, null);
		//Push the main state.
		game.pushState(TitleScreen.getInstance());
		//View the game.
		setContentView(game);
	}

}
