package com.ghackk.assignment.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
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
public class WebtoonsDto implements Serializable {

    public static final long serialVersionUID = 37883489342323L;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String id;
    private String title;
    private String descriptions;
    private String characters;

}

