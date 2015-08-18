package com.instructure.canvas.service.impl;

import static org.junit.Assert.*;

import com.instructure.canvas.model.Assignment;
import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.Props;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.util.service.ServiceProps;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.map.HashedMap;
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
@PrepareForTest({GetterUtil.class,ServiceProps.class,JSONFactoryUtil.class,PropsUtil.class,Validator.class})
@SuppressStaticInitializationFor("com.liferay.util.service.ServiceProps")
public class AssignmentLocalServiceImplTest extends CanvasUtilityMock
{
	public static final String USER_TOKEN="o9TZs2JmorXCRkrepp6E4xpsqSymgtPcgrcFSOstQuP2NCwHyi4dJF19k6pYVKDz";
	public static final String BASE_URL="https://canvas.cisco.instructure.com/api/v1";
	public static final String CANVAS_TOKEN="canvas.token";
	public static final String CANVAS_BASE_URL="canvas.base.url";
	public static final int COURSE_ID=4630;
	public static final String STR_COURSE_ID="4630";
	public static final int COURSE_ID_INVALID=22;
	public static final String COURSE_STR_ID_INVALID="22";
	@InjectMocks
	AssignmentLocalServiceImpl assignmentLocalServiceImpl=spy(new AssignmentLocalServiceImpl());
	@Mock
	List<Assignment>  assignment;
	/* 
	 * The code Mocks   all classes  and values required for testing {@link AssignmentLocalServiceImpl} for each and every test execution. 
	 * @Param none
	 */
	@Before
	public void setUp() throws Exception
	{
		assignment=new ArrayList<Assignment>();
		log.info("Started Junit for AssignmentLocalServiceImplTest setUp method");
		Props _props=mock(Props.class);
		mockStatic(PropsUtil.class);
		mockStatic(GetterUtil.class);
		mockStatic(ServiceProps.class);
		mockStatic(JSONFactoryUtil.class);
		suppress(constructor(ServiceProps.class));
		when(PropsUtil.getProps()).thenReturn(_props);
		when(PropsUtil.get(CANVAS_TOKEN)).thenReturn(USER_TOKEN);
		when(PropsUtil.get(CANVAS_BASE_URL)).thenReturn(BASE_URL);
		super.setUp();
		log.info("Ended Junit for AssignmentLocalServiceImplTest setUp method");
		
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
	 * The code Mocks  and tests getAssignments method of AssignmentLocalServiceImpl for valid course id.
	 * @Param none
	 */
	@Test
	public void getAssignmentsTest()
	{
		log.info("Started Junit for AssignmentLocalServiceImplTest getAssignmentsTest method");
		assignment=assignmentLocalServiceImpl.getAssignments(COURSE_ID);
		assertNotNull(assignment);
		log.info("Ended Junit for AssignmentLocalServiceImplTest getAssignmentsTest method");
	}
	/* 
	 * The code Mocks  and tests getAssignments method of AssignmentLocalServiceImpl  for Invalid course id.
	 * @Param none
	 */
	@Test()
	public void getAssignmentsIoExceptionTest() throws JSONException
	{
		log.info("Started Junit for AssignmentLocalServiceImplTest getAssignmentsIoExceptionTest method");
		assignment=assignmentLocalServiceImpl.getAssignments(COURSE_ID_INVALID);
		Mockito.verify(assignmentLocalServiceImpl).getAssignments(COURSE_ID_INVALID);
		assertEquals(assignment.size(),0);
		log.info("Ended Junit for AssignmentLocalServiceImplTest getAssignmentsIoExceptionTest method");
	}
	/* 
	 * The code Mocks  and tests getCompletionAssignment method of AssignmentLocalServiceImpl  for valid course id.
	 * @Param none
	 */
	@Test
	public void getCompletionAssignmentTest()
	{
		log.info("Started Junit for AssignmentLocalServiceImplTest getCompletionAssignmentTest method");
		Assignment  assignment=assignmentLocalServiceImpl.getCompletionAssignment(COURSE_ID);
		assertNotNull(assignment);
		Mockito.verify(assignmentLocalServiceImpl).getCompletionAssignment(COURSE_ID);
		log.info("Ended Junit for AssignmentLocalServiceImplTest getCompletionAssignmentTest method");
			
	}
	/* 
	 * The code Mocks  and tests getCompletionAssignment method of AssignmentLocalServiceImpl  for invalid course id.
	 * @Param none
	 */
	@Test
	public void getCompletionAssignmentExceptionTest()
	{
		log.info("Started Junit for AssignmentLocalServiceImplTest getCompletionAssignmentException method");
		assignmentLocalServiceImpl.getCompletionAssignment(COURSE_ID_INVALID);
		Mockito.verify(assignmentLocalServiceImpl).getCompletionAssignment(COURSE_ID_INVALID);
		log.info("Ended Junit for AssignmentLocalServiceImplTest getCompletionAssignmentException method");
	}
	/* 
	 * The code Mocks  and tests getAssignmentsForVoucherEligibility method of AssignmentLocalServiceImpl  for valid course id.
	 * @Param none
	 */
	@Test
	public void getAssignmentsForVoucherEligibilityTest() throws IOException
	{
		 log.info("Started Junit for AssignmentLocalServiceImplTest getAssignmentsForVoucherEligibilityTest method");
		 assignment=assignmentLocalServiceImpl.getAssignmentsForVoucherEligibility(STR_COURSE_ID);
		 assertNotNull(assignment);
		 Mockito.verify(assignmentLocalServiceImpl).getAssignmentsForVoucherEligibility(STR_COURSE_ID);
		 log.info("Ended Junit for AssignmentLocalServiceImplTest getAssignmentsForVoucherEligibilityTest method");
	}
	/* 
	 * The code Mocks  and tests getAssignmentsForVoucherEligibility method of AssignmentLocalServiceImpl  for invalid course id.
	 * @Param none
	 */
	@Test
	public void getAssignmentsForVoucherEligibilityExceptionTest() throws IOException
	{
		 log.info("Started Junit for AssignmentLocalServiceImplTest getAssignmentsForVoucherEligibilityException method");
		 assignment=assignmentLocalServiceImpl.getAssignmentsForVoucherEligibility(COURSE_STR_ID_INVALID);
		 Mockito.verify(assignmentLocalServiceImpl).getAssignmentsForVoucherEligibility(COURSE_STR_ID_INVALID);
		 assertEquals(assignment.size(),0);
		 log.info("Ended Junit for AssignmentLocalServiceImplTest getAssignmentsForVoucherEligibilityException method");
	}
	private static final Log log = LogFactoryUtil.getLog(AssignmentLocalServiceImplTest.class);
	
	@SuppressWarnings({ "unchecked", "unused" })
	private Map<String,Object> jsonResponse=new HashedMap();
}
