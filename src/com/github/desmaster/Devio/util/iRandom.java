package com.github.desmaster.Devio.util;

import java.awt.Rectangle;
import java.util.Random;

import com.github.desmaster.Devio.realm.Realm;

public class iRandom {
	public static Random r = new Random();
	
	public static int nextInt(){
		return r.nextInt();
	}
	public static int nextInt(int max){
		return r.nextInt(max);
	}
	public static int nextInt(int min,int max){
		return r.nextInt(max - min) + min;
	}
	
	public static Double nextDouble(){
		return r.nextDouble();
	}
	public static Double nextDouble(Double max){
		return nextDouble() - Double.MAX_VALUE - max;
	}
	public static Double nextDouble(Double min,Double max){
		return nextDouble(max - min) + min;
	}	
	
	public static Position nextPosition(){
		return new Position(nextInt(Realm.WORLD_WIDTH),nextInt(Realm.WORLD_HEIGHT));
	}
	public static Position nextPosition(Position a, Position b){
		return new Position(nextInt(a.getX(),b.getX()),nextInt(a.getY(),b.getY()));
	}
	public static Position nextPosition(Rectangle a){
		return new Position(nextDouble(a.getMinX(),a.getMaxX()),nextDouble(a.getMinY(),a.getMaxY()));
	}
}
