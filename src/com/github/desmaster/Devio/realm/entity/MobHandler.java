package com.github.desmaster.Devio.realm.entity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.github.desmaster.Devio.cons.Console;
import com.github.desmaster.Devio.realm.entity.mobs.Mob_GreenGoo;

public class MobHandler {

	private List<Mob> mobs = new ArrayList<Mob>();

	public MobHandler() {
		mobs.add(new Mob_GreenGoo());
		Console.log("Initialized GreenGoo");
	}

	public void tick() {
		Iterator<Mob> iterator = mobs.iterator();
		while (iterator.hasNext()) {
			Mob mob = iterator.next();
			if (mob.isNearPlayer()) {
				mob.tick();
			}
		}
	}

	public void render() {
		Iterator<Mob> iterator = mobs.iterator();
		while (iterator.hasNext()) {
			Mob mob = iterator.next();
			if (mob.isNearPlayer()) {
				mob.render();
			}
		}
	}
}