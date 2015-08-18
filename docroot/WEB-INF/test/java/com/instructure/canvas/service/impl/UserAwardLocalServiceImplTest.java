package com.instructure.canvas.service.impl;

import static org.junit.Assert.assertNotNull;

import com.cisco.utility.service.UtilityLocalServiceUtil;
import com.instructure.canvas.model.UserAward;
import com.instructure.canvas.service.AwardLocalServiceUtil;
import com.instructure.canvas.service.persistence.UserAwardPersistence;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portlet.documentlibrary.store.DLStoreUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.powermock.api.easymock.PowerMock;
import org.powermock.core.classloader.annotations.PowerMockListener;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.core.testlisteners.FieldDefaulter;
import org.powermock.modules.junit4.PowerMockRunner;
/**
*
* @author lambakarnam.satish
*
*/
@RunWith(PowerMockRunner.class)
@PowerMockListener(FieldDefaulter.class)
@PrepareForTest({UtilityLocalServiceUtil.class,UserAwardPersistence.class,DLStoreUtil.class,UserAwardLocalServiceImpl.class,CounterLocalServiceUtil.class,AwardLocalServiceUtil.class})
public class UserAwardLocalServiceImplTest extends CanvasUtilityMock
{
	public static final String TEST_CERTFICATE_VALUE="Cisco-123";
	public static final String FILE_PATH="test/awt/test.properties";
	public static final int TWO=2;
	@InjectMocks
	private UserAwardLocalServiceImpl userAwardLocalServiceImpl=spy(new UserAwardLocalServiceImpl());
	@Mock
	UserAward userAward;
	@Mock
	private UserAwardPersistence userAwardPersistence;
	@Mock
	List<UserAward>  userAwards;
	@Mock
	File file;
	
