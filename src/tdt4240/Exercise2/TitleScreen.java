package tdt4240.Exercise2;



import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.view.MotionEvent;
import sheep.game.Sprite;
import sheep.game.State;
import sheep.graphics.Image;
import sheep.graphics.Font;
import sheep.input.TouchListener;
import sheep.input.Touch;


public class TitleScreen extends State implements TouchListener{
	private static TitleScreen instance = null;
	private Image heliImage = new Image(R.drawable.heli1_east);
	private Image backgroundImage = new Image(R.drawable.background);
	private Sprite backSprite;
	private Sprite heliSprite;
	private Paint paint;
	
	
	
	private TitleScreen() {
		backSprite = new Sprite(backgroundImage);
		heliSprite = new Sprite(heliImage);
		heliSprite.setPosition(135, 120);
		heliSprite.setSpeed(0, 0);
		addTouchListener(this);
		paint = new Paint();  
		paint.setColor(Color.BLACK); 
		paint.setTextSize(16); 
		}
	
	public static TitleScreen getInstance() {
		if(instance == null){
			instance = new TitleScreen();
		}
		return instance;
	}
	@Override
	public boolean onTouchDown(MotionEvent event){
		heliSprite.setPosition(event.getX(), event.getY());
		return true;
	}
	@Override
	public boolean onTouchUp(MotionEvent event) {
		heliSprite.setPosition(event.getX(), event.getY());
		return true;
	}
	@Override
	public boolean onTouchMove(MotionEvent event) {
		heliSprite.setPosition(event.getX(), event.getY());
		return true;
	}
	
	
	public void draw(android.graphics.Canvas canvas){
		backSprite.draw(canvas);
	    heliSprite.draw(canvas);
		Paint p = new Paint(Font.WHITE_SANS_BOLD_16);
		p.setColor(Color.BLACK);
	    canvas.drawText((int)heliSprite.getX() + "," + (int)heliSprite.getY() , 40, 40, p);
	    }
	
	public void update(float dt) {
		if(heliSprite.getX() <= 100){
		heliSprite.setPosition(100, heliSprite.getY());
		}
		
		if(heliSprite.getX()>=375){
			heliSprite.setPosition(375, heliSprite.getY());
		}
		if(heliSprite.getY() >=600){
			heliSprite.setPosition(heliSprite.getX(), 600);
		}
		if(heliSprite.getY() < 40){
			heliSprite.setPosition(heliSprite.getX(), 40);
		}
		
		
		heliSprite.update(dt);
		
	}

}
