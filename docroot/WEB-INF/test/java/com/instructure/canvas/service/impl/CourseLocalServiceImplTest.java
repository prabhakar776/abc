package com.instructure.canvas.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import com.cisco.communityactivity.util.CommonMockUtil;
import com.cisco.utility.constants.CiscoConstants;
import com.instructure.canvas.model.Assignment;
import com.instructure.canvas.model.Award;
import com.instructure.canvas.model.Course;
import com.instructure.canvas.model.SubmissionVersion;
import com.instructure.canvas.service.AssignmentLocalService;
import com.instructure.canvas.service.AwardLocalServiceUtil;
import com.instructure.canvas.service.CanvasEnrollmentLocalService;
import com.instructure.canvas.service.SubmissionVersionLocalService;
import com.instructure.canvas.service.base.CourseLocalServiceBaseImpl;
import com.instructure.canvas.service.persistence.CoursePersistence;
import com.instructure.canvas.util.CanvasURLConnectionFactory;
import com.liferay.counter.service.CounterLocalService;
import com.liferay.counter.service.persistence.CounterFinder;
import com.liferay.portal.json.JSONArrayImpl;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.pacl.permission.PortalRuntimePermission;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.Props;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portlet.asset.model.AssetEntry;
import com.liferay.portlet.asset.service.AssetEntryLocalService;
import com.liferay.util.service.ServiceProps;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.map.HashedMap;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.core.classloader.annotations.SuppressStaticInitializationFor;
import org.powermock.modules.junit4.PowerMockRunner;
@RunWith(PowerMockRunner.class)
@PrepareForTest({CourseLocalServiceImpl.class,GetterUtil.class,ServiceProps.class,JSONFactoryUtil.class,CounterLocalService.class,CoursePersistence.class,PropsUtil.class,PortalRuntimePermission.class,
	Validator.class,CounterFinder.class,GroupLocalServiceUtil.class,AwardLocalServiceUtil.class
})
@SuppressStaticInitializationFor("com.liferay.util.service.ServiceProps")

