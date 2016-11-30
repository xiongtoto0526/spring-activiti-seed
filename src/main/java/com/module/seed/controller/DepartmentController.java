package com.module.seed.controller;

import com.module.seed.controller.response.CommonResponse;
import com.module.seed.controller.response.ErrorCode;
import com.module.seed.service.DepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DepartmentController {

    private static final Logger logger = LoggerFactory.getLogger(DepartmentController.class);

    @Autowired
    DepartmentService departmentService;

    @RequestMapping(value = "/apis/departments",method = RequestMethod.GET)
    public ResponseEntity<?> getAllDepartment(){
        logger.info("begin getAllDepartment...");
        return ResponseEntity.ok("success");
    }


}
