package com.vehicleservice.repository;

import com.vehicleservice.model.Vehicle;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class VehicleRepository {

    private final ConcurrentHashMap<Long, Vehicle> store = new ConcurrentHashMap<>();
    private final AtomicLong idSequence = new AtomicLong(0);

    @PostConstruct
    public void seed() {
        Vehicle lisaMarie = new Vehicle();
        lisaMarie.setNickName("The Lisa Marie");
        lisaMarie.setVin("4M2DV11W4RDJ53329");
        lisaMarie.setMake("Mercury");
        lisaMarie.setModel("Villager");
        lisaMarie.setYear("1994");
        lisaMarie.setMiles(159864);
        save(lisaMarie);

        Vehicle dolly = new Vehicle();
        dolly.setNickName("Dolly");
        dolly.setVin("JN8AZ2KR1AT169594");
        dolly.setMake("Nissan");
        dolly.setModel("Cube");
        dolly.setYear("2010");
        dolly.setMiles(59000);
        save(dolly);
    }

    public List<Vehicle> findAll() {
        return new ArrayList<>(store.values());
    }

    public Optional<Vehicle> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    public Optional<Vehicle> findByVin(String vin) {
        if (vin == null) {
            return Optional.empty();
        }
        return store.values().stream()
                .filter(v -> vin.equals(v.getVin()))
                .findFirst();
    }

    public Vehicle save(Vehicle v) {
        if (v.getId() == null) {
            v.setId(idSequence.incrementAndGet());
        }
        store.put(v.getId(), v);
        return v;
    }

    public boolean deleteById(Long id) {
        return store.remove(id) != null;
    }

    public boolean existsById(Long id) {
        return store.containsKey(id);
    }
}
