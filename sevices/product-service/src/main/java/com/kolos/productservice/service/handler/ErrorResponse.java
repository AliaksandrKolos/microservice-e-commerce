package com.kolos.productservice.service.handler;

import java.util.Map;

public record ErrorResponse(
        Map<String, String> errors
) {
}
