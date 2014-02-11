package tdt4240.Exercise2;

import android.annotation.SuppressLint;
import java.beans.PropertyChangeSupport;
import java.beans.PropertyChangeListener;

@SuppressLint("NewApi")
public class HeliModell{
	PropertyChangeSupport pcs;
	private float x;
	private float y;
	
	@SuppressLint("NewApi")
	public HeliModell() {
		pcs = new PropertyChangeSupport(this);
		x = 150;
		y = 150;
	}
	
	public void setPos(float x, float y){
		float oldX = x;
		float oldY = y;
		this.x = x;
		this.y = y;
		pcs.firePropertyChange("X-value", oldX, x);
		pcs.firePropertyChange("Y-value", oldY, y);
		System.out.println("hei");
	}
	public void addPropertyChangeListener(PropertyChangeListener pcl){
		pcs.addPropertyChangeListener(pcl);
	}
	public float getX() {
		return x;
	}
	public float getY() {
		return y;
	}
}
