package com.jaewoong.controller;

import lombok.extern.log4j.Log4j;
import net.coobird.thumbnailator.Thumbnailator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@Controller
@Log4j
public class UploadController {

    private boolean checkImage(File file)
    {
        try {
            String contentType = Files.probeContentType(file.toPath());

            return contentType.startsWith("image");
        }catch (IOException e)
        {
            //TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;
    }

    private String getFolder()
    {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        Date date = new Date();

        String str = sdf.format(date);

        return str.replace("-",File.separator);
    }

    @GetMapping("/uploadForm")
    public void uploadForm()
    {
        log.info("upload form");
    }

    @PostMapping("/uploadFormAction")
    public void uploadFormPost(MultipartFile[] uploadFile, Model model)
    {
        log.info("upload IN");
        String uploadFolder = "C:\\Users\\choi\\Desktop\\Project\\upload";

        for (MultipartFile multipartFile : uploadFile)
        {
            log.info("-------------------");
            log.info("Upload File Name: "+multipartFile.getOriginalFilename() );
            log.info("Upload File Size: "+multipartFile.getSize());

            File saveFile = new File(uploadFolder,multipartFile.getOriginalFilename());

            try
            {
                multipartFile.transferTo(saveFile);
            }
            catch (Exception e)
            {
                log.error(e.getMessage());
            }
        }
    }

    @GetMapping("/uploadAjax")
    public void uploadAjax()
    {
        log.info("upload ajax");
    }

    @PostMapping("/uploadAjaxAction")
    public void uploadAjaxPost(MultipartFile[] uploadFile)
    {
        log.info("update ajax post.......");
        String uploadFolder = "C:\\Users\\choi\\Desktop\\Project\\upload";

        File uploadPath = new File(uploadFolder,getFolder());
        log.info("upload path: "+uploadPath);

        if (uploadPath.exists()==false)
        {
            uploadPath.mkdirs();
        }

        for(MultipartFile multipartFile:uploadFile) {
            log.info("Upload File Name: " + multipartFile.getOriginalFilename());
            log.info("Upload File Size: " + multipartFile.getSize());

            String uploadFileName = multipartFile.getOriginalFilename();

            uploadFileName = uploadFileName.substring(uploadFileName.lastIndexOf("\\")+1);
            log.info("only file name: "+uploadFileName);

            UUID uuid = UUID.randomUUID();

            uploadFileName = uuid.toString()+"_"+uploadFileName;



            try
            {
                File saveFile = new File(uploadPath,uploadFileName);
                multipartFile.transferTo(saveFile);
                if(checkImage(saveFile))
                {
                    FileOutputStream thumbnail = new FileOutputStream(new File(uploadPath,"s_"+uploadFileName));
                    Thumbnailator.createThumbnail(multipartFile.getInputStream(),thumbnail,100,100);
                    thumbnail.close();
                }
            }catch (Exception e)
            {
               e.printStackTrace();
            }
        }

    }
}
