package net.jeremiahshore.apdwh.model;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by Jeremiah on 8/1/2016.
 */
@Entity
public class Country {
    @Id private String code;
    @Column private String name;
    @Column private BigDecimal internetUsers;
    @Column private BigDecimal adultLiteracyRate;

    /**** CONSTRUCTOR ****/
    public Country() {}

    public Country(CountryBuilder countryBuilder) {
        this.code = countryBuilder.code;
        this.name = countryBuilder.name;
        this.internetUsers = countryBuilder.internetUsers;
        this.adultLiteracyRate = countryBuilder.adultLiteracyRate;
    }

    /**** BUILDER ****/
    public static class CountryBuilder {
        private String code;
        private String name;
        private BigDecimal internetUsers;
        private BigDecimal adultLiteracyRate;

        public CountryBuilder(String code, String name) {
            this.code = code;
            this.name = name;
        }

        public CountryBuilder withInternetUsers(BigDecimal internetUsers) {
            this.internetUsers = internetUsers;
            return this;
        }

        public CountryBuilder withAdultLiteracyRate(BigDecimal adultLiteracyRate) {
            this.adultLiteracyRate = adultLiteracyRate;
            return this;
        }

        public Country build() {
            return new Country(this);
        }
    }

    /**** GETTERS AND SETTERS ****/
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getInternetUsers() {
        return internetUsers;
    }

    public void setInternetUsers(BigDecimal internetUsers) {
        this.internetUsers = internetUsers;
    }

    public BigDecimal getAdultLiteracyRate() {
        return adultLiteracyRate;
    }

    public void setAdultLiteracyRate(BigDecimal adultLiteracyRate) {
        this.adultLiteracyRate = adultLiteracyRate;
    }

    /**** OVERRIDES ****/
    @Override
    public String toString() {
        return "Country{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", internetUsers=" + internetUsers +
                ", adultLiteracyRate=" + adultLiteracyRate +
                '}';
    }
}
