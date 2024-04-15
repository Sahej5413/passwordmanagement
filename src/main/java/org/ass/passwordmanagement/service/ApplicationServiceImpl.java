package org.ass.passwordmanagement.service;

import java.util.List;

import org.ass.passwordmanagement.dto.AppResponseDto;
import org.ass.passwordmanagement.dto.ApplicationDto;
import org.ass.passwordmanagement.entity.ApplicationEntity;
import org.ass.passwordmanagement.repository.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApplicationServiceImpl implements ApplicationService {
	@Autowired
	private ApplicationRepository applicationRepository;

	@Override
	public AppResponseDto processCreateApp(ApplicationDto applicationDto) {
		AppResponseDto appResponseDto = null;
		try {
		ApplicationEntity applicationEntity = new ApplicationEntity();
		applicationEntity.setAppName(applicationDto.getAppName());
		applicationEntity.setUrl(applicationDto.getAppUrl());
		applicationEntity.setAppType(applicationDto.getAppType());
		applicationEntity.setPassword(applicationDto.getPassword());
		applicationEntity.setStatus(applicationDto.getStatus());
		
			ApplicationEntity savedObj = applicationRepository.save(applicationEntity);
			if (savedObj == null) {
				appResponseDto = new AppResponseDto("FAILURE", "500", null, null);
			}
			appResponseDto = new AppResponseDto("SUCCESS", "200", savedObj, null);
		} catch (Exception e) {
			appResponseDto = new AppResponseDto("FAILURE", "500", null, e.getLocalizedMessage());
		}
		return appResponseDto;
	}
	
	
	public AppResponseDto getAll() {
		AppResponseDto appResponseDto=null;
		try {
			List<ApplicationEntity> applicationa=applicationRepository.findAll();
			appResponseDto=new AppResponseDto("success", "error", applicationa, "404");
		}
		catch (Exception e) {
			// TODO: handle exception
			appResponseDto=new AppResponseDto("success", "error"," applicationa", "404");
			
		}
		
		return appResponseDto;
		
	}
	

	@Override
	public AppResponseDto getById(long id) {
		// TODO Auto-generated method stub
		ApplicationEntity applicationEntity=applicationRepository.findById(id);
		if(applicationEntity==null) {
			return new AppResponseDto("failure", "500", null, null);
		}
	 return new AppResponseDto("success", "200", applicationEntity, null);
	 
	}


	@Override
	public AppResponseDto getByType(String appType) {
		List<ApplicationEntity>appList=applicationRepository.findByAppType(appType);
		return new AppResponseDto("success","400","ApplicationEntity","null");
	}
	
}
