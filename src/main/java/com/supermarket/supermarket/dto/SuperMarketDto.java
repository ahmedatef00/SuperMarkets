package com.supermarket.supermarket.dto;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Data
public class SuperMarketDto {
    private Long id;
    private String ar_name;
    private String en_name;
    private String address;
    private String image;
    private boolean active;

    public String getActive() {
        if (active == false) {
            return "NotActivated";
        } else
            return "Activated";
    }
}
