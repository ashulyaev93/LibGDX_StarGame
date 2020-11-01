package geekbrains.com.pool;


import geekbrains.com.Base.SpritesPool;
import geekbrains.com.Bullet;

public class BulletPool extends SpritesPool<Bullet> {
    @Override
    protected Bullet newObject() {
        return new Bullet();
    }
}