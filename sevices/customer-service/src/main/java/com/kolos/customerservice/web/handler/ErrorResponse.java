package com.kolos.customerservice.web.handler;

import java.util.Map;

public record ErrorResponse(
        Map<String, String> errors
) {
}
