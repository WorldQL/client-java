package com.worldql.client.serialization;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import org.jetbrains.annotations.Nullable;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.UUID;

public class BinaryUUID {
    private static UUID asUuid(byte[] bytes) {
        ByteBuffer bb = ByteBuffer.wrap(bytes);

        long firstLong = bb.getLong();
        long secondLong = bb.getLong();

        return new UUID(firstLong, secondLong);
    }

    private static byte[] asBytes(UUID uuid) {
        ByteBuffer bb = ByteBuffer.wrap(new byte[16]);

        bb.putLong(uuid.getMostSignificantBits());
        bb.putLong(uuid.getLeastSignificantBits());

        return bb.array();
    }

    public static class UUIDSerializer extends StdSerializer<UUID> {
        public UUIDSerializer() {
            this(null);
        }

        public UUIDSerializer(final @Nullable Class<UUID> c) {
            super(c);
        }

        @Override
        public void serialize(UUID uuid, JsonGenerator json, SerializerProvider se) throws IOException {
            byte[] bytes = asBytes(uuid);
            json.writeBinary(bytes);
        }
    }

    public static class UUIDDeserializer extends StdDeserializer<UUID> {
        public UUIDDeserializer() {
            this(null);
        }

        public UUIDDeserializer(final @Nullable Class<UUID> c) {
            super(c);
        }

        @Override
        public UUID deserialize(JsonParser json, DeserializationContext de) throws IOException, JsonProcessingException {
            // TODO: Implement
            return null;
        }
    }
}
