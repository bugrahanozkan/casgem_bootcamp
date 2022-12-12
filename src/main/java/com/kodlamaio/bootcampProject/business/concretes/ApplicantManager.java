package com.kodlamaio.bootcampProject.business.concretes;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import com.kodlamaio.bootcampProject.business.abstracts.ApplicantService;
import com.kodlamaio.bootcampProject.business.constants.Messages;
import com.kodlamaio.bootcampProject.business.request.applicant.CreateApplicantRequest;
import com.kodlamaio.bootcampProject.business.request.applicant.GetApplicantRequest;
import com.kodlamaio.bootcampProject.business.request.applicant.UpdateApplicantRequest;
import com.kodlamaio.bootcampProject.business.response.applicant.CreateApplicantResponse;
import com.kodlamaio.bootcampProject.business.response.applicant.GetAllApplicantResponse;
import com.kodlamaio.bootcampProject.business.response.applicant.GetApplicantResponse;
import com.kodlamaio.bootcampProject.business.response.applicant.UpdateApplicantResponse;
import com.kodlamaio.bootcampProject.core.utilities.exceptions.BusinessException;
import com.kodlamaio.bootcampProject.core.utilities.mapper.ModelMapperService;
import com.kodlamaio.bootcampProject.core.utilities.results.DataResult;
import com.kodlamaio.bootcampProject.core.utilities.results.Result;
import com.kodlamaio.bootcampProject.core.utilities.results.SuccessDataResult;
import com.kodlamaio.bootcampProject.core.utilities.results.SuccessResult;
import com.kodlamaio.bootcampProject.dataAccess.ApplicantRepository;
import com.kodlamaio.bootcampProject.entities.Applicant;

import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor

public class ApplicantManager  implements ApplicantService{
 private ApplicantRepository applicantRepository;
 private ModelMapperService   mapperService;
	@Override
	public DataResult<List<GetAllApplicantResponse>> getAll() {
		
		
		List<Applicant> applicants = applicantRepository.findAll();
		List<GetAllApplicantResponse> response= applicants
				.stream()
				.map(applicant -> mapperService.forResponse().map(applicant,GetAllApplicantResponse.class))
				.collect(Collectors.toList());
		
		
		return new SuccessDataResult<List<GetAllApplicantResponse>>(response,Messages.ApplicantGetAll);// response'ları eklediğimiz listeyi(responseList) geri döndürüyoruz.
	}

	@Override
	public DataResult<CreateApplicantResponse> add(CreateApplicantRequest createApplicantRequest) {
		
		Applicant applicant = this.mapperService.forRequest().map(createApplicantRequest, Applicant.class);
		applicant.setId(0);
		
		checkIfApplicantExistsByNationalIdendinty(createApplicantRequest.getNationalIdendity());

		this.applicantRepository.save(applicant);

		CreateApplicantResponse createApplicantResponse = this.mapperService.forResponse().map(applicant, CreateApplicantResponse.class);

		return new SuccessDataResult<>(createApplicantResponse,Messages.ApplicantAdd);
	}

	@Override
	public DataResult <List<GetAllApplicantResponse>> getByName(GetApplicantRequest  request) {
		List<Applicant> applicants = applicantRepository.findByFirstName(request.getFirstName());
		List<GetAllApplicantResponse> response = applicants
				.stream()
				.map(a-> mapperService.forResponse().map(a, GetAllApplicantResponse.class))
				.collect(Collectors.toList());
		return new SuccessDataResult<List<GetAllApplicantResponse>>(response, "getAllByName");
	}

	@Override
	public DataResult<GetApplicantResponse> getById(int id) {
		
		checkIfApplicantById(id);
		
		Applicant applicant=this.applicantRepository.findById(id).get();
		
		GetApplicantResponse response = this.mapperService.forResponse().map(applicant,GetApplicantResponse.class);
		
		
		return new SuccessDataResult<GetApplicantResponse>(response,Messages.ApplicantById);
	}

	@Override
	public Result deleteApplicantById(int id) {
		
		checkIfApplicantById(id);
		applicantRepository.deleteById(id);
		return new SuccessResult(Messages.ApplicantDelete);
	}

	@Override
	public DataResult<UpdateApplicantResponse> uptadeApplicantById(UpdateApplicantRequest updateApplicantRequest) {
		
		
		
		checkIfApplicantById(updateApplicantRequest.getId());
		
		Applicant applicant= this.mapperService.forRequest().map(updateApplicantRequest, Applicant.class);
		
		checkIfApplicantExistsByNationalIdendinty(updateApplicantRequest.getNationalIdendity());

		this.applicantRepository.save(applicant);
		
		UpdateApplicantResponse updateApplicantResponse = this.mapperService.forResponse().map(applicant, UpdateApplicantResponse.class);


		return new SuccessDataResult<>(updateApplicantResponse,Messages.ApplicantUpdate);
	}
	
	
	//iş kuralları
	private void checkIfApplicantExistsByNationalIdendinty(String nationalIdentidy) {
		Applicant applicant=this.applicantRepository.findApplicantByNationalIdendity(nationalIdentidy);
			if(applicant!=null) {
				throw new BusinessException(Messages.ApplicantIdendityError);
			}
			
				
	}
	
	private void checkIfApplicantById(int id) {
		Applicant applicant= this.applicantRepository.findById(id).orElse(null);
		if(applicant==null) {
			throw new BusinessException(Messages.ApplicantNotId);
		}
	}

	

	
}

