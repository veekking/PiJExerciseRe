package week10.hueyimpl;

import week10.huey.Fly;
import week10.huey.Human;

public class HueyImpl implements Fly, Human {
	private Fly f;
	private Human h;

	public HueyImpl(){
		f = new FlyImpl();
		h = new HumanImpl();
	}
	@Override
	public void eat() {
		f.eat();
	}

	@Override
	public void move() {
		h.move();
	}
}