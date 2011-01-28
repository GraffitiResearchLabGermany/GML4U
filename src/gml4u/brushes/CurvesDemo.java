package gml4u.brushes;

import gml4u.drawing.GmlStrokeDrawer;
import gml4u.model.GmlPoint;
import gml4u.model.GmlStroke;
import processing.core.PGraphics;
import toxi.geom.Vec3D;

public class CurvesDemo extends GmlStrokeDrawer {

	public void draw(PGraphics g, GmlStroke stroke, float scale, float minTime, float maxTime) {
			
		g.pushStyle();
		g.strokeWeight(5);
		g.stroke(200);
		g.noFill();
		g.beginShape();
		for (GmlPoint point : stroke.getPoints()) {
			if (point.time < minTime) continue;
			if (point.time > maxTime) break;
			
			Vec3D v = point.scale(scale);
			curveVertex(g, v);
		}
		g.endShape();
		g.popStyle();
	}
	
	private static void curveVertex(PGraphics g, Vec3D v) {
		g.curveVertex(v.x, v.y, v.z);
	}
}