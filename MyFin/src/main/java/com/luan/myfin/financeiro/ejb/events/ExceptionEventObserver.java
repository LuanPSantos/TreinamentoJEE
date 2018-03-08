
package com.luan.myfin.financeiro.ejb.events;

import javax.ejb.Stateless;
import javax.enterprise.event.Observes;

@Stateless
public class ExceptionEventObserver {
    
    public void listenToException(@Observes ExceptionEvent event){
        
        System.out.println("\nErro interno:");
        event.getException().printStackTrace();
        System.out.println();
    }
}
