package geekbrains.com;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.math.Vector2;

import java.awt.Rectangle;

public class StarGame extends ApplicationAdapter{
	public static boolean isAndroid = false ;
	SpriteBatch batch;
	Background background;
	Hero hero;
	OrthographicCamera camera;
	Texture img;
	Texture shipImg;
	Rectangle klipartz;
	Vector3 touchPos;

	@Override
	public void create () {
		camera = new OrthographicCamera();
		camera.setToOrtho(false,400, 600);

		batch = new SpriteBatch();

		touchPos = new Vector3();

		background = new Background();

		hero = new Hero();

		shipImg = new Texture("ship.png");

		klipartz = new Rectangle();
		klipartz.x = 600 / 2 - 100 / 2;
		klipartz.y = 20;
		klipartz.width = 100;
		klipartz.height = 100;

		for ( int i = 0 ; i < 4 ; i++) {
			AsteroidEmitter.getInstance().addAsteroid( new Vector2(( float )
					Math.random() * 1280 , ( float ) Math.random() * 720 ), new Vector2(( float )
					(Math.random() - 0.5 ) * 200 , ( float ) (Math.random() - 0.5 ) * 200 ), 1.0f , 100 );
		}
	}

	//отвечает за размер фона;
	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0.2f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		camera.update();

		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		batch.draw(shipImg, klipartz.x, klipartz.y);
		batch.end();

		if(Gdx.input.isTouched()){
			touchPos.set(Gdx.input.getX(),Gdx.input.getY(),0);
			camera.unproject(touchPos);
			klipartz.x = (int)(touchPos.x-100/2);
		}

		if(klipartz.x < 0) klipartz.x=0;
		if(klipartz.x > 400-100) klipartz.x = 300;

		try{
			background.render(batch);
		}catch (IllegalStateException e){

		}
		//hero.render(batch);
		AsteroidEmitter.getInstance().render(batch);
		BulletEmitter.getInstance().render(batch);
		//batch.end();
	}

	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}

	public void update ( float dt) {
		background.update(hero, dt);
		hero.update(dt);
		AsteroidEmitter.getInstance().update(dt);
		BulletEmitter.getInstance().update(dt);
		//checkCollision();
	}

	// Метод checkCollision занимается проверкой столкновений. Первый цикл за
	// столкновения игрока с астероидами, второй - пуль с астероидами. Проверка
	// осуществляется за счет сравнения окружностей (построенных вокруг объектов), если
	// две окружности пересекаются, значит столкновение есть.
	public void checkCollision () {
//		for (Asteroid o : AsteroidEmitter.getInstance().asteroids) {
//			if (hero.hitArea.overlaps(o.hitArea)) {
//				Vector2 acc = hero.position.cpy().sub(o.position).nor();
//				hero.velocity.mulAdd(acc, 20 );
//				o.velocity.mulAdd(acc, - 20 );
//			}
//		}
		for (Bullet b : BulletEmitter.getInstance().bullets) {
			if (b.active) {
				for (Asteroid a : AsteroidEmitter.getInstance().asteroids) {
					if (a.hitArea.contains(b.position)) {
						a.takeDamage( 50 );
						b.destroy();
					}
				}
			}
		}
	}
}