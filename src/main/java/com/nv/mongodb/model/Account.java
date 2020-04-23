package com.nv.mongodb.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;

@Document(collection="accounts")
@JsonIgnoreProperties(value = { "account_id" })
@Data
public class Account {
    @Id
    private String id;
    private String account_id;
    private String limit;
    ArrayList<String> products = new ArrayList<String>();
}