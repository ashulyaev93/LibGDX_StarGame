package geekbrains.com.sprite;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import geekbrains.com.Base.Ship;
import geekbrains.com.math.Rect;


public class Bullet extends Sprite {

    private Rect worldBounds;
    private Vector2 v;
    private int damage;
    private Sprite owner;
    private TextureRegion[] regions;
    private EnemyShip pos;

    public Bullet() {
        v = new Vector2();
        TextureRegion[] regions = new TextureRegion[1];
    }

    public void set(
            Ship owner,
            TextureRegion region,
            Vector2 pos,
            Vector2 v,
            Rect worldBounds,
            int damage,
            float height
    ) {

        this.regions[0] = region;
        this.pos.set(pos);
        this.v.set(v);
        this.worldBounds = worldBounds;
        this.damage = damage;

    }

//    public void update(float delta) {
//        this.pos.mulAdd(v, delta);
//        if (isOutside(worldBounds)) {
//            destroy();
//        }
//    }

    public int getDamage() {
        return damage;
    }

    public Sprite getOwner() {
        return owner;
    }
}
