package com.instructure.canvas.util.comparator;

import com.instructure.canvas.model.Course;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.model.User;

/**
 * Created with IntelliJ IDEA.
 * User: bswaim
 * Date: 4/2/12
 * Time: 10:04 AM
 * To change this template use File | Settings | File Templates.
 */
public class CourseNameComparator extends OrderByComparator {

	public static final String ORDER_BY_ASC = "User_.screenName ASC";

	public static final String ORDER_BY_DESC = "User_.screenName DESC";

	public static final String[] ORDER_BY_FIELDS = {"screenName"};

	public CourseNameComparator() {
		this(true);
	}

	public CourseNameComparator(boolean ascending) {
		_ascending = ascending;
	}

	@Override
	public int compare(Object obj1, Object obj2) {
		Course course1 = (Course)obj1;
		Course course2 = (Course)obj2;

		if (_log.isDebugEnabled()) {
			_log.debug("Comparing: " + course1.getName() + " to " +
					course2.getName());
		}

		int value = course1.getName().toLowerCase().compareTo(
			course2.getName().toLowerCase());

		if (_ascending) {
			return value;
		}
		else {
			return -value;
		}
	}

	@Override
	public String getOrderBy() {
		if (_ascending) {
			return ORDER_BY_ASC;
		}
		else {
			return ORDER_BY_DESC;
		}
	}

	@Override
	public String[] getOrderByFields() {
		return ORDER_BY_FIELDS;
	}

	@Override
	public boolean isAscending() {
		return _ascending;
	}

	private boolean _ascending;


	private static Log _log = LogFactoryUtil.getLog(CourseNameComparator.class);
}
