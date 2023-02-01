package com.cg.iservice;

import java.util.List;

import com.cg.entity.Asset;

public interface IAssetService {

	public Asset addAsset(Asset asset);
	public Asset updateAsset(int id,Asset asset);
	 public void deleteAsset(int itemNum);
	 public List<Asset> retrieveAllAssets();
	
}
