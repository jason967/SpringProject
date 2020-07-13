package com.jaewoong.controller;

import com.jaewoong.domain.AttachFileDTO;
import lombok.Data;
import lombok.extern.log4j.Log4j;
import net.coobird.thumbnailator.Thumbnailator;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.print.attribute.standard.Media;
import java.awt.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller
@Log4j
@Data
public class UploadController {

    @GetMapping("/display")
    @ResponseBody
    public ResponseEntity<byte[]> getFile(String fileName)
    {
        log.info("fileName: "+fileName);

        File file = new File("C:\\Users\\choi\\Desktop\\Project\\upload"+fileName);
        log.info("file: " + file);

        ResponseEntity<byte[]> result = null;

        try
        {
            HttpHeaders headers =new HttpHeaders();

            headers.add("Content-Type",Files.probeContentType(file.toPath()));
            result=new ResponseEntity<>(FileCopyUtils.copyToByteArray(file),headers,HttpStatus.OK);
        }catch (IOException e)
        {
            e.printStackTrace();
        }
        return result;
    }

    private boolean checkImageType(File file)
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

    @PostMapping(value = "/uploadAjaxAction",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseEntity<List<AttachFileDTO>> uploadAjaxPost(MultipartFile[] uploadFile)
    {
        log.info("update ajax post.......");
        List<AttachFileDTO> list = new ArrayList<>();
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
            AttachFileDTO attachDTO = new AttachFileDTO();

            uploadFileName = uploadFileName.substring(uploadFileName.lastIndexOf("\\")+1);
            log.info("only file name: "+uploadFileName);

            attachDTO.setFileName(uploadFileName);

            UUID uuid = UUID.randomUUID();

            uploadFileName = uuid.toString()+"_"+uploadFileName;

            try
            {
                File saveFile = new File(uploadPath,uploadFileName);
                multipartFile.transferTo(saveFile);

                attachDTO.setUuid(uuid.toString());
                attachDTO.setUploadPath(uploadFileName);

                if(checkImageType(saveFile))
                {
                    attachDTO.setImage(true);
                    FileOutputStream thumbnail = new FileOutputStream(new File(uploadPath,"s_"+uploadFileName));
                    Thumbnailator.createThumbnail(multipartFile.getInputStream(),thumbnail,100,100);
                    thumbnail.close();
                }
                list.add(attachDTO);
            }catch (Exception e)
            {
               e.printStackTrace();
            }
        }
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}
