package com.emeint.vetclinic.system.Constants;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter
public class AppConstants {

    @Value("${image.storage.directory:images}") // Default folder: resources/images
    private String imageDirectory;

}
