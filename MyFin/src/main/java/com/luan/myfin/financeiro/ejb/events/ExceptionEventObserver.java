
package com.luan.myfin.financeiro.ejb.events;

import java.io.IOException;
import javax.enterprise.event.Observes;

public class ExceptionEventObserver {
    
    
    public void listenToException(@Observes ExceptionEvent event) throws IOException{
        
        System.out.println(event.getException());
    }
}
