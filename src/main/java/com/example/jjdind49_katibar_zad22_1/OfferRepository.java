package com.example.jjdind49_katibar_zad22_1;

import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Repository
public class OfferRepository {

    private final Set<Offer> offers = new HashSet<>();

    OfferRepository() {
        offers.add(new Offer("Budowa maszyn przemysłowych",
                "Wykonujemy kompleksowy proces budowy maszyn przemysłowych oraz linii produkcyjnych. " +
                        "Tworzymy konstrukcję urządzeń gniazdowych. Integrujemy również systemy nadrzędne SCADA.",
                "machine.jpg"));
        offers.add(new Offer("Automatyzacja produkcji",
                "Zajmujemy się automatyzacją maszyn, całych linii produkcyjnych w branży przemysłowej i przetwórczej. " +
                        "Przeprowadzamy modernizację układów sterowniczych.",
                "automatic.jpg"));
        offers.add(new Offer("System do planowania produkcji",
                "Przedstawiamy najlepszy system do planowania produkcji. Sporządzimy dokładny audyt, " +
                        "zajmiemy się wdrożeniem oraz przeszkoleniem pracowników.",
                "plan.jpg"));
        offers.add(new Offer("Prefabrykacja szaf sterowniczych",
                "Od wielu lat zajmujemy się prefabrykacją szaf sterowniczych, rozdzielnic elektrycznych, " +
                        "paneli operatorskich. Zapewniamy deklarację zgodności CE, gwarancję oraz serwisowanie.",
                "cabinet.jpg"));
    }

    Collection<Offer> findAll() {
        return offers;
    }
}