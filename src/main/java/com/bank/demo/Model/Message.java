package com.bank.demo.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Message implements Serializable {
    @EmbeddedId
    private MessageId id;
    private String objet;
    private String contenu;
    private String etat;
    @MapsId("ClientId")
    @ManyToOne
    private Client client;
    @MapsId("TransactionId")
    @ManyToOne
    private Transaction transaction;

}
