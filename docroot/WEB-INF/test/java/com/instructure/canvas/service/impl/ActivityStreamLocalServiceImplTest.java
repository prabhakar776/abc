package com.instructure.canvas.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import com.cisco.communityactivity.util.CommonMockUtil;
import com.instructure.canvas.model.ActivityStream;
import com.instructure.canvas.util.CanvasURLConnectionFactory;
import com.liferay.portal.json.JSONArrayImpl;
import com.liferay.portal.json.JSONObjectImpl;
import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.Props;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.util.service.ServiceProps;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.powermock.core.classloader.annotations.PowerMockListener;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.core.classloader.annotations.SuppressStaticInitializationFor;
import org.powermock.core.testlisteners.FieldDefaulter;
import org.powermock.modules.junit4.PowerMockRunner;
@RunWith(PowerMockRunner.class)
@PowerMockListener(FieldDefaulter.class)
@PrepareForTest({ Validator.class,CourseLocalServiceImpl.class,GetterUtil.class,ServiceProps.class,PropsUtil.class,JSONFactoryUtil.class})
@SuppressStaticInitializationFor("com.liferay.util.service.ServiceProps")
public class ActivityStreamLocalServiceImplTest extends CommonMockUtil
{
	@InjectMocks
	public ActivityStreamLocalServiceImpl activityStreamLocalServiceImpl=spy(new ActivityStreamLocalServiceImpl());
	public static final String CANVAS_TOKEN="canvas.token";
	public static final String CANVAS_BASE_URL="canvas.base.url";
	public static final String USER_TOKEN="o9TZs2JmorXCRkrepp6E4xpsqSymgtPcgrcFSOstQuP2NCwHyi4dJF19k6pYVKDz";
	public static final String BASE_URL="https://canvas.cisco.instructure.com/api/v1";
	public static final String COURSE_STR_ID_INVALID="22";
	/* 
	 * The code Mocks   all classes  and values required for testing {@link ActivityStreamLocalServiceImpl} for each and every test execution. 
	 * @Param none
	 */
	@Before
	public void setUp() throws Exception
	{
		log.info("Started Junit for ActivityStreamLocalServiceImpl Setup method");
		Props _props=mock(Props.class);
		mockStatic(PropsUtil.class);
		when(PropsUtil.getProps()).thenReturn(_props);
		mockStatic(ServiceProps.class);
		suppress(constructor(ServiceProps.class));
		when(PropsUtil.get(CANVAS_TOKEN)).thenReturn(USER_TOKEN);
		when(PropsUtil.get(CANVAS_BASE_URL)).thenReturn(BASE_URL);
		mockStatic(Validator.class);
		mockStatic(JSONFactoryUtil.class);
		super.setUp();
		when(Validator.isNotNull(Mockito.contains(PropsUtil.get(CANVAS_BASE_URL)))).thenReturn(false);
	
		log.info("Ended Junit for ActivityStreamLocalServiceImpl Setup method");
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
	 * The code Mocks  and tests getActivityStreams method of ActivityStreamLocalServiceImpl.
	 * @Param none
	 */
	@Test
	public void getActivityStreamsTest() throws Exception
	{
	  log.info("Started Junit for ActivityStreamLocalServiceImpl getActivityStreamsTest method");
	  mockStatic(CanvasURLConnectionFactory.class);
	  List<ActivityStream> activity= activityStreamLocalServiceImpl.getActivityStreams(StringPool.BLANK);
      Mockito.verify(activityStreamLocalServiceImpl).getActivityStreams(StringPool.BLANK);
      assertNotNull(activity);
	  when(Validator.isNotNull(Mockito.anyString())).thenReturn(false);
	 activity= activityStreamLocalServiceImpl.getActivityStreams(USER_TOKEN);
      Mockito.verify(activityStreamLocalServiceImpl).getActivityStreams(USER_TOKEN);
      assertNotNull(activity);
      log.info("Ended Junit for ActivityStreamLocalServiceImpl getActivityStreamsTest method");
	}
	/* 
	 * The code Mocks  and tests getActivityStreams method of ActivityStreamLocalServiceImpl for IOException.
	 * @Param none
	 */
	@Test
	public void getActivityStreamsIOExceptionTest() throws Exception
	{
	  log.info("Started Junit for ActivityStreamLocalServiceImpl getActivityStreamsIOExceptionTest method");
	  mockStatic(CanvasURLConnectionFactory.class);
	  when(Validator.isNotNull(Mockito.anyString())).thenReturn(true);
	  List<ActivityStream> activity= activityStreamLocalServiceImpl.getActivityStreams(StringPool.BLANK);
      Mockito.verify(activityStreamLocalServiceImpl).getActivityStreams(StringPool.BLANK);
      assertEquals(activity.size(),0);
      log.info("Ended Junit for ActivityStreamLocalServiceImpl getActivityStreamsIOExceptionTest method");
	}
	private static final Log log = LogFactoryUtil.getLog(ActivityStreamLocalServiceImpl.class);
}
