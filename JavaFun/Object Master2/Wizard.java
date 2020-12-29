package com.codingdojo.java.objectmaster2;

public class Wizard extends Human {
	
	public Wizard() {
		this.health = 50;
		this.intelligence = 8;
	}
	public Wizard(String name) {
		this.health = 50;
		this.intelligence = 8;
		this.name = name;
	}

	public void heal(Human human) {
		human.setHealth(human.getHealth()+intelligence);
		System.out.println("(" + human.getName() + " had their health increased by " + this.intelligence + ".)");
	}
	public void fireball(Human human) {
		human.setHealth(human.getHealth()-(intelligence*3));
		System.out.println("(" + human.getName() + " has taken " + intelligence*3 + " points of damage!)");
	}
}