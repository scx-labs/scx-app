package dev.scx.app._old.config.source;

import dev.scx.app._old.config.ScxConfigSource;
import dev.scx.node.ObjectNode;

import java.util.function.BiConsumer;

/// AbstractConfigSource
///
/// @author scx567888
/// @version 0.0.1
public abstract class AbstractConfigSource implements ScxConfigSource {

    protected ObjectNode configMapping;
    private BiConsumer<ObjectNode, ObjectNode> changeHandler;

    @Override
    public void onChange(BiConsumer<ObjectNode, ObjectNode> changeHandler) {
        this.changeHandler = changeHandler;
    }

    public void callOnChange(ObjectNode oldValue, ObjectNode newValue) {
        if (changeHandler != null) {
            this.changeHandler.accept(oldValue, newValue);
        }
    }

    @Override
    public ObjectNode configMapping() {
        return configMapping;
    }

}