public class CourseLocalServiceImplTest extends CommonMockUtil {
	@InjectMocks
protected	CounterLocalService counterLocalService = mock(CounterLocalService.class);
	@InjectMocks
	private CourseLocalServiceImpl courseLocalServiceImpl = new CourseLocalServiceImpl();
	@Mock
	CourseLocalServiceBaseImpl impl=mock(CourseLocalServiceBaseImpl.class);
	@Mock
	CoursePersistence coursePersistence=mock(CoursePersistence.class);;
	@Mock 
	Course course;
	@Mock
	AssetEntry assetEntry =mock(AssetEntry.class);
	@Mock
	AssetEntryLocalService assetEntryLocalService=mock(AssetEntryLocalService.class);
	@Mock
	CanvasEnrollmentLocalService canvasEnrollmentLocalService;
	@Mock
	SubmissionVersion submissionVersion=mock(SubmissionVersion.class);
	@Mock
	SubmissionVersionLocalService submissionVersionLocalService;
	@Mock
	AssignmentLocalService assignmentLocalService;
	@Mock
	Assignment assignment;
	@Mock
	Award award;
	@Mock
	List<SubmissionVersion> submissionVersionList;
	public static final String USER_TOKEN="o9TZs2JmorXCRkrepp6E4xpsqSymgtPcgrcFSOstQuP2NCwHyi4dJF19k6pYVKDz";
	public static final String GET_JSON_OBJECTS="getJSONObjects";
	public static final String GET="get";
	public static final String STATES_ARRAY="New York";
	public static final String GET_COURSES_JSON="[{\"hide_final_grades\":false,\"default_view\":\"feed\",\"account_id\":1222,\"enrollment_term_id\":1199,\"integration_id\":null,\"start_at\":\"2014-02-01T11:01:00Z\",\"public_syllabus\":false,\"storage_quota_mb\":500,\"html_url\":\"https://15282891.canvas-dev.cisco.instructure.com/courses/208\",\"id\":208,\"enrollments\":[{\"enrollment_state\":\"active\",\"role_id\":6,\"role\":\"TeacherEnrollment\",\"type\":\"teacher\"}],\"course_code\":\"121\",\"workflow_state\":\"unpublished\",\"end_at\":\"2014-03-30T10:59:00Z\",\"apply_assignment_group_weights\":false,\"name\":\"GA3Tesr\",\"sis_course_id\":null,\"calendar\":{\"ics\":\"https://canvas-dev.cisco.instructure.com/feeds/calendars/course_BRuv3tQimRecBnZJiKuP6ZmerBxiixBZ8CuHUUeG.ics\"}},{\"hide_final_grades\":false,\"default_view\":\"feed\",\"account_id\":1222,\"enrollment_term_id\":1199,\"integration_id\":null,\"start_at\":\"2013-10-10T11:01:00Z\",\"public_syllabus\":false,\"storage_quota_mb\":500,\"html_url\":\"https://15282891.canvas-dev.cisco.instructure.com/courses/191\",\"id\":191,\"enrollments\":[{\"enrollment_state\":\"active\",\"role_id\":6,\"role\":\"TeacherEnrollment\",\"type\":\"teacher\"}],\"course_code\":\"spr33-D2-Class\",\"workflow_state\":\"available\",\"end_at\":\"2014-01-01T10:59:00Z\",\"apply_assignment_group_weights\":false,\"name\":\"spr33-D2-Class\",\"sis_course_id\":null,\"calendar\":{\"ics\":\"https://canvas-dev.cisco.instructure.com/feeds/calendars/course_lPJK6C14VShit96Bj6TXlknZPC9TEqtIfkPGtFHH.ics\"}},{\"hide_final_grades\":false,\"default_view\":\"wiki\",\"account_id\":1222,\"enrollment_term_id\":1199,\"integration_id\":null,\"start_at\":\"2014-07-11T11:01:00Z\",\"public_syllabus\":false,\"storage_quota_mb\":500,\"html_url\":\"https://15282891.canvas-dev.cisco.instructure.com/courses/230\",\"id\":230,\"enrollments\":[{\"enrollment_state\":\"active\",\"role_id\":6,\"role\":\"TeacherEnrollment\",\"type\":\"teacher\"}],\"course_code\":\"R&S Intro\",\"workflow_state\":\"available\",\"end_at\":\"2015-01-25T10:59:00Z\",\"apply_assignment_group_weights\":true,\"name\":\"R&S Intro\",\"sis_course_id\":null,\"calendar\":{\"ics\":\"https://canvas-dev.cisco.instructure.com/feeds/calendars/course_9AQ7iS3M8WTDhUefjxKdOR7kVhcgJCS5kwTDUXJT.ics\"}},{\"hide_final_grades\":false,\"default_view\":\"wiki\",\"account_id\":1222,\"enrollment_term_id\":1199,\"integration_id\":null,\"start_at\":\"2014-11-21T11:01:00Z\",\"public_syllabus\":false,\"storage_quota_mb\":500,\"html_url\":\"https://15282891.canvas-dev.cisco.instructure.com/courses/493\",\"id\":493,\"enrollments\":[{\"enrollment_state\":\"active\",\"role_id\":6,\"role\":\"TeacherEnrollment\",\"type\":\"teacher\"}],\"course_code\":\"ddd\",\"workflow_state\":\"unpublished\",\"end_at\":\"2015-06-28T10:59:00Z\",\"apply_assignment_group_weights\":true,\"name\":\"ddd\",\"sis_course_id\":null,\"calendar\":{\"ics\":\"https://canvas-dev.cisco.instructure.com/feeds/calendars/course_ZLYC7enosZU8KPUGyZhwV52U2trcYRjsTd273FKD.ics\"}},{\"hide_final_grades\":false,\"default_view\":\"feed\",\"account_id\":1222,\"enrollment_term_id\":1199,\"integration_id\":null,\"start_at\":\"2013-12-13T11:01:00Z\",\"public_syllabus\":false,\"storage_quota_mb\":500,\"html_url\":\"https://15282891.canvas-dev.cisco.instructure.com/courses/201\",\"id\":201,\"enrollments\":[{\"enrollment_state\":\"active\",\"role_id\":6,\"role\":\"TeacherEnrollment\",\"type\":\"teacher\"}],\"course_code\":\"232\",\"workflow_state\":\"unpublished\",\"end_at\":\"2014-03-01T10:59:00Z\",\"apply_assignment_group_weights\":false,\"name\":\"TestD2\",\"sis_course_id\":null,\"calendar\":{\"ics\":\"https://canvas-dev.cisco.instructure.com/feeds/calendars/course_zdZTwl5tVthD8NkULnH9pxeMrmdSoljtx5V2PSCz.ics\"}},{\"hide_final_grades\":false,\"default_view\":\"wiki\",\"account_id\":1222,\"enrollment_term_id\":1199,\"integration_id\":null,\"start_at\":\"2014-09-02T11:01:00Z\",\"public_syllabus\":false,\"storage_quota_mb\":500,\"html_url\":\"https://15282891.canvas-dev.cisco.instructure.com/courses/190\",\"id\":190,\"enrollments\":[{\"enrollment_state\":\"active\",\"role_id\":6,\"role\":\"TeacherEnrollment\",\"type\":\"teacher\"}],\"course_code\":\"67678\",\"workflow_state\":\"available\",\"end_at\":\"2014-11-01T10:59:00Z\",\"apply_assignment_group_weights\":true,\"name\":\"sp33-D1-Class\",\"sis_course_id\":null,\"calendar\":{\"ics\":\"https://canvas-dev.cisco.instructure.com/feeds/calendars/course_eZk4LvaEgJxytkispN9vy3k7Z1hIiotKYTUjv2pO.ics\"}},{\"hide_final_grades\":false,\"default_view\":\"wiki\",\"account_id\":1222,\"enrollment_term_id\":1199,\"integration_id\":null,\"start_at\":\"2013-10-02T11:01:00Z\",\"public_syllabus\":false,\"storage_quota_mb\":500,\"html_url\":\"https://15282891.canvas-dev.cisco.instructure.com/courses/189\",\"id\":189,\"enrollments\":[{\"enrollment_state\":\"active\",\"role_id\":6,\"role\":\"TeacherEnrollment\",\"type\":\"teacher\"}],\"course_code\":\"677687\",\"workflow_state\":\"available\",\"end_at\":\"2014-03-01T10:59:00Z\",\"apply_assignment_group_weights\":true,\"name\":\"sp33-D2-Class\",\"sis_course_id\":null,\"calendar\":{\"ics\":\"https://canvas-dev.cisco.instructure.com/feeds/calendars/course_BZ2IWsZ30kuOhhyzcknK3ZFtPkC20laQ6DZ6KbHq.ics\"}},{\"hide_final_grades\":false,\"default_view\":\"feed\",\"account_id\":1222,\"enrollment_term_id\":1199,\"integration_id\":null,\"start_at\":\"2014-07-01T11:01:00Z\",\"public_syllabus\":false,\"storage_quota_mb\":500,\"html_url\":\"https://15282891.canvas-dev.cisco.instructure.com/courses/192\",\"id\":192,\"enrollments\":[{\"enrollment_state\":\"active\",\"role_id\":6,\"role\":\"TeacherEnrollment\",\"type\":\"teacher\"}],\"course_code\":\"spr33-D2-Class\",\"workflow_state\":\"available\",\"end_at\":\"2014-11-01T10:59:00Z\",\"apply_assignment_group_weights\":false,\"name\":\"spr33-D2-Class\",\"sis_course_id\":null,\"calendar\":{\"ics\":\"https://canvas-dev.cisco.instructure.com/feeds/calendars/course_q9uLcmaoLxTlIanhGbeMuUCCVggGxU6zcBmjmYtk.ics\"}}][{\"hide_final_grades\":false,\"default_view\":\"feed\",\"account_id\":1222,\"enrollment_term_id\":1199,\"integration_id\":null,\"start_at\":\"2014-02-01T11:01:00Z\",\"public_syllabus\":false,\"storage_quota_mb\":500,\"html_url\":\"https://15282891.canvas-dev.cisco.instructure.com/courses/208\",\"id\":208,\"enrollments\":[{\"enrollment_state\":\"active\",\"role_id\":6,\"role\":\"TeacherEnrollment\",\"type\":\"teacher\"}],\"course_code\":\"121\",\"workflow_state\":\"unpublished\",\"end_at\":\"2014-03-30T10:59:00Z\",\"apply_assignment_group_weights\":false,\"name\":\"GA3Tesr\",\"sis_course_id\":null,\"calendar\":{\"ics\":\"https://canvas-dev.cisco.instructure.com/feeds/calendars/course_BRuv3tQimRecBnZJiKuP6ZmerBxiixBZ8CuHUUeG.ics\"}},{\"hide_final_grades\":false,\"default_view\":\"feed\",\"account_id\":1222,\"enrollment_term_id\":1199,\"integration_id\":null,\"start_at\":\"2013-10-10T11:01:00Z\",\"public_syllabus\":false,\"storage_quota_mb\":500,\"html_url\":\"https://15282891.canvas-dev.cisco.instructure.com/courses/191\",\"id\":191,\"enrollments\":[{\"enrollment_state\":\"active\",\"role_id\":6,\"role\":\"TeacherEnrollment\",\"type\":\"teacher\"}],\"course_code\":\"spr33-D2-Class\",\"workflow_state\":\"available\",\"end_at\":\"2014-01-01T10:59:00Z\",\"apply_assignment_group_weights\":false,\"name\":\"spr33-D2-Class\",\"sis_course_id\":null,\"calendar\":{\"ics\":\"https://canvas-dev.cisco.instructure.com/feeds/calendars/course_lPJK6C14VShit96Bj6TXlknZPC9TEqtIfkPGtFHH.ics\"}},{\"hide_final_grades\":false,\"default_view\":\"wiki\",\"account_id\":1222,\"enrollment_term_id\":1199,\"integration_id\":null,\"start_at\":\"2014-07-11T11:01:00Z\",\"public_syllabus\":false,\"storage_quota_mb\":500,\"html_url\":\"https://15282891.canvas-dev.cisco.instructure.com/courses/230\",\"id\":230,\"enrollments\":[{\"enrollment_state\":\"active\",\"role_id\":6,\"role\":\"TeacherEnrollment\",\"type\":\"teacher\"}],\"course_code\":\"R&S Intro\",\"workflow_state\":\"available\",\"end_at\":\"2015-01-25T10:59:00Z\",\"apply_assignment_group_weights\":true,\"name\":\"R&S Intro\",\"sis_course_id\":null,\"calendar\":{\"ics\":\"https://canvas-dev.cisco.instructure.com/feeds/calendars/course_9AQ7iS3M8WTDhUefjxKdOR7kVhcgJCS5kwTDUXJT.ics\"}},{\"hide_final_grades\":false,\"default_view\":\"wiki\",\"account_id\":1222,\"enrollment_term_id\":1199,\"integration_id\":null,\"start_at\":\"2014-11-21T11:01:00Z\",\"public_syllabus\":false,\"storage_quota_mb\":500,\"html_url\":\"https://15282891.canvas-dev.cisco.instructure.com/courses/493\",\"id\":493,\"enrollments\":[{\"enrollment_state\":\"active\",\"role_id\":6,\"role\":\"TeacherEnrollment\",\"type\":\"teacher\"}],\"course_code\":\"ddd\",\"workflow_state\":\"unpublished\",\"end_at\":\"2015-06-28T10:59:00Z\",\"apply_assignment_group_weights\":true,\"name\":\"ddd\",\"sis_course_id\":null,\"calendar\":{\"ics\":\"https://canvas-dev.cisco.instructure.com/feeds/calendars/course_ZLYC7enosZU8KPUGyZhwV52U2trcYRjsTd273FKD.ics\"}},{\"hide_final_grades\":false,\"default_view\":\"feed\",\"account_id\":1222,\"enrollment_term_id\":1199,\"integration_id\":null,\"start_at\":\"2013-12-13T11:01:00Z\",\"public_syllabus\":false,\"storage_quota_mb\":500,\"html_url\":\"https://15282891.canvas-dev.cisco.instructure.com/courses/201\",\"id\":201,\"enrollments\":[{\"enrollment_state\":\"active\",\"role_id\":6,\"role\":\"TeacherEnrollment\",\"type\":\"teacher\"}],\"course_code\":\"232\",\"workflow_state\":\"unpublished\",\"end_at\":\"2014-03-01T10:59:00Z\",\"apply_assignment_group_weights\":false,\"name\":\"TestD2\",\"sis_course_id\":null,\"calendar\":{\"ics\":\"https://canvas-dev.cisco.instructure.com/feeds/calendars/course_zdZTwl5tVthD8NkULnH9pxeMrmdSoljtx5V2PSCz.ics\"}},{\"hide_final_grades\":false,\"default_view\":\"wiki\",\"account_id\":1222,\"enrollment_term_id\":1199,\"integration_id\":null,\"start_at\":\"2014-09-02T11:01:00Z\",\"public_syllabus\":false,\"storage_quota_mb\":500,\"html_url\":\"https://15282891.canvas-dev.cisco.instructure.com/courses/190\",\"id\":190,\"enrollments\":[{\"enrollment_state\":\"active\",\"role_id\":6,\"role\":\"TeacherEnrollment\",\"type\":\"teacher\"}],\"course_code\":\"67678\",\"workflow_state\":\"available\",\"end_at\":\"2014-11-01T10:59:00Z\",\"apply_assignment_group_weights\":true,\"name\":\"sp33-D1-Class\",\"sis_course_id\":null,\"calendar\":{\"ics\":\"https://canvas-dev.cisco.instructure.com/feeds/calendars/course_eZk4LvaEgJxytkispN9vy3k7Z1hIiotKYTUjv2pO.ics\"}},{\"hide_final_grades\":false,\"default_view\":\"wiki\",\"account_id\":1222,\"enrollment_term_id\":1199,\"integration_id\":null,\"start_at\":\"2013-10-02T11:01:00Z\",\"public_syllabus\":false,\"storage_quota_mb\":500,\"html_url\":\"https://15282891.canvas-dev.cisco.instructure.com/courses/189\",\"id\":189,\"enrollments\":[{\"enrollment_state\":\"active\",\"role_id\":6,\"role\":\"TeacherEnrollment\",\"type\":\"teacher\"}],\"course_code\":\"677687\",\"workflow_state\":\"available\",\"end_at\":\"2014-03-01T10:59:00Z\",\"apply_assignment_group_weights\":true,\"name\":\"sp33-D2-Class\",\"sis_course_id\":null,\"calendar\":{\"ics\":\"https://canvas-dev.cisco.instructure.com/feeds/calendars/course_BZ2IWsZ30kuOhhyzcknK3ZFtPkC20laQ6DZ6KbHq.ics\"}},{\"hide_final_grades\":false,\"default_view\":\"feed\",\"account_id\":1222,\"enrollment_term_id\":1199,\"integration_id\":null,\"start_at\":\"2014-07-01T11:01:00Z\",\"public_syllabus\":false,\"storage_quota_mb\":500,\"html_url\":\"https://15282891.canvas-dev.cisco.instructure.com/courses/192\",\"id\":192,\"enrollments\":[{\"enrollment_state\":\"active\",\"role_id\":6,\"role\":\"TeacherEnrollment\",\"type\":\"teacher\"}],\"course_code\":\"spr33-D2-Class\",\"workflow_state\":\"available\",\"end_at\":\"2014-11-01T10:59:00Z\",\"apply_assignment_group_weights\":false,\"name\":\"spr33-D2-Class\",\"sis_course_id\":null,\"calendar\":{\"ics\":\"https://canvas-dev.cisco.instructure.com/feeds/calendars/course_q9uLcmaoLxTlIanhGbeMuUCCVggGxU6zcBmjmYtk.ics\"}}]";
	public static final String ACCOUNT_NAME="shobhitagarwal";
	public static final String BASE_URL="https://canvas.cisco.instructure.com/api/v1";
	public static final String TEST_CONSTANT="123";
	public static final String  courseId="1209";
	public static final String shortName="CT2";
	public static final String longName="Cisco Testing  2";
	public static final String accountId="4630";
	public static final String termId="1209";
	public static final String status="create";
	public static final String netacadCoreOfferingId="123";
	public static final String CANVAS_TOKEN="canvas.token";
	public static final String CANVAS_BASE_URL="canvas.base.url";
	@Before
	public void setUp() throws Exception
	{
		Props _props=mock(Props.class);
		mockStatic(PropsUtil.class);
		when(PropsUtil.getProps()).thenReturn(_props);
		when(PropsUtil.get(CANVAS_TOKEN)).thenReturn(USER_TOKEN);
		when(PropsUtil.get(CANVAS_BASE_URL)).thenReturn(BASE_URL);
		mockStatic(CanvasURLConnectionFactory.class);
		mockStatic(JSONFactoryUtil.class);
		mockStatic(Validator.class);
		mockStatic(GetterUtil.class);
		mockStatic(ServiceProps.class);
		mockStatic(GroupLocalServiceUtil.class);
		super.setUp();
		suppress(constructor(ServiceProps.class));
		when(GetterUtil.getBoolean(Mockito.any())).thenReturn(true);
		when(coursePersistence.fetchById(Mockito.anyLong())).thenReturn(course);
		stub(method(com.liferay.util.service.ServiceProps.class,"get",String.class)).toReturn(TEST_TRUE);
		suppressMethod(CourseLocalServiceImpl.class,new String[]{"getCourseById"});
		when(Validator.isNotNull(Mockito.contains(PropsUtil.get(CANVAS_BASE_URL)))).thenReturn(false);
		when(Validator.isNull(Mockito.any())).thenReturn(true);
		when(coursePersistence.create(Mockito.anyLong())).thenReturn(course);
		when(GroupLocalServiceUtil.getGroup(Mockito.anyLong(), Mockito.anyString())).thenReturn(group);
		when(group.getGroupId()).thenReturn(1L);
		suppressMethod(AssetEntryLocalService.class,new String[]{"updateEntry"});
		List<SubmissionVersion> submissionVersionList=new ArrayList<SubmissionVersion>();
		when(submissionVersion.getAssignmentName()).thenReturn(CiscoConstants.COURSE_COMPLETION);
		when(submissionVersion.getCurrentGrade()).thenReturn("Complete");
		submissionVersionList.add(submissionVersion);
		when( assignment.getName()).thenReturn(CiscoConstants.COURSE_COMPLETION).thenReturn(CiscoConstants.FINAL_EXAM);
		when(submissionVersionLocalService.getSubmissionHistory(Mockito.anyString(),Mockito.anyString())).thenReturn(submissionVersionList);
		when(coursePersistence.fetchById(Mockito.anyLong())).thenReturn(course);
	}
	@SuppressWarnings("unchecked")
	@Test
	public void getCourses() throws JSONException, SystemException, IOException
	{
		courseLocalServiceImpl.getCourses("", true, new String[]{});
		courseLocalServiceImpl.getCourses(USER_TOKEN,TEST_TRUE, new String[]{STATES_ARRAY});	
		courseLocalServiceImpl.getCourses(USER_TOKEN, TEST_FALSE, new String[]{STATES_ARRAY});	
//		Code to check when fetchById returns null value
		when(coursePersistence.fetchById(Mockito.anyLong())).thenReturn(null);
		courseLocalServiceImpl.getCourses(USER_TOKEN, TEST_TRUE, new String[]{});	
//		Code to check when fetchById throws System Exception
		when(coursePersistence.fetchById(Mockito.anyLong())).thenThrow(new SystemException());
		courseLocalServiceImpl.getCourses(USER_TOKEN, TEST_TRUE, new String[]{});		
		assertNotNull(getJsonResponse().get("getCourses"));
		jsonResponse=new HashedMap();
//		Get Courses method with two parameters
		courseLocalServiceImpl.getCourses(USER_TOKEN, TEST_FALSE);
		assertNotNull(getJsonResponse().get("getCourses"));
	}
	
	
	@Test
	public void createCourse() throws IOException, SystemException
	{
		
		when(counterLocalService.increment()).thenReturn(1L);
		String courseIdResponse=courseLocalServiceImpl.createCourse(courseId,  shortName,  longName,  accountId, termId,  status,  netacadCoreOfferingId);
		assertNotNull(getJsonResponse().get("updateCourses"));
		assertNotNull(courseIdResponse);
	}
	@Test
	public void updateCourse() throws SystemException
	{
		when(Validator.isNotNull(Mockito.any())).thenReturn(true);
		courseLocalServiceImpl.updateCourse("198", "Course-102", "Course-102", 23, 04, 2015, 24, 04, 2015, "UTC");
		assertEquals(Validator.isNotNull(Mockito.any()), true);
	}
	@Test
	public void getDistinctEnrolledCoursesForInstructor() throws JSONException, IOException
	{
		JSONArray impl=new JSONArrayImpl(GET_COURSES_JSON);
		when(canvasEnrollmentLocalService.getInstructorEnrollmentsForUser(Mockito.anyString())).thenReturn(impl);
		courseLocalServiceImpl.getDistinctEnrolledCoursesForInstructor(ACCOUNT_NAME);
	}
	@Test
	public void createcourse1() throws JSONException, IOException, SystemException
	{
		String netacadCoreOfferingId="123",timeZoneId="UTC";
		int startYear=23,startMonth=04,startDay=23,concludeYear=2015,concludeMonth=04,concludeDay=23;
		boolean enforceDates=false;
		when(counterLocalService.increment()).thenReturn(1L);
		String courseIdResponse=courseLocalServiceImpl.createCourse(courseId,  shortName,  longName,  accountId,  termId, status, netacadCoreOfferingId ,  startYear, startMonth,  startDay,  concludeYear,  concludeMonth, concludeDay,  timeZoneId,  enforceDates);
		assertNotNull(courseIdResponse);
	}
	@Test
	public void getCourses2() throws JSONException, IOException
	{
		when(Validator.isNotNull(Mockito.anyString())).then(new Answer<Boolean>() {
			@Override
			public Boolean answer(InvocationOnMock invocation) throws Throwable {
				String response=invocation.getArguments()[0].toString();
				if(response==null||response.length()<=0||response.equalsIgnoreCase(USER_TOKEN))
				{
					return false;
				}
				else
					return true;
			}
		});
		List<Course> course=	courseLocalServiceImpl.getCourses(USER_TOKEN);
		assertNotNull(course);
	}
	@Test
	public void getAllCourses() throws JSONException, IOException, SystemException
	{
		when(Validator.isNotNull(Mockito.anyString())).then(new Answer<Boolean>() {
			@Override
			public Boolean answer(InvocationOnMock invocation) throws Throwable {
				String response=invocation.getArguments()[0].toString();
				if(response!=null&&response.length()>0)
				{
					return true;
				}
				else{
					return false;
				}
					
			}
		});
		 List<Course> courseDetails=	courseLocalServiceImpl.getAllCourses(TEST_CONSTANT);
		 assertNotNull(courseDetails);
	}
	
