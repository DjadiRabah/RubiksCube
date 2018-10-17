package graphic2d;

import obs.Observable;
import obs.Observer;
import rotation.RotationObserver;

public class HUD implements Observer
{
	protected int index;
	protected RotationObserver rotationObserver;
	
	public HUD() 
	{
		this.index = 0;
		this.rotationObserver = new RotationObserver();
	}

	@Override
	public void update(Observable observable, Object object) 
	{
		if(observable instanceof ButtonRotation)
		{
			
		}
		else if(observable instanceof ButtonIndex)
		{
			this.index = (int) object;
		}
	}
}
