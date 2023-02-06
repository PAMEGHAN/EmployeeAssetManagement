package com.cg.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.entity.Asset;
import com.cg.entity.Employee;
import com.cg.exception.AssetNotFoundException;
import com.cg.exception.EmployeeNotFoundException;
import com.cg.iservice.IAssetService;
import com.cg.repository.AssetRepository;

@Service
public class AssetService implements IAssetService {

	String message="Asset Not Found";

	@Autowired
	private AssetRepository assetRepository;


	@Override
	public Asset addAsset(Asset asset) {
		assetRepository.save(asset);
		return asset;
	}

	@Override
	public Asset updateAsset(int id,Asset asset) {

        Optional<Asset> assetDetails=assetRepository.findById(asset.getItemNum());
        assetDetails.get().setItemName(asset.getItemName());
        //assetDetails.setItemNum(asset.getItemNum());
        assetDetails.get().setSerialNum(asset.getSerialNum());
        assetDetails.get().setStatus(asset.getStatus());
        return assetRepository.save(assetDetails.get());

    }

   @Override
public void deleteAsset(int itemNum) {

		Optional<Asset> asset = assetRepository.findById(itemNum);

		if(asset.isEmpty())

			throw new AssetNotFoundException(message);

		assetRepository.deleteById(itemNum);
	}


   @Override
public List<Asset> retrieveAllAssets(){

		return assetRepository.findAll();


	}
   public List<Asset> getAssetByEmpId(int empId){
	   List<Asset> asset =assetRepository.findAll();
	   List<Asset> assetList= new ArrayList();
	   for(Asset asset1:asset) {
		   if(empId == asset1.getEmployee().getEmpId())
			   assetList.add(asset1);
	   }
	   
	    return assetList;
   }
}


