package com.nullwert.annilyser.main.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;

@Data
public class Meta {

    @Getter(AccessLevel.NONE)
    private BaseMeta clazz;
    private BaseMeta team;
    private BaseMeta player;

    @JsonProperty("class")
    public BaseMeta getClazz() {
        return clazz;
    }
}
