package com.codeline.ccsb.controllers;

import com.codeline.ccsb.entities.PhoneNumber;
import com.codeline.ccsb.requestObjects.PhoneNumberCreateRequest;
import com.codeline.ccsb.responseObjects.PhoneNumberCreateResponse;
import com.codeline.ccsb.services.PhoneNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("phoneNumbers")
public class PhoneNumberController {
    @Autowired
    PhoneNumberService phoneNumberService;

    @PostMapping("create")
    public PhoneNumberCreateResponse createPhoneNumber(@RequestBody PhoneNumberCreateRequest request) throws Exception {
        PhoneNumberCreateRequest.validCreatePhoneNumberRequest(request);
        return phoneNumberService.savePhoneNumber(request);
    }

    @GetMapping("getAll")
    public List<PhoneNumber> getAllPhoneNumber() {
        List<PhoneNumber> phoneNumberList = phoneNumberService.gitAllPhoneNumbers();
        return phoneNumberList;
    }

    @GetMapping("getById")
    public PhoneNumber getPhoneNumber(@RequestParam int id) throws Exception {
        return phoneNumberService.getPhoneNumberById(id);
    }

    @PutMapping("update")
    public PhoneNumber updatePhoneNumber(@RequestBody PhoneNumber updateObjFromUser) throws Exception {
        return phoneNumberService.updatePhoneNumber(updateObjFromUser);
    }

    @DeleteMapping("delete/{id}")
    public String deletePhoneNumber(@PathVariable int id) throws Exception {
        phoneNumberService.deletePhoneNumber(id);
        return "SUCCESS";
    }
}
