package com.supermarket.billing.controller;

import org.springframework.web.bind.annotation.*;
import java.io.IOException;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/backup")
public class BackupController {

    @GetMapping
    public String backupDatabase() throws IOException {

        String command =
                "C:\\xampp\\mysql\\bin\\mysqldump -u root supermarket > C:\\backup.sql";

        Runtime.getRuntime().exec(new String[]{"cmd.exe", "/c", command});

        return "Backup Created Successfully";
    }
}