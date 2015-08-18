Liferay.Service.register("Liferay.Service.INS", "com.instructure.canvas.service", "canvas-integration-portlet");

Liferay.Service.register("Liferay.Service.CANVAS", "com.instructure.canvas.service", "canvas-integration-portlet");

Liferay.Service.registerClass(
	Liferay.Service.CANVAS, "CanvasUser",
	{
		getNineDigitId: true,
		getJSONNineDigitId: true
	}
);