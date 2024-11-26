package com.kolos.orderservice.service.handler;

import java.util.Map;

public record ErrorResponse(
        Map<String, String> errors
) {
}
