package com.example;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GenerateCppFromTemplate {
    public static void main(String[] args) {
        // Configure FreeMarker
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_30);
        try {
            cfg.setDirectoryForTemplateLoading(new File("src/main/resources/templates"));
            cfg.setDefaultEncoding("UTF-8");

            // Load template
            Template template = cfg.getTemplate("template.ftl");

            // Data-model
            Map<String, Object> dataModel = new HashMap<>();
            dataModel.put("className", "Person");
            dataModel.put("fields", List.of(
                new Field("std::string", "name"),
                new Field("int", "age")
            ));

            // Ensure the output directory exists
            File outputDir = new File("output");
            if (!outputDir.exists()) {
                outputDir.mkdirs();
            }

            // Generate output
            FileWriter fileWriter = new FileWriter(new File(outputDir, "Person.h"));
            template.process(dataModel, fileWriter);
            fileWriter.close();

            System.out.println("C++ code generated successfully.");

        } catch (IOException | TemplateException e) {
            e.printStackTrace();
        }
    }

    public static class Field {
        private String type;
        private String name;

        public Field(String type, String name) {
            this.type = type;
            this.name = name;
        }

        public String getType() {
            return type;
        }

        public String getName() {
            return name;
        }
    }
}
