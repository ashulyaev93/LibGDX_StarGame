package geekbrains.com.pool;

//import ru.geekbrains.base.SpritesPool;
//import ru.geekbrains.math.Rect;
//import ru.geekbrains.sprite.EnemyShip;

import geekbrains.com.Base.SpritesPool;
import geekbrains.com.math.Rect;
import geekbrains.com.sprite.EnemyShip;

public class EnemyShipPool extends SpritesPool<EnemyShip> {

    private BulletPool bulletPool;
    private Rect worldBounds;

    public EnemyShipPool(BulletPool bulletPool, Rect worldBounds) {
        this.bulletPool = bulletPool;
        this.worldBounds = worldBounds;
    }

    @Override
    protected EnemyShip newObject() {
        return new EnemyShip(bulletPool, worldBounds);
    }
}