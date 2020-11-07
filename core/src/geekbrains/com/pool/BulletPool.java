package geekbrains.com.pool;


import geekbrains.com.Base.SpritesPool;
import geekbrains.com.sprite.Bullet;

//homework6
public class BulletPool extends SpritesPool<Bullet> {

    protected Bullet newObject() {
        return new Bullet();
    }
}