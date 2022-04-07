package uz.coder24.redislearning.model;


import lombok.Data;

import java.io.Serializable;

@Data

public class User  implements Serializable {

    private Long id;
    private String name;
    private String phone;
    private Integer age;

}
