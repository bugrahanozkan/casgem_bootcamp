package com.kodlamaio.bootcampProject.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.kodlamaio.bootcampProject.business.abstracts.InstructorService;
import com.kodlamaio.bootcampProject.business.constants.Messages;
import com.kodlamaio.bootcampProject.business.request.instructor.CreateInstructorRequest;
import com.kodlamaio.bootcampProject.business.request.instructor.GetInstructorRequest;
import com.kodlamaio.bootcampProject.business.request.instructor.UpdateInstructorRequest;
import com.kodlamaio.bootcampProject.business.response.instructor.CreateInstructorResponse;
import com.kodlamaio.bootcampProject.business.response.instructor.GetAllInstructorResponse;
import com.kodlamaio.bootcampProject.business.response.instructor.GetInstructorResponse;
import com.kodlamaio.bootcampProject.business.response.instructor.UpdateInstructorResponse;
import com.kodlamaio.bootcampProject.core.utilities.exceptions.BusinessException;
import com.kodlamaio.bootcampProject.core.utilities.mapper.ModelMapperService;
import com.kodlamaio.bootcampProject.core.utilities.results.DataResult;
import com.kodlamaio.bootcampProject.core.utilities.results.Result;
import com.kodlamaio.bootcampProject.core.utilities.results.SuccessDataResult;
import com.kodlamaio.bootcampProject.core.utilities.results.SuccessResult;
import com.kodlamaio.bootcampProject.dataAccess.InstructorRepository;
import com.kodlamaio.bootcampProject.entities.Instructor;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class InstructorManager implements InstructorService {

	private InstructorRepository instructorRepository;
	private ModelMapperService mapperService;

	@Override
	public DataResult<List<GetAllInstructorResponse>> getAll() {
		List<Instructor> instructors = this.instructorRepository.findAll();
		List<GetAllInstructorResponse> response = instructors.stream()
				.map(instructor -> this.mapperService.forResponse().map(instructor, GetAllInstructorResponse.class))
				.collect(Collectors.toList());
		return new SuccessDataResult<List<GetAllInstructorResponse>>(response, Messages.InstructorGetAll);
	}

	@Override
	public DataResult<CreateInstructorResponse> add(CreateInstructorRequest createInstructorRequest) {// requestden// geleni önce// instructora// çevirdik/ sonra// response// çevirdik
																																																																																											
		checkIfInstructorExistsByNationalIdendity(createInstructorRequest.getNationalIdendity());

		Instructor instructor = this.mapperService.forRequest().map(createInstructorRequest, Instructor.class);

		this.instructorRepository.save(instructor);

		CreateInstructorResponse createInstructorResponse = this.mapperService.forResponse().map(instructor,
				CreateInstructorResponse.class);

		return new SuccessDataResult<CreateInstructorResponse>(createInstructorResponse, Messages.InstructorCreated);
	}


	@Override
	public DataResult<List<GetAllInstructorResponse>> findByName(GetInstructorRequest request) {
		List<Instructor> instructors = instructorRepository.findByFirstName(request.getFirstName());
		
		List<GetAllInstructorResponse> response=  instructors
				.stream()
				.map(i-> mapperService.forResponse().map(i, GetAllInstructorResponse.class))
				.collect(Collectors.toList());
		
		return new SuccessDataResult<List<GetAllInstructorResponse>>(response, "findByName");
	}
	
	@Override
	public DataResult<GetInstructorResponse> getById(int id) {

		checkIfInstructorExistsById(id);

		Instructor instructor = this.instructorRepository.getInstructorById(id);// repository ile veritabanındaki id'yi bulup bize veriyor. verdiği değeri instructor nesnesine çevirdi.
																				
		GetInstructorResponse response = this.mapperService.forResponse().map(instructor, GetInstructorResponse.class);// instructor nesnesini aldık ve mapper yardımıyla GetInstructorRespons sınıfına çevirdik ve response değişkenine atadık.
																									
		return new SuccessDataResult<GetInstructorResponse>(response);// response fieldını result kullanarak dahaokunaklı,anlaşılır olması için döndürdük.
																	
	}

	@Override
	public Result deleteInstructorById(int id) {

		checkIfInstructorExistsById(id);

		this.instructorRepository.deleteById(id);

		return new SuccessResult(Messages.InstructorDeleted);
	}

	@Override
	public DataResult<UpdateInstructorResponse> updateInstructorById(UpdateInstructorRequest updateInstructorRequest) {

		checkIfInstructorExistsById(updateInstructorRequest.getId());

		Instructor instructor = this.mapperService.forRequest().map(updateInstructorRequest, Instructor.class);

		checkIfInstructorExistsByNationalIdendity(updateInstructorRequest.getNationalIdendity());

		this.instructorRepository.save(instructor);

		UpdateInstructorResponse updateInstructorResponse = this.mapperService.forResponse().map(instructor,
				UpdateInstructorResponse.class);

		return new SuccessDataResult<UpdateInstructorResponse>(updateInstructorResponse, Messages.InstructorUptaded);
	}

	private void checkIfInstructorExistsByNationalIdendity(String nationalIdendity) {
		Instructor instructor = this.instructorRepository.findInstructorByNationalIdendity(nationalIdendity);
		if (instructor != null) {
			throw new BusinessException(Messages.InstructorNationalError);
		}
	}

	private void checkIfInstructorExistsById(int id) {
		Instructor instructor = this.instructorRepository.findById(id).orElse(null);
		if (instructor == null) {
			throw new BusinessException(Messages.InstructorNotId);
		}

	}

}
