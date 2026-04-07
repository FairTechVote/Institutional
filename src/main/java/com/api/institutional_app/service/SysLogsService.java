package com.api.institutional_app.service;

import com.api.institutional_app.dto.ResponseSysLogsByDate;
import com.api.institutional_app.dto.RequestSysLogsByDate;

public interface SysLogsService {

    ResponseSysLogsByDate getSysLogsByDate(RequestSysLogsByDate request);

}
