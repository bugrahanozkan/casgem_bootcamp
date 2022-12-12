package com.kodlamaio.bootcampProject.business.abstracts;

import java.util.List;

import com.kodlamaio.bootcampProject.business.request.blacklist.CreateBlacklistRequest;
import com.kodlamaio.bootcampProject.business.request.blacklist.UpdateBlacklistRequest;
import com.kodlamaio.bootcampProject.business.response.blacklist.CreateBlacklistResponse;
import com.kodlamaio.bootcampProject.business.response.blacklist.GetAllBlacklistResponse;
import com.kodlamaio.bootcampProject.business.response.blacklist.GetBlacklistResponse;
import com.kodlamaio.bootcampProject.business.response.blacklist.UpdateBlacklistResponse;
import com.kodlamaio.bootcampProject.core.utilities.results.DataResult;
import com.kodlamaio.bootcampProject.core.utilities.results.Result;
import com.kodlamaio.bootcampProject.entities.Blacklist;

public interface BlacklistService {
	DataResult <List<GetAllBlacklistResponse>> getAll();
	
	DataResult<GetBlacklistResponse> getById(int id);
	
	DataResult<CreateBlacklistResponse> add(CreateBlacklistRequest createBlacklistRequest);
	
	DataResult<UpdateBlacklistResponse> update(UpdateBlacklistRequest updateBlacklistRequest );
	
	Result delete(int id);
	
	Blacklist getBlacklistById(int id);
	
	boolean existsBlacklistByApplicantId(int userId);
}
