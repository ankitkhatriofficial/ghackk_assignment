package com.ghackk.assignment.document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Ankit Khatri
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "webtoons")
public class Webtoons implements Serializable {

    private static final long serialVersionUID = 347834734344L;

    @Id
    @Field(value = "_id")
    private ObjectId id;

    private String title;
    private String descriptions;
    private String characters;
    private String userId;

    @CreatedDate
    private Date createdAt;

    @LastModifiedDate
    private Date updatedAt;
}