	/* 
	 * The code Mocks   all classes  and values required for testing {@link UserAwardLocalServiceImpl} for each and every test execution 
	 * @Param none
	 */
	@Before
	public void setUp() throws Exception
	{
		log.info("Started Junit for UserAwardLocalServiceImplTest Setup method");
		mockStatic(UtilityLocalServiceUtil.class);
		mockStatic(CounterLocalServiceUtil.class);
		mockStatic(AwardLocalServiceUtil.class);
		mockStatic(DLStoreUtil.class);
		super.setUp();
		when(userAwardPersistence.findByCanvasUserId(Mockito.anyLong())).thenReturn(getArrayList(TEST_COUNT_ONE));
		when(userAwardPersistence.fetchByCourseId(Mockito.anyLong(),Mockito.anyLong())).thenReturn(userAward);
		when(UtilityLocalServiceUtil.getEntityId(Mockito.anyLong(), Mockito.anyString(),Mockito.anyString(), Mockito.anyString())).thenReturn(TEST_ONE);
		when(userAward.isLetter()).thenReturn(true);
		when(userAward.clone()).thenReturn(userAward);
		file=new File("test.properties");
		if(!file.exists())
		{
			file.createNewFile();
		}
		when(userAward.getCertId()).thenReturn(FILE_PATH);
		FileInputStream fileIs=PowerMock.createMock(FileInputStream.class);
		whenNew(FileInputStream.class).withArguments(Matchers.anyString()).thenReturn(fileIs);
		when(AwardLocalServiceUtil.addFileToDL(Mockito.anyLong(),Mockito.any(FileInputStream.class), Mockito.anyString(), Mockito.anyLong())).thenReturn(TEST_COMMUNITIES_VALUE);
		when(AwardLocalServiceUtil.getExistingFile(Mockito.any(UserAward.class),Mockito.anyLong())).thenReturn(file);
		log.info("Ending Junit for UserAwardLocalServiceImplTest Setup method");
	}
	/**
	  * The method clears Mocked  classes and  properties for each and every request
	 * 
	 */
	  @After
	  public void tearDown() 
	  {
		PortalBeanLocatorUtil.setBeanLocator(null);
		file=new File("test.properties");
		if(!file.exists())
		{
			if(file.delete())
			{
				log.info("File deleted successfully");;
			}
				
		}
	  }
	/* 
	 * The code Mocks  and tests mergeUserAwardsTest method of UserAwardLocalServiceImpl
	 * @Param none
	 */
	@Test
	public void mergeUserAwardsTest() throws PortalException, SystemException
	{
		log.info("Started Junit for UserAwardLocalServiceImpl mergeUserAwardsTest method");
		userAwardLocalServiceImpl.mergeUserAwards(TEST_ONE, TEST_ONE, TEST_ONE);
		when(userAward.isLetter()).thenReturn(false);
		UserAward award=mock(UserAward.class);
		when(userAwardPersistence.fetchByCourseId(0, 1)).thenReturn(award);
		when(award.isLetter()).thenReturn(true);
		userAwards=userAwardLocalServiceImpl.mergeUserAwards(TEST_ONE, TEST_ONE, TEST_ONE);
		Mockito.verify(userAwardLocalServiceImpl,Mockito.times(2)).mergeUserAwards(TEST_ONE, TEST_ONE, TEST_ONE);
		assertNotNull(userAwards);
		log.info("Ended Junit for UserAwardLocalServiceImpl mergeUserAwardsTest method");
	}
	
	
	  /* 
	  * The code Mocks  and tests createEnrollmentSeatFileExceptionTest method of UserAwardLocalServiceImpl for FileNotFoundException exception scenario.
	  */
	@Test
	public void mergeUserAwardsFileExceptionTest() throws Exception
	{
		log.info("Started Junit for UserAwardLocalServiceImpl mergeUserAwardsFileExceptionTest method");
		whenNew(FileInputStream.class).withArguments(Matchers.anyString()).thenThrow(new FileNotFoundException());
		userAwards=userAwardLocalServiceImpl.mergeUserAwards(TEST_ONE, TEST_ONE, TEST_ONE);
		Mockito.verify(userAwardLocalServiceImpl).mergeUserAwards(TEST_ONE, TEST_ONE, TEST_ONE);
		assertNotNull(userAwards);
		log.info("Ended Junit for UserAwardLocalServiceImpl mergeUserAwardsFileExceptionTest method");
	
	}
	 /* 
	 * The code Mocks  and tests mergeUserAwardsSystemExceptionTest method of UserAwardLocalServiceImpl with userAwardPersistence.fetchByCourseId throwing SystemException exception.
	 */
	@Test(expected=SystemException.class)
	public void mergeUserAwardsSystemExceptionTestCase1() throws Exception
	{
		log.info("Started Junit for UserAwardLocalServiceImpl mergeUserAwardsSystemExceptionTest method");
		when(userAwardPersistence.fetchByCourseId(Mockito.anyLong(),Mockito.anyLong())).thenThrow(new SystemException());
		userAwardLocalServiceImpl.mergeUserAwards(TEST_ONE, TEST_ONE, TEST_ONE);
		Mockito.verify(userAwardLocalServiceImpl).mergeUserAwards(TEST_ONE, TEST_ONE, TEST_ONE);
		log.info("Ended Junit for UserAwardLocalServiceImpl mergeUserAwardsSystemExceptionTest method");
	}
	 /* 
	  * The code Mocks  and tests mergeUserAwardsSystemExceptionTest1 method of UserAwardLocalServiceImpl with userAwardPersistence.fetchByCourseId throwing Portal exception
	  * and calling revertUserAwards if more than one record is there in list .
	  */
	@Test(expected=SystemException.class)
	public void mergeUserAwardsSystemExceptionTestCase2() throws Exception
	{	
		log.info("Started Junit for UserAwardLocalServiceImpl mergeUserAwardsSystemExceptionTest method");
		when(userAwardPersistence.findByCanvasUserId(Mockito.anyLong())).thenReturn(getArrayList(TWO));
		when(userAwardPersistence.fetchByCourseId(Mockito.anyLong(),Mockito.anyLong())).thenReturn(userAward).thenThrow(new SystemException());
		userAwardLocalServiceImpl.mergeUserAwards(TEST_ONE, TEST_ONE, TEST_ONE);
		Mockito.verify(userAwardLocalServiceImpl).mergeUserAwards(TEST_ONE, TEST_ONE, TEST_ONE);
		log.info("Ended Junit for UserAwardLocalServiceImpl mergeUserAwardsSystemExceptionTest method");
	}
	
