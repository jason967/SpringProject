package com.jaewoong.sample;

import lombok.Data;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Data
public class Restaurant {
    @Setter(onMethod = @__({@Autowired}))
    private Chef chef;
}
