package com.signette.domains;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Adresse", schema = "public", catalog = "SIGNETTE")
public class AdresseEntity {
    private int addressId;
    private Integer addressNumber;
    private String addressStreet;
    private String addressCity;
    private String addressCountry;

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "ADDRESS_SEQ")
    @SequenceGenerator(name = "ADDRESS_SEQ", sequenceName = "ADDRESS_SEQ", allocationSize = 1)
    @Column(name = "address_id", unique = true, nullable = false, precision = 22, scale = 0)
    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    @Basic
    @Column(name = "address_number", nullable = true)
    public Integer getAddressNumber() {
        return addressNumber;
    }

    public void setAddressNumber(Integer addressNumber) {
        this.addressNumber = addressNumber;
    }

    @Basic
    @Column(name = "address_street", nullable = true, length = 50)
    public String getAddressStreet() {
        return addressStreet;
    }

    public void setAddressStreet(String addressStreet) {
        this.addressStreet = addressStreet;
    }

    @Basic
    @Column(name = "address_city", nullable = true, length = 20)
    public String getAddressCity() {
        return addressCity;
    }

    public void setAddressCity(String addressCity) {
        this.addressCity = addressCity;
    }

    @Basic
    @Column(name = "address_country", nullable = true, length = 20)
    public String getAddressCountry() {
        return addressCountry;
    }

    public void setAddressCountry(String addressCountry) {
        this.addressCountry = addressCountry;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AdresseEntity that = (AdresseEntity) o;
        return addressId == that.addressId && Objects.equals(addressNumber, that.addressNumber) && Objects.equals(addressStreet, that.addressStreet) && Objects.equals(addressCity, that.addressCity) && Objects.equals(addressCountry, that.addressCountry);
    }

    @Override
    public int hashCode() {
        return Objects.hash(addressId, addressNumber, addressStreet, addressCity, addressCountry);
    }
}
