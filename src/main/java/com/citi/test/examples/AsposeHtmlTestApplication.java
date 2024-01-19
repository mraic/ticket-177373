package com.citi.test.examples;

import com.aspose.html.HTMLDocument;
import com.aspose.html.drawing.Margin;
import com.aspose.html.drawing.Page;
import com.aspose.html.saving.PdfSaveOptions;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.stream.Collectors;

@SpringBootApplication
public class AsposeHtmlTestApplication {

    private static final String cssFileDir = "mle_mc_styles.css";
    private static final String htmlfileDir = "index.html";
    private static final String htmlWithCssfileDir = "hello1.html";
    private static final String outputPDF = "mle_mc_styles.css";

    public static void main(String[] args) throws IOException {

        SpringApplication.run(AsposeHtmlTestApplication.class, args);

        String finalPDFDir = "N/A";
        HTMLDocument document = new HTMLDocument(htmlWithCssfileDir);

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


        InputStream in = new FileInputStream(htmlfileDir);
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        String line = reader.lines().collect(Collectors.joining());
        Document doc = Jsoup.parse(line);
        Path path = Paths
                .get(cssFileDir);
        document = new HTMLDocument(doc.html(), path.toString()); // doc.html(), path.getParent().toString()
        com.aspose.html.dom.Element link = document.createElement("link");
        link.setAttribute("rel", "stylesheet");
        link.setAttribute("href", path.toUri().toString());
        com.aspose.html.dom.Element head = document.getElementsByTagName("head").get_Item(0);
        head.appendChild(link);
        options = new PdfSaveOptions();
        options.getPageSetup()
                .setAnyPage(new Page(new com.aspose.html.drawing.Size(com.aspose.html.drawing.Length.fromInches(11.69),
                        com.aspose.html.drawing.Length.fromInches(8.26)), new Margin(0, 0, 0, 0)));
        options.getPageSetup().setAdjustToWidestPage(true);

        System.out.println("Done");


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

    }
}

