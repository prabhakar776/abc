package com.instructure.canvas.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import com.cisco.communityactivity.util.CommonMockUtil;
import com.instructure.canvas.model.EnrollmentSeat;
import com.instructure.canvas.service.persistence.EnrollmentSeatPersistence;
import com.liferay.counter.service.CounterLocalService;
import com.liferay.counter.service.persistence.CounterFinder;
import com.liferay.counter.service.persistence.CounterPersistence;
import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.util.PwdGenerator;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.powermock.core.classloader.annotations.PowerMockListener;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.core.classloader.annotations.SuppressStaticInitializationFor;
import org.powermock.core.testlisteners.FieldDefaulter;
import org.powermock.modules.junit4.PowerMockRunner;
@RunWith(PowerMockRunner.class)
@PowerMockListener(FieldDefaulter.class)
@PrepareForTest({PwdGenerator.class})
@SuppressStaticInitializationFor({"com.liferay.util.service.ServiceProps","com.liferay.util.PwdGenerator;"})
public class EnrollmentSeatLocalServiceImplTest extends CommonMockUtil 
{
	public static final String USER_TOKEN="USER_TOKEN";
	public static final String PASSWORD="PASSWORD";
	@InjectMocks
	private EnrollmentSeatLocalServiceImpl enrollmentSeatLocalServiceImpl=spy(new EnrollmentSeatLocalServiceImpl());
	@Mock
	protected CounterLocalService counterLocalService1;
	@Mock
	protected EnrollmentSeat enrollmentSeat;
	@Mock
	protected CounterPersistence counterPersistence;
	@Mock
	protected CounterFinder counterFinder;
	@Mock
	protected EnrollmentSeatPersistence enrollmentSeatPersistence;
	/* 
	 * The code Mocks   all classes  and values required for testing {@link EnrollmentSeatLocalServiceImpl} for each and every test execution. 
	 * @Param none
	 */
	@Before
	public void setUp() throws Exception
	{
		log.info("Started Junit for EnrollmentSeatLocalServiceImplTest Setup method");
		super.setUp();
		mockStatic(PwdGenerator.class);
		when(counterLocalService1.increment()).thenReturn(1L);
		when(enrollmentSeatPersistence.create(Mockito.anyLong())).thenReturn(enrollmentSeat);
		when(enrollmentSeatPersistence.fetchByToken(USER_TOKEN)).thenReturn(enrollmentSeat).thenReturn(enrollmentSeat);
		when(PwdGenerator.getPassword(Mockito.anyString(),Mockito.anyInt())).thenReturn("PASSWORD");
		log.info("Ended Junit for EnrollmentSeatLocalServiceImplTest Setup method");
	}
	/* 
	 *  The method clears Mocked  classes and  properties for each and every request.
	 * @Param none
	 */
	@After
	public void tearDown() 
	{
		PortalBeanLocatorUtil.setBeanLocator(null);
	}
	/* 
	 * The code Mocks  and tests createEnrollmentSeat method of EnrollmentSeatLocalServiceImpl.
	 * @Param none
	 */
	@Test
	public void createEnrollmentSeatTest() throws PortalException, SystemException
	{
		log.info("Started Junit for EnrollmentSeatLocalServiceImplTest createEnrollmentSeatTest method");
		List<EnrollmentSeat> enrollmentSeatList=enrollmentSeatLocalServiceImpl.createEnrollmentSeats(1,PASSWORD,PASSWORD);	
		Mockito.verify(enrollmentSeatLocalServiceImpl).createEnrollmentSeats(TEST_COUNT_ONE,PASSWORD,PASSWORD);
		assertNotNull(enrollmentSeatList);
		log.info("Ended Junit for EnrollmentSeatLocalServiceImplTest createEnrollmentSeatTest method");
	}
	/* 
	 * The code Mocks  and tests getEnrollmentSeat method of EnrollmentSeatLocalServiceImpl.
	 * @Param none
	 */
	@Test
	public void getEnrollmentSeatTest() throws PortalException, SystemException
	{
		log.info("Started Junit for EnrollmentSeatLocalServiceImplTest getEnrollmentSeatTest method");
		EnrollmentSeat enrollmentSeat=enrollmentSeatLocalServiceImpl.getEnrollmentSeat(USER_TOKEN);		
		Mockito.verify(enrollmentSeatLocalServiceImpl).getEnrollmentSeat(USER_TOKEN);		
		assertNotNull(enrollmentSeat);
		log.info("Ended Junit for EnrollmentSeatLocalServiceImplTest getEnrollmentSeatTest method");
	}
	/* 
	* The code Mocks  and tests isValidToken method of EnrollmentSeatLocalServiceImpl.
	* @Param none
	*/
	@Test
	public void isValidTokenTest() throws SystemException
	{
		log.info("Started Junit for EnrollmentSeatLocalServiceImplTest isValidTokenTest method");
		boolean status=enrollmentSeatLocalServiceImpl.isValidToken(USER_TOKEN);
		Mockito.verify(enrollmentSeatLocalServiceImpl).isValidToken(USER_TOKEN);
		assertEquals(status,true);
		log.info("Ended Junit for EnrollmentSeatLocalServiceImplTest isValidTokenTest method");
		
	}
	/* 
	 * The code Mocks  and tests isValidToken method of EnrollmentSeatLocalServiceImpl for SystemException.
	 * @Param none
	 */
	@Test
	public void isValidTokenSystemExceptionTest() throws SystemException
	{
		log.info("Started Junit for EnrollmentSeatLocalServiceImplTest isValidTokenSystemExceptionTest method");
		when(enrollmentSeat.getUserId()).thenReturn(1L);
		when(enrollmentSeatPersistence.fetchByToken(Mockito.anyString())).thenThrow(new SystemException());
		boolean status=enrollmentSeatLocalServiceImpl.isValidToken(USER_TOKEN);
		Mockito.verify(enrollmentSeatLocalServiceImpl).isValidToken(USER_TOKEN);
		assertEquals(status,false);
		log.info("Ended Junit for EnrollmentSeatLocalServiceImplTest isValidTokenSystemExceptionTest method");
	}
	/* 
	* The code Mocks  and tests claimEnrollmentSeat method of EnrollmentSeatLocalServiceImpl.
	* @Param none
	*/
	@Test
	public void claimEnrollmentSeatTest() throws SystemException, PortalException
	{
		log.info("Started Junit for EnrollmentSeatLocalServiceImplTest claimEnrollmentSeatTest method");
		when(enrollmentSeatPersistence.fetchByToken(USER_TOKEN)).thenReturn(enrollmentSeat);
		boolean status=enrollmentSeatLocalServiceImpl.claimEnrollmentSeat(USER_TOKEN,TEST_ONE);
		Mockito.verify(enrollmentSeatLocalServiceImpl).claimEnrollmentSeat(USER_TOKEN,TEST_ONE);
		assertEquals(status,true);
		log.info("Ended Junit for EnrollmentSeatLocalServiceImplTest claimEnrollmentSeatTest method");
	}
	/* 
	* The code Mocks  and tests claimEnrollmentSeat method of EnrollmentSeatLocalServiceImpl for PortalException.
	* @Param none
	*/
	@Test(expected=PortalException.class)
	public void claimEnrollmentSeatTest1() throws SystemException, PortalException
	{
		log.info("Started Junit for EnrollmentSeatLocalServiceImplTest claimEnrollmentSeatTest1 method");
		when(enrollmentSeat.getUserId()).thenReturn(1L);
		when(enrollmentSeatPersistence.fetchByToken(USER_TOKEN)).thenReturn(enrollmentSeat);
		boolean status=enrollmentSeatLocalServiceImpl.claimEnrollmentSeat(USER_TOKEN,TEST_ONE);
		Mockito.verify(enrollmentSeatLocalServiceImpl).claimEnrollmentSeat(USER_TOKEN,TEST_ONE);
		assertEquals(status,false);
		log.info("Ended Junit for EnrollmentSeatLocalServiceImplTest claimEnrollmentSeatTest1 method");
	}
	/* 
	* The code Mocks  and tests claimEnrollmentSeat method of EnrollmentSeatLocalServiceImpl for PortalException.
	* @Param none
	*/
	@Test(expected=PortalException.class)
	public void claimEnrollmentSeatPortalExceptionTest() throws SystemException, PortalException
	{
		log.info("Started Junit for EnrollmentSeatLocalServiceImplTest claimEnrollmentSeatPortalExceptionTest method");
		when(enrollmentSeatPersistence.fetchByToken(USER_TOKEN)).thenReturn(null);
		boolean status=enrollmentSeatLocalServiceImpl.claimEnrollmentSeat(USER_TOKEN,TEST_ONE);
		Mockito.verify(enrollmentSeatLocalServiceImpl).claimEnrollmentSeat(USER_TOKEN,TEST_ONE);
		assertEquals(status,false);
		log.info("Ended Junit for EnrollmentSeatLocalServiceImplTest claimEnrollmentSeatPortalExceptionTest method");
	}
	private static final Log log = LogFactoryUtil.getLog(EnrollmentSeatLocalServiceImplTest.class);
}
