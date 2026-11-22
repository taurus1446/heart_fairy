
package com.heartfairy.magic;

import android.app.Activity;
import android.os.Bundle;
import android.graphics.*;
import android.view.*;
import java.util.Random;

public class MainActivity extends Activity {
    @Override
    public void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(new GameView());
    }

    class GameView extends View {
        Paint p = new Paint(3);
        Random random = new Random();
        int score = 0;
        int goal = 10;
        float heartX = -1, heartY = -1;
        boolean complete = false;

        GameView() {
            super(MainActivity.this);
        }

        void color(int c) {
            p.setColor(c);
            p.setStyle(Paint.Style.FILL);
        }

        void text(Canvas c, String s, float x,
                  float y, float size, int col) {
            color(col);
            p.setTypeface(Typeface.create(
                "sans-serif", Typeface.BOLD));
            p.setTextSize(size);
            p.setTextAlign(Paint.Align.CENTER);
            c.drawText(s, x, y, p);
        }

        void heart(Canvas c, float x, float y, float r) {
            color(Color.rgb(255, 75, 140));
            Path path = new Path();
            path.moveTo(x, y + r);
            path.cubicTo(x-r*2, y-r/3,
                x-r, y-r*1.5f, x, y-r/2);
            path.cubicTo(x+r, y-r*1.5f,
                x+r*2, y-r/3, x, y+r);
            c.drawPath(path, p);
        }

        @Override
        protected void onDraw(Canvas c) {
            float w = getWidth(), h = getHeight();
            c.drawColor(Color.rgb(255, 235, 248));

            text(c, "하트 요정의 마법나라",
                w/2, h*0.12f, w*0.065f,
                Color.rgb(180, 60, 130));

            text(c, "모은 하트: " + score + " / " + goal,
                w/2, h*0.20f, w*0.05f,
                Color.rgb(120, 65, 145));

            // 요정 날개
            color(Color.rgb(205, 175, 255));
            c.drawOval(w*.27f,h*.37f,
                w*.51f,h*.60f,p);
            c.drawOval(w*.49f,h*.37f,
                w*.73f,h*.60f,p);

            // 요정 얼굴
            color(Color.rgb(255, 220, 195));
            c.drawCircle(w/2,h*.43f,w*.13f,p);

            // 머리카락
            color(Color.rgb(245, 130, 195));
            c.drawArc(w*.37f,h*.32f,
                w*.63f,h*.46f,180,180,true,p);

            // 눈
            color(Color.rgb(80, 50, 90));
            c.drawCircle(w*.46f,h*.43f,w*.009f,p);
            c.drawCircle(w*.54f,h*.43f,w*.009f,p);

            // 드레스
            color(Color.rgb(255, 130, 195));
            Path dress = new Path();
            dress.moveTo(w/2,h*.51f);
            dress.lineTo(w*.37f,h*.68f);
            dress.lineTo(w*.63f,h*.68f);
            dress.close();
            c.drawPath(dress,p);

            if (heartX < 0) {
                heartX = w*.5f;
                heartY = h*.78f;
            }

            if (!complete) {
                heart(c,heartX,heartY,w*.055f);
                text(c,"하트를 터치해서 마법을 모아요!",
                    w/2,h*.90f,w*.041f,
                    Color.rgb(130,65,145));
            } else {
                text(c,"마법 성공! 축하해요!",
                    w/2,h*.80f,w*.055f,
                    Color.rgb(210,60,130));
                text(c,"화면을 누르면 다시 시작!",
                    w/2,h*.89f,w*.04f,
                    Color.rgb(130,65,145));
            }
        }

        @Override
        public boolean onTouchEvent(
                android.view.MotionEvent e) {
            if (e.getAction() == MotionEvent.ACTION_DOWN) {
                if (complete) {
                    score = 0;
                    complete = false;
                } else {
                    float dx = e.getX()-heartX;
                    float dy = e.getY()-heartY;
                    float radius = getWidth()*.10f;
                    if (dx*dx+dy*dy < radius*radius) {
                        score++;
                        if (score >= goal) {
                            complete = true;
                        } else {
                            heartX = getWidth()*
                                (.15f+random.nextFloat()*.70f);
                            heartY = getHeight()*
                                (.72f+random.nextFloat()*.13f);
                        }
                    }
                }
                invalidate();
                return true;
            }
            return true;
        }
    }
}
