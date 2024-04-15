package org.ass.passwordmanagement.service;

import org.ass.passwordmanagement.dto.AppResponseDto;
import org.ass.passwordmanagement.dto.ApplicationDto;

public interface ApplicationService {

	public  AppResponseDto processCreateApp(ApplicationDto applicationDto);

	public AppResponseDto getById(long id);
	
	public AppResponseDto getByType(String appType);


}
