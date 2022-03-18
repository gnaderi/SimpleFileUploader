package com.naderi.sfu.controller;

import com.naderi.sfu.entity.FileBag;
import com.naderi.sfu.exception.StoreFileNotFoundException;
import com.naderi.sfu.service.FileStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Controller
public class FileUploadController {
    @Autowired
    private FileStoreService fileStoreService;


    @GetMapping("/")
    public String listUploadedFiles(Model model) throws IOException {
        Stream<FileBag> files = fileStoreService.findAll().stream();
        model.addAttribute("files", files.map(path -> MvcUriComponentsBuilder.fromMethodName(FileUploadController.class,
                "loadFile", path.getFileName()).build().toString()).collect(Collectors.toList()));
        return "uploadForm";
    }

    @GetMapping("/files/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> loadFile(@PathVariable String filename) throws IOException {

        FileBag fileBag = fileStoreService.findByName(filename);
        InputStreamResource content = new InputStreamResource(new ByteArrayInputStream(fileBag.getContent()));
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + fileBag.getFileName() + "\"").body(content);
    }

    @PostMapping("/")
    public String upload(@RequestParam("file") MultipartFile file,
                         RedirectAttributes redirectAttributes) throws IOException {

        FileBag fileBag = new FileBag(file.getOriginalFilename(), file.getContentType(), new Date(), new Date(), file.getBytes());
        FileBag savedFileBag = fileStoreService.save(fileBag);
        redirectAttributes.addFlashAttribute("message", "You successfully uploaded !");

        return "redirect:/";
    }

    @ExceptionHandler(StoreFileNotFoundException.class)
    public ResponseEntity<?> handleStorageFileNotFound(StoreFileNotFoundException exc) {
        return ResponseEntity.notFound().build();
    }

}
