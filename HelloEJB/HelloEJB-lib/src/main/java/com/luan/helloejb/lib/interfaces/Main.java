package com.luan.helloejb.lib.interfaces;

import com.luan.helloejb.lib.models.Message;
import java.util.List;

public interface Main {

    public Message findMessage(String text);

    public List<Message> findAllMessage();
}
