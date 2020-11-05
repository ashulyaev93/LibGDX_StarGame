package geekbrains.com.pool;


import geekbrains.com.Base.SpritesPool;
import geekbrains.com.sprite.Bullet;

public class BulletPool extends SpritesPool<Bullet> {

    protected Bullet newObject() {
        return new Bullet();
    }
}