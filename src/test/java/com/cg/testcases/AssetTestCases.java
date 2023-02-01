package com.cg.testcases;

import static org.assertj.core.api.Assertions.assertThat;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.entity.Asset;
import com.cg.entity.Employee;
import com.cg.repository.AssetRepository;
import com.cg.service.AssetService;

@SpringBootTest
public class AssetTestCases {
	
	@Mock
	private AssetRepository assetRepository;
	
	@InjectMocks
	private AssetService assetService;
	
	@Test
	void addAsset() {
		Asset asset = new Asset("Laptop",1,100,"allocated");
		when(assetRepository.save(asset)).thenReturn(asset);
		Asset assetDetails = assetService.addAsset(asset);
		assertThat(assetDetails.getItemName().equals(asset.getItemName()));
	}

	@Test
	void updateAsset() {
		Asset asset = new Asset("Laptop",1,100,"allocated");
		when(assetRepository.findById(asset.getItemNum())).thenReturn(Optional.of(asset));
		Asset assetDetails = assetService.updateAsset(1,asset);
		assertEquals("Laptop",asset.getItemName());
		verify(assetRepository,times(1)).findById(asset.getItemNum());
		
	}
	
	@Test
	void deleteAsset() {
		Asset asset = new Asset("Laptop",1,100,"allocated");
		when(assetRepository.findById(asset.getItemNum())).thenReturn(Optional.of(asset));
		Asset assetDetails = assetService.updateAsset(1,asset);
		assetService.deleteAsset(asset.getItemNum());
		verify(assetRepository,times(1)).deleteById(asset.getItemNum());
	}
	
	@Test
	void retriveAllAssets() {
		List<Asset> asset=new ArrayList<Asset>();
		when(assetRepository.findAll()).thenReturn(asset);
		assetService.retrieveAllAssets();
		
		
	}
}
