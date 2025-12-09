package com.codeline.ccsb.controllers;

import com.codeline.ccsb.entities.Mark;
import com.codeline.ccsb.requestObjects.MarkCreateRequest;
import com.codeline.ccsb.responseObjects.MarkCreateResponse;
import com.codeline.ccsb.services.MarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/marks")
public class MarkController {
    @Autowired
    MarkService markService;

    @PostMapping("create")
    public MarkCreateResponse createMarks(@RequestBody MarkCreateRequest requestObj) throws Exception{
        MarkCreateRequest.validCreateMarkRequest(requestObj);
        return markService.saveMarks(requestObj);
    }

    @GetMapping("getAll")
    public List<Mark> getAllMarks() {
        List<Mark> instructorList = markService.getAllMarks();
        return instructorList;
    }

    @GetMapping("getById")
    public Mark getMarks(@RequestParam int id) throws Exception {
        return markService.getMarksById(id);
    }

    @PutMapping("update")
    public Mark updateMarks(@RequestBody Mark updateObjFromUser) throws Exception {
        return markService.updateMarks(updateObjFromUser);
    }

    @DeleteMapping("delete/{id}")
    public String deleteMarks(@PathVariable int id) throws Exception {
        markService.deleteMarks(id);
        return "SUCCESS";
    }
}
