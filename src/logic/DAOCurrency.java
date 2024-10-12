package logic;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DAOCurrency(
        String result,
        @JsonProperty("conversion_rates") Map<String, Double> conversion_rates
) {}