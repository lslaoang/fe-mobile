package com.testco.femobile.controller;

import com.testco.femobile.service.VerifyService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("${api.base-path}")
public class MobileController {

    private final VerifyService verifyService;

    public MobileController(VerifyService verifyService) {
        this.verifyService = verifyService;
    }

    @RequestMapping(path = "/verify", method = RequestMethod.GET)
    public String verifyAccount() {
//        try {
//            verifyService.verify();
//        } catch (RuntimeException e) {
//            return "access-denied";
//        }
        return "verified";
    }
}
