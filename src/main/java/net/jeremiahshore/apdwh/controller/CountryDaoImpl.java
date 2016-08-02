package net.jeremiahshore.apdwh.controller;

import net.jeremiahshore.apdwh.model.Country;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * Created by Jeremiah Shore at 8/1/2016 20:28 for analyze-with-hibernate.
 **/
public class CountryDaoImpl implements CountryDao {
    private SessionFactory sessionFactory;

    public CountryDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    /**** DATA RETRIEVAL ****/
    @Override
    public List<Country> findAll() {
        Session session = sessionFactory.openSession();
        Criteria criteria = session.createCriteria(Country.class);
        List<Country> allCountries = criteria.list();
        session.close();
        return allCountries;
    }

    @Override
    public Country findByCode(String code) {
        Session session = sessionFactory.openSession();
        Criteria criteria = session.createCriteria(Country.class)
                .setMaxResults(1)
                .add(Restrictions.eq("code", code));
        return (Country) criteria.uniqueResult();
    }

    /**** DATA MANIPULATION ****/
    @Override
    public void save(Country country) {
        //TODO: test to see if a country can be added with a country code that already exists
        //TODO: if possible, control this in code, otherwise handle the SQL Exception
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(country);
        //the id from the line above does not need to be returned and assigned using country.setCode() because the
        //code (PK) is a unique String in real life, and it is required when creating a new country with CountryBuilder
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void update(Country country) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(country);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(Country country) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(country);
        session.getTransaction().commit();
        session.close();
    }

}
