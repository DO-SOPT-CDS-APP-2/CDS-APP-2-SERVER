package org.sopt.cdsserver.product.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Brand {
    TYPE_SERVICE("타입서비스")
    ;
    private final String name;
}
