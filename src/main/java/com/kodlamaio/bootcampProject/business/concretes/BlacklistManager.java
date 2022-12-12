package com.kodlamaio.bootcampProject.business.concretes;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import com.kodlamaio.bootcampProject.business.abstracts.BlacklistService;
import com.kodlamaio.bootcampProject.business.constants.Messages;
import com.kodlamaio.bootcampProject.business.request.blacklist.CreateBlacklistRequest;
import com.kodlamaio.bootcampProject.business.request.blacklist.UpdateBlacklistRequest;
import com.kodlamaio.bootcampProject.business.response.blacklist.CreateBlacklistResponse;
import com.kodlamaio.bootcampProject.business.response.blacklist.GetAllBlacklistResponse;
import com.kodlamaio.bootcampProject.business.response.blacklist.GetBlacklistResponse;
import com.kodlamaio.bootcampProject.business.response.blacklist.UpdateBlacklistResponse;
import com.kodlamaio.bootcampProject.core.utilities.exceptions.BusinessException;
import com.kodlamaio.bootcampProject.core.utilities.mapper.ModelMapperService;
import com.kodlamaio.bootcampProject.core.utilities.results.DataResult;
import com.kodlamaio.bootcampProject.core.utilities.results.Result;
import com.kodlamaio.bootcampProject.core.utilities.results.SuccessDataResult;
import com.kodlamaio.bootcampProject.core.utilities.results.SuccessResult;
import com.kodlamaio.bootcampProject.dataAccess.BlacklistRepository;
import com.kodlamaio.bootcampProject.entities.Blacklist;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BlacklistManager implements BlacklistService {
	private BlacklistRepository blacklistRepository;
	private ModelMapperService mapperService;

	@Override
	public DataResult<List<GetAllBlacklistResponse>> getAll() {
		List<GetAllBlacklistResponse> response = blacklistRepository.findAll().stream()
				.map(black -> mapperService.forResponse().map(black, GetAllBlacklistResponse.class))
				.collect(Collectors.toList());
		return new SuccessDataResult<List<GetAllBlacklistResponse>>(response, Messages.BlackListGetAll);
	}

	@Override
	public DataResult<GetBlacklistResponse> getById(int id) {
		checkIfBlacklistExistById(id);
		Blacklist blacklist = blacklistRepository.getBlacklistById(id);
		GetBlacklistResponse response = mapperService.forResponse().map(blacklist, GetBlacklistResponse.class);
		return new SuccessDataResult<GetBlacklistResponse>(response, "getById");
	}

	@Override
	public DataResult<CreateBlacklistResponse> add(CreateBlacklistRequest createBlacklistRequest) {
		Blacklist blacklist = mapperService.forRequest().map(createBlacklistRequest, Blacklist.class);
		blacklist.setId(0);
		blacklistRepository.save(blacklist);
		CreateBlacklistResponse response = mapperService.forResponse().map(blacklist, CreateBlacklistResponse.class);
		return new SuccessDataResult<CreateBlacklistResponse>(response, Messages.BlackListCreated);
	}

	@Override
	public DataResult<UpdateBlacklistResponse> update(UpdateBlacklistRequest updateBlacklistRequest) {
		Blacklist blacklist = mapperService.forRequest().map(updateBlacklistRequest, Blacklist.class);

		UpdateBlacklistResponse response = mapperService.forResponse().map(blacklist, UpdateBlacklistResponse.class);
		return new SuccessDataResult<UpdateBlacklistResponse>(response, Messages.BlackListUpdated);
	}

	@Override
	public Result delete(int id) {
		checkIfBlacklistExistById(id);
		blacklistRepository.deleteById(id);
		return new SuccessResult(Messages.BlackListDeleted);
	}

	@Override
	public Blacklist getBlacklistById(int id) {
		return blacklistRepository.getBlacklistById(id);
	}

	@Override
	public boolean existsBlacklistByApplicantId(int userId) {

		return blacklistRepository.existsBlacklistByApplicantId(userId);
	}

	private void checkIfBlacklistExistById(int id) {

		if (blacklistRepository.getBlacklistById(id) == null)
			throw new BusinessException(id + Messages.BlackListIdException);
	}

}
