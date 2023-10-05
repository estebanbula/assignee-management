package com.helpcenter.events.gateway;

import com.helpcenter.events.model.Event;

public interface IEventGateway {

    void emitEvent(Event event);
}
