create table CANVAS_ActivityStream (
	activityStreamId LONG not null primary key,
	createdAt VARCHAR(75) null,
	updatedAt VARCHAR(75) null,
	id_ LONG,
	title VARCHAR(75) null,
	message VARCHAR(75) null,
	type_ VARCHAR(75) null,
	contextType VARCHAR(75) null,
	courseId LONG,
	groupId VARCHAR(75) null,
	htmlUrl VARCHAR(75) null
);

create table CANVAS_Assignment (
	assignmentId LONG not null primary key,
	name VARCHAR(75) null,
	submissionType VARCHAR(75) null
);

create table CANVAS_Award (
	awardId LONG not null primary key,
	cvlId VARCHAR(75) null,
	cvlName VARCHAR(75) null,
	score DOUBLE,
	letterArticleId LONG,
	certificateArticleId LONG,
	active_ BOOLEAN,
	createDate DATE null,
	modifiedDate DATE null
);

create table CANVAS_CanvasAccount (
	accountId LONG not null primary key,
	id_ VARCHAR(75) null,
	parentAccountId VARCHAR(75) null,
	name VARCHAR(75) null,
	rootAccountId VARCHAR(75) null,
	SISAccountId VARCHAR(75) null,
	status LONG,
	timeZone VARCHAR(75) null
);

create table CANVAS_CanvasEnrollment (
	courseId LONG not null primary key,
	userId VARCHAR(75) null,
	role VARCHAR(75) null,
	sectionId VARCHAR(75) null,
	status VARCHAR(75) null,
	associatedUserId VARCHAR(75) null
);

create table CANVAS_CanvasUser (
	userId LONG not null primary key,
	SID VARCHAR(75) null,
	loginId VARCHAR(75) null,
	password_ VARCHAR(75) null,
	firstName VARCHAR(75) null,
	lastName VARCHAR(75) null,
	email VARCHAR(75) null,
	status VARCHAR(75) null,
	fullName VARCHAR(75) null,
	canvasUserId VARCHAR(75) null,
	currentScore DOUBLE,
	finalScore DOUBLE
);

create table CANVAS_CertLetterQueue (
	id_ LONG not null primary key,
	courseId LONG,
	createDate DATE null,
	createdBy LONG,
	status VARCHAR(75) null,
	errorDescription VARCHAR(75) null,
	errorCount INTEGER,
	modifiedDate DATE null,
	startTime DATE null,
	endTime DATE null,
	zipFileLocation VARCHAR(75) null,
	expiryDate DATE null,
	type_ VARCHAR(75) null,
	downloadDate DATE null
);

create table CANVAS_Course (
	canvasId LONG not null primary key,
	name VARCHAR(75) null,
	id_ LONG,
	enrollments VARCHAR(75) null,
	course_code VARCHAR(75) null,
	sis_course_id VARCHAR(75) null,
	calendar VARCHAR(75) null,
	url VARCHAR(75) null,
	netacadCoreOfferingId VARCHAR(75) null,
	accountId LONG,
	netacadCVLId VARCHAR(75) null,
	startDate DATE null,
	endDate DATE null
);

create table CANVAS_EnrollmentSeat (
	id_ LONG not null primary key,
	token VARCHAR(75) null,
	rootAccountId VARCHAR(75) null,
	courseId VARCHAR(75) null,
	userId LONG,
	createDate DATE null,
	redeemDate DATE null
);

create table CANVAS_Submission (
	submissionId LONG not null primary key,
	assignmentId LONG,
	courseId LONG,
	attempt INTEGER,
	grade VARCHAR(75) null,
	htmlUrl VARCHAR(75) null,
	score DOUBLE,
	submissionDate VARCHAR(75) null,
	graderId VARCHAR(75) null,
	userId LONG
);

create table CANVAS_SubmissionVersion (
	submissionId LONG not null primary key,
	assignmentId LONG,
	assignmentName VARCHAR(75) null,
	attempt INTEGER,
	body VARCHAR(75) null,
	currentGrade VARCHAR(75) null,
	currentGradedAt VARCHAR(75) null,
	currentGrader VARCHAR(75) null,
	gradeMatchesCurrentSubmission VARCHAR(75) null,
	gradedAt VARCHAR(75) null,
	grader VARCHAR(75) null,
	graderId LONG,
	newGrade VARCHAR(75) null,
	newGradedAt VARCHAR(75) null,
	newGrader VARCHAR(75) null,
	previousGrade VARCHAR(75) null,
	previousGradedAt VARCHAR(75) null,
	previousGrader VARCHAR(75) null,
	score LONG,
	userName VARCHAR(75) null,
	userId LONG,
	submissionType VARCHAR(75) null,
	url VARCHAR(75) null,
	workflowState VARCHAR(75) null
);

create table CANVAS_Todo (
	todoId LONG not null primary key,
	type_ VARCHAR(75) null,
	assignmentName VARCHAR(75) null,
	assignmentDescription VARCHAR(75) null,
	ignore_ VARCHAR(75) null,
	ignorePermanently VARCHAR(75) null,
	needsGradingCount LONG,
	contextType VARCHAR(75) null,
	courseId VARCHAR(75) null,
	groupId VARCHAR(75) null,
	htmlUrl VARCHAR(75) null
);

create table CANVAS_UserAward (
	id_ LONG not null primary key,
	canvasUserId LONG,
	courseId LONG,
	externalId LONG,
	certId VARCHAR(75) null,
	letter BOOLEAN,
	createDate DATE null
);