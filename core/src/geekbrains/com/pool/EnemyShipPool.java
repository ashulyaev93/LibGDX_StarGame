package geekbrains.com.pool;

import geekbrains.com.Base.SpritesPool;
import geekbrains.com.math.Rect;
import geekbrains.com.sprite.EnemyShip;

//homework7
public class EnemyShipPool extends SpritesPool<EnemyShip> {

    private BulletPool bulletPool;
    private ExplosionPool explosionPool;
    private Rect worldBounds;

    public EnemyShipPool(BulletPool bulletPool, ExplosionPool explosionPool, Rect worldBounds) {
        this.bulletPool = bulletPool;
        this.explosionPool = explosionPool;
        this.worldBounds = worldBounds;
    }

    @Override
    protected EnemyShip newObject() {
        return new EnemyShip(bulletPool, explosionPool, worldBounds);
    }
}