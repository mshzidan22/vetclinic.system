package com.emeint.vetclinic.system.service;

import com.emeint.vetclinic.system.Constants.AppConstants;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ImageService {
    private final AppConstants appConstants;

    public String saveImage(MultipartFile imageFile) throws IOException {
        String uploadDirectory = appConstants.getImageDirectory(); // Use configured directory
        String uniqueFileName = UUID.randomUUID() + "_" + imageFile.getOriginalFilename();

        Path uploadPath = Path.of(uploadDirectory);
        Path filePath = uploadPath.resolve(uniqueFileName);

        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }

        Files.copy(imageFile.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

        return uniqueFileName;
    }

    public byte[] getImage(String imageName) throws IOException {
        Path imagePath = Path.of(appConstants.getImageDirectory(), imageName);

        if (Files.exists(imagePath)) {
            return Files.readAllBytes(imagePath);
        } else {
            throw new IOException("Image not found: " + imageName);
        }
    }

    public boolean deleteImage(String imageName) throws IOException {
        Path imagePath = Path.of(appConstants.getImageDirectory(), imageName);

        if (Files.exists(imagePath)) {
            Files.delete(imagePath);
            return true;
        } else {
            return false;
        }
    }
}