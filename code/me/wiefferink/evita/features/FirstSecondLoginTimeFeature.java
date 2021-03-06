package me.wiefferink.evita.features;

import me.wiefferink.evita.Feature;
import me.wiefferink.evita.Session;

import java.util.Calendar;
import java.util.SortedSet;

/**
 * Time between first and second login in days
 */
public class FirstSecondLoginTimeFeature extends Feature<String> {
	public String calculate(SortedSet<Session> sessions) {
		Calendar first = null;
		for (Session session : sessions) {
			if (first == null) {
				first = session.actions.last().date;
			} else {
				return ""+((int) ((session.actions.first().date.getTimeInMillis() - first.getTimeInMillis()) / 86400000L));
			}
		}
		return "?";
	}

	public String getWekaHeader() {
		return "loginTimeFirstSecond NUMERIC";
	}
}