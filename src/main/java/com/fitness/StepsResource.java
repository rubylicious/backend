/**
 * Copyright 2016 Google Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.fitness;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.fitness.model.ISteps;
import com.fitness.repository.StepsRepository;

@Path("steps")//

public class StepsResource{
	
	@GET 
	@Produces(MediaType.APPLICATION_JSON)
	@Path("test")
	public List<ISteps> getSteps(){
		return StepsRepository.findStepsPerMonth("567");
	}
	
	@GET 
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{monthYear}")
	public List<ISteps> getSteps(@PathParam("monthYear") String monthYear){
		
		return StepsRepository.findStepsPerMonth(monthYear);
	}

	@POST
	@Path("submit")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<ISteps> submitSteps(ArrayList<ISteps> stepsList){
		System.out.println(stepsList);
		return stepsList;
		
	}
  
}
