package ru.guar7387.surfaceviewsample.gamedata;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;

import ru.guar7387.surfaceviewsample.R;
import ru.guar7387.surfaceviewsample.utils.Logger;

public class MiddleMonster implements Monster {

    private static final String TAG = MiddleMonster.class.getName();

    private final Area area;

    private final int left;
    private final int right;

    private int hitPoints;

    private double difX;

    public MiddleMonster(int x, int y) {
        left = x;
        right = x + ImagesSize.MiddleMonster.BITMAP_WIDTH;

        area = new ObjectArea(x, y, x + ImagesSize.MiddleMonster.BITMAP_WIDTH, y + ImagesSize.MiddleMonster.BITMAP_HEIGHT);

        difX = 0;

        hitPoints = 15;
    }

    @Override
    public int getBitmapId() {
        return R.mipmap.middle_monster;
    }

    @Override
    public int getHitPoints() {
        return hitPoints;
    }

    @Override
    public int getSpeed() {
        return 200;
    }

    @Override
    public Area getObjectArea() {
        return area;
    }

    @Override
    public void shoot(int damage) {
        hitPoints -= damage;
    }

    @Override
    public void move(long time) {
        int left = this.left;
        int top = area.getTop();
        int right = this.right;
        int bottom = area.getBottom();

        difX += (getSpeed() * (1.0 * time / 3600));
        left -= (int) difX;
        right -= (int) difX;
        area.changePosition(left, top, right, bottom);

        Logger.log(TAG, "Middle monster position - " + area);
    }

    @Override
    public void render(Bitmap bitmap, Paint paint, Canvas canvas) {
        canvas.drawBitmap(bitmap, area.getLeft(), area.getTop(), paint);
    }

}