	 /* 
	  * The code Mocks  and tests mergeUserAwardsPoratlExceptionTest method of UserAwardLocalServiceImpl with AwardLocalServiceUtil throwing Portal exception.
	  */
	@Test
	public void mergeUserAwardsPoratlExceptionTest() throws Exception
	{
		log.info("Started Junit for UserAwardLocalServiceImpl mergeUserAwardsPoratlExceptionTest method");
		when(AwardLocalServiceUtil.addFileToDL(Mockito.anyLong(),Mockito.any(FileInputStream.class), Mockito.anyString(), Mockito.anyLong())).thenThrow(new PortalException());
		userAwardLocalServiceImpl.mergeUserAwards(TEST_ONE, TEST_ONE, TEST_ONE);
		Mockito.verify(userAwardLocalServiceImpl).mergeUserAwards(TEST_ONE, TEST_ONE, TEST_ONE);
		log.info("Ended Junit for UserAwardLocalServiceImpl mergeUserAwardsPoratlExceptionTest method");
	}
	 /* 
	 * The code Mocks  and tests mergeUserAwardsAwardLocalServiceUtilSystemExceptionTest method of UserAwardLocalServiceImpl with AwardLocalServiceUtil throwing System exception.
	 */
	@Test(expected=SystemException.class)
	public void mergeUserAwardsAwardLocalServiceUtilSystemExceptionTest() throws Exception
	{
		log.info("Started Junit for UserAwardLocalServiceImpl mergeUserAwardsAwardLocalServiceUtilSystemExceptionTest method");
		when(AwardLocalServiceUtil.addFileToDL(Mockito.anyLong(),Mockito.any(FileInputStream.class), Mockito.anyString(), Mockito.anyLong())).thenThrow(new SystemException());
		userAwardLocalServiceImpl.mergeUserAwards(TEST_ONE,TEST_ONE,TEST_ONE);
		Mockito.verify(userAwardLocalServiceImpl).mergeUserAwards(TEST_ONE, TEST_ONE, TEST_ONE);
		log.info("Ended Junit for UserAwardLocalServiceImpl mergeUserAwardsAwardLocalServiceUtilSystemExceptionTest method");
	}
	 /* 
	  * The code Mocks  and tests revertUserAwardsTest method of UserAwardLocalServiceImpl.
	  */
	@Test
	public void revertUserAwardsTest() throws SystemException, PortalException
	{
		log.info("Started Junit for UserAwardLocalServiceImpl revertUserAwardsTest method");
		userAwardLocalServiceImpl.revertUserAwards(TEST_ONE,TEST_ONE, getArrayList(TEST_COUNT_ONE));
		/*This line passes null value for List*/
		userAwardLocalServiceImpl.revertUserAwards(TEST_ONE,TEST_ONE,null);
		Mockito.verify(userAwardLocalServiceImpl).revertUserAwards(TEST_ONE,TEST_ONE,null);
		log.info("Ended Junit for UserAwardLocalServiceImpl revertUserAwardsTest method");
	}
	 /* 
	 * The code Mocks  and tests getCertificateTest method of UserAwardLocalServiceImpl.
	  */
	@Test
	public void getCertificateTest()  throws SystemException, PortalException
	{
		when(userAwardPersistence.fetchByCUID_CID_L(Mockito.anyLong(), Mockito.anyLong(), Mockito.eq(TEST_FALSE))).thenReturn(userAward);
		UserAward userAward=userAwardLocalServiceImpl.getCertificate(TEST_ONE,TEST_ONE);
		Mockito.verify(userAwardLocalServiceImpl).getCertificate(TEST_ONE,TEST_ONE);
		assertNotNull(userAward);
		
	}
	 /* 
	  * The code Mocks  and tests getLetterTest method of UserAwardLocalServiceImpl.
	  */
	@Test
	public void getLetterTest()  throws SystemException, PortalException
	{
		log.info("Started Junit for UserAwardLocalServiceImpl revertUserAwardsTest method");
		when(userAwardPersistence.fetchByCUID_CID_L(Mockito.anyLong(), Mockito.anyLong(), Mockito.eq(TEST_TRUE))).thenReturn(userAward);
		UserAward userAward=userAwardLocalServiceImpl.getLetter(TEST_ONE, TEST_ONE);
		Mockito.verify(userAwardLocalServiceImpl).getLetter(TEST_ONE, TEST_ONE);
		assertNotNull(userAward);
		log.info("Ended Junit for UserAwardLocalServiceImpl revertUserAwardsTest method");
	}
	 /* 
	  * The code Mocks  and tests getUserAwardTest method of UserAwardLocalServiceImpl.
	  */
	@Test
	public void getUserAwardTest()  throws SystemException, PortalException
	{
		log.info("Started Junit for UserAwardLocalServiceImpl getUserAwardTest method");
		when(userAwardPersistence.fetchByCertID(Mockito.anyString())).thenReturn(userAward);
		UserAward userAward=userAwardLocalServiceImpl.getUserAward(TEST_CERTFICATE_VALUE);
		assertNotNull(userAward);
		log.info("Ended Junit for UserAwardLocalServiceImpl getUserAwardTest method");
	}
	/* 
	 * This method return List of UserAward based on count
	 * @Param count 
	 */
	public List<UserAward> getArrayList(int count)
	{
		List<UserAward> toUserAwardsList = new ArrayList<UserAward>();
		for(int i=0;i<=count;i++)
		{
		toUserAwardsList.add(userAward);
		}
		return toUserAwardsList;
	}
	private static final Log log = LogFactoryUtil.getLog(UserAwardLocalServiceImpl.class);
}
