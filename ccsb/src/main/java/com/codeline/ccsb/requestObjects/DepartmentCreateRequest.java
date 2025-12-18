package com.codeline.ccsb.requestObjects;

import com.codeline.ccsb.entities.Department;
import com.codeline.ccsb.helper.Constants;
import com.codeline.ccsb.helper.HelperUtils;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentCreateRequest {
    private String departmentName;
    private List<Integer> instructorsId;
    private List<Integer> courseId;

    public static Department convertToDepartment(DepartmentCreateRequest request) {
        Department department = new Department();
        department.setDepartmentName(request.getDepartmentName());
        return department;
    }

    public static void validCreateDepartmentRequest(DepartmentCreateRequest request) throws Exception {
        if (HelperUtils.isNull(request.getDepartmentName()) || request.getDepartmentName().isEmpty() || request.getDepartmentName().isBlank()) {
            throw new Exception(Constants.Department_CRETE_REQUEST_Department_NAME_NOT_VALID);
        } else if (HelperUtils.isNull(request.getInstructorsId()) || HelperUtils.isListEmpty(request.getInstructorsId())) {
            throw new Exception(Constants.Department_CREATE_REQUEST_INSTRUCTOR_ID_NOT_VALID);
        }
    }
}
