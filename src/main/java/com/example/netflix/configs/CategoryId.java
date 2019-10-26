package com.example.netflix.configs;

import com.example.netflix.models.Categories;
import org.hibernate.HibernateException;
import org.hibernate.MappingException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.Configurable;
import org.hibernate.id.IdentifierGenerator;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.type.Type;

import java.io.Serializable;
import java.util.Properties;
import java.util.stream.Stream;

public class CategoryId implements IdentifierGenerator, Configurable {
    private String prefix;

    @Override
    public void configure(Type type, Properties params, ServiceRegistry serviceRegistry) throws MappingException {

    }

    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
//        String query = String.format("select %s from %s",
//                session.getEntityPersister(Categories.getClass().get(), obj)
//                        .getIdentifierPropertyName(),
//                obj.getClass().getSimpleName());
//
//        Stream ids = session.createQuery(query).stream();


        return prefix;
    }
}
