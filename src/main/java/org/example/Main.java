package org.example;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.example.entity.GiftCertificate;
import org.example.entity.Tag;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("psql");
        EntityManager manager = factory.createEntityManager();
        manager.getTransaction().begin();
        GiftCertificate cert = manager.find(GiftCertificate.class, 1L);
        Tag tag = manager.find(Tag.class, 1L);
        manager.getTransaction().commit();
        System.out.println(cert);
        System.out.println(tag);
    }
}