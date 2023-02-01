package com.cg.service;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.entity.Asset;
import com.cg.exception.AssetNotFoundException;
import com.cg.iservice.IAssetService;
import com.cg.repository.AssetRepository;

@Service
public class AssetService implements IAssetService {
	
	String message="Asset Not Found";
	
	@Autowired
	private AssetRepository assetRepository;
	

	public Asset addAsset(Asset asset) {
		assetRepository.save(asset);
		return asset;
	}

	public Asset updateAsset(int id,Asset asset) {
      
        Optional<Asset> assetDetails=assetRepository.findById(asset.getItemNum());
        assetDetails.get().setItemName(asset.getItemName());
        //assetDetails.setItemNum(asset.getItemNum());
        assetDetails.get().setSerialNum(asset.getSerialNum());
        assetDetails.get().setStatus(asset.getStatus());
        return assetRepository.save(assetDetails.get());

    }
	
   public void deleteAsset(int itemNum) {
		
		Optional<Asset> asset = assetRepository.findById(itemNum);
		
		if(asset.isEmpty())
			
			throw new AssetNotFoundException(message);
		
		assetRepository.deleteById(itemNum);
	}
   
   
   public List<Asset> retrieveAllAssets(){
		
		return assetRepository.findAll();
		
		
	}


}
