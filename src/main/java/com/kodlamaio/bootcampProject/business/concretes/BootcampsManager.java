package com.kodlamaio.bootcampProject.business.concretes;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Service;
import com.kodlamaio.bootcampProject.business.abstracts.BootcampsService;
import com.kodlamaio.bootcampProject.business.constants.Messages;
import com.kodlamaio.bootcampProject.business.request.bootcamps.CreateBootcampsRequest;
import com.kodlamaio.bootcampProject.business.request.bootcamps.UpdateBootcampsRequest;
import com.kodlamaio.bootcampProject.business.response.bootcamps.CreateBootcampResponse;
import com.kodlamaio.bootcampProject.business.response.bootcamps.GetAllBootcampsResponse;
import com.kodlamaio.bootcampProject.business.response.bootcamps.GetBootcampsResponse;
import com.kodlamaio.bootcampProject.business.response.bootcamps.UpdateBootcampsResponse;
import com.kodlamaio.bootcampProject.core.utilities.exceptions.BusinessException;
import com.kodlamaio.bootcampProject.core.utilities.mapper.ModelMapperService;
import com.kodlamaio.bootcampProject.core.utilities.results.DataResult;
import com.kodlamaio.bootcampProject.core.utilities.results.Result;
import com.kodlamaio.bootcampProject.core.utilities.results.SuccessDataResult;
import com.kodlamaio.bootcampProject.core.utilities.results.SuccessResult;
import com.kodlamaio.bootcampProject.dataAccess.BootcampsRepository;
import com.kodlamaio.bootcampProject.entities.Bootcamps;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BootcampsManager implements BootcampsService {

	private BootcampsRepository bootcampsRepository;

	private ModelMapperService mapperService;

	@Override
	public DataResult<List<GetAllBootcampsResponse>> getAll() {
		List<Bootcamps> bootcamps = bootcampsRepository.findAll();
		List<GetAllBootcampsResponse> response = bootcamps.stream()
				.map(bootcamp -> mapperService.forResponse().map(bootcamp, GetAllBootcampsResponse.class))
				.collect(Collectors.toList());
		return new SuccessDataResult<List<GetAllBootcampsResponse>>(response, Messages.BootcampsGetAll);
	}

	@Override
	public DataResult<CreateBootcampResponse> add(CreateBootcampsRequest createBootcampsRequest) {
		
		checkIfBootcampIsActive(createBootcampsRequest.getState());
		checkIfDateException(createBootcampsRequest.getDateStart(), createBootcampsRequest.getDateEnd());
		Bootcamps bootcamps = this.mapperService.forRequest().map(createBootcampsRequest, Bootcamps.class);
		bootcamps.setId(0);

		this.bootcampsRepository.save(bootcamps);

		CreateBootcampResponse createBootcampsResponse = this.mapperService.forResponse().map(bootcamps,
				CreateBootcampResponse.class);

		return new SuccessDataResult<>(createBootcampsResponse, Messages.BootcampsAdd);
	}

	@Override
	public DataResult<GetAllBootcampsResponse> getByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataResult<GetBootcampsResponse> getById(int id) {
		
		checkIfBootcampsExistById(id);
		
		Bootcamps bootcamps = this.bootcampsRepository.findById(id).get();

		GetBootcampsResponse response = this.mapperService.forResponse().map(bootcamps, GetBootcampsResponse.class);

		return new SuccessDataResult<GetBootcampsResponse>(response, Messages.BootcampsGetById);
	}

	@Override
	public Result deleteById(int id) {
		checkIfBootcampsExistById(id);
		bootcampsRepository.deleteById(id);
		return new SuccessResult(Messages.BootcampsDelete);
	}

	@Override
	public DataResult<UpdateBootcampsResponse> updateById(UpdateBootcampsRequest updateBootcampsRequest) {
		
		
		Bootcamps bootcamps = this.mapperService.forRequest().map(updateBootcampsRequest, Bootcamps.class);

		this.bootcampsRepository.save(bootcamps);

		UpdateBootcampsResponse updateBootcampsResponse = this.mapperService.forResponse().map(bootcamps,
				UpdateBootcampsResponse.class);

		return new SuccessDataResult<>(updateBootcampsResponse, Messages.BootcampsUpdate);
	}
	
	private void checkIfBootcampsExistById(int id) {
		if(bootcampsRepository.getBootcampsById(id) == null)
			throw new BusinessException(Messages.BootcampsIdException);
	}
	
	private void checkIfDateException(@NotNull LocalDate dateStart,LocalDate dateEnd) {
		
		if(dateEnd.isBefore(dateStart))
			throw new BusinessException(Messages.BootcampsDateException);
	}
	
	@Override
	public void checkIfBootcampIsActive(int state) {
		if(state==2)
			throw new BusinessException(Messages.BootcampActiveException);
	}
	

}
