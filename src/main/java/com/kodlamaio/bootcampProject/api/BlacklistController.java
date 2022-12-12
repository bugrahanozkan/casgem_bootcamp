package com.kodlamaio.bootcampProject.api;

import java.util.List;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.kodlamaio.bootcampProject.business.abstracts.BlacklistService;
import com.kodlamaio.bootcampProject.business.request.blacklist.CreateBlacklistRequest;
import com.kodlamaio.bootcampProject.business.request.blacklist.UpdateBlacklistRequest;
import com.kodlamaio.bootcampProject.business.response.blacklist.CreateBlacklistResponse;
import com.kodlamaio.bootcampProject.business.response.blacklist.GetAllBlacklistResponse;
import com.kodlamaio.bootcampProject.business.response.blacklist.GetBlacklistResponse;
import com.kodlamaio.bootcampProject.business.response.blacklist.UpdateBlacklistResponse;
import com.kodlamaio.bootcampProject.core.utilities.results.DataResult;
import com.kodlamaio.bootcampProject.core.utilities.results.Result;

import lombok.AllArgsConstructor;

@RequestMapping("/api/v2/blacklists")
@RestController
@AllArgsConstructor
public class BlacklistController {

	private final BlacklistService blacklistService;

	@GetMapping("/getAll")
	public DataResult<List<GetAllBlacklistResponse>> getAll() {
		return blacklistService.getAll();
	}
	@GetMapping("getById/{id}")
	public DataResult<GetBlacklistResponse> getById(@PathVariable int id){
		return blacklistService.getById(id);
	}
	
	@PostMapping("/add")
	public DataResult<CreateBlacklistResponse> add(@Valid @RequestBody  CreateBlacklistRequest request){
		return blacklistService.add(request);
	}
	
	@PutMapping("/update")
 DataResult<UpdateBlacklistResponse> update(@Valid @RequestBody UpdateBlacklistRequest request){
		return blacklistService.update(request);
	}
	@DeleteMapping("/deleteById/{id}")
	Result delete(@PathVariable int id) {
		return blacklistService.delete(id);
	}
}
