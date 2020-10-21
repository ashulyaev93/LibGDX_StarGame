package geekbrains.com.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import geekbrains.com.MyStarGame;

//отвечает за размер фона;
public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.height = 400;
		config.width = 600;
		new LwjglApplication(new MyStarGame(), config);
	}
}

