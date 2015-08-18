package com.instructure.canvas.service.impl;

import com.cisco.communityactivity.util.CommonMockUtil;
import com.liferay.counter.service.CounterLocalService;
import com.liferay.portal.json.JSONArrayImpl;
import com.liferay.portal.json.JSONObjectImpl;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;

import java.util.Map;

import org.apache.commons.collections.map.HashedMap;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
@RunWith(PowerMockRunner.class)
@PrepareForTest({JSONFactoryUtil.class,CounterLocalService.class})
public class CanvasUtilityMock  extends CommonMockUtil
{
	public static final String ACCOUNTID="4630";
	@Mock 
	public CounterLocalService counterLocalService;
	@Before
	public void setUp() throws Exception
	{
		mockStatic(JSONFactoryUtil.class);
		super.setUp();
		when(counterLocalService.increment()).thenReturn(TEST_ONE);
		when(JSONFactoryUtil.createJSONArray(Mockito.anyString())).thenAnswer(new Answer<JSONArray>() {
			@Override
			public JSONArray answer(InvocationOnMock invocation)throws Throwable {
				String response=invocation.getArguments()[0].toString();
				if(response!=null){
					jsonResponse.put("jsonArrayDetails", response);
				return new JSONArrayImpl(invocation.getArguments()[0].toString());
				
				}
				else
					return new JSONArrayImpl();
			}
		});
		when(JSONFactoryUtil.createJSONObject(Mockito.anyString())).thenAnswer(new Answer<JSONObject>() {
			@Override
			public JSONObject answer(InvocationOnMock invocation) throws Throwable {
				String response=invocation.getArguments()[0].toString();
				if(response!=null){
				jsonResponse.put("jsonObjectDetails", response);
				return new JSONObjectImpl(invocation.getArguments()[0].toString());
				}
				else
					return new JSONObjectImpl();
			}
		});
	}
	
	@SuppressWarnings("unchecked")
	private Map<String,Object> jsonResponse=new HashedMap();
}
