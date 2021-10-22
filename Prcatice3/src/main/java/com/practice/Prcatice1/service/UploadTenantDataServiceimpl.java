package com.practice.Prcatice1.service;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.practice.Prcatice1.Dao.SupplierRiskDataRepository;
import com.practice.Prcatice1.model.GenericQueryCreationDTO;
import com.practice.Prcatice1.model.GenericQueryCreationResultDTO;

@Service
public class UploadTenantDataServiceimpl implements UploadTenantDataService{
	
	@Autowired
	public SupplierRiskDataRepository supplierRiskDataRepository;

	@Override
	public GenericQueryCreationResultDTO getGenericQueryResult(GenericQueryCreationDTO genericQueryCreationDTO) {
		return supplierRiskDataRepository.getGenericQueryResult(genericQueryCreationDTO);
	}

}
