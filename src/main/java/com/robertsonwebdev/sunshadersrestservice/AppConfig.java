package com.robertsonwebdev.sunshadersrestservice;

import org.springframework.context.annotation.Configuration;

import java.util.Optional;

@Configuration
public class AppConfig {

    public AppointmentRepository appointmentRepository(){
        return new AppointmentRepository() {
            @Override
            public <S extends Appointment> S save(S s) {
                return null;
            }

            @Override
            public <S extends Appointment> Iterable<S> saveAll(Iterable<S> iterable) {
                return null;
            }

            @Override
            public Optional<Appointment> findById(Long aLong) {
                return Optional.empty();
            }

            @Override
            public boolean existsById(Long aLong) {
                return false;
            }

            @Override
            public Iterable<Appointment> findAll() {
                return null;
            }

            @Override
            public Iterable<Appointment> findAllById(Iterable<Long> iterable) {
                return null;
            }

            @Override
            public long count() {
                return 0;
            }

            @Override
            public void deleteById(Long aLong) {

            }

            @Override
            public void delete(Appointment appointment) {

            }

            @Override
            public void deleteAll(Iterable<? extends Appointment> iterable) {

            }

            @Override
            public void deleteAll() {

            }
        };
    }
}
