package com.practice.Prcatice1.Dao;

import com.practice.Prcatice1.model.GenericQueryCreationDTO;
import com.practice.Prcatice1.model.GenericQueryCreationResultDTO;

public interface SupplierRiskDataRepository {
	public GenericQueryCreationResultDTO getGenericQueryResult(GenericQueryCreationDTO genericQueryCreationDTO);
}
