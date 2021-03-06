package me.wiefferink.evita.classes;

import me.wiefferink.evita.Action;
import me.wiefferink.evita.Class;
import me.wiefferink.evita.Session;

import java.util.SortedSet;

public class PersonalGoalClass extends Class {
	@Override
	public String determine(SortedSet<Session> sessions) {
		for (Session session : sessions) {
			for (Action action : session.actions) {
				if (action.code == 52) { // personal goal
					return "Adherent";
				}
			}
		}
		return "NotAdherent";
	}

	@Override
	public String getWekaHeader() {
		return "{Adherent,NotAdherent}";
	}

	@Override
	public String getName() {
		return "classPersonalGoal";
	}
}
