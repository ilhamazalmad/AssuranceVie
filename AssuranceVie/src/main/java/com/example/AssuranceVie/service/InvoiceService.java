package com.example.AssuranceVie.service;

import com.example.AssuranceVie.bean.InscriptionAssuranceVieProduitFinancier;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Locale;

@Service
public class InvoiceService {

    // OrderModel is a POJO contains all the data about the Invoice
    // Locale is used to localize the PDF file (French, English...)
    Logger log = LogManager.getLogger(InvoiceService.class);
    // Path to the jrxml template
    private final String invoice_template_path = "/jasper/invoice_template.jrxml";
    public void generateInvoiceFor(InscriptionAssuranceVieProduitFinancier iavpf, Locale locale) throws IOException {

        // Create a temporary PDF file
        File pdfFile = File.createTempFile("my-invoice", ".pdf");

        // Initiate a FileOutputStream
        try(FileOutputStream pos = new FileOutputStream(pdfFile))
        {
            // We will generate PDF here
        }
        catch (final Exception e)
        {
            log.error(String.format("An error occured during PDF creation: %s", e));
        }

    }

    // Load invoice jrxml template

}