package org.smurfs.handler;

import java.util.List;

public interface Handler<T> {

    void handle(List<T> object);
}
