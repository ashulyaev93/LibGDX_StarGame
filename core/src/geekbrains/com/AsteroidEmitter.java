package geekbrains.com;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class AsteroidEmitter {
    public Asteroid[] asteroids;

    private static final AsteroidEmitter ourInstance = new AsteroidEmitter();
    public static AsteroidEmitter getInstance() {
        return ourInstance;
    }

    public void addAsteroid(Vector2 vector2, Vector2 vector21, float v, int i) {
    }

    public void render(SpriteBatch batch) {
    }

    public void update(float dt) {
    }
}
