package com.techm.ms.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.techm.ms.model.User;
import com.techm.ms.model.swagger.AccountResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


/**
 * This is the Interface definition for User Service
 */
@Api("user")
@Path("/user")
@Produces({MediaType.APPLICATION_JSON})
@RestController
public interface UserResource {
	/**
     * Service definition which returns user for given userID
     * @return User - Returns the details of the user being queried
     */
	@Produces({MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_JSON})
	@ApiOperation(
			value = "Get User Resource",
			notes = "Returns user for given userID representation format",
			response = User.class)
	@ApiResponses(
			value = {
					@ApiResponse(code = 200, message = "OK"),
					@ApiResponse(code = 400, message = "BAD REQUEST"),		
					@ApiResponse(code = 404, message = "NOT_FOUND")		
					})
	 @RequestMapping(value = "/user/{userID}", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<User> getUser(@PathVariable String userID);
	
	/**
     * Service definition which creates the user for given user object
     * @return User - Created Status
     */
	@Produces({MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_JSON})
	@ApiOperation(
			value = "Create user Resource",
			notes = "Returns all the accounts in ResourceCollection representation format",
			response = AccountResponse.class)
	@ApiResponses(
			value = {
					@ApiResponse(code = 201, message = "CREATED"),
					@ApiResponse(code = 409, message = "CONFLICTED")					
					})
	 @RequestMapping(value = "/user", method = RequestMethod.POST)
	   public @ResponseBody ResponseEntity<User> createUser(@RequestBody User user);

}