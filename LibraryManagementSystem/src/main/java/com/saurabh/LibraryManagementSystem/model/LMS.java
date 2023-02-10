package com.saurabh.LibraryManagementSystem.model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LMS {
    private String name;
    private String address;
    private int number;
    private int faculties;
}
