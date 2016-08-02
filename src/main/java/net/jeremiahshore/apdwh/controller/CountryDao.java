package net.jeremiahshore.apdwh.controller;

import net.jeremiahshore.apdwh.model.Country;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by Jeremiah Shore at 8/1/2016 20:22 for analyze-with-hibernate.
 **/
public interface CountryDao {
    List<Country> findAll();
    Country findByCode(String code);

    void save(Country country);
    void update(Country country);
    void delete(Country country);
}
