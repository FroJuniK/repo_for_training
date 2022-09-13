package ru.otus.dataprocessor;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import ru.otus.model.Measurement;

import java.io.IOException;
import java.util.List;

public class ResourcesFileLoader implements Loader {

    private final ObjectMapper mapper = new ObjectMapper();
    private final String fileName;

    public ResourcesFileLoader(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public List<Measurement> load() {
        //читает файл, парсит и возвращает результат
        try (var input = ResourcesFileLoader.class.getClassLoader().getResourceAsStream(fileName)) {
            mapper.addMixIn(Measurement.class, MeasurementMixIn.class);
            return mapper.readValue(input, new TypeReference<>() {});
        } catch (IOException ex) {
            throw new FileProcessException(ex);
        }
    }

    public static class MeasurementMixIn {
        @JsonCreator
        public MeasurementMixIn(@JsonProperty("name") String name, @JsonProperty("value") double value) {
        }
    }
}
