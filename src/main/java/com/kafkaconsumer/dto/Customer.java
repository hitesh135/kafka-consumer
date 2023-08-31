package com.kafkaconsumer.dto;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
public class Customer implements Serializable {
    private static final long serialVersionUID = -2454508986274706098L;

    private Long id;
    private String name;
    private String email;
    private String contactNo;
}
