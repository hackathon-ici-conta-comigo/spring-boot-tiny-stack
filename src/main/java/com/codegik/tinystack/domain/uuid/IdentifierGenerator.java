package com.codegik.tinystack.domain.uuid;

import java.util.UUID;

public final class IdentifierGenerator {

    public static final String generate() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
}
