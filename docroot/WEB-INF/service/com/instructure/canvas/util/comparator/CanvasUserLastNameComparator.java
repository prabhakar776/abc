package com.instructure.canvas.util.comparator;

import com.instructure.canvas.model.CanvasUser;
import com.liferay.portal.kernel.util.OrderByComparator;

public class CanvasUserLastNameComparator extends OrderByComparator {

	public CanvasUserLastNameComparator() {
		this(false);
	}

	public CanvasUserLastNameComparator(boolean ascending) {
		_ascending = ascending;
	}

	@Override
	public int compare(Object obj1, Object obj2) {
		CanvasUser user1 = (CanvasUser)obj1;
		CanvasUser user2 = (CanvasUser)obj2;
		
		int value = user1.getLastName().toLowerCase().compareTo(
			user2.getLastName().toLowerCase());

		if (value == 0) {
			value = user1.getFirstName().toLowerCase().compareTo(
				user2.getFirstName().toLowerCase());
		}

		if (_ascending) {
			return value;
		}
		else {
			return -value;
		}
	}

	@Override
	public boolean isAscending() {
		return _ascending;
	}

	private boolean _ascending;

}