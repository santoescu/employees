package co.com.cidenet.employees.api;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder(toBuilder = true)
public class Response {
    private String respuesta;

}
