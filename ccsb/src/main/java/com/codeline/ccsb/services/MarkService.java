package com.codeline.ccsb.services;

import com.codeline.ccsb.entities.Course;
import com.codeline.ccsb.entities.Mark;
import com.codeline.ccsb.helper.Constants;
import com.codeline.ccsb.helper.HelperUtils;
import com.codeline.ccsb.repositories.CourseRepository;
import com.codeline.ccsb.repositories.MarkRepository;
import com.codeline.ccsb.requestObjects.MarkCreateRequest;
import com.codeline.ccsb.responseObjects.MarkCreateResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class MarkService {
    @Autowired
    MarkRepository markRepository;

    @Autowired
    CourseRepository courseRepository;

    public List<Mark> getAllMarks() {
        return markRepository.findAll();
    }

    public MarkCreateResponse saveMarks(MarkCreateRequest request) throws Exception {
        Mark mark = MarkCreateRequest.convertToMark(request);
        mark.setCreatedDate(new Date());
        mark.setIsActive(Boolean.TRUE);

//        Course course = courseRepository.getCourseById(request.getCourseId());
//        if (HelperUtils.isNotNull(course)) {
//            mark.setCourse(course);
//        } else {
//            throw new Exception(Constants.MARK_CREATE_REQUEST_COURSE_ID_NOT_VALID);
//        }

        return MarkCreateResponse.convertToMarkResponse(markRepository.save(mark));
    }

    public Mark updateMarks(Mark mark) throws Exception {
        Mark existingMark = markRepository.findById(mark.getId()).get();
        if (existingMark != null && existingMark.getIsActive()) {
            mark.setUpdatedDate(new Date());
            return markRepository.save(mark);
        } else {
            throw new Exception("Bad Request");
        }
    }

    public void deleteMarks(Integer id) throws Exception {
        Mark existingMark = markRepository.findById(id).get();
        if (existingMark != null && existingMark.getIsActive()) {
            existingMark.setUpdatedDate(new Date());
            existingMark.setIsActive(Boolean.FALSE);
            markRepository.save(existingMark);
        } else {
            throw new Exception("Bad Request");
        }
    }

    public Mark getMarksById(Integer id) throws Exception {
        Mark existingMark = markRepository.findById(id).get();
        if (existingMark != null && existingMark.getIsActive()) {
            return existingMark;
        } else {
            throw new Exception("Bad Request");
        }
    }
}
