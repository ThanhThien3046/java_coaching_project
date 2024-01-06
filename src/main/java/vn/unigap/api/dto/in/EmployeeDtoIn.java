package vn.unigap.api.dto.in;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
public class EmployeeDtoIn {
    private String email;
    private String name;
    private Integer province;
    private String description;
}
