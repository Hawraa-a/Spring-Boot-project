package com.codeline.ccsb.controllers;

import com.codeline.ccsb.entities.Address;
import com.codeline.ccsb.requestObjects.AddressCreateRequest;
import com.codeline.ccsb.responseObjects.AddressCreateResponse;
import com.codeline.ccsb.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("Address")
public class AddressController {
    @Autowired
    AddressService addressService;

    @PostMapping("create")
    public AddressCreateResponse createAddress(@RequestBody AddressCreateRequest requestObj) throws Exception {
        AddressCreateRequest.validCreateAddressRequest(requestObj);
        return addressService.saveAddress(requestObj);
    }

    @PutMapping("update")
    public Address updateAddress(@RequestBody Address updateObjFromUser) throws Exception {
        return addressService.updateAddress(updateObjFromUser);
    }
}
