// Code generated by Wire protocol buffer compiler, do not edit.
// Source file: packets.proto at 7:1
package au.com.codeka.warworlds.common.proto;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.StringBuilder;
import okio.ByteString;

/**
 * Wrapper class for all the packets.
 */
public final class Packet extends Message<Packet, Packet.Builder> {
  public static final ProtoAdapter<Packet> ADAPTER = new ProtoAdapter_Packet();

  private static final long serialVersionUID = 0L;

  @WireField(
      tag = 1,
      adapter = "au.com.codeka.warworlds.common.proto.HelloRequestPacket#ADAPTER"
  )
  public final HelloRequestPacket hello_request;

  @WireField(
      tag = 2,
      adapter = "au.com.codeka.warworlds.common.proto.HelloResponsePacket#ADAPTER"
  )
  public final HelloResponsePacket hello_response;

  public Packet(HelloRequestPacket hello_request, HelloResponsePacket hello_response) {
    this(hello_request, hello_response, ByteString.EMPTY);
  }

  public Packet(HelloRequestPacket hello_request, HelloResponsePacket hello_response, ByteString unknownFields) {
    super(ADAPTER, unknownFields);
    this.hello_request = hello_request;
    this.hello_response = hello_response;
  }

  @Override
  public Builder newBuilder() {
    Builder builder = new Builder();
    builder.hello_request = hello_request;
    builder.hello_response = hello_response;
    builder.addUnknownFields(unknownFields());
    return builder;
  }

  @Override
  public boolean equals(Object other) {
    if (other == this) return true;
    if (!(other instanceof Packet)) return false;
    Packet o = (Packet) other;
    return Internal.equals(unknownFields(), o.unknownFields())
        && Internal.equals(hello_request, o.hello_request)
        && Internal.equals(hello_response, o.hello_response);
  }

  @Override
  public int hashCode() {
    int result = super.hashCode;
    if (result == 0) {
      result = unknownFields().hashCode();
      result = result * 37 + (hello_request != null ? hello_request.hashCode() : 0);
      result = result * 37 + (hello_response != null ? hello_response.hashCode() : 0);
      super.hashCode = result;
    }
    return result;
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    if (hello_request != null) builder.append(", hello_request=").append(hello_request);
    if (hello_response != null) builder.append(", hello_response=").append(hello_response);
    return builder.replace(0, 2, "Packet{").append('}').toString();
  }

  public static final class Builder extends Message.Builder<Packet, Builder> {
    public HelloRequestPacket hello_request;

    public HelloResponsePacket hello_response;

    public Builder() {
    }

    public Builder hello_request(HelloRequestPacket hello_request) {
      this.hello_request = hello_request;
      return this;
    }

    public Builder hello_response(HelloResponsePacket hello_response) {
      this.hello_response = hello_response;
      return this;
    }

    @Override
    public Packet build() {
      return new Packet(hello_request, hello_response, buildUnknownFields());
    }
  }

  private static final class ProtoAdapter_Packet extends ProtoAdapter<Packet> {
    ProtoAdapter_Packet() {
      super(FieldEncoding.LENGTH_DELIMITED, Packet.class);
    }

    @Override
    public int encodedSize(Packet value) {
      return (value.hello_request != null ? HelloRequestPacket.ADAPTER.encodedSizeWithTag(1, value.hello_request) : 0)
          + (value.hello_response != null ? HelloResponsePacket.ADAPTER.encodedSizeWithTag(2, value.hello_response) : 0)
          + value.unknownFields().size();
    }

    @Override
    public void encode(ProtoWriter writer, Packet value) throws IOException {
      if (value.hello_request != null) HelloRequestPacket.ADAPTER.encodeWithTag(writer, 1, value.hello_request);
      if (value.hello_response != null) HelloResponsePacket.ADAPTER.encodeWithTag(writer, 2, value.hello_response);
      writer.writeBytes(value.unknownFields());
    }

    @Override
    public Packet decode(ProtoReader reader) throws IOException {
      Builder builder = new Builder();
      long token = reader.beginMessage();
      for (int tag; (tag = reader.nextTag()) != -1;) {
        switch (tag) {
          case 1: builder.hello_request(HelloRequestPacket.ADAPTER.decode(reader)); break;
          case 2: builder.hello_response(HelloResponsePacket.ADAPTER.decode(reader)); break;
          default: {
            FieldEncoding fieldEncoding = reader.peekFieldEncoding();
            Object value = fieldEncoding.rawProtoAdapter().decode(reader);
            builder.addUnknownField(tag, fieldEncoding, value);
          }
        }
      }
      reader.endMessage(token);
      return builder.build();
    }

    @Override
    public Packet redact(Packet value) {
      Builder builder = value.newBuilder();
      if (builder.hello_request != null) builder.hello_request = HelloRequestPacket.ADAPTER.redact(builder.hello_request);
      if (builder.hello_response != null) builder.hello_response = HelloResponsePacket.ADAPTER.redact(builder.hello_response);
      builder.clearUnknownFields();
      return builder.build();
    }
  }
}
