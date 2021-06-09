package com.signette.domains;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Client", schema = "public", catalog = "SIGNETTE")
public class ClientEntity {
    private int clientId;
    private String clientWording;
    private String clientMail;
    private String clientPhone;
    private AdresseEntity adresseByClientFkAddressId;

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "CLIENT_SEQ")
    @SequenceGenerator(name = "CLIENT_SEQ", sequenceName = "CLIENT_SEQ", allocationSize = 1)
    @Column(name = "client_id", unique = true, nullable = false, precision = 22, scale = 0)
    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    @Basic
    @Column(name = "client_wording", nullable = false, length = 20)
    public String getClientWording() {
        return clientWording;
    }

    public void setClientWording(String clientWording) {
        this.clientWording = clientWording;
    }

    @Basic
    @Column(name = "client_mail", nullable = true, length = 30)
    public String getClientMail() {
        return clientMail;
    }

    public void setClientMail(String clientMail) {
        this.clientMail = clientMail;
    }

    @Basic
    @Column(name = "client_phone", nullable = true, length = 14)
    public String getClientPhone() {
        return clientPhone;
    }

    public void setClientPhone(String clientPhone) {
        this.clientPhone = clientPhone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClientEntity that = (ClientEntity) o;
        return clientId == that.clientId && Objects.equals(clientWording, that.clientWording) && Objects.equals(clientMail, that.clientMail) && Objects.equals(clientPhone, that.clientPhone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clientId, clientWording, clientMail, clientPhone);
    }

    @ManyToOne
    @JoinColumn(name = "client_fk_address_id", referencedColumnName = "address_id", nullable = false)
    public AdresseEntity getAdresseByClientFkAddressId() {
        return adresseByClientFkAddressId;
    }

    public void setAdresseByClientFkAddressId(AdresseEntity adresseByClientFkAddressId) {
        this.adresseByClientFkAddressId = adresseByClientFkAddressId;
    }
}
