package vn.unigap.api.dto.out;

import lombok.*;
import vn.unigap.api.entity.Employee;

@Data
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDtoOut {
    private long id;
    private String email;
    private String name;
    private Integer province;
    private String description;

    public static EmployeeDtoOut from(Employee e) {
        return EmployeeDtoOut.builder()
                .id(e.getId())
                .email(e.getEmail())
                .name(e.getName())
                .province(e.getProvince())
                .description(e.getDescription())
                .build();
    }
}
