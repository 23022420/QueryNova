package com.aisqlassistant.service;

import org.springframework.stereotype.Service;

@Service
public class ExportService {

    public String exportPDF() {

        return "PDF Export Successful";

    }

    public String exportExcel() {

        return "Excel Export Successful";

    }

}