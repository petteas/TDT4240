package tdt4240.Exercise2;



import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import android.annotation.SuppressLint;
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


@SuppressLint("NewApi")
public class TitleScreen extends State implements TouchListener, PropertyChangeListener{
	private HeliModell hm;
	private static TitleScreen instance = null;
	private Image heliImage = new Image(R.drawable.heli1_east);
	private Image backgroundImage = new Image(R.drawable.background);
	private Sprite backSprite;
	private Sprite heliSprite;
	private Paint paint;
	
	
	
	private TitleScreen() {
		hm = new HeliModell();
		hm.addPropertyChangeListener(this);
		backSprite = new Sprite(backgroundImage);
		heliSprite = new Sprite(heliImage);
		heliSprite.setPosition(hm.getX(),hm.getY());
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
		hm.setPos(event.getX(), event.getY());
		return true;
	}
	@Override
	public boolean onTouchUp(MotionEvent event) {
		hm.setPos(event.getX(), event.getY());
		return true;
	}
	@Override
	public boolean onTouchMove(MotionEvent event) {
		hm.setPos(event.getX(), event.getY());
		return true;
	}
	
	public void draw(android.graphics.Canvas canvas){
		backSprite.draw(canvas);
	    heliSprite.draw(canvas);
		Paint p = new Paint(Font.WHITE_SANS_BOLD_16);
		p.setColor(Color.BLACK);
	    canvas.drawText((int)hm.getX() + "," + (int)hm.getY() , 40, 40, p);
	    }
	
	public void update(float dt) {
		if(hm.getX() <= 100){
		hm.setPos(100, hm.getY());
		}
		
		if(hm.getX()>=375){
			hm.setPos(375, hm.getY());
		}
		if(hm.getY() >=600){
			hm.setPos(hm.getX(), 600);
		}
		if(hm.getY() < 40){
			hm.setPos(hm.getX(), 40);
		}
		heliSprite.setPosition(hm.getX(), hm.getY());
		heliSprite.update(dt);
		
	}

	@Override
	public void propertyChange(PropertyChangeEvent event) {
		if(hm == null){
			System.out.println("halla");
			return;
		}
		heliSprite.setPosition(hm.getX(), hm.getY());
		System.out.println("heisann");
	}

}
