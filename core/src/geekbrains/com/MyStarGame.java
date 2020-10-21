package geekbrains.com;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.math.Vector3;

import java.awt.Rectangle;

public class MyStarGame extends ApplicationAdapter {
	OrthographicCamera camera;
	SpriteBatch batch;
	Texture img;
	Texture shipImg;
	Rectangle klipartz;
	Vector3 touchPos;

	@Override
	public void create () {
		camera = new OrthographicCamera();
		camera.setToOrtho(false,600, 400);

		batch = new SpriteBatch();

		touchPos = new Vector3();

		img = new Texture("spaceSky.jpg");
		shipImg = new Texture("klipartz.com.png");

		klipartz = new Rectangle();
		klipartz.x = 600 / 2 - 100 / 2;
		klipartz.y = 20;
		klipartz.width = 100;
		klipartz.height = 100;
	}

	//отвечает за размер фона;
	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0.2f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		camera.update();

		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		batch.draw(shipImg, klipartz.x, klipartz.y); //Gdx.graphics.getWidth(), Gdx.graphics.getWidth()
		batch.end();

		if(Gdx.input.isTouched()){
			touchPos.set(Gdx.input.getX(),Gdx.input.getY(),0);
			camera.unproject(touchPos);
			klipartz.x = (int)(touchPos.x-100/2);
		}

		if(klipartz.x < 0) klipartz.x=0;
		if(klipartz.x > 600-100) klipartz.x = 500;
	}

	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
