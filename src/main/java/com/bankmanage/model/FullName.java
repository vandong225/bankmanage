package com.bankmanage.model;
import lombok.Data;
import lombok.RequiredArgsConstructor;
@Data
@RequiredArgsConstructor
public class FullName {
    private String firstName;
    private String midName;
    private String lastName;
}
