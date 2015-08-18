create index IX_C88FBBAD on CANVAS_Award (active_);
create index IX_AA2A10A8 on CANVAS_Award (cvlId);
create index IX_D0660758 on CANVAS_Award (cvlName);

create index IX_16FB9C3F on CANVAS_CertLetterQueue (courseId, createdBy);
create index IX_A4B52C25 on CANVAS_CertLetterQueue (courseId, createdBy, status);
create index IX_B44B4199 on CANVAS_CertLetterQueue (courseId, status, createdBy);
create index IX_C881DA1C on CANVAS_CertLetterQueue (courseId, status, createdBy, type_);
create index IX_C966607 on CANVAS_CertLetterQueue (status, errorCount);
create index IX_5DDE321 on CANVAS_CertLetterQueue (status, expiryDate);

create index IX_23BBD08C on CANVAS_Course (id_);
create index IX_ADADF4E on CANVAS_Course (netacadCVLId);
create index IX_6C77CD2A on CANVAS_Course (netacadCoreOfferingId);

create index IX_88B20160 on CANVAS_EnrollmentSeat (courseId);
create index IX_F20FC0D3 on CANVAS_EnrollmentSeat (token);

create index IX_942F9683 on CANVAS_UserAward (canvasUserId);
create index IX_A81BE3E7 on CANVAS_UserAward (canvasUserId, courseId, letter);
create index IX_1DB2E924 on CANVAS_UserAward (certId);
create index IX_DFC9E7CD on CANVAS_UserAward (courseId, canvasUserId);