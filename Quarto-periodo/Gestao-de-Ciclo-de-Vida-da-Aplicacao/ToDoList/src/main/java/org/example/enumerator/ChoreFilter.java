package org.example.enumerator;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
public enum ChoreFilter {

    ALL(1L, "All Chores"),
    COMPLETED(2L, "Only completed Chores"),
    UNCOMPLETED(3L, "Only uncompleted Chores");

    private long identifier;
    private String description;
}
