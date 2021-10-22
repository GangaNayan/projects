package com.practice.Prcatice1.controller;

import org.springframework.http.MediaType;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.practice.Prcatice1.model.GenericQueryCreationDTO;
import com.practice.Prcatice1.model.GenericQueryCreationResultDTO;
import com.practice.Prcatice1.model.ResultObj;
import com.practice.Prcatice1.model.ZCIResponse;
import com.practice.Prcatice1.service.UploadTenantDataService;

@RestController
@RequestMapping("/genericqueycreation")
public class GenericQueryCreationController {
	
	@Autowired
	private UploadTenantDataService uploadTenantDataService;
	
	//private static final Logger	LOGGER	= LoggerFactory.getLogger(SupplierRiskController.class);
	
	@RequestMapping(path = "/genericlist", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ZCIResponse getGenericQueryList(@RequestBody GenericQueryCreationDTO genericQueryCreationDTO) {
		
		ZCIResponse zciResponse=new ZCIResponse();
		
		
		try {
			
			String query=genericQueryCreationDTO.getQuery();
			if(!query.stripLeading().toLowerCase().startsWith("select")) {
				zciResponse.setErrorCode("403");
				zciResponse.setErrorMessage("Forbiden");
				return zciResponse;
			}
			
			GenericQueryCreationResultDTO  genericQueryCreationResultDTO=uploadTenantDataService.getGenericQueryResult(genericQueryCreationDTO);
			GenericQueryCreationResultDTO gc=genericQueryCreationResultDTO;
			List<Object> ol=gc.getColclass();
			long tcount=gc.getTotalCount();
			String stcakError=gc.getErrorStackTrace();
			
			ResultObj robj=new ResultObj();
			robj.setColclass(ol);
			robj.setTotalCount(tcount);
			
			
			if(stcakError==null) {
				zciResponse.setErrorCode("200");
		        zciResponse.setErrorMessage("SUCCESS");
		        zciResponse.setResult(robj);
			}else {
				zciResponse.setErrorCode("500");
		        zciResponse.setErrorMessage("FAILURE   	"+stcakError);
			}
	        
	        
		} catch (Exception e) {
		//LOGGER.error("Error in processing",e);
	
	    }
		
		return zciResponse;
	}
	

}
