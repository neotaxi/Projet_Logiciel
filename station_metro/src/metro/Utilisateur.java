package metro;

import java.awt.Point;

public class Utilisateur {
	Point GPS;
	boolean changementOk;
	public Utilisateur(Point gPS) {
		super();
		GPS = gPS;
		this.changementOk = true;
	}
	public Point getGPS() {
		return GPS;
	}
	public void setGPS(Point gPS) {
		GPS = gPS;
	}
	public boolean isChangementOk() {
		return changementOk;
	}
	public void setChangementOk(boolean changementOk) {
		this.changementOk = changementOk;
	}
	
}
