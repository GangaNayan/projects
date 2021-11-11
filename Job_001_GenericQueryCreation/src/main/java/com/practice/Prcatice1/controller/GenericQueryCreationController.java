package com.practice.Prcatice1.controller;

import org.springframework.http.MediaType;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.practice.Prcatice1.Dao.GenericQueryCreation_Validation;
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
	
	private static final Logger	LOGGER	= LoggerFactory.getLogger(GenericQueryCreationController.class);
	
	@RequestMapping(path = "/genericlist", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ZCIResponse getGenericQueryList(@RequestBody GenericQueryCreationDTO genericQueryCreationDTO) {
		
		ZCIResponse zciResponse=new ZCIResponse();
		
		try {
			
//			String query=genericQueryCreationDTO.getQuery();
//			if(!query.stripLeading().toLowerCase().startsWith("select")) {
//				zciResponse.setErrorCode("403");
//				zciResponse.setErrorMessage("Forbiden");
//				zciResponse.setStatus(false);
//				return zciResponse;
//			}
			
			/* Note : Make Sure to change database dependency according to your database
			 Description
			 //API Request
             {
             "startIndex":0,
             "endIndex":0,
             "query": "select * from emp1"
             }

            //API Response
            {
             "status": true,
             "errorCode": "200",
             "errorMessage": "SUCCESS",
             "errorParams": null,
             "result": {
             "data": [
                 {
                "ename": "naya",
                "esal": "899.0",
                "eno": "39",
                "eaddr": "ets"
            },
            ..... etc
            {
                "ename": "ygf",
                "esal": "89.9",
                "eno": "987",
                "eaddr": "fgg"
            }
           ],
             "totalCount": 17
           },
          "checksum": null,
         "responseCode": null
         }
			 *
			 */
			
			GenericQueryCreation_Validation vd=new GenericQueryCreation_Validation();
			
			if(!vd.isPositiveNumbers(genericQueryCreationDTO)) {
				zciResponse.setErrorCode("403");
				zciResponse.setErrorMessage("Forbiden : Numbers Cannot Be Negative, Please Enter a Valid Number");
				zciResponse.setStatus(false);
				return zciResponse;
			}
			
			if(!vd.isEndIndexGraterThanStartIndex(genericQueryCreationDTO)) {
				zciResponse.setErrorCode("403");
				zciResponse.setErrorMessage("Forbiden : startIndex Cannot be Grater than endIndex, Please Enter a Valid Number");
				zciResponse.setStatus(false);
				return zciResponse;
			}
			
			if(!vd.isEndIndexGraterThanZero(genericQueryCreationDTO)) {
				zciResponse.setErrorCode("403");
				zciResponse.setErrorMessage("Forbiden : endIndex Cannot be Zero, Please Enter a Valid Number");
				zciResponse.setStatus(false);
				return zciResponse;
			}
			
			if(!vd.isLimitLessThanOrEqualToThousand(genericQueryCreationDTO)) {
				zciResponse.setErrorCode("403");
				zciResponse.setErrorMessage("Forbiden : Not Possible to Display More Than 1000 Records");
				zciResponse.setStatus(false);
				return zciResponse;
			}
			
			if(!vd.isSelectQuery(genericQueryCreationDTO)) {
				zciResponse.setErrorCode("403");
				zciResponse.setErrorMessage("Forbiden : Only Select Queries Are Allowed, Please Enter Valid Select Query");
				zciResponse.setStatus(false);
				return zciResponse;
			}
			
			
			GenericQueryCreationResultDTO  genericQueryCreationResultDTO=uploadTenantDataService.getGenericQueryResult(genericQueryCreationDTO);
			GenericQueryCreationResultDTO gc=genericQueryCreationResultDTO;
			List<Object> ol=gc.getData();
			long tcount=gc.getTotalCount();
			String stcakError=gc.getErrorStackTrace();
			
			
		    ResultObj robj=new ResultObj();
			robj.setData(ol);
			robj.setTotalCount(tcount);
			
			
			if(stcakError==null) {
				zciResponse.setErrorCode("200");
		        zciResponse.setErrorMessage("SUCCESS");
		        zciResponse.setResult(robj);
		        zciResponse.setStatus(true);
			}else {
				zciResponse.setErrorCode("500");
		        zciResponse.setErrorMessage("FAILURE   	"+stcakError);
		        zciResponse.setStatus(false);
			}
	        
		} catch (Exception e) {
		LOGGER.error("Error in processing",e);
	
	    }
		
		return zciResponse;
	}
	

}