package javabrains.spring.core.understanding.dependency_injection;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Triangle implements Shape {
	
	/*private Point pointA;
	private Point pointB;
	private Point pointC;*/
	
	private List<Point> points;
	//private Map<Point> pointsMap;
	private Set<Point> pointsSet;
	private Map<Integer,Point> pointsMap;
	
	public Map<Integer, Point> getPointsMap() {
		return pointsMap;
	}

	public void setPointsMap(Map<Integer, Point> pointsMap) {
		this.pointsMap = pointsMap;
	}

	@Override
	public void draw() {
		System.out.println("Triangle drawn");
		/*System.out.println("pointA " + pointA.getX() + " " + pointA.getY());
		System.out.println("pointB " + pointB.getX() + " " + pointB.getY());
		System.out.println("pointC " + pointC.getX() + " " + pointC.getY());*/
		/*for(Point point : points){
			System.out.println(point.getX() + " " + point.getY());
		}*/
		
		/*for(Point point : pointsSet){
			System.out.println(point.getX() + " " + point.getY());
		}*/
		for(Entry<Integer, Point> point : pointsMap.entrySet()){
			System.out.println("Key: " + point.getKey() + " " +  "Values: " + point.getValue().getX() + " " + point.getValue().getY());
		}
	}
	
	public Set<Point> getPointsSet() {
		return pointsSet;
	}

	public void setPointsSet(Set<Point> pointsSet) {
		this.pointsSet = pointsSet;
	}

	public List<Point> getPoints() {
		return points;
	}

	public void setPoints(List<Point> points) {
		this.points = points;
	}
	

	/*public Point getPointA() {
		return pointA;
	}

	public void setPointA(Point pointA) {
		this.pointA = pointA;
	}

	public Point getPointB() {
		return pointB;
	}

	public void setPointB(Point pointB) {
		this.pointB = pointB;
	}

	public Point getPointC() {
		return pointC;
	}

	public void setPointC(Point pointC) {
		this.pointC = pointC;
	}*/
	
	

	/*private String type;
	private int height;
	
	public Triangle(String type){
		this.type = type;
	}

	public Triangle(int height){
		this.height = height;
	}
	
	public Triangle(String type,int height){
		this.type = type;
		this.height = height;
	}
	
	public int getHeight(){
		return height;
	}*/


	/*public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}*/
	

}
