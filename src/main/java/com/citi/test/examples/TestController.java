/*
package com.citi.test.examples;

import com.aspose.html.drawing.Margin;
import com.aspose.html.drawing.Page;
import com.aspose.html.saving.PdfSaveOptions;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.stream.Collectors;


@RestController
public class TestController {
    */
/*windows
    private static final String cssFileDir = "mle_mc_styles.css";
    private static final String htmlfileDir = "index.html";
    private static final String htmlWithCssfileDir = "hello1.html";
    private static final String outputPDF = "Output.pdf";
    *//*



    */
/*Linux

import org.springframework.web.bind.annotation.GetMapping;

private static final String cssFileDir = "mle_mc_styles.css";
    private static final String htmlfileDir = "index.html";
    private static final String htmlWithCssfileDir = "hello1.html";
    private static final String outputPDF = "mle_mc_styles.css";


    @GetMapping("/")
    public String suggestion() throws IOException, URISyntaxException {
        String finalPDFDir = "N/A";
        com.aspose.html.HTMLDocument document = new com.aspose.html.HTMLDocument(htmlWithCssfileDir); //
        PdfSaveOptions options = new PdfSaveOptions();
        options.getPageSetup()
                .setAnyPage(new Page(new com.aspose.html.drawing.Size(com.aspose.html.drawing.Length.fromInches(11.69),
                        com.aspose.html.drawing.Length.fromInches(8.26)), new Margin(0, 0, 0, 0)));
        options.getPageSetup().setAdjustToWidestPage(true);

        try (MemoryStreamProvider streamProvider = new MemoryStreamProvider()) {
            com.aspose.html.converters.Converter.convertHTML(document, options, streamProvider.lStream);
            java.io.InputStream memory = streamProvider.lStream.get(0);
            memory.reset();
            byte biyes[] = memory.readAllBytes();
            finalPDFDir = outputPDF
                    + new SimpleDateFormat("dd-MMM-yyyy_HH-mm-ss").format(new Date()) + ".pdf";
            try (FileOutputStream fos = new FileOutputStream(finalPDFDir)) {
                fos.write(biyes);
            }
        }
        return "Suggested implementation - The final pdf is in this directory:" + finalPDFDir;
    }


    @GetMapping("/aspose")
    public String aspose() throws IOException {
        String finalPDFDir = "N/A";
        InputStream in = new FileInputStream(htmlfileDir);
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        String line = reader.lines().collect(Collectors.joining());
        Document doc = Jsoup.parse(line);
        Path path = Paths
                .get(cssFileDir);
        com.aspose.html.HTMLDocument document = new com.aspose.html.HTMLDocument( doc.html(), path.getParent().toString()); // doc.html(), path.getParent().toString()
        com.aspose.html.dom.Element link = document.createElement("link");
        link.setAttribute("rel", "stylesheet");
        link.setAttribute("href", path.toUri().toString());
        com.aspose.html.dom.Element head = document.getElementsByTagName("head").get_Item(0);
        head.appendChild(link);
        PdfSaveOptions options = new PdfSaveOptions();
        options.getPageSetup()
                .setAnyPage(new Page(new com.aspose.html.drawing.Size(com.aspose.html.drawing.Length.fromInches(11.69),
                        com.aspose.html.drawing.Length.fromInches(8.26)), new Margin(0, 0, 0, 0)));
        options.getPageSetup().setAdjustToWidestPage(true);

        try (MemoryStreamProvider streamProvider = new MemoryStreamProvider()) {
            com.aspose.html.converters.Converter.convertHTML(document, options, streamProvider.lStream);
            java.io.InputStream memory = streamProvider.lStream.get(0);
            memory.reset();
            byte biyes[] = memory.readAllBytes();
            finalPDFDir = outputPDF
                    + new SimpleDateFormat("dd-MMM-yyyy_HH-mm-ss").format(new Date()) + ".pdf";
            try (FileOutputStream fos = new FileOutputStream(finalPDFDir)) {
                fos.write(biyes);
            }
        }
        return " We need similar config citi - The final pdf is in this directory:" + finalPDFDir;
    }

}
*/
