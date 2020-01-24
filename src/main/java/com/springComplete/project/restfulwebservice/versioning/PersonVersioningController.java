package com.springComplete.project.restfulwebservice.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonVersioningController {
	
	
	@GetMapping("/person/versionv1")
	public PersonV1 personV1() {		
		return new PersonV1("Rajesh Upadhyay");
		
	}
	@GetMapping("/person/versionv2")
	public PersonV2 personV2() {		
		return new PersonV2(new Name("Rajesh", "Upadhyay"));		
	}
	
	@GetMapping(value ="/person/params", params="version=1")
	public PersonV1 paramv1() {		
		return new PersonV1("Rajesh Upadhyay");
		
	}
	@GetMapping(value="/person/params", params="version=2")
	public PersonV2 paramv2() {		
		return new PersonV2(new Name("Rajesh", "Upadhyay"));		
	}
	
	@GetMapping(value ="/person/headers", headers="X-api-version=1")
	public PersonV1 headersv1() {		
		return new PersonV1("Rajesh Upadhyay");
		
	}
	@GetMapping(value="/person/headers", headers="X-api-version=2")
	public PersonV2 headersv2() {		
		return new PersonV2(new Name("Rajesh", "Upadhyay"));		
	}
	
	@GetMapping(value ="/person/produces", produces="application/vnd.company.app-v1+json")
	public PersonV1 applicationtypev1() {		
		return new PersonV1("Rajesh Upadhyay");
		
	}
	@GetMapping(value="/person/produces", produces="application/vnd.company.app-v2+json")
	public PersonV2 applicationtypev2() {		
		return new PersonV2(new Name("Rajesh", "Upadhyay"));		
	}
	
	

}