	@Test
	public void getCourses1() throws JSONException
	{
		Course course=	courseLocalServiceImpl.getCourse(USER_TOKEN,TEST_ONE);
		assertNotNull(course);
	}
	
	@Test
	public void isQualifiedForCertificateTest() throws JSONException, IOException
	{
		boolean course=	courseLocalServiceImpl.isQualifiedForCertificate(TEST_ONE,TEST_ONE);
		assertEquals(course,true);
		submissionVersionList=new ArrayList<SubmissionVersion>();
		when(submissionVersion.getAssignmentName()).thenReturn(StringPool.BLANK);
		when(submissionVersion.getCurrentGrade()).thenReturn("Failed");
		submissionVersionList.add(submissionVersion);
		when(submissionVersionLocalService.getSubmissionHistory(Mockito.anyString(),Mockito.anyString())).thenReturn(submissionVersionList);
		course=	courseLocalServiceImpl.isQualifiedForCertificate(TEST_ONE,TEST_ONE);
		assertEquals(course,false);
	}
	@Test
	public void isQualifiedForCertificateIOExceptionTest() throws JSONException, IOException
	{
		when(submissionVersionLocalService.getSubmissionHistory(Mockito.anyString(),Mockito.anyString())).thenThrow(new IOException());
		boolean course=	courseLocalServiceImpl.isQualifiedForCertificate(TEST_ONE,TEST_ONE);
		assertEquals(course,false);
	}
	@Test
	public void isQualifiedForCertificateJSONExceptionTest() throws JSONException, IOException
	{
		when(submissionVersionLocalService.getSubmissionHistory(Mockito.anyString(),Mockito.anyString())).thenThrow(new JSONException());
		boolean course=	courseLocalServiceImpl.isQualifiedForCertificate(TEST_ONE,TEST_ONE);
		assertEquals(course,false);
	}
	@Test
	public void isQualifiedForLetterTest() throws JSONException, IOException, SystemException
	{
		mockStatic(AwardLocalServiceUtil.class);
		List<Assignment> assignments =new ArrayList<Assignment>();
		assignments.add(assignment);
		when( assignmentLocalService.getAssignments(Mockito.anyLong())).thenReturn(assignments);
		when( assignment.getName()).thenReturn(CiscoConstants.COURSE_COMPLETION);
		boolean status=courseLocalServiceImpl.isQualifiedForLetter(TEST_ONE,TEST_ONE);
		assertEquals(status, TEST_FALSE);
		when(AwardLocalServiceUtil.getAwardByCVLId(Mockito.anyString())).thenReturn(award);
		List<SubmissionVersion> submissionVersionList=new ArrayList<SubmissionVersion>();
		when(submissionVersion.getAssignmentName()).thenReturn(CiscoConstants.COURSE_COMPLETION);
		when(submissionVersion.getCurrentGrade()).thenReturn("Complete");
		submissionVersionList.add(submissionVersion);
		when( assignment.getName()).thenReturn(CiscoConstants.COURSE_COMPLETION).thenReturn(CiscoConstants.FINAL_EXAM);
		when(submissionVersionLocalService.getSubmissionHistory(Mockito.anyString(),Mockito.anyString(),Mockito.anyString())).thenReturn(submissionVersionList);
		when(award.getScore()).thenReturn(10.0);
		when(submissionVersion.getScore()).thenReturn(100L);
		when(submissionVersion.getAttempt()).thenReturn(1);
		when(course.getNetacadCVLId()).thenReturn("1L");
		when(submissionVersion.getGraderId()).thenReturn(0L);
		status=courseLocalServiceImpl.isQualifiedForLetter(TEST_ONE,TEST_ONE);
		when( coursePersistence.fetchById(Mockito.anyLong())).thenReturn(course);
		when(submissionVersionLocalService.getSubmissionHistory(Mockito.anyString(),Mockito.anyString(),Mockito.anyString())).thenThrow(new IOException());
		status=courseLocalServiceImpl.isQualifiedForLetter(TEST_ONE,TEST_ONE);
		when( assignment.getName()).thenReturn(CiscoConstants.COURSE_COMPLETION).thenReturn(CiscoConstants.FINAL_EXAM);
		when( coursePersistence.fetchById(Mockito.anyLong())).thenThrow(new SystemException());
		status=courseLocalServiceImpl.isQualifiedForLetter(TEST_ONE,TEST_ONE);
		when( assignment.getName()).thenReturn(CiscoConstants.COURSE_COMPLETION).thenReturn(CiscoConstants.FINAL_EXAM);
		/*Setting Validator.isNull(submission.getGraderId()) to true*/
		when(Validator.isNull(Mockito.anyLong())).thenReturn(TEST_TRUE);
		status=courseLocalServiceImpl.isQualifiedForLetter(TEST_ONE,TEST_ONE);
		assertEquals(status, TEST_FALSE);
	}
	@Test
	public void isQualifiedForLetterTestIOExceptionTest() throws JSONException, IOException
	{
		
		when(submissionVersionLocalService.getSubmissionHistory(Mockito.anyString(),Mockito.anyString(),Mockito.anyString())).thenThrow(new IOException());
		boolean course=	courseLocalServiceImpl.isQualifiedForLetter(TEST_ONE,TEST_ONE);
		assertEquals(course,false);
	}
	@Test
	public void isQualifiedForLetterTestJSONExceptionTest() throws JSONException, IOException
	{
		when(submissionVersionLocalService.getSubmissionHistory(Mockito.anyString(),Mockito.anyString(),Mockito.anyString())).thenThrow(new JSONException());
		boolean course=	courseLocalServiceImpl.isQualifiedForLetter(TEST_ONE,TEST_ONE);
		assertEquals(course,false);
	}
	
	@Test
	public void getCourseByOIDTest() throws SystemException
	{
		when(coursePersistence.fetchByNetacadOfferingId(Mockito.anyString())).thenReturn(course);		
		Course course=	courseLocalServiceImpl.getCourseByOID(TEST_CONSTANT);
		assertNotNull(course);
	}
	
	@Test
	public void getCoursesByCVLIdTest() throws SystemException
	{
		List<String> cvlIds=new ArrayList<String>();
		cvlIds.add(TEST_CONSTANT);
		cvlIds.add(TEST_CONSTANT);
		when(coursePersistence.fetchByNetacadOfferingId(Mockito.anyString())).thenReturn(course);		
		List<Course> course=	courseLocalServiceImpl.getCoursesByCVLId(cvlIds);
		assertNotNull(course);
	}
	private static final Log log = LogFactoryUtil.getLog(CourseLocalServiceImplTest.class);
	@SuppressWarnings("unchecked")
	private Map<String,Object> jsonResponse=new HashedMap();
}