package com.ghackk.assignment.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author Ankit Khatri
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto implements Serializable {

    public static final long serialVersionUID = 34784378834L;

    private String firstName;
    private String lastName;
    private String email;
    private String password;
}
