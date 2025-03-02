package org.qy.panel.tools;

import io.fabric8.kubernetes.api.model.HasMetadata;

import java.util.List;

public interface KubernetesResource <T extends HasMetadata> {
    T create(T resource);
    T update(T resource);
    void delete(String name, String namespace);
    T get(String name, String namespace);
    List<T> list(String namespace);
}
