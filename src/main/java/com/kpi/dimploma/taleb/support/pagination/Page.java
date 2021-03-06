package com.kpi.dimploma.taleb.support.pagination;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
public class Page<T> {
    @Getter @Setter
    private List<T> content;

    @Getter @Setter
    private int totalPages;
}
