package com.bank.demo.Model;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class MessageId implements Serializable {
    private Long ClientId;
    private Long TransactionId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MessageId messageId = (MessageId) o;
        return Objects.equals(ClientId, messageId.ClientId) &&
                Objects.equals(TransactionId, messageId.TransactionId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ClientId, TransactionId);
    }
}
