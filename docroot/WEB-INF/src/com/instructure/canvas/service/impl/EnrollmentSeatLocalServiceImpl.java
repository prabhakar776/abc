package com.instructure.canvas.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.instructure.canvas.model.EnrollmentSeat;
import com.instructure.canvas.service.base.EnrollmentSeatLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.util.PwdGenerator;

/**
 * The implementation of the enrollment seat local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.instructure.canvas.service.EnrollmentSeatLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.instructure.canvas.service.base.EnrollmentSeatLocalServiceBaseImpl
 * @see com.instructure.canvas.service.EnrollmentSeatLocalServiceUtil
 */
public class EnrollmentSeatLocalServiceImpl extends EnrollmentSeatLocalServiceBaseImpl {
	
	public List<EnrollmentSeat> createEnrollmentSeats(int nSeats, String rootAccountId, String courseId) throws SystemException {
	
		List<EnrollmentSeat> enrollmentSeats = new ArrayList<EnrollmentSeat>();
		
		for (int i = 0; i < nSeats; i++) {
			long pk = counterLocalService.increment();
			
			EnrollmentSeat enrollmentSeat  = enrollmentSeatPersistence.create(pk);
			
			String token = null;
			
			boolean unique = false;

			StringBundler sb = new StringBundler();
			sb.append(PropsUtil.get("tokens.charset.lowercase"));
			sb.append(PropsUtil.get("tokens.charset.numbers"));
			sb.append(PropsUtil.get("tokens.charset.uppercase"));

			String acceptableChars = sb.toString();
			
			if (Validator.isNull(acceptableChars) && !acceptableChars.equals("nullnullnull")) {
				throw new SystemException("Please provide the tokens.charset data in portal-ext.properties");
			}

			int safeLimit = 200;
			while (!unique) {
				token = PwdGenerator.getPassword(acceptableChars, 6);
				
				if (enrollmentSeatPersistence.fetchByToken(token) == null) {
					unique = true;
				}
				if (safeLimit-- < 0) {
					throw new SystemException("Exceeded safe limit looping on unique token generation with charsequence: "
							+ acceptableChars);
				}
			}
			
			enrollmentSeat.setRootAccountId(rootAccountId);
			enrollmentSeat.setCourseId(courseId);
			enrollmentSeat.setToken(token);
			enrollmentSeat.setUserId(0);
			enrollmentSeat.setCreateDate(new Date());
			
			enrollmentSeats.add(enrollmentSeat);
			
			enrollmentSeatPersistence.update(enrollmentSeat);
		}
		
		return enrollmentSeats;
	}
	
	public EnrollmentSeat getEnrollmentSeat(String token) throws SystemException {
		return enrollmentSeatPersistence.fetchByToken(token);
	}
	
	public boolean isValidToken(String token) {
		boolean valid = false;
		
		EnrollmentSeat enrollmentSeat = null;
		
		try {
			enrollmentSeat = enrollmentSeatPersistence.fetchByToken(token);
			
			if (enrollmentSeat != null && enrollmentSeat.getUserId() == 0) {
				valid = true;
			}
		}
		catch (SystemException e) {
			valid = false;
		}
		
		return valid;
	}
	
	public boolean claimEnrollmentSeat(String token, long userId) throws PortalException, SystemException {
		EnrollmentSeat enrollmentSeat = enrollmentSeatPersistence.fetchByToken(token);
		
		if (enrollmentSeat == null || enrollmentSeat.getUserId() != 0) {
			throw new PortalException("Invalid Seat Token or already claimed");
		}
		
		enrollmentSeat.setUserId(userId);
		enrollmentSeat.setRedeemDate(new Date());
		
		enrollmentSeatPersistence.update(enrollmentSeat);
		
		return true;
	}
}