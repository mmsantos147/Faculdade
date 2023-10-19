package org.example.repository;

import org.example.domain.Chore;

import java.util.List;

public interface ChoreRepository {

    List<Chore> load();
}
