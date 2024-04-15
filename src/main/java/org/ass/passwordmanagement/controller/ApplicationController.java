package org.ass.passwordmanagement.controller;

import org.ass.passwordmanagement.constantutil.MappingConstant;
import org.ass.passwordmanagement.dto.AppResponseDto;
import org.ass.passwordmanagement.dto.ApplicationDto;
import org.ass.passwordmanagement.service.ApplicationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//@Controller
@RestController
public class ApplicationController {
	@Autowired
	private ApplicationServiceImpl serviceImpl;

	public ApplicationController() {
		System.out.println(this.getClass().getSimpleName());
	}
//    @RequestMapping(value="/saveUser")
//	public ModelAndView saveUser(ApplicationDto applicationDto) {
//		System.out.println(applicationDto);
//		serviceImpl.processCreateApp(applicationDto);
//       return new ModelAndView("index.jsp");
//	}
	//@RequestMapping(value="/createApp")
	@PostMapping(value=MappingConstant.CREATE_APP)
	public @ResponseBody AppResponseDto createApp(@RequestBody ApplicationDto applicationDto)
	{
		return serviceImpl.processCreateApp(applicationDto);
	}
	
//	@RequestMapping(value="/getAll")
	@GetMapping(value=MappingConstant.GET_ALL_DATA)
	public @ResponseBody AppResponseDto getAllData()
	{
		return serviceImpl.getAll();
	}
	
	@GetMapping(value=MappingConstant.GET_DATA_BY_ID)
	public @ResponseBody AppResponseDto findApplicationById(@PathVariable("id") long id) {
		
		return serviceImpl.getById(id);
		
	}
	
	@GetMapping(value=MappingConstant.GET_DATA_BY_TYPE)
	public @ResponseBody AppResponseDto findApplicationByType(@RequestHeader("appType") String appType) {
		
		return serviceImpl.getByType(appType);
		
	}
	
}