package com.worldql.client;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.worldql.client.types.server_bound.HandshakeRequest;
import com.worldql.client.types.server_bound.ServerMessage;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.msgpack.jackson.dataformat.MessagePackFactory;

import java.net.URI;
import java.net.URISyntaxException;
import java.nio.ByteBuffer;
import java.util.UUID;

public class Client {
    @NotNull
    static final ObjectMapper mapper = new ObjectMapper(new MessagePackFactory());

    @NotNull
    private final URI url;

    @Nullable
    private final String auth;

    // region: Connection Struct
    private record Connection(
        @NotNull
        UUID uuid,

        @NotNull
        WebSocketClient ws,

        @Nullable
        String token
    ) {}

    @Nullable
    private Connection connection;
    // endregion

    // region: Constructors
    public Client(final @NotNull String url, final @Nullable String auth, final boolean autoconnect) throws URISyntaxException, Exception {
        this.url = new URI(url);
        this.auth = auth;

        if (autoconnect) this.connect();
    }

    public Client(final @NotNull String url, final @Nullable String auth) throws URISyntaxException {
        this.url = new URI(url);
        this.auth = auth;
    }

    public Client(final @NotNull String url) throws URISyntaxException {
        this.url = new URI(url);
        this.auth = null;
    }
    // endregion

    // region: Lifecycle
    public void connect() throws Exception {
        if (this.connection != null) {
            // TODO: Strongly type exception
            throw new Exception("cannot connect if already connected");
        }

        UUID uuid = UUID.randomUUID();
        WebSocketClient ws = new WebSocketClient(this.url) {
            @Override
            public void onOpen(ServerHandshake serverHandshake) {
                try {
                    Client.this.onOpen();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onMessage(String s) {
                // Ignore string messages
            }

            @Override
            public void onMessage(ByteBuffer bytes) {
                // TODO: Process messages
            }

            @Override
            public void onClose(int i, String s, boolean b) {

            }

            @Override
            public void onError(Exception e) {

            }
        };

        this.connection = new Connection(uuid, ws, null);
        ws.connectBlocking();
    }

    public void disconnect() {
        if (this.connection != null) {
            this.connection.ws.close();
        }

        this.connection = null;
    }
    // endregion

    // region: WebSocket Handlers
    private void onOpen() throws Exception {
        if (this.connection == null) {
            // TODO: Strongly type exception
            throw new Exception("onOpen called with no connection");
        }

        HandshakeRequest payload = new HandshakeRequest(this.auth);
        ServerMessage message = new ServerMessage(this.connection.uuid, "", payload);

        byte[] encoded = mapper.writeValueAsBytes(message);
        this.connection.ws.send(encoded);
    }
    // endregion

    // region: Public Methods
    // TODO
    // endregion
}
