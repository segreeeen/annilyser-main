package com.nullwert.annilyser.main.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Meta {
    private Meta clazz;
    private Meta team;
    private Meta player;
}
