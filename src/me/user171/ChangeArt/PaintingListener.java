package me.user171.ChangeArt;

import java.util.Timer;
import java.util.TimerTask;

import org.bukkit.event.entity.EntityListener;
import org.bukkit.event.painting.PaintingPlaceEvent;
import org.bukkit.Art;

public class PaintingListener extends EntityListener{

	ChangeArt ca;
	Timer t;
	
	PaintingListener(ChangeArt ca){
		this.ca = ca;
	}
	
	public void onPaintingPlace(PaintingPlaceEvent e){
		t = new Timer();
		t.scheduleAtFixedRate(new PaintingChangeTask(e), 0, 5000); //repeat every 5 seconds
	}
	
	public void onPaintingBreak(PaintingPlaceEvent e){
		
	}
	
	private class PaintingChangeTask extends TimerTask{
		Art[] artlist = {Art.KEBAB, Art.AZTEC, Art.ALBAN, Art.AZTEC2, Art.BOMB, Art.PLANT, Art.WASTELAND};
		PaintingPlaceEvent e;
		int artindex;
		int artarraylength;
		PaintingChangeTask(PaintingPlaceEvent e){
			this.e = e;
			artindex = 0;
			artarraylength = artlist.length;
		}
		
		public void run(){
			if(artindex == artarraylength){
				artindex = 0;
			}
			e.getPainting().setArt(artlist[artindex]);
			artindex++;
		}
	}
}
