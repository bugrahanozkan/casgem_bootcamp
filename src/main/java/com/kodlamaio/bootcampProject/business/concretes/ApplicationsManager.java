package com.kodlamaio.bootcampProject.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.kodlamaio.bootcampProject.business.abstracts.ApplicationsService;
import com.kodlamaio.bootcampProject.business.abstracts.BlacklistService;
import com.kodlamaio.bootcampProject.business.abstracts.BootcampsService;
import com.kodlamaio.bootcampProject.business.constants.Messages;
import com.kodlamaio.bootcampProject.business.request.applications.CreateApplicationsRequest;
import com.kodlamaio.bootcampProject.business.request.applications.UpdateApplicationsRequest;
import com.kodlamaio.bootcampProject.business.response.applications.CreateApplicationsResponse;
import com.kodlamaio.bootcampProject.business.response.applications.GetAllApplicationsResponse;
import com.kodlamaio.bootcampProject.business.response.applications.GetApplicationsResponse;
import com.kodlamaio.bootcampProject.business.response.applications.UpdateApplicationsResponse;
import com.kodlamaio.bootcampProject.core.utilities.exceptions.BusinessException;
import com.kodlamaio.bootcampProject.core.utilities.mapper.ModelMapperService;
import com.kodlamaio.bootcampProject.core.utilities.results.DataResult;
import com.kodlamaio.bootcampProject.core.utilities.results.Result;
import com.kodlamaio.bootcampProject.core.utilities.results.SuccessDataResult;
import com.kodlamaio.bootcampProject.core.utilities.results.SuccessResult;
import com.kodlamaio.bootcampProject.dataAccess.ApplicationsRepository;
import com.kodlamaio.bootcampProject.dataAccess.BootcampsRepository;
import com.kodlamaio.bootcampProject.entities.applications.Applications;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ApplicationsManager  implements ApplicationsService{

	
	private ApplicationsRepository applicationsRepository;
	private ModelMapperService mapperService;
	private BlacklistService blacklistService;
	private BootcampsService bootcampsService;
	  
	
	@Override
	public DataResult<List<GetAllApplicationsResponse>> getAll() {
		List<Applications> applications= applicationsRepository.findAll();
		List<GetAllApplicationsResponse> response = applications.stream()
				.map(application -> mapperService
						.forResponse().map(application, GetAllApplicationsResponse.class))
				.collect(Collectors.toList());
		return new SuccessDataResult<List<GetAllApplicationsResponse>>(response,Messages.ApplicationsGetAll);
	}

	@Override
	public DataResult<CreateApplicationsResponse> add(CreateApplicationsRequest createApplicationsRequest) {
		checkIfUserBlacklist(createApplicationsRequest.getUserId());
		
		checkIfUserHasApplication(createApplicationsRequest.getUserId());
		
		bootcampsService.checkIfBootcampIsActive(createApplicationsRequest.getBootcampsId());
		
		
		Applications applications = this.mapperService.forRequest().map(createApplicationsRequest, Applications.class);
		applications.setId(0);

		this.applicationsRepository.save(applications);

		CreateApplicationsResponse createApplicationsResponse = this.mapperService.
				forResponse()
				.map(applications, CreateApplicationsResponse.class);

		return new SuccessDataResult<>(createApplicationsResponse,Messages.ApplicationsAdd);
	}

	@Override
	public DataResult<GetAllApplicationsResponse> getByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataResult<GetApplicationsResponse> getById(int id) {
		
		checkIfApplicationsExistById(id);
		
		Applications applications=this.applicationsRepository.findById(id).get();
		
		GetApplicationsResponse response = this.mapperService.forResponse().map(applications,GetApplicationsResponse.class);
		
		
		return new SuccessDataResult<GetApplicationsResponse>(response,Messages.ApplicationsGetById);
	}

	@Override
	public Result deleteById(int id) {
		checkIfApplicationsExistById(id);
		applicationsRepository.deleteById(id);
		return new SuccessResult(Messages.ApplicationsDelete);
	} 

	@Override
	public DataResult<UpdateApplicationsResponse> updateById(UpdateApplicationsRequest updateApplicationsRequest) {
		
		checkIfApplicationsExistById(updateApplicationsRequest.getId());
		
		Applications applications= this.mapperService.forRequest().map(updateApplicationsRequest, Applications.class);

		this.applicationsRepository.save(applications);
		
		UpdateApplicationsResponse updateApplicationsResponse = this.mapperService.forResponse().map(applications, UpdateApplicationsResponse.class);


		return new SuccessDataResult<>(updateApplicationsResponse,Messages.ApplicationsUpdate);
	}
	
	private void checkIfApplicationsExistById(int id) {
		if(applicationsRepository.getApplicationById(id) == null)
			throw new BusinessException(Messages.ApplicationsIdException);
	}
	
	private void checkIfUserHasApplication(int id) {
		if(applicationsRepository.existsApplicationByUserId(id))
			throw new BusinessException(id+ Messages.UserHasApplication);
	}
	
	private void checkIfUserBlacklist(int id) {
		if(blacklistService.existsBlacklistByApplicantId(id))
			throw new BusinessException(id+"numaralı kullanıcı karalistede");
	}

}
