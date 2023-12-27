package com.example.WoofBackend_Develop.ceo.service;


import com.example.WoofBackend_Develop.ceo.model.Ceo;
import com.example.WoofBackend_Develop.ceo.model.request.PostCreateCeoReq;
import com.example.WoofBackend_Develop.ceo.model.response.PostCreateCeoRes;
import com.example.WoofBackend_Develop.ceo.repository.CeoRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CeoService {

    @Value("${project.upload.path}")
    private String uploadPath;

    private CeoRepo ceoRepo;

    public CeoService(String uploadPath, CeoRepo ceoRepo) {
        this.uploadPath = uploadPath;
        this.ceoRepo = ceoRepo;
    }

    public String makeFolder() {
        String str = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
        String folderPath = str.replace("/", File.separator);
        File uploadPathFolder = new File(uploadPath, folderPath);
        if (uploadPathFolder.exists() == false) {
            uploadPathFolder.mkdirs();
        }

        return folderPath;
    }

    public String saveFile(MultipartFile file) {
        String originalName = file.getOriginalFilename();
        String folderPath = makeFolder();
        String uuid = UUID.randomUUID().toString();
        String saveFileName = folderPath + File.separator + uuid + "_" + originalName;
        File saveFile = new File(uploadPath, saveFileName);

        return saveFileName;

    }


    // 회원가입(upload 프로젝트 참고)
    public PostCreateCeoRes create(PostCreateCeoReq postCreateCeoReq) {

        String saveFileName = saveFile(postCreateCeoReq.getImage());


        Ceo ceo = Ceo.builder()
                .email(postCreateCeoReq.getEmail())
                .password(postCreateCeoReq.getPassword())
                .name(postCreateCeoReq.getName())
                .image(saveFileName.replace(File.separator, "/"))
                .build();

        Ceo result = ceoRepo.save(ceo);

         PostCreateCeoRes response = PostCreateCeoRes.builder()
                .id(result.getId())
                .name(result.getName())
                .image(result.getImage())
                .build();

         return response;


    }

    public void read(Long id) {
        ceoRepo.findById(id);

    }




}
