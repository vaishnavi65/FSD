package com.cts.iiht.junit;


import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cts.iiht.model.AllProjectDetails;
import com.cts.iiht.model.AllTaskDetails;
import com.cts.iiht.model.ParentTask;
import com.cts.iiht.model.Project;
import com.cts.iiht.model.Users;
import com.cts.iiht.service.ParentTaskService;
import com.cts.iiht.service.ProjectService;
import com.cts.iiht.service.TaskService;
import com.cts.iiht.service.UserService;


public class TestProjectManagerController {

}
